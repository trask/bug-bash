Configuration

* ApplicationInsights Log4j 1.2 Appender
* ApplicationInsights Web Auto
* Spring Boot 2.x
* Standalone (jar)

Test

* Update instrumentation key in `ApplicationInsights.xml`
* Update instrumentation key in `logback.xml`
* Build: `mvn clean package`
* Run: `java -jar target/app.jar`

* Hit http://localhost:8080/error
* Verify data in portal

* Hit http://localhost:8080/warn
* Verify data in portal

* Hit http://localhost:8080/info
* Verify data in portal (should not capture log with the given configuration in `logback.xml`)
