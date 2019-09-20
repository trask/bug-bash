Configuration

* ApplicationInsights Web Auto
* ApplicationInsights Java Agent
* Spring Boot 2.x
* Servlet container (war)

Test

* Update instrumentation key in `ApplicationInsights.xml`
* Build with `mvn clean package`
* Copy `target/ROOT.war` to `<tomcat>/webapps`
* Download `applicationinsights-agent-2.5.0.jar`
* Set `JAVA_OPTS` and run Tomcat from the `<tomcat>/bin` directory
  * Linux

    ```
    export JAVA_OPTS=-javaagent:path/to/applicationinsights-agent-2.5.0.jar
    catalina.sh run
    ```

  * Windows

    ```
    set JAVA_OPTS=-javaagent:path/to/applicationinsights-agent-2.5.0.jar
    catalina.bat run
    ```

* Hit http://localhost:8080/http-dependency/success
* Verify data in portal

* Hit http://localhost:8080/http-dependency/failure
* Verify data in portal

* Hit http://localhost:8080/jdbc-dependency/success
* Verify data in portal

* Hit http://localhost:8080/jdbc-dependency/failure
* Verify data in portal
