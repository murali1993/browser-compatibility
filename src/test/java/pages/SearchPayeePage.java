package pages;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import pageobjects.SearchPayeeObj;

public class SearchPayeePage extends BasePage {

	public void navigateFundtransfers() throws Throwable {
		SearchPayeeObj searchPayeeObj = new SearchPayeeObj(driver);
		ThreadWait(2000);
		searchPayeeObj.getCashOptn().click();
		ThreadWait(2000);
		searchPayeeObj.getCreateOptn().click();
		ThreadWait(2000);
		searchPayeeObj.getFundTransfersOptn().click();
		implicitWait();
	}

	public void searchpaye() throws InterruptedException {
		SearchPayeeObj searchPayeeObj = new SearchPayeeObj(driver);
		Thread.sleep(5000);
		searchPayeeObj.getSearchField().sendKeys("shp");
		ThreadWait(2000);

	}
	public void searchResultAssertion()
	{
		SearchPayeeObj searchPayeeObj = new SearchPayeeObj(driver);
		if ((searchPayeeObj.getSearchedTextResult().getText()) != null) {

			System.out.println("Displayed search result " + searchPayeeObj.getSearchedTextResult().getText());
		} else {
			Assert.fail("No result displayed for the search");
		}
		
	}
	public void selectPayee()
	{   SearchPayeeObj searchPayeeObj = new SearchPayeeObj(driver);
		searchPayeeObj.getSearchedTextResult().click();
	}

	public void invoiceSection() throws InterruptedException {
		SearchPayeeObj searchPayeeObj = new SearchPayeeObj(driver);
		Thread.sleep(2000);

		jsExecutor(searchPayeeObj.getPaymentMethod());

		jsExecutor(searchPayeeObj.getPayeeTxtBox());

		searchPayeeObj.getPayeeTxtBox().sendKeys("shp");
		Thread.sleep(13000);
		
		searchPayeeObj.getPayee().click();
		Thread.sleep(8000);
		searchPayeeObj.getPayAmount().sendKeys("2000");
		Thread.sleep(8000);
		searchPayeeObj.getOutsideClick().click();

		implicitWait();
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		Actions act=new Actions(driver);
		
		act.moveToElement(searchPayeeObj.getInvoiceLbl());
		Thread.sleep(5000);
		if(searchPayeeObj.getInvoiceLbl().getText().equalsIgnoreCase("INVOICE DETAILS"))
		{
			System.out.println("INVOICE DETAILS is displayed");
		}else{
			Assert.fail("INVOICE DETAILS is not displayed");
		}}
		
	public void selectInvoice()
	{
		
		SearchPayeeObj searchPayeeObj = new SearchPayeeObj(driver);
		jsExecutor(searchPayeeObj.getInvoiceTP());

		searchPayeeObj.getInvoiceTP().sendKeys(Keys.DOWN, Keys.ENTER);

		jsExecutor(searchPayeeObj.getContinueBtn());
		implicitWait();

		

	}
	
	public void addInvoice()
	{    SearchPayeeObj searchPayeeObj = new SearchPayeeObj(driver);
		searchPayeeObj.getSubmitBtn().click();
		ThreadWait(2000);
		
	}
	
	public void addRecords()
	{
		SearchPayeeObj searchPayeeObj = new SearchPayeeObj(driver);
		ThreadWait(3000);
		searchPayeeObj.getAddRecordsBtn().click();
	}
	
	public void addInvoiceRecords()
	{
		SearchPayeeObj searchPayeeObj = new SearchPayeeObj(driver);
		ThreadWait(3000);
		if(searchPayeeObj.getAddInvRecordsLbl().getText().contains("ADD INVOICE RECORDS"))
		{
		System.out.println("ADD INVOICE RECORDS overlay is displayed");	
		}else{
			Assert.fail("ADD INVOICE RECORDS overlay is not displayed");
		}
	}
	
	public void saveInvoiceRecords()
	{
		SearchPayeeObj searchPayeeObj = new SearchPayeeObj(driver);
		ThreadWait(3000);
		searchPayeeObj.getInvoiceDesTxt().sendKeys("Invoice1");
		searchPayeeObj.getInvoiceAmtTxt().sendKeys("5000");
		ThreadWait(3000);
		searchPayeeObj.getInvoiceAmtPlane().click();
		ThreadWait(2000);
		searchPayeeObj.getSaveRecordsBtn().click();
		ThreadWait(2000);
		if(!(searchPayeeObj.getSavedRecordCount().getText().isEmpty()))
		{
			System.out.println("Total records added is: "+searchPayeeObj.getSavedRecordCount().getText());
		}else{
			Assert.fail("No invoice record added");
		}
	}
	
	public void invoiceRecordsValidation()
	{
		SearchPayeeObj searchPayeeObj = new SearchPayeeObj(driver);
		ThreadWait(3000);
		if(searchPayeeObj.getInvoiceAmountLbl().getText().contains(searchPayeeObj.getTotlInvAmountLbl().getText()))
		{
			System.out.println("Total invoice is displayed in the Invoice Section");
		}else{
			Assert.fail("Total invoice is not displayed in the Invoice Section");
		}
	}
	

	public boolean verifyPayment() {
		SearchPayeeObj searchPayeeObj = new SearchPayeeObj(driver);
		String title = searchPayeeObj.getTxtVerification().getText();

		if (title.equals("YOUR PAYMENT HAS BEEN SUBMITTED SUCCESSFULLY")) {
			return true;
		} else {
			return false;
		}
	}

}