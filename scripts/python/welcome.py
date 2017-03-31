#!/usr/bin/env python

import sys

if ( len(sys.argv[1:]) != 0 ):
    user = sys.argv[1:]
    name = user[0]
    print("Hello {}, Welcome to the world of conundrums !!!.".format(name))
else:
    print("No warm welcome but cold reception!!!")
