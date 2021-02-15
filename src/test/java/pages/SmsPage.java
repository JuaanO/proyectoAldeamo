package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static java.lang.Thread.sleep;

public class SmsPage {

    private WebDriver driver;
    private final int TIMEOUT = 30;
    private final By numberInput;
    private final By messageInput;
    private final By processButton;
    private final By sendButton;
    private final By closeModal;
    private final By reportOption;
    private final By reportSmsOption;

    public SmsPage(WebDriver driver){
        this.driver = driver;
        numberInput = By.xpath("//*[@id='inputGsmList']");
        messageInput = By.xpath("//*[@id='txtMessage']");
        processButton = By.xpath("//*[@id='buttonProcess']");
        sendButton = By.xpath("//*[@id='buttonSend']");
        closeModal = By.xpath("//*[@id='buttonClose']");
        reportOption = By.xpath("//a[@data-target='#Reportes']");
        reportSmsOption = By.xpath("//ul[@id='Reportes']//li[2]//a[1]");
    }

    public void createMessage(String number,String message){
        driver.findElement(numberInput).sendKeys(number);
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        WebElement elemento = wait.until(ExpectedConditions.presenceOfElementLocated(messageInput));
        elemento.sendKeys(message);
    }

    public void proccessMessage() throws InterruptedException {
        driver.findElement(processButton).click();
        sleep(1000);
    }

    public void sendMessage() throws InterruptedException {
        driver.findElement(processButton).click();
        sleep(1000);
        driver.findElement(sendButton).click();
        sleep(1000);
    }

    public void closeModal(){
        WebDriverWait wait = new WebDriverWait(driver, TIMEOUT);
        WebElement elemento = wait.until(ExpectedConditions.presenceOfElementLocated(closeModal));
        elemento.click();
    }

    public void chooseOption(){
        driver.findElement(reportOption).click();
        driver.findElement(reportSmsOption).click();
    }

    public void assertionSms(){
        Assert.assertTrue(driver.findElement(By.xpath("//h2[normalize-space()='Reporte Detallados']")).getText().contains("Reporte Detallados"));
    }
}
