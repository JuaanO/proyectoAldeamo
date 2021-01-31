import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class TestReporte {

    WebDriver driver;


    @BeforeMethod
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setCapability("marrionette", false);
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://tellit.aldeamo.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void reportes() throws InterruptedException {
        // LOGIN
        driver.findElement(By.xpath("//*[@id='username']")).sendKeys("juan.estrella");
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("Tellit2020*");
        driver.findElement(By.cssSelector("button[type='submit']")).click();

        //Agregar un asset para validar que se encuentra hecho el login correctamente

        // ENVIAR UN MENSAJE
        //  Agregar validacion queesta en mensaje
        driver.findElement(By.xpath("//h1[contains(text(),'Potencia las')]")).click();
        driver.findElement(By.xpath("//*[@id='inputGsmList']")).sendKeys("986235829");
        driver.findElement(By.xpath("//*[@id='txtMessage']")).sendKeys("Hola, este es un mensaje de prueba.");
        driver.findElement(By.xpath("//*[@id='buttonProcess']")).click();

//        Confirmar envio de mensaje

        driver.findElement(By.xpath("//*[@id='buttonSend']")).click();
        driver.findElement(By.xpath("//*[@id='buttonClose']")).click();

        // REPORTES

        driver.findElement(By.xpath("//a[@data-target='#Reportes']")).click();
        driver.findElement(By.xpath("//ul[@id='Reportes']//li[2]//a[1]")).click();

        //Hacer un assert en reportes

        driver.findElement(By.xpath("//i[@class='fas fa-bars']")).click();

        driver.findElement((By.xpath("//*[@id='multiSelectUser']/div/div[1]/span"))).click();
        driver.findElement(By.xpath("//*[@id='multiSelectUser']/div/div[2]/ul[1]/li[1]/div")).click();
        driver.findElement(By.xpath("//*[@id='multiSelectUser']/div/div[2]/ul[1]/li[2]/input")).sendKeys("estrella");

        driver.findElement(By.xpath("//*[@id='multiSelectUser']/div/div[2]/ul[2]/li")).click();

        //bajo el input de usuarios
        driver.findElement((By.xpath("//*[@id='multiSelectUser']/div/div[1]/span"))).click();

        driver.findElement(By.xpath("//input[@placeholder='Referencia']")).sendKeys("Fast Send 2021-01-30");

        driver.findElement(By.xpath("//*[@id='multiSelectMessageType']/div/div[1]/span")).click();

        driver.findElement(By.xpath("//div[normalize-space()='SMS']")).click();
        driver.findElement(By.xpath("//*[@id='multiSelectMessageType']/div/div[1]/span")).click();
        driver.findElement(By.xpath("//button[normalize-space()='Buscar']")).click();

        driver.findElement(By.xpath("//i[@class='fas fa-file-download fa-2x']")).click();

        // regreso a menu central de tellit
//        driver.findElement(By.xpath("//a[@class='navbar-brand']//img")).click();

        //abro las notificaciones

        driver.findElement(By.xpath("/html/body/app-root/div[2]/app-header/header/nav/div[3]/div/ul/li[1]/a")).click();

        // descargo notificaciones

        sleep(5000);
        driver.findElement(By.xpath("//body//app-root//li[@class='dropdown drop-custom notifications-menu show']//li//li[1]//div[2]//div[1]//a[2]//i[1]")).click();
//
        sleep(2000);

    }

    @AfterMethod
    public void tearDown() {

        driver.quit();
    }
}
