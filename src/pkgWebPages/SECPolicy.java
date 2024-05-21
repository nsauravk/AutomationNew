package pkgWebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import pkgSetupFiles.PropertiesSetupFile;
import pkgUtilities.HelperClass;

public class SECPolicy {
	
	PropertiesSetupFile objPSF = new PropertiesSetupFile("SECPolicy");
	HelperClass util = new HelperClass();
	PolicyProposalForm objPPF = new PolicyProposalForm();
	DeclarationBasedWholeTurnover objDBWT = new DeclarationBasedWholeTurnover();
	
	WebElement poluwElement;
	Select drpdwnList;
	
	String actualMsg = "All good";

	public String addNewSECPolicyProposal(WebDriver driver) {
		try {
			poluwElement = driver.findElement(objPSF.getLocator("submenu_fresh"));
			util.waitForElementToBeClickable(driver, poluwElement);
			poluwElement.click();
			
			poluwElement = driver.findElement(objPSF.getLocator("link_add"));
			util.waitForElementToBeClickable(driver, poluwElement);
			poluwElement.click();
			
			poluwElement = driver.findElement(objPSF.getLocator("txt_tileAddProposal"));
			if(util.isElementPresent(poluwElement))
				System.out.println("Landed: Policy Issue - Add New Proposal Entry");
			else {
				actualMsg = "Failed to Land: Policy Issue - Add New Proposal Entry";
				System.out.println(actualMsg);
				return actualMsg;
			}
			
			objDBWT.searchInwardDetails(driver);
			objDBWT.searchExporterDetails(driver);
//			objDBWT.selectProduct(driver,"SEC");

			poluwElement = driver.findElement(objPSF.getLocator("proposal_date"));
			util.waitForElementToBeClickable(driver, poluwElement);
			poluwElement.clear();
			poluwElement.sendKeys("2022-10-20");

			drpdwnList = new Select(driver.findElement(objPSF.getLocator("drpdwn_polType")));
			util.waitForDropdownOptions(driver, drpdwnList);
			drpdwnList.selectByValue("SEC");

			drpdwnList = new Select(driver.findElement(objPSF.getLocator("drpdwn_typeOfCover")));
//			drpdwnList.selectByValue("Comprehensive");
			util.getRandomValueFromDropdown(driver, drpdwnList);
//			util.waitForDropdownOptions(driver, drpdwnList);
//			drpdwnList.selectByValue(typeOfCover);

			drpdwnList = new Select(driver.findElement(objPSF.getLocator("drpdwn_fieldOfficerCode")));
			util.getRandomValueFromDropdown(driver, drpdwnList);
//			util.waitForDropdownOptions(driver, drpdwnList);
//			drpdwnList.selectByIndex(1);

	
			drpdwnList = new Select(driver.findElement(objPSF.getLocator("drpdwn_brokerName")));
			util.getRandomValueFromDropdown(driver, drpdwnList);
//			util.waitForDropdownOptions(driver, drpdwnList);
//			drpdwnList.selectByIndex(1);
			
			poluwElement = driver.findElement(objPSF.getLocator("btn_submitProposal"));
			util.waitForElementToBeClickable(driver, poluwElement);
			poluwElement.click();
			driver.switchTo().alert().accept();

			Thread.sleep(7000);
			objDBWT.fillHeaderDetails(driver);
			objDBWT.fillExporterBankDetails(driver);
			objDBWT.fillTurnoverBadDets(driver);
			objDBWT.fillDetailsOfLimitAvailedFromAllBanks(driver);
			objDBWT.fillCreditInsuranceDetails(driver);
			objDBWT.fillCreditManagementRiskAppraisal(driver);
			objDBWT.fillExportTurnoverInLast12CalendarMonths(driver);
			objDBWT.fillDebtorsDistribution(driver);
			objDBWT.fillAgeDebtorAnalysis(driver);
			objDBWT.fillOverdueDetailsAsOnDate(driver);
			objDBWT.fillprojectedTurnoverNext12Month_SEC(driver);
			objDBWT.fillprojectedExportTurnoverNext12CalendarMonth(driver);
			objDBWT.fillMerchantingTrade(driver);
			objDBWT.fillUploadDocuments(driver);
			// objDBWT.fillSECPolicyDetails(driver);
						
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return actualMsg;
	}
}
