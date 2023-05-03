# Exchange rate web-app

## Summary:
Web application that loads data(exchange rates) from a third-party service
into an internal PostgresQL database. Implemented API requests operate on
a local database (i.e. retrieve data from a database). API contain two methods:
1. Request for a list of exchange rates for all sources, with average market rates.
2. Request to issue a list of average exchange rates for all sources for the period.

## Used public API:
1. https://api.monobank.ua/docs/ 
2. https://minfin.com.ua/ua/developers/api/ 
3. https://api.privatbank.ua/#p24/exchange

## Used Tech stack:
- Java17
- Gradle
- Spring Boot 3.0.6
- Tomcat
- Hibernate
- PostgresQl
- Swagger
- REST, DTO and other patterns

## Swagger path:
http://localhost:8080/swagger-ui.html