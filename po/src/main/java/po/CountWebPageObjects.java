package po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.List;

/**
 * Page Object Counter - Counts various web elements on a webpage.
 * Demonstrates Selenium element location by tag name.
 * 
 * @author Learning Project
 * @version 1.0
 */
public class CountWebPageObjects {
    
    // Configuration constants
    private static final String CHROME_DRIVER_PATH = "/usr/bin/chromedriver";
    private static final String DEFAULT_URL = "https://mail.google.com/";
    
    public static void main(String[] args) {
        CountWebPageObjects counter = new CountWebPageObjects();
        counter.run();
    }
    
    /**
     * Main execution flow
     */
    public void run() {
        WebDriver driver = null;
        
        try {
            // Setup WebDriver
            driver = setupDriver();
            
            // Navigate to page
            navigateTo(driver, DEFAULT_URL);
            
            // Count and display elements
            countAndDisplayElements(driver);
            
        } catch (Exception e) {
            System.err.println("Error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (driver != null) {
                driver.quit();
                System.out.println("Browser closed successfully.");
            }
        }
    }
    
    /**
     * Setup ChromeDriver with options
     */
    private WebDriver setupDriver() {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        System.out.println("Launching Chrome...");
        
        return driver;
    }
    
    /**
     * Navigate to specified URL
     */
    private void navigateTo(WebDriver driver, String url) {
        System.out.println("Navigating to: " + url);
        driver.get(url);
        
        // Wait for page to load
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
    
    /**
     * Count and display all page elements
     */
    private void countAndDisplayElements(WebDriver driver) {
        System.out.println("\n=== Page Element Analysis ===\n");
        
        // Count different element types
        int linkCount = countElements(driver, "a", "Links");
        int inputCount = countElements(driver, "input", "Input fields");
        int buttonCount = countElements(driver, "button", "Buttons");
        int imageCount = countElements(driver, "img", "Images");
        int dropdownCount = countElements(driver, "select", "Dropdowns");
        
        // Calculate total
        int totalObjects = linkCount + inputCount + buttonCount + imageCount + dropdownCount;
        
        System.out.println("\n============================");
        System.out.println("Total Number of Objects: " + totalObjects);
        System.out.println("============================\n");
    }
    
    /**
     * Count elements by tag name and display result
     * 
     * @param driver WebDriver instance
     * @param tagName HTML tag name to search for
     * @param elementType Friendly name for display
     * @return Count of elements found
     */
    private int countElements(WebDriver driver, String tagName, String elementType) {
        List<WebElement> elements = driver.findElements(By.tagName(tagName));
        int count = elements.size();
        System.out.println(String.format("%-20s: %d", elementType, count));
        return count;
    }
}
