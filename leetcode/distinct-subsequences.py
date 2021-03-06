#!/usr/bin/env python
# coding:utf-8
# Copyright (C) dirlt

class Solution(object):
    def numDistinct(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: int
        """

        n = len(s) + 1
        m = len(t) + 1
        st = []
        for i in range(n):
            st.append([1] + [0] * (m - 1))


        for i in range(1, n):
            for j in range(1, m):
                # st[i][j] involves with s[i-1][ and t[j-1]
                st[i][j] = st[i-1][j]
                if s[i-1] == t[j-1]:
                    st[i][j] += st[i-1][j-1]

        # for i in range(n):
        #     print st[i]
        return st[n-1][m-1]

if __name__ == '__main__':
    s = Solution()
    print s.numDistinct('rabbbit', 'rabbit')
    print s.numDistinct('ccc', 'c')
