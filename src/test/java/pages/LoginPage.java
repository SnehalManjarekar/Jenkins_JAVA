package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public By username = By.id("username");
    public By password = By.id("password");
    public By loginBtn = By.xpath("//button[@type='submit']");
    public By flashMsg = By.id("flash");
}