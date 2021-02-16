package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static java.lang.Thread.sleep;

public class DetailedReportPage {

    private WebDriver driver;
    private final By userDropDownButton;
    private final By userDropUpButton;
    private final By selectAllCheck;
    private final By searchInputName;
    private final By selectNameOption;
    private final By referenceIntput;
    private final By menuButton;
    private final By typeDropDownButton;
    private final By typeDropUpButton;
    private final By typeOptionCheck;
    private final By searchButton;
    private final By downloadButton;
    private final By mainButton;

    public DetailedReportPage(WebDriver driver){
        this.driver = driver;
        userDropDownButton = By.xpath("//*[@id='multiSelectUser']/div/div[1]/span");
        userDropUpButton = By.xpath("//*[@id='multiSelectUser']/div/div[1]/span");
        selectAllCheck = By.xpath("//*[@id='multiSelectUser']/div/div[2]/ul[1]/li[1]/div");
        searchInputName = By.xpath("//*[@id='multiSelectUser']/div/div[2]/ul[1]/li[2]/input");
        selectNameOption = By.xpath("//*[@id='multiSelectUser']/div/div[2]/ul[2]/li");
        referenceIntput = By.xpath("//input[@placeholder='Reference']");
        menuButton = By.xpath("//i[@class='fas fa-bars']");
        typeDropDownButton = By.xpath("//*[@id='multiSelectMessageType']/div/div[1]/span");
        typeDropUpButton = By.xpath("//*[@id='multiSelectMessageType']/div/div[1]/span");
        typeOptionCheck = By.xpath("//div[normalize-space()='SMS']");
        searchButton = By.xpath("//button[normalize-space()='Search']");
        downloadButton = By.xpath("//i[@class='fas fa-file-download fa-2x']");
        mainButton = By.xpath("//a[@class='navbar-brand']//img");

    }

    public void openMenu(){
        driver.findElement(menuButton).click();
    }

    public void fillForm(String user, String reference){
        driver.findElement(menuButton).click();
        driver.findElement(userDropDownButton).click();
        driver.findElement(selectAllCheck).click();
        driver.findElement(searchInputName).sendKeys(user);
        driver.findElement(selectNameOption).click();
        driver.findElement(userDropUpButton).click();
        driver.findElement(referenceIntput).sendKeys(reference);
        driver.findElement(typeDropDownButton).click();
        driver.findElement(typeOptionCheck).click();
        driver.findElement(typeDropUpButton).click();
    }

    public void inputReference(String reference){
        driver.findElement(referenceIntput).sendKeys(reference);
    }

    public void chooseType(){
        driver.findElement(typeDropDownButton).click();
        driver.findElement(typeOptionCheck).click();
        driver.findElement(typeDropUpButton).click();
    }

    public void searchReport(){
        driver.findElement(searchButton).click();
    }

    public void downloadReport(){
        driver.findElement(downloadButton).click();
    }

    public void returnMainPage() throws InterruptedException {
        driver.findElement(mainButton).click();
        sleep(3000);
    }

    public void assertionReportPage(){
        Assert.assertTrue(driver.findElement(By.xpath("//h2[normalize-space()='Detailed Report']")).getText().contains("Detailed Report"));
    }
}
