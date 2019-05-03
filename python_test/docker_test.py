import docker

client = docker.from_env()

container = client.containers.run(
        "alpine",
        detach=True
    )
print(container.status)

print(container.exec_run("echo hoge"))
