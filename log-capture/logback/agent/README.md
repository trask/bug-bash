Configuration

* ApplicationInsights Web Auto
* ApplicationInsights Java Agent
* Spring Boot 2.x
* Standalone (jar)

Run

* Update instrumentation key in `ApplicationInsights.xml`
* Build with `mvn clean package`
* Run with `java -javaagent:target/dependency/applicationinsights-agent-2.5.0.jar -jar target/app.jar`

Verify

* Hit http://localhost:8080/log/error
  * Verify data in portal
* Hit http://localhost:8080/log/warn
  * Verify data in portal
* Hit http://localhost:8080/log/info
  * Verify data in portal (should not capture log with the given configuration in `logback.xml`)
