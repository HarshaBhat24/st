# 📚 Workspace Index - Quick Navigation Guide

This workspace contains multiple Java and web projects organized for learning and testing. All projects are documented with individual README files.

---

## 🗂️ Project Directory

### ✅ Java Unit Testing Projects

| Project | Type | Description | Quick Start |
|---------|------|-------------|-------------|
| **calc/** | JUnit 5 | Calculator with comprehensive tests | `cd calc && mvn test` |
| **db/** | JUnit 5 | MySQL database connection testing | `cd db && mvn test` |

### 🌐 Selenium WebDriver Projects

| Project | Framework | Description | Quick Start |
|---------|-----------|-------------|-------------|
| **cross/** | TestNG + Selenium | Cross-browser testing framework | `cd cross && mvn test` |
| **fio/** | TestNG + JXL | Excel file I/O operations | `cd fio && mvn test` |
| **number_of_chechbox/** | TestNG + Selenium | Checkbox counter and analyzer | `cd number_of_chechbox && mvn test` |
| **po/** | Selenium | Page object element counter | `cd po && mvn exec:java` |
| **websel/** | Selenium | Login automation demo | `cd websel && mvn exec:java` |
| **selenium-test/** | Maven Template | Selenium project template | `cd selenium-test && mvn compile` |

### 💻 Console Applications

| Project | Type | Description | Quick Start |
|---------|------|-------------|-------------|
| **matrixmul/** | Java Console | Matrix multiplication program | `cd matrixmul && mvn exec:java` |

### 🎨 Web Development Projects

| Project | Tech Stack | Description | Quick Start |
|---------|-----------|-------------|-------------|
| **login/** | HTML/CSS/JS | Login form with validation | `cd login && open index.html` |

---

## 📖 Documentation Structure

Each project contains:
- **README.md** - Detailed project documentation
  - Overview and features
  - Project structure
  - How to run
  - Configuration instructions
  - Learning objectives
  - Enhancement ideas
  - Troubleshooting guide
  - Resources

---

## 🚀 Quick Start by Learning Path

### Beginner Path
1. **Start Here**: `calc/` - Learn basic JUnit testing
2. **Next**: `matrixmul/` - Practice core Java
3. **Then**: `login/` - Understand web forms

### Database Path
1. `db/` - Database connectivity
2. `fio/` - File I/O with Excel

### Selenium Path
1. `websel/` - Basic Selenium automation
2. `po/` - Element location strategies
3. `number_of_chechbox/` - Element analysis
4. `cross/` - Advanced cross-browser testing

---

## 🛠️ Common Commands

### Maven Projects
```bash
# Clean and compile
mvn clean compile

# Run tests
mvn clean test

# Run main class
mvn exec:java

# View test reports
xdg-open target/surefire-reports/index.html
```

### Standalone Java Files
```bash
# Compile
javac -cp ".:/usr/share/java/*" FileName.java

# Run
java -cp ".:/usr/share/java/*:." FileName
```

### Web Projects
```bash
# Open in browser
xdg-open index.html

# Or use local server
python3 -m http.server 8000
```

---

## 📁 Project File Structure

All Maven projects follow standard structure:
```
project-name/
├── README.md           # Project documentation
├── pom.xml            # Maven configuration
├── src/
│   ├── main/
│   │   ├── java/      # Application code
│   │   └── resources/ # Configuration files
│   └── test/
│       ├── java/      # Test classes
│       └── resources/ # Test resources
└── target/            # Build output (generated)
```

---

## 🎯 Project Status

### ✅ Fully Configured & Documented
- calc/ - Maven + JUnit 5
- cross/ - Maven + TestNG + Selenium
- db/ - Maven + JUnit 5 + MySQL
- fio/ - Maven + TestNG + JXL
- login/ - HTML/CSS/JS
- matrixmul/ - Maven + Java
- number_of_chechbox/ - Maven + TestNG
- po/ - Maven + Selenium
- selenium-test/ - Maven + Selenium
- websel/ - Maven + Selenium

### 📝 Code Structure
- **Properly Packaged**: All Java classes in appropriate packages
- **Well-Documented**: JavaDoc comments and inline documentation
- **Clean Code**: Refactored for readability and maintainability
- **Modern Practices**: Using latest dependencies and patterns

---

## 🔧 System Requirements

### General
- Java JDK 11 or higher
- Maven 3.6+

### For Selenium Projects
- ChromeDriver at `/usr/bin/chromedriver`
- Chrome browser installed
- Internet connection

### For Database Projects
- MySQL Server 8.0+
- MySQL Connector/J 8.x

### For Web Projects
- Modern web browser
- Optional: Python 3 for local server

---

## 📚 Learning Resources

### Java & Testing
- [JUnit 5 Documentation](https://junit.org/junit5/docs/current/user-guide/)
- [TestNG Documentation](https://testng.org/doc/)
- [Maven Getting Started](https://maven.apache.org/guides/getting-started/)

### Selenium
- [Selenium WebDriver Docs](https://www.selenium.dev/documentation/webdriver/)
- [Guru99 Selenium Tutorial](https://www.guru99.com/selenium-tutorial.html)

### Web Development
- [MDN Web Docs](https://developer.mozilla.org/)
- [JavaScript.info](https://javascript.info/)

---

## 🤝 Best Practices Implemented

1. **Maven Standard Directory Layout** - All projects follow conventions
2. **Separation of Concerns** - Tests separated from main code
3. **Configuration Externalization** - Constants at top of files
4. **Proper Error Handling** - Try-catch-finally blocks
5. **Resource Management** - Automatic cleanup with try-with-resources
6. **Documentation** - README files and inline comments
7. **Clean Code** - Descriptive names and single responsibility
8. **Version Control Ready** - .gitignore recommended for target/

---

## 💡 Tips for Navigating

1. **Read the main README.md first** for workspace overview
2. **Check individual project READMEs** for specific instructions
3. **Start with simpler projects** (calc, login) before advanced ones
4. **Test incrementally** - run tests after understanding each project
5. **Modify and experiment** - best way to learn

---

## ⚠️ Important Notes

1. **ChromeDriver Path**: Update in code if your path differs from `/usr/bin/chromedriver`
2. **Database Credentials**: Modify in `db/` project as needed
3. **Build Files**: `target/` directories contain compiled code - can be cleaned with `mvn clean`
4. **Old Class Files**: Some root directories have `.class` files from old compilations - these can be deleted

---

## 🔍 Quick Search Tips

Looking for something specific?

| Want to learn about... | Go to project... |
|------------------------|------------------|
| Unit testing | calc/ |
| Database testing | db/ |
| File I/O | fio/ |
| Form validation | login/ |
| Web automation | websel/ |
| Cross-browser testing | cross/ |
| Element location | po/ |
| TestNG | cross/, fio/, number_of_chechbox/ |
| Console apps | matrixmul/ |

---

## 📧 Need Help?

Each README contains:
- Detailed setup instructions
- Common issues and solutions
- Links to documentation
- Enhancement ideas

Start with the main README.md and drill down into specific projects!

---

**Last Updated**: December 14, 2025
**Total Projects**: 10
**Status**: All projects restructured, documented, and ready for learning
