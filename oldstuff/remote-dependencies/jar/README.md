Configuration

* ApplicationInsights Web Auto
* ApplicationInsights Java Agent
* Spring Boot 2.x
* Standalone (jar)

Run

* Update instrumentation key in `ApplicationInsights.xml`
* Build with `mvn clean package`
* Run with `java -javaagent:applicationinsights-agent-2.5.0.jar -jar target/app.jar`

Verify

* Hit http://localhost:8080/http-dependency/success
  * Verify data in portal
* Hit http://localhost:8080/http-dependency/failure
  * Verify data in portal
* Hit http://localhost:8080/jdbc-dependency/success
  * Verify data in portal
* Hit http://localhost:8080/jdbc-dependency/failure
  * Verify data in portal
