Setup

* Run all three services from their directories
  * `frontend`
    * `java -javaagent:applicationinsights-agent-3.0.0-BUGBASH.2.jar -jar frontend.jar`
  * `service-a`
    * `java -javaagent:applicationinsights-agent-2.6.2.jar -jar service-a.jar`
  * `service-b`
    * `java -javaagent:applicationinsights-agent-3.0.0-BUGBASH.2.jar -jar service-b.jar`

Test #1

* Hit http://localhost:8080/hello
* This will hit the frontend service only
* Verify data in portal
  * ...
  * sdkVersion should be 3.0.0-BUGBASH.2

* Hit http://localhost:8080/service-a
* This will hit the frontend service which will then call service A
* Verify data in portal
  * ...
  * sdkVersion should be 2.6.2

* Hit http://localhost:8080/service-ab
* This will hit the frontend service which will then call service A which will then call service B
* Verify data in portal
  * ...
  * sdkVersion should be 3.0.0-BUGBASH.2

Test #2

* Set sampling to 5%
* Send 100 requests, from bash shell:
  ```
  for i in {1..100}; do curl --silent --output /dev/null http://localhost:8080/service-ab; done
  ```
* Verify data in portal
* Verify that there are approximately 5 traces, and check that none of them are "broken"

Test #3

* Use a different Application Insights resource (instrumentation key) for each service
* Verify the same result as in test #1

Test #4

* Disable W3C distributed tracing on Service A (2.6.2)
  * Need to disable it in both `ApplicationInsights.xml` and `AI-Agent.xml`
* Verify the same result as in test #1
