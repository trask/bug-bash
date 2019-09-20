Configuration

* ApplicationInsights Web Auto
* ApplicationInsights Java Agent
* Spring Boot 2.x
* Standalone (jar)

Test

* Update instrumentation key in `ApplicationInsights.xml`
* Build all three from their directories (`frontend`, `service-a` and `service-b`)
  * `mvn clean package`
* Run all three from their directories (`frontend`, `service-a` and `service-b`)
  * `java -javaagent:target/dependency/applicationinsights-agent-2.5.0.jar -jar target/app.jar`

* Hit http://localhost:8080/service-a
* Verify data in portal

* Hit http://localhost:8080/service-ab
* Verify data in portal
