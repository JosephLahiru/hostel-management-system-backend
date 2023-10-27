FROM openjdk:19
EXPOSE 8080
WORKDIR /app
COPY ./target/hostel-management-system-backend-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar", "--type=local"]