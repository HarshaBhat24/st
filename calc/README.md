# Calculator Unit Testing Project

A comprehensive JUnit 5 based calculator implementation demonstrating test-driven development and nested test organization.

## 📋 Overview

This project showcases:
- Basic arithmetic operations with proper error handling
- JUnit 5 nested test classes for organized test suites
- Parameterized testing approaches
- Exception testing patterns

## 🏗️ Project Structure

```
calc/
├── README.md                      # This file
├── CalculatorTest.java            # Main test class with Calculator implementation
├── CalculatorTest.class           # Compiled test class
└── CalculatorTest$Calculator.class # Compiled inner class
```

## 🚀 Features

### Calculator Operations
- **Addition**: Handles positive, negative, and zero values
- **Subtraction**: Supports all integer combinations
- **Multiplication**: Includes zero handling
- **Division**: With division-by-zero protection

### Test Organization
- **Nested Test Classes**: Tests grouped by operation type
- **DisplayName Annotations**: Readable test descriptions
- **BeforeEach Setup**: Consistent test initialization

## 🧪 Test Cases

### Addition Tests
- Adding two positive numbers
- Adding negative and positive numbers

### Subtraction Tests
- Subtracting two positive numbers
- Subtracting from a negative number

### Multiplication Tests
- Multiplying two positive numbers
- Multiplying by zero

### Division Tests
- Dividing two positive numbers
- Division by zero exception handling

## 💻 How to Run

### Using JUnit Console Launcher
```bash
# Compile
javac -cp ".:/usr/share/java/junit5.jar" CalculatorTest.java

# Run all tests
java -cp ".:/usr/share/java/junit5.jar" org.junit.platform.console.ConsoleLauncher \
  --select-class calc.CalculatorTest

# Run specific nested class
java -cp ".:/usr/share/java/junit5.jar" org.junit.platform.console.ConsoleLauncher \
  --select-class calc.CalculatorTest$AdditionTests
```

### Using IDE
- Import as Java project
- Ensure JUnit 5 is in classpath
- Right-click `CalculatorTest.java` → Run as JUnit Test

## 📝 Code Example

```java
Calculator calc = new Calculator();
int result = calc.add(2, 3);  // Returns 5

// Division with error handling
try {
    calc.divide(10, 0);
} catch (ArithmeticException e) {
    System.out.println("Cannot divide by zero");
}
```

## 🎯 Learning Objectives

1. Understanding JUnit 5 annotations
2. Organizing tests with nested classes
3. Testing edge cases and exceptions
4. Following AAA pattern (Arrange-Act-Assert)

## 🔧 Requirements

- Java JDK 11 or higher
- JUnit 5.x
- No external dependencies

## 📚 Resources

- [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/)
- [JUnit 5 Nested Tests](https://junit.org/junit5/docs/current/user-guide/#writing-tests-nested)
