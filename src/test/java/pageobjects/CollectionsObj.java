package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CollectionsObj {

	@FindBy(how = How.XPATH, using = "//html/body/div[2]/div/div/div/aside/div/div/ul/li[2]/a/div/label/span/img")
	private WebElement cashOptn;

	@FindBy(how = How.XPATH, using = "//label[text()='Create']")
	private WebElement createOptn;

	@FindBy(how = How.XPATH, using = "//em[text()='Direct Debit Instructions']")
	private WebElement directDebitIns;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Enter Batch Name']")
	private WebElement batchName;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Select Credit Account']")
	private WebElement creditAccount;

	@FindBy(how = How.XPATH, using = "//span[text() = 'No']")
	private WebElement realTime;

	@FindBy(how = How.XPATH, using = "//span[text()='ADD DIRECT DEBIT']")
	private WebElement addDirectdebit;

	@FindBy(how = How.XPATH, using = "//h3[text() = 'ADD DIRECT DEBIT TO BATCH']")
	private WebElement addDirectdebit_title;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Enter Mandate Reference']")
	private WebElement mandateRefernce;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Enter Payer Name']")
	private WebElement payeeName;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Enter Account Number']")
	private WebElement accountNum;

	@FindBy(how = How.XPATH, using = "//input[@placeholder = 'Select a date']")
	private WebElement calendar;

	@FindBy(how = How.XPATH, using = "(//button[@type = 'button'])[9]")
	private WebElement calendararea;

	@FindBy(how = How.XPATH, using = "(//button[@type = 'button'])[10]")
	private WebElement leftNav;

	@FindBy(how = How.XPATH, using = "(//button[@type = 'button'])[11]")
	private WebElement rightNav;

	@FindBy(how = How.XPATH, using = "(//div[@class = 'sc-AykKE iJfoio'])[3]")
	private WebElement calenderoutside;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Enter Amount']")
	private WebElement amount;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Enter Local Code']")
	private WebElement localCode;

	@FindBy(how = How.XPATH, using = "//div[text()= 'Select Direct Debit Purpose']")
	private WebElement debitPurpose;

	@FindBy(how = How.XPATH, using = "//div[text()='E-commerce Payment']")
	private WebElement debitName;

	@FindBy(how = How.XPATH, using = "//span[text()='SAVE']")
	private WebElement btnSave;

	@FindBy(how = How.XPATH, using = "//span[text()='Submit']")
	private WebElement btnSubmit;

	@FindBy(how = How.XPATH, using = "(//span[text()='Submit'])[2]")
	private WebElement btnCnfSubmit;

	@FindBy(how = How.XPATH, using = "//h3[text()='YOUR DIRECT DEBIT BATCH HAS BEEN SUCCESSFULLY SUBMITTED']")
	private WebElement ddiSuccessMsg;

	@FindBy(how = How.XPATH, using = "//span[@class = 'DirectDebitConfirmation__ContentUnderline-eLiTnn eCgZhH']")
	private WebElement Batchnumlink;

	@FindBy(how = How.XPATH, using = "(//div[@class = 'BatchHeader__HeaderContent-fLmzV godBeX'])[1]")
	private WebElement batchRefnum;

	@FindBy(how = How.XPATH, using = "//button[@class = 'css-mad3ld css-kup8xj css-8atqhb e5dmjwd3']")
	private WebElement txnDownarrowButton;

	@FindBy(how = How.XPATH, using = "//span[text() = 'ADDITIONAL INFORMATION']")
	private WebElement addition_info;

	@FindBy(how = How.XPATH, using = "//div[@class = 'AdditionalFieldsForBlotterStyles__SubHeaderLabel-fNQhnk gVPSgP']")
	private WebElement debit_purpose;

	public WebElement getCashOptn() {
		return cashOptn;
	}

	public WebElement getCreateOptn() {
		return createOptn;
	}

	public WebElement getDirectDebitIns() {
		return directDebitIns;
	}

	public WebElement getBatchName() {
		return batchName;
	}

	public WebElement getCreditAccount() {
		return creditAccount;
	}

	public WebElement getRealTime() {
		return realTime;
	}

	public WebElement getAddDirectdebit() {
		return addDirectdebit;
	}

	public WebElement getaddDirectdebit_title() {
		return addDirectdebit_title;
	}

	public WebElement getMandateRefernce() {
		return mandateRefernce;
	}

	public WebElement getPayeeName() {
		return payeeName;
	}

	public WebElement getAccountNum() {
		return accountNum;
	}

	public WebElement getCalendar() {
		return calendar;
	}

	public WebElement getcalendararea() {
		return calendararea;
	}

	public WebElement getRightNav() {
		return rightNav;
	}

	public WebElement getLeftNav() {
		return leftNav;
	}

	public WebElement getcalenderoutside() {
		return calenderoutside;
	}

	public WebElement getAmount() {
		return amount;
	}

	public WebElement getLocalCode() {
		return localCode;
	}

	public WebElement getDebitPurpose() {
		return debitPurpose;
	}

	public WebElement getDebitName() {
		return debitName;
	}

	public WebElement getBtnSave() {
		return btnSave;
	}

	public WebElement getBtnSubmit() {
		return btnSubmit;
	}

	public WebElement getBtnCnfSubmit() {
		return btnCnfSubmit;
	}

	public WebElement getDdiSuccessMsg() {
		return ddiSuccessMsg;

	}

	public WebElement getBatchnumlink() {
		return Batchnumlink;

	}

	public WebElement getBatchRefnum() {
		return batchRefnum;
	}

	public WebElement gettxnDownarrowButton() {
		return txnDownarrowButton;
	}

	public WebElement getAddition_info() {
		return addition_info;
	}

	public WebElement getDebit_purpose() {
		return debit_purpose;
	}

	public CollectionsObj(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}

}
