# Parallel Junit 5 tests

- Repository answers question how to run easily tests in parallel / concurrent.
- Each method is running in its own thread
- Technologies used : maven-surefire-plugin + jupiter + java 11


## junit-platform.properties


To enable parallel execution

```
junit.jupiter.execution.parallel.enabled=true
```

## maven-surefire-plugin

To control parallelization see pom.xml

```xml
<plugin>
    <groupId>org.apache.maven.plugins</groupId>
    <artifactId>maven-surefire-plugin</artifactId>
    <version>${surefire-plugin.version}</version>
    <configuration>
        <parallel>methods</parallel>
        <useUnlimitedThreads>true</useUnlimitedThreads>
        <includes>
            <include>ApplicationTests*.class</include>
        </includes>
    </configuration>
</plugin>
```

## Run log

```
2021-07-20 18:53:34.820  INFO 52936 --- [Pool-1-worker-3] c.s.p.p.junit5.test.ApplicationTests     : test 3 starts
2021-07-20 18:53:34.820  INFO 52936 --- [ool-1-worker-13] c.s.p.p.junit5.test.ApplicationTests2    : test 5 starts
2021-07-20 18:53:34.820  INFO 52936 --- [Pool-1-worker-9] c.s.p.p.junit5.test.ApplicationTests     : test 2 starts
2021-07-20 18:53:34.820  INFO 52936 --- [Pool-1-worker-7] c.s.p.p.junit5.test.ApplicationTests     : test 1 starts
2021-07-20 18:53:34.820  INFO 52936 --- [ool-1-worker-11] c.s.p.p.junit5.test.ApplicationTests2    : test 4 starts
2021-07-20 18:53:34.820  INFO 52936 --- [Pool-1-worker-5] c.s.p.p.junit5.test.ApplicationTests2    : test 6 starts
2021-07-20 18:53:36.831  INFO 52936 --- [ool-1-worker-13] c.s.p.p.junit5.test.ApplicationTests2    : test 5 done
2021-07-20 18:53:36.832  INFO 52936 --- [Pool-1-worker-5] c.s.p.p.junit5.test.ApplicationTests2    : test 6 done
2021-07-20 18:53:36.831  INFO 52936 --- [ool-1-worker-11] c.s.p.p.junit5.test.ApplicationTests2    : test 4 done
2021-07-20 18:53:36.830  INFO 52936 --- [Pool-1-worker-9] c.s.p.p.junit5.test.ApplicationTests     : test 2 done
2021-07-20 18:53:36.831  INFO 52936 --- [Pool-1-worker-3] c.s.p.p.junit5.test.ApplicationTests     : test 3 done
2021-07-20 18:53:36.831  INFO 52936 --- [Pool-1-worker-7] c.s.p.p.junit5.test.ApplicationTests     : test 1 done
```

## pom.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>2.5.2</version>
    <relativePath/>
    </parent>
    <groupId>com.szatmary.peter</groupId>
    <artifactId>parallel-junit5-test</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>parallel-junit5-test</name>
    <description>Spring Boot app parallel test junit5 run with Jupiter</description>
    <properties>
        <java.version>11</java.version>
        <jupiter.version>5.3.0-RC1</jupiter.version><!-- new is not working -->
        <junit-platform.version>1.8.0-M1</junit-platform.version>
        <surefire-plugin.version>3.0.0-M5</surefire-plugin.version>
        <lombok.version>1.18.20</lombok.version>
    </properties>
    <dependencies>
        <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter</artifactId>
        </dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>

		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<version>${lombok.version}</version>
			<scope>test</scope>
		</dependency>

		<dependency>
			<groupId>org.junit.jupiter</groupId>
			<artifactId>junit-jupiter-engine</artifactId>
			<version>${jupiter.version}</version>
			<scope>test</scope>
		</dependency>

		<dependency>
			<groupId>org.junit.jupiter</groupId>
			<artifactId>junit-jupiter-api</artifactId>
			<version>${jupiter.version}</version>
			<scope>test</scope>
		</dependency>

		<dependency>
			<groupId>org.junit.platform</groupId>
			<artifactId>junit-platform-engine</artifactId>
			<version>${junit-platform.version}</version>
			<scope>test</scope>
		</dependency>

		<dependency>
			<groupId>org.junit.platform</groupId>
			<artifactId>junit-platform-launcher</artifactId>
			<version>${junit-platform.version}</version>
			<scope>test</scope>
		</dependency>
	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-surefire-plugin</artifactId>
				<version>${surefire-plugin.version}</version>
				<configuration>
					<parallel>methods</parallel>
					<useUnlimitedThreads>true</useUnlimitedThreads>
					<includes>
						<include>ApplicationTests*.class</include>
					</includes>
				</configuration>
			</plugin>
		</plugins>
	</build>
</project>
```


## More information

- [Junit5](https://junit.org/junit5/docs/current/user-guide/)
- [Maven surefire plugin](https://maven.apache.org/surefire/maven-surefire-plugin/)