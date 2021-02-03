package seleniumgluecode;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.DetailedReportPage;
import pages.MainPage;
import pages.SmsPage;

public class Test {

    private WebDriver driver = Hooks.getDriver();

    @Given("^a user logged to Tellit choose an option$")
    public void aUserLoggedToTellitChooseAnOption() {
        MainPage mainPage = new MainPage(driver);
        mainPage.chooseOption();
        mainPage.assertionMain();
    }

    @When("^the user do a \"([^\"]*)\"$")
    public void theUserDoA(String option) throws Throwable {
        SmsPage smsPage = new SmsPage(driver);
        smsPage.inputNumber("987288333");
        smsPage.inputMessage("Hola, este es un mensaje de prueba.");
        smsPage.proccessMessage();
        smsPage.sendMessage();
        smsPage.chooseOption();

    }

    @And("^the user fill the form$")
    public void theUserFillTheForm() throws Throwable {
        DetailedReportPage detailedReportPage = new DetailedReportPage(driver);
        detailedReportPage.assertionReportPage();
        detailedReportPage.openMenu();
        detailedReportPage.selectUser("estrella");
        detailedReportPage.inputReference("Fast Send 2021-01-30");
        detailedReportPage.chooseType();
        detailedReportPage.searchReport();

    }

    @Then("^the user can download a report$")
    public void theUserCanDownloadAReport() throws Throwable {
        MainPage mainPage = new MainPage(driver);
        DetailedReportPage detailedReportPage = new DetailedReportPage(driver);
        detailedReportPage.downloadReport();
        detailedReportPage.returnMainPage();
        //abro las notificaciones
        mainPage.downloadReport();

    }

}
