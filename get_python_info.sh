#!/bin/sh

set +x

pyinfo=`dpkg-query -s python`
echo "Python info follows: "
echo ${pyinfo}
