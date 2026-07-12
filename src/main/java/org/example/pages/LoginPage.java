package org.example.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    private WebDriverWait wait;

    // Locator
    private By username = By.id("username");
    private By password = By.id("password");
    private By loginBtn = By.cssSelector("button[type='submit']");
    private By message = By.id("flash");

    public LoginPage(WebDriver driver) {
        super(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Membuka halaman login
    public void open() {
        driver.get("https://the-internet.herokuapp.com/login");
    }

    // Input username
    public void inputUsername(String user) {
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(username));
        element.clear();
        element.sendKeys(user);
    }

    // Input password
    public void inputPassword(String pass) {
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(password));
        element.clear();
        element.sendKeys(pass);
    }

    // Klik tombol login
    public void clickLogin() {
        wait.until(
                        ExpectedConditions.elementToBeClickable(loginBtn))
                .click();
    }

    // Ambil pesan hasil login
    public String getMessage() {
        return wait.until(
                        ExpectedConditions.visibilityOfElementLocated(message))
                .getText();
    }
}