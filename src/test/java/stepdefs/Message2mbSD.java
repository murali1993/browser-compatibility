package stepdefs;

import cucumber.api.java.en.Then;
import pages.BasePage;
import pages.Message2mb;

public class Message2mbSD extends BasePage {

	

	@Then("^user selects reporting category from the left pane$")
	public void user_selects_reporting_category_from_the_left_pane() throws Throwable {
		Message2mb msg = new Message2mb(driver);
		msg.selectReportingCat();
	}

	@Then("^user should able to download message attachment greater than (\\d+)MB$")
	public void user_should_able_to_download_message_attachment_greater_than_MB(int arg1) throws Exception {
		Message2mb msg = new Message2mb(driver);
		msg.messages2mb();
	}



}
