package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MessagesObj {

	@FindBy(how = How.XPATH, using = "//div[@class='header-container row']/child::div[3]/div[2]/div[1]/div/button")
	private WebElement msgBtn;
	
	@FindBy(how = How.XPATH, using = "//section[@class='main-section']/child::main//h2")
	private WebElement msgScrHdrTxt;

	

	

	

	

	@FindBy(how = How.XPATH, using = "//span[@class='alert-badge']")
	private WebElement unreadMsgPop;

	@FindBy(how = How.XPATH, using = "//span[@class='sc-scb-53-filter custom-position']")
	private WebElement filter;

	@FindBy(how = How.XPATH, using = "//div[@class='cp-Panels ember-view']/child::div[1]/a/span")
	private WebElement revBtn;

	@FindBy(how = How.XPATH, using = "//label[contains(text(),'FROM')]/following::div/div/div/input")
	private WebElement calendarFrom;

	@FindBy(how = How.XPATH, using = "//label[contains(text(),'TO')]/following::div/div/div/input")
	private WebElement calendarTo;

	@FindBy(how = How.XPATH, using = "//button[@class='s2b-button-primary  filters-action']")
	private WebElement applyBtn;

	@FindBy(how = How.XPATH, using = "//li[@class='message-row  message-row--selected ']/child::div/div/div[1]/div[3]/label")
	private WebElement fstMsg;

	@FindBy(how = How.XPATH, using = "//li[@class='message-row  message-row--selected ']/child::div/div/div[1]/div[1]")
	private WebElement fstMsgDt;

	@FindBy(how = How.XPATH, using = "//div[@class='s2b-label--medium ember-view']/child::label")
	private WebElement fstMsgAc;

	@FindBy(how = How.XPATH, using = "//span[@class='sc-scb-31-list']")
	private WebElement multiSel;

	@FindBy(how = How.XPATH, using = "//div[@class='select-all']")
	private WebElement selectAll;

	@FindBy(how = How.XPATH, using = "//span[text()='Actions']")
	private WebElement action;

	@FindBy(how = How.XPATH, using = "//p[text()='Mark as unread']")
	private WebElement markUnread;

	public MessagesObj(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getMsgBtn() {
		return msgBtn;
	}
	
	public WebElement getMsgScrHdrTxt() {
		return msgScrHdrTxt;
	}

	
	public WebElement getUnreadMsgPop() {
		return unreadMsgPop;
	}

	public WebElement getFilter() {
		return filter;
	}

	public WebElement getRevBtn() {
		return revBtn;
	}
	public WebElement getCalendarFrom() {
		return calendarFrom;
	}
	
	public WebElement getCalendarTo() {
		return calendarTo;
	}

	public WebElement getApplyBtn() {
		return applyBtn;
	}

	public WebElement getFstMsg() {
		return fstMsg;
	}

	public WebElement getFstMsgDt() {
		return fstMsgDt;
	}

	public WebElement getFstMsgAc() {
		return fstMsgAc;
	}

	public WebElement getMultiSel() {
		return multiSel;
	}

	public WebElement getSelectAll() {
		return selectAll;
	}

	public WebElement getAction() {
		return action;
	}

	public WebElement getMarkUnread() {
		return markUnread;
	}

}