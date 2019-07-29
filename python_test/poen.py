import responder

api = responder.API()

@api.route("/")
async def hoge(req, resp):
    data = await req.media()
    resp.media = data
    print("*******************************")
    print(data)
    print(req.headers)
    print(await req.content)
    print(await req.text)

if __name__ == "__main__":
    api.run(port=8080)
