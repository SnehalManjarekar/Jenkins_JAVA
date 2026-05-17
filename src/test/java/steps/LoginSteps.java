package steps;

import base.baseClass;
import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.LoginPage;

public class LoginSteps extends baseClass {

    LoginPage loginPage;

    // ---------------- VALID LOGIN ----------------
    @When("enter valid {string} and {string}")
    public void enter_valid_credentials(String uname, String pass) {
        driver.findElement(loginPage.username).sendKeys(uname);
        driver.findElement(loginPage.password).sendKeys(pass);
    }
    // ---------------- INVALID LOGIN ----------------
    @When("enter invalid {string} and {string}")
    public void enter_invalid_credentials(String inname, String inpass) {
        driver.findElement(loginPage.username).sendKeys(inname);
        driver.findElement(loginPage.password).sendKeys(inpass);
    }
    // ---------------- BLANK LOGIN ----------------
    @When("enter Blank username and password")
    public void Blank_credentials() {
        driver.findElement(loginPage.username).sendKeys("");
        driver.findElement(loginPage.password).sendKeys("");
    }
    // ---------------- COMMON STEP ----------------
    @Given("the user navigates to the login page")
    public void open_login_page() {
        openBrowser();
        driver.get("https://the-internet.herokuapp.com/login");
        loginPage = new LoginPage(driver);
    }
    @And("click login button")
    public void class_login_button() {
        driver.findElement(loginPage.loginBtn).click();
    }
    // ---------------- VALIDATION ----------------
    @Then("Secure Area page should display")
    public void verify_login() {
        String message = driver.findElement(loginPage.flashMsg)
                .getText()
                .replace("×", "")
                .trim();

        Assert.assertTrue(
                message.contains("You logged into a secure area!"),
                "User is not logged in"
        );

        Assert.assertTrue(
                driver.getCurrentUrl().contains("secure"),
                "Not redirected to Secure Area page"
        );

        System.out.println("Valid Login Test Passed");

        closeBrowser();
    }

    @Then("error message should display")
    public void verify_invalid_login() {
        String message = driver.findElement(loginPage.flashMsg)
                .getText()
                .replace("×", "")
                .trim();

        Assert.assertTrue(
                message.contains("Your username is invalid!"),
                "Invalid Login Test Failed"
        );

        System.out.println("Invalid Login Test Passed");

        closeBrowser();
    }

    @Then("error message should display for blank")
    public void verify_blank_field_error() {

        String message = driver.findElement(loginPage.flashMsg)
                .getText()
                .replace("×", "")
                .trim();

//         NOTE: Website actually shows:"Your username is invalid!" for blank login also.

        Assert.assertTrue(
                message.contains("This field is required"),
                "Blank Login Test Failed"
        );

        System.out.println("Blank Login Test Passed");

        closeBrowser();
    }
}