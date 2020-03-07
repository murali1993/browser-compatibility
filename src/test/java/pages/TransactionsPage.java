package pages;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageobjects.TransactionsObj;
import utils.DriverConfig;

public class TransactionsPage extends BasePage {

	public static List<BigDecimal> amtlst = new ArrayList<BigDecimal>();
	public static BigDecimal totlsum = BigDecimal.ZERO;
	public static BigDecimal upSum = BigDecimal.ZERO;
	public static int size = 0;

	public static List<BigDecimal> getAmtlst() {
		return amtlst;
	}

	public static BigDecimal getTotlsum() {
		return totlsum;
	}

	public static BigDecimal getUpSum() {
		return upSum;
	}

	public static int getSize() {
		return size;
	}

	public void navigateToPaymentScreen() throws InterruptedException {
		TransactionsObj tran = new TransactionsObj(driver);
		jsExecutor(tran.getCashOptn());
//		tran.getCashOptn().click();
		ThreadWait(3000);

		//tran.getManageBtn().click();
		jsExecutor(tran.getManageBtn());
		ThreadWait(3000);

		//tran.getTransactions().click();
		jsExecutor(tran.getTransactions());
		implicitWait();
		

	}

	public void verifyPaymentSummaryPage() throws InterruptedException {
		TransactionsObj tran = new TransactionsObj(driver);
		Thread.sleep(5000);
        String refID=tran.getPaymentLink().getText();
		tran.getPaymentLink().click();
		implicitWait();
		String Validation = tran.getPaymentsSummaryTxt().getText();
		Assert.assertEquals(Validation, "MANUAL PAYMENT SUMMARY");
	 
		 
		if(refID.contains(tran.getPaymentRefLbl().getText()))
		{
			System.out.println("MANUAL PAYMENT SUMMARY page is displayed for the ref number:"+tran.getPaymentRefLbl().getText());
		}else
		{
			Assert.fail("MANUAL PAYMENT SUMMARY page is not displayed for the ref number:"+tran.getPaymentRefLbl().getText());
		}
			
		Actions act=new Actions(driver);
		act.moveToElement(tran.getBackBtnSummary()).click().build().perform();
		Thread.sleep(2000);
		try {
			if(tran.getBackBtnSummary().isDisplayed())
			{
			jsExecutor(tran.getBackBtnSummary());
			}	
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

	public void verifySorting() throws Throwable {

		TransactionsObj tran = new TransactionsObj(driver);

		ArrayList<BigDecimal> beforesorting = new ArrayList<BigDecimal>();
		List<WebElement> elementList = tran.getAmountBeforeSort();

		for (WebElement we : elementList) {
			BigDecimal bigDecimal;
			System.out.println(we.getText());
			beforesorting.add(bigDecimal = new BigDecimal(we.getText().replace(",", "").replace("HKD ", "")));
		}
		System.out.println(beforesorting);
		Collections.sort(beforesorting);
		System.out.println(beforesorting);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", tran.getBtnSort());
		js.executeScript("arguments[0].click()", tran.getAmountSort());
		js.executeScript("arguments[0].click()", tran.getSortApply());
		Thread.sleep(5000);
		ArrayList<BigDecimal> aftersorting = new ArrayList<BigDecimal>();
		List<WebElement> elementList1 = tran.getAmountBeforeSort();

		for (WebElement we1 : elementList) {
			BigDecimal bigDecimal2;
			aftersorting.add(bigDecimal2 = new BigDecimal(we1.getText().replace(",", "").replace("HKD ", "")));
		}

		System.out.println(aftersorting);

		Assert.assertTrue(beforesorting.equals(aftersorting));
	}

	public void multiSelect() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement msel = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@class='TableToolsstyles__ControlsDiv-kQGTpm eRpHHt']/child::div/div/div/button")));

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-1000)");

