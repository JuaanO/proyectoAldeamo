package pages;

import helpers.Helpers;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private WebDriver driver;
    private final By smsButton;
    private final By notificationButton;
    private final By downloadFileButton;
    private final By assertionMain;

    public MainPage(WebDriver driver){
        this.driver = driver;
        smsButton = By.xpath("//h1[contains(text(),'Enhance communications with')]");
        notificationButton = By.xpath("/html/body/app-root/div[2]/app-navbar/header/nav/div[3]/div/ul/li[1]/a/span");
        downloadFileButton = By.xpath("//body//app-root//li[@class='dropdown drop-custom notifications-menu show']//li//li[1]//div[2]//div[1]//a[2]//i[1]");
        assertionMain = By.xpath("//h2[normalize-space()='SMS']");
    }

    public void chooseOption(){
        driver.findElement(smsButton).click();
    }

    public void downloadReport() {
        Helpers helpers = new Helpers();
        driver.findElement(notificationButton).click();
        helpers.sleepSeconds(5);
        driver.findElement(downloadFileButton).click();
        helpers.sleepSeconds(3);
    }

    public void assertionMain(){
        Assert.assertTrue(driver.findElement(assertionMain).getText().contains("SMS"));
    }
}
