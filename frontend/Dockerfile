#Stage 1
FROM maven:3.6.3-adoptopenjdk-11 as stage1
RUN addgroup --system --gid 1001 groupefrontend && adduser --system --home /home/frontend --uid 1001 --gid 1001 frontend
RUN mkdir /frontend && chown -R frontend:groupefrontend /frontend
USER frontend
WORKDIR /frontend
COPY pom.xml .
COPY ./src ./src
RUN mvn clean install -Dmaven.test.skip=true

#Stage 2
FROM adoptopenjdk/openjdk11:jre-11.0.9_11-alpine
WORKDIR /frontend
LABEL app_name="Frontend"
LABEL app_description="Frontend application calling Backend"
LABEL app_version="1.0.0"
COPY --from=stage1 /frontend/target/frontend.jar /frontend
CMD ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/frontend/frontend.jar"]

