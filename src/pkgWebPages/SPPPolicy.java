package pkgWebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import pkgSetupFiles.PropertiesSetupFile;
import pkgUtilities.HelperClass;

public class SPPPolicy {
	
	PropertiesSetupFile objPSF = new PropertiesSetupFile("SPPPolicy");
	HelperClass util = new HelperClass();
	PolicyProposalForm objPPF = new PolicyProposalForm();
	ExposureBasedIndividual objEBI = new ExposureBasedIndividual();
	WebElement poluwElement;
	Select drpdwnList;
	String actualMsg = "All good";

	public String addNewSPPPolicyProposal(WebDriver driver) {
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
			
			objEBI.searchInwardDetails(driver);
			objEBI.searchExporterDetails(driver);
			objEBI.selectProduct(driver, "SPP");
//			poluwElement = driver.findElement(objPSF.getLocator("proposal_date"));
//			util.waitForElementToBeClickable(driver, poluwElement);
//			poluwElement.clear();
//			poluwElement.sendKeys("20/10/2022");
//
//			drpdwnList = new Select(driver.findElement(objPSF.getLocator("drpdwn_polType")));
//			util.waitForDropdownOptions(driver, drpdwnList);
//			drpdwnList.selectByValue("SCR");

//			drpdwnList = new Select(driver.findElement(objPSF.getLocator("drpdwn_typeOfCover")));
//			drpdwnList.selectByValue("Comprehensive");
//			util.getRandomValueFromDropdown(driver, drpdwnList);
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

			Thread.sleep(7000);

			objEBI.fillHeaderDetails(driver);
			objEBI.fillExporterBankDetails(driver);
			objEBI.fillTurnoverBadDets(driver);
			objEBI.fillDetailsOfLimitAvailedFromAllBanks(driver);
			objEBI.fillCreditInsuranceDetails(driver);
			objEBI.fillCreditManagementRiskAppraisal(driver);
			objEBI.fillCustomerDetails(driver);
			objEBI.fillExperienceWithCustomer(driver);
			objEBI.fillAnticipatedTurnoverForTheNextOneYearOnTheBuyer(driver);
			objEBI.fillOrdersOnHand(driver);
			objEBI.fillNatureOfContract(driver);
			objEBI.fillUploadDocuments(driver);
			// objEBI.fillSPPPolicyDetails(driver);


						
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return actualMsg;
	}

}
