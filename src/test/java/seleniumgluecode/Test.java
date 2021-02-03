package seleniumgluecode;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import helpers.Helpers;

public class Test extends TestBase{

    @Given("^a user logged to Tellit choose an option$")
    public void aUserLoggedToTellitChooseAnOption() {
        mainPage.chooseOption();
        mainPage.assertionMain();
        helpers.takeScrenshoot(driver);
    }

    @When("^the user do a \"([^\"]*)\"$")
    public void theUserDoA(String option) throws Throwable {
        smsPage.createMessage("987288333","Hola, este es un mensaje de prueba.");
        smsPage.sendMessage();
        smsPage.chooseOption();

    }

    @And("^the user fill the form$")
    public void theUserFillTheForm() {
        detailedReportPage.assertionReportPage();
        helpers.takeScrenshoot(driver);
        detailedReportPage.fillForm("estrella", "Fast Send");
        detailedReportPage.searchReport();

    }

    @Then("^the user can download a report$")
    public void theUserCanDownloadAReport() throws Throwable {
        detailedReportPage.downloadReport();
        detailedReportPage.returnMainPage();
        helpers.takeScrenshoot(driver);
        mainPage.downloadReport();

    }
}