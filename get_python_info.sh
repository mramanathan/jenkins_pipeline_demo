#!/bin/sh

set +x

pyinfo=`dpkg-query -s python`
echo "Python pkginfo follows..."
echo ${pyinfo}
