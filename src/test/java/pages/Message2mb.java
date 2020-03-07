package pages;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Message2mb extends BasePage {

	@FindBy(how = How.XPATH, using = "//p[text() = 'Messages']")
	private WebElement Messagesicon;

	@FindBy(how = How.XPATH, using = "(//div[@class = 'category s2b-label--regular s2b-label--extra-small s2b-label--primaryColor2 ember-view'])[2]")
	private WebElement reporting;

	@FindBy(how = How.XPATH, using = "(//div[@class = 'clearfix message-row-container'])[1]")
	private WebElement Messages;

	@FindBy(how = How.XPATH, using = "//div[@class='s2b-label--light s2b-label--large s2b-label--primaryColor2 ember-view']/label")
	private WebElement Messagesize;

	public Message2mb(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getMessagesicon() {
		return Messagesicon;
	}

	public WebElement getReporting() {
		return reporting;
	}

	public WebElement getMessages() {
		return Messages;
	}

	public WebElement getMessagesize() {
		return Messagesize;

	}

	public void selectReportingCat() throws Throwable {
		Message2mb msg1 = new Message2mb(driver);
		jsExecutor( msg1.reporting);
		ThreadWait(1000);
	}

	public void messages2mb() {
		Message2mb msg1 = new Message2mb(driver);
		jsExecutor(msg1.Messages);
		String attachmenttext = Messagesize.getText().replace(" MB", "");
		int attachmentsize = Integer.parseInt(attachmenttext);
		if (attachmentsize > 2) {

			jsExecutor(Messagesize);
		}

		Set<String> s1 = driver.getWindowHandles();
		int a = s1.size();
		if (a > 1) {
			System.out.println("File Downloading");
		}

	}

}
