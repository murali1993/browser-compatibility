package stepdefs;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects.TransactionsObj;
import pages.BasePage;
import pages.TransactionsPage;

public class TransactionsSD extends BasePage {
	TransactionsPage transPage = new TransactionsPage();

	@Given("^user navigates to payments transaction screen$")
	public void user_navigates_to_payments_transaction_screen() throws Exception {
		clickOnHamburger();
		transPage.navigateToPaymentScreen();
	}

	@Then("^verify user is able to click payment reference to navigate to payment summary$")
	public void verify_user_is_able_to_click_payment_reference_to_navigate_to_payment_summary() throws Exception {
		transPage.verifyPaymentSummaryPage();
	}

	@Then("^verify user is able to apply filter conditions$")
	public void verify_user_is_able_to_apply_filter_conditions() throws Exception {
		transPage.filter();
	}

	@Then("^verify user able to navigate between pages$")
	public void verify_user_able_to_navigate_between_pages() throws Exception {
		transPage.pagination();
	}

	@Then("^verify user is able to sort transaction list$")
	public void verify_user_is_able_to_sort_transaction_list() throws Throwable {
		transPage.verifySorting();
	}

	@When("^the user multiselects the transaction$")
	public void the_user_multiselects_the_transaction() throws Exception {
		transPage.multiSelect();
		transPage.selectMultiTrans();
		if (transPage.selectAll()) {
			System.out.println("Select All button is attached to  Manage Transaction screen");
		} else {
			Assert.fail("Select All button is not attached to  Manage Transaction screen");
		}

	}

	@Then("^verify user should view actions and show selected tab$")
	public void verify_user_should_view_actions_and_show_selected_tab() throws Exception {
		if (transPage.actionsEnable()) {
			System.out.println("Action button is attached to  Manage Transaction screen");
		} else {
			Assert.fail("Action button is not attached to  Manage Transaction screen");
		}

	}

	@Then("^verify the appropriate amount has been added$")
	public void verify_the_appropriate_amount_has_been_added() throws Exception {
		if (transPage.verifyAmount()) {
			System.out.println("Sum Amount for selected transactions is displayed properly");

		} else {
			Assert.fail("Sum Amount for selected transactions is not displayed properly");
		}

		transPage.unselectTrans();
		if (transPage.updatedAmountSumCk()) {
			System.out.println("Sum amount is successfully updated");
		} else {
			Assert.fail("Sum amount is not successfully updated");
		}

	}

	@Then("^verify user is able to traverse between columns$")
	public void verify_user_is_able_to_traverse_between_columns() throws Exception {
		transPage.columnTraverse();

	}

	@Then("^verify user is able to click the vertical dots to view the menu$")
	public void verify_user_is_able_to_click_the_vertical_dots_to_view_the_menu() throws Throwable {

		transPage.verifyThreeDotsMenu();
	}

	@Then("^verify user should be able to export transaction list$")
	public void verify_user_should_be_able_to_export_transaction_list() throws Throwable {

		transPage.verifyExport();
	}

	@Then("^verify user is able to customize the transaction list in settings option using drag and drop feature$")
	public void verify_user_is_able_to_customize_the_transaction_list_in_settings_option_using_drag_and_drop_feature()
			throws Exception {
		transPage.settings();
		ThreadWait(6000);
		String emberid = driver.findElement(By.xpath(".//div[contains(text(),'DEBIT ACCOUNT NUMBER')]/ancestor::div[@class='ember-view'][1]"))
				.getAttribute("id");
		WebElement drgsrc = driver.findElement(By.xpath(".//div[contains(text(),'DEBIT ACCOUNT NUMBER')]/parent::div"));
		WebElement drgtrgt = driver.findElement(By.xpath("(//div[@class = 'css-nsezcw eijyc9d0'])[2]"));
		ThreadWait(3000);
		Actions actions = new Actions(driver);
//		actions.clickAndHold(drgsrc).moveByOffset(0, 100).moveByOffset(50, 500).moveToElement(drgtrgt, 0, 100).release().build().perform();
		actions.clickAndHold(drgsrc).moveByOffset(0, 100).moveByOffset(50, 100).moveToElement(drgtrgt, 0, 100).release().build().perform();
	}

	@Then("^verify user should able to view the newly added column$")
	public void verify_user_should_able_to_view_the_newly_added_column() throws Exception {
		//ThreadWait(5000);
		Thread.sleep(5000);
		if (transPage.applyChangess()) {
			System.out.println("New Column is added successfully");
		} else {
			Assert.fail("New Column is not added successfully");
		}

		
	}

	@Then("^verify user should able to reset the added column$")
	public void verify_user_should_able_to_reset_the_added_column() throws Exception {
		ThreadWait(5000);
		transPage.settings();
		transPage.reset();
		if (transPage.applyChangess()) {
			System.out.println("Template reset successfully");
		}
		transPage.reset();

	}

}
