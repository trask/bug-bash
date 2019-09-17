Configuration

* ApplicationInsights Web (manual)
* Spring Boot 2.x
* Standalone (jar)

Test

* Update instrumentation key in `ApplicationInsights.xml`
* Build with `mvn clean package`
* Run: `java -jar target/app.jar`

* Hit http://localhost:8080/hello
* Verify data in portal

* Hit http://localhost:8080/exception
* Verify data in portal
