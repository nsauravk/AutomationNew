package pkgWebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import pkgSetupFiles.PropertiesSetupFile;
import pkgUtilities.HelperClass;

public class CSAPolicy {

	PropertiesSetupFile objPSF = new PropertiesSetupFile("CSAPolicy");
	HelperClass util = new HelperClass();
	PolicyProposalForm objPPF = new PolicyProposalForm();
	DeclarationBasedIndividual objDBI = new DeclarationBasedIndividual();

	WebElement poluwElement;
	Select drpdwnList;

	String actualMsg = "All good";

	public String addNewCSAPolicyProposal(WebDriver driver) {
		try {
			poluwElement = driver.findElement(objPSF.getLocator("submenu_fresh"));
			util.waitForElementToBeClickable(driver, poluwElement);
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
			objDBI.selectProduct(driver, "CSA");

			Thread.sleep(7000);

			objDBI.fillHeaderDetails(driver);
			objDBI.fillExporterBankDetails(driver);
			objDBI.fillTurnoverBadDets(driver);
			objDBI.fillDetailsOfLimitAvailedFromAllBanks(driver);
			objDBI.fillCreditInsuranceDetails(driver);
			objDBI.fillCreditManagementRiskAppraisal(driver);
			objDBI.fillGlobalEntityStockHolderDetails(driver);
			objDBI.fillGlobalEntityStockHolderBankDetails(driver);
			objDBI.fillShipmentMadeToBuyerOrLCOpeningBankInLast1Year(driver);
			objDBI.fillQuarterwiseExpectedSales(driver);
			objDBI.fillExpectedAnnualTurnoverEachCountry(driver);
			objDBI.fillUltimateBuyerWithCreditDetails(driver);
			objDBI.fillUltimateBuyerLossDetails(driver);
			objDBI.fillUploadDocuments(driver);
//			objDBI.fillCSAOtherProposalDetails(driver);


			


		} catch (Exception e) {
			e.printStackTrace();
		}

		return actualMsg;
	}

}
