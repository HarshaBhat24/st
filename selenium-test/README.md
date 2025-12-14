# Selenium Test Framework

Maven-based Selenium WebDriver project template for test automation.

## 📋 Overview

A minimal Maven project structure configured for Selenium testing with TestNG.

## 🏗️ Project Structure

```
selenium-test/
├── README.md
├── pom.xml              # Maven configuration
├── src/
│   └── main/
│       └── java/
│           └── GuruWebpageLogin.java  # Sample login test
└── target/              # Build output
    ├── classes/
    └── generated-sources/
```

## 🚀 Features

- Maven dependency management
- Selenium WebDriver 4.15.0
- TestNG 7.8.0 integration
- Ready-to-use project structure
- Example test included

## 💻 How to Run

### Run Tests
```bash
cd selenium-test
mvn clean test
```

### Compile Only
```bash
mvn clean compile
```

### Run Specific Class
```bash
mvn exec:java -Dexec.mainClass="GuruWebpageLogin"
```

## ⚙️ Configuration

### pom.xml Dependencies
```xml
<dependencies>
    <dependency>
        <groupId>org.seleniumhq.selenium</groupId>
        <artifactId>selenium-java</artifactId>
        <version>4.15.0</version>
    </dependency>
    <dependency>
        <groupId>org.testng</groupId>
        <artifactId>testng</artifactId>
        <version>7.8.0</version>
    </dependency>
</dependencies>
```

## 📁 Directory Structure Explained

```
src/
├── main/
│   ├── java/          # Application/utility code
│   └── resources/     # Configuration files
└── test/
    ├── java/          # Test classes
    └── resources/     # Test data files
```

## 🎯 Getting Started

### 1. Add Your Test Class
```java
// src/test/java/com/yourpackage/YourTest.java
package com.yourpackage;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class YourTest {
    @Test
    public void testSomething() {
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        System.out.println(driver.getTitle());
        driver.quit();
    }
}
```

### 2. Create TestNG Suite XML
```xml
<!-- src/test/resources/testng.xml -->
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
<suite name="Test Suite">
    <test name="Smoke Tests">
        <classes>
            <class name="com.yourpackage.YourTest"/>
        </classes>
    </test>
</suite>
```

### 3. Update pom.xml for Suite Execution
```xml
<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-surefire-plugin</artifactId>
            <version>3.0.0</version>
            <configuration>
                <suiteXmlFiles>
                    <suiteXmlFile>src/test/resources/testng.xml</suiteXmlFile>
                </suiteXmlFiles>
            </configuration>
        </plugin>
    </plugins>
</build>
```

## 🔧 Requirements

- Java JDK 11+
- Maven 3.6+
- ChromeDriver (or other browser drivers)

## 🎨 Recommended Project Additions

### 1. Add WebDriverManager
Automatically manages driver binaries:
```xml
<dependency>
    <groupId>io.github.bonigarcia</groupId>
    <artifactId>webdrivermanager</artifactId>
    <version>5.6.2</version>
</dependency>
```

Usage:
```java
WebDriverManager.chromedriver().setup();
WebDriver driver = new ChromeDriver();
```

### 2. Add Logging
```xml
<dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>slf4j-simple</artifactId>
    <version>2.0.9</version>
</dependency>
```

### 3. Add ExtentReports
Beautiful HTML test reports:
```xml
<dependency>
    <groupId>com.aventstack</groupId>
    <artifactId>extentreports</artifactId>
    <version>5.1.1</version>
</dependency>
```

### 4. Add AssertJ
Fluent assertions:
```xml
<dependency>
    <groupId>org.assertj</groupId>
    <artifactId>assertj-core</artifactId>
    <version>3.24.2</version>
    <scope>test</scope>
</dependency>
```

## 📝 Best Practices

1. **Organize by Package**
   ```
   src/test/java/
   ├── pages/          # Page Object classes
   ├── tests/          # Test classes
   ├── utils/          # Helper utilities
   └── base/           # Base test class
   ```

2. **Use Page Object Model**
   ```java
   public class LoginPage {
       private WebDriver driver;
       
       @FindBy(name = "username")
       private WebElement usernameField;
       
       public LoginPage(WebDriver driver) {
           this.driver = driver;
           PageFactory.initElements(driver, this);
       }
       
       public void login(String user, String pass) {
           usernameField.sendKeys(user);
           // ...
       }
   }
   ```

3. **Base Test Class**
   ```java
   public class BaseTest {
       protected WebDriver driver;
       
       @BeforeMethod
       public void setUp() {
           WebDriverManager.chromedriver().setup();
           driver = new ChromeDriver();
       }
       
       @AfterMethod
       public void tearDown() {
           if (driver != null) {
               driver.quit();
           }
       }
   }
   ```

## 📚 Resources

- [Maven Official Documentation](https://maven.apache.org/guides/)
- [Selenium WebDriver](https://www.selenium.dev/documentation/webdriver/)
- [TestNG Documentation](https://testng.org/doc/documentation-main.html)
- [Page Object Model](https://www.selenium.dev/documentation/test_practices/encouraged/page_object_models/)
