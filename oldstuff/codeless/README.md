Configuration

* ApplicationInsights Java Codeless Agent
* Spring Boot 2.x
* Standalone (jar)

Test

* Copy `applicationinsights-agent-codeless-2.5.0-BETA.3-SNAPSHOT.jar` into this directory
* Update instrumentation key in `ApplicationInsights.json`
* Build: `mvn clean package`
* Run: `java -javaagent:applicationinsights-agent-codeless-2.5.0-BETA.3-SNAPSHOT.jar -jar target/app.jar`

* Hit http://localhost:8080/http-dependency/success
* Verify data in portal

* Hit http://localhost:8080/http-dependency/failure
* Verify data in portal
