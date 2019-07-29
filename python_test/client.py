
import requests

URL = "http://127.0.0.1:8080"
files = {
    "user": (None,"test_user"),
    "password": (None, "hoge"),
    "hoge": open("./client.py", "r")
}

r = requests.post(URL, files=files)
print(r.text)
print(eval(r.text)["hoge"])
