# Exchange rate web-app

## 📔 Summary:
Web application that loads data(exchange rates) from a third-party service
into an internal PostgresQL database. Implemented API requests operate on
a local database (i.e. retrieve data from a database). API contain two methods:
1. Request for a list of exchange rates for all sources, with average market rates.
2. Request to issue a list of average exchange rates for all sources for the period.

## 📑 Used public API:
1. https://api.monobank.ua/docs/ 
2. https://minfin.com.ua/ua/developers/api/ 
3. https://api.privatbank.ua/#p24/exchange

## 🔨 Used Tech stack:
- Java17
- Gradle
- Spring Boot 3.0.6
- Tomcat
- Hibernate
- PostgresQl
- Swagger
- REST, DTO and other patterns

## 🖥️ BackEnd Project SetUp:
- Clone this repo.
- Start your PostgreSQLServer
- Create DB from int_db.sql script in resources.
- Create application.properties file in src/main/resources folder
with data as in application.properties.sample file 
and fill in your data(login, password, url, driver) 
in src/main/resources/application.properties file.
- Start app from: com/example/exchangerateapp/ExchangeRateAppApplication.java file.
Enjoy the app.

## 💻 Entering Swagger UI throw SpringDoc:
- Start app as in previous chapter.
- Enter http://localhost:8080/swagger-ui.html 
and you`ll see all the needed Swagger UI functional and REST endpoints ;)

## Swagger path
You can start Swagger UI from this url:
http://localhost:8080/swagger-ui.html

## Video Presentation
You can check how the app work in this video presentation:
https://www.loom.com/share/77c32cdf3d0b48a6926b94d0df39439a

_____
Good luck. With :hearts: love from :ukraine: Ukraine! :smiley: