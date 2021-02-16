package seleniumgluecode;

import cucumber.api.java.en.And;

public class ReportMessageFail extends TestBase{

    @And("^the user fill the form and fail test$")
    public void theUserFillTheFormAndFailTest() {
        detailedReportPage.assertionReportPage();
        detailedReportPage.fillFormAndFail("estrella", "Fast Send");
        detailedReportPage.searchReport();

    }
}