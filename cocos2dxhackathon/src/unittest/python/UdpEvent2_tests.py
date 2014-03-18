# -*- coding: utf-8 -*-
'''
Created on 2014年3月16日

@author: aadebuger
'''
import unittest
import time
import cocos2dx.UdpEvent
class Test(unittest.TestCase):


    def testName(self):
        cocos2dx.UdpEvent.udpevent("172.16.1.194", "touchbegin,442.0,302.0,1005")
        time.sleep(5)
        cocos2dx.UdpEvent.udpevent("172.16.1.194", "touchmoved,422.0,301.0,1005")
        time.sleep(5)


        cocos2dx.UdpEvent.udpevent("172.16.1.194", "touchend,422.0,301.0,1005")
  

if __name__ == "__main__":
    #import sys;sys.argv = ['', 'Test.testName']
    unittest.main()