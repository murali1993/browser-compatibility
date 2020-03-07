package stepdefs;

import org.junit.AfterClass;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects.DashbordObj;
import pages.BasePage;
import pages.LoginPage;


public class DashbordSD extends BasePage {
	WebDriverWait wait = new WebDriverWait(driver, 60);

	@Given("^user successfully login as \"([^\"]*)\" to the S2BNG application$")
	public void user_successfully_login_as_to_the_S_BNG_application(String role) throws Exception {
		initiateEyes("Collections-BS",driver,"S2BNG-Baseline");
	    // initiateEyes("Report-BS",driver,"S2BNG-Checkpoint-ie");
		LoginPage loginPage = new LoginPage();
		loginPage.loginToS2B(role);

	}

	@Given("^user navigate to manage dashboard menu$")
	public void user_navigate_to_manage_dashboard_menu() throws Exception {
		DashbordObj dash = new DashbordObj(driver);
		clickOnHamburger();
		dash.getSettingsBtn().click();
		ThreadWait(4000);
		dash.getManageDashBtn().click();
		ThreadWait(4000);
	}

	@When("^user drag and drop the \"([^\"]*)\" widget$")
	public void user_drag_and_drop_the_widget(String arg1) throws Exception {

		WebElement tile = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@unique-widget-id='quick-payments2']/child::span")));

		DashbordObj dash = new DashbordObj(driver);
		ThreadWait(4000);

		if (tile.isDisplayed()) {
			dash.getQuickPayBtn().click();
			ThreadWait(10000);

		} else
			Assert.fail("Quick Pay Button is not displayed");
        eyes.checkWindow("Before drag and drop");
		Actions builder = new Actions(driver);
		ThreadWait(3000);
		builder.dragAndDrop(dash.getFromArea(), dash.getToArea()).build().perform();
		eyes.checkWindow("After drag and drop");
		dash.getSaveBtn().click();

		ThreadWait(5000);

	}

	@Then("^verify user able to view dashboard with \"([^\"]*)\" widget$")
	public void verify_user_able_to_view_dashboard_with_widget(String arg1) throws Exception {

		WebElement tileup = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("(//div[@class='widget-content'])[8]/child::div/div[1]/div[1]/div[1]/div[1]/label")));

		if (tileup.getText().contains("QUICK PAYMENT")) {
			eyes.checkWindow("Quick Payment Widget");
			System.out.println("Quick Payment is successfully added to the dashbord");
		} else {
			Assert.fail("Quick Payment is successfully added to the dashbord");
		}
		eyes.closeAsync();
	}
	@AfterClass
	public void forceClose() {
		eyes.abortIfNotClosed();
	}
}
