#!/bin/bash

## apt list --installed : Returns warnings about aptitude
## apt-mark showmanual : displays the name of packages only
## dpkg -l : Returns oneline note on each installed pkg
<<<<<<< HEAD
python_pkgs=`dpkg --get-selections | grep -i python`
=======
python_pkgs=`dpkg --get-selections | grep -i python
>>>>>>> 567bfae4bea42191e72fdb591078206ebe79d2a9

echo "Python packages installed..."
echo ${python_pkgs}

