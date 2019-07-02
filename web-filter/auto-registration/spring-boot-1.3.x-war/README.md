Configuration

* ApplicationInsights Web Auto
* Spring Boot 1.3.x
* Servlet container (war)

Test

* Update instrumentation key in `ApplicationInsights.xml`
* Build: `mvn clean package`
* Deploy `target/app.war` to Tomcat

* Hit http://localhost:8080/app/hello
* Verify data in portal

* Hit http://localhost:8080/app/exception
* Verify data in portal
