# -*- coding: utf-8 -*-
'''
Created on 2014年3月16日

@author: aadebuger
'''
import socket
import sys
def   udpevent(ip,str):
    UDP_PORT =10001 
    print "UDP target IP:", ip
    print "UDP target port:", UDP_PORT
    print "message:", str
    sock = socket.socket(socket.AF_INET,socket.SOCK_DGRAM)
    sock.sendto(str, (ip, UDP_PORT))
    
if __name__ == '__main__':
    pass