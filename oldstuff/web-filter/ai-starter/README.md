NOTE ApplicationInsights Spring Boot Starter only supports Spring Boot 1.4.0 and later

Configuration

* ApplicationInsights Spring Boot Starter
* Spring Boot 2.x
* Standalone (jar)

Run

* Update instrumentation key in `application.properties`
* Build with `mvn clean package`
* Run with `java -jar target/app.jar`

Verify

* Hit http://localhost:8080/hello
  * Verify data in portal
* Hit http://localhost:8080/exception
  * Verify data in portal
