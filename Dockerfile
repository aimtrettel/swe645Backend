# Alpine Linux with OpenJDK JRE
FROM openjdk:8-jre-alpine

# Copy war file
COPY Backend.war /echo.war

# run the app
CMD ["/usr/bin/java", "-jar", "/echo.war"]