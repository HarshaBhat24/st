# Database Connection Testing Project

JUnit 5 test suite for validating MySQL database connectivity and operations using JDBC.

## 📋 Overview

This project demonstrates:
- JDBC connection establishment and management
- Database connection validation testing
- SQL query execution testing
- Proper resource cleanup with try-with-resources

## 🏗️ Project Structure

```
db/
├── README.md                      # This file
├── dbconnect.java                 # Database connection test class
└── DatabaseConnectionTest.class   # Compiled test class
```

## 🚀 Features

### Connection Management
- JDBC driver loading
- Connection pooling ready
- Timeout configuration
- Automatic connection cleanup

### Test Cases
1. **Connection Validation**: Verifies connection is not null
2. **Connection Health Check**: Tests connection validity
3. **Query Execution**: Executes simple SELECT query

## ⚙️ Configuration

### Database Settings (Modify in code as needed)
```java
JDBC_DRIVER = "com.mysql.cj.jdbc.Driver"
DATABASE_URL = "jdbc:mysql://localhost:3306/testdb"
DATABASE_USER = "root"
DATABASE_PASSWORD = "root"
CONNECTION_TIMEOUT_SECONDS = 5
```

## 🛠️ Setup Instructions

### 1. Install MySQL Server
```bash
# Ubuntu/Debian
sudo apt-get install mysql-server

# Start MySQL service
sudo systemctl start mysql
```

### 2. Create Test Database
```sql
mysql -u root -p
CREATE DATABASE testdb;
USE testdb;

-- Optional: Create a test table
CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100),
    email VARCHAR(100)
);
```

### 3. Install MySQL JDBC Driver
```bash
# Download MySQL Connector/J
wget https://dev.mysql.com/get/Downloads/Connector-J/mysql-connector-j-8.2.0.tar.gz
tar -xzf mysql-connector-j-8.2.0.tar.gz

# Or use system package manager
sudo apt-get install libmysql-java
```

## 💻 How to Run

### Compile and Run
```bash
# Compile with dependencies
javac -cp ".:/usr/share/java/junit5.jar:/usr/share/java/mysql-connector.jar" dbconnect.java

# Run tests
java -cp ".:/usr/share/java/junit5.jar:/usr/share/java/mysql-connector.jar" \
  org.junit.platform.console.ConsoleLauncher --select-class DatabaseConnectionTest
```

## 📝 Code Example

```java
// Establish connection
Connection conn = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/testdb",
    "root",
    "password"
);

// Check if valid
if (conn.isValid(5)) {
    System.out.println("Connection successful!");
}

// Execute query
try (Statement stmt = conn.createStatement()) {
    ResultSet rs = stmt.executeQuery("SELECT 1");
    if (rs.next()) {
        System.out.println("Query executed successfully");
    }
}

// Connection auto-closes with try-with-resources
```

## 🎯 Learning Objectives

1. JDBC connection establishment
2. Database connection testing best practices
3. Resource management with try-with-resources
4. SQL query execution and result processing
5. JUnit lifecycle methods (@BeforeAll, @AfterAll)

## 🔧 Requirements

- Java JDK 11+
- MySQL Server 8.0+
- MySQL Connector/J 8.x
- JUnit 5.x

## ⚠️ Troubleshooting

### Connection Refused
- Ensure MySQL server is running: `sudo systemctl status mysql`
- Check if port 3306 is accessible: `netstat -an | grep 3306`

### Authentication Failed
- Verify username and password
- Check MySQL user privileges: `GRANT ALL ON testdb.* TO 'root'@'localhost';`

### ClassNotFoundException
- Ensure MySQL JDBC driver is in classpath
- Verify driver JAR file location

## 📚 Resources

- [MySQL JDBC Tutorial](https://dev.mysql.com/doc/connector-j/en/)
- [JDBC API Documentation](https://docs.oracle.com/javase/8/docs/api/java/sql/package-summary.html)
