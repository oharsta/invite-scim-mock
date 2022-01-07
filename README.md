# invite-scim-mock

[![Build Status](https://github.com/oharsta/invite-scim-mock/actions/workflows/maven.yml/badge.svg)](https://github.com/oharsta/invite-scim-mock/actions/workflows/maven.yml/badge.svg)

SCIM Mock implementation

## [Getting started](#getting-started)

### [System Requirements](#system-requirements)

- Java 17
- Maven 3

First install Java 17 with a package manager and then export the correct the `JAVA_HOME`. For example on Mac OS:

```
export JAVA_HOME=/Library/Java/JavaVirtualMachines/openjdk-17.jdk/Contents/Home/
```

### [Building and running](#building-and-running)

This project uses Spring Boot and Maven. To run locally, type:

```
mvn spring-boot:run
```

To build and deploy (the latter requires credentials in your maven settings):

```
mvn clean deploy
```
