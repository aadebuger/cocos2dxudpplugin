# -*- coding: utf-8 -*-
'''
Created on 2014年3月16日

@author: aadebuger
'''
import unittest
import thread
import time
import cocos2dx.UdpEvent
class Test(unittest.TestCase):


    def testName(self):
        cocos2dx.UdpEvent.udpevent("172.16.1.194", "touchbegin,422.0,302.0,1004")
        time.sleep(5)
        cocos2dx.UdpEvent.udpevent("172.16.1.194", "touchmoved,442.0,301.0,1004")
        time.sleep(5)


        cocos2dx.UdpEvent.udpevent("172.16.1.194", "touchend,482.0,301.0,1004")
        

if __name__ == "__main__":
    #import sys;sys.argv = ['', 'Test.testName']
    unittest.main()