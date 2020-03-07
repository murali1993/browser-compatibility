package pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Assert;
import org.openqa.selenium.Keys;

import pageobjects.CollectionsObj;

public class CollectionsPage extends BasePage {
	
	public static String batch_Ref_Number;

	public void navigateDDI() throws Throwable {
		CollectionsObj collectionObj = new CollectionsObj(driver);
		collectionObj.getCashOptn().click();
		collectionObj.getCreateOptn().click();
		boolean b =  collectionObj.getDirectDebitIns().isDisplayed();
		Assert.assertTrue(b);
		System.out.println(" Direct Debit Instructions Menu is displayed");
	}	
		
	public void Clickddi() throws Throwable {
		CollectionsObj collectionObj = new CollectionsObj(driver);
		Thread.sleep(8000);
		collectionObj.getDirectDebitIns().click();
		implicitWait();
	}
	
	public void SelectCreditaccount() throws Throwable {
		
		CollectionsObj collectionObj = new CollectionsObj(driver);
		//collectionObj.getCreditAccount().click();
		Thread.sleep(5000);
		collectionObj.getCreditAccount().sendKeys("SCB");
		Thread.sleep(3000);
		collectionObj.getCreditAccount().sendKeys(Keys.DOWN, Keys.ENTER);
		implicitWait();
		Thread.sleep(5000);
		//collectionObj.getRealTime().click();
		eyes.checkWindow("Realtime section ");
	}
	
	
	public void click_add_ddi() throws Throwable {
		Thread.sleep(5000);
		CollectionsObj collectionObj = new CollectionsObj(driver);
		jsExecutor(collectionObj.getAddDirectdebit());
		implicitWait();
				
	}
	
	public void add_ddi_screen() throws Throwable {
		
		CollectionsObj collectionObj = new CollectionsObj(driver);	
		Thread.sleep(8000);
		boolean b1 = collectionObj.getaddDirectdebit_title().isDisplayed();
		eyes.checkWindow("ADD DIRECT DEBIT TO BATCH screen");
		Assert.assertTrue(b1);
		System.out.println("User Is On Add Direct Debit to batch Instruction Page");
		ThreadWait(2000);
	}

	public void inputs_ddi() throws Throwable {
		CollectionsObj colObj = new CollectionsObj(driver);
		colObj.getMandateRefernce().sendKeys("dummy");
		colObj.getPayeeName().sendKeys("tester");
		colObj.getAccountNum().sendKeys("112211");
		colObj.getAmount().sendKeys("2000");
		Thread.sleep(4000);
		//colObj.getLocalCode().click();
		
		colObj.getLocalCode().sendKeys("ABBEY NATIONAL TREASURY");
	
		colObj.getLocalCode().sendKeys(Keys.DOWN, Keys.ENTER);
		eyes.checkWindow("ADD DIRECT DEBIT TO BATCH screen");
		jsExecutor(colObj.getDebitPurpose());
		Thread.sleep(10000);
		jsExecutor(colObj.getDebitName());
		//colObj.getDebitName().click();
		Thread.sleep(500); 
		
	}
	
	public void Calendar_nav() throws Throwable {
		CollectionsObj colObj = new CollectionsObj(driver);
//		jsExecutorscroll(colObj.getCalendar());
		Thread.sleep(500); 
		String currentdate = colObj.getCalendar().getAttribute("value");
		System.out.println(currentdate);
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy ");
		Date date = new Date();
		String todaydate = dateFormat.format(date);
		jsExecutor(colObj.getcalendararea());
		
		Thread.sleep(100); 
		jsExecutor(colObj.getLeftNav());
		jsExecutor(colObj.getRightNav());
		jsExecutor(colObj.getcalenderoutside());
	}
	
	public void saving_batch() throws Throwable {
		CollectionsObj colObj = new CollectionsObj(driver);
		jsExecutor(colObj.getBtnSave());
		implicitWait();
		Thread.sleep(5000);
		eyes.checkWindow("Saving batch");
	}

	public void Submit_batch() throws Throwable {
		
		CollectionsObj colObj = new CollectionsObj(driver);
		jsExecutor(colObj.getBtnSubmit());
		Thread.sleep(5000);
		eyes.checkWindow("Submit batch");
		
	}
	
	public void Submit_confirm() throws Throwable {
		
		CollectionsObj colObj = new CollectionsObj(driver);
		Thread.sleep(5000);
		jsExecutor(colObj.getBtnCnfSubmit());
		String succesmsg = colObj.getDdiSuccessMsg().getText();
		implicitWait();
		eyes.checkWindow("Your direct debit batch has been successfully submitted ");
		Assert.assertEquals(succesmsg, "YOUR DIRECT DEBIT BATCH HAS BEEN SUCCESSFULLY SUBMITTED");
		implicitWait();
	}

	public void batch_Reference_click() throws Throwable {

		CollectionsObj colObj = new CollectionsObj(driver);
		batch_Ref_Number = colObj.getBatchnumlink().getText();
		jsExecutor(colObj.getBatchnumlink());
		//colObj.getBatchnumlink().click();
		implicitWait();
		
		
	}
	
	public void Verify_batch_Ref_num() throws Throwable {
		CollectionsObj colObj = new CollectionsObj(driver);
		Thread.sleep(100); 
		String batchRefNumber = colObj.getBatchRefnum().getText();
	Assert.assertEquals(batchRefNumber, batch_Ref_Number);
	
	}
	
	public void downArrowclick() throws Throwable {
		
		CollectionsObj colObj = new CollectionsObj(driver);
		jsExecutor(colObj.gettxnDownarrowButton());
		
	
	}
	
	public void verify_additional_info() throws Throwable {
		
		CollectionsObj colObj = new CollectionsObj(driver);
		boolean verify = colObj.getAddition_info().isDisplayed();
		Assert.assertTrue(verify);
		eyes.checkWindow("Additional Information ");
		System.out.println("Additional Information Displayed");
		String debitPurpose = colObj.getDebit_purpose().getText();
		if (debitPurpose.equals("Direct Debit Purpose")) {
			System.out.println("Direct Debit Purpose");
		} 		
	
	}
}
