package seleniumgluecode;

import org.openqa.selenium.WebDriver;
import pages.DetailedReportPage;
import pages.MainPage;
import pages.SmsPage;

public class TestBase {

    protected WebDriver driver = Hooks.getDriver();
    protected MainPage mainPage = new MainPage(driver);
    protected SmsPage smsPage = new SmsPage(driver);
    protected DetailedReportPage detailedReportPage = new DetailedReportPage(driver);

}
