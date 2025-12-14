# Selenium Login Automation

Standalone Selenium WebDriver program for automating login flow on the Guru99 demo site.

## 📋 Overview

This project demonstrates:
- Selenium WebDriver setup and configuration
- Web element location strategies
- Explicit waits for reliable automation
- Login form automation
- Result verification
- Clean test structure with helper methods

## 🏗️ Project Structure

```
websel/
├── README.md
└── GuruWebpageLogin.java    # Main test class
```

## 🚀 Features

### Test Flow
1. **Setup**: Initialize ChromeDriver and WebDriverWait
2. **Navigate**: Open Guru99 Mercury Tours demo site
3. **Login**: Enter credentials and submit form
4. **Verify**: Check page title for success
5. **Cleanup**: Close browser and release resources

### Key Patterns
- **Configuration Constants**: Centralized settings
- **Helper Methods**: Single-responsibility functions
- **Explicit Waits**: Reliable element synchronization
- **Error Handling**: Try-catch-finally pattern
- **Clean Code**: Well-documented and organized

## 💻 How to Run

### Method 1: Direct Execution
```bash
cd websel

# Compile
javac -cp ".:/usr/share/java/selenium/*" GuruWebpageLogin.java

# Run
java -cp ".:/usr/share/java/selenium/*:." GuruWebpageLogin
```

### Method 2: Using IDE
1. Import as Java project
2. Add Selenium WebDriver to classpath
3. Update ChromeDriver path if needed
4. Run `main()` method

### Expected Output
```
Launching Chrome Browser...
Page Title: Login: Mercury Tours
LOGIN SUCCESSFUL...
All test cases passed
```

## 📝 Code Structure

### Configuration Section
```java
// WebDriver path
private static final String CHROME_DRIVER_PATH = "/usr/bin/chromedriver";

// Application URL
private static final String BASE_URL = "http://demo.guru99.com/test/newtours/";

// Timeouts
private static final Duration WAIT_TIMEOUT = Duration.ofSeconds(10);

// Test credentials
private static final String TEST_USERNAME = "userName";
private static final String TEST_PASSWORD = "password";

// Expected results
private static final String EXPECTED_TITLE = "Login: Mercury Tours";
```

### Test Flow
```java
public void runLoginTest() {
    try {
        setupDriver();              // Initialize WebDriver
        navigateToLoginPage();      // Open URL
        performLogin(user, pass);   // Fill and submit form
        verifyLoginSuccess();       // Check results
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        tearDown();                 // Clean up
    }
}
```

### Helper Methods
Each step is broken into focused methods:
- `setupDriver()`: Initialize Chrome and WebDriverWait
- `navigateToLoginPage()`: Navigate to URL
- `performLogin()`: Complete login flow
- `enterUsername()`: Fill username field with wait
- `enterPassword()`: Fill password field
- `clickSubmitButton()`: Submit form
- `verifyLoginSuccess()`: Validate page title
- `tearDown()`: Close browser

## 🎯 Element Location Strategy

### Username Field
```java
WebElement usernameField = wait.until(
    ExpectedConditions.visibilityOfElementLocated(By.name("userName"))
);
usernameField.sendKeys(username);
```

**Why explicit wait?**
- Page may take time to load
- Element might be present but not yet visible
- Prevents `NoSuchElementException`

### Alternative Locators
```java
// By ID
By.id("username")

// By CSS Selector
By.cssSelector("input[name='userName']")

// By XPath
By.xpath("//input[@name='userName']")
```

## 🔧 Requirements

### System Requirements
- Java JDK 8+
- ChromeDriver installed
- Chrome browser
- Internet connection (for demo site)

### Selenium WebDriver
```bash
# Ubuntu/Debian
sudo apt-get install libselenium-java

# Or download manually from:
# https://www.selenium.dev/downloads/
```

## ⚙️ Configuration

### Update ChromeDriver Path

**Linux:**
```java
private static final String CHROME_DRIVER_PATH = "/usr/bin/chromedriver";
```

