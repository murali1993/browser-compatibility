package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class DashbordObj {

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Menu')]")
	public WebElement menuBtn;

	@FindBy(how = How.XPATH, using = "//ul[@class='menu-list-new']/child::li[4]/a/div/label")
	public WebElement settingsBtn;

	@FindBy(how = How.XPATH, using = "//div[@class='menu-content-new menu-content--active menu-content-item-heading']/child::div/a[2]/div/label")
	public WebElement manageDashBtn;

	@FindBy(how = How.XPATH, using = "//div[@unique-widget-id='quick-payments2']/child::span")
	public WebElement quickPayclBtn;

	@FindBy(how = How.XPATH, using = "//span[@id='quick-navigation7']']")
	public WebElement quickNavclBtn;

	@FindBy(how = How.XPATH, using = "//img[@src='assets/images/dashboard/widgets/quick-payments.svg']")
	public WebElement fromArea;

	@FindBy(how = How.XPATH, using = "//div[@id='2' or @id ='5' or@id='8']")
	public WebElement toArea;

	@FindBy(how = How.XPATH, using = "//div[@class='large-12 medium-12 small-12 columns s2b-action-bar-component']/child::div/ul")
	public WebElement saveBtn;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Quick Payment')]")
	public WebElement quickPayTile;

	public DashbordObj(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getMenuBtn() {
		return menuBtn;
	}

	public WebElement getSettingsBtn() {
		return settingsBtn;
	}

	public WebElement getManageDashBtn() {
		return manageDashBtn;
	}

	public WebElement getQuickPayBtn() {
		return quickPayclBtn;
	}

	public WebElement getQuickNavclBtn() {
		return quickNavclBtn;
	}

	public WebElement getFromArea() {
		return fromArea;
	}

	public WebElement getToArea() {
		return toArea;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getQuickPayTile() {
		return quickPayTile;
	}

}
