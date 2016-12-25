#!/bin/sh

set -o -x errexit

pyinfo=`dpkg-query -s python`
echo ${pyinfo}
