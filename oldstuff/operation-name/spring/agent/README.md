Configuration

* ApplicationInsights Java Agent
* ApplicationInsights Web Auto
* Spring Boot 2.x
* Standalone (jar)

Test

* Copy `applicationinsights-agent-2.5.0-BETA-SNAPSHOT.jar` into this directory
* Update instrumentation key in `ApplicationInsights.xml`
* Build: `mvn clean package`
* Run: `java -javaagent:applicationinsights-agent-2.5.0-BETA-SNAPSHOT.jar -jar target/app.jar`

* Hit http://localhost:8080/error
* Verify data in portal

* Hit http://localhost:8080/warn
* Verify data in portal

* Hit http://localhost:8080/info
* Verify data in portal (should not capture log with the given configuration in `logback.xml`)
