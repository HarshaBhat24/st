# Cross-Browser Testing Project

TestNG-based Selenium framework for cross-browser testing with parameterized browser selection.

## 📋 Overview

This project demonstrates:
- Cross-browser testing with Selenium WebDriver
- TestNG parameterization for browser selection
- Base test class pattern for reusable setup
- Explicit waits for reliable element interaction

## 🏗️ Project Structure

```
cross/
├── README.md
├── pom.xml                              # Maven configuration
├── src/
│   ├── test/
│   │   ├── java/
│   │   │   └── com/crossbrowser/program9/
│   │   │       ├── BaseTest.java       # Base class with browser setup
│   │   │       └── MyTest.java         # Test implementation
│   │   └── resources/
│   │       └── testing.xml             # TestNG configuration
└── target/                              # Build output and reports
    └── surefire-reports/                # TestNG HTML reports
```

## 🚀 Features

### Browser Support
- ✅ Chrome (Linux compatible)
- ⚠️ Firefox (not installed on current system)
- ⚠️ Edge (not available on Linux)

### Test Capabilities
- Parameterized browser execution
- WebDriverWait for synchronization
- Automatic browser cleanup
- Detailed console logging

## 💻 How to Run

### Run All Tests
```bash
cd cross
mvn clean test
```

### Run Specific Browser
```bash
# Chrome only
mvn test -Dbrowser=chrome

# Firefox (if installed)
mvn test -Dbrowser=firefox
```

### View Test Reports
```bash
# Open HTML report
xdg-open target/surefire-reports/index.html
```

## ⚙️ Configuration

### testing.xml (TestNG Suite Configuration)
```xml
<!DOCTYPE suite SYSTEM "https://testng.org/testng-1.0.dtd">
<suite name="Cross Browser Testing Suite">
    <test name="Chrome Test">
        <parameter name="browser" value="chrome"/>
        <classes>
            <class name="com.crossbrowser.program9.MyTest"/>
        </classes>
    </test>
    
    <!-- Add more browser tests -->
    <test name="Firefox Test">
        <parameter name="browser" value="firefox"/>
        <classes>
            <class name="com.crossbrowser.program9.MyTest"/>
        </classes>
    </test>
</suite>
```

### pom.xml Dependencies
- Selenium Java 4.27.0
- TestNG 7.8.0

## 📝 Code Structure

### BaseTest.java
Provides browser setup infrastructure:
```java
@Parameters("browser")
@BeforeMethod
public void setup(String browser) {
    // Initialize WebDriver based on browser parameter
    // Configure browser options
    // Maximize window
}

@AfterMethod
public void tearDown() {
    // Close browser
    // Clean up resources
}
```

### MyTest.java
Contains actual test cases:
```java
@Test
public void testGoogleSearch() {
    // Navigate to URL
    // Perform actions
    // Verify results
}
```

## 🎯 Test Case: Google Search

**Steps:**
1. Navigate to Google homepage
2. Wait for search box to be clickable
3. Enter search term "Selenium WebDriver"
4. Submit search
5. Wait for results page
6. Verify page title contains "Selenium"

## 🔧 Requirements

### System Requirements
- Java JDK 11+
- Maven 3.6+
- ChromeDriver at `/usr/bin/chromedriver`

### Installing ChromeDriver
```bash
# Ubuntu/Debian
sudo apt-get install chromium-chromedriver

# Or download manually
wget https://chromedriver.storage.googleapis.com/LATEST_RELEASE
# Download corresponding version and place in /usr/bin/
```

## 🎨 Adding New Browsers

### Firefox Setup
```java
if (browser.equalsIgnoreCase("firefox")) {
    System.setProperty("webdriver.gecko.driver", "/usr/bin/geckodriver");
    FirefoxOptions options = new FirefoxOptions();
    driver = new FirefoxDriver(options);
}
```

### Edge Setup (Windows)
```java
if (browser.equalsIgnoreCase("edge")) {
    System.setProperty("webdriver.edge.driver", "C:\\path\\to\\msedgedriver.exe");
    driver = new EdgeDriver();
}
```

## 📊 Expected Output

```
Launching Chrome Browser...
Browser launched: chrome
Navigated to Google
Page title: Selenium WebDriver - Google Search
Browser closed

===============================================
Cross Browser Testing Suite
Total tests run: 1, Passes: 1, Failures: 0, Skips: 0
===============================================
```

## 🎯 Learning Objectives

1. Cross-browser test automation
2. TestNG parameterization
3. Inheritance in test frameworks
4. WebDriver management
5. Explicit waits vs implicit waits
6. Page load strategies

## 🔍 Troubleshooting

### ChromeDriver Version Mismatch
```bash
# Check Chrome version
google-chrome --version

# Download matching ChromeDriver
# Ensure versions align (e.g., Chrome 120 → ChromeDriver 120)
```

### Element Not Found
- Increase wait timeout in `Duration.ofSeconds(20)`
- Verify element locator strategy
- Check if element is in iframe

### Test Hangs
- Check if browser window opened
- Verify network connectivity
- Review console for JavaScript errors

## 📚 Resources

- [Selenium WebDriver Documentation](https://www.selenium.dev/documentation/webdriver/)
- [TestNG Documentation](https://testng.org/doc/documentation-main.html)
- [Cross-Browser Testing Best Practices](https://www.selenium.dev/documentation/test_practices/)
