from flask import Flask, request, jsonify
from flask_cors import CORS


app = Flask(__name__)
CORS(app)


@app.route("/api/1.0/login/", methods=["POST"])
def login():
    if request.method == "POST":
        ## email: test@test.com
        ## password: hogehoge
        json = request.get_json()
        if json["email"] == "test@test.com" and json["password"] == "hogehoge":
            return jsonify({"token":"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoyLCJ1c2VybmFtZSI6ImhvZ2UxQGdtYWlsLmNvbSIsImV4cCI6MTU1NjgxNTEwOSwiZW1haWwiOiJob2dlMUBnbWFpbC5jb20ifQ.U380KxwByhqarCADS7fsuZQA6ZVGcMOGSY3k_LADcTI"})


@app.route("/api/1.0/register/", methods=["POST"])
def register():
    if request.method == "POST":
        json = request.get_json()
        if json.get("email") and json.get("username") and json.get("password"):
            return jsonify({"id": 1,"username": "hoge","email": "hoge@hoge.com"}), 201


@app.route("/api/1.0/contests/", methods=["GET", "POST"])
def contests():
    if request.method == "GET":
        return jsonify({"count":2,"next":None,"previous":None,"results":[{"id":1,"isOpen":False,"isActive":False,"title":"Test Contest 01","tag":"TC1","startDate":"2019-05-08","contestTime":100,"writer":"ucpr","topPage":"Hello World!"},{"id":2,"isOpen":False,"isActive":False,"title":"Test Contest 02","tag":"TC2","startDate":"2019-05-08","contestTime":100,"writer":"ucpr","topPage":"hoge"}]})


@app.route("/api/1.0/contests/<name>/", methods=["GET"])
def contest_detail(name):
    return jsonify(
        {"count":1,"next":None,"previous":None,"results":[
            {"id":1,"isOpen":False,"isActive":False,"title":"Test Contest 01","tag":"TC1","startDate":"2019-05-08","contestTime":100,"writer":"ucpr","topPage":"Hello World!"}]
            }
        )


if __name__ == "__main__":
    app.run(port=8000)

