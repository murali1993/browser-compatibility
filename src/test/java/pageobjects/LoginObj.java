package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginObj {

	@FindBy(how = How.XPATH, using = "//label[@for='userid_email-name']/parent::div/input")
	public WebElement userID;

	@FindBy(how = How.XPATH, using = "//label[@for='group_id-name']/parent::div/input")
	private WebElement groupID;

	@FindBy(how = How.XPATH, using = "//label[text()='Remember me']")
	private WebElement remCk;

	@FindBy(how = How.XPATH, using = "//p[text()='CONTINUE']")
	private WebElement contBtn;

	@FindBy(how = How.XPATH, using = "//label[@for='unified_password-name']/parent::div/input")
	private WebElement password;

	@FindBy(how = How.XPATH, using = "//p[text()='LOGIN']")
	private WebElement loginBtn;

	public LoginObj(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getUserID() {
		return userID;
	}

	public WebElement getGroupID() {
		return groupID;
	}

	public WebElement getRemCk() {
		return remCk;
	}

	public WebElement getContBtn() {
		return contBtn;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}

}
