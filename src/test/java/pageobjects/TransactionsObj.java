package pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import pages.BasePage;

public class TransactionsObj extends BasePage {
	
	@FindBy(how = How.XPATH, using = "//html/body/div[2]/div/div/div/aside/div/div/ul/li[2]/a/div/label/span/img")
	private WebElement cashOptn;

	@FindBy(how = How.XPATH, using = "//label[text()='Transactions']")
	private WebElement transactions;

	@FindBy(how = How.XPATH, using = "//label[text()='Manage']")
	private WebElement manageBtn;

	@FindBy(how = How.XPATH, using = "(//div[@class='PaymentRefNo__RefCard-lbIgNx eOoDqt']/span)[1]")
	private WebElement paymentLink;
	
	@FindBy(how = How.XPATH, using = "//div[@class='s2b-label--light s2b-label--extra-large s2b-label--primaryColor2 payment-reference-number ember-view']/label")
	private WebElement paymentRefLbl;
		
	@FindBy(how = How.XPATH, using = "//span[text()='Summary']")
	private WebElement paymentSummary;

	@FindBy(how = How.XPATH, using = "//div[text()='Manual Payment Summary']")
	private WebElement paymentsSummaryTxt;
	
	@FindBy(how = How.XPATH, using = "//p[text()='BACK']")
	private WebElement backBtnSummary;

	@FindBy(how = How.XPATH, using = "//div[@class='TableToolsstyles__ContainerDiv-josVCx kPLpuC']/child::div/div[2]/div[3]/button")
	private WebElement btnSort;

	@FindBy(how = How.XPATH, using = "(//button[@class='css-mad3ld css-1rx5ul0 option css-1p62yv1 css-1mv4lh1 css-1k7m01l'])[1]")
	private WebElement amountSort;
	
	@FindBy(how = How.XPATH, using = "//button[@title= 'Move Right']")
	private WebElement rightBtn;

	@FindBy(how = How.XPATH, using = "//button[@title= 'Move Left']")
	private WebElement leftBtn;

	@FindBy(how = How.XPATH, using = "//div[@title = 'Filter']")
	private WebElement filterTxt;

	@FindBy(how = How.XPATH, using = "//div[@class='TableToolsstyles__SearchDiv-kLXDoc gniGCR']/following::div[1]/button")
	private WebElement filterElement;

