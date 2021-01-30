import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class TestReporte {

    WebDriver driver;
    @Test
    public void reportes() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setCapability("marrionette", false);
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://tellit.aldeamo.com/");

        // LOGIN
        driver.findElement(By.xpath("//*[@id='username']")).sendKeys("juan.estrella");
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("Tellit2020*");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        // BUCAR OPCION

        sleep(5000);
        driver.quit();
    }
}
