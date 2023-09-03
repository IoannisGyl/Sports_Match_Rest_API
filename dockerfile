FROM openjdk:17-oracle
ADD target/football_match_api_demo-0.0.1-jar-with-dependencies.jar football_match_api_demo-0.0.1-jar-with-dependencies.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "football_match_api_demo-0.0.1-jar-with-dependencies.jar"]