#!/usr/bin/python3
import urllib.request
import json
postData = urllib.request.urlopen("https://jsonplaceholder.typicode.com/posts")

#json.dumps() json -> str
#json.loads() str  -> json 

#print(getJson)
#print(postData.read().decode('utf-8'))
getJson  = json.loads(postData.read().decode('utf-8'))
print(getJson)
print(getJson[0]['userId'])
