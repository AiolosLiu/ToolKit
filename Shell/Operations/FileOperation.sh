#!/bin/sh

#-eq  #Is equal
#-ne  #Is not equal
#-lt  #Less than
#-le  #Less than or equal
#-gt  #Greater than
#-ge  #Greater than or equal

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
    
