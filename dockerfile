FROM openjdk:17-oracle
ADD target/sports_match_api_demo-0.0.1-jar-with-dependencies.jar sports_match_api_demo-0.0.1-jar-with-dependencies.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "sports_match_api_demo-0.0.1-jar-with-dependencies.jar"]