#!/usr/bin/python3

import os
import sys

class FileOperations:

# ‘r’ – Read mode which is used when the file is only being read 
#‘w’ – Write mode which is used to edit and write new information to the file (any existing files with the same name will be erased when this mode is activated) 
#‘a’ – Appending mode, which is used to add new data to the end of the file; that is new information is automatically amended to the end 
#‘r+’ – Special read and write mode, which is used to handle both actions when working with a file 
    
    def __init__(self):
        pass
        
    def help(self):
        pass

    def listDictionary(self):
        os.system('ls -a')

    def writeFile(self, filName, operation):
        f = open(fileName, operation)
        inputS = input("Please input the content, end with exit()\n")
        ArrStr = []
        while inputS != "exit()":
            ArrStr.append(inputS)
            inputS = input()
        for ele in ArrStr:
            f.write(ele + '\n')
        f.close()

    def createFile(self, fileName):
        self.writeFile(fileName, 'w')

    def readFile(self, fileName):
        f = open(fileName, 'r')
        
        for line in f:
            print(line)
        f.close()
    def deleteFile(self, fileName):
        os.remove(fileName)

if __name__ == "__main__":
    
    op       = str(sys.argv[1])
    fo       = FileOperations()
    if op =="-l":
        fo.listDictionary()
    else:
        fileName = str(sys.argv[2])
        if op == "-c":
            fo.createFile(fileName)
        elif op == "-w":
            fo.writeFile(fileName, 'a')
        elif op == "-r":
            fo.readFile(fileName)
        elif op == "-d":
            fo.deleteFile(fileName)
        
