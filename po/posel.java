package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
public class
CountWebPageObjects {
public static void
main(String[] args) {
// Set ChromeDriver path (update as per your system) System.setProperty("webdriver.chrome.driver",
"C:\\Users\\driver\\chromedriver.exe");
WebDriver driver = new ChromeDriver(); try {
driver.manage().window().maximize();
System.out.println("Launching Chrome...");
// Open target page (example: Gmail login page)
driver.get("https://mail.google.com/");
// Count links
List<WebElement> links = driver.findElements(By.tagName("a"));
// Count input fields (textboxes, password fields, etc.)
List<WebElement> inputs = driver.findElements(By.tagName("input"));
// Count buttons
List<WebElement> buttons = driver.findElements(By.tagName("button"));
// Count images
List<WebElement> images = driver.findElements(By.tagName("img"));
// Count dropdowns
List<WebElement> dropdowns = driver.findElements(By.tagName("select"));
// Print counts
System.out.println("Number of Links: " + links.size());
System.out.println("Number of Input fields: " + inputs.size());
System.out.println("Number of Buttons: " + buttons.size());
System.out.println("Number of Images: " + images.size());
System.out.println("Number of Dropdowns: " + dropdowns.size());
// Total objects
int totalObjects = links.size() + inputs.size() + buttons.size() + images.size() + dropdowns.size();
System.out.println("Total Number of Objects on the Page: " + totalObjects);
} finally {
driver.quit();
}
}
}