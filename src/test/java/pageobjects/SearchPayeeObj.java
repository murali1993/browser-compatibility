package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class SearchPayeeObj {

	@FindBy(how = How.XPATH, using = "//html/body/div[2]/div/div/div/aside/div/div/ul/li[2]/a/div/label/span/img")
	private WebElement cashOptn;

	@FindBy(how = How.XPATH, using = "//label[text()='Create']")
	private WebElement createOptn;

	@FindBy(how = How.XPATH, using = "//label[text()='Fund Transfer']")
	private WebElement fundTransfersOptn;

	@FindBy(how = How.XPATH, using = "//input[@placeholder= 'Choose a debit account']")
	private WebElement searchfield;

	@FindBy(how = How.XPATH, using = "//div[text()='G CO LTD-0101295650-SGD-Name1 bo name-SCBLSGSGXXX-SG']")
	private WebElement searchedTextResult;

	@FindBy(how = How.XPATH, using = "//span[text() = 'SELF']")
	private WebElement paymentMethod;

	@FindBy(how = How.XPATH, using = "//input[@placeholder = 'Choose a payee']")
	private WebElement payeeTxtBox;

	@FindBy(how = How.XPATH, using = "//div[text() = 'PG CO L-NO 2 AC-SCBLSGSGXXX--SG-SGD']")
	private WebElement payee;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Pay Recipient']")
	private WebElement payAmount;

	@FindBy(how = How.XPATH, using = "//html/body/div[2]/div/div/div/section/main/section/div[2]/div[2]/div[4]/div/div/div/div/div/div[2]/div/div/div[2]/div")
	private WebElement outsideClick;

	@FindBy(how = How.XPATH, using = "//html/body/div[2]/div/div/div/section/main/section/div[2]/div[2]/div[8]/div/div/div/div/div/div/div/div[3]/div/div/div/div/div[2]/div/div/div[2]/div/div/span")
	private WebElement invoiceDownArrow;

	@FindBy(how = How.XPATH, using = "//label[contains(text(), 'INVOICE DETAILS')]")
	private WebElement invoiceLbl;

	@FindBy(how = How.XPATH, using = "//input[@placeholder = 'Select Invoice Type']")
	private WebElement invoicetp;

	@FindBy(how = How.XPATH, using = "//div[text()='2 Column Invoice']")
	private WebElement invoiceType;
	
	@FindBy(how = How.XPATH, using = "//p[contains(text(),'ADD RECORDS')]")
	private WebElement addRecordsBtn;
	
	@FindBy(how = How.XPATH, using = "//h4[contains(text(),'ADD INVOICE RECORDS')]")
	private WebElement addInvRecordsLbl;	
	
	
	@FindBy(how = How.XPATH, using = "//input[@placeholder='Invoice Description']")
	private WebElement invoiceDesTxt;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Enter amount']")
	private WebElement invoiceAmtTxt;
	
	@FindBy(how = How.XPATH, using = "//div[@class='panel amount-section']")
	private WebElement invoiceAmtPlane;
	
	@FindBy(how = How.XPATH, using = "//p[contains(text(),'SAVE RECORDS')]")
	private WebElement saveRecordsBtn;
	
	@FindBy(how = How.XPATH, using = "//div[@class='s2b-label--large s2b-label--primaryColor2 ember-view']/label")
	private WebElement savedRecordCount;

	@FindBy(how = How.XPATH, using = "//div[@class='s2b-label--regular s2b-label--extra-large s2b-label--primaryColor2 ember-view']/label")
	private WebElement invoiceAmountLbl;
	
	@FindBy(how = How.XPATH, using = "//div[@class='s2b-label--extra-large s2b-label--primaryColor2 ember-view']/label")
	private WebElement totlInvAmountLbl;
		
	@FindBy(how = How.XPATH, using = "//p[text()='CONTINUE']")
	private WebElement continueBtn;

	@FindBy(how = How.XPATH, using = "//p[text()='Submit']")
	private WebElement submitBtn;

	@FindBy(how = How.XPATH, using = "//p[text()='Your payment has been submitted successfully']")
	private WebElement txtVerification;

	public WebElement getCashOptn() {
		return cashOptn;
	}

	public WebElement getCreateOptn() {
		return createOptn;
	}

	public WebElement getFundTransfersOptn() {
		return fundTransfersOptn;
	}

	public WebElement getSearchField() {
		return searchfield;
	}

	public WebElement getSearchedTextResult() {
		return searchedTextResult;
	}

	public WebElement getPaymentMethod() {
		return paymentMethod;

	}

	public WebElement getPayeeTxtBox() {
		return payeeTxtBox;

	}

	public WebElement getPayee() {
		return payee;

	}

	public WebElement getPayAmount() {
		return payAmount;
	}

	public WebElement getOutsideClick() {
		return outsideClick;
	}

	public WebElement getInvoiceLbl() {
		return invoiceLbl;
	}

	public WebElement getInvoiceDownArrow() {
		return invoiceDownArrow;
	}

	public WebElement getInvoiceTP() {
		return invoicetp;
	}

	public WebElement getInvoiceType() {
		return invoiceType;
	}
   
	public WebElement getSearchfield() {
		return searchfield;
	}

	public WebElement getInvoicetp() {
		return invoicetp;
	}

	public WebElement getAddRecordsBtn() {
		return addRecordsBtn;
	}

	public WebElement getAddInvRecordsLbl() {
		return addInvRecordsLbl;
	}

	public WebElement getInvoiceDesTxt() {
		return invoiceDesTxt;
	}

	public WebElement getInvoiceAmtTxt() {
		return invoiceAmtTxt;
	}

	public WebElement getInvoiceAmtPlane() {
		return invoiceAmtPlane;
	}

	public WebElement getSaveRecordsBtn() {
		return saveRecordsBtn;
	}

	public WebElement getSavedRecordCount() {
		return savedRecordCount;
	}

	public WebElement getInvoiceAmountLbl() {
		return invoiceAmountLbl;
	}

	public WebElement getTotlInvAmountLbl() {
		return totlInvAmountLbl;
	}

	public WebElement getContinueBtn() {
		return continueBtn;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}

	public WebElement getTxtVerification() {
		return txtVerification;
	}

	public SearchPayeeObj(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

}