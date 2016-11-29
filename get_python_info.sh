#!/bin/sh

set +x

pyinfo=`dpkg-query -s python`
echo ${pyinfo}
