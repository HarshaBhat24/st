package number_of_chechbox;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import java.util.List;
public class p10 {
private WebDriver driver;
@BeforeClass
public void setUp() {
System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
org.openqa.selenium.chrome.ChromeOptions options = new org.openqa.selenium.chrome.ChromeOptions();
options.addArguments("--remote-allow-origins=*");
options.addArguments("--no-sandbox");
options.addArguments("--disable-dev-shm-usage");
driver = new ChromeDriver(options);
driver.manage().window().maximize();
}
@Test
public void testCheckBoxesCount() {
driver.get("https://the-internet.herokuapp.com/checkboxes");
// Find all checkboxes
List<WebElement> checkboxes =
driver.findElements(By.xpath("//input[@type='checkbox']"));
System.out.println("Total Checkboxes: " +
checkboxes.size());
int checked = 0;
int unchecked = 0;
for (WebElement checkbox : checkboxes) {
if(checkbox.isSelected()) {
checked++;
} else {
unchecked++;
}
}
System.out.println("Checked Checkboxes: " + checked);
System.out.println("Unchecked Checkboxes: " + unchecked);
}
@AfterClass
public void tearDown() {
if (driver != null)
driver.quit();
}
}