package pkgWebPages;

import java.io.File;
import java.util.LinkedHashMap;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import pkgDataStore.DataSource;
import pkgSetupFiles.PropertiesSetupFile;
import pkgUtilities.HelperClass;

public class ExposureBasedIndividual {

	DataSource objDataSource = new DataSource();
//	LinkedHashMap<String, String> inputMap = new LinkedHashMap<String, String>();
	LinkedHashMap<String, String> inputMap = new LinkedHashMap<String, String>();

	PropertiesSetupFile objPSF = new PropertiesSetupFile("ExposureBasedIndividual");
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
			poluwElement.sendKeys("2023001312");

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

			Thread.sleep(2000);

			poluwElement = driver.findElement(objPSF.getLocator("btn_scr_final_submit"));
			util.waitForElementToBeClickable(driver, poluwElement);
			poluwElement.click();
			driver.switchTo().alert().accept();
			driver.switchTo().alert().accept();

			Thread.sleep(3000);

			poluwElement = driver.findElement(objPSF.getLocator("txt_application_number"));
//				poluwElement.getText();
			System.out.println("The Application Number :" + poluwElement.getText());

			poluwElement = driver.findElement(objPSF.getLocator("txt_proposal_number"));
//				poluwElement.getText();
			System.out.println("The Proposal Number :" + poluwElement.getText());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public void fillOverdueDetailsAsOnDate(WebDriver driver) {
		try {

			Thread.sleep(1000);
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

	public void selectProduct(WebDriver driver, String policyType) {
		try {

			poluwElement = driver.findElement(objPSF.getLocator("proposal_date"));
			util.waitForElementToBeClickable(driver, poluwElement);
//			poluwElement.clear();
			poluwElement.sendKeys("2022-10-20");

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

	// Buyer Details policy proposal form
	public boolean fillBuyerDetails(WebDriver driver) throws Exception {
		try {

			Thread.sleep(2000);
			inputMap = objDataSource.readData("PolicyProposal");

			poluwElement = driver.findElement(objPSF.getLocator("link_buyerdetails"));
//				util.waitForElementToBeClickable(driver, poluwElement);
			Thread.sleep(1000);
			poluwElement.click();

			statusList = new Select(driver.findElement(objPSF.getLocator("drpdwn_detbuyercountry")));
			util.getRandomValueFromDropdown(driver, statusList);

			poluwElement = driver.findElement(objPSF.getLocator("txt_detbuyername"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.clear();
			poluwElement.sendKeys(inputMap.get("BuyerNameOfInsuranceDetails"));

			poluwElement = driver.findElement(objPSF.getLocator("txt_detbuyeraddress"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.clear();
			poluwElement.sendKeys(inputMap.get("StateInfo"));

			poluwElement = driver.findElement(objPSF.getLocator("txt_detbuyercity"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.clear();
			poluwElement.sendKeys(inputMap.get("Bank_Branch_Address"));

			poluwElement = driver.findElement(objPSF.getLocator("txt_detbuyerphonenum"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.clear();
			poluwElement.sendKeys("02346778899");

			poluwElement = driver.findElement(objPSF.getLocator("txt_detbuyerfaxnum"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.clear();
			poluwElement.sendKeys("442081234567");

			poluwElement = driver.findElement(objPSF.getLocator("txt_detbuyeremail"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			util.enterRandomMailID(poluwElement);

			poluwElement = driver.findElement(objPSF.getLocator("txt_detbuyerweb"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.clear();
			poluwElement.sendKeys("abcd.com");

//				poluwElement = driver.findElement(objPSF.getLocator("txt_detbuyercontperson"));
//				util.waitForVisibilityOfElement(driver, poluwElement);
//				poluwElement.clear();
//				poluwElement.sendKeys("Roman");

			poluwElement = driver.findElement(objPSF.getLocator("txt_detbuyercontperson"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			util.enterRandomString(poluwElement);

			poluwElement = driver.findElement(objPSF.getLocator("txt_detbuyermobnum"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.clear();
			poluwElement.sendKeys("9876543211");

			poluwElement = driver.findElement(objPSF.getLocator("txt_detbuyerregnum"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			util.enterRandomID(poluwElement);

			poluwElement = driver.findElement(objPSF.getLocator("txt_detbuyervatnum"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			util.enterRandomID(poluwElement);

			// BWP Policy Proposal form eight FORM B
			/*
			 * poluwElement = driver.findElement(objPSF.getLocator("txt_altbuyeraddress"));
			 * util.waitForVisibilityOfElement(driver, poluwElement);
			 * poluwElement.sendKeys("Paris");
			 * 
			 * poluwElement = driver.findElement(objPSF.getLocator("txt_altbuyercity"));
			 * util.waitForVisibilityOfElement(driver, poluwElement);
			 * poluwElement.sendKeys("Tokiyo");
			 * 
			 * statusList = new
			 * Select(driver.findElement(objPSF.getLocator("drpdwn_altbuyercountry")));
			 * util.waitForVisibilityOfElement(driver, poluwElement);
			 * statusList.selectByVisibleText("Iran");
			 * 
			 * poluwElement = driver.findElement(objPSF.getLocator("txt_altbuyerphonenum"));
			 * util.waitForVisibilityOfElement(driver, poluwElement);
			 * poluwElement.sendKeys("9876543000");
			 * 
			 * poluwElement = driver.findElement(objPSF.getLocator("txt_altbuyerfaxnum"));
			 * util.waitForVisibilityOfElement(driver, poluwElement);
			 * poluwElement.sendKeys("+44-208-1234567");
			 * 
			 * poluwElement = driver.findElement(objPSF.getLocator("txt_altbuyeremail"));
			 * util.waitForVisibilityOfElement(driver, poluwElement);
			 * poluwElement.sendKeys("buyer1@gmail.com");
			 * 
			 * poluwElement = driver.findElement(objPSF.getLocator("txt_altbuyerweb"));
			 * util.waitForVisibilityOfElement(driver, poluwElement);
			 * poluwElement.sendKeys("buyer1");
			 * 
			 * poluwElement =
			 * driver.findElement(objPSF.getLocator("txt_altbuyercontperson"));
			 * util.waitForVisibilityOfElement(driver, poluwElement);
			 * poluwElement.sendKeys("John Snow");
			 * 
			 * poluwElement = driver.findElement(objPSF.getLocator("txt_altbuyermobnum"));
			 * util.waitForVisibilityOfElement(driver, poluwElement);
			 * poluwElement.sendKeys("9876543000");
			 * 
			 * poluwElement = driver.findElement(objPSF.getLocator("txt_altbuyerregnum"));
			 * util.waitForVisibilityOfElement(driver, poluwElement);
			 * poluwElement.sendKeys("123006");
			 * 
			 * poluwElement = driver.findElement(objPSF.getLocator("txt_altbuyervatnum"));
			 * util.waitForVisibilityOfElement(driver, poluwElement);
			 * poluwElement.sendKeys("12303306");
			 * 
			 * // BWP Policy Proposal form eight FORM C
			 * 
			 * poluwElement = driver.findElement(objPSF.getLocator("txt_buyerparcomname"));
			 * util.waitForVisibilityOfElement(driver, poluwElement);
			 * poluwElement.sendKeys("TCS");
			 * 
			 * poluwElement =
			 * driver.findElement(objPSF.getLocator("txt_buyerparcomaddress"));
			 * util.waitForVisibilityOfElement(driver, poluwElement);
			 * poluwElement.sendKeys("Hinjewadi");
			 * 
			 * poluwElement = driver.findElement(objPSF.getLocator("txt_buyerparcomcity"));
			 * util.waitForVisibilityOfElement(driver, poluwElement);
			 * poluwElement.sendKeys("Pune");
			 * 
			 * statusList = new
			 * Select(driver.findElement(objPSF.getLocator("drpdwn_buyerparcomcountry")));
			 * util.waitForVisibilityOfElement(driver, poluwElement);
			 * statusList.selectByVisibleText("Brazil");
			 * 
			 * poluwElement = driver.findElement(objPSF.getLocator("txt_buyerparcomphone"));
			 * util.waitForVisibilityOfElement(driver, poluwElement);
			 * poluwElement.sendKeys("9876543209");
			 * 
			 * poluwElement = driver.findElement(objPSF.getLocator("txt_buyerparcomfax"));
			 * util.waitForVisibilityOfElement(driver, poluwElement);
			 * poluwElement.sendKeys("+44-208-1234567");
			 * 
			 * poluwElement = driver.findElement(objPSF.getLocator("txt_buyerparcomemail"));
			 * util.waitForVisibilityOfElement(driver, poluwElement);
			 * poluwElement.sendKeys("tcs@gmail.com");
			 * 
			 * poluwElement = driver.findElement(objPSF.getLocator("txt_buyerparcomweb"));
			 * util.waitForVisibilityOfElement(driver, poluwElement);
			 * poluwElement.sendKeys("tcs");
			 * 
			 * poluwElement =
			 * driver.findElement(objPSF.getLocator("txt_buyerparcontperson"));
			 * util.waitForVisibilityOfElement(driver, poluwElement);
			 * poluwElement.sendKeys("Ratan Tata");
			 * 
			 * poluwElement =
			 * driver.findElement(objPSF.getLocator("txt_buyerparcommobnum"));
			 * util.waitForVisibilityOfElement(driver, poluwElement);
			 * poluwElement.sendKeys("9876543210");
			 * 
			 * poluwElement = driver.findElement(objPSF.getLocator("txt_buyerparregnum"));
			 * util.waitForVisibilityOfElement(driver, poluwElement);
			 * poluwElement.sendKeys("3454345");
			 * 
			 * poluwElement = driver.findElement(objPSF.getLocator("txt_buyerparvatnum"));
			 * util.waitForVisibilityOfElement(driver, poluwElement);
			 * poluwElement.sendKeys("34543445");
			 */

			poluwElement = driver.findElement(objPSF.getLocator("btn_savebuyerdetails"));
			util.waitForElementToBeClickable(driver, poluwElement);
			poluwElement.click();

			Thread.sleep(5000);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public boolean fillBankDetails(WebDriver driver) throws Exception {
		try {

			Thread.sleep(2000);
			inputMap = objDataSource.readData("PolicyProposal");

			poluwElement = driver.findElement(objPSF.getLocator("link_bankdetails"));
//				util.waitForElementToBeClickable(driver, poluwElement);
			Thread.sleep(1000);
			poluwElement.click();

//				poluwElement = driver.findElement(objPSF.getLocator("txt_detbankname"));
//				util.waitForVisibilityOfElement(driver, poluwElement);
//				poluwElement.clear();
//				poluwElement.sendKeys("Axis Bank");

			poluwElement = driver.findElement(objPSF.getLocator("txt_detbankname"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.clear();
			poluwElement.sendKeys(inputMap.get("Bank_name"));

			poluwElement = driver.findElement(objPSF.getLocator("txt_detbankaddress"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.clear();
			poluwElement.sendKeys(inputMap.get("StateInfo"));

//				poluwElement = driver.findElement(objPSF.getLocator("txt_detbankcity"));
//				util.waitForVisibilityOfElement(driver, poluwElement);
//				poluwElement.clear();
//				poluwElement.sendKeys("Mumbai");

			poluwElement = driver.findElement(objPSF.getLocator("txt_detbankcity"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.clear();
			poluwElement.sendKeys(inputMap.get("Bank_Branch_Address"));

			statusList = new Select(driver.findElement(objPSF.getLocator("drpdwn_detbankcountry")));
			util.getRandomValueFromDropdown(driver, statusList);

			poluwElement = driver.findElement(objPSF.getLocator("txt_detbankphnnum"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.clear();
			poluwElement.sendKeys("02345887766");

			poluwElement = driver.findElement(objPSF.getLocator("txt_detbankfax"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.clear();
			poluwElement.sendKeys("442081234567");

			poluwElement = driver.findElement(objPSF.getLocator("txt_detbankemail"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.clear();
			util.enterRandomMailID(poluwElement);

			poluwElement = driver.findElement(objPSF.getLocator("txt_detbankaccnum"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.clear();
			util.enterRandomID(poluwElement);

			poluwElement = driver.findElement(objPSF.getLocator("txt_detbankswiftcode"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.clear();
			util.enterRandomID(poluwElement);

			poluwElement = driver.findElement(objPSF.getLocator("btn_savebankdetails"));
			util.waitForElementToBeClickable(driver, poluwElement);
			poluwElement.click();
			driver.switchTo().alert().accept();

			Thread.sleep(5000);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	// LC Bank Details
	public boolean fillLCBankDetails(WebDriver driver) throws Exception {
		try {

			Thread.sleep(2000);
			inputMap = objDataSource.readData("PolicyProposal");

			poluwElement = driver.findElement(objPSF.getLocator("link_lcbankdetails"));
//				util.waitForElementToBeClickable(driver, poluwElement);
			Thread.sleep(1000);
			poluwElement.click();

//				poluwElement = driver.findElement(objPSF.getLocator("txt_lcbankname"));
//				util.waitForVisibilityOfElement(driver, poluwElement);
//				poluwElement.sendKeys("SBI Bank");

			poluwElement = driver.findElement(objPSF.getLocator("txt_lcbankname"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.sendKeys(inputMap.get("Bank_name"));

			poluwElement = driver.findElement(objPSF.getLocator("txt_lcbankaddress"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			util.enterAddressLine1(poluwElement);

			poluwElement = driver.findElement(objPSF.getLocator("txt_lcbankcity"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			util.enterFullAddress(poluwElement);

			statusList = new Select(driver.findElement(objPSF.getLocator("drpdwn_lcbankcountry")));
			util.getRandomValueFromDropdown(driver, statusList);

			poluwElement = driver.findElement(objPSF.getLocator("txt_lcbankphnnum"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.sendKeys("02345667788");

			poluwElement = driver.findElement(objPSF.getLocator("txt_lcbankfax"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.sendKeys("123451234567");

			poluwElement = driver.findElement(objPSF.getLocator("txt_lcbankemail"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			util.enterRandomMailID(poluwElement);

			poluwElement = driver.findElement(objPSF.getLocator("txt_lcbankaccnum"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			util.enterRandomID(poluwElement);

			poluwElement = driver.findElement(objPSF.getLocator("txt_lcbankswiftcode"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			util.enterRandomID(poluwElement);

			poluwElement = driver.findElement(objPSF.getLocator("btn_lcbankdetails"));
			util.waitForElementToBeClickable(driver, poluwElement);
			poluwElement.click();
			driver.switchTo().alert().accept();
			Thread.sleep(5000);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	// Details of all shipments made to the buyer/ LC opening bank in the last one
	// year
	public boolean fillDetailsOfAllShipmentsMadeToTheBuyerLCOpeningBank(WebDriver driver) throws Exception {
		try {

			Thread.sleep(2000);
			inputMap = objDataSource.readData("PolicyProposal");
			poluwElement = driver.findElement(objPSF.getLocator("link_allshipmentstobuyer"));
//				util.waitForElementToBeClickable(driver, poluwElement);
			Thread.sleep(1000);
			poluwElement.click();

			poluwElement = driver.findElement(objPSF.getLocator("txt_allshipdateofshipment"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			util.setCurrentDate(poluwElement);

			poluwElement = driver.findElement(objPSF.getLocator("txt_allshipvalue"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.sendKeys(inputMap.get("Total_Value_Bad_Debts"));

			statusList = new Select(driver.findElement(objPSF.getLocator("drpdwn_allshiptopid")));
			util.getRandomValueFromDropdown(driver, statusList);

			poluwElement = driver.findElement(objPSF.getLocator("txt_allshipduepaymentdate"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			util.setCurrentDate(poluwElement);

			poluwElement = driver.findElement(objPSF.getLocator("txt_allshipduerealizationdate"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			util.setCurrentDate(poluwElement);

//				poluwElement = driver.findElement(objPSF.getLocator("txt_allshipreasonfordue"));
//				util.waitForVisibilityOfElement(driver, poluwElement);
//				poluwElement.sendKeys("No Reason");

			poluwElement = driver.findElement(objPSF.getLocator("txt_allshipreasonfordue"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.sendKeys(inputMap.get("NonPayment"));

			poluwElement = driver.findElement(objPSF.getLocator("btn_addnewvalueallshipments"));
			util.waitForElementToBeClickable(driver, poluwElement);
			poluwElement.click();
			driver.switchTo().alert().accept();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public boolean fillOrdersOnHand(WebDriver driver) {
		try {

			Thread.sleep(2000);
			inputMap = objDataSource.readData("PolicyProposal");
			JavascriptExecutor m = (JavascriptExecutor) driver;
			m.executeScript("window.scrollBy(0,-800)");

			poluwElement = driver.findElement(objPSF.getLocator("link_OrderOnHand"));
			util.waitForElementToBeClickable(driver, poluwElement);
			poluwElement.click();

			drpdwnList = new Select(driver.findElement(objPSF.getLocator("drpdwn_OrderOnHand_Type")));
			util.getRandomValueFromDropdown(driver, drpdwnList);

			poluwElement = driver.findElement(objPSF.getLocator("txt_OrderOnHand_OrderNo"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			util.enterRandomID(poluwElement);

			statusList = new Select(driver.findElement(objPSF.getLocator("drpdwn_OrderOnHand_Payment")));
			util.getRandomValueFromDropdown(driver, statusList);

			poluwElement = driver.findElement(objPSF.getLocator("txt_OrderOnHand_Amount_Foreign"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.sendKeys(inputMap.get("Profit_Loss_After_Tax"));

			drpdwnList = new Select(driver.findElement(objPSF.getLocator("drpdwn_Foreign_Currency")));
			util.getRandomValueFromDropdown(driver, drpdwnList);

			poluwElement = driver.findElement(objPSF.getLocator("txt_OrderOnHand_rate_of_exchange"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.sendKeys("50");

//			poluwElement = driver.findElement(objPSF.getLocator("txt_OrderOnHand_Amount_INR"));
//			util.waitForVisibilityOfElement(driver, poluwElement);
//			poluwElement.sendKeys(inputMap.get("Total_Value_Bad_Debts"));

//			poluwElement = driver.findElement(objPSF.getLocator("date_orderOnHand_Cotract_LC"));
//			util.waitForVisibilityOfElement(driver, poluwElement);
//			util.setCurrentDate(poluwElement);
//
//			poluwElement = driver.findElement(objPSF.getLocator("date_orderOnHand_Cotract_LC_Expiry"));
//			util.waitForVisibilityOfElement(driver, poluwElement);
//			util.setCurrentDate(poluwElement);
//
//			poluwElement = driver.findElement(objPSF.getLocator("date_orderOnHand_Last_Date_Within"));
//			util.waitForVisibilityOfElement(driver, poluwElement);
//			util.setCurrentDate(poluwElement);

			poluwElement = driver.findElement(objPSF.getLocator("btn_OrderOnHand_Add_New"));
			util.waitForElementToBeClickable(driver, poluwElement);
			poluwElement.click();
			driver.switchTo().alert().accept();

			Thread.sleep(2000);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;

	}

	// Anticipated turnover for the next one year on the buyer
	public boolean fillAnticipatedTurnoverForTheNextOneYearOnTheBuyer(WebDriver driver) throws Exception {
		try {

			Thread.sleep(2000);
			inputMap = objDataSource.readData("PolicyProposal");

			poluwElement = driver.findElement(objPSF.getLocator("link_antiturnover"));
			util.waitForElementToBeClickable(driver, poluwElement);
			poluwElement.click();

			poluwElement = driver.findElement(objPSF.getLocator("txt_antiturnovervalue"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.sendKeys(inputMap.get("Total_Value_Bad_Debts"));

			statusList = new Select(driver.findElement(objPSF.getLocator("drpdwn_antiturnovertopid")));
			util.selectRandomValueFromDropdown(driver, statusList);

			poluwElement = driver.findElement(objPSF.getLocator("btn_addvalueantiturn"));
			util.waitForElementToBeClickable(driver, poluwElement);
			poluwElement.click();
			driver.switchTo().alert().accept();


		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	// Shipping Schedule Policy Proposal form
	public boolean fillShippingSchedule(WebDriver driver) throws Exception {
		try {

			Thread.sleep(2000);
			inputMap = objDataSource.readData("PolicyProposal");


			poluwElement = driver.findElement(objPSF.getLocator("link_shippingschedule"));
//				util.waitForElementToBeClickable(driver, poluwElement);
			Thread.sleep(1000);
			poluwElement.click();

			statusList = new Select(driver.findElement(objPSF.getLocator("drpdwn_shipscheduleyear")));
			util.getRandomValueFromDropdown(driver, statusList);

			statusList = new Select(driver.findElement(objPSF.getLocator("drpdwn_shipschedulemonth")));
			util.getRandomValueFromDropdown(driver, statusList);

			poluwElement = driver.findElement(objPSF.getLocator("txt_shipschedulevalue"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.sendKeys(inputMap.get("Total_Value_Bad_Debts"));

			statusList = new Select(driver.findElement(objPSF.getLocator("drpdwn_shipscheduletopid")));
			util.getRandomValueFromDropdown(driver, statusList);

			poluwElement = driver.findElement(objPSF.getLocator("btn_addvalueshippingschedule"));
			util.waitForElementToBeClickable(driver, poluwElement);
			poluwElement.click();
			driver.switchTo().alert().accept();

			Thread.sleep(2000);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
		}

		// Other Proposal Details of SSP product tab.
		public boolean fillSSPPolicyDetails(WebDriver driver) {
			try {

				Thread.sleep(2000);
				inputMap = objDataSource.readData("PolicyProposal");
				JavascriptExecutor m = (JavascriptExecutor) driver;
				m.executeScript("window.scrollBy(0,-500)");

				poluwElement = driver.findElement(objPSF.getLocator("link_ssp_other_proposal_details"));
				util.waitForElementToBeClickable(driver, poluwElement);
				poluwElement.click();

				poluwElement = driver.findElement(objPSF.getLocator("check_ssp_gov_buyer"));
				util.waitForElementToBeClickable(driver, poluwElement);
				poluwElement.click();

				poluwElement = driver.findElement(objPSF.getLocator("txt_ssp_govbuyerdetails"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				poluwElement.sendKeys(inputMap.get("Bank_name"));

				poluwElement = driver.findElement(objPSF.getLocator("check_ssp_buyerassociated"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				poluwElement.click();

				poluwElement = driver.findElement(objPSF.getLocator("txt_ssp_buyerassociateddet"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				poluwElement.sendKeys(inputMap.get("BuyerNameOfInsuranceDetails"));

				poluwElement = driver.findElement(objPSF.getLocator("txt_ssp_descofcommodity"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				poluwElement.sendKeys(inputMap.get("NonPayment"));

				statusList = new Select(driver.findElement(objPSF.getLocator("drpdwn_ssp_countryfromwhere")));
				util.getRandomValueFromDropdown(driver, statusList);

				statusList = new Select(driver.findElement(objPSF.getLocator("drpdwn_ssp_countryofdestination")));
				util.getRandomValueFromDropdown(driver, statusList);

//				poluwElement = driver.findElement(objPSF.getLocator("txt_ssp_required_loss_limit"));
//				util.waitForElementToBeClickable(driver, poluwElement);
//				poluwElement.clear();
//				poluwElement.sendKeys("900");

				poluwElement = driver.findElement(objPSF.getLocator("txt_ssp_requiredpercentage"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				poluwElement.sendKeys("8");

				statusList = new Select(driver.findElement(objPSF.getLocator("drpdwn_required_payment")));
				util.getRandomValueFromDropdown(driver, statusList);

				poluwElement = driver.findElement(objPSF.getLocator("btn_ssp_save"));
				util.waitForElementToBeClickable(driver, poluwElement);
				poluwElement.click();
				driver.switchTo().alert().accept();

				poluwElement = driver.findElement(objPSF.getLocator("link_ssp_other_proposal_details"));
				util.waitForElementToBeClickable(driver, poluwElement);
				poluwElement.click();

				poluwElement = driver.findElement(objPSF.getLocator("btn_ssp_final_submit"));
				util.waitForElementToBeClickable(driver, poluwElement);
				poluwElement.click();
				driver.switchTo().alert().accept();

				Thread.sleep(5000);

				poluwElement = driver.findElement(objPSF.getLocator("txt_application_number"));
//				poluwElement.getText();
				System.out.println("The Application Number :" + poluwElement.getText());

				poluwElement = driver.findElement(objPSF.getLocator("txt_proposal_number"));
//				poluwElement.getText();
				System.out.println("The Proposal Number :" + poluwElement.getText());

			} catch (Exception e) {
				e.printStackTrace();
			}
			return status;

		}

		// Other Proposal Details (BWP)
		public boolean fillBWPPolicyDetails(WebDriver driver) throws Exception {
			try {

				Thread.sleep(2000);
				inputMap = objDataSource.readData("PolicyProposal");
				JavascriptExecutor m = (JavascriptExecutor) driver;
				m.executeScript("window.scrollBy(0,-500)");

				poluwElement = driver.findElement(objPSF.getLocator("link_bwpproduct"));
				util.waitForElementToBeClickable(driver, poluwElement);
				poluwElement.click();

				poluwElement = driver.findElement(objPSF.getLocator("check_govbuyer"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				poluwElement.click();

				poluwElement = driver.findElement(objPSF.getLocator("txt_govbuyerdetails"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				poluwElement.sendKeys(inputMap.get("BuyerNameOfInsuranceDetails"));

				poluwElement = driver.findElement(objPSF.getLocator("check_buyerassociated"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				poluwElement.click();

				poluwElement = driver.findElement(objPSF.getLocator("txt_buyerassociateddet"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				poluwElement.sendKeys(inputMap.get("Bank_name"));

				poluwElement = driver.findElement(objPSF.getLocator("txt_descofcommodity"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				poluwElement.sendKeys(inputMap.get("Bank_name"));

				drpdwnList = new Select(driver.findElement(objPSF.getLocator("drpdwn_countryfromwhere")));
				util.getRandomValueFromDropdown(driver, drpdwnList);

				drpdwnList = new Select(driver.findElement(objPSF.getLocator("drpdwn_countryofdestination")));
				util.getRandomValueFromDropdown(driver, drpdwnList);

				poluwElement = driver.findElement(objPSF.getLocator("txt_requiredpercentage"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				poluwElement.sendKeys("8");

				drpdwnList = new Select(driver.findElement(objPSF.getLocator("drpdwn_requiredofpayment")));
				util.getRandomValueFromDropdown(driver, drpdwnList);

				poluwElement = driver.findElement(objPSF.getLocator("txt_anticipated_max_amount"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				poluwElement.sendKeys(inputMap.get("CreditInformation"));

				poluwElement = driver.findElement(objPSF.getLocator("btn_bwp_save"));
				util.waitForElementToBeClickable(driver, poluwElement);
				poluwElement.click();
				driver.switchTo().alert().accept();
				Thread.sleep(5000);

				poluwElement = driver.findElement(objPSF.getLocator("link_bwpproduct"));
				util.waitForElementToBeClickable(driver, poluwElement);
				poluwElement.click();

				poluwElement = driver.findElement(objPSF.getLocator("btn_bwp_final_submit"));
				util.waitForElementToBeClickable(driver, poluwElement);
				poluwElement.click();
				driver.switchTo().alert().accept();

				Thread.sleep(6000);

				poluwElement = driver.findElement(objPSF.getLocator("txt_application_number"));
//				poluwElement.getText();
				System.out.println("The Application Number :" + poluwElement.getText());

				poluwElement = driver.findElement(objPSF.getLocator("txt_proposal_number"));
//				poluwElement.getText();
				System.out.println("The Proposal Number :" + poluwElement.getText());

			} catch (Exception e) {
				e.printStackTrace();
			}
			return status;
		}

		// Global Entity/Stock Holder Details
		public void fillGlobalEntityStockHolderDetails(WebDriver driver) {
			try {
				Thread.sleep(2000);
				inputMap = objDataSource.readData("PolicyProposal");
				poluwElement = driver.findElement(objPSF.getLocator("btn_globalEntityStockHolderDetailsTab"));
				util.waitForElementToBeClickable(driver, poluwElement);
				poluwElement.click();

				poluwElement = driver.findElement(objPSF.getLocator("btn_activeTab"));
				util.waitForVisibilityOfElement(driver, poluwElement);

				if (poluwElement.getText().contains("Global Entity / Stock Holder"))
					System.out.println("Active: Global Entity / Stock Holder Details tab");
				else
					System.out.println("Not Active: Global Entity / Stock Holder Details tab");

//				NameOfTheInsurance
//				poluwElement = driver.findElement(objPSF.getLocator("txt_globalEntityStockHolder_Name"));
//				util.waitForVisibilityOfElement(driver, poluwElement);
//				poluwElement.sendKeys("ECGC");

				poluwElement = driver.findElement(objPSF.getLocator("txt_globalEntityStockHolder_Name"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				poluwElement.sendKeys(inputMap.get("NameOfTheInsurance"));

				poluwElement = driver.findElement(objPSF.getLocator("txt_globalEntityStockHolder_TelephoneNo"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				poluwElement.clear();
				poluwElement.sendKeys("09876543210");

				poluwElement = driver.findElement(objPSF.getLocator("txt_globalEntityStockHolder_Email"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				util.enterRandomMailID(poluwElement);

				poluwElement = driver.findElement(objPSF.getLocator("txt_globalEntityStockHolder_FaxNo"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				poluwElement.clear();
				poluwElement.sendKeys("+12-345-1234567");

				drpdwnList = new Select(
						driver.findElement(objPSF.getLocator("drpdwn_globalEntityStockHolder_Country")));
				util.getRandomValueFromDropdown(driver, drpdwnList);
//				util.waitForDropdownOptions(driver, drpdwnList);

//				poluwElement = driver.findElement(objPSF.getLocator("txt_globalEntityStockHolder_AddressLine"));
//				util.waitForVisibilityOfElement(driver, poluwElement);
//				poluwElement.sendKeys("Mumbai");

				poluwElement = driver.findElement(objPSF.getLocator("txt_globalEntityStockHolder_AddressLine"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				poluwElement.sendKeys(inputMap.get("Bank_Branch_Address"));

				poluwElement = driver.findElement(objPSF.getLocator("btn_globalEntityStockHolder_Save"));
				util.waitForElementToBeClickable(driver, poluwElement);
				poluwElement.click();

				driver.switchTo().alert().accept();

				Thread.sleep(5000);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// Global Entity / Stock Holder Bank Details
		public void fillGlobalEntityStockHolderBankDetails(WebDriver driver) {
			try {

				Thread.sleep(2000);
				inputMap = objDataSource.readData("PolicyProposal");
				JavascriptExecutor g = (JavascriptExecutor) driver;
				g.executeScript("window.scrollBy(0,-500)");

				poluwElement = driver.findElement(objPSF.getLocator("btn_globalEntityStockHolderBankDetailsTab"));
				util.waitForElementToBeClickable(driver, poluwElement);
				poluwElement.click();

				poluwElement = driver.findElement(objPSF.getLocator("btn_activeTab"));
				util.waitForVisibilityOfElement(driver, poluwElement);

				if (poluwElement.getText().contains("Global Entity/Stock Holder Bank Details"))
					System.out.println("Active: Global Entity / Stock Holder Bank Details tab");
				else
					System.out.println("Not Active: Global Entity / Stock Holder Bank Details tab");

				poluwElement = driver.findElement(objPSF.getLocator("txt_globalEntityStockHolderBankDetails_BankName"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				poluwElement.sendKeys(inputMap.get("NameOfTheInsurance"));

//				poluwElement = driver.findElement(objPSF.getLocator("txt_limitAvailedByAllBank_BankAddress"));
//				util.waitForVisibilityOfElement(driver, poluwElement);
//				poluwElement.sendKeys(inputMap.get("NameOfTheInsurance"));

				poluwElement = driver
						.findElement(objPSF.getLocator("txt_globalEntityStockHolderBankDetails_BankAccNo"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				util.enterRandomID(poluwElement);

				poluwElement = driver.findElement(objPSF.getLocator("txt_globalEntityStockHolderBankDetails_Email"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				util.enterRandomMailID(poluwElement);

				poluwElement = driver.findElement(objPSF.getLocator("txt_globalEntityStockHolderBankDetails_MobileNo"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				poluwElement.sendKeys("9876543210");

				poluwElement = driver.findElement(objPSF.getLocator("txt_globalEntityStockHolderBankDetails_FaxNo"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				poluwElement.sendKeys("+12-345-1234567");

				poluwElement = driver.findElement(objPSF.getLocator("txt_globalEntityStockHolderBankDetails_Street"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				util.enterAddressLine2(poluwElement);

				poluwElement = driver.findElement(objPSF.getLocator("txt_globalEntityStockHolderBankDetails_City"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				poluwElement.sendKeys(inputMap.get("Bank_Branch_Address"));

				drpdwnList = new Select(
						driver.findElement(objPSF.getLocator("drpdwn_globalEntityStockHolderBankDetails_Country")));
				util.getRandomValueFromDropdown(driver, drpdwnList);
//				util.waitForDropdownOptions(driver, drpdwnList);

				poluwElement = driver.findElement(objPSF.getLocator("btn_globalEntityStockHolderBankDetails_Save"));
				util.waitForElementToBeClickable(driver, poluwElement);
				poluwElement.click();
				driver.switchTo().alert().accept();

				Thread.sleep(5000);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public void fillShipmentMadeToBuyerOrLCOpeningBankInLast1Year(WebDriver driver) {
			try {

				Thread.sleep(2000);
				inputMap = objDataSource.readData("PolicyProposal");
				poluwElement = driver
						.findElement(objPSF.getLocator("btn_allShipmentsToBuyerOrLCOpeningBankInLast1YearTab"));
				util.waitForElementToBeClickable(driver, poluwElement);
				poluwElement.click();

				poluwElement = driver.findElement(objPSF.getLocator("btn_activeTab"));
				util.waitForVisibilityOfElement(driver, poluwElement);

				if (poluwElement.getText()
						.contains("Details of all shipments made to the buyer / LC opening bank in the last one year"))
					System.out.println(
							"Active: Details Of All Shipments Made To The Buyer /LC Opening Bank In The Last One Year tab");
				else
					System.out.println(
							"Not Active: Details Of All Shipments Made To The Buyer /LC Opening Bank In The Last One Year tab");

				poluwElement = driver.findElement(
						objPSF.getLocator("date_detailsOfAllShipmentsToBuyerOrLCOpeningBankInLast1Year_ShipmentDate"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				util.setCurrentDate(poluwElement);

				poluwElement = driver.findElement(
						objPSF.getLocator("txt_detailsOfAllShipmentsToBuyerOrLCOpeningBankInLast1Year_Value"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				poluwElement.sendKeys(inputMap.get("Total_Sales_Turnover"));

				drpdwnList = new Select(driver.findElement(
						objPSF.getLocator("drpdwn_detailsOfAllShipmentsToBuyerOrLCOpeningBankInLast1Year_TopID")));
				util.getRandomValueFromDropdown(driver, drpdwnList);

				poluwElement = driver.findElement(objPSF
						.getLocator("date_detailsOfAllShipmentsToBuyerOrLCOpeningBankInLast1Year_PaymentDueDate"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				util.setCurrentDate(poluwElement);

				poluwElement = driver.findElement(objPSF
						.getLocator("date_detailsOfAllShipmentsToBuyerOrLCOpeningBankInLast1Year_RealizationDueDate"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				util.setCurrentDate(poluwElement);

				poluwElement = driver.findElement(objPSF
						.getLocator("txt_detailsOfAllShipmentsToBuyerOrLCOpeningBankInLast1Year_DelayOrOverdueReason"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				poluwElement.sendKeys(inputMap.get("NonPayment"));

				poluwElement = driver.findElement(
						objPSF.getLocator("btn_detailsOfAllShipmentsToBuyerOrLCOpeningBankInLast1Year_AddNewValue"));
				util.waitForElementToBeClickable(driver, poluwElement);
				poluwElement.click();
				driver.switchTo().alert().accept();

				Thread.sleep(3000);

			} catch (Exception e) {

			}
		}

		// Quarter wise Expected Sales through Agent
		public void fillQuarterwiseExpectedSales(WebDriver driver) {
			try {
				Thread.sleep(2000);
				inputMap = objDataSource.readData("PolicyProposal");
				poluwElement = driver.findElement(objPSF.getLocator("btn_quarterWiseExpectedSalesThroughAgentTab"));
				util.waitForElementToBeClickable(driver, poluwElement);
				poluwElement.click();

				poluwElement = driver.findElement(objPSF.getLocator("btn_activeTab"));
				util.waitForVisibilityOfElement(driver, poluwElement);

				if (poluwElement.getText().contains("Quarter Wise Expected Sales through Agent"))
					System.out.println("Active: Quarter Wise Expected Sales Through Agent tab");
				else
					System.out.println("Not Active: Quarter Wise Expected Sales Through Agent tab");

				poluwElement = driver.findElement(
						objPSF.getLocator("txt_quarterWiseExpectedSalesThroughAgent_ForeignCurrency_Quarter1"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				poluwElement.clear();
				poluwElement.sendKeys(inputMap.get("Total_Export_Turnover"));

				poluwElement = driver.findElement(
						objPSF.getLocator("txt_quarterWiseExpectedSalesThroughAgent_ForeignCurrency_Quarter2"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				poluwElement.clear();
				poluwElement.sendKeys(inputMap.get("Total_Export_Turnover"));

				poluwElement = driver.findElement(
						objPSF.getLocator("txt_quarterWiseExpectedSalesThroughAgent_ForeignCurrency_Quarter3"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				poluwElement.clear();
				poluwElement.sendKeys(inputMap.get("Total_Export_Turnover"));

				poluwElement = driver.findElement(
						objPSF.getLocator("txt_quarterWiseExpectedSalesThroughAgent_ForeignCurrency_Quarter4"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				poluwElement.clear();
				poluwElement.sendKeys(inputMap.get("Total_Export_Turnover"));

				/*
				 * poluwElement = driver.findElement(objPSF.getLocator(
				 * "txt_quarterWiseExpectedSalesThroughAgent_ForeignCurrency_Total"));
				 * util.waitForVisibilityOfElement(driver, poluwElement);
				 * poluwElement.getText();
				 */

				poluwElement = driver.findElement(
						objPSF.getLocator("txt_quarterWiseExpectedSalesThroughAgent_IndianRupees_Quarter1"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				poluwElement.clear();
				poluwElement.sendKeys(inputMap.get("Total_Sales_Turnover"));

				poluwElement = driver.findElement(
						objPSF.getLocator("txt_quarterWiseExpectedSalesThroughAgent_IndianRupees_Quarter2"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				poluwElement.clear();
				poluwElement.sendKeys(inputMap.get("Total_Sales_Turnover"));

				poluwElement = driver.findElement(
						objPSF.getLocator("txt_quarterWiseExpectedSalesThroughAgent_IndianRupees_Quarter3"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				poluwElement.clear();
				poluwElement.sendKeys(inputMap.get("Total_Sales_Turnover"));

				poluwElement = driver.findElement(
						objPSF.getLocator("txt_quarterWiseExpectedSalesThroughAgent_IndianRupees_Quarter4"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				poluwElement.clear();
				poluwElement.sendKeys(inputMap.get("Total_Sales_Turnover"));

				/*
				 * poluwElement = driver.findElement(objPSF.getLocator(
				 * "txt_quarterWiseExpectedSalesThroughAgent_IndianRupees_Total"));
				 * util.waitForVisibilityOfElement(driver, poluwElement);
				 * poluwElement.getText();
				 */

				drpdwnList = new Select(driver.findElement(
						objPSF.getLocator("drpdwn_quarterWiseExpectedSalesThroughAgent_ForeignCurrency_Currency")));
				util.waitForVisibilityOfElement(driver, poluwElement);
				util.getRandomValueFromDropdown(driver, drpdwnList);

				poluwElement = driver.findElement(
						objPSF.getLocator("txt_quarterWiseExpectedSalesThroughAgent_ForeignCurrency_ExchangeRate"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				poluwElement.clear();
				poluwElement.sendKeys(inputMap.get("CreditInformation"));
				/*
				 * poluwElement = driver .findElement(objPSF.getLocator(
				 * "txt_quarterWiseExpectedSalesThroughAgent_BuyerDetails_Code"));
				 * util.waitForVisibilityOfElement(driver, poluwElement);
				 * poluwElement.sendKeys("1234592W");
				 * 
				 * poluwElement = driver .findElement(objPSF.getLocator(
				 * "txt_quarterWiseExpectedSalesThroughAgent_BuyerDetails_Name"));
				 * util.waitForVisibilityOfElement(driver, poluwElement);
				 * poluwElement.sendKeys("Amazon");
				 * 
				 * drpdwnList = new Select(driver.findElement( objPSF.getLocator(
				 * "drpdwn_quarterWiseExpectedSalesThroughAgent_BuyerDetails_Country")));
				 * util.getRandomValueFromDropdown(driver, drpdwnList); //
				 * util.waitForVisibilityOfElement(driver, poluwElement);
				 * 
				 */
				poluwElement = driver.findElement(
						objPSF.getLocator("btn_quarterWiseExpectedSalesThroughAgent_ForeignCurrency_Save"));
				util.waitForElementToBeClickable(driver, poluwElement);
				poluwElement.click();

				driver.switchTo().alert().accept();

				Thread.sleep(5000);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public void fillExpectedAnnualTurnoverEachCountry(WebDriver driver) {
			try {

				Thread.sleep(2000);
				inputMap = objDataSource.readData("PolicyProposal");
				poluwElement = driver.findElement(objPSF.getLocator("btn_expectedAnnualTurnoverInEachCountryTab"));
				util.waitForElementToBeClickable(driver, poluwElement);
				poluwElement.click();

				poluwElement = driver.findElement(objPSF.getLocator("btn_activeTab"));
				util.waitForVisibilityOfElement(driver, poluwElement);

				if (poluwElement.getText().contains("Expected Annual Turnover In Each Country"))
					System.out.println("Active: Expected Annual Turnover In Each Country tab");
				else
					System.out.println("Not Active: Expected Annual Turnover In Each Country tab");

//				poluwElement = driver.findElement(objPSF.getLocator("radiobtn_expectedAnnualTurnoverInEachCountry_Yes"));
//				util.waitForElementToBeClickable(driver, poluwElement);
//				poluwElement.click();

				/*
				 * poluwElement = driver.findElement(objPSF.getLocator(
				 * "radiobtn_expectedAnnualTurnoverInEachCountry_No"));
				 * util.waitForElementToBeClickable(driver, poluwElement); poluwElement.click();
				 */

				drpdwnList = new Select(
						driver.findElement(objPSF.getLocator("drpdwn_expectedAnnualTurnoverInEachCountry_Country")));
				util.waitForVisibilityOfElement(driver, poluwElement);
				util.getRandomValueFromDropdown(driver, drpdwnList);

				poluwElement = driver.findElement(
						objPSF.getLocator("txt_expectedAnnualTurnoverInEachCountry_ExpectedAnnualTurnover"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				poluwElement.sendKeys(inputMap.get("Total_Sales_Turnover"));

				poluwElement = driver
						.findElement(objPSF.getLocator("btn_expectedAnnualTurnoverInEachCountry_AddNewValue"));
				util.waitForElementToBeClickable(driver, poluwElement);
				poluwElement.click();

				driver.switchTo().alert().accept();

				Thread.sleep(2000);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// Ultimate Buyer With Credit Details Propsoal form
		public void fillUltimateBuyerWithCreditDetails(WebDriver driver) {

			try {
				Thread.sleep(2000);
				inputMap = objDataSource.readData("PolicyProposal");
				poluwElement = driver.findElement(objPSF.getLocator("link_ultimateBuyerWithCreditDetails"));
				util.waitForElementToBeClickable(driver, poluwElement);
				poluwElement.click();

//					poluwElement = driver.findElement(objPSF.getLocator("txt_buyerCode_UltimateBuyer"));
//					util.waitForVisibilityOfElement(driver, poluwElement);
//					poluwElement.sendKeys("12345");

				poluwElement = driver.findElement(objPSF.getLocator("txt_buyerName_UltimateBuyer"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				poluwElement.sendKeys(inputMap.get("BuyerNameOfInsuranceDetails"));

				poluwElement = driver.findElement(objPSF.getLocator("txt_addressLine_UltimateBuyer"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				poluwElement.sendKeys(inputMap.get("Bank_Branch_Address"));

				drpdwnList = new Select(driver.findElement(objPSF.getLocator("drpdwn_country_UltimateBuyer")));
				util.getRandomValueFromDropdown(driver, drpdwnList);
//					util.waitForDropdownOptions(driver, drpdwnList);

				poluwElement = driver.findElement(objPSF.getLocator("txt_amountForeignCurrency_UltimateBuyer"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				poluwElement.sendKeys(inputMap.get("Total_Sales_Turnover"));

				drpdwnList = new Select(driver.findElement(objPSF.getLocator("drpdwn_foreignCurrency_UltimateBuyer")));
				util.getRandomValueFromDropdown(driver, drpdwnList);
//					util.waitForDropdownOptions(driver, drpdwnList);

				poluwElement = driver.findElement(objPSF.getLocator("txt_amountExtendedInRupees_UltimateBuyer"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				poluwElement.sendKeys(inputMap.get("Total_Sales_Turnover"));

				poluwElement = driver.findElement(objPSF.getLocator("btn_addNew_ultimateBuyer"));
				util.waitForElementToBeClickable(driver, poluwElement);
				poluwElement.click();

				driver.switchTo().alert().accept();

				Thread.sleep(2000);

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		public void fillUltimateBuyerLossDetails(WebDriver driver) {
			try {

				Thread.sleep(2000);
				inputMap = objDataSource.readData("PolicyProposal");

				poluwElement = driver.findElement(objPSF.getLocator("btn_ultimateBuyerLossDetailsTab"));
				util.waitForElementToBeClickable(driver, poluwElement);
				poluwElement.click();

				poluwElement = driver.findElement(objPSF.getLocator("txt_ultimateBuyerLossDetails_BuyerName"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				poluwElement.sendKeys(inputMap.get("BuyerNameOfInsuranceDetails"));

				poluwElement = driver.findElement(objPSF.getLocator("txt_ultimateBuyerLossDetails_AddressLine"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				poluwElement.sendKeys(inputMap.get("StateInfo"));

				drpdwnList = new Select(
						driver.findElement(objPSF.getLocator("drpdwn_ultimateBuyerLossDetails_Country")));
				util.getRandomValueFromDropdown(driver, drpdwnList);

				poluwElement = driver.findElement(objPSF.getLocator("txt_ultimateBuyerLossDetails_LossAmount"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				poluwElement.sendKeys(inputMap.get("Total_Sales_Turnover"));

				poluwElement = driver.findElement(objPSF.getLocator("txt_ultimateBuyerLossDetails_ReasonForLoss"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				poluwElement.sendKeys(inputMap.get("NonPayment"));

				poluwElement = driver.findElement(objPSF.getLocator("btn_ultimateBuyerLossDetails_AddNew"));
				util.waitForElementToBeClickable(driver, poluwElement);
				poluwElement.click();
				driver.switchTo().alert().accept();

				Thread.sleep(2000);

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		public void fillCSAOtherProposalDetails(WebDriver driver) {
			try {

				Thread.sleep(2000);
				inputMap = objDataSource.readData("PolicyProposal");
				JavascriptExecutor m = (JavascriptExecutor) driver;
				m.executeScript("window.scrollBy(0,-500)");

				poluwElement = driver.findElement(objPSF.getLocator("btn_CSA_Tab"));
				util.waitForElementToBeClickable(driver, poluwElement);
				poluwElement.click();

				poluwElement = driver.findElement(objPSF.getLocator("btn_CSA_Tab"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				if (poluwElement.getText().contains("Other Proposal Details (CSA) "))
					System.out.println("Active: CSA Proposal Details tab");
				else
					System.out.println("Not Active: CSA Proposal Details tab");

				poluwElement = driver.findElement(objPSF.getLocator("chckbx_CSA_Finacial_relationship"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				poluwElement.click();

				poluwElement = driver.findElement(objPSF.getLocator("txt_CSA_ContractNumber"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				poluwElement.sendKeys("98765432111");

				poluwElement = driver.findElement(objPSF.getLocator("txt_CSA_Contract_Date"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				util.setCurrentDate(poluwElement);

				poluwElement = driver.findElement(objPSF.getLocator("txt_CSA_Contract_Expire"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				util.selectRandomFutureDate(poluwElement);

				drpdwnList = new Select(driver.findElement(objPSF.getLocator("drpdwn_CSA_Commodity")));
				util.getRandomValueFromDropdown(driver, drpdwnList);

				poluwElement = driver.findElement(objPSF.getLocator("txt_CSA_Amount_Foreign_Currency"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				poluwElement.sendKeys(inputMap.get("Total_Export_Turnover"));

				drpdwnList = new Select(driver.findElement(objPSF.getLocator("drpdwn_CSA_Foreign_Currency")));
				// util.waitForDropdownOptions(driver, drpdwnList);
				util.getRandomValueFromDropdown(driver, drpdwnList);

				poluwElement = driver.findElement(objPSF.getLocator("txt_CSA_High_Amount_INR"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				poluwElement.sendKeys(inputMap.get("Total_Sales_Turnover"));

				poluwElement = driver.findElement(objPSF.getLocator("txt_CSA_Average_NO_Days"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				poluwElement.sendKeys(inputMap.get("CreditInformation"));

				poluwElement = driver.findElement(objPSF.getLocator("chckbx_CSA_Stock_Holding_Agent_Effect"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				poluwElement.click();

				poluwElement = driver.findElement(objPSF.getLocator("txt_CSA_Max_Credit_Extended"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				poluwElement.sendKeys(inputMap.get("Total_Value_Bad_Debts"));

				poluwElement = driver.findElement(objPSF.getLocator("txt_CSA_Coversion_Foreign_Currency"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				poluwElement.sendKeys(inputMap.get("Total_Value_Bad_Debts"));

				poluwElement = driver.findElement(objPSF.getLocator("txt_CSA_Max_Credit_Extended_To_Ultimate"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				poluwElement.sendKeys(inputMap.get("Total_Value_Bad_Debts"));

				poluwElement = driver.findElement(objPSF.getLocator("txt_CSA_Average_Credit_Extended_FC"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				poluwElement.sendKeys(inputMap.get("Total_Value_Bad_Debts"));

				poluwElement = driver.findElement(objPSF.getLocator("txt_CSA_Average_Extended_To_Utimate_INR"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				poluwElement.sendKeys(inputMap.get("Total_Value_Bad_Debts"));

				poluwElement = driver.findElement(objPSF.getLocator("txt_CSA_Average_Period_of_Credit"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				poluwElement.sendKeys(inputMap.get("CreditInformation"));

				poluwElement = driver.findElement(objPSF.getLocator("radiobtn_CSA_Political_Risk_From"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				poluwElement.click();

				poluwElement = driver.findElement(objPSF.getLocator("btn_CSA_save"));
				util.waitForElementToBeClickable(driver, poluwElement);
				poluwElement.click();

				Thread.sleep(3000);

				poluwElement = driver.findElement(objPSF.getLocator("btn_CSA_submit"));
				util.waitForElementToBeClickable(driver, poluwElement);
				poluwElement.click();
				driver.switchTo().alert().accept();

				Thread.sleep(3000);

				poluwElement = driver.findElement(objPSF.getLocator("txt_application_number"));
//				poluwElement.getText();
				System.out.println("The Application Number :" + poluwElement.getText());

				poluwElement = driver.findElement(objPSF.getLocator("txt_proposal_number"));
//				poluwElement.getText();
				System.out.println("The Proposal Number :" + poluwElement.getText());

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		public void fillCGEOtherProposalDetails(WebDriver driver) {
			try {

				Thread.sleep(2000);
				inputMap = objDataSource.readData("PolicyProposal");
				JavascriptExecutor m = (JavascriptExecutor) driver;
				m.executeScript("window.scrollBy(0,-500)");

				poluwElement = driver.findElement(objPSF.getLocator("btn_CGE_Tab"));
				util.waitForElementToBeClickable(driver, poluwElement);
				poluwElement.click();

				poluwElement = driver.findElement(objPSF.getLocator("btn_CGE_Tab"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				if (poluwElement.getText().contains("Other Proposal Details (CGE)"))
					System.out.println("Active: CGE Proposal Details tab");
				else
					System.out.println("Not Active: CGE Proposal Details tab");

				drpdwnList = new Select(driver.findElement(objPSF.getLocator("drpdwn_CGE_FinanceRelationship")));
				util.getRandomValueFromDropdown(driver, drpdwnList);

				poluwElement = driver.findElement(objPSF.getLocator("txt_CGE_FinanceStakeInGlobalEntity"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				poluwElement.sendKeys(inputMap.get("CreditInformation"));

				poluwElement = driver.findElement(objPSF.getLocator("txt_CGE_ContractNumber"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				poluwElement.sendKeys("98765432111");

				poluwElement = driver.findElement(objPSF.getLocator("txt_CGE_Contract_Date"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				util.setCurrentDate(poluwElement);

				poluwElement = driver.findElement(objPSF.getLocator("txt_CGE_Contract_Expire"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				util.selectRandomFutureDate(poluwElement);

				drpdwnList = new Select(driver.findElement(objPSF.getLocator("drpdwn_CGE_Commodity")));
				util.getRandomValueFromDropdown(driver, drpdwnList);

				poluwElement = driver.findElement(objPSF.getLocator("txt_CGE_Amount_Foreign_Currency"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				poluwElement.sendKeys(inputMap.get("Total_Export_Turnover"));

				drpdwnList = new Select(driver.findElement(objPSF.getLocator("drpdwn_CGE_Foreign_Currency")));
				// util.waitForDropdownOptions(driver, drpdwnList);
				util.getRandomValueFromDropdown(driver, drpdwnList);

				poluwElement = driver.findElement(objPSF.getLocator("txt_CGE_High_Amount_INR"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				poluwElement.sendKeys(inputMap.get("Total_Sales_Turnover"));

				poluwElement = driver.findElement(objPSF.getLocator("txt_CGE_Average_NO_Days"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				poluwElement.sendKeys(inputMap.get("CreditInformation"));

				poluwElement = driver.findElement(objPSF.getLocator("chckbx_CGE_Stock_Holding_Agent_Effect"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				poluwElement.click();

				poluwElement = driver.findElement(objPSF.getLocator("txt_CGE_Max_Credit_Extended"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				poluwElement.sendKeys(inputMap.get("Total_Value_Bad_Debts"));

				poluwElement = driver.findElement(objPSF.getLocator("txt_CGE_Coversion_Foreign_Currency"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				poluwElement.sendKeys(inputMap.get("Total_Value_Bad_Debts"));

				poluwElement = driver.findElement(objPSF.getLocator("txt_CGE_Max_Credit_Extended_To_Ultimate"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				poluwElement.sendKeys(inputMap.get("Total_Value_Bad_Debts"));

				poluwElement = driver.findElement(objPSF.getLocator("txt_CGE_Average_Credit_Extended_FC"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				poluwElement.sendKeys(inputMap.get("Total_Value_Bad_Debts"));

				poluwElement = driver.findElement(objPSF.getLocator("txt_CGE_Average_Extended_To_Utimate_INR"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				poluwElement.sendKeys(inputMap.get("Total_Value_Bad_Debts"));

				poluwElement = driver.findElement(objPSF.getLocator("txt_CGE_Average_Period_of_Credit"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				poluwElement.sendKeys(inputMap.get("CreditInformation"));

				poluwElement = driver.findElement(objPSF.getLocator("radiobtn_CGE_Political_Risk_From"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				poluwElement.click();

				poluwElement = driver.findElement(objPSF.getLocator("btn_CGE_save"));
				util.waitForElementToBeClickable(driver, poluwElement);
				poluwElement.click();
				driver.switchTo().alert().accept();

				Thread.sleep(3000);

				poluwElement = driver.findElement(objPSF.getLocator("btn_CGE_submit"));
				util.waitForElementToBeClickable(driver, poluwElement);
				poluwElement.click();
				driver.switchTo().alert().accept();

				Thread.sleep(3000);

				poluwElement = driver.findElement(objPSF.getLocator("txt_application_number"));
//				poluwElement.getText();
				System.out.println("The Application Number :" + poluwElement.getText());

				poluwElement = driver.findElement(objPSF.getLocator("txt_proposal_number"));
//				poluwElement.getText();
				System.out.println("The Proposal Number :" + poluwElement.getText());

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		// Other Proposal Details for SBE product.
		public boolean fillSBEPolicyDetails(WebDriver driver) {
			try {

				Thread.sleep(2000);
				inputMap = objDataSource.readData("PolicyProposal");
				JavascriptExecutor m = (JavascriptExecutor) driver;
				m.executeScript("window.scrollBy(0,-500)");

				poluwElement = driver.findElement(objPSF.getLocator("link_sbe_other_proposal_details"));
				util.waitForElementToBeClickable(driver, poluwElement);
				poluwElement.click();

				poluwElement = driver.findElement(objPSF.getLocator("check_gov_buyer"));
				util.waitForElementToBeClickable(driver, poluwElement);
				poluwElement.click();

//				poluwElement = driver.findElement(objPSF.getLocator("txt_sbe_govbuyerdetails"));
//				util.waitForVisibilityOfElement(driver, poluwElement);
//				poluwElement.sendKeys(inputMap.get("Bank_name"));

				poluwElement = driver.findElement(objPSF.getLocator("check_sbe_buyerassociated"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				poluwElement.click();

				JavascriptExecutor m1 = (JavascriptExecutor) driver;
				m1.executeScript("window.scrollBy(0,-500)");

				statusList = new Select(driver.findElement(objPSF.getLocator("drpdwn_sbe_des_Of_Goods")));
				util.getRandomValueFromDropdown(driver, statusList);

				statusList = new Select(driver.findElement(objPSF.getLocator("drpdwn_sbe_countryfromwhere")));
				util.getRandomValueFromDropdown(driver, statusList);

				statusList = new Select(driver.findElement(objPSF.getLocator("drpdwn_sbe_countryofdestination")));
				util.getRandomValueFromDropdown(driver, statusList);

				poluwElement = driver.findElement(objPSF.getLocator("txt_sbe_required_loss_limit"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				poluwElement.clear();
				poluwElement.sendKeys(inputMap.get("Total_Value_Bad_Debts"));

				poluwElement = driver.findElement(objPSF.getLocator("txt_sbe_requiredpercentage"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				poluwElement.sendKeys("8");

				poluwElement = driver.findElement(objPSF.getLocator("btn_sbe_save"));
				util.waitForElementToBeClickable(driver, poluwElement);
				poluwElement.click();
				driver.switchTo().alert().accept();
				Thread.sleep(5000);

				poluwElement = driver.findElement(objPSF.getLocator("link_sbe_other_proposal_details"));
				util.waitForElementToBeClickable(driver, poluwElement);
				poluwElement.click();

				poluwElement = driver.findElement(objPSF.getLocator("btn_sbe_final_submit"));
				util.waitForElementToBeClickable(driver, poluwElement);
				poluwElement.click();
				Thread.sleep(1000);
				driver.switchTo().alert().accept();

				Thread.sleep(5000);

				poluwElement = driver.findElement(objPSF.getLocator("txt_application_number"));
//					poluwElement.getText();
				System.out.println("The Application Number :" + poluwElement.getText());

				poluwElement = driver.findElement(objPSF.getLocator("txt_proposal_number"));
//					poluwElement.getText();
				System.out.println("The Proposal Number :" + poluwElement.getText());

			} catch (Exception e) {
				e.printStackTrace();
			}
			return status;

		}

		// Customer details tab for SITES policy proposal.
		public void fillCustomerDetails(WebDriver driver) {
			try {

				Thread.sleep(2000);
				inputMap = objDataSource.readData("PolicyProposal");

				poluwElement = driver.findElement(objPSF.getLocator("link_customerDetails"));
				util.waitForElementToBeClickable(driver, poluwElement);
				poluwElement.click();

				poluwElement = driver.findElement(objPSF.getLocator("txt_CustomerDetails_Name"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				poluwElement.sendKeys(inputMap.get("BuyerNameOfInsuranceDetails"));

				poluwElement = driver.findElement(objPSF.getLocator("txt_CustomerDetails_AddressLine"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				util.enterAddressLine1(poluwElement);

				poluwElement = driver.findElement(objPSF.getLocator("txt_CustomerDetails_CustomerStreet"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				util.enterAddressLine2(poluwElement);

				poluwElement = driver.findElement(objPSF.getLocator("txt_CustomerDetails_CustomerCity"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				poluwElement.sendKeys(inputMap.get("Bank_Branch_Address"));

				poluwElement = driver.findElement(objPSF.getLocator("txt_CustomerDetails_CustomerState"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				poluwElement.sendKeys(inputMap.get("StateInfo"));

				drpdwnList = new Select(
						driver.findElement(objPSF.getLocator("drpdwn_CustomerDetails_CustomerCountry")));
				util.getRandomValueFromDropdown(driver, drpdwnList);

				poluwElement = driver.findElement(objPSF.getLocator("txt_CustomerDetails_CustomerPhoneNo"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				poluwElement.sendKeys("02347112233");

				poluwElement = driver.findElement(objPSF.getLocator("txt_CustomerDetails_CustomerEmail"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				util.enterRandomMailID(poluwElement);

				poluwElement = driver.findElement(objPSF.getLocator("txt_CustomerDetails_CustomerFaxNo"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				poluwElement.sendKeys("123451234567");

				poluwElement = driver.findElement(objPSF.getLocator("radiobtn_CustomerDetails_AssociateOfYours"));
				util.waitForElementToBeClickable(driver, poluwElement);
				poluwElement.click();

				poluwElement = driver.findElement(objPSF.getLocator("txt_CustomerDetails_StakeInAssociate"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				poluwElement.clear();
				poluwElement.sendKeys("90");

//				poluwElement = driver.findElement(objPSF.getLocator("radiobtn_CustomerDetails_Government"));
//				util.waitForElementToBeClickable(driver, poluwElement);
//				poluwElement.click();
//
//				poluwElement = driver.findElement(objPSF.getLocator("txt_CustomerDetails_GovernmentDeptDetails"));
////				util.waitForVisibilityOfElement(driver, poluwElement);
//				poluwElement.sendKeys(inputMap.get("NonPayment"));

				poluwElement = driver.findElement(objPSF.getLocator("btn_CustomerDetails_Save"));
				util.waitForElementToBeClickable(driver, poluwElement);
				poluwElement.click();
				Thread.sleep(2000);
				driver.switchTo().alert().accept();


			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		public void fillExperienceWithCustomer(WebDriver driver) {
			try {

				Thread.sleep(2000);
				inputMap = objDataSource.readData("PolicyProposal");

				poluwElement = driver.findElement(objPSF.getLocator("btn_ExperienceWithCustomer_SITES"));
				util.waitForElementToBeClickable(driver, poluwElement);
				poluwElement.click();

				drpdwnList = new Select(driver.findElement(objPSF.getLocator("drpdwn_ExperienceWithCustomer_Month")));
				util.getRandomValueFromDropdown(driver, drpdwnList);

				poluwElement = driver.findElement(objPSF.getLocator("txt_ExperienceWithCustomer_ValueOfInvoices"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				poluwElement.sendKeys(inputMap.get("Total_Sales_Turnover"));

				drpdwnList = new Select(
						driver.findElement(objPSF.getLocator("drpdwn_ExperienceWithCustomer_TermOfPayment")));
				util.getRandomValueFromDropdown(driver, drpdwnList);

				poluwElement = driver.findElement(objPSF.getLocator("txt_ExperienceWithCustomer_DuedateOfRealization"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				util.setCurrentDate(poluwElement);

				poluwElement = driver.findElement(objPSF.getLocator("txt_ExperienceWithCustomer_ReasonForDelay"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				poluwElement.sendKeys(inputMap.get("NonPayment"));

				poluwElement = driver.findElement(objPSF.getLocator("btn_ExperienceWithCustomer_AddNew"));
				util.waitForElementToBeClickable(driver, poluwElement);
				poluwElement.click();
				driver.switchTo().alert().accept();

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		// Nature of Contract tab for SITES policy proposal
		public void fillNatureOfContract(WebDriver driver) {

			try {

				Thread.sleep(2000);
				inputMap = objDataSource.readData("PolicyProposal");
				poluwElement = driver.findElement(objPSF.getLocator("link_natureOfContract_Sites"));
				util.waitForElementToBeClickable(driver, poluwElement);
				poluwElement.click();

				drpdwnList = new Select(driver.findElement(objPSF.getLocator("drp_Nature_Assessment_Method_Sites")));
				util.getRandomValueFromDropdown(driver, drpdwnList);
				
				drpdwnList = new Select(driver.findElement(objPSF.getLocator("drp_Nature_SystemOfBilling")));
				util.getRandomValueFromDropdown(driver, drpdwnList);

				drpdwnList = new Select(driver.findElement(objPSF.getLocator("drp_Nature_SystemOfSendingBill")));
				util.getRandomValueFromDropdown(driver, drpdwnList);
			
				drpdwnList = new Select(driver.findElement(objPSF.getLocator("drp_Nature_PaymentStructure")));
				util.getRandomValueFromDropdown(driver, drpdwnList);

				poluwElement = driver.findElement(objPSF.getLocator("btn_Nature_Save"));
				util.waitForElementToBeClickable(driver, poluwElement);
				poluwElement.click();

				driver.switchTo().alert().accept();
				Thread.sleep(5000);

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		public boolean fillSITESPolicyDetails(WebDriver driver) {
			try {
				Thread.sleep(2000);
				poluwElement = driver.findElement(objPSF.getLocator("link_Other_Proposal_Details_SITES"));
				util.waitForElementToBeClickable(driver, poluwElement);
				poluwElement.click();

				poluwElement = driver.findElement(objPSF.getLocator("radiobtn_SITES_Customer_Risks"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				poluwElement.click();

				poluwElement = driver.findElement(objPSF.getLocator("txt_Exposure_Hightest_point"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				poluwElement.clear();
				poluwElement.sendKeys("90");

				poluwElement = driver.findElement(objPSF.getLocator("btn_SITES_Save_Other"));
				util.waitForElementToBeClickable(driver, poluwElement);
				poluwElement.click();
				poluwElement.click();
				driver.switchTo().alert().accept();

				Thread.sleep(5000);

				JavascriptExecutor m = (JavascriptExecutor) driver;
				m.executeScript("window.scrollBy(0,-800)");

				poluwElement = driver.findElement(objPSF.getLocator("btn_SITES_Submit_other"));
				util.waitForElementToBeClickable(driver, poluwElement);
				poluwElement.click();
				driver.switchTo().alert().accept();

				Thread.sleep(6000);

				poluwElement = driver.findElement(objPSF.getLocator("txt_application_number"));
//				poluwElement.getText();
				System.out.println("The Application Number :" + poluwElement.getText());

				poluwElement = driver.findElement(objPSF.getLocator("txt_proposal_number"));
//				poluwElement.getText();
				System.out.println("The Proposal Number :" + poluwElement.getText());

			} catch (Exception e) {
				e.printStackTrace();
			}
			return status;

		}

		public void fillSPPPolicyDetails(WebDriver driver) {
			try {

				Thread.sleep(2000);
				poluwElement = driver.findElement(objPSF.getLocator("link_Other_Proposal_Details_SPP"));
				util.waitForElementToBeClickable(driver, poluwElement);
				poluwElement.click();

				poluwElement = driver.findElement(objPSF.getLocator("radiobtn_SPP_Customer_Risks"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				poluwElement.click();

				poluwElement = driver.findElement(objPSF.getLocator("txt_Exposure_Hightest_point_SPP"));
				util.waitForVisibilityOfElement(driver, poluwElement);
				poluwElement.clear();
				poluwElement.sendKeys("90");

				poluwElement = driver.findElement(objPSF.getLocator("btn_SPP_Save_Other"));
				util.waitForElementToBeClickable(driver, poluwElement);
				poluwElement.click();
				driver.switchTo().alert().accept();

				Thread.sleep(5000);

				JavascriptExecutor m = (JavascriptExecutor) driver;
				m.executeScript("window.scrollBy(0,-800)");

				poluwElement = driver.findElement(objPSF.getLocator("btn_SPP_Submit_other"));
				util.waitForElementToBeClickable(driver, poluwElement);
				poluwElement.click();
				driver.switchTo().alert().accept();

				Thread.sleep(6000);

				poluwElement = driver.findElement(objPSF.getLocator("txt_application_number"));
//				poluwElement.getText();
				System.out.println("The Application Number :" + poluwElement.getText());

				poluwElement = driver.findElement(objPSF.getLocator("txt_proposal_number"));
//				poluwElement.getText();
				System.out.println("The Proposal Number :" + poluwElement.getText());

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
}
