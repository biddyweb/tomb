#!/usr/bin/env python
#coding:utf-8
#Copyright (C) dirlt

import urllib2
import re
import os
import json
import string
import threading
import re
import pymongo

import requests
from bs4 import BeautifulSoup
import hashlib

STATION_ID = 600261907

mongo_client = pymongo.MongoClient()
mongo_db = mongo_client.rr_image
cache_table = mongo_db['cache_%d' % STATION_ID]

CACHE_DIR = 'cache-%d/' % (STATION_ID)
if not os.path.exists(CACHE_DIR):
    os.makedirs(CACHE_DIR)

OUTPUT_DIR = 'output-%d/' % (STATION_ID)
if not os.path.exists(OUTPUT_DIR):
    os.makedirs(OUTPUT_DIR)

def get_url(url, ss = None):
    if not ss:
        ss = requests.session()
    key = hashlib.md5(url).hexdigest()
    r = cache_table.find_one({'_id': key})
    if r: return r['data']
    print('get url %s' % url)
    r = ss.get(url)
    data = r.content
    cache_table.insert({'_id': key, 'data': data})
    return data

def get_album_urls():
    cache = CACHE_DIR + 'album.urls.txt'
    if not os.path.exists(cache):
        ss = requests.session()
        urls = []
        init_url = 'http://page.renren.com/%d/album' % STATION_ID

        def f(url, init = False):
            data = get_url(url, ss)
            bs = BeautifulSoup(data)
            xs = bs.select('#tabBody > div > div > div > table > tbody > tr > td > div > a')
            for x in xs:
                path = x.attrs['href']
                urls.append('http://page.renren.com' + path)
            if init:
                xs = bs.select('#tabBody > div > div > div > ol > li > a')
                last_page = int(xs[-1].attrs['href'].split('=')[-1])
                return last_page

        last_page = f(init_url, True)
        for x in range(1, last_page + 1):
            url = init_url + '?curpage=%d' % x
            f(url)

        with open(cache, 'w') as fh:
            fh.writelines(map(lambda x: x + '\n', urls))
        return urls

    with open(cache) as fh:
        return [x.strip() for x in fh]

def get_image_urls(album_url):
    album_id = album_url.split('/')[-1]
    cache = CACHE_DIR + 'album.urls.%s.txt' % album_id
    if os.path.exists(cache):
        with open(cache) as fh:
            return [x.strip() for x in fh]

    curpage = 0
    ss = requests.session()
    images = []
    while True:
        url = album_url + '?curpage=%d' % curpage
        data = get_url(url, ss)
        bs = BeautifulSoup(data)
        xs = bs.select('#single-column > table > tbody > tr > td > a')
        for x in xs:
            images.append('http://page.renren.com' + x.attrs['href'])
        # 最后一页
        xs = bs.select('#content > div.pager-top > ol > li > a')
        if not xs or 'class' not in xs[-1].attrs:
            break
        curpage += 1

    with open(cache, 'w') as fh:
        fh.writelines(map(lambda x: x + '\n', images))
    return images

DOWNLOAD_URL_RE = re.compile(r'"large":"([^"]+)"')

def get_data_urls(image_urls):
    urls = []
    ss = requests.session()
    for x in image_urls:
        data = get_url(x, ss)
        m = re.search(DOWNLOAD_URL_RE, data)
        if not m: continue
        urls.append(m.groups()[0])
    return urls

def download_pics(data_urls):
    ss = requests.session()
    for x in data_urls:
        file_name = x.split('/')[-1]
        file_path = os.path.join(OUTPUT_DIR, file_name)
        if os.path.exists(file_path): continue
        r = ss.get(x)
        print('download pic %s' % x)
        with open(file_path, 'wb') as fh:
            fh.write(r.text)

if __name__ == '__main__':
    urls = get_album_urls()

    imgs = []
    for url in urls:
        images = get_image_urls(url)
        imgs.extend(images)
    with open(CACHE_DIR + 'rr_image.urls.txt', 'w') as fh:
        fh.writelines(map(lambda x: x + '\n', imgs))

    urls = get_data_urls(imgs)
    with open(CACHE_DIR + 'rr_data.urls.txt', 'w') as fh:
        fh.writelines(map(lambda x: x + '\n', urls))

    download_pics(urls)
