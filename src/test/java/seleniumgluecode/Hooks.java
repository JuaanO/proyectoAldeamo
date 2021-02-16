package seleniumgluecode;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import helpers.Helpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import pages.LoginPage;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Hooks {

    private static WebDriver driver;
    private static int numberOfCase = 0;

    @Before
    public void setUp() throws MalformedURLException {

        numberOfCase ++;
        System.out.println("Scenario: " +numberOfCase+ " is running ..");
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        URL url = new URL("http://0.0.0.0:4444/wd/hub");
        driver = new RemoteWebDriver(url,capabilities);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://tellit.aldeamo.com/");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("juan.estrella","Tellit2020..");
        loginPage.assertionLogin();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(Scenario result) {
        if(result.isFailed()){
            Helpers helpers = new Helpers();
            helpers.takeScrenshoot(driver);
        }
        System.out.println("Scenario: " +numberOfCase+ " ran correctly.");
        driver.quit();
    }

    public static WebDriver getDriver(){
        return driver;
    }
}
