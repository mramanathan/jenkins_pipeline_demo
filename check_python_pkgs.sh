#!/bin/bash

## apt list --installed : Returns warnings about aptitude
## apt-mark showmanual : displays the name of packages only
## dpkg -l : Returns oneline note on each installed pkg
python_pkgs=`dpkg --get-selections | grep -i python

echo "Python packages installed..."
echo ${python_pkgs}

