## NOTE BELOW:
## CONFIRM ARTIFACT NAME
## MUST NOT CHANGE IMAGES
## 
## DOCKERFILE must reside in project root, i.e. rss-evaluation-service/Evaluation/Dockerfile
### Employ the builder pattern
FROM maven:3.6.1-jdk-8 as builder
### Provide Default Argument
WORKDIR /usr/src/app 
COPY ./target . 
## Use only a JRE to run application
FROM gcr.io/distroless/java:8
# FROM openjdk:7
## Copy Artifact from maven image
COPY --from=builder /usr/src/app/rss-cart-0.0.1-SNAPSHOT.jar /app/app.jar 
WORKDIR /app 

EXPOSE 9999

ENTRYPOINT ["java", "-jar", "app.jar"]
