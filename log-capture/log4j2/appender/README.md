Configuration

* ApplicationInsights Log4j 1.2 Appender
* ApplicationInsights Web Auto
* Spring Boot 2.x
* Standalone (jar)

Test

* Update instrumentation key in `ApplicationInsights.xml`
* Build: `mvn clean package`
* Run: `java -jar target/app.jar`

* Hit http://localhost:8080/log/error
* Verify data in portal

* Hit http://localhost:8080/log/warn
* Verify data in portal

* Hit http://localhost:8080/log/info
* Verify data in portal (should not capture log with the given configuration in `log4j2.xml`)
