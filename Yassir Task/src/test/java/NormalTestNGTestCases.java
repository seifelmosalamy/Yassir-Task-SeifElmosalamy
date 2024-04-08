import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageobjects.LoginPage;
import resources.Base;

public class NormalTestNGTestCases extends Base {

    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeClass
    public void setUp() {
        // Set up WebDriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Initialize LoginPage object
        loginPage = new LoginPage(driver);
    }

    @Test
    public void loginWithValidCredentials() {
        // Navigate to the login page
        driver.get("https://www.saucedemo.com/");

        // Verify if the login page is open
        Assert.assertTrue(loginPage.checkIfLoginPageIsOpen(), "Login page is not open");

        // Enter valid username and password
        loginPage.getUsername().sendKeys("standard_user");
        loginPage.getPassword().sendKeys("secret_sauce");

        // Click on the login button
        loginPage.loginButton().click();

        // Verify if login is successful (redirects to inventory page)
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html", "Login failed");
    }

    @AfterClass
    public void tearDown() {
        driver.close();
        // Close the browser
    }
}
