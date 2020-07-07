# Tokenlab Challenge - Management of events (Backend)

A simple project to management of events

> Project phase: Development :warning:

## Index

* [Setup](#Setup)

## Setup
### Requirements

* Installed:   
[git](https://www.digitalocean.com/community/tutorials/how-to-contribute-to-open-source-getting-started-with-git)   
[Docker](https://www.docker.com/)

* Optional:   
[Docker-Compose](https://docs.docker.com/compose/install/)   
[Java 11](https://www.oracle.com/technetwork/java/javase/overview/index.html)   
[Maven 3.x](https://maven.apache.org/install.html)

### Run Application

##### Clone source code from git
```
$  git clone https://github.com/viniciuslsilva/tokenlab-challenge.git .
```

##### Build Docker image
```
$ docker build -t="tokenlab-challenge" .
```
Maven build will be executes during creation of the docker image.

>Note:if you run this command for first time it will take some time in order to download base image from [DockerHub](https://hub.docker.com/)

##### Run Docker Container
```
$ docker run -p 8080:8080 -it --rm tokenlab-challenge
```

#####  Stop Docker Container:
```
docker stop `docker container ls | grep "tokenlab-challenge:*" | awk '{ print $1 }'`
```

##### Run with docker-compose 

Build and start the container by running 

```
$ docker-compose up -d 
```

##### Stop Docker Container:
```
docker-compose down
```

**[⬆ Back to Index](#index)**
