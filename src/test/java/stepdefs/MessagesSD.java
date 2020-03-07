package stepdefs;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageobjects.MessagesObj;
import pages.BasePage;
import pages.LoginPage;
import pages.MessagesPage;

public class MessagesSD extends BasePage {

	public static int msgctafter = 0;
	public static int msgbfr = 0;

	LoginPage log = new LoginPage();
	MessagesPage msgscr = new MessagesPage();
	
	@When("^user click on messages icon in the home page$")
	public void user_click_on_messages_icon_in_the_home_page() throws Exception {
		ThreadWait(3000);
		msgscr.clickMessageBtn();
		
	}

	@Then("^user navigate to S(\\d+)B Messages Screen$")
	public void user_navigate_to_S_B_Messages_Screen(int arg1) throws Exception {
		MessagesObj msg = new MessagesObj(driver);
		System.out.println();
		//if(msg.getMsgScrHdrTxt().getText().equals(""))
		ThreadWait(3000);
		msgscr.countreset();
		ThreadWait(3000);
		msgbfr = msgscr.getMessageCount();
		
	}
	@When("^user filter with dates$")
	public void user_filter_with_dates() throws Exception {
		ThreadWait(3000);
		 msgscr.applyMessageFilter();
		
	}

	@Then("^user should see messages for applied filters$")
	public void user_should_see_messages_for_applied_filters() throws Exception {
		String date=msgscr.filterValidation();
		if (date.contains("14/11/2019")) {
			System.out.println("Message displayed  for the filtered date " + date);
		} else {
			System.out.println("Message not displayed for the filtered date" + date);
			Assert.fail("Message not displayed for the filtered date" + date);
		}
	}

	@When("^user clicks on a message$")
	public void user_clicks_on_a_message() throws Exception {
		ThreadWait(3000);
		msgscr.openMessage();

		
	}

	@Then("^verify selected message is displayed in the right pane$")
	public void verify_selected_message_is_displayed_in_the_right_pane() throws Exception {
		if ((msgscr.getMsghdrFromLeftPane()).contains(msgscr.getMsgContent())) {
			System.out.println("Selected message displayed properly on the message area  ");
		} else {
			Assert.fail("Selected message not displayed as expected");
		}
	}

	@Then("^verify message count is reduced by (\\d+)$")
	public void verify_message_count_is_reduced_by(int arg1) throws Exception {
		ThreadWait(3000);

		MessagesObj msg = new MessagesObj(driver);
		try {
			Thread.sleep(3000);
			String messagecount = msg.getUnreadMsgPop().getText();
			msgctafter = Integer.parseInt(messagecount);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		} catch (Exception e) {
			System.out.println("No unread messages Remaining");
		}
		if ((msgctafter < msgbfr)) {
			System.out.println("Message count before read: " + msgbfr);
			System.out.println("Message count after read: " + msgctafter);
			System.out.println("New message count is updated ");
		} else {
			System.out.println("Message count before read: " + msgbfr);
			System.out.println("Message count after read: " + msgctafter);
			Assert.fail("Message count is not displayed as expected ");
		}
	}

}
