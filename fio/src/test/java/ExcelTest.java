import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ExcelTest {
private static final String INPUT_FILE = "src/test/resources/excel/Students.xls";
private static final String OUTPUT_FILE = "src/test/resources/excel/Result.xls";
@BeforeClass
public void setUp() throws Exception {
System.out.println("Setting up before running Excel test...");
// Create sample Students.xls file if it doesn't exist
File inputFile = new File(INPUT_FILE);
if (!inputFile.exists()) {
System.out.println("Creating sample Students.xls file...");
FileOutputStream fo = new FileOutputStream(INPUT_FILE);
WritableWorkbook workbook = Workbook.createWorkbook(fo);
WritableSheet sheet = workbook.createSheet("Students", 0);
// Add headers
sheet.addCell(new Label(0, 0, "Name"));
sheet.addCell(new Label(1, 0, "Roll No"));
sheet.addCell(new Label(2, 0, "Marks"));
// Add sample data
sheet.addCell(new Label(0, 1, "John"));
sheet.addCell(new Number(1, 1, 101));
sheet.addCell(new Number(2, 1, 45));
sheet.addCell(new Label(0, 2, "Jane"));
sheet.addCell(new Number(1, 2, 102));
sheet.addCell(new Number(2, 2, 32));
sheet.addCell(new Label(0, 3, "Bob"));
sheet.addCell(new Number(1, 3, 103));
sheet.addCell(new Number(2, 3, 67));
sheet.addCell(new Label(0, 4, "Alice"));
sheet.addCell(new Number(1, 4, 104));
sheet.addCell(new Number(2, 4, 28));
sheet.addCell(new Label(0, 5, "Charlie"));
sheet.addCell(new Number(1, 5, 105));
sheet.addCell(new Number(2, 5, 89));
workbook.write();
workbook.close();
fo.close();
System.out.println("Sample file created successfully!");
}
}
@Test
public void testImportExport() throws Exception {
// Open the input Excel file
FileInputStream fi = new FileInputStream(INPUT_FILE);
Workbook workbook = Workbook.getWorkbook(fi);
Sheet sheet = workbook.getSheet(0);
// Prepare output Excel file
FileOutputStream fo = new FileOutputStream(OUTPUT_FILE);
WritableWorkbook writableWorkbook = Workbook.createWorkbook(fo);
WritableSheet writableSheet = writableWorkbook.createSheet("ResultSheet", 0);
// Copy data from input to output
for (int i = 0; i < sheet.getRows(); i++) {
for (int j = 0; j < sheet.getColumns(); j++) {
String cellValue = sheet.getCell(j,
i).getContents(); Label label = new
Label(j, i, cellValue);
writableSheet.addCell(label);
}
}
// Add Result column header
Label header = new Label(sheet.getColumns(), 0, "Result");
writableSheet.addCell(header);
// Process student marks and update result
for (int i = 1; i < sheet.getRows(); i++) {
// Assuming marks are in the 3rd column (index 2)
String markStr = sheet.getCell(2, i).getContents();
int marks = Integer.parseInt(markStr);
String result = (marks > 35) ? "Pass" : "Fail";
Label resultLabel = new Label(sheet.getColumns(), i, result);
writableSheet.addCell(resultLabel);
}
// Save the output file
writableWorkbook.write();
writableWorkbook.close();
workbook.close();
fi.close();
fo.close();
System.out.println(" Records successfully updated in " + OUTPUT_FILE);
}
}