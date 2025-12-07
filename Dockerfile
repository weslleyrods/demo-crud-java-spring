FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY . .
RUN ./mvnw clean install -DskipTests
RUN mv target/*.jar target/app.jar
CMD ["java", "-jar", "target/app.jar"]