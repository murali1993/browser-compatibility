package pages;

import java.awt.AWTException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import pageobjects.ReportsObj;

public class ReportsPage extends BasePage {

	public int isFileDownloaded(String path) {
		File dir = new File(path);
		File[] dir_contents = dir.listFiles();
		int length = dir_contents.length;
		return length;

	}

	public void notification() throws InterruptedException {
		ReportsObj rept = new ReportsObj(driver);
		Thread.sleep(5000);
		rept.getNotiBtn().click();
	}

	public void reportDownload() throws InterruptedException {
		ReportsObj rept = new ReportsObj(driver);
		rept.getWorCapBtn().click();
		ThreadWait(3000);

		rept.getDown().click();

		ThreadWait(5000);

		rept.getAccNo().click();
		ThreadWait(2000);

		rept.getAccountChkBx().click();
		ThreadWait(2000);

		rept.getEmpare().click();
		ThreadWait(2000);

		rept.getRolldtbtn().click();

		rept.getDurationTxt().click();
		rept.getDurationTxt().clear();
		rept.getDurationTxt().sendKeys("Current Date - 12 months");
		rept.getDurationTxt().sendKeys(Keys.ARROW_DOWN);
		rept.getDurationTxt().sendKeys(Keys.ENTER);
		ThreadWait(5000);

		rept.getExportBtn().click();
		ThreadWait(5000);

		rept.getExportFBtn().click();
		ThreadWait(5000);

	}

	private static String readJSFile(String filePath) throws FileNotFoundException {
		StringBuilder contentBuilder = new StringBuilder();
		BufferedReader br = new BufferedReader(new FileReader(filePath));
		try {

			String sCurrentLine;
			while ((sCurrentLine = br.readLine()) != null) {
				contentBuilder.append(sCurrentLine).append("\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return contentBuilder.toString();
	}

	public void dragAndDrop(String dragSource, String dropTarget) throws FileNotFoundException {
		System.out.println("Drag and Drop started :");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String jsfile = readJSFile("drag_and_drop_helper.js");

		js.executeScript(jsfile + "$('" + dragSource + "').simulateDragDrop({ dropTarget: '" + dropTarget + "'});");

		System.out.println("Drag and Drop completed");
	}

	public void dand(WebElement dragSource, WebElement dropTarget) throws FileNotFoundException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String jsfile = readJSFile("draganddrop.js")
				+ "executeDrageAndDrop(arguments[0], arguments[1])";

		js.executeScript(jsfile, dragSource, dropTarget);

	}

	public void oadReportAddColumn() throws InterruptedException, AWTException, IOException {

		ReportsObj rept = new ReportsObj(driver);
		rept.getWorCapBtn().click();
		ThreadWait(3000);
	
		rept.getOperAccDtlsBtn().click();

		ThreadWait(5000);

		//String dragElement = "#ember2341 > div > div.DragDropTable__container___3zkDW602 > div.sc-bdVaJa.hZbodf > div > div.sc-htpNat.dlYZyy > div > div.DragDropTable__dragDropContainer___GjZ3O602 > div > div > div > div > div:nth-child(9)";
		//String dropElement = "#ember2341 > div > div.DragDropTable__container___3zkDW602 > div.sc-bdVaJa.hZbodf > div > div.sc-htpNat.hsMSZV > div > div > div > div:nth-child(1) > div";
		WebElement from=driver.findElement(By.xpath("//div[contains(text(),'Company')]"));
		WebElement to=driver.findElement(By.xpath("//div[contains(@class,'ReactVirtualized__Grid VirtualizedTable__body___278Sj')]"));
		dand(from, to);

		System.out.println("Drag and Drop completed");

	}

	public void oasReportAddColumn() throws InterruptedException, AWTException, IOException {

		ReportsObj rept = new ReportsObj(driver);
		ThreadWait(3000);
		rept.getOperAccStmtBtn().click();
		ThreadWait(5000);
		WebElement accdtl = driver.findElement(By.xpath("//div[text()='Account Details']/child::span"));
		accdtl.click();
		String dragElement = "#ember4315 > div > div.DragDropTable__container___3zkDW602 > div.sc-bdVaJa.hZbodf > div > div.sc-htpNat.dlYZyy > div > div.DragDropTable__dragDropContainer___GjZ3O602 > div > div > div > div > div:nth-child(9)";
		String dropElement = "#ember4315 > div > div.DragDropTable__container___3zkDW602 > div.sc-bdVaJa.hZbodf > div > div.sc-htpNat.hsMSZV > div > div > div > div:nth-child(1) > div > div.ReactVirtualized__Grid.VirtualizedTable__body___278Sj602 > div > div.Sortable__cell___2feKB602.Sortable__cellMouseover___M8i09602";
		dragAndDrop(dragElement, dropElement);

	}

	public String geOADReportColTxt() {
		WebElement edit = driver.findElement(By
				.xpath("(//div[@class='ReactVirtualized__Grid__innerScrollContainer'])[1]/child::div[1]/button/span"));
		String beforeEdit = edit.getText();
		return beforeEdit;

	}

	public String getOASReportColTxt() {
		WebElement edit = driver.findElement(By
				.xpath("(//div[@class='ReactVirtualized__Grid__innerScrollContainer'])[1]/child::div[1]/button/span"));
		String beforeEdit = edit.getText();
		return beforeEdit;

	}

	public void subReports() throws InterruptedException {
		ReportsObj rept = new ReportsObj(driver);
		rept.getSubScrBtn().click();
		ThreadWait(3000);

	}

	public void openSubReport(String report) {

		WebElement openSub = driver.findElement(By.xpath(
				"//a[text()='Operating Account Details_" + report + "']/following::div[7]//div[2]/div/div/a/span"));
		openSub.click();
	}

	public void oadReportEditCol() {
		WebElement edit = driver.findElement(By
				.xpath("(//div[@class='ReactVirtualized__Grid__innerScrollContainer'])[1]/child::div[1]/button/span"));
		Actions act = new Actions(driver);
		act.moveToElement(edit);
		act.doubleClick(edit);
		act.click();

		act.sendKeys(" Header").build().perform();

	}

	public void oasReportEditCol() {
		WebElement edit = driver.findElement(By
				.xpath("(//div[@class='ReactVirtualized__Grid__innerScrollContainer'])[1]/child::div[1]/button/span"));
		Actions act = new Actions(driver);
		act.moveToElement(edit);
		act.doubleClick(edit);
		act.click();

		act.sendKeys(" Header").build().perform();

	}

	public void continueButton()
	{WebElement continuebtn = driver.findElement(
			By.xpath("//div[@class='s2b-action-bar ember-view']/child::div/div/div[1]/ul[1]/li[1]/div/button"));
	ThreadWait(3000);
	continuebtn.click();}
	public String saveReport(String rptnme) throws InterruptedException

	{
		
		WebElement saveClsbtn = driver.findElement(
				By.xpath("//div[@class='s2b-action-bar ember-view']/child::div/div/div[1]/ul[1]/li[2]/div/button"));
		ThreadWait(3000);
		saveClsbtn.click();
		WebElement rptName = driver
				.findElement(By.xpath("//input[@class='s2b-textfield ember-text-field ember-view']"));
		ThreadWait(3000);
		rptName.sendKeys(rptnme);
		WebElement submtBtn = driver.findElement(By.xpath("//p[text()='SUBMIT']"));
		ThreadWait(3000);

		submtBtn.click();
		return rptnme;

	}

}