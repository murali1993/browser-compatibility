package stepdefs;

import java.util.Random;

import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects.ReportsObj;
import pages.BasePage;
import pages.ReportsPage;

public class ReportsOASSD extends BasePage {
	public static String bftColTxt = "";
	public static String reportnem = "";
	public static String colname = "";
	public static String newcol = "";

	ReportsPage report = new ReportsPage();

	@When("^user clicks S(\\d+)B Menu Button$")
	public void user_clicks_S_B_Menu_Button(int arg1) throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		clickOnHamburger();
		ThreadWait(4000);
	}

	@When("^user navigates to S(\\d+)B reports and detailsScreen$")
	public void user_navigates_to_S_B_reports_and_detailsScreen(int arg1) throws Throwable {
		ReportsObj rep = new ReportsObj(driver);
		ThreadWait(2000);
		rep.getCashBtn().click();
		ThreadWait(2000);
		rep.getViewBtn().click();
		ThreadWait(2000);
		rep.getReportBtn().click();

		report.notification();
		ThreadWait(3000);
	}

	@When("^user able to add new column by Drag and Drop$")
	public void user_able_to_add_new_column_by_Drag_and_Drop() throws Throwable {
		ThreadWait(3000);
		report.oasReportAddColumn();
	}

	@When("^user able to edit the specified column name$")
	public void user_able_to_edit_the_specified_column_name() throws Throwable {
		bftColTxt = report.getOASReportColTxt();
		report.oasReportEditCol();
	}

	@When("^user able to save the edited report$")
	public void user_able_to_save_the_edited_report() throws Throwable {
		Random rand = new Random();
		int rand_int1 = rand.nextInt(1000);

		String rptnme = String.valueOf(rand_int1);
		System.out.println(rptnme);
		Thread.sleep(5000);
		reportnem = report.saveReport(rptnme);
		Thread.sleep(5000);
	}

	@Then("^verify user able to run the edited report$")
	public void verify_user_able_to_run_the_edited_report() throws Throwable {
		report.notification();
	}

	@Then("^verify new column is added to the report$")
	public void verify_new_column_is_added_to_the_report() throws Throwable {

	}

	@Then("^verify modified column name is updated in the report$")
	public void verify_modified_column_name_is_updated_in_the_report() throws Throwable {

		// driver.quit();
	}

}
