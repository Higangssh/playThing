# Use the official OpenJDK 17 as a parent image
FROM openjdk:17-jdk

WORKDIR /app
# 빌드된 JAR 파일을 컨테이너에 복사
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar

# 컨테이너 내의 볼륨 마운트 지점 설정
VOLUME /tmp

# 컨테이너 내에서 사용할 포트 지정
EXPOSE 9000

# Spring Boot 프로파일을 활성화하는 환경 변수 설정
ENV SPRING_PROFILES_ACTIVE=dbProd

# 애플리케이션을 실행하기 위한 명령어 설정
ENTRYPOINT ["java","-jar","app.jar"]