package stepDefinitions;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.junit.Assert;
import org.junit.runner.RunWith;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import pageobjects.ItemsPage;
import pageobjects.LoginPage;
import resources.Base;

import java.io.File;
import java.io.IOException;

@RunWith(Cucumber.class)
public class TestCheckout extends Base {
    public ItemsPage ip;

    @And("Check footer to make a scroll")
    public void scrollingFeature() throws InterruptedException {
        ip = new ItemsPage(driver);
        ip.scrollUntilElementIsInView(ip.getFooter());
        String x = ip.getFooter().getText();
        Assert.assertEquals(x, ip.getExpectedFooterText());
        // Take screenshot
        saveScreenshot("scrollingFeature", takeScreenshot());
    }

    @Then("User adds an item to the cart")
    public void user_adds_an_item_to_the_cart() throws InterruptedException {
        Thread.sleep(2000);
        ip.getRedItemButton().click();
        System.out.println("clicked on item");

        // Take screenshot
        saveScreenshot("user_adds_an_item_to_the_cart", takeScreenshot());
    }

    @And("Item is successfully added to the cart")
    public void item_is_successfully_added_to_the_cart() {
        ip.scrollUntilElementIsInView(ip.getCart());

        // Take screenshot
        saveScreenshot("item_is_successfully_added_to_the_cart", takeScreenshot());
    }

    @When("User goes to checkout")
    public void user_goes_to_checkout() throws InterruptedException {
        ip.getCart().click();
        saveScreenshot("user_goes_to_checkout", takeScreenshot());
        ip.getCheckout().click();

        // Assuming some steps to go to checkout
    }

    @And("User entered his info")
    public void userEnteredHisInfo() throws InterruptedException {

            ip.getFirstName().sendKeys("seif");
            ip.getLastName().sendKeys("elmosalamy");
            ip.getPostalCode().sendKeys("123");
        saveScreenshot("user_entered_his_info", takeScreenshot());

        ip.getcontinueButton().click();

        // Assuming some steps for user info entry
    }

    @Then("Checkout page is displayed")
    public void checkout_page_is_displayed() throws InterruptedException {
        saveScreenshot("checkout_page_is_displayed", takeScreenshot());
        ip.scrollUntilElementIsInView(ip.getFinishButton());
        Assert.assertTrue(ip.getFinishButton().isDisplayed());
        ip.getFinishButton().click();
    }

    @And("Finished checkout")
    public void finishedCheckout() {
        Assert.assertTrue(ip.getThankYou().isDisplayed());
        saveScreenshot("Finished checkout", takeScreenshot());
    }
}
