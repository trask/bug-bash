#!/bin/bash -e

cd /c/git/ApplicationInsights-Java
./gradlew :agent-codeless:clean :agent-codeless:build -x test -DskipWinNative=true
cp agent-codeless/build/libs/applicationinsights-agent-codeless-2.5.1-BETA-SNAPSHOT.jar ../bug-bash/codeless-azure-function/applicationinsights-agent-codeless.jar
cd /c/git/bug-bash/codeless-azure-function
mvn clean package azure-functions:deploy
sleep 1
curl https://traskfunction.azurewebsites.net/api/HttpTrigger-Java