	@FindBy(how = How.XPATH, using = "//span[text() = 'Apply']")
	private WebElement filterApplyTxt;
	
	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Show Records Per Page')]/following::div/div/div/input")
	private WebElement recPerPageDrp;
	
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'19')]")
	private WebElement recPerPageCountLbl;
	
	@FindBy(how = How.XPATH, using = "//div[@class='Blotterstyles__StyledPaginationContainer-bOXYeg bVvqPO']/child::div/button")
	private List<WebElement> paginationBtn;
	
	@FindBy(how = How.XPATH, using = "(//button[@class = 'BlotterRowActionsCellstyles__StyledButton-eexkQM iFXORq'])[1]")
	private WebElement threeDots;

	@FindBy(how = How.XPATH, using = "//div[@class = 'ActionsItemstyles__StyledText-Cgthw fuBlcL']")
	private List<WebElement> actionsMenuTable;

	@FindBy(how = How.XPATH, using = "//button[@class = 'ActionsListstyles__StyledCloseButton-VCbKS kfAyiL']")
	private WebElement actionMenuClose;

	@FindBy(how = How.XPATH, using = "//span[text() = 'export list']")
	private WebElement exportList;

	@FindBy(how = How.XPATH, using ="//span[text() = 'EXPORT']")
	private WebElement exportOptn;
	
	@FindBy(how = How.XPATH, using = "//div[@title = 'Customise']")
	private WebElement settingsBtn;
	
	@FindBy(how = How.XPATH, using = "(//div[@class = 'css-1rr4qq7 eltjkzr1'])[5]")
	private WebElement dragOptions;
	
	@FindBy(how = How.XPATH, using = "//button[@class = 'css-mad3ld css-kup8xj']")
	private List<WebElement> dropAreaClose;
		
	@FindBy(how = How.XPATH, using = "//div[@class = 'css-1izx72p e15wa31f7']")
	private WebElement dropOptions;
	
	@FindBy(how = How.XPATH, using = "//span[text() = 'APPLY CHANGES']")
	private WebElement dndApply;
	
	@FindBy(how = How.XPATH, using = "//span[text() = 'CANCEL']")
	private WebElement  dndCancel;

	@FindBy(how = How.XPATH, using = "//div[@class='ReactVirtualized__Grid__innerScrollContainer']/child::div/div[4]")
	private List<WebElement> amountBeforeSort;

	@FindBy(how = How.XPATH, using = "//span[text() = 'APPLY']")
	private WebElement sortApply;

	@FindBy(how = How.XPATH, using = "//div[@class='ReactVirtualized__Grid__innerScrollContainer']/child::div/div[4]")
	private List<WebElement> amountAfterSort;
	
	@FindBy(how = How.XPATH, using = "//button[@class='css-mad3ld checkboxModeButton css-kup8xj']")
	private WebElement multiSelect;
	
	@FindBy(how = How.XPATH, using = "//span[text()='Select all']")
	private WebElement selectAllBtn;
	
	@FindBy(how = How.XPATH, using = "//span[text()='Show selected']")
	private WebElement showSelectBtn;
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Actions')]")
	private WebElement actionsBtn;
		
	@FindBy(how = How.XPATH, using = "//div[@title='Customise']/button")
	private WebElement settingBtn;

    @FindBy(how = How.XPATH, using = "//span[contains(text(),'RESET TO DEFAULT')]")
	private WebElement resetDefault;
    
    @FindBy(how = How.XPATH, using = "//span[contains(text(),'YES')]")
	private WebElement resetYes;
    
    @FindBy(how = How.XPATH, using = "//span[contains(text(),'APPLY CHANGES')]")
   	private WebElement applyChgs;

	public TransactionsObj(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	public WebElement getCashOptn() {
		return cashOptn;
	}


	public WebElement getTransactions() {
		return transactions;
	}


	public WebElement getManageBtn() {
		return manageBtn;
	}


	public WebElement getPaymentLink() {
		return paymentLink;
	}

	public WebElement getPaymentRefLbl() {
		return paymentRefLbl;
	}
	public WebElement getRecPerPageCountLbl() {
		return recPerPageCountLbl;
	}

	public List<WebElement> getPaginationBtn() {
		return paginationBtn;
	}
	public WebElement getActionsBtn() {
		return actionsBtn;
	}

	public WebElement getPaymentSummary() {
		return paymentSummary;
	}


	public WebElement getPaymentsSummaryTxt() {
		return paymentsSummaryTxt;
	}


	public WebElement getBackBtnSummary() {
		return backBtnSummary;
	}


	public WebElement getBtnSort() {
		return btnSort;
	}


	public WebElement getAmountSort() {
		return amountSort;
	}


	public WebElement getRightBtn() {
		return rightBtn;
	}


	public WebElement getLeftBtn() {
		return leftBtn;
	}


	public WebElement getFilterTxt() {
		return filterTxt;
	}
	


	public WebElement getFilterElement() {
		return filterElement;
	}


	public WebElement getRecPerPageDrp() {
		return recPerPageDrp;
	}

	public WebElement getFilterApplyTxt() {
		return filterApplyTxt;
	}


	public WebElement getThreeDots() {
		return threeDots;
	}


	public List<WebElement> getActionsMenuTable() {
		return actionsMenuTable;
	}


	public WebElement getActionMenuClose() {
		return actionMenuClose;
	}


	public WebElement getExportList() {
		return exportList;
	}


	public WebElement getExportOptn() {
		return exportOptn;
	}


	public WebElement getSettingsBtn() {
		return settingsBtn;
	}


	public WebElement getDragOptions() {
		return dragOptions;
	}


	public List<WebElement> getDropAreaClose() {
		return dropAreaClose;
	}


	public WebElement getDropOptions() {
		return dropOptions;
	}


	public WebElement getDndApply() {
		return dndApply;
	}


	public WebElement getDndCancel() {
		return dndCancel;
	}


	public WebElement getSortApply() {
		return sortApply;
	}


	public List<WebElement> getAmountAfterSort() {
		return amountAfterSort;
	}


	public WebElement getMultiSelect() {
		return multiSelect;
	}


	public WebElement getSelectAllBtn() {
		return selectAllBtn;
	}


	public WebElement getShowSelectBtn() {
		return showSelectBtn;
	}


	public WebElement getSettingBtn() {
		return settingBtn;
	}


	public WebElement getResetDefault() {
		return resetDefault;
	}


	public WebElement getResetYes() {
		return resetYes;
	}


	public WebElement getApplyChgs() {
		return applyChgs;
	}


	public List<WebElement> getAmountBeforeSort() {
		return amountBeforeSort;
	}

	
	
}