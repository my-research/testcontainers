FROM adoptopenjdk/openjdk11

WORKDIR /wonit
COPY todo-application/build/libs/todo-application-0.0.1.jar ./app/boot.jar

ENTRYPOINT exec java ${JAVA_OPTS} -jar /wonit/app/boot.jar
