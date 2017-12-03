#!/usr/bin/python3
import urllib.request
import json
postData = urllib.request.urlopen("https://jsonplaceholder.typicode.com/posts")
#getJson  = json.dumps(str(postData.read()))
#print(getJson)
#print(postData.read().decode('utf-8'))
getJson  = json.loads(postData.read().decode('utf-8'))
print(getJson)
print(getJson[0]['userId'])
