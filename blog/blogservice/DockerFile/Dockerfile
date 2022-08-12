FROM openjdk:17
MAINTAINER cpq
ARG jarfile
RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

RUN mkdir -p /blogservice
COPY $jarfile /abcscanpaymentprovider/app.jar
WORKDIR /blogservice

EXPOSE 8842

CMD java -Dfile.encoding=UTF8  -Duser.timezone=GMT+08 -Djava.security.egd=file:/dev/./urandom -jar app.jar
