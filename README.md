
# Microservice-Test
It's a microservice-test app  developed by me in order to practice the use of base microservice communication with rabbitmq in Spring boot.    
Used:  
RabbitMQ;     
Spring MVC;  
Spring Data JPA;  
Spring Security(jwt);  
Spring Cloud Gateway;  
Postgresql;       

API allowes:      
to signup and login;  
to search for club and league;    

# Example:
```http
http://localhost:8888/api/v1/signup(have to set userName and password
{
    "userName":"",
    "password":""
})

http://localhost:8888/api/v1/login(have to set userName and password
{
    "userName":"",
    "password":""
})
if you want to use these api first signup,login
and token will be received.With this token(header Authorization:token)
you can access these api's. 
http://localhost:8888/api/v2/leagues/premier league/clubs/manchester united
http://localhost:8888/api/v2/leagues/premier league/clubs/
http://localhost:8888/api/v3/clubs/most-viewed
```
## Configuration

```http
  You have to configure 
  spring.datasource.driver-class-name
  spring.datasource.url
  spring.datasource.username
  spring.datasource.password 
  inside application.properties files (except spring-cloud-gateway-service).
  For data
  insert into league(id,league_name,country) 
  values(1,'premier league','england')
  
  insert into clubs(id,arena,city,club_name,country_name,league)
  values(1,'anfield','liverpool','liverpool','england','premier league')
  values(2,'old trafford','manchester','manchester united','england','premier league')
  
  insert into managers (id,club_name,manager_name,nationality)
  values(1,'liverpool','klopp','germany')
  values(2,'manchester united','ralf','germany')

  insert into board  (id,club_name ,executor_name,title) 
  values(1,'liverpool','John Henry','Principal Owner')
  values(2,'manchester united','Joel Glazer','Executive Co-Chairman and Director')
```
