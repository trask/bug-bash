Configuration

* ApplicationInsights Java Agent
* ApplicationInsights Web Auto
* Spring Boot 2.x
* Standalone (jar)

Test

* Copy `applicationinsights-agent-2.5.0-BETA-SNAPSHOT.jar` into this directory
* Update instrumentation key in `ApplicationInsights.xml`
* Build `frontend`, `service-a` and `service-b`
  * `(cd frontend; mvn clean package)`
  * `(cd service-a; mvn clean package)`
  * `(cd service-b; mvn clean package)`
* Run all three
  * `java -javaagent:applicationinsights-agent-2.5.0-BETA-SNAPSHOT.jar -jar frontend/target/app.jar &`
  * `java -javaagent:applicationinsights-agent-2.5.0-BETA-SNAPSHOT.jar -jar service-a/target/app.jar &`
  * `java -javaagent:applicationinsights-agent-2.5.0-BETA-SNAPSHOT.jar -jar service-b/target/app.jar &`

* Hit http://localhost:8080/service-a
* Verify data in portal

* Hit http://localhost:8080/service-ab
* Verify data in portal
