package pkgWebPages;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pkgDataStore.DataSource;
import pkgSetupFiles.PropertiesSetupFile;
import pkgUtilities.HelperClass;

public class DeclarationBasedWholeTurnover {

	DataSource objDataSource = new DataSource();
//	LinkedHashMap<String, String> inputMap = new LinkedHashMap<String, String>();
	LinkedHashMap<String, String> inputMap = new LinkedHashMap<String, String>();

	PropertiesSetupFile objPSF = new PropertiesSetupFile("DeclarationBasedWholeTurnover");
	HelperClass util = new HelperClass();
	WebElement poluwElement;
	Select drpdwnList;
	String typeOfCover = "Comprehensive";
	String entriesAfterAdding, actualMsg = "All good";
	int entriesBeforeAdding;

	boolean status = false;
	List<WebElement> poluwElements;
	Select statusList;

//	String actualMsg = "All good";

	public void searchInwardDetails(WebDriver driver) {
		try {
			poluwElement = driver.findElement(objPSF.getLocator("link_searchInward"));
			util.waitForElementToBeClickable(driver, poluwElement);
			poluwElement.click();

//			poluwElement = driver.findElement(objPSF.getLocator("txt_titleInwardLookup"));
//			if (util.isElementPresent(poluwElement))
//				System.out.println("Opened: Inward Lookup Pop-up");
//			else {
//				actualMsg = "Failed to open: Inward Lookup Pop-up";
//				System.out.println(actualMsg);
////				return actualMsg;
//			}

//			poluwElement = driver.findElement(objPSF.getLocator("txt_inwardNumber"));
//			util.waitForVisibilityOfElement(driver, poluwElement);
//			poluwElement.sendKeys("0280157024");
			// 0280157024 UAT
			// 0280157015 QA

			poluwElement = driver.findElement(objPSF.getLocator("btn_inwardGetResults"));
			util.waitForElementToBeClickable(driver, poluwElement);
			poluwElement.click();
			Thread.sleep(2000);

			/*
			 * poluwElement = driver.findElement(objPSF.getLocator("date_inwardDateFrom"));
			 * util.waitForVisibilityOfElement(driver, poluwElement); //
			 * util.selectRandomPastDate(poluwElement, 30);
			 * poluwElement.sendKeys("11/09/2022");
			 * 
			 * poluwElement = driver.findElement(objPSF.getLocator("date_inwardDateTo"));
			 * util.waitForVisibilityOfElement(driver, poluwElement); //
			 * util.setCurrentDate(poluwElement); poluwElement.sendKeys("11/10/2022");
			 * 
			 * 
			 */

			poluwElement = driver.findElement(objPSF.getLocator("radiobtn_inward"));
			util.waitForElementToBeClickable(driver, poluwElement);
			poluwElement.click();

			JavascriptExecutor a = (JavascriptExecutor) driver;
			a.executeScript("window.scrollBy(0,-500)");

			poluwElement = driver.findElement(objPSF.getLocator("btn_select_inward"));
			util.waitForElementToBeClickable(driver, poluwElement);
			poluwElement.click();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void searchExporterDetails(WebDriver driver) {
		try {
			Thread.sleep(1000);
			poluwElement = driver.findElement(objPSF.getLocator("link_searchExporter"));
			util.waitForElementToBeClickable(driver, poluwElement);
			poluwElement.click();

			poluwElement = driver.findElement(objPSF.getLocator("txt_titleExporterLookup"));
			util.waitForVisibilityOfElement(driver, poluwElement);

			if (util.isElementPresent(poluwElement))
				System.out.println("Opened: Search Exporter pop-up");
			else
				System.out.println("Failed to open: Search Exporter pop-up");
			// 4364 13859
			poluwElement = driver.findElement(objPSF.getLocator("txt_exporterCode"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.sendKeys("4364");
			// BC000644 BZ000156
			poluwElement = driver.findElement(objPSF.getLocator("txt_expIECode"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.sendKeys("BC000644");

//			poluwElement = driver.findElement(objPSF.getLocator("txt_expIECode"));
//			util.waitForVisibilityOfElement(driver, poluwElement);
//			poluwElement.sendKeys("1234592W");

			poluwElement = driver.findElement(objPSF.getLocator("txt_exporterName"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			// poluwElement.sendKeys("Tata Coffee");

			poluwElement = driver.findElement(objPSF.getLocator("btn_searchExporter"));
			util.waitForElementToBeClickable(driver, poluwElement);
			poluwElement.click();

			Thread.sleep(1000);
			poluwElement = driver.findElement(objPSF.getLocator("radiobtn_exporter"));
			util.waitForElementToBeClickable(driver, poluwElement);
			poluwElement.click();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean fillHeaderDetails(WebDriver driver) throws Exception {
		try {

			Thread.sleep(2000);

			JavascriptExecutor d = (JavascriptExecutor) driver;
			d.executeScript("window.scrollBy(0,-1000)");

			poluwElement = driver.findElement(objPSF.getLocator("link_headerdetails"));
			util.waitForElementToBeClickable(driver, poluwElement);
			poluwElement.click();

			poluwElement = driver.findElement(objPSF.getLocator("link_search_receipt_details"));
			util.waitForElementToBeClickable(driver, poluwElement);
			poluwElement.click();

//			poluwElement = driver.findElement(objPSF.getLocator("txt_headerDeatils_receipt_number"));
//			util.waitForVisibilityOfElement(driver, poluwElement);
//			poluwElement.sendKeys("2022000004");

			poluwElement = driver.findElement(objPSF.getLocator("txt_headerDeatils_receipt_number"));
//			util.waitForVisibilityOfElement(driver, poluwElement);
			Thread.sleep(1000);
			poluwElement.sendKeys("2022002051");

			poluwElement = driver.findElement(objPSF.getLocator("btn_search_receipt_details"));
			util.waitForElementToBeClickable(driver, poluwElement);
			poluwElement.click();

			poluwElement = driver.findElement(objPSF.getLocator("radiobtn_headerDetails"));
			Thread.sleep(2000);
			poluwElement.click();

			poluwElement = driver.findElement(objPSF.getLocator("btn_headersave"));
			util.waitForElementToBeClickable(driver, poluwElement);
			poluwElement.click();

			Thread.sleep(3000);

//			drpdwnList = new Select(driver.findElement(objPSF.getLocator("drpdwn_headerbranchcode")));
//			util.waitForDropdownOptions(driver, drpdwnList);
//			drpdwnList.selectByVisibleText("Kochi Branch");
//
//			drpdwnList = new Select(driver.findElement(objPSF.getLocator("drpdwn_headertypeofcover")));
//			util.waitForDropdownOptions(driver, drpdwnList);
//			drpdwnList.selectByVisibleText("Political");
//
//			drpdwnList = new Select(driver.findElement(objPSF.getLocator("drpdwn_headerfieldcode")));
//			util.waitForDropdownOptions(driver, drpdwnList);
//			drpdwnList.selectByVisibleText("Auditors - Kochi Branch");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	// Exporter Bank Details policy proposal form
	public boolean fillExporterBankDetails(WebDriver driver) throws Exception {
		try {

			Thread.sleep(2000);
			poluwElement = driver.findElement(objPSF.getLocator("link_exporterbankdetails"));
			util.waitForElementToBeClickable(driver, poluwElement);
			poluwElement.click();

			poluwElement = driver.findElement(objPSF.getLocator("check_selectexporterbank"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.click();

			poluwElement = driver.findElement(objPSF.getLocator("btn_exportersave"));
			util.waitForElementToBeClickable(driver, poluwElement);
			poluwElement.click();
			Thread.sleep(4000);
//				driver.switchTo().alert().accept();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public void fillTurnoverBadDets(WebDriver driver) {
		try {

			Thread.sleep(1000);
			inputMap = objDataSource.readData("PolicyProposal");

			poluwElement = driver.findElement(objPSF.getLocator("btn_turnOverBadDebtTab"));
			util.waitForElementToBeClickable(driver, poluwElement);
			poluwElement.click();

			poluwElement = driver.findElement(objPSF.getLocator("btn_activeTab"));
			util.waitForVisibilityOfElement(driver, poluwElement);

			if (poluwElement.getText().contains("Turnover and Bad Debts"))
				System.out.println("Active: Turnover and Bad Debt Details tab");
			else
				System.out.println("Not Active: Turnover and Bad Debt Details tab");

			poluwElement = driver.findElement(objPSF.getLocator("txt_showEntriesInfo"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.getText().replaceAll("[^\\d]", " ").trim().replaceAll(" +", " ");
//			System.out.println(poluwElement.getText().replaceAll("[^\\d]", " ").trim().replaceAll(" +", " "));
//			entriesBeforeAdding = Integer.parseInt(poluwElement.getText().replaceAll("[^\\d]", " "));
//			System.out.println(entriesBeforeAdding);

			// drpdwnList = new Select(driver.findElement(objPSF.getLocator

			drpdwnList = new Select(driver.findElement(objPSF.getLocator("txt_turnOverBadDebt_FinancialYear")));
			util.waitForVisibilityOfElement(driver, poluwElement);
			drpdwnList.selectByValue("2022-2023");

			poluwElement = driver.findElement(objPSF.getLocator("txt_turnOverBadDebt_TotalSalesTurnover"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.sendKeys("9000000");

			poluwElement = driver.findElement(objPSF.getLocator("txt_turnOverBadDebt_TotalExportTurnover"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.sendKeys("9000000");

			poluwElement = driver
					.findElement(objPSF.getLocator("txt_turnOverBadDebt_PerccentageOfExportTurnoverOnAdvance"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.sendKeys("10");

			poluwElement = driver.findElement(objPSF.getLocator("txt_turnOverBadDebt_PercentageOfExportTurnoverOnLC"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.sendKeys("40");

			poluwElement = driver
					.findElement(objPSF.getLocator("txt_turnOverBadDebt_PercentageOfExportTurnoverOnNonLC"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.sendKeys("50");

//			poluwElement = driver.findElement(objPSF.getLocator("txt_turnOverBadDebt_ValueOfBadDebts"));
//			util.waitForVisibilityOfElement(driver, poluwElement);
//			poluwElement.sendKeys("80000000");

			poluwElement = driver.findElement(objPSF.getLocator("txt_turnOverBadDebt_ValueOfBadDebts"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.sendKeys("9000000");

			poluwElement = driver.findElement(objPSF.getLocator("txt_turnOverBadDebt_ActionTaken"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.click();
			poluwElement.sendKeys("No");

//			poluwElement = driver.findElement(objPSF.getLocator("txt_turnOverBadDebt_ProfitLossAfterTax"));
//			util.waitForVisibilityOfElement(driver, poluwElement);
//			poluwElement.sendKeys("90000000");

			poluwElement = driver.findElement(objPSF.getLocator("radiobtn_ProfitAfterTax"));
			util.waitForElementToBeClickable(driver, poluwElement);
			poluwElement.click();

			poluwElement = driver.findElement(objPSF.getLocator("txt_turnOverBadDebt_ProfitLossAfterTax"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.sendKeys("9000000");

//			poluwElement = driver.findElement(objPSF.getLocator("txt_turnOverBadDebt_ReasonForLoss"));
//			util.waitForVisibilityOfElement(driver, poluwElement);
//			poluwElement.sendKeys("Yes");

			poluwElement = driver.findElement(objPSF.getLocator("btn_turnOverBadDebt_AddNewValue"));
			util.waitForElementToBeClickable(driver, poluwElement);
			poluwElement.click();

			driver.switchTo().alert().accept();
			Thread.sleep(2000);

//			poluwElement = driver.findElement(objPSF.getLocator("txt_showEntriesInfo"));
//			util.waitForVisibilityOfElement(driver, poluwElement);
//			System.out.println(poluwElement.getText());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Limits Availed from Bank

	public void fillDetailsOfLimitAvailedFromAllBanks(WebDriver driver) {
		try {

			inputMap = objDataSource.readData("PolicyProposal");

//				JavascriptExecutor a = (JavascriptExecutor) driver;
//				a.executeScript("window.scrollBy(0,-500)");

			Thread.sleep(1000);
			poluwElement = driver.findElement(objPSF.getLocator("btn_limitAvailedByAllBanksTab"));
			util.handleElementInterceptExceptionUsingAction(driver, poluwElement);
			poluwElement.click();

			poluwElement = driver.findElement(objPSF.getLocator("btn_activeTab"));
			util.waitForVisibilityOfElement(driver, poluwElement);

			if (poluwElement.getText().contains("Limits Being Availed By You From All The Banks"))
				System.out.println("Active: Details of Limits Being Availed By You From All The Banks tab");
			else
				System.out.println("Not Active: Details of Limits Being Availed By You From All The Banks tab");

//				poluwElement = driver.findElement(objPSF.getLocator("txt_limitAvailedByAllBank_BankName"));
//				util.waitForVisibilityOfElement(driver, poluwElement);
//				poluwElement.sendKeys("SBI");

			poluwElement = driver.findElement(objPSF.getLocator("txt_limitAvailedByAllBank_BankName"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.sendKeys(inputMap.get("Bank_name"));

//				poluwElement = driver.findElement(objPSF.getLocator("txt_limitAvailedByAllBank_BankAddress"));
//				util.waitForVisibilityOfElement(driver, poluwElement);
//				poluwElement.sendKeys("Bandra");

			poluwElement = driver.findElement(objPSF.getLocator("txt_limitAvailedByAllBank_BankAddress"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.sendKeys(inputMap.get("Bank_Branch_Address"));

//				poluwElement = driver.findElement(objPSF.getLocator("txt_limitAvailedByAllBank_BankPincode"));
//				util.waitForVisibilityOfElement(driver, poluwElement);
//				poluwElement.sendKeys("400050");

			poluwElement = driver.findElement(objPSF.getLocator("txt_limitAvailedByAllBank_BankPincode"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.sendKeys(inputMap.get("Pincode"));

			poluwElement = driver.findElement(objPSF.getLocator("txt_limitAvailedByAllBank_FacilitySanctioned"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.sendKeys("Unlimited");

//				poluwElement = driver.findElement(objPSF.getLocator("txt_limitAvailedByAllBank_SanctionedAmt"));
//				util.waitForVisibilityOfElement(driver, poluwElement);
//				poluwElement.sendKeys("1000");

			poluwElement = driver.findElement(objPSF.getLocator("txt_limitAvailedByAllBank_SanctionedAmt"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.sendKeys("9000000");

//				poluwElement = driver.findElement(objPSF.getLocator("txt_limitAvailedByAllBank_AmtOutstanding"));
//				util.waitForVisibilityOfElement(driver, poluwElement);
//				poluwElement.sendKeys("100");

			poluwElement = driver.findElement(objPSF.getLocator("txt_limitAvailedByAllBank_AmtOutstanding"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.sendKeys("9000000");

//				poluwElement = driver.findElement(objPSF.getLocator("date_limitAvailedByAllBank_OutstandingDate"));
//				util.waitForVisibilityOfElement(driver, poluwElement);
////				util.selectRandomPastDate(poluwElement, 10);
//				poluwElement.sendKeys("09/10/2021");

			poluwElement = driver.findElement(objPSF.getLocator("date_limitAvailedByAllBank_OutstandingDate"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.sendKeys(inputMap.get("Outstanding_Date"));

//				poluwElement = driver.findElement(objPSF.getLocator("txt_limitAvailedByAllBank_OverdueAmt"));
//				util.waitForVisibilityOfElement(driver, poluwElement);
//				poluwElement.sendKeys("100");

			poluwElement = driver.findElement(objPSF.getLocator("txt_limitAvailedByAllBank_OverdueAmt"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.sendKeys("9000000");

//				poluwElement = driver.findElement(objPSF.getLocator("date_limitAvailedByAllBank_OverdueDate"));
//				util.waitForVisibilityOfElement(driver, poluwElement);
////				util.selectRandomPastDate(poluwElement, 5);
//				poluwElement.sendKeys("10/10/2021");

			poluwElement = driver.findElement(objPSF.getLocator("date_limitAvailedByAllBank_OverdueDate"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.sendKeys(inputMap.get("Overdue_Date"));

			poluwElement = driver.findElement(objPSF.getLocator("btn_limitAvailedByAllBank_AddNewValue"));
			util.waitForElementToBeClickable(driver, poluwElement);
			poluwElement.click();

			driver.switchTo().alert().accept();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void fillCreditManagementRiskAppraisal(WebDriver driver) {
		try {

			Thread.sleep(2000);
			inputMap = objDataSource.readData("PolicyProposal");
			poluwElement = driver.findElement(objPSF.getLocator("btn_creditMgmtRiskAppraisalTab"));
			util.waitForElementToBeClickable(driver, poluwElement);
			poluwElement.click();

			poluwElement = driver.findElement(objPSF.getLocator("btn_activeTab"));
			util.waitForVisibilityOfElement(driver, poluwElement);

			if (poluwElement.getText().contains("Credit Management Risk Appraisal"))
				System.out.println("Active: Credit Management Risk Appraisal Details tab");
			else
				System.out.println("Not Active: Credit Management Risk Appraisal Details tab");

			poluwElement = driver.findElement(objPSF.getLocator("radiobtn_creditManagementRiskAppraisal"));
			util.waitForElementToBeClickable(driver, poluwElement);
			poluwElement.click();

			poluwElement = driver.findElement(objPSF.getLocator("txt_creditMgmtRiskAppraisal_PersonName"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.sendKeys(inputMap.get("BuyerNameOfInsuranceDetails"));

			poluwElement = driver.findElement(objPSF.getLocator("txt_creditMgmtRiskAppraisal_PersonDesignation"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.sendKeys("Manager");

			poluwElement = driver
					.findElement(objPSF.getLocator("chckbox_creditMgmtRiskAppraisal_AssessBuyerStatusReport"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.click();

			poluwElement = driver
					.findElement(objPSF.getLocator("chckbox_creditMgmtRiskAppraisal_AssessBuyerBankReport"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.click();

			poluwElement = driver.findElement(objPSF.getLocator("chckbox_creditMgmtRiskAppraisal_AuditedMgmtAccount"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.click();

			poluwElement = driver.findElement(objPSF.getLocator("chckbox_creditMgmtRiskAppraisal_OtherSources"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.click();

			poluwElement = driver.findElement(objPSF.getLocator("txt_creditMgmtRiskAppraisal_CreditInfoUpdateFreq"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.sendKeys(inputMap.get("CreditInformation"));

			poluwElement = driver.findElement(objPSF.getLocator("txt_creditMgmtRiskAppraisal_BuyerExposureReviewFreq"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.sendKeys(inputMap.get("CreditInformation"));

			poluwElement = driver
					.findElement(objPSF.getLocator("txt_creditMgmtRiskAppraisal_BuyerExposureReviewBasis"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.sendKeys(inputMap.get("CreditInformation"));

			poluwElement = driver
					.findElement(objPSF.getLocator("txt_creditMgmtRiskAppraisal_BuyerExposureReviewDetails"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.sendKeys(inputMap.get("CreditInformation"));

			poluwElement = driver
					.findElement(objPSF.getLocator("txt_creditMgmtRiskAppraisal_NonPaymentPreventiveAction"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.sendKeys(inputMap.get("NonPayment"));

			poluwElement = driver
					.findElement(objPSF.getLocator("txt_creditMgmtRiskAppraisal_NonPaymentRecoveryAction"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.sendKeys(inputMap.get("NonPayment"));

			poluwElement = driver.findElement(objPSF.getLocator("btn_creditMgmtRiskAppraisal_Submit"));
			util.waitForElementToBeClickable(driver, poluwElement);
			poluwElement.click();

			Thread.sleep(3000);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void fillCreditInsuranceDetails(WebDriver driver) {
		try {
			Thread.sleep(2000);

			inputMap = objDataSource.readData("PolicyProposal");

			poluwElement = driver.findElement(objPSF.getLocator("btn_creditInsuranceTab"));
			util.handleElementInterceptExceptionUsingAction(driver, poluwElement);
			poluwElement.click();

			poluwElement = driver.findElement(objPSF.getLocator("btn_activeTab"));
			util.waitForVisibilityOfElement(driver, poluwElement);

			if (poluwElement.getText().contains("Credit Insurance Details"))
				System.out.println("Active: Credit Insurance Details tab");
			else
				System.out.println("Not Active: Credit Insurance Details tab");

//			poluwElement = driver.findElement(objPSF.getLocator("txt_creditInsurance_InsuranceName"));
//			util.waitForVisibilityOfElement(driver, poluwElement);
//			poluwElement.sendKeys("ECGC");

			poluwElement = driver.findElement(objPSF.getLocator("radiobtn_creditInsuranceDetails"));
			util.waitForElementToBeClickable(driver, poluwElement);
			poluwElement.click();

			poluwElement = driver.findElement(objPSF.getLocator("txt_creditInsurance_InsuranceName"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.sendKeys(inputMap.get("NameOfTheInsurance"));

//			poluwElement = driver.findElement(objPSF.getLocator("txt_creditInsurance_valueExportTurnover"));
//			util.waitForVisibilityOfElement(driver, poluwElement);
//			poluwElement.sendKeys("1000");

			poluwElement = driver.findElement(objPSF.getLocator("txt_creditInsurance_valueExportTurnover"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.sendKeys(inputMap.get("ValueOfTheExport"));

//			poluwElement = driver.findElement(objPSF.getLocator("txt_creditInsurance_BuyerName"));
//			util.waitForVisibilityOfElement(driver, poluwElement);
//			poluwElement.sendKeys("Pepsi");

			poluwElement = driver.findElement(objPSF.getLocator("txt_creditInsurance_BuyerName"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.sendKeys(inputMap.get("BuyerNameOfInsuranceDetails"));

//			poluwElement = driver.findElement(objPSF.getLocator("txt_creditInsurance_BuyerAddress"));
//			util.waitForVisibilityOfElement(driver, poluwElement);
//			poluwElement.sendKeys("US");

			poluwElement = driver.findElement(objPSF.getLocator("txt_creditInsurance_BuyerAddress"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.sendKeys(inputMap.get("Bank_Branch_Address"));

			poluwElement = driver.findElement(objPSF.getLocator("txt_creditInsurance_OtherDetails"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.sendKeys("NO");

			poluwElement = driver.findElement(objPSF.getLocator("btn_creditInsurance_AddNewValue"));
			util.waitForElementToBeClickable(driver, poluwElement);
			poluwElement.click();

			driver.switchTo().alert().accept();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void fillExportTurnoverInLast12CalendarMonths(WebDriver driver) {
		try {

			Thread.sleep(1000);
			inputMap = objDataSource.readData("PolicyProposal");
			poluwElement = driver.findElement(objPSF.getLocator("btn_exportTurnoverLast12CalendarMonthTab"));
			util.waitForElementToBeClickable(driver, poluwElement);
			poluwElement.click();

			poluwElement = driver.findElement(objPSF.getLocator("btn_activeTab"));
			util.waitForVisibilityOfElement(driver, poluwElement);

			if (poluwElement.getText().contains("Details of Export Turnover"))
				System.out.println("Active: Details Export Turnover in the Last 12 Calendar Months tab");
			else
				System.out.println("Not Active: Details Export Turnover in the Last 12 Calendar Months tab");

			poluwElement = driver.findElement(objPSF.getLocator("txt_exportTurnoverLast12m_BuyerName"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.sendKeys(inputMap.get("Bank_name"));

			drpdwnList = new Select(driver.findElement(objPSF.getLocator("drpdwn_exportTurnoverLast12m_Country")));
			util.getRandomValueFromDropdown(driver, drpdwnList);

			statusList = new Select(driver.findElement(objPSF.getLocator("drpdwn_exportTurnoverLast12m_TopID")));
			util.selectRandomValueFromDropdown(driver, statusList);

			poluwElement = driver.findElement(objPSF.getLocator("txt_exportTurnoverLast12m_MaxExposure"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.sendKeys(inputMap.get("CreditInformation"));

			poluwElement = driver.findElement(objPSF.getLocator("txt_exportTurnoverLast12m_ShipmentValue"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.sendKeys(inputMap.get("CreditInformation"));

			poluwElement = driver.findElement(objPSF.getLocator("txt_exportTurnoverLast12m_NoOfYearDealing"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.sendKeys(inputMap.get("CreditInformation"));

			poluwElement = driver
					.findElement(objPSF.getLocator("txt_exportTurnoverLast12m_PercentExportBuyerToTotalExport"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.sendKeys("40");

			poluwElement = driver.findElement(objPSF.getLocator("btn_exportTurnoverLast12m_AddNewValue"));
			util.waitForElementToBeClickable(driver, poluwElement);
			poluwElement.click();

			driver.switchTo().alert().accept();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void fillDebtorsDistribution(WebDriver driver) {
		try {

			Thread.sleep(1000);
			inputMap = objDataSource.readData("PolicyProposal");
			poluwElement = driver.findElement(objPSF.getLocator("btn_debtorsDistributionTab"));
			util.waitForElementToBeClickable(driver, poluwElement);
			poluwElement.click();

			poluwElement = driver.findElement(objPSF.getLocator("btn_activeTab"));
			util.waitForVisibilityOfElement(driver, poluwElement);

			if (poluwElement.getText().contains("Debtors Distribution"))
				System.out.println("Active: Debtors Distribution Details tab");
			else
				System.out.println("Not Active: Debtors Distribution Details tab");

			poluwElement = driver.findElement(objPSF.getLocator("date_debtorsDistribution_AsOnDate"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.sendKeys(inputMap.get("Outstanding_Date"));

			poluwElement = driver.findElement(objPSF.getLocator("txt_debtorsDistribution_0To25L_NoOfBuyers"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.clear();
			poluwElement.sendKeys("1");

//			poluwElement = driver
//					.findElement(objPSF.getLocator("txt_debtorsDistribution_0To25L_TotalAmountOutstandingOnLC"));
//			util.waitForVisibilityOfElement(driver, poluwElement);
//			poluwElement.clear();
//			poluwElement.sendKeys("10");

			poluwElement = driver
					.findElement(objPSF.getLocator("txt_debtorsDistribution_0To25L_TotalAmountOutstandingOnLC"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.clear();
			poluwElement.sendKeys(inputMap.get("Total_Sales_Turnover"));

			poluwElement = driver
					.findElement(objPSF.getLocator("txt_debtorsDistribution_0To25L_TotalAmountOutstandingOnNonLC"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.clear();
			poluwElement.sendKeys(inputMap.get("Total_Sales_Turnover"));

			poluwElement = driver
					.findElement(objPSF.getLocator("txt_debtorsDistribution_0To25L_TotalAmountOutstandingOnOthers"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.clear();
			poluwElement.sendKeys(inputMap.get("Total_Sales_Turnover"));

			/*
			 * poluwElement =
			 * driver.findElement(objPSF.getLocator("txt_debtorsDistribution_0To25L_Total"))
			 * ; util.waitForVisibilityOfElement(driver, poluwElement);
			 * poluwElement.getText();
			 */

			poluwElement = driver.findElement(objPSF.getLocator("txt_debtorsDistribution_25LTo50L_NoOfBuyers"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.clear();
			poluwElement.sendKeys("9");

			poluwElement = driver
					.findElement(objPSF.getLocator("txt_debtorsDistribution_25LTo50L_TotalAmountOutstandingOnLC"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.clear();
			poluwElement.sendKeys(inputMap.get("Amount_Outstanding"));

			poluwElement = driver
					.findElement(objPSF.getLocator("txt_debtorsDistribution_25LTo50L_TotalAmountOutstandingOnNonLC"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.clear();
			poluwElement.sendKeys(inputMap.get("Amount_Outstanding"));

			poluwElement = driver
					.findElement(objPSF.getLocator("txt_debtorsDistribution_25LTo50L_TotalAmountOutstandingOnOthers"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.clear();
			poluwElement.sendKeys(inputMap.get("Amount_Outstanding"));

			/*
			 * poluwElement =
			 * driver.findElement(objPSF.getLocator("txt_debtorsDistribution_25LTo50L_Total"
			 * )); util.waitForVisibilityOfElement(driver, poluwElement);
			 * poluwElement.getText();
			 */

			poluwElement = driver.findElement(objPSF.getLocator("txt_debtorsDistribution_50LTo1M_NoOfBuyers"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.clear();
			poluwElement.sendKeys("4");

			poluwElement = driver
					.findElement(objPSF.getLocator("txt_debtorsDistribution_50LTo1M_TotalAmountOutstandingOnLC"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.clear();
			poluwElement.sendKeys(inputMap.get("Amount_Outstanding"));

			poluwElement = driver
					.findElement(objPSF.getLocator("txt_debtorsDistribution_50LTo1M_TotalAmountOutstandingOnNonLC"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.clear();
			poluwElement.sendKeys(inputMap.get("Amount_Outstanding"));

			poluwElement = driver
					.findElement(objPSF.getLocator("txt_debtorsDistribution_50LTo1M_TotalAmountOutstandingOnOthers"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.clear();
			poluwElement.sendKeys(inputMap.get("Amount_Outstanding"));

			poluwElement = driver.findElement(objPSF.getLocator("txt_debtorsDistribution_1To10M_NoOfBuyers"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.clear();
			poluwElement.sendKeys("1");

			poluwElement = driver
					.findElement(objPSF.getLocator("txt_debtorsDistribution_1MTo10M_TotalAmountOutstandingOnLC"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.clear();
			poluwElement.sendKeys(inputMap.get("Amount_Outstanding"));

			poluwElement = driver
					.findElement(objPSF.getLocator("txt_debtorsDistribution_1MTo10M_TotalAmountOutstandingOnNonLC"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.clear();
			poluwElement.sendKeys(inputMap.get("Amount_Outstanding"));

			poluwElement = driver
					.findElement(objPSF.getLocator("txt_debtorsDistribution_1MTo10M_TotalAmountOutstandingOnOthers"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.clear();
			poluwElement.sendKeys(inputMap.get("Amount_Outstanding"));

			/*
			 * poluwElement =
			 * driver.findElement(objPSF.getLocator("txt_debtorsDistribution_50LTo1M_Total")
			 * ); util.waitForVisibilityOfElement(driver, poluwElement);
			 * poluwElement.getText();
			 */
			Thread.sleep(2000);
			poluwElement = driver.findElement(objPSF.getLocator("btn_debtorsDistribution_Save"));
			util.waitForElementToBeClickable(driver, poluwElement);
			poluwElement.click();


		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void fillAgeDebtorAnalysis(WebDriver driver) {
		try {

			Thread.sleep(2000);
			inputMap = objDataSource.readData("PolicyProposal");
			poluwElement = driver.findElement(objPSF.getLocator("btn_agewiseDebtorAnalysisTab"));
			util.waitForElementToBeClickable(driver, poluwElement);
			poluwElement.click();

			poluwElement = driver.findElement(objPSF.getLocator("btn_activeTab"));
			util.waitForVisibilityOfElement(driver, poluwElement);

			if (poluwElement.getText().contains("Age-wise Debtor Analysis"))
				System.out.println("Active: Age-wise Debtor Analysis tab");
			else
				System.out.println("Not Active: Age-wise Debtor Analysis tab");

			poluwElement = driver.findElement(objPSF.getLocator("date_agewiseDebtorAnalysis_AsOnDate"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.sendKeys(inputMap.get("Overdue_Date"));

			poluwElement = driver
					.findElement(objPSF.getLocator("txt_agewiseDebtorAnalysis_OutstandingAmountAgeing_0To90"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.clear();
			poluwElement.sendKeys(inputMap.get("Total_Sales_Turnover"));

			poluwElement = driver
					.findElement(objPSF.getLocator("txt_agewiseDebtorAnalysis_OutstandingAmountAgeing_91To180"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.clear();
			poluwElement.sendKeys(inputMap.get("Total_Sales_Turnover"));

			poluwElement = driver
					.findElement(objPSF.getLocator("txt_agewiseDebtorAnalysis_OutstandingAmountAgeing_181To270"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.clear();
			poluwElement.sendKeys(inputMap.get("Total_Sales_Turnover"));

			/*
			 * poluwElement = driver.findElement(objPSF.getLocator(
			 * "txt_agewiseDebtorAnalysis_OutstandingAmountAgeing_Total"));
			 * util.waitForVisibilityOfElement(driver, poluwElement);
			 * poluwElement.getText();
			 */

			poluwElement = driver
					.findElement(objPSF.getLocator("txt_agewiseDebtorAnalysis_OutstandingAmount_LessThanEquals30Days"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.clear();
			poluwElement.sendKeys(inputMap.get("Total_Sales_Turnover"));

			poluwElement = driver.findElement(objPSF.getLocator("txt_agewiseDebtorAnalysis_OutstandingAmount_30Days"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.clear();
			poluwElement.sendKeys(inputMap.get("Total_Sales_Turnover"));

			/*
			 * poluwElement = driver.findElement(objPSF.getLocator(
			 * "txt_agewiseDebtorAnalysis_OutstandingAmount_Total"));
			 * util.waitForVisibilityOfElement(driver, poluwElement);
			 * poluwElement.getText();
			 */

			poluwElement = driver.findElement(objPSF.getLocator("btn_agewiseDebtorAnalysis_Save"));
			util.waitForElementToBeClickable(driver, poluwElement);
			poluwElement.click();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	// Projected Turnover For the next 12 months (for the period)
	public void fillprojectedTurnoverNext12Month(WebDriver driver) {
		try {

			Thread.sleep(1000);
			inputMap = objDataSource.readData("PolicyProposal");

			poluwElement = driver.findElement(objPSF.getLocator("btn_projectedTurnoverNxt12mTab"));
			util.waitForElementToBeClickable(driver, poluwElement);
			poluwElement.click();

			/*
			 * poluwElement = driver.findElement(objPSF.getLocator("btn_activeTab"));
			 * util.waitForVisibilityOfElement(driver, poluwElement);
			 * 
			 * if(poluwElement.getText().
			 * contains("Projected Turnover For The Next 12 Months"))
			 * System.out.println("Active: Projected Turnover For The Next 12 Months tab");
			 * else System.out.
			 * println("Not Active: Projected Turnover For The Next 12 Months tab");
			 */

			poluwElement = driver.findElement(objPSF.getLocator("txt_projectedTurnoverNext12Month_date"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.sendKeys(inputMap.get("Overdue_Date"));

			poluwElement = driver
					.findElement(objPSF.getLocator("txt_projectedTurnoverNxt12m_TotalProjectedSalesTurnover"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.clear();
			poluwElement.sendKeys(inputMap.get("ValueOfTheExport"));
//			poluwElement.sendKeys("500000000000");

			poluwElement = driver
					.findElement(objPSF.getLocator("txt_projectedTurnoverNxt12m_TotalProjectedExportTurnover"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.clear();
			poluwElement.sendKeys(inputMap.get("ValueOfTheExport"));
//			poluwElement.sendKeys("400000000000");

			poluwElement = driver.findElement(
					objPSF.getLocator("txt_projectedTurnoverNxt12m_PercentageOfExportTurnoverProjectedOnAdvance"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.clear();
			poluwElement.sendKeys("20");

			poluwElement = driver.findElement(
					objPSF.getLocator("txt_projectedTurnoverNxt12m_PercentageOfExportTurnoverProjectedOnLC"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.clear();
			poluwElement.sendKeys("70");

			poluwElement = driver.findElement(
					objPSF.getLocator("txt_projectedTurnoverNxt12m_PercentageOfExportTurnoverProjectedOnNonLC"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.clear();
			poluwElement.sendKeys("10");

			poluwElement = driver.findElement(objPSF.getLocator("btn_projectedTurnoverNxt12m_Save"));
//			util.waitForElementToBeClickable(driver, poluwElement);
			Thread.sleep(2000);
			poluwElement.click();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Details of projected export turnover for the next 12 calendar months
	public void fillprojectedExportTurnoverNext12CalendarMonth(WebDriver driver) {
		try {

			Thread.sleep(2000);
			inputMap = objDataSource.readData("PolicyProposal");
			poluwElement = driver.findElement(objPSF.getLocator("btn_projectedExportTurnoverNext12CalendarMonthTab"));
			util.waitForElementToBeClickable(driver, poluwElement);
			poluwElement.click();

			poluwElement = driver.findElement(objPSF.getLocator("btn_activeTab"));
			util.waitForVisibilityOfElement(driver, poluwElement);

			if (poluwElement.getText().contains("Projected Export Turnover For The Next 12 Calendar Months"))
				System.out.println("Active: Projected Export Turnover For The Next 12 Calendar Months tab");
			else
				System.out.println("Not Active: Projected Export Turnover For The Next 12 Calendar Months tab");

//			poluwElement = driver.findElement(objPSF.getLocator("txt_projectedExportTurnoverNext12CalendarMonth_BuyerCode"));
//			util.waitForVisibilityOfElement(driver, poluwElement);
//			poluwElement.sendKeys("1111");

			poluwElement = driver
					.findElement(objPSF.getLocator("txt_projectedExportTurnoverNext12CalendarMonth_BuyerName"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.sendKeys(inputMap.get("BuyerNameOfInsuranceDetails"));

//			poluwElement = driver
//					.findElement(objPSF.getLocator("txt_projectedExportTurnoverNext12CalendarMonth_BuyerStreet"));
//			util.waitForVisibilityOfElement(driver, poluwElement);
//			poluwElement.sendKeys("Gulmohar Road");

			poluwElement = driver
					.findElement(objPSF.getLocator("txt_projectedExportTurnoverNext12CalendarMonth_BuyerStreet"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.sendKeys(inputMap.get("Bank_Branch_Address"));

			poluwElement = driver
					.findElement(objPSF.getLocator("txt_projectedExportTurnoverNext12CalendarMonth_BuyerCity"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.sendKeys(inputMap.get("Bank_Branch_Address"));

			drpdwnList = new Select(driver
					.findElement(objPSF.getLocator("drpdwn_projectedExportTurnoverNext12CalendarMonth_BuyerCountry")));
			util.selectRandomValueFromDropdown(driver, drpdwnList);

			poluwElement = driver
					.findElement(objPSF.getLocator("txt_projectedExportTurnoverNext12CalendarMonth_BuyerPhoneNo"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.sendKeys("9876543210");

			poluwElement = driver
					.findElement(objPSF.getLocator("txt_projectedExportTurnoverNext12CalendarMonth_BuyerFaxNumber"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.sendKeys("+12-345-1234567");

			poluwElement = driver
					.findElement(objPSF.getLocator("txt_projectedExportTurnoverNext12CalendarMonth_BuyerEmail"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.sendKeys("testmail@buyer.com");

			poluwElement = driver
					.findElement(objPSF.getLocator("txt_projectedExportTurnoverNext12CalendarMonth_BuyerWebsite"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.sendKeys("www.buyersite.com");

			poluwElement = driver
					.findElement(objPSF.getLocator("txt_projectedExportTurnoverNext12CalendarMonth_NoOfYrsDealing"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.sendKeys(inputMap.get("CreditInformation"));

			drpdwnList = new Select(
					driver.findElement(objPSF.getLocator("drpdwn_projectedExportTurnoverNext12CalendarMonth_TopID")));
			util.selectRandomValueFromDropdown(driver, drpdwnList);

			poluwElement = driver
					.findElement(objPSF.getLocator("txt_projectedExportTurnoverNext12CalendarMonth_ShipmentValue"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.sendKeys("50000000");

//			poluwElement = driver
//					.findElement(objPSF.getLocator("txt_projectedExportTurnoverNext12CalendarMonth_MaxExposure"));
//			util.waitForVisibilityOfElement(driver, poluwElement);
//			poluwElement.sendKeys("30");

			poluwElement = driver
					.findElement(objPSF.getLocator("txt_projectedExportTurnoverNext12CalendarMonth_MaxExposure"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.sendKeys("1,00,00,000");

//			drpdwnList = new Select(driver
//					.findElement(objPSF.getLocator("drpdwn_projectedExportTurnoverNext12CalendarMonth_Commodity")));
//			util.selectRandomValueFromDropdown(driver, drpdwnList);

			poluwElement = driver.findElement(
					objPSF.getLocator("txt_projectedExportTurnoverNext12CalendarMonth_PercentageOfExportToBuyer"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.sendKeys("30");

			poluwElement = driver
					.findElement(objPSF.getLocator("btn_projectedExportTurnoverNext12CalendarMonth_AddEntry"));
			util.waitForElementToBeClickable(driver, poluwElement);
			poluwElement.click();
			driver.switchTo().alert().accept();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Merchant Trade tab of policy proposal form
	public boolean fillMerchantingTrade(WebDriver driver) {
		try {

			inputMap = objDataSource.readData("PolicyProposal");
			poluwElement = driver.findElement(objPSF.getLocator("link_Merchant_Trade"));
			util.waitForElementToBeClickable(driver, poluwElement);
			poluwElement.click();
			poluwElement.click();

			Thread.sleep(1000);
			poluwElement = driver.findElement(objPSF.getLocator("radiobtn_Merchant_Trade_Cover_Required"));
			util.waitForElementToBeClickable(driver, poluwElement);
			poluwElement.click();

//			poluwElement = driver.findElement(objPSF.getLocator("txt_Merchant_buyer_name"));
//			util.waitForVisibilityOfElement(driver, poluwElement);
//			poluwElement.sendKeys("NSE");

			poluwElement = driver.findElement(objPSF.getLocator("txt_Merchant_buyer_name"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.sendKeys(inputMap.get("BuyerNameOfInsuranceDetails"));

//			poluwElement = driver.findElement(objPSF.getLocator("txt_Merchant_buyer_address"));
//			util.waitForVisibilityOfElement(driver, poluwElement);
//			poluwElement.sendKeys("Mumbai");

			poluwElement = driver.findElement(objPSF.getLocator("txt_Merchant_buyer_address"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.sendKeys(inputMap.get("Bank_Branch_Address"));

			drpdwnList = new Select(driver.findElement(objPSF.getLocator("drpdwn_Merchant_Buyer_Country")));
			util.getRandomValueFromDropdown(driver, drpdwnList);

			drpdwnList = new Select(driver.findElement(objPSF.getLocator("drpdwn_Merchanting_Country")));
			util.getRandomValueFromDropdown(driver, drpdwnList);

			statusList = new Select(driver.findElement(objPSF.getLocator("drpdwn_TermOf_Payment")));
			util.waitForDropdownOptions(driver, statusList);
			statusList.selectByVisibleText("DP-120");

//			poluwElement = driver.findElement(objPSF.getLocator("txt_Merchant_Projected_Export_Turnover"));
//			util.waitForVisibilityOfElement(driver, poluwElement);
//			poluwElement.sendKeys("10000000");

			poluwElement = driver.findElement(objPSF.getLocator("txt_Merchant_Projected_Export_Turnover"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.sendKeys(inputMap.get("Total_Value_Bad_Debts"));

			poluwElement = driver.findElement(objPSF.getLocator("btn_Merchant_Trade_Add_New"));
			util.waitForElementToBeClickable(driver, poluwElement);
			poluwElement.click();
			driver.switchTo().alert().accept();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;

	}

	public void fillUploadDocuments(WebDriver driver) {
		try {

			inputMap = objDataSource.readData("PolicyProposal");
			Thread.sleep(1000);
			poluwElement = driver.findElement(objPSF.getLocator("btn_upload_documents"));
			util.waitForElementToBeClickable(driver, poluwElement);
			poluwElement.click();

			drpdwnList = new Select(driver.findElement(objPSF.getLocator("drpdwn_Document_types")));
			Thread.sleep(1000);
			util.getRandomValueFromDropdown(driver, drpdwnList);

			poluwElement = driver.findElement(objPSF.getLocator("txt_document_description"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.sendKeys(inputMap.get("NonPayment"));

//			poluwElement = driver.findElement(objPSF.getLocator("link_upload_docu"));
//			String pathUploadDoc = System.getProperty("user.dir") + "\\testData\\pdf.pdf";
//			System.out.println(pathUploadDoc);
//			util.waitForElementToBeClickable(driver, poluwElement);
//			poluwElement.sendKeys(pathUploadDoc);

			poluwElement = driver.findElement(objPSF.getLocator("link_upload_docu"));
			poluwElement.sendKeys(new File("./testData/pdf.pdf").getAbsolutePath());

//			poluwElement.click();
//			Runtime.getRuntime().exec("C:\\Users\\ECGC-HP86\\Downloads\\test.exe");

//			poluwElement = driver.findElement(objPSF.getLocator("link_upload_docu"));
//			poluwElement.sendKeys(new File("./testData/pdf.pdf").getAbsolutePath());

//			projElement = driver.findElement(By.id(prop.getProperty("tx_sanction_letter")));
//			projElement.sendKeys(new File("./testData/N 95 mask usage.pdf").getAbsolutePath());
//			Thread.sleep(1000);

			poluwElement = driver.findElement(objPSF.getLocator("btn_upload_document_Save"));
			util.waitForElementToBeClickable(driver, poluwElement);
			poluwElement.click();
			Thread.sleep(4000);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Optional Cover Required (SCR)
	public boolean fillSCRPolicyDetails(WebDriver driver) {
		try {

			inputMap = objDataSource.readData("PolicyProposal");
			poluwElement = driver.findElement(objPSF.getLocator("btn_scrTab"));
			util.waitForElementToBeClickable(driver, poluwElement);
			poluwElement.click();
			poluwElement.click();

			/*
			 * poluwElement = driver.findElement(objPSF.getLocator("btn_activeTab"));
			 * util.waitForVisibilityOfElement(driver, poluwElement);
			 * if(poluwElement.getText().contains("SCR"))
			 * System.out.println("Active: SCR tab"); else
			 * System.out.println("Not Active: SCR tab");
			 */

//				poluwElement = driver
//						.findElement(objPSF.getLocator("chckbx_SCR_ExportsAgainstLettersOfCredit_CoverRequired"));
//				util.waitForVisibilityOfElement(driver, poluwElement);
//				poluwElement.click();
			//
//				poluwElement = driver
//						.findElement(objPSF.getLocator("chckbx_SCR_ExportsToAssociateSisterConcern_CoverRequired"));
//				util.waitForVisibilityOfElement(driver, poluwElement);
//				poluwElement.click();

			poluwElement = driver.findElement(objPSF.getLocator("radiobtn_SCR_CoverForDeemedExports_NoCoverRequired"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.click();

			poluwElement = driver.findElement(objPSF.getLocator("radiobtn_SCR_CoverForDeemedExports_CoverRequired"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.click();

//				poluwElement = driver.findElement(objPSF.getLocator("radiobtn_SCR_CoverForMerchantingTradeThirdCountryExports_NoCoverRequired"));
//				util.waitForVisibilityOfElement(driver, poluwElement);
//				poluwElement.click();

			poluwElement = driver.findElement(
					objPSF.getLocator("radiobtn_SCR_CoverForMerchantingTradeThirdCountryExports_CoverRequired"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.click();

//				poluwElement = driver.findElement(objPSF.getLocator("txt_SCR_RequestedML"));
//				util.waitForVisibilityOfElement(driver, poluwElement);
//				poluwElement.clear();
//				poluwElement.sendKeys("100");

			poluwElement = driver.findElement(objPSF.getLocator("txt_SCR_OtherRequirements"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.sendKeys("Test");

			poluwElement = driver.findElement(objPSF.getLocator("btn_scr_save"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.click();



		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public void fillOverdueDetailsAsOnDate(WebDriver driver) {
		try {

			Thread.sleep(2000);
			inputMap = objDataSource.readData("PolicyProposal");
			poluwElement = driver.findElement(objPSF.getLocator("btn_overdueTab"));
			util.waitForElementToBeClickable(driver, poluwElement);
			poluwElement.click();

			poluwElement = driver.findElement(objPSF.getLocator("btn_activeTab"));
			util.waitForVisibilityOfElement(driver, poluwElement);

			if (poluwElement.getText().contains("Overdue Details"))
				System.out.println("Active: Overdue Details tab");
			else
				System.out.println("Not Active: Overdue Details tab");

			poluwElement = driver.findElement(objPSF.getLocator("txt_overdue_As_On_Date"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.sendKeys(inputMap.get("Overdue_Date"));

			poluwElement = driver.findElement(objPSF.getLocator("txt_overdue_BuyerName"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.sendKeys(inputMap.get("BuyerNameOfInsuranceDetails"));

			drpdwnList = new Select(driver.findElement(objPSF.getLocator("drpdwn_overdue_Country")));
			util.getRandomValueFromDropdown(driver, drpdwnList);

			poluwElement = driver.findElement(objPSF.getLocator("txt_overdue_Address"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.sendKeys(inputMap.get("Bank_Branch_Address"));

			poluwElement = driver.findElement(objPSF.getLocator("txt_overdue_Street"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.sendKeys(inputMap.get("Bank_Branch_Address"));

			poluwElement = driver.findElement(objPSF.getLocator("txt_overdue_City"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.sendKeys(inputMap.get("Bank_Branch_Address"));

			poluwElement = driver.findElement(objPSF.getLocator("txt_overdue_State"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.sendKeys(inputMap.get("StateInfo"));

			poluwElement = driver.findElement(objPSF.getLocator("date_overdue_ShipmentsStartDate"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.sendKeys(inputMap.get("Overdue_Date"));

			poluwElement = driver.findElement(objPSF.getLocator("date_overdue_ShipmentsEndDate"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.sendKeys(inputMap.get("Overdue_Date"));

			drpdwnList = new Select(driver.findElement(objPSF.getLocator("drpdwn_overdue_TopID")));
			util.getRandomValueFromDropdown(driver, drpdwnList);

			poluwElement = driver.findElement(objPSF.getLocator("txt_overdue_OverDueAmt"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.sendKeys(inputMap.get("Overdue_Amount"));

			poluwElement = driver.findElement(objPSF.getLocator("txt_overdue_NoOfDaysBeyondEarliestDueDate"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.sendKeys(inputMap.get("CreditInformation"));

			poluwElement = driver.findElement(objPSF.getLocator("txt_overdue_OverdueReason"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.sendKeys("No Reason");

			poluwElement = driver.findElement(objPSF.getLocator("date_overdue_AsOnDate"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.sendKeys(inputMap.get("Overdue_Date"));

			poluwElement = driver.findElement(objPSF.getLocator("txt_overdue_ActionTaken"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.sendKeys(inputMap.get("NonPayment"));

			poluwElement = driver.findElement(objPSF.getLocator("btn_overdue_AddNewValue"));
			util.waitForElementToBeClickable(driver, poluwElement);
			poluwElement.click();

			driver.switchTo().alert().accept();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void fillprojectedTurnoverNext12Month_SEC(WebDriver driver) {

		try {

			Thread.sleep(1000);
			inputMap = objDataSource.readData("PolicyProposal");

			poluwElement = driver.findElement(objPSF.getLocator("btn_projectedTurnoverNxt12mTab"));
			util.waitForElementToBeClickable(driver, poluwElement);
			poluwElement.click();

			/*
			 * poluwElement = driver.findElement(objPSF.getLocator("btn_activeTab"));
			 * util.waitForVisibilityOfElement(driver, poluwElement);
			 * 
			 * if(poluwElement.getText().
			 * contains("Projected Turnover For The Next 12 Months"))
			 * System.out.println("Active: Projected Turnover For The Next 12 Months tab");
			 * else System.out.
			 * println("Not Active: Projected Turnover For The Next 12 Months tab");
			 */

			poluwElement = driver.findElement(objPSF.getLocator("txt_projectedTurnoverNext12Month_date"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.sendKeys(inputMap.get("Overdue_Date"));

			poluwElement = driver
					.findElement(objPSF.getLocator("txt_projectedTurnoverNxt12m_TotalProjectedSalesTurnover"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.clear();
//				poluwElement.sendKeys(inputMap.get("ValueOfTheExport"));
			poluwElement.sendKeys("50000000");

			poluwElement = driver
					.findElement(objPSF.getLocator("txt_projectedTurnoverNxt12m_TotalProjectedExportTurnover"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.clear();
//				poluwElement.sendKeys(inputMap.get("ValueOfTheExport"));
			poluwElement.sendKeys("50000000");

			poluwElement = driver.findElement(
					objPSF.getLocator("txt_projectedTurnoverNxt12m_PercentageOfExportTurnoverProjectedOnAdvance"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.clear();
			poluwElement.sendKeys("20");

			poluwElement = driver.findElement(
					objPSF.getLocator("txt_projectedTurnoverNxt12m_PercentageOfExportTurnoverProjectedOnLC"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.clear();
			poluwElement.sendKeys("70");

			poluwElement = driver.findElement(
					objPSF.getLocator("txt_projectedTurnoverNxt12m_PercentageOfExportTurnoverProjectedOnNonLC"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.clear();
			poluwElement.sendKeys("10");

			poluwElement = driver.findElement(objPSF.getLocator("btn_projectedTurnoverNxt12m_Save"));
//				util.waitForElementToBeClickable(driver, poluwElement);
			Thread.sleep(2000);
			poluwElement.click();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void fillSECPolicyDetails(WebDriver driver) {
		try {

			inputMap = objDataSource.readData("PolicyProposal");

			poluwElement = driver.findElement(objPSF.getLocator("btn_sec_Tab"));
			util.waitForElementToBeClickable(driver, poluwElement);
			poluwElement.click();

			poluwElement = driver.findElement(objPSF.getLocator("radiobtn_SEC_Exports_Against_LOC"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.click();

			poluwElement = driver.findElement(objPSF.getLocator("radiobtn_SEC_Exports_To_Associate"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.click();

			poluwElement = driver.findElement(objPSF.getLocator("radiobtn_SEC_Cover_For_Deemed_Exports"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.click();

			poluwElement = driver.findElement(objPSF.getLocator("txt_SEC_Any_Other_Requirements"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.sendKeys("Test");

			poluwElement = driver.findElement(objPSF.getLocator("btn_scr_save"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.click();

			Thread.sleep(2000);

			poluwElement = driver.findElement(objPSF.getLocator("btn_scr_final_submit"));
			util.waitForElementToBeClickable(driver, poluwElement);
			poluwElement.click();
			driver.switchTo().alert().accept();
//			driver.switchTo().alert().accept();

			Thread.sleep(3000);

			poluwElement = driver.findElement(objPSF.getLocator("txt_application_number"));
//			poluwElement.getText();
			System.out.println("The Application Number :" + poluwElement.getText());

			poluwElement = driver.findElement(objPSF.getLocator("txt_proposal_number"));
//			poluwElement.getText();
			System.out.println("The Proposal Number :" + poluwElement.getText());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void fillETPPolicyDetails(WebDriver driver) {
		try {

			inputMap = objDataSource.readData("PolicyProposal");

			poluwElement = driver.findElement(objPSF.getLocator("btn_sec_Tab"));
			util.waitForElementToBeClickable(driver, poluwElement);
			poluwElement.click();

			poluwElement = driver.findElement(objPSF.getLocator("radiobtn_SEC_Exports_Against_LOC"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.click();

			poluwElement = driver.findElement(objPSF.getLocator("radiobtn_SEC_Exports_To_Associate"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.click();

			poluwElement = driver.findElement(objPSF.getLocator("radiobtn_SEC_Cover_For_Deemed_Exports"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.click();

			poluwElement = driver.findElement(objPSF.getLocator("txt_SEC_Any_Other_Requirements"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.sendKeys("Test");

			poluwElement = driver.findElement(objPSF.getLocator("btn_scr_save"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.click();

			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete';"));
			
			// js.executeScript("return document.readyState").equals("complete")

			System.out.println("Before 5 sec");
			Thread.sleep(5000);
			System.out.println("After 5 sec");

			poluwElement = driver.findElement(objPSF.getLocator("btn_scr_final_submit"));
			util.waitForElementToBeClickable(driver, poluwElement);
			poluwElement.click();
			driver.switchTo().alert().accept();
//			driver.switchTo().alert().accept();

			Thread.sleep(3000);

			poluwElement = driver.findElement(objPSF.getLocator("txt_application_number"));
//			poluwElement.getText();
			System.out.println("The Application Number :" + poluwElement.getText());

			poluwElement = driver.findElement(objPSF.getLocator("txt_proposal_number"));
//			poluwElement.getText();
			System.out.println("The Proposal Number :" + poluwElement.getText());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void selectProduct(WebDriver driver, String policyType) {
		try {

			poluwElement = driver.findElement(objPSF.getLocator("proposal_date"));
			util.waitForElementToBeClickable(driver, poluwElement);
			util.setCurrentDate(poluwElement);

			drpdwnList = new Select(driver.findElement(objPSF.getLocator("drpdwn_polType")));
			util.waitForDropdownOptions(driver, drpdwnList);
			drpdwnList.selectByValue(policyType);

			drpdwnList = new Select(driver.findElement(objPSF.getLocator("drpdwn_typeOfCover")));
			util.getRandomValueFromDropdown(driver, drpdwnList);
//			util.waitForDropdownOptions(driver, drpdwnList);
//			drpdwnList.selectByValue(typeOfCover);


//			drpdwnList = new Select(driver.findElement(objPSF.getLocator("drpdwn_fieldOfficerCode")));
//			util.getRandomValueFromDropdown(driver, drpdwnList);
//			util.waitForDropdownOptions(driver, drpdwnList);
//			drpdwnList.selectByIndex(1);

//			drpdwnList = new Select(driver.findElement(objPSF.getLocator("drpdwn_brokerName")));
//			util.getRandomValueFromDropdown(driver, drpdwnList);
//			util.waitForDropdownOptions(driver, drpdwnList);
//			drpdwnList.selectByIndex(1);

			poluwElement = driver.findElement(objPSF.getLocator("btn_submitProposal"));
			util.waitForElementToBeClickable(driver, poluwElement);
			poluwElement.click();

			driver.switchTo().alert().accept();

//			poluwElement = driver.findElement(objPSF.getLocator("txt_submitMsg"));
//			util.waitForVisibilityOfElement(driver, poluwElement);

//			System.out.println(poluwElement.getText());
//			System.out.println(Integer.parseInt(poluwElement.getText().replaceAll("[^0-9]", "")));
//			System.out.println(Integer.parseInt(poluwElement.getText().replaceAll("\\D+", "")));
//			System.out.println(Integer.parseInt(poluwElement.getText().replaceAll("[^0-9]", "")));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void fillSubmitSRCPolicyDetails(WebDriver driver) {
		try {

			poluwElement = driver.findElement(objPSF.getLocator("btn_scr_final_submit"));
			util.waitForElementToBeClickable(driver, poluwElement);
			poluwElement.click();
			driver.switchTo().alert().accept();
			// driver.switchTo().alert().accept();

			poluwElement = driver.findElement(objPSF.getLocator("txt_application_number"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.getText();
			System.out.println("The Application Number :" + poluwElement.getText());

			poluwElement = driver.findElement(objPSF.getLocator("txt_proposal_number"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.getText();
			System.out.println("The Proposal Number :" + poluwElement.getText());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}