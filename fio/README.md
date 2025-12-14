# Excel File I/O Testing

TestNG project for reading from and writing to Excel files using the JXL (Java Excel) library.

## 📋 Overview

This project demonstrates:
- Reading data from Excel files (.xls format)
- Processing data programmatically
- Writing results to new Excel files
- Automated test data creation
- File I/O operations with TestNG

## 🏗️ Project Structure

```
fio/
├── README.md
├── pom.xml                              # Maven configuration
├── src/
│   └── test/
│       ├── java/
│       │   └── ExcelTest.java          # Excel operations test
│       └── resources/
│           └── excel/
│               ├── Students.xls        # Input file (auto-generated)
│               └── Result.xls          # Output file
└── target/                              # Build output
    └── surefire-reports/                # Test reports
```

## 🚀 Features

### File Operations
- **Auto-generates sample data** if Students.xls doesn't exist
- **Reads Excel sheets** with multiple rows/columns
- **Processes data** (pass/fail based on marks)
- **Writes formatted output** with results

### Sample Data
| Name    | Roll No | Marks | Result |
|---------|---------|-------|--------|
| John    | 101     | 45    | Pass   |
| Jane    | 102     | 32    | Fail   |
| Bob     | 103     | 67    | Pass   |
| Alice   | 104     | 28    | Fail   |
| Charlie | 105     | 89    | Pass   |

**Passing Criteria**: Marks > 35

## 💻 How to Run

### Execute Test
```bash
cd fio
mvn clean test
```

### Expected Output
```
Setting up before running Excel test...
Creating sample Students.xls file...
Sample file created successfully!
Records successfully updated in src/test/resources/excel/Result.xls

===============================================
Surefire suite
Total tests run: 1, Passes: 1, Failures: 0, Skips: 0
===============================================
```

### View Results
The output file `Result.xls` will contain all original data plus a new "Result" column.

## 📝 Code Walkthrough

### 1. Setup Phase (@BeforeClass)
```java
@BeforeClass
public void setUp() {
    // Check if input file exists
    // If not, create sample Students.xls with test data
    // Add headers and student records
}
```

### 2. Test Execution (@Test)
```java
@Test
public void testImportExport() {
    // 1. Read from Students.xls
    // 2. Copy all data to Result.xls
    // 3. Process marks (Pass if > 35, else Fail)
    // 4. Add Result column
    // 5. Save output file
}
```

### 3. Data Processing Logic
```java
for (int i = 1; i < sheet.getRows(); i++) {
    String markStr = sheet.getCell(2, i).getContents();
    int marks = Integer.parseInt(markStr);
    String result = (marks > 35) ? "Pass" : "Fail";
    writableSheet.addCell(new Label(3, i, result));
}
```

## 🔧 Requirements

### System Requirements
- Java JDK 11+
- Maven 3.6+

### Dependencies (in pom.xml)
```xml
<dependency>
    <groupId>net.sourceforge.jexcelapi</groupId>
    <artifactId>jxl</artifactId>
    <version>2.6.12</version>
</dependency>
<dependency>
    <groupId>org.testng</groupId>
    <artifactId>testng</artifactId>
    <version>7.8.0</version>
</dependency>
```

## 📊 JXL Library Classes

### Reading Excel Files
```java
FileInputStream fi = new FileInputStream("input.xls");
Workbook workbook = Workbook.getWorkbook(fi);
Sheet sheet = workbook.getSheet(0);

// Get cell value
String value = sheet.getCell(column, row).getContents();
```

### Writing Excel Files
```java
FileOutputStream fo = new FileOutputStream("output.xls");
WritableWorkbook workbook = Workbook.createWorkbook(fo);
WritableSheet sheet = workbook.createSheet("Sheet1", 0);

// Add text cell
Label label = new Label(column, row, "Text");
sheet.addCell(label);

// Add number cell
Number number = new Number(column, row, 100);
sheet.addCell(number);

// Save and close
workbook.write();
workbook.close();
```

## 🎯 Learning Objectives

1. Excel file manipulation in Java
2. JXL library usage
3. TestNG lifecycle methods
4. File I/O best practices
5. Data-driven testing concepts
6. Resource management

## 🎨 Enhancement Ideas

1. **Multiple Sheets**: Process multiple worksheets
2. **Formulas**: Add Excel formulas for calculations
3. **Formatting**: Apply cell colors, fonts, borders
4. **Validation**: Check data types before processing
5. **Error Handling**: Handle corrupted or missing files
6. **CSV Support**: Add CSV import/export
7. **Apache POI**: Migrate to Apache POI for .xlsx support
8. **Parameterization**: Read test data from Excel for tests

## 🔄 File Format Support

### JXL Library
- ✅ Read: `.xls` (Excel 97-2003)
- ✅ Write: `.xls` (Excel 97-2003)
- ❌ `.xlsx` (Excel 2007+) not supported

### For .xlsx Support
Use Apache POI library instead:
```xml
<dependency>
    <groupId>org.apache.poi</groupId>
    <artifactId>poi-ooxml</artifactId>
    <version>5.2.5</version>
</dependency>
```

## ⚠️ Common Issues

### File Not Found
- Ensure `src/test/resources/excel/` directory exists
- Check file permissions
- Run from project root directory

### File Locked
- Close Excel if file is open
- Check if another process is using the file

### OutOfMemoryError
- For large files, increase heap size: `mvn test -DargLine="-Xmx1024m"`

## 📚 Resources

- [JXL API Documentation](http://jexcelapi.sourceforge.net/)
- [TestNG @BeforeClass Documentation](https://testng.org/doc/documentation-main.html#annotations)
- [Apache POI (for .xlsx)](https://poi.apache.org/)
