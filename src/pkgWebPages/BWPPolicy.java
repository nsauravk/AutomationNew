package pkgWebPages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import pkgSetupFiles.PropertiesSetupFile;
import pkgUtilities.HelperClass;


public class BWPPolicy {
	String actualMsg, getWholeMsg;
	boolean status = false;
	WebElement poluwElement;
	PropertiesSetupFile objPSF = new PropertiesSetupFile("BWPPolicy");
	HelperClass util = new HelperClass();
	PolicyProposalForm objPPF = new PolicyProposalForm();
	DeclarationBasedIndividual objDBI = new DeclarationBasedIndividual();

	List<WebElement> poluwElements;
	Select statusList;

	public String addPolUW_BWPPolicy(WebDriver driver) throws Exception {
		try {

			poluwElement = driver.findElement(objPSF.getLocator("submenu_fresh"));
//			util.waitForElementToBeClickable(driver, poluwElement);
			Thread.sleep(2000);
			poluwElement.click();

			poluwElement = driver.findElement(objPSF.getLocator("link_add"));
			util.waitForElementToBeClickable(driver, poluwElement);
			poluwElement.click();

			poluwElement = driver.findElement(objPSF.getLocator("txt_tileAddProposal"));
			if (util.isElementPresent(poluwElement))
				System.out.println("Landed: Policy Issue - Add New Proposal Entry");
			else {
				actualMsg = "Failed to Land: Policy Issue - Add New Proposal Entry";
				System.out.println(actualMsg);
				return actualMsg;
			}

			objDBI.searchInwardDetails(driver);
			objDBI.searchExporterDetails(driver);
			objDBI.selectProduct(driver, "BWP");

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
			objDBI.fillHeaderDetails(driver);
			objDBI.fillExporterBankDetails(driver);
			objDBI.fillTurnoverBadDets(driver);
			objDBI.fillDetailsOfLimitAvailedFromAllBanks(driver);
			objDBI.fillCreditInsuranceDetails(driver);
			objDBI.fillCreditManagementRiskAppraisal(driver);
			objDBI.fillBuyerDetails(driver);
			objDBI.fillBankDetails(driver);
			objDBI.fillLCBankDetails(driver);
			objDBI.fillDetailsOfAllShipmentsMadeToTheBuyerLCOpeningBank(driver);
			objDBI.fillOrdersOnHand(driver);
			objDBI.fillAnticipatedTurnoverForTheNextOneYearOnTheBuyer(driver);
			objDBI.fillShippingSchedule(driver);
			objDBI.fillUploadDocuments(driver);
			// objDBI.fillBWPPolicyDetails(driver);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return getWholeMsg;
	}
}
