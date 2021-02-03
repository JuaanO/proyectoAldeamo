package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DetailedReportPage;
import pages.LoginPage;
import pages.MainPage;
import pages.SmsPage;
import java.util.concurrent.TimeUnit;

public class TestReporte {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        DesiredCapabilities cap = new DesiredCapabilities();
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://tellit.aldeamo.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void reportes() throws InterruptedException {
        // LOGIN PAGE
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("juan.estrella","Tellit2020*");
        loginPage.assertionLogin();
        // MAIN PAGE
        MainPage mainPage = new MainPage(driver);
        mainPage.chooseOption();
        mainPage.assertionMain();
        // SMS PAGE
        SmsPage smsPage = new SmsPage(driver);
//        smsPage.inputNumber("987288333");
//        smsPage.inputMessage("Hola, este es un mensaje de prueba.");

        smsPage.proccessMessage();
        smsPage.sendMessage();
        smsPage.chooseOption();
//        smsPage.assertionSms();
        // REPORT PAGE
        DetailedReportPage detailedReportPage = new DetailedReportPage(driver);
        Assert.assertTrue(driver.findElement(By.xpath("//h2[normalize-space()='Reporte Detallados']")).getText().contains("Reporte Detallados"));
        detailedReportPage.openMenu();
//        detailedReportPage.selectUser("estrella");
        detailedReportPage.inputReference("Fast Send 2021-01-30");
        detailedReportPage.chooseType();
        detailedReportPage.searchReport();
        detailedReportPage.downloadReport();
        detailedReportPage.returnMainPage();
        //abro las notificaciones
        mainPage.downloadReport();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
