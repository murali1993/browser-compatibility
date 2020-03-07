
package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.applitools.eyes.BatchInfo;
import com.applitools.eyes.EyesRunner;
import com.applitools.eyes.selenium.ClassicRunner;
import com.applitools.eyes.selenium.Eyes;

import utils.DriverConfig;

public class BasePage {

	public static WebDriver driver;
	public static EyesRunner runner;
	public static Eyes eyes;
	public static BatchInfo batch;

	public BasePage() {
		this.driver = DriverConfig.getDriver();
	}

	public void implicitWait() {
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	public void ThreadWait(long duration) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void jsExecutor(WebElement ele) {
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].click()", ele);
	}

	public void clickOnHamburger() throws InterruptedException {
		WebElement menuclick;
		System.out.println("before thread=============");
		Thread.sleep(60000);
		System.out.println("after thread=============");
		WebDriverWait wait = new WebDriverWait(driver, 70);
		Thread.sleep(5000);
		menuclick = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Menu')]")));
		System.out.println("after wait=============");
		jsExecutor(menuclick);
		ThreadWait(5000);

	}
	
	/*public void initiateEyes(String pageName, WebDriver driver) {
		
		runner = new ClassicRunner();
		eyes = new Eyes(runner);
		eyes.setApiKey("0a8S76Xg105iLG3S3AWD2xmSm105mgDjzmKbaRTW2Km6YWE110");
		eyes.setBatch(new BatchInfo("S2BNG"));	
		eyes.open(driver, "S2BNG", pageName);
		
	}*/
	
	public void initiateEyes(String pageName, WebDriver driver, String batchname) {
		   
        runner = new ClassicRunner();
        eyes = new Eyes(runner);
//        eyes.setApiKey("ebepoJIY0EWG51qEentJU3p1hu108y96sovWGDlJPFZMo110");
        eyes.setApiKey("Ar991001012tGj673EYuI081tVvg1GtWNn29r4Hot6zUIpTI110");
        eyes.setBaselineEnvName("Browserstack - Baseline");
        eyes.setForceFullPageScreenshot(true);
        eyes.setBatch(new BatchInfo(batchname));   
//        eyes.open(driver, "S2BNG", pageName, new RectangleSize(929,888));
        eyes.open(driver, "S2BNG", pageName);
       
    }

}