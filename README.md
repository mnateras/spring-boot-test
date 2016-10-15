Prerequisites:

    Java min 1.8
    Maven 3


Build and execute as follows:

	$ mvn clean package exec:java


Properties (application.properties)

	maze.server.host=http://localhost:8080


Technical decisions:

- This project includes spring-boot, jackson-databind, and guava libraries. This allows the implemented Java code to be simple and neat.

- The required Brain & Runner threads have been implemented using the @EnableAsync @Async annotations and the @Bean ThreadPoolTaskExecutor.

- java.util.concurrent.Future will control the 2 seconds required by the Runner to process a move operation.

- Logback logging library will provide the required console & file logs.