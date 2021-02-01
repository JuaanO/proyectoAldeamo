package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static java.lang.Thread.sleep;

public class MainPage {

    private WebDriver driver;
    private final By smsButton;
    private final By notificationButton;
    private final By downloadFileButton;

    public MainPage(WebDriver driver){
        this.driver = driver;
        smsButton = By.xpath("//h1[contains(text(),'Potencia las')]");
        notificationButton = By.xpath("/html/body/app-root/div[2]/app-navbar/header/nav/div[3]/div/ul/li[1]/a/span");
        downloadFileButton = By.xpath("//body//app-root//li[@class='dropdown drop-custom notifications-menu show']//li//li[1]//div[2]//div[1]//a[2]//i[1]");
    }

    public void chooseOption(){
        driver.findElement(smsButton).click();
    }

    public void downloadReport() throws InterruptedException {
        driver.findElement(notificationButton).click();
        sleep(5000);
        driver.findElement(downloadFileButton).click();
        sleep(2000);
    }

    public void assertionMain(){
        Assert.assertTrue(driver.findElement(By.xpath("//h2[normalize-space()='SMS']")).getText().contains("SMS"));
    }
}
