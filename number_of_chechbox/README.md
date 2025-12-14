# Checkbox Counter - Selenium Test

TestNG project that counts and analyzes checkboxes on a webpage using Selenium WebDriver.

## 📋 Overview

This project demonstrates:
- Dynamic web element detection with Selenium
- XPath locator strategies
- Checkbox state inspection (selected/unselected)
- TestNG test lifecycle management
- Chrome browser automation on Linux

## 🏗️ Project Structure

```
number_of_chechbox/
├── README.md
├── pom.xml                                    # Maven configuration
├── src/
│   └── test/
│       └── java/
│           └── number_of_chechbox/
│               └── p10.java                   # Checkbox test class
└── target/                                    # Build output
    └── surefire-reports/                      # Test reports
```

## 🚀 Features

### Checkbox Analysis
- **Total Count**: Finds all checkboxes on the page
- **State Detection**: Identifies checked vs unchecked
- **Console Report**: Displays detailed statistics

### Test Site
Uses [The Internet - Checkboxes](https://the-internet.herokuapp.com/checkboxes)
- Public test site by Herokuapp
- Contains 2 checkboxes (1 checked, 1 unchecked by default)

## 💻 How to Run

### Execute Test
```bash
cd number_of_chechbox
mvn clean test
```

### Expected Output
```
Browser launched and maximized
Total Checkboxes: 2
Checked Checkboxes: 1
Unchecked Checkboxes: 1
Browser closed

===============================================
Surefire suite
Total tests run: 1, Passes: 1, Failures: 0, Skips: 0
===============================================
```

### View Test Reports
```bash
xdg-open target/surefire-reports/index.html
```

## 📝 Code Walkthrough

### 1. Setup (@BeforeClass)
```java
@BeforeClass
public void setUp() {
    // Set ChromeDriver path
    System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
    
    // Configure Chrome options
    ChromeOptions options = new ChromeOptions();
    options.addArguments("--remote-allow-origins=*");
    options.addArguments("--no-sandbox");
    options.addArguments("--disable-dev-shm-usage");
    
    // Initialize driver
    driver = new ChromeDriver(options);
    driver.manage().window().maximize();
}
```

### 2. Test Execution (@Test)
```java
@Test
public void testCheckBoxesCount() {
    // Navigate to test page
    driver.get("https://the-internet.herokuapp.com/checkboxes");
    
    // Find all checkbox elements
    List<WebElement> checkboxes = 
        driver.findElements(By.xpath("//input[@type='checkbox']"));
    
    // Analyze each checkbox
    for (WebElement checkbox : checkboxes) {
        if (checkbox.isSelected()) {
            checked++;
        } else {
            unchecked++;
        }
    }
    
    // Display results
    System.out.println("Total: " + checkboxes.size());
}
```

### 3. Cleanup (@AfterClass)
```java
@AfterClass
public void tearDown() {
    if (driver != null) {
        driver.quit();
    }
}
```

## 🔧 Requirements

### System Requirements
- Java JDK 11+
- Maven 3.6+
- ChromeDriver at `/usr/bin/chromedriver`
- Internet connection (for test site)

### Dependencies
```xml
<dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-java</artifactId>
    <version>4.27.0</version>
</dependency>
<dependency>
    <groupId>org.testng</groupId>
    <artifactId>testng</artifactId>
    <version>7.8.0</version>
</dependency>
```

## 🎯 XPath Locator Explained

```xpath
//input[@type='checkbox']
```

**Breakdown:**
- `//` : Search anywhere in DOM
- `input` : Target input elements
- `[@type='checkbox']` : Filter by type attribute

**Alternative Locators:**
```java
// By CSS Selector
driver.findElements(By.cssSelector("input[type='checkbox']"));

// By Tag Name (less specific)
driver.findElements(By.tagName("input"));
```

## 📊 Sample Test Scenarios

### Test Different Pages
```java
// Gmail
driver.get("https://mail.google.com/");

// Amazon
driver.get("https://www.amazon.com/");

// Your own application
driver.get("http://localhost:8080/your-app");
```

### Enhanced Checkbox Operations
```java
// Click all unchecked boxes
for (WebElement checkbox : checkboxes) {
    if (!checkbox.isSelected()) {
        checkbox.click();
    }
}

// Verify checkbox is enabled
if (checkbox.isEnabled()) {
    System.out.println("Checkbox is clickable");
}

// Get checkbox attributes
String id = checkbox.getAttribute("id");
String name = checkbox.getAttribute("name");
```

## 🎯 Learning Objectives

1. Selenium WebDriver element location
2. Working with collections of WebElements
3. Checkbox state inspection methods
4. TestNG annotations and lifecycle
5. Chrome browser configuration
6. Dynamic element handling

## 🎨 Enhancement Ideas

1. **Data-Driven**: Test multiple URLs from Excel
2. **Assertions**: Use TestNG assertions for validation
3. **Screenshots**: Capture page before/after interaction
4. **Logging**: Integrate Log4j for better reporting
5. **Parallel Testing**: Run multiple URLs in parallel
6. **Element Interaction**: Click checkboxes and verify state changes
7. **Explicit Waits**: Add waits for dynamic checkboxes
8. **Custom Reports**: Generate HTML/PDF reports

## ⚠️ Common Issues

### ChromeDriver Not Found
```bash
# Install via package manager
sudo apt-get install chromium-chromedriver

# Or manually download
wget https://chromedriver.storage.googleapis.com/LATEST_RELEASE
```

### No Checkboxes Found
- Verify URL is correct
- Check if page loads completely
- Inspect HTML to confirm checkbox elements exist
- Use browser DevTools to validate XPath

### WebDriverException
```java
// Add these Chrome options
options.addArguments("--headless");  // Run without UI
options.addArguments("--disable-gpu");
options.addArguments("--window-size=1920,1080");
```

## 🔍 Debugging Tips

### Print Checkbox Details
```java
for (int i = 0; i < checkboxes.size(); i++) {
    WebElement cb = checkboxes.get(i);
    System.out.println("Checkbox " + (i+1));
    System.out.println("  Selected: " + cb.isSelected());
    System.out.println("  Enabled: " + cb.isEnabled());
    System.out.println("  Displayed: " + cb.isDisplayed());
    System.out.println("  ID: " + cb.getAttribute("id"));
}
```

## 📚 Resources

- [Selenium WebDriver Documentation](https://www.selenium.dev/documentation/webdriver/)
- [TestNG Annotations Guide](https://testng.org/doc/documentation-main.html#annotations)
- [XPath Tutorial](https://www.w3schools.com/xml/xpath_intro.asp)
- [The Internet Test Site](https://the-internet.herokuapp.com/)
