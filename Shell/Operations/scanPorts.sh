#!/bin/bash

netstat | awk '{print $7}' > tmp.txt

#need="27212"
#for port in $(grep '[0-9]' $p_array)
#do
#    echo port
##    if $port == "34";then 
##        echo "find"
##    fi  
#done

for line in $(cat tmp.txt)
do
#    echo $line
    if [ $line = "27212" ];
    then
        echo "find"
    fi
done
