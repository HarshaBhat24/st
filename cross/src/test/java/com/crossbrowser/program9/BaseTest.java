package com.crossbrowser.program9;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
public class BaseTest {
protected WebDriver driver;
// Default constructor (REǪUIRED)
public BaseTest() {
}
@BeforeMethod
@Parameters("browser")
public void setup(String browser) {
if (browser.equalsIgnoreCase("chrome")) {
System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
ChromeOptions options = new ChromeOptions();
options.addArguments("--remote-allow-origins=*");
options.addArguments("--no-sandbox");
options.addArguments("--disable-dev-shm-usage");
driver = new ChromeDriver(options);
} else if (browser.equalsIgnoreCase("firefox")) {
System.out.println("Firefox is not installed on this system");
throw new IllegalArgumentException("Firefox not available. Only Chrome is supported.");
} else if (browser.equalsIgnoreCase("edge")) {
System.out.println("Edge is not available on Linux");
throw new IllegalArgumentException("Edge not available on Linux. Only Chrome is supported.");
} else {
throw new IllegalArgumentException("Unsupported browser: " + browser);
}
driver.manage().window().maximize();
System.out.println("Browser launched: " + browser);
}
@AfterMethod
public void tearDown() {
if(driver!= null) {
driver.quit();
System.out.println("Browser closed");
}
}
}