Configuration

* ApplicationInsights Web Auto
* Spring Boot 1.3.x
* Standalone (jar)

Run

* Update instrumentation key in `ApplicationInsights.xml`
* Build with `mvn clean package`
* Run with `java -jar target/app.jar`

Verify

* Hit http://localhost:8080/hello
  * Verify data in portal
* Hit http://localhost:8080/exception
  * Verify data in portal
