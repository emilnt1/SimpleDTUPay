FROM adoptopenjdk:11-jre-hotspot
CMD mvn package
WORKDIR /usr/src
COPY target/quarkus-app /usr/src/quarkus-app
CMD java -Xmx64m \
-jar quarkus-app/quarkus-run.jar