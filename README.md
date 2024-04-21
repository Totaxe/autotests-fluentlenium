An example of UI automated tests using [FluentLenium](https://github.com/FluentLenium/FluentLenium) framework.

A similar project using Selenium can be found [here](https://github.com/Totaxe/autotests-java).

## Application Under Test
[LinkAce](https://github.com/Kovah/LinkAce) is a bookmark management web application written in PHP. It uses MySQL (MariaDB) to store data.

How to install with Docker:
```
git clone https://github.com/Totaxe/autotests-fluentlenium.git
cd docker
docker compose up -d
```

## Running tests
```
chmod a+x gradlew
./gradlew cleanTest test
```

Test report is generated by Gradle in build/reports/tests/test/index.html.

## Settings
Test bench settings are in src/test/test.properties. You can also specify settings in environment variables or java system properties.

Browser automation settings are in src/test/fluentlenium.properties. The description can be found in FluentLenium [documentation](https://fluentlenium.io/docs/configuration/).

Logging settings are in src/test/logback-test.xml.

## Libraries Used
| Name | Description |
| -------- | -------- |
| [JUnit 5](https://github.com/junit-team/junit5)  | Testing framework |
| [AssertJ](https://github.com/assertj/assertj)  | Test assertions |
| [FluentLenium](https://github.com/FluentLenium/FluentLenium) | Browser automation |
| [Retrofit](https://github.com/square/retrofit) | LinkAce API client |
| [WebDriverManager](https://github.com/bonigarcia/webdrivermanager) | Browser driver management |
| [OWNER](https://github.com/matteobaccan/owner) | Settings |
| [Logback](https://github.com/qos-ch/logback) (SLF4J) | Logging |
| [Lombok](https://github.com/projectlombok/lombok) | Boilerplate code generation |
| [MyBatis](https://github.com/mybatis/mybatis-3) | SQL script execution |

## Remote Test Execution

Tests can be executed using [Selenoid](https://github.com/aerokube/selenoid) or [Browserless](https://github.com/browserless/chrome).

Settings for Selenoid:
```properties
webDriver = remote
capabilities = selenoid
remoteUrl = http://192.168.0.157:4444/wd/hub
```
Settings for Browserless:
```properties
webDriver = remote
capabilities = browserless
remoteUrl = http://192.168.0.157:3000/webdriver
```

## Jenkins
Tests can be run on Jenkins. The pipeline script is in Jenkinsfile.

The **junit** step generates report that can be viewed in Jenkins UI.

The page screenshot is made after each test and attached to the report using [JUnit Attachments](https://plugins.jenkins.io/junit-attachments/) plugin.