		ThreadWait(8000);
		jsExecutor(msel);
		//.click();
		
	}

	public boolean selectAll() throws InterruptedException {
		TransactionsObj tran = new TransactionsObj(driver);
		ThreadWait(5000);
		if (tran.getSelectAllBtn().getText().contains("SELECT ALL")) {
			return true;
		} else {
			return false;
		}
	}

	public boolean actionsEnable() throws InterruptedException {
		ThreadWait(5000);
		TransactionsObj tran = new TransactionsObj(driver);
		if (tran.getActionsBtn().getText().contains("ACTIONS")) {
			return true;
		} else {
			return false;
		}
	}

	public void selectMultiTrans() throws InterruptedException {
		for (int i = 1; i < 4; i++) {
			WebElement checkBoxTranRow = driver
					.findElement(By.xpath("//div[@class='ReactVirtualized__Grid__innerScrollContainer']/child::div[" + i
							+ "]/div[1]/div/div/span/label/input"));
			Thread.sleep(4000);
			jsExecutor(checkBoxTranRow);
			//.click();
		}
		TransactionsObj tran = new TransactionsObj(driver);
		jsExecutor(tran.getShowSelectBtn());
		//.click();
	}

	public boolean verifyAmount() {
		List<WebElement> amtellst = driver.findElements(By.xpath(
				"//div[@aria-colindex = '5']"));
	
		for (WebElement el : amtellst) {

			String amt = el.getText();

			String updatedamt = amt.substring(4, amt.length() );
			String Updateamt = updatedamt.replace(",", "");
			BigDecimal bigDecimalCncy = new BigDecimal(Updateamt);
			amtlst.add(bigDecimalCncy);
		}

		for (BigDecimal el : amtlst) {
			totlsum = totlsum.add(el);

		}
		WebElement sumhdr = driver
				.findElement(By.xpath("(//span[@class='PaymentDashboard__ValueContiner-bRAOXf bTkeuW'])[2]"));
		System.out.println("Total sum for selected: " + totlsum);
		amtlst.clear();

		if (sumhdr.getText().replace(",", "").contains(totlsum.toString())) {
			return true;

		} else {
			return false;
		}

	}

	public void unselectTrans() throws InterruptedException {
		for (int i = 2; i < 3; i++) {
			WebElement checkBoxTranRow = driver
					.findElement(By.xpath("//div[@class='ReactVirtualized__Grid__innerScrollContainer']/child::div[" + i
							+ "]/div[1]/div/div/span/label/input"));
			//checkBoxTranRow.click();
			Thread.sleep(3000);
			jsExecutor(checkBoxTranRow);
		}

	}

	public boolean updatedAmountSumCk() {
		List<WebElement> amtellst = driver.findElements(By.xpath(
				"//div[@aria-colindex = '5']"));
		for (WebElement el : amtellst) {

			String amt = el.getText();

			String updatedamt = amt.substring(4, amt.length());

			BigDecimal bigDecimalCncy = new BigDecimal(updatedamt.replace(",", ""));
			amtlst.add(bigDecimalCncy);
		}

		for (BigDecimal el : amtlst) {
			upSum = upSum.add(el);

		}
		WebElement sumhdr = driver
				.findElement(By.xpath("(//span[@class='PaymentDashboard__ValueContiner-bRAOXf bTkeuW'])[2]"));
		System.out.println("Total sum after updated: " + upSum);
		System.out.println(sumhdr.getText().replace(",", ""));
		System.out.println(upSum.toString());
		if (sumhdr.getText().replace(",", "").contains(upSum.toString())) {
			return true;
		} else {
			return false;
		}
	}

	public void settings() throws InterruptedException {
		TransactionsObj tran = new TransactionsObj(driver);
		ThreadWait(5000);
		jsExecutor(tran.getSettingBtn());
//		tran.getSettingBtn().click();
		ThreadWait(3000);
	}

	public void reset() throws InterruptedException {
		TransactionsObj tran = new TransactionsObj(driver);
		//tran.getResetDefault().click();
		jsExecutor(tran.getResetDefault());
		ThreadWait(3000);
		//tran.getResetYes().click();
		jsExecutor(tran.getResetYes());
		ThreadWait(3000);
	}

	public boolean applyChangess() throws InterruptedException {
		TransactionsObj tran = new TransactionsObj(driver);
		Thread.sleep(5000);
		Actions act = new Actions(driver);
		act.moveToElement(tran.getApplyChgs()).build().perform();
		Thread.sleep(5000);
		//tran.getApplyChgs().click();
		jsExecutor(tran.getApplyChgs());
		ThreadWait(3000);
		List<WebElement> hdrlst = driver.findElements(By.xpath("//div[@class = 'css-nsezcw eijyc9d0']"));
		System.out.println(hdrlst);
		for (WebElement el : hdrlst) {
			if (!(el.getText().contains("DEBIT ACCOUNT NUMBER"))) {
				return false;
			}
		}	
			return true;
		
	}
	
	
	public void columnTraverse() throws InterruptedException {

		TransactionsObj obj = new TransactionsObj(driver);

		ThreadWait(5000);
		jsExecutor(obj.getRightBtn());
		ThreadWait(5000);
		
		
		if(obj.getLeftBtn().isDisplayed())
		{
			jsExecutor(obj.getLeftBtn());
			System.out.println("Column traverse navigation is working as expected");
		}else{
			Assert.fail("Column traverse navigation is not working as expected");
		}
		ThreadWait(5000);
	
	}

	public void verifyThreeDotsMenu() throws Throwable {

		int count = 0;
		TransactionsObj transObj = new TransactionsObj(driver);

		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement msel = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[@class='TableToolsstyles__ControlsDiv-kQGTpm eRpHHt']/child::div/div/div/button")));
		Actions act = new Actions(driver);

		ThreadWait(5000);
		act.moveToElement(msel).build().perform();
		ThreadWait(5000);
		jsExecutor(msel);
		//msel.click();

		ArrayList<String> Menulistitems = new ArrayList<String>();
		Menulistitems.add("EXPORT");
		Menulistitems.add("PRINT");

		jsExecutor(transObj.getThreeDots());
		ThreadWait(500);

		ArrayList<String> Menulist = new ArrayList<String>();
		List<WebElement> Menuelements = transObj.getActionsMenuTable();

		for (WebElement we1 : Menuelements) {
			Menulist.add(we1.getText());
		}

		if (Menulist.contains(Menulistitems.get(0))) {
			count++;
		}
		if (Menulist.contains(Menulistitems.get(1))) {
			count++;
		}
		if (count == 0) {
			Assert.fail("Menu not displayed");
		}
		jsExecutor(transObj.getActionMenuClose());
		//transObj.getActionMenuClose().click();

	}

	public void verifyExport() throws Throwable {

		TransactionsObj transObj = new TransactionsObj(driver);
		jsExecutor(transObj.getExportList());
		jsExecutor(transObj.getExportOptn());
		Thread.sleep(5000);	
		
	}

	public void filter() throws InterruptedException {
		TransactionsObj transObj = new TransactionsObj(driver);
		Thread.sleep(5000);
		//transObj.getFilterElement().click();
		jsExecutor(transObj.getFilterElement());
		ThreadWait(500);
		jsExecutor(transObj.getFilterTxt());
		ThreadWait(500);
		jsExecutor(transObj.getRecPerPageDrp());
//		transObj.getRecPerPageDrp().click();
		transObj.getRecPerPageDrp().sendKeys(Keys.DOWN);
		ThreadWait(500);
		transObj.getRecPerPageDrp().sendKeys(Keys.ENTER);
		ThreadWait(500);
		jsExecutor(transObj.getFilterApplyTxt());
		ThreadWait(7000);
		
		if(transObj.getRecPerPageCountLbl().getText().contains("19"))
		{
			System.out.println("Record per page is updated as 19");
		}else{
			//Assert.fail("Record per page is not updated as 1-20");
		}
		
		
	}
	
	public void pagination() throws InterruptedException {
		TransactionsObj transObj = new TransactionsObj(driver);
		for(WebElement el:transObj.getPaginationBtn())
		{
			String temp=el.getText();
			//System.out.println(temp);
			if(el.getText().equals("2"))
			{
				ThreadWait(3000);
				jsExecutor(el);
//				el.click();
				ThreadWait(5000);
				if(transObj.getRecPerPageCountLbl().getText().contains("11"))
				{
					System.out.println("Pagination Achieved");
				}else{
					Assert.fail("Pagination not Achieved");
				}
			}
		}
		
		
	}
	

}