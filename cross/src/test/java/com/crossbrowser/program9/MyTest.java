package com.crossbrowser.program9;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
public class MyTest extends BaseTest {
// Default constructor (REǪUIRED)
public MyTest() {
super();
}
@Test
public void testGoogleSearch() {
try {
// Navigate to Google
driver.get("https://www.google.com");
System.out.println("Navigated to Google");
// Wait for search box
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
WebElement searchBox = wait.until(
ExpectedConditions.elementToBeClickable(By.name("q"))
);
// Perform search
searchBox.sendKeys("Selenium WebDriver");
searchBox.submit();
// Wait for results
wait.until(ExpectedConditions.titleContains("Selenium"));
// Verify
String title = driver.getTitle();
System.out.println("Page title: " + title);
Assert.assertTrue(title.contains("Selenium"), "Title should contain Selenium");
} catch (Exception e) {
System.out.println("Test failed: " + e.getMessage());
throw e;
}
}
}