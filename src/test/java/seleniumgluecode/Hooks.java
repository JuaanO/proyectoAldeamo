package seleniumgluecode;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class Hooks {

    private static WebDriver driver;
    private static int numberOfCase = 0;

    @Before
    public void setUp(){

        numberOfCase ++;
        System.out.println("Scenario: " +numberOfCase+ " is running ..");
        DesiredCapabilities cap = new DesiredCapabilities();
        System.setProperty("webdriver.chrome.driver", "src/test/resources/Chromedriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://tellit.aldeamo.com/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("juan.estrella","Tellit2020*");
        loginPage.assertionLogin();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(){

        System.out.println("Scenario: " +numberOfCase+ " ran correctly.");
        driver.quit();
    }

    public static WebDriver getDriver(){

        return driver;
    }
}
