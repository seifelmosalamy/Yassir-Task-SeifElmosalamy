package stepDefinitions;

import org.junit.runner.RunWith;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import java.io.IOException;
import org.junit.Assert;
import pageobjects.ItemsPage;
import pageobjects.LoginPage;
import resources.Base;

@RunWith(Cucumber.class)
public class TestLogin extends Base {
    public LoginPage lp;

    @Given("User is on {string} landing page")
    public void user_is_on_landing_page(String pageUrl) throws IOException {
        driver = initializeDriver();
        driver.get(pageUrl);
    }

    @Then("Login page is opened")
    public void Login_page_is_opened() {
        lp = new LoginPage(driver);
        Assert.assertTrue(lp.checkIfLoginPageIsOpen());
    }

    @When("User enters {string} and {string} and clicks sign in button")
    public void user_enters_and_clicks_sign_in_button(String username, String password) {
        lp.getUsername().sendKeys(username);
        lp.getPassword().sendKeys(password);
        lp.loginButton().click();
    }
   //region  Checking Wrong login credential Test Case
    @Then("Error message is shown")
    public void user_can_not_login_in() {
        Assert.assertTrue(lp.checkWrongLoginCridentials());//Test
    }
//endregion
    @And("Close browser")
    public void close_browser() {
        driver.close();
    }
}
