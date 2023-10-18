FROM openjdk:17
ARG JAR_FILE=target/TOPEDUCATION-ARITZ.jar
COPY ${JAR_FILE} TOPEDUCATION-ARITZ.jar
EXPOSE 8090
ENTRYPOINT ["java","-jar","/TOPEDUCATION-ARITZ.jar"]