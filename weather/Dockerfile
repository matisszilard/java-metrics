FROM gradle:8.5.0-jdk17

WORKDIR /app/
COPY ./build/libs/*.jar app.jar
ENV JAVA_TOOL_OPTIONS -Dfile.encoding=UTF8 -Djava.security.egd=file:/dev/./urandom
ENV JAVA_OPTS=""

CMD ["sh", "-c", "java $JAVA_OPTS $JAVA_TOOL_OPTIONS -jar app.jar"]
