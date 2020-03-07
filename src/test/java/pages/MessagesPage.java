package pages;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageobjects.MessagesObj;


public class MessagesPage extends BasePage {
	public static int msgct = 0;
	public static int msgctafter = 0;
	WebDriverWait wait = new WebDriverWait(driver, 60);

	public void clickMessageBtn() throws InterruptedException {
	
		ThreadWait(4000);
		WebElement msgbt = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@class='header-container row']/child::div[3]/div[2]/div[1]/div/button")));
		msgbt.click();
	}

	public int getMessageCount() throws InterruptedException {

		MessagesObj msg = new MessagesObj(driver);
		ThreadWait(4000);
		if (msg.getUnreadMsgPop().isDisplayed()) {
			String messagecount = msg.getUnreadMsgPop().getText();
			msgct = Integer.parseInt(messagecount);

			implicitWait();

		} else {
			System.out.println("No unread messages Remaining");
		}
		return msgct;

	}

	public void messagecountVal() {
		MessagesObj msg = new MessagesObj(driver);

		try {
			String messagecount = msg.getUnreadMsgPop().getText();
			msgctafter = Integer.parseInt(messagecount);
			System.out.println(msgct);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		} catch (Exception e) {
			System.out.println("No unread messages Remaining");
		}
		if ((msgctafter < msgct)) {
			System.out.println("Message count before read: " + msgct);
			System.out.println("Message count after read: " + msgctafter);
			System.out.println("New message count is updated ");
		} else {
			System.out.println("Message count before read: " + msgct);
			System.out.println("Message count after read: " + msgctafter);
			System.out.println("Message count is not displayed as expected ");
		}

	}

	public void applyMessageFilter() throws InterruptedException {
		
		MessagesObj msg = new MessagesObj(driver);
		msg.getFilter().click();
		ThreadWait(5000);
		msg.getRevBtn().click();
		ThreadWait(2000);
		msg.getCalendarFrom().sendKeys("14/11/2019");
		ThreadWait(2000);
		msg.getCalendarTo().sendKeys("14/11/2019");
		ThreadWait(5000);
		msg.getApplyBtn().click();
		

	}
	
	public String filterValidation()
	{
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement msgdt = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//li[@class='message-row  message-row--selected ']/child::div/div/div[1]/div[1]")));
		String date = msgdt.getText();

		return date;
	}
	
	public void openMessage() 
	{
		
		MessagesObj msg = new MessagesObj(driver);
		WebElement msgHdr = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//li[@class='message-row  message-row--selected ']/child::div/div/div[1]/div[3]/label")));
		if(msgHdr.getText()!=null)
		{
			System.out.println("Selected Message is opened");
		}else
		{
			Assert.fail("Selected Message is not opened");
		}
	}

	public String getMsghdrFromLeftPane() {
		
		
		MessagesObj msg = new MessagesObj(driver);
		WebElement msgHdr = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//li[@class='message-row  message-row--selected ']/child::div/div/div[1]/div[3]/label")));
		String msgBdyHeader = msgHdr.getText();
		return msgBdyHeader;

	}

	public String getMsgContent() {
		
		MessagesObj msg = new MessagesObj(driver);
		WebElement msghbd = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='s2b-label--medium ember-view']/child::label")));

		String msgbdy = msghbd.getText();
		return msgbdy;
	}

	public void countreset() throws InterruptedException {
		MessagesObj msg = new MessagesObj(driver);
		
		ThreadWait(5000);
		msg.getMultiSel().click();
		ThreadWait(3000);
		msg.getSelectAll().click();
		ThreadWait(3000);
		msg.getAction().click();
		ThreadWait(3000);
		msg.getMarkUnread().click();
		ThreadWait(3000);

	}

}
