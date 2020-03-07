package pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class ReportsObj {

	@FindBy(how = How.XPATH, using = "//ul[@class='menu-list-new']/child::li[2]/a/div/label")
	private WebElement cashBtn;

	@FindBy(how = How.XPATH, using = "//ul[@class='menu-content-new menu-content--active menu-list-new']/child::li[5]/div/div/label")
	private WebElement viewBtn;

	@FindBy(how = How.XPATH, using = "//div[@class='menu-content-new menu-content--active menu-content-item-heading']/child::div/a[1]/div/label")
	private WebElement reportBtn;

	@FindBy(how = How.XPATH, using = "//div[@class='s2b-action-bar ember-view']/child::div/div/div[1]/ul[2]/li/div/button")
	private WebElement notibtn;

	@FindBy(how = How.XPATH, using = "//p[contains(text(),'Working Capital')]")
	private WebElement worCapBtn;
	//div[@class='row s2b-accordion']/child::div/div[6]/div[1]/a/span
	
	@FindBy(how = How.XPATH, using = "//div[@class='row s2b-accordion']/child::div/div[1]/div[1]/a/span")
	private WebElement subScrBtn;

	@FindBy(how = How.XPATH, using = "//p[contains(text(),'Operating Account Statement')]/following::div[11]/div/div/div/a[1]")
	private WebElement down;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Account Number']")
	private WebElement accNo;

	@FindBy(how = How.XPATH, using = "//div[@class='s2b-dropdown-container s2b-dropdown-container--additional show']/child::ul/li[1]/div/input")
	private WebElement accountChkbx;

	@FindBy(how = How.XPATH, using = "//div[@class='cueContent cardCols hideCue ']")
	private WebElement empare;

	@FindBy(how = How.XPATH, using = "//button[@class='switchOption active  ']")
	private WebElement rolldtbtn;

	@FindBy(how = How.XPATH, using = "//input[@placeholder='Select Duration']")
	private WebElement durationTxt;

	@FindBy(how = How.XPATH, using = "//ul[@class='action-button-right ']/child::li[2]/div/button")
	private WebElement exportbtn;

	@FindBy(how = How.XPATH, using = "(//ul[@class='action-button-right '])[2]/li[1]/div/button")
	private WebElement exportFBtn;

	@FindBy(how = How.XPATH, using = "//p[contains(text(),'Operating Account Details')]/following::div[11]/div/div/div/a[1]")
	private WebElement operAccDtlsBtn;

	@FindBy(how = How.XPATH, using = "//div[@class='css-1jxhgpx egbto161']/child::div")
	private List<WebElement> repcollst;

	@FindBy(how = How.XPATH, using = "//div[@class='Sortable__container___3uKDs602']")
	private WebElement dropColmArea;

	@FindBy(how = How.XPATH, using = "//p[contains(text(),'Operating Account Statement')]/following::div[11]/div/div/div/a[3]")
	private WebElement operAccStmtBtn;

	@FindBy(how = How.XPATH, using = "//div[text()='As At Date Header']")
	private WebElement asDateHdr;

	@FindBy(how = How.XPATH, using = "//div[text()='Company']")
	private WebElement companyHdr;

	public ReportsObj(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCashBtn() {
		return cashBtn;
	}

	public WebElement getViewBtn() {
		return viewBtn;
	}

	public WebElement getReportBtn() {
		return reportBtn;
	}

	public WebElement getNotiBtn() {
		return notibtn;
	}

	public WebElement getWorCapBtn() {
		return worCapBtn;
	}

	public WebElement getDown() {
		return down;
	}

	public WebElement getAccNo() {
		return accNo;
	}

	public WebElement getAccountChkBx() {
		return accountChkbx;
	}

	public WebElement getEmpare() {
		return empare;
	}

	public WebElement getRolldtbtn() {
		return rolldtbtn;
	}

	public WebElement getDurationTxt() {
		return durationTxt;
	}

	public WebElement getExportBtn() {
		return exportbtn;
	}

	public WebElement getExportFBtn() {
		return exportFBtn;
	}

	public WebElement getOperAccDtlsBtn() {
		return operAccDtlsBtn;
	}

	public List<WebElement> getRepcollst() {
		return repcollst;
	}

	public WebElement getDropColmArea() {
		return dropColmArea;
	}

	public WebElement getOperAccStmtBtn() {
		return operAccStmtBtn;
	}

	public WebElement getSubScrBtn() {
		return subScrBtn;
	}

	public WebElement getAsDatHdr() {
		return asDateHdr;
	}

	public WebElement getCompanyHdr() {
		return companyHdr;
	}

}