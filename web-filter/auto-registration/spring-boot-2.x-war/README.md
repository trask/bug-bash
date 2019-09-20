Configuration

* ApplicationInsights Web Auto
* Spring Boot 2.x
* Servlet container (war)

Test

* Update instrumentation key in `ApplicationInsights.xml`
* Build with `mvn clean package`
* Copy `target/ROOT.war` to `<tomcat>/webapps`
* Run Tomcat from the `<tomcat>/bin` directory
  * Linux `catalina.sh run`
  * Windows `catalina.bat run`

* Hit http://localhost:8080/hello
* Verify data in portal

* Hit http://localhost:8080/exception
* Verify data in portal
