 # Api Documentation 

## Prerequisites
1. Maven 3.9.4
2. Postgresql 15.4
3. Java 17
4. Spring Boot 3.1.3
5. Docker Desktop

## Setup
After you've downloaded this project locally and installed the required software you can build the API and place it in a docker container by following this process:
1. Set up a local `match_db` (or equivalent) postgres DB and update the `application.properties` file with the correct connection details
2. CD into the project's directory
2. ```mvn clean compile assembly:single```
2. ```docker build -t sports_match_api_demo-0.0.1-jar-with-dependencies .``` (this will create the docker image)
3. ```docker run -p 8080:8080 sports_match_api_demo-0.0.1-jar-with-dependencies``` (this will place the image in a docker container and run it)
4. If all goes well the API should be reachable on http://localhost:8080/api/

## API Endpoints
The following endpoints are available:

| URL                    | Request Type | Description                                  | JSON Format                                                                                                                                        |
|------------------------|--------------|----------------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------|
| /createMatch           | POST         | Creates a new match entry                    | {<br/>"description":"test",<br/>"match_date":"12/12/2023",<br/>"match_time":"12:00",<br/>"team_a":"OSFP",<br/>"team_b":"PAO",<br/>"sport":1<br/>}  |
| /createMatchOdds       | POST         | Creates a new match odds entry               | {<br/>"match_id":1,<br/>"specifier":"X",<br/>"odd":1.5<br/>}                                                                                       |
| /getAllMatches         | GET          | Gets a list of all matches                   | N/A                                                                                                                                                |
| /getAllMatchOdds       | GET          | Gets a list of all match Odds                | N/A                                                                                                                                                |
| /getMatchById/{id}     | GET          | Gets a specific match using its ID           | N/A                                                                                                                                                |
| /getMatchOddsById/{id} | GET          | Gets a specific match odds item using its ID | N/A                                                                                                                                                |
| /updateMatch/{id}      | PUT          | Updates a specific match using its ID        | {<br/>"description":"test2",<br/>"match_date":"12/12/2023",<br/>"match_time":"12:00",<br/>"team_a":"OSFP",<br/>"team_b":"PAO",<br/>"sport":0<br/>} |
| /updateMatchOdds/{id}  | PUT          | Updates a specific match odds using its ID   | {<br/>"match_id":1,<br/>"specifier":"X",<br/>"odd":2<br/>}                                                                                         |
| /deleteAllMatches      | DELETE       | Deletes all match items                      | N/A                                                                                                                                                |
| /deleteAllMatchOdds    | DELETE       | Deletes all match odds items                 | N/A                                                                                                                                                |
| /deleteMatch/{id}      | DELETE       | Deletes a specific match using its ID        | N/A                                                                                                                                                |
| /deleteMatchOdds/{id}  | DELETE       | Deletes a specific match odds using its ID   | N/A                                                                                                                                                |

## Current Issues
I encountered a variety of issues / bugs while setting up and creating this project, which I resolved, but unfortunately there's one which still persists and is preventing the API from starting (on docker and on a local server):
```
org.springframework.beans.factory.UnsatisfiedDependencyException:
Error creating bean with name 'matchOddsService': Unsatisfied dependency expressed through field 'matchOddsRepository': Error creating bean with name 'matchOddsRepository' defined in Repositories.MatchOddsRepository defined in @EnableJpaRepositories declared on APIController: Cannot resolve reference to bean 'jpaSharedEM_entityManagerFactory' while setting bean property 'entityManager'
```

I'm still investigating the above issue but it's worth mentioning in case you encounter it as well.
