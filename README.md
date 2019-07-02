
Build ApplicationInsights-Java locally

```
git clone https://github.com/microsoft/ApplicationInsights-Java.git
cd ApplicationInsights-Java
git checkout v25-beta-wip
./gradlew install -x test -DskipWinNative=true
```


Mass update all instrumentation keys in the bug bash apps:
```
INSTRUMENTATIONKEY=** Your instrumentation key **
find -name ApplicationInsights.xml | xargs sed -i 's/\*\* Your instrumentation key \*\*/$INSTRUMENTATIONKEY/'
find -name log4j.properties | xargs sed -i 's/\[APPLICATION_INSIGHTS_KEY\]/$INSTRUMENTATIONKEY/'
find -name log4j2.xml | xargs sed -i 's/\[APPLICATION_INSIGHTS_KEY\]/$INSTRUMENTATIONKEY/'
find -name logback.xml | xargs sed -i 's/\[APPLICATION_INSIGHTS_KEY\]/$INSTRUMENTATIONKEY/'
```


TODO

Add `operation-name` tests for Spring MVC, JAX-RS and Struts
