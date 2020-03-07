package stepdefs;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Random;

import org.junit.AfterClass;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects.ReportsObj;
import pages.BasePage;
import pages.LoginPage;
import pages.ReportsPage;

public class ReportsOADSD extends BasePage {
	public static String bftColTxt = "";
	public static String reportnem = "";
	public static String colname = "";
	public static String newcol = "";

	LoginPage log = new LoginPage();
	ReportsPage report = new ReportsPage();

	@When("^user navigates to S(\\d+)B reports Screen$")
	public void user_navigates_to_S_B_reports_Screen(int arg1) throws Throwable {
		clickOnHamburger();
		ThreadWait(4000);
		ReportsObj rep = new ReportsObj(driver);
		ThreadWait(2000);
		rep.getCashBtn().click();
		ThreadWait(2000);
		rep.getViewBtn().click();
		ThreadWait(2000);
		rep.getReportBtn().click();
		ThreadWait(3000);
		eyes.checkWindow("Notification Screen");
		report.notification();

		ThreadWait(3000);
	}

	@When("^user able to add new column by drag and drop$")
	public void user_able_to_add_new_column_by_drag_and_drop() throws Throwable {

		ThreadWait(3000);
		report.oadReportAddColumn();
		eyes.checkWindow("OAD report screen");
	}

	@When("^user able to edit the column name$")
	public void user_able_to_edit_the_column_name() throws Throwable {
		bftColTxt = report.geOADReportColTxt();
		report.oadReportEditCol();
	}

	@When("^user able to save the report$")
	public void user_able_to_save_the_report() throws Throwable {

		Random rand = new Random();
		int rand_int1 = rand.nextInt(1000);

		String rptnme = String.valueOf(rand_int1);
		System.out.println(rptnme);
		ThreadWait(5000);
		report.continueButton();
		Thread.sleep(5000);
		eyes.checkWindow("Save OAD Report");
		reportnem = report.saveReport(rptnme);
		// ThreadWait(5000);
		Thread.sleep(5000);
	}

	@Then("^verify user able to run the report$")
	public void verify_user_able_to_run_the_report() throws Throwable {
		eyes.checkWindow("Notification screen");
		report.notification();
		Thread.sleep(5000);
		eyes.checkWindow("Save as new Report");
		ThreadWait(5000);
		eyes.checkWindow("Saved OAD Report");
		Thread.sleep(5000);
		report.openSubReport(reportnem);
		eyes.checkWindow("Run report screen");

	}

	@Then("^verify new column is added in the report$")
	public void verify_new_column_is_added_in_the_report() throws Throwable {
		ReportsObj rpom = new ReportsObj(driver);
		newcol = "Company";
		Thread.sleep(5000);
		Actions act = new Actions(driver);

		driver.findElement(By.xpath(".//div[contains(@class,'ReactVirtualized__Grid VirtualizedTable__body___278Sj')]"))
				.click();
		Robot robot = new Robot();

		for (int k = 0; k < 25; k++) {

			driver.findElement(
					By.xpath(".//div[contains(@class,'ReactVirtualized__Grid VirtualizedTable__body___278Sj')]"))
					.sendKeys(Keys.ARROW_RIGHT);
		}

		if (rpom.getCompanyHdr().getText().contains("Company"))

		{
			System.out.println("New column 'Company' is added ");
		} else {
			Assert.fail("New column is not added properly");
		}

	}

	@Then("^verify column name is updated in the report$")
	public void verify_column_name_is_updated_in_the_report() throws Throwable {

		ReportsObj rpom = new ReportsObj(driver);
		colname = "As At Date Header";
		if (rpom.getAsDatHdr().getText().contains("As At Date Header")) {
			System.out.println("Column name 'AS At Date' is newly updated as 'As At Date Header'");
		} else {
			Assert.fail("Column name is not updated");
		}
		// driver.quit();
		eyes.closeAsync();
	}

	@AfterClass
	public void forceClose() {
		eyes.abortIfNotClosed();
	}
}
