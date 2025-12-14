# Quick Reference - Common Tasks

A cheat sheet for frequently used commands and tasks in this workspace.

## 📦 Maven Commands

```bash
# Clean build artifacts
mvn clean

# Compile code
mvn compile

# Run tests
mvn test

# Package as JAR
mvn package

# Run main class
mvn exec:java -Dexec.mainClass="fully.qualified.ClassName"

# Skip tests during build
mvn clean install -DskipTests

# View dependency tree
mvn dependency:tree
```

## 🧪 Running Tests

### JUnit 5 (calc, db)
```bash
cd calc   # or db
mvn clean test

# View test report
xdg-open target/surefire-reports/index.html
```

### TestNG (cross, fio, number_of_chechbox)
```bash
cd cross   # or fio, number_of_chechbox
mvn clean test

# View TestNG report
xdg-open target/surefire-reports/index.html
```

## 🚀 Running Applications

### Console Applications
```bash
# Matrix Multiplication
cd matrixmul
mvn clean compile exec:java

# Or create JAR and run
mvn clean package
java -jar target/matrix-multiplier-1.0-SNAPSHOT.jar
```

### Selenium Applications
```bash
# Page Object Counter
cd po
mvn clean compile exec:java

# Login Automation
cd websel
mvn clean compile exec:java
```

### Web Applications
```bash
# Login form
cd login
xdg-open index.html

# Or with local server
python3 -m http.server 8000
# Then open: http://localhost:8000
```

## 🔍 Troubleshooting

### ChromeDriver Issues
```bash
# Check ChromeDriver version
/usr/bin/chromedriver --version

# Check Chrome version
google-chrome --version

# Install ChromeDriver (Ubuntu/Debian)
sudo apt-get install chromium-chromedriver
```

### MySQL Connection Issues
```bash
# Check if MySQL is running
sudo systemctl status mysql

# Start MySQL
sudo systemctl start mysql

# Connect to MySQL
mysql -u root -p
```

### Maven Issues
```bash
# Update Maven
sudo apt-get update
sudo apt-get install maven

# Check Maven version
mvn -version

# Force update dependencies
mvn clean install -U
```

## 📂 File Organization

### Clean Up Build Artifacts
```bash
# Clean all Maven projects
cd /home/harsha/Downloads
for dir in calc cross db fio matrixmul number_of_chechbox po selenium-test websel; do
    cd $dir && mvn clean && cd ..
done
```

### Remove Old Class Files
```bash
# Remove compiled .class files from root directories
cd /home/harsha/Downloads
find . -name "*.class" -type f -delete
```

## 🎨 Code Quality

### Format Java Code
```bash
# Using IDE: Right-click -> Format or Ctrl+Shift+F

# Maven plugin (add to pom.xml):
<plugin>
    <groupId>com.spotify.fmt</groupId>
    <artifactId>fmt-maven-plugin</artifactId>
    <version>2.21.1</version>
</plugin>

# Run formatting
mvn fmt:format
```

## 📊 Test Coverage

### Add JaCoCo for Coverage Reports
Add to pom.xml:
```xml
<plugin>
    <groupId>org.jacoco</groupId>
    <artifactId>jacoco-maven-plugin</artifactId>
    <version>0.8.11</version>
    <executions>
        <execution>
            <goals>
                <goal>prepare-agent</goal>
            </goals>
        </execution>
        <execution>
            <id>report</id>
            <phase>test</phase>
            <goals>
                <goal>report</goal>
            </goals>
        </execution>
    </executions>
</plugin>
```

Run coverage:
```bash
mvn clean test
xdg-open target/site/jacoco/index.html
```

## 🌐 Browser Configuration

### Headless Chrome
Add to Java code:
```java
ChromeOptions options = new ChromeOptions();
options.addArguments("--headless");
options.addArguments("--no-sandbox");
options.addArguments("--disable-dev-shm-usage");
WebDriver driver = new ChromeDriver(options);
```

## 📝 Git Commands (Recommended)

```bash
# Initialize repository
cd /home/harsha/Downloads
git init

# Create .gitignore
cat > .gitignore << EOF
# Maven
target/
pom.xml.tag
pom.xml.releaseBackup
pom.xml.versionsBackup

# Java
*.class
*.jar
*.war

# IDE
.idea/
.vscode/
*.iml
.project
.classpath
.settings/

# OS
.DS_Store
Thumbs.db
EOF

# Add files
git add .

# Commit
git commit -m "Initial commit: Restructured workspace"
```

## 🔐 Security Notes

### Update Passwords
```bash
# Search for hardcoded passwords
grep -r "password" --include="*.java"

# Replace with environment variables:
String password = System.getenv("DB_PASSWORD");
```

## 📈 Performance Tips

### Parallel Test Execution
Add to surefire plugin in pom.xml:
```xml
<configuration>
    <parallel>classes</parallel>
    <threadCount>4</threadCount>
</configuration>
```

### Increase Memory
```bash
# For Maven
export MAVEN_OPTS="-Xmx1024m"

# For Java
java -Xmx1024m -jar application.jar
```

## 🎓 Learning Workflow

### Recommended Order
```bash
# 1. Start with basics
cd calc && mvn test

# 2. Try console app
cd ../matrixmul && mvn exec:java

# 3. Database testing
cd ../db && mvn test

# 4. Web basics
cd ../login && xdg-open index.html

# 5. Selenium basics
cd ../websel && mvn exec:java

# 6. Advanced Selenium
cd ../cross && mvn test
```

## 📞 Support Resources

- **Stack Overflow**: [stackoverflow.com](https://stackoverflow.com)
- **Maven Issues**: [maven.apache.org/users](https://maven.apache.org/users/index.html)
- **Selenium Forum**: [selenium.dev/support](https://www.selenium.dev/support/)
- **JUnit Discord**: Join from junit.org

---

**Tip**: Bookmark this file for quick reference!
