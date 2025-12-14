# Matrix Multiplication Program

A console-based Java application for performing matrix multiplication with dimension validation.

## 📋 Overview

This program demonstrates:
- User input handling with Scanner
- 2D array manipulation
- Matrix multiplication algorithm
- Input validation and error handling

## 🏗️ Project Structure

```
matrixmul/
├── README.md          # This file
└── matrixmul.java     # Main program file
```

## 🚀 Features

- **Dynamic Matrix Input**: User defines matrix dimensions
- **Dimension Validation**: Checks if multiplication is possible (M1 columns = M2 rows)
- **Interactive Console**: Step-by-step input prompts
- **Result Display**: Formatted output of resultant matrix

## 🧮 Matrix Multiplication Rules

For matrices A (m×n) and B (o×p):
- Multiplication is possible only if **n = o**
- Result matrix will be of size **m×p**
- Each element: `C[i][j] = Σ(A[i][k] × B[k][j])` for k from 0 to n-1

## 💻 How to Run

### Compile and Execute
```bash
cd matrixmul
javac matrixmul.java
java matrixmul.matrixmul
```

### Sample Execution
```
Enter number of rows in M1: 2
Enter number of columns in M1: 3
Enter number of rows in M2: 3
Enter number of columns in M2: 2

Enter elements of Matrix A:
A[0][0] : 1
A[0][1] : 2
A[0][2] : 3
A[1][0] : 4
A[1][1] : 5
A[1][2] : 6

Enter elements of Matrix B:
B[0][0] : 7
B[0][1] : 8
B[1][0] : 9
B[1][1] : 10
B[2][0] : 11
B[2][1] : 12

Resultant Matrix:
58 64
139 154
```

## 📝 Algorithm Explanation

```java
// For each element in result matrix
for (int i = 0; i < rows_A; i++) {
    for (int j = 0; j < cols_B; j++) {
        result[i][j] = 0;
        // Multiply and sum
        for (int k = 0; k < cols_A; k++) {
            result[i][j] += A[i][k] * B[k][j];
        }
    }
}
```

**Time Complexity**: O(m × p × n)  
**Space Complexity**: O(m × p) for result matrix

## 🎯 Learning Objectives

1. Understanding 2D arrays in Java
2. Matrix multiplication algorithm implementation
3. User input validation
4. Nested loop optimization
5. Scanner class usage

## 🔧 Requirements

- Java JDK 8 or higher
- No external dependencies

## 🎨 Possible Enhancements

1. **File I/O**: Read matrices from files
2. **Error Handling**: More robust input validation
3. **Matrix Operations**: Add addition, subtraction, transpose
4. **GUI Version**: JavaFX or Swing interface
5. **Performance**: Strassen's algorithm for large matrices
6. **Testing**: Add JUnit test cases

## 📊 Test Cases

### Valid Multiplication
```
Matrix A (2×3):        Matrix B (3×2):        Result (2×2):
[1  2  3]             [7   8]                [58   64]
[4  5  6]             [9  10]                [139  154]
                      [11 12]
```

### Invalid Multiplication
```
Matrix A (2×3)  ×  Matrix B (2×2)
Output: "Matrix Multiplication is not possible (M1 columns ≠ M2 rows)."
```

## 📚 Resources

- [Matrix Multiplication - Khan Academy](https://www.khanacademy.org/math/precalculus/x9e81a4f98389efdf:matrices/x9e81a4f98389efdf:multiplying-matrices-by-matrices/v/matrix-multiplication-intro)
- [Java 2D Arrays Tutorial](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/arrays.html)
