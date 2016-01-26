#!/usr/bin/env python
# coding:utf-8
# Copyright (C) dirlt

from config import *

from pymongo import MongoClient
import pymongo
import requests


class Document(object):

    """Mongo Document"""

    @classmethod
    def from_json(cls, js):
        x = cls()
        x.__dict__ = js
        return x

    def to_json(self):
        return self.__dict__

Client = MongoClient(MONGO_URL)
DB = Client.pdcast
TCache = DB['cache']
# itunes playlist
TPlaylist = DB['playlist']
TPodcast = DB['feed']
TWeight = DB['weight']
TTopList = DB['toplist']

import redis
RedisClient = redis.StrictRedis(host=REDIS_URL[0],
                                port=REDIS_URL[1],
                                db=REDIS_URL[2])

# requests settings.
from requests.adapters import HTTPAdapter
Session = requests.Session()
Session.mount('http://', HTTPAdapter(max_retries=MAX_RETRY_NUMBER))
Session.mount('https://', HTTPAdapter(max_retries=MAX_RETRY_NUMBER))

TCache.create_index('key')
TCache.create_index('tag')

TPlaylist.create_index('pid')
TPlaylist.create_index('country')
TPlaylist.create_index('genres')

TPodcast.create_index('key')
TPodcast.create_index('itunes_id')
TPodcast.create_index('country')
TPodcast.create_index('genres')
TPodcast.create_index('language')

TWeight.create_index('key')
TTopList.create_index('key')

import json as json_lib

with open('genres.json') as fh:
    GENRES_MAPPING = json_lib.load(fh)
with open('genres_all.json') as fh:
    GENRES_ALL_MAPPING = json_lib.load(fh)

import hashlib


def get_feed_key(feedUrl):
    return hashlib.sha1(feedUrl).hexdigest()
