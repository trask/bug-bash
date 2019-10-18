Configuration

* ApplicationInsights Java Codeless Agent
* Spring Boot 2.x
* Standalone (jar)

Test

* Copy `applicationinsights-codeless-agent-2.5.1-BETA-SNAPSHOT.jar` into this directory
* Update instrumentation key in
  * `frontend/ApplicationInsights.json`
  * `service-a/ApplicationInsights.json`
  * `service-b/ApplicationInsights.json`
* Build `frontend`, `service-a` and `service-b`
  * `(cd frontend; mvn clean package)`
  * `(cd service-a; mvn clean package)`
  * `(cd service-b; mvn clean package)`
* Run all three
  * `(cd frontend; java -javaagent:applicationinsights-agent-codeless-2.5.1-BETA-SNAPSHOT.jar -jar target/app.jar &)`
  * `(cd service-a; java -javaagent:applicationinsights-agent-codeless-2.5.1-BETA-SNAPSHOT.jar -jar target/app.jar &)`
  * `(cd service-a; java -javaagent:applicationinsights-agent-codeless-2.5.1-BETA-SNAPSHOT.jar -jar target/app.jar &)`

* Hit http://localhost:8080/service-a
* Verify data in portal

* Hit http://localhost:8080/service-ab
* Verify data in portal
