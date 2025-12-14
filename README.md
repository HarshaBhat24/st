# Downloads Workspace - Java & Web Projects

A collection of Java testing projects (Selenium, JUnit, TestNG) and web development examples organized for learning and practice.

## 📁 Project Structure

### Java Testing Projects

#### 1. **calc/** - Calculator Unit Testing
JUnit 5 based calculator implementation with comprehensive test coverage using nested test classes.

**Key Features:**
- Basic arithmetic operations (add, subtract, multiply, divide)
- Nested test organization by operation type
- Exception handling for edge cases

**How to Run:**
```bash
cd calc
javac -cp ".:/usr/share/java/junit5.jar" CalculatorTest.java
java -cp ".:/usr/share/java/junit5.jar" org.junit.platform.console.ConsoleLauncher --select-class CalculatorTest
```

#### 2. **cross/** - Cross-Browser Testing with Selenium
TestNG-based cross-browser testing framework supporting Chrome, Firefox, and Edge.

**Key Features:**
- Parameterized browser testing
- Base test class for setup/teardown
- Google search test example

**How to Run:**
```bash
cd cross
mvn clean test
```

#### 3. **db/** - Database Connection Testing
JUnit 5 tests for MySQL database connectivity and operations.

**Key Features:**
- JDBC connection validation
- Connection pooling best practices
- SQL query execution tests

**Setup Required:**
- MySQL server running on localhost:3306
- Database: `testdb`
- Credentials: root/root

**How to Run:**
```bash
cd db
javac -cp ".:/usr/share/java/junit5.jar:/usr/share/java/mysql-connector.jar" dbconnect.java
```

#### 4. **fio/** - Excel File I/O Operations
TestNG tests for reading and writing Excel files using JXL library.

**Key Features:**
- Read student data from Excel
- Process marks and generate results
- Export results to new Excel file

**How to Run:**
```bash
cd fio
mvn clean test
```

#### 5. **matrixmul/** - Matrix Multiplication
Console-based Java application for matrix multiplication.

**Key Features:**
- Dynamic matrix size input
- Dimension validation
- Result calculation and display

**How to Run:**
```bash
cd matrixmul
javac matrixmul.java
java matrixmul.matrixmul
```

#### 6. **number_of_chechbox/** - Checkbox Counter
Selenium test to count and analyze checkboxes on a webpage.

**Key Features:**
- Dynamic checkbox detection
- Count checked vs unchecked boxes
- TestNG integration

**How to Run:**
```bash
cd number_of_chechbox
mvn clean test
```

#### 7. **po/** - Page Object Counter
Selenium script to count various web elements (links, buttons, images, etc.).

**Key Features:**
- Count links, inputs, buttons, images, dropdowns
- Gmail page analysis example
- Total object count summary

**How to Run:**
```bash
cd po
mvn compile exec:java -Dexec.mainClass="po.CountWebPageObjects"
```

#### 8. **websel/** - Selenium Login Automation
Standalone Selenium test for login page automation.

**Key Features:**
- Login form automation
- Explicit waits
- Success/failure verification

**How to Run:**
```bash
cd websel
javac -cp ".:/usr/share/selenium/*" GuruWebpageLogin.java
java -cp ".:/usr/share/selenium/*" GuruWebpageLogin
```

#### 9. **selenium-test/** - Selenium Test Framework
Maven-based Selenium project template.

**How to Run:**
```bash
cd selenium-test
mvn clean test
```

### Web Development Projects

#### 10. **login/** - Login Form with Validation
Pure HTML/CSS/JavaScript login form with client-side validation.

**Key Features:**
- 3 login attempts with lockout
- Input validation
- Success page redirect
- Credentials: Username=`Form`, Password=`123`

**How to Run:**
Open `login/index.html` in a web browser

## 🛠️ Prerequisites

### For Java Projects:
- Java JDK 11 or higher
- Maven 3.6+
- JUnit 5 (for unit tests)
- TestNG 7.8+ (for some test projects)

### For Selenium Projects:
- ChromeDriver installed at `/usr/bin/chromedriver`
- Selenium WebDriver 4.x
- Supported browsers installed

### For Database Projects:
- MySQL Server 8.0+
- JDBC Driver for MySQL

## 📚 Learning Path

1. **Start with:** `calc/` - Learn unit testing basics
2. **Move to:** `db/` - Understand database testing
3. **Practice:** `matrixmul/` - Core Java algorithms
4. **Learn Selenium:** `websel/` - Basic automation
5. **Advanced:** `cross/` - Cross-browser testing
6. **Page Objects:** `po/` - Element counting
7. **Data-driven:** `fio/` - Excel integration
8. **Web Dev:** `login/` - Frontend validation

## 📖 Additional Resources

- [JUnit 5 Documentation](https://junit.org/junit5/docs/current/user-guide/)
- [TestNG Documentation](https://testng.org/doc/)
- [Selenium Documentation](https://www.selenium.dev/documentation/)
- [Maven Getting Started](https://maven.apache.org/guides/getting-started/)

## 🤝 Contributing

Feel free to add more test cases, improve existing code, or add new projects to this workspace.

## 📝 Notes

- Update ChromeDriver path in files if your installation differs
- Modify database credentials in `db/dbconnect.java` as needed
- Some projects contain compiled `.class` files - these can be cleaned using Maven or manual deletion
