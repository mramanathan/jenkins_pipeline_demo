#!/bin/bash

echo "Dumping environment vars and values..."
printenv

if [[ "$vmharbor" = "YES" ]]
then
   echo "make changes to /etc/default/docker"
else
   echo "make no changes to /etc/default/docker"
fi
