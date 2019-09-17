Configuration

* ApplicationInsights Java Agent
* ApplicationInsights Web Auto
* Spring Boot 2.x
* Standalone (jar)

Test

* Copy `applicationinsights-agent-2.5.0.jar` into this directory
* Update instrumentation key in `ApplicationInsights.xml`
* Build all three `frontend`, `service-a` and `service-b`, from their directories
  * `mvn clean package`
* Run all three, from their directories
  * `java -javaagent:applicationinsights-agent-2.5.0.jar -jar target/app.jar`

* Hit http://localhost:8080/service-a
* Verify data in portal

* Hit http://localhost:8080/service-ab
* Verify data in portal
