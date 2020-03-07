package stepdefs;

import org.junit.AfterClass;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.BasePage;
import pages.CollectionsPage;

public class CollectionsSD extends BasePage {

	CollectionsPage colPage = new CollectionsPage();

	@Then("^user should see Direct Debit Instructions under collection menu$")
	public void user_should_see_Direct_Debit_Instructions_under_collection_menu() throws Throwable {
		clickOnHamburger();
		colPage.navigateDDI();

	}

	@Then("^user navigates to DDI screen on clicking DDI menu$")
	public void user_navigates_to_DDI_screen_on_clicking_DDI_menu() throws Throwable {
		colPage.Clickddi();
		eyes.checkWindow("DDI screen");

	}

	@When("^user selects credit Account$")
	public void user_selects_credit_Account() throws Throwable {
		colPage.SelectCreditaccount();
       
	}

	@When("^user click on Add Direct Debit button$")
	public void user_click_on_Add_Direct_Debit_button() throws Throwable {
		colPage.click_add_ddi();

	}

	@Then("^user navigates to Add Direct Debit Batch Screen$")
	public void user_navigates_to_Add_Direct_Debit_Batch_Screen() throws Throwable {
		colPage.add_ddi_screen();

	}

	@And("^user picks date from calendar after navigating to and fro$")
	public void user_picks_date_from_calendar_after_navigating_to_and_fro() throws Throwable {
		colPage.Calendar_nav();

	}

	@When("^user inputs mandatory fields with direct debit purpose selected$")
	public void user_inputs_mandatory_fields_with_direct_debit_purpose_selected() throws Throwable {
		colPage.inputs_ddi();

	}

	@Then("^user saves the batch by clicking on save button$")
	public void user_saves_the_batch_by_clicking_on_save_button() throws Throwable {
		colPage.saving_batch();

	}

	@Then("^user should view the entered details with submit button$")
	public void user_should_view_the_entered_details_with_submit_button() throws Throwable {
		colPage.Submit_batch();

	}

	@Then("^user land on to the confirmation screen with batch reference number$")
	public void user_land_on_to_the_confirmation_screen_with_batch_reference_number() throws Throwable {
		colPage.Submit_confirm();

	}

	@When("^user clicks on the created batch reference number$")
	public void user_clicks_on_the_created_batch_reference_number() throws Throwable {
		colPage.batch_Reference_click();

	}

	@Then("^user verify newly added batch is displayed in the batch list$")
	public void user_verify_newly_added_batch_is_displayed_in_the_batch_list() throws Throwable {
		colPage.Verify_batch_Ref_num();

	}

	@Then("^user click on the down arrow of the added transaction$")
	public void user_click_on_the_down_arrow_of_the_added_transaction() throws Throwable {
		colPage.downArrowclick();

	}

	@Then("^user should see the added debit purpose in the additional information section$")
	public void user_should_see_the_added_debit_purpose_in_the_additional_information_section() throws Throwable {
		colPage.verify_additional_info();
		eyes.closeAsync();
	}
	
}
