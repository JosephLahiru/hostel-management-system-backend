FROM openjdk:21
EXPOSE 8080
WORKDIR project
ADD ./target/hostel-management-system-backend-0.0.1-SNAPSHOT.jar /project
ENTRYPOINT ["java", "-jar", "hostel-management-system-backend-0.0.1-SNAPSHOT.jar", "--type='local'"]