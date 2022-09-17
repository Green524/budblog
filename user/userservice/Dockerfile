FROM openjdk:17-alpine
MAINTAINER chenum
RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

RUN mkdir -p /userservice

COPY userservice/target/userservice-0.0.5.jar /userservice/app.jar
WORKDIR /userservice

EXPOSE 8843

CMD java -Dfile.encoding=UTF8  -Duser.timezone=GMT+08 -Djava.security.egd=file:/dev/./urandom -jar app.jar --spring.profiles.active=prod