package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {

    private WebDriver driver;

    private final By userField;
    private final By passwordField;
    private final By loginButton;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        userField = By.xpath("//*[@id='username']");
        passwordField = By.xpath("//*[@id='password']");
        loginButton = By.cssSelector("button[type='submit']");
    }

    public void login(String user, String pass){
        driver.findElement(userField).sendKeys(user);
        driver.findElement(passwordField).sendKeys(pass);
        driver.findElement(loginButton).click();
    }
    // Validacion
    public void assertionLogin(){
        Assert.assertTrue(driver.findElement(By.xpath("//h2[normalize-space()='Products']")).getText().contains("Products"));
    }
}
