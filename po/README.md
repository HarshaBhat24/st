# Page Object Counter

Selenium WebDriver program that counts various web elements (links, inputs, buttons, images, dropdowns) on a webpage.

## 📋 Overview

This project demonstrates:
- Counting different types of web elements
- Selenium WebDriver element location by tag name
- Page analysis and element statistics
- Practical web scraping patterns

## 🏗️ Project Structure

```
po/
├── README.md
├── pom.xml                   # Maven configuration
├── posel.java               # Page object counter (main class)
├── src/
│   └── main/                # Empty (source in root)
└── target/                  # Build output
```

## 🚀 Features

### Element Counting
Identifies and counts:
- **Links** (`<a>` tags)
- **Input Fields** (`<input>` tags - text, password, email, etc.)
- **Buttons** (`<button>` tags)
- **Images** (`<img>` tags)
- **Dropdowns** (`<select>` tags)
- **Total Objects**: Sum of all above

### Sample Target
Default URL: Gmail login page (`https://mail.google.com/`)

## 💻 How to Run

### Method 1: Maven
```bash
cd po
mvn clean compile
mvn exec:java -Dexec.mainClass="po.CountWebPageObjects"
```

### Method 2: Manual Compilation
```bash
# Compile
javac -cp ".:/usr/share/java/selenium/*" posel.java

# Run (update classpath as needed)
java -cp ".:/usr/share/java/selenium/*:." po.CountWebPageObjects
```

### Expected Output
```
Launching Chrome...
Number of Links: 15
Number of Input fields: 8
Number of Buttons: 3
Number of Images: 12
Number of Dropdowns: 2
Total Number of Objects on the Page: 40
```

## 📝 Code Walkthrough

### 1. WebDriver Setup
```java
System.setProperty("webdriver.chrome.driver", 
    "C:\\Users\\driver\\chromedriver.exe");  // Update path
WebDriver driver = new ChromeDriver();
driver.manage().window().maximize();
```

### 2. Element Counting
```java
// Count by tag name
List<WebElement> links = driver.findElements(By.tagName("a"));
List<WebElement> inputs = driver.findElements(By.tagName("input"));
List<WebElement> buttons = driver.findElements(By.tagName("button"));
List<WebElement> images = driver.findElements(By.tagName("img"));
List<WebElement> dropdowns = driver.findElements(By.tagName("select"));

// Print results
System.out.println("Number of Links: " + links.size());
```

### 3. Total Calculation
```java
int totalObjects = links.size() + inputs.size() + buttons.size() 
                 + images.size() + dropdowns.size();
System.out.println("Total Objects: " + totalObjects);
```

## 🔧 Requirements

### System Requirements
- Java JDK 11+
- Maven 3.6+
- ChromeDriver (update path in code)

### Dependencies
```xml
<dependency>
    <groupId>org.seleniumhq.selenium</groupId>
    <artifactId>selenium-java</artifactId>
    <version>4.27.0</version>
</dependency>
```

## ⚙️ Configuration

### Update ChromeDriver Path
For Linux:
```java
System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
```

For Windows:
```java
System.setProperty("webdriver.chrome.driver", 
    "C:\\path\\to\\chromedriver.exe");
```

For macOS:
```java
System.setProperty("webdriver.chrome.driver", 
    "/usr/local/bin/chromedriver");
```

### Test Different Websites
```java
// Amazon
driver.get("https://www.amazon.com/");

// Your application
driver.get("http://localhost:3000/");

// Any public website
driver.get("https://example.com/");
```

## 📊 Sample Results

### Gmail Login Page
```
Links: 15
Input fields: 8 (username, password, hidden fields)
Buttons: 3 (Sign in, Create account, etc.)
Images: 12 (Google logo, icons)
Dropdowns: 2 (language selector)
Total: 40
```

### Amazon Homepage
```
Links: 200+
Input fields: 20+ (search, filters)
Buttons: 50+
Images: 100+
Dropdowns: 10+ (categories, filters)
Total: 380+
```

## 🎯 Learning Objectives

1. Selenium WebDriver basics
2. Element location by tag name
3. Working with WebElement collections
4. Page analysis techniques
5. Try-finally resource management
6. Maven project structure

## 🎨 Enhancement Ideas

1. **Detailed Analysis**
   ```java
   // Count input types separately
   int textInputs = 0, passwordInputs = 0, emailInputs = 0;
   for (WebElement input : inputs) {
       String type = input.getAttribute("type");
       if (type.equals("text")) textInputs++;
       else if (type.equals("password")) passwordInputs++;
       else if (type.equals("email")) emailInputs++;
   }
   ```

2. **Link Analysis**
   ```java
   // External vs internal links
   int internalLinks = 0, externalLinks = 0;
   String currentDomain = driver.getCurrentUrl();
   for (WebElement link : links) {
       String href = link.getAttribute("href");
       if (href.contains(currentDomain)) {
           internalLinks++;
       } else {
           externalLinks++;
       }
   }
   ```

3. **Export Results**
   ```java
   // Write to CSV
   FileWriter writer = new FileWriter("page-analysis.csv");
   writer.write("Element Type,Count\n");
   writer.write("Links," + links.size() + "\n");
   // ... more rows
   writer.close();
   ```

4. **Multiple Pages**
   ```java
   String[] urls = {"https://google.com", "https://amazon.com"};
   for (String url : urls) {
       driver.get(url);
       analyzePageElements();
   }
   ```

5. **Additional Element Types**
   ```java
   // Forms, tables, divs, spans, etc.
   List<WebElement> forms = driver.findElements(By.tagName("form"));
   List<WebElement> tables = driver.findElements(By.tagName("table"));
   List<WebElement> textareas = driver.findElements(By.tagName("textarea"));
   ```

## ⚠️ Common Issues

### Stale Element Exception
```java
// If page updates dynamically, re-find elements
try {
    int count = links.size();
} catch (StaleElementReferenceException e) {
    links = driver.findElements(By.tagName("a"));
    int count = links.size();
}
```

### Hidden Elements
```java
// Count only visible elements
int visibleLinks = 0;
for (WebElement link : links) {
    if (link.isDisplayed()) {
        visibleLinks++;
    }
}
```

### Dynamic Content
```java
// Wait for page to load completely
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
wait.until(webDriver -> 
    ((JavascriptExecutor) webDriver)
        .executeScript("return document.readyState").equals("complete")
);
```

## 🔍 Element Attributes to Explore

```java
for (WebElement element : links) {
    String href = element.getAttribute("href");
    String text = element.getText();
    String id = element.getAttribute("id");
    String className = element.getAttribute("class");
    boolean isDisplayed = element.isDisplayed();
    boolean isEnabled = element.isEnabled();
}
```

## 📚 Resources

- [Selenium By.tagName Documentation](https://www.selenium.dev/documentation/webdriver/elements/finders/)
- [HTML Tags Reference](https://www.w3schools.com/tags/)
- [Web Element Interface](https://www.selenium.dev/selenium/docs/api/java/org/openqa/selenium/WebElement.html)
