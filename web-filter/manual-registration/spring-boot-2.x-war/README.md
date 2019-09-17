Configuration

* ApplicationInsights Web (manual)
* Spring Boot 2.x
* Servlet container (war)

Test

* Update instrumentation key in `ApplicationInsights.xml`
* Build with `mvn clean package`
* Deploy `target/ROOT.war` to Tomcat

* Hit http://localhost:8080/hello
* Verify data in portal

* Hit http://localhost:8080/exception
* Verify data in portal
