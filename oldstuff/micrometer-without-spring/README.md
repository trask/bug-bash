Configuration

* Micrometer

Run

* Update instrumentation key in `application.properties`
* Build with `mvn clean package`
* Run with `java -jar target/app.jar`

Verify

* Hit http://localhost:8080/hello
  * Verify `bug_bash_counter` metric data in portal
