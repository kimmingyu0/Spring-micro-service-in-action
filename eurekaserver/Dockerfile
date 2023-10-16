# stage 1
# Start with a base image containing Java runtime
FROM openjdk:17-slim as build

# Add Maintainer Info
LABEL maintainer="Illary kmg <minku4820@gmail.com>"

# The application's jar file
ARG JAR_FILE=target/eurekaserver-0.0.1-SNAPSHOT.jar

# Add the application's jar to the container
COPY ${JAR_FILE} app.jar

# unpackage jar file
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf /app.jar)

# stage 2
# Same Java runtime
FROM openjdk:17-slim

# Add volume pointing to /tmp
VOLUME /tmp

# Copy unpackaged application to new container
ARG DEPENDENCY=/target/dependency
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app

# execute the application ➍
ENTRYPOINT ["java","-cp","app:app/lib/*","com.optimagrowth.eureka.EurekaserverApplication"]

# 레이어로 나뉜 Jar를 위한 DockerFile 만들기
#FROM openjdk:17-slim as build
#WORKDIR application
#ARG JAR_FILE=target/*.jar
#COPY ${JAR_FILE} application.jar
#RUN java -Djarmode=layertools -jar application.jar extract

#FROM openjdk:17-slim
#WORKDIR application

#COPY --from=build application/dependencies/ ./
#COPY --from=build application/spring-boot-loader/ ./
#COPY --from=build application/snapshot-dependencies/ ./
#COPY --from=build application/application/ ./
#ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]
