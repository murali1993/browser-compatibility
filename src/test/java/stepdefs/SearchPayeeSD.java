package stepdefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.BasePage;
import pages.SearchPayeePage;

public class SearchPayeeSD extends BasePage {
	SearchPayeePage payee = new SearchPayeePage();

	@Given("user click on fund transfer option from cash create menu")
	public void user_click_on_fund_transfer_option_from_cash_create_menu() throws Throwable {
		clickOnHamburger();
		payee.navigateFundtransfers();
	}

	@When("user search with minimum of three letters in payee textbox")
	public void user_search_with_minimum_of_three_letters_in_payee_textbox() throws InterruptedException {
		payee.searchpaye();
	}

	@Then("user should see the suggestion box")
	public void user_should_see_the_suggestion_box() {
		payee.searchResultAssertion();
	}

	@When("user select the payee from PayTo search box")
	public void user_select_the_payee_from_PayTo_search_box() {
		payee.selectPayee();
	}

	@Then("user verify Invoice detail section is displayed")
	public void user_verify_Invoice_detail_section_is_displayed() throws InterruptedException {
		payee.invoiceSection();
	}

	@Then("user able to select option from Invoice Type dropdown")
	public void user_able_to_select_option_from_Invoice_Type_dropdown() {
		payee.selectInvoice();
	}

	@Then("user click on Add Invoice button")
	public void user_click_on_Add_Invoice_button() {
		payee.addInvoice();
	}

	@Then("user should see Add Invoice Records overlay")
	public void user_should_see_Add_Invoice_Records_overlay() {
		payee.addRecords();
		payee.addInvoiceRecords();
	}

	@Then("user save the invoice records")
	public void user_save_the_invoice_records() {
		payee.saveInvoiceRecords();
		payee.saveInvoiceRecords();
	}

	@Then("user should see the added details in the invoice details section")
	public void user_should_see_the_added_details_in_the_invoice_details_section() {
		payee.invoiceRecordsValidation();
	}

}