**Windows:**
```java
private static final String CHROME_DRIVER_PATH = 
    "C:\\Users\\YourName\\drivers\\chromedriver.exe";
```

**macOS:**
```java
private static final String CHROME_DRIVER_PATH = 
    "/usr/local/bin/chromedriver";
```

### Chrome Options
```java
ChromeOptions options = new ChromeOptions();
options.addArguments("--start-maximized");
options.addArguments("--headless");  // Run without UI
options.addArguments("--disable-gpu");
options.addArguments("--no-sandbox");
driver = new ChromeDriver(options);
```

## 🎯 Learning Objectives

1. Selenium WebDriver initialization
2. Element location strategies
3. Explicit waits vs implicit waits
4. Form automation patterns
5. Verification techniques
6. Clean code practices in test automation
7. Error handling in automation scripts

## 🎨 Enhancement Ideas

1. **TestNG Integration**
   ```java
   @Test
   public void testLogin() {
       runLoginTest();
   }
   
   @DataProvider
   public Object[][] credentials() {
       return new Object[][] {
           {"user1", "pass1"},
           {"user2", "pass2"}
       };
   }
   ```

2. **Page Object Model**
   ```java
   public class LoginPage {
       WebDriver driver;
       By usernameField = By.name("userName");
       By passwordField = By.name("password");
       By submitButton = By.name("submit");
       
       public void login(String user, String pass) {
           driver.findElement(usernameField).sendKeys(user);
           driver.findElement(passwordField).sendKeys(pass);
           driver.findElement(submitButton).click();
       }
   }
   ```

3. **Screenshot on Failure**
   ```java
   public void captureScreenshot(String filename) {
       File screenshot = ((TakesScreenshot) driver)
           .getScreenshotAs(OutputType.FILE);
       FileUtils.copyFile(screenshot, 
           new File("screenshots/" + filename + ".png"));
   }
   ```

4. **Logging**
   ```java
   import org.apache.logging.log4j.Logger;
   
   Logger logger = LogManager.getLogger(GuruWebpageLogin.class);
   logger.info("Navigating to login page");
   logger.error("Login failed", exception);
   ```

5. **Multiple Browsers**
   ```java
   public WebDriver initDriver(String browser) {
       switch(browser.toLowerCase()) {
           case "chrome":
               return new ChromeDriver();
           case "firefox":
               return new FirefoxDriver();
           case "edge":
               return new EdgeDriver();
           default:
               throw new IllegalArgumentException("Browser not supported");
       }
   }
   ```

## ⚠️ Common Issues

### ChromeDriver Version Mismatch
```bash
# Check Chrome version
google-chrome --version

# Download matching ChromeDriver from:
# https://chromedriver.chromium.org/downloads
```

### Element Not Interactable
```java
// Wait for element to be clickable
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
WebElement element = wait.until(
    ExpectedConditions.elementToBeClickable(By.name("submit"))
);
element.click();
```

### Timeout Exception
- Increase wait duration
- Check network speed
- Verify element locator is correct
- Check if element is in iframe

## 🔍 Debugging Tips

```java
// Print current URL
System.out.println("Current URL: " + driver.getCurrentUrl());

// Print page source
System.out.println(driver.getPageSource());

// Check if element exists
List<WebElement> elements = driver.findElements(By.name("userName"));
System.out.println("Found " + elements.size() + " elements");

// Get element attributes
WebElement element = driver.findElement(By.name("userName"));
System.out.println("Type: " + element.getAttribute("type"));
System.out.println("Value: " + element.getAttribute("value"));
```

## 📚 Resources

- [Selenium WebDriver Documentation](https://www.selenium.dev/documentation/webdriver/)
- [Guru99 Selenium Tutorial](https://www.guru99.com/selenium-tutorial.html)
- [Explicit Waits](https://www.selenium.dev/documentation/webdriver/waits/)
- [Element Location Strategies](https://www.selenium.dev/documentation/webdriver/elements/finders/)
