#!/bin/sh

OP=$1

case "$OP" in
    "-c")
        touch $2
        echo "Create file named $2"
    ;;
    "-d")
        rm $2
        echo "delete $2"
    ;;
    "-w")
        echo $3 >> $2
        echo "add"
    ;;
    "-r")
        cat $2
    ;;
    "-l")
        ls
    ;;
esac
    
