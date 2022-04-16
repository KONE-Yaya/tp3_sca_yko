#Stage 1
FROM maven:3.6.3-adoptopenjdk-11 as stage1
RUN addgroup --system --gid 1001 groupebackend && adduser --system --home /home/backend --uid 1001 --gid 1001 backend
RUN mkdir /backend && chown -R backend:groupebackend /backend
USER backend
WORKDIR /backend
COPY pom.xml .
COPY ./src ./src
COPY ./logs ./logs
RUN mvn clean install -Dmaven.test.skip=true

#Stage 2
FROM adoptopenjdk/openjdk11:jre-11.0.9_11-alpine
WORKDIR /backend
LABEL app_name="Backend"
LABEL app_description="Backend application called Frontend"
LABEL app_version="1.0.0"
COPY --from=stage1 /backend/target/backend.jar /backend
CMD ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/backend/backend.jar"]