#!/bin/bash -e

mvn package azure-functions:deploy
sleep 1
curl https://traskfunction.azurewebsites.net/api/HttpTrigger-Java
