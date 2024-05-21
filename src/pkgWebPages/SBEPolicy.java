package pkgWebPages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import pkgSetupFiles.PropertiesSetupFile;
import pkgUtilities.HelperClass;

public class SBEPolicy {

	String actualMsg, getWholeMsg;
	boolean status = false;
	WebElement poluwElement;
	PropertiesSetupFile objPSF = new PropertiesSetupFile("SBEPolicy");
	HelperClass util = new HelperClass();
	PolicyProposalForm objPPF = new PolicyProposalForm();
	ExposureBasedIndividual objEBI = new ExposureBasedIndividual();

	List<WebElement> poluwElements;
	Select statusList;
	
	public String addPolUW_SBEPolicy(WebDriver driver) throws Exception {
		try {
			Thread.sleep(1000);
			poluwElement = driver.findElement(objPSF.getLocator("submenu_fresh"));
			util.waitForElementToBeClickable(driver, poluwElement);
//			Thread.sleep(2000);
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
			objEBI.selectProduct(driver, "SBE");

//			poluwElement = driver.findElement(objPSF.getLocator("txt_submitMsg"));
//			getWholeMsg = poluwElement.getText();
//			System.out.println(getWholeMsg);

//			This is for getting the last integer in the string
//			String lastWord = getWholeMsg.substring(getWholeMsg.lastIndexOf(" ")+1);
//			System.out.println(lastWord);

//			int skipLastWord = getWholeMsg.lastIndexOf(" ");
//			getWholeMsg = getWholeMsg.substring(0, skipLastWord);
//			System.out.println(getWholeMsg);
			
			Thread.sleep(7000);

			objEBI.fillHeaderDetails(driver);
			objEBI.fillExporterBankDetails(driver);
			objEBI.fillTurnoverBadDets(driver);
			objEBI.fillDetailsOfLimitAvailedFromAllBanks(driver);
			objEBI.fillCreditInsuranceDetails(driver);
			objEBI.fillCreditManagementRiskAppraisal(driver);
			objEBI.fillBuyerDetails(driver);
			objEBI.fillBankDetails(driver);
			objEBI.fillLCBankDetails(driver);
			objEBI.fillDetailsOfAllShipmentsMadeToTheBuyerLCOpeningBank(driver);
			objEBI.fillOrdersOnHand(driver);
			objEBI.fillAnticipatedTurnoverForTheNextOneYearOnTheBuyer(driver);
			objEBI.fillShippingSchedule(driver);
			objEBI.fillUploadDocuments(driver);
//			objEBI.fillSBEPolicyDetails(driver);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return getWholeMsg;
	}
	

}
