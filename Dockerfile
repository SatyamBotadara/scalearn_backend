FROM amazoncorretto:17 as build
WORKDIR /scalearn
# copy pom xml and install dependency
RUN yum install -y tar gzip
COPY ./pom.xml .
COPY ./mvnw .
COPY ./.mvn ./.mvn
RUN ./mvnw dependency:go-offline
# create java artifacts
COPY . .
RUN ./mvnw clean install

FROM amazoncorretto:17
WORKDIR /scalearn
COPY --from=build /scalearn/target/this-is-scalearn-project-0.0.1-SNAPSHOT.jar ./scalearn.jar
ENTRYPOINT [ "java","-jar","scalearn.jar" ]

