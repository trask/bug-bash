These CHANGED are designed to run locally.

If you want to deploy any of them to Azure App Services, you need to configure the `azure-webapp-maven-plugin` under the `<build>`/`<plugins>` section of the app's `pom.xml` (see below).

Then login and set your subscription, e.g.

```
az login
az account set --subscription <subscription id>
```

Then build and deploy the app to Azure App Services, e.g.

```
mvn clean package azure-webapp:deploy
```

## How to configure azure-webapp-maven-plugin

### If the app is a spring boot jar without the java agent:

```
      <plugin>
        <groupId>com.microsoft.azure</groupId>
        <artifactId>azure-webapp-maven-plugin</artifactId>
        <version>1.7.0</version>
        <configuration>
          <schemaVersion>V2</schemaVersion>
          <!-- Note: you cannot have both windows and linux app services in the same resource group -->
          <resourceGroup>** Your Azure Resource Group **</resourceGroup>
          <!-- Note: app name must be globally unique within the region below -->
          <appName>** Your App Service app name **</appName>
          <pricingTier>P1v2</pricingTier>
          <region>West US</region>
          <runtime>
            <os>linux</os>
            <javaVersion>jre8</javaVersion>
            <webContainer>jre8</webContainer>
          </runtime>
          <deployment>
            <resources>
              <resource>
                <directory>${project.build.directory}</directory>
                <includes>
                  <include>*.jar</include>
                </includes>
              </resource>
            </resources>
          </deployment>
        </configuration>
      </plugin>
```

### If the app is a spring boot jar with the java agent:

```
      <plugin>
        <groupId>com.microsoft.azure</groupId>
        <artifactId>azure-webapp-maven-plugin</artifactId>
        <version>1.7.0</version>
        <configuration>
          <schemaVersion>V2</schemaVersion>
          <!-- Note: you cannot have both windows and linux app services in the same resource group -->
          <resourceGroup>** Your Azure Resource Group **</resourceGroup>
          <!-- Note: app name must be globally unique within the region below -->
          <appName>** Your App Service app name **</appName>
          <pricingTier>P1v2</pricingTier>
          <region>West US</region>
          <runtime>
            <os>linux</os>
            <javaVersion>jre8</javaVersion>
            <webContainer>jre8</webContainer>
          </runtime>
          <deployment>
            <resources>
              <resource>
                <directory>${project.build.directory}</directory>
                <includes>
                  <include>*.jar</include>
                </includes>
              </resource>
              <resource>
                <directory>${project.build.directory}/dependency</directory>
                <includes>
                  <include>*.jar</include>
                </includes>
              </resource>
              <resource>
                <directory>${project.basedir}</directory>
                <includes>
                  <include>AI-Agent.xml</include>
                </includes>
              </resource>
            </resources>
          </deployment>
          <appSettings>
            <property>
              <name>JAVA_OPTS</name>
              <value>-javaagent:/home/site/wwwroot/applicationinsights-agent-${applicationinsights.version}.jar</value>
           </property>
          </appSettings>
        </configuration>
      </plugin>
```

### If the app is a war without the java agent:

```
      <plugin>
        <groupId>com.microsoft.azure</groupId>
        <artifactId>azure-webapp-maven-plugin</artifactId>
        <version>1.7.0</version>
        <configuration>
          <schemaVersion>V2</schemaVersion>
          <!-- Note: you cannot have both windows and linux app services in the same resource group -->
          <resourceGroup>** Your Azure Resource Group **</resourceGroup>
          <!-- Note: app name must be globally unique within the region below -->
          <appName>** Your App Service app name **</appName>
          <pricingTier>P1v2</pricingTier>
          <region>West US</region>
          <runtime>
            <os>linux</os>
            <javaVersion>jre8</javaVersion>
            <webContainer>tomcat 8.5</webContainer>
          </runtime>
          <deployment>
            <resources>
              <resource>
                <directory>${project.build.directory}</directory>
                <includes>
                  <include>*.war</include>
                </includes>
              </resource>
            </resources>
          </deployment>
        </configuration>
      </plugin>
```

### If the app is a war with the java agent:

```
      <plugin>
        <!-- download the applicationinsights-agent jar file to the target/dependency directory -->
        <artifactId>maven-dependency-plugin</artifactId>
        <executions>
          <execution>
            <id>copy</id>
            <phase>generate-resources</phase>
            <goals>
              <goal>copy</goal>
            </goals>
          </execution>
        </executions>
        <configuration>
          <artifactItems>
            <artifactItem>
              <groupId>com.microsoft.azure</groupId>
              <artifactId>applicationinsights-agent</artifactId>
              <version>${applicationinsights.version}</version>
            </artifactItem>
          </artifactItems>
        </configuration>
      </plugin>
      <plugin>
        <!-- place the applicationinsights-agent jar and AI-Agent xml files inside of the war file under META-INF -->
        <artifactId>maven-war-plugin</artifactId>
        <configuration>
          <webResources>
            <resource>
              <directory>${project.build.directory}/dependency</directory>
              <targetPath>META-INF</targetPath>
              <includes>
                <include>*.jar</include>
              </includes>
            </resource>
            <resource>
              <directory>${project.basedir}</directory>
              <targetPath>META-INF</targetPath>
              <includes>
                <include>AI-Agent.xml</include>
              </includes>
            </resource>
          </webResources>
        </configuration>
      </plugin>
      <plugin>
        <groupId>com.microsoft.azure</groupId>
        <artifactId>azure-webapp-maven-plugin</artifactId>
        <version>1.7.0</version>
        <configuration>
          <schemaVersion>V2</schemaVersion>
          <!-- Note: you cannot have both windows and linux app services in the same resource group -->
          <resourceGroup>** Your Azure Resource Group **</resourceGroup>
          <!-- Note: app name must be globally unique within the region below -->
          <appName>** Your App Service app name **</appName>
          <pricingTier>P1v2</pricingTier>
          <region>West US</region>
          <runtime>
            <os>linux</os>
            <javaVersion>jre8</javaVersion>
            <webContainer>tomcat 8.5</webContainer>
          </runtime>
          <deployment>
            <resources>
              <resource>
                <directory>${project.build.directory}</directory>
                <includes>
                  <include>*.war</include>
                </includes>
              </resource>
            </resources>
          </deployment>
          <appSettings>
            <property>
              <name>JAVA_OPTS</name>
              <value>-javaagent:/home/site/wwwroot/webCHANGED/ROOT/META-INF/applicationinsights-agent-${applicationinsights.version}.jar</value>
            </property>
          </appSettings>
        </configuration>
      </plugin>
```
