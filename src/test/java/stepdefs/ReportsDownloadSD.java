package stepdefs;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects.ReportsObj;
import pages.BasePage;
import pages.ReportsPage;

public class ReportsDownloadSD extends BasePage {
	String path = System.getProperty("user.dir") + "\\downloads";
	int totalfilecountBfDw = 0;
	int totalfilecountAfDw = 0;
	ReportsPage report = new ReportsPage();

	
	@Given("^user navigates to Myreports by selecting cash view report option$")
	public void user_navigates_to_Myreports_by_selecting_cash_view_report_option() throws Exception {
		clickOnHamburger();
		ThreadWait(4000);
		ReportsObj rep = new ReportsObj(driver);
		rep.getCashBtn().click();
		ThreadWait(2000);
		rep.getViewBtn().click();
		
	}

	@Then("^verify user landed on to the Myreports screen$")
	public void verify_user_landed_on_to_the_Myreports_screen() throws Exception {
		ThreadWait(2000);
		ReportsObj rep = new ReportsObj(driver);
		rep.getReportBtn().click();
		report.notification(); // skip setting password alert
	}
	@Then("^verify user able to download the Operating Account Statement Report$")
	public void verify_user_able_to_download_the_Operating_Account_Statement_Report() throws Throwable {

		report.reportDownload();
		totalfilecountAfDw = report.isFileDownloaded(path);
		ThreadWait(5000);
		System.out.println(totalfilecountBfDw);
		ThreadWait(10000);
		System.out.println(totalfilecountAfDw);
		if (totalfilecountBfDw < totalfilecountAfDw) {
			System.out.println(
					"Operating Account Statement Report for the duration \"Current Date - 12 months\" is downloaded successfully");
		} else {
			Assert.fail(
					"Operating Account Statement Report for the duration \"Current Date - 12 months\" is not downloaded");
		}
		// driver.quit();

	}
	
	

}
