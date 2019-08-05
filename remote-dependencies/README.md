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

* Hit http://localhost:8080/http-dependency/success
* Verify data in portal

* Hit http://localhost:8080/http-dependency/failure
* Verify data in portal

* Hit http://localhost:8080/jdbc-dependency/success
* Verify data in portal

* Hit http://localhost:8080/jdbc-dependency/failure
* Verify data in portal
