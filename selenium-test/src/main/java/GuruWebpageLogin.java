import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class GuruWebpageLogin {

    // Configuration constants
    private static final String CHROME_DRIVER_PATH = "/usr/bin/chromedriver";
    private static final String BASE_URL = "http://demo.guru99.com/test/newtours/";
    private static final Duration WAIT_TIMEOUT = Duration.ofSeconds(10);

    // Test data constants
    private static final String TEST_USERNAME = "userName";
    private static final String TEST_PASSWORD = "password";
    private static final String EXPECTED_TITLE = "Login: Mercury Tours";

    private WebDriver driver;
    private WebDriverWait wait;

    public static void main(String[] args) {
        GuruWebpageLogin test = new GuruWebpageLogin();
        test.runLoginTest();
    }

    public void runLoginTest() {
        try {
            setupDriver();
            navigateToLoginPage();
            performLogin(TEST_USERNAME, TEST_PASSWORD);
            verifyLoginSuccess();
        } catch (Exception e) {
            System.err.println("Test failed with exception:");
            e.printStackTrace();
        } finally {
            tearDown();
        }
    }

    private void setupDriver() {
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, WAIT_TIMEOUT);
        System.out.println("Launching Chrome Browser...");
    }

    private void navigateToLoginPage() {
        driver.get(BASE_URL);
    }

    private void performLogin(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickSubmitButton();
    }

    private void enterUsername(String username) {
        WebElement usernameField = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.name("userName")));
        usernameField.sendKeys(username);
    }

    private void enterPassword(String password) {
        WebElement passwordField = driver.findElement(By.name("password"));
        passwordField.sendKeys(password);
    }

    private void clickSubmitButton() {
        WebElement submitButton = driver.findElement(By.name("submit"));
        submitButton.click();
        // Wait for page to load after login
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void verifyLoginSuccess() {
        String actualTitle = driver.getTitle();
        System.out.println("Page Title: " + actualTitle);

        if (EXPECTED_TITLE.equals(actualTitle)) {
            System.out.println("LOGIN SUCCESSFUL...");
            System.out.println("All test cases passed");
        } else {
            System.out.println("LOGIN FAILED");
        }
    }

    private void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}