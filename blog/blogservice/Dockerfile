FROM openjdk:17-alpine
MAINTAINER chenum
RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

RUN mkdir -p /blogservice

COPY blogservice/target/blogservice-0.0.10.jar /blogservice/app.jar
WORKDIR /blogservice

EXPOSE 8842

CMD java -Dfile.encoding=UTF8  -Duser.timezone=GMT+08 -Djava.security.egd=file:/dev/./urandom -jar app.jar --spring.profiles.active=prod