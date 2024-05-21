package pkgWebPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import pkgSetupFiles.PropertiesSetupFile;
import pkgUtilities.HelperClass;

public class CGEPolicy {

	PropertiesSetupFile objPSF = new PropertiesSetupFile("CGEPolicy");
	HelperClass util = new HelperClass();
	PolicyProposalForm objPPF = new PolicyProposalForm();
	DeclarationBasedIndividual objDBI = new DeclarationBasedIndividual();
	
	WebElement poluwElement;
	Select drpdwnList;
	
	String actualMsg = "All good";

	public String addNewCGEPolicyProposal(WebDriver driver) {
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
			
			objDBI.searchInwardDetails(driver);
			objDBI.searchExporterDetails(driver);
			objDBI.selectProduct(driver, "CGE");

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
//			objDBI.fillCGEOtherProposalDetails(driver);
			
//			objDBI.fillDetailsOfLimitAvailedFromAllBanks(driver);
//			objDBI.fillCreditInsuranceDetails(driver);
//			objDBI.fillCreditManagementRiskAppraisal(driver);
//			objDBI.fillExpectedAnnualTurnoverEachCountry(driver);
			/*
			 * poluwElement = driver.findElement(objPSF.getLocator("btn_CGE_Tab"));
			 * util.waitForElementToBeClickable(driver, poluwElement); poluwElement.click();
			 * 
			 * poluwElement = driver.findElement(objPSF.getLocator("btn_CGE_Tab"));
			 * util.waitForVisibilityOfElement(driver, poluwElement);
			 * if(poluwElement.getText().contains("CGE"))
			 * System.out.println("Active: CGE tab"); else
			 * System.out.println("Not Active: CGE tab");
			 * 
			 * drpdwnList = new
			 * Select(driver.findElement(objPSF.getLocator("drpdwn_CGE_Finance_Relationship"
			 * ))); util.getRandomValueFromDropdown(driver, drpdwnList);
			 * 
			 * poluwElement =
			 * driver.findElement(objPSF.getLocator("txt_CGE_Financial_Stake_IN"));
			 * util.waitForVisibilityOfElement(driver, poluwElement);
			 * poluwElement.sendKeys("10000");
			 * 
			 * // poluwElement =
			 * driver.findElement(objPSF.getLocator("chckbx_CSA_Finacial_relationship")); //
			 * util.waitForVisibilityOfElement(driver, poluwElement); //
			 * poluwElement.click();
			 * 
			 * poluwElement =
			 * driver.findElement(objPSF.getLocator("txt_CGE_ContractNumber"));
			 * util.waitForVisibilityOfElement(driver, poluwElement);
			 * poluwElement.sendKeys("98765432111");
			 * 
			 * poluwElement =
			 * driver.findElement(objPSF.getLocator("txt_CGE_Contract_Date"));
			 * util.waitForVisibilityOfElement(driver, poluwElement);
			 * poluwElement.sendKeys("19/10/2022");
			 * 
			 * poluwElement =
			 * driver.findElement(objPSF.getLocator("txt_CGE_Contract_Expire"));
			 * util.waitForVisibilityOfElement(driver, poluwElement);
			 * poluwElement.sendKeys("19/10/2023");
			 * 
			 * drpdwnList = new
			 * Select(driver.findElement(objPSF.getLocator("drpdwn_CGE_Commodity")));
			 * util.getRandomValueFromDropdown(driver, drpdwnList);
			 * 
			 * poluwElement =
			 * driver.findElement(objPSF.getLocator("txt_CGE_Amount_Foreign_Currency"));
			 * util.waitForVisibilityOfElement(driver, poluwElement);
			 * poluwElement.sendKeys("100000");
			 * 
			 * drpdwnList = new
			 * Select(driver.findElement(objPSF.getLocator("drpdwn_CGE_Foreign_Currency")));
			 * // util.waitForDropdownOptions(driver, drpdwnList); Thread.sleep(1000);
			 * util.getRandomValueFromDropdown(driver, drpdwnList);
			 * 
			 * poluwElement =
			 * driver.findElement(objPSF.getLocator("txt_CGE_High_Amount_INR"));
			 * util.waitForVisibilityOfElement(driver, poluwElement);
			 * poluwElement.sendKeys("100000");
			 * 
			 * poluwElement =
			 * driver.findElement(objPSF.getLocator("txt_CGE_Average_NO_Days"));
			 * util.waitForVisibilityOfElement(driver, poluwElement);
			 * poluwElement.sendKeys("30");
			 * 
			 * poluwElement =
			 * driver.findElement(objPSF.getLocator("chckbx_CGE_Stock_Holding_Agent_Effect")
			 * ); util.waitForVisibilityOfElement(driver, poluwElement);
			 * poluwElement.click();
			 * 
			 * poluwElement =
			 * driver.findElement(objPSF.getLocator("txt_CGE_Max_Credit_Extended"));
			 * util.waitForVisibilityOfElement(driver, poluwElement);
			 * poluwElement.sendKeys("30000");
			 * 
			 * poluwElement =
			 * driver.findElement(objPSF.getLocator("txt_CGE_Coversion_Foreign_Currency"));
			 * util.waitForVisibilityOfElement(driver, poluwElement);
			 * poluwElement.sendKeys("90");
			 * 
			 * poluwElement = driver.findElement(objPSF.getLocator(
			 * "txt_CGE_Max_Credit_Extended_To_Ultimate"));
			 * util.waitForVisibilityOfElement(driver, poluwElement);
			 * poluwElement.sendKeys("30000");
			 * 
			 * poluwElement =
			 * driver.findElement(objPSF.getLocator("txt_CGE_Average_Credit_Extended_FC"));
			 * util.waitForVisibilityOfElement(driver, poluwElement);
			 * poluwElement.sendKeys("70000");
			 * 
			 * poluwElement = driver.findElement(objPSF.getLocator(
			 * "txt_CGE_Average_Extended_To_Utimate_INR"));
			 * util.waitForVisibilityOfElement(driver, poluwElement);
			 * poluwElement.sendKeys("900000");
			 * 
			 * poluwElement =
			 * driver.findElement(objPSF.getLocator("txt_CGE_Average_Period_of_Credit"));
			 * util.waitForVisibilityOfElement(driver, poluwElement);
			 * poluwElement.sendKeys("30");
			 * 
			 * poluwElement =
			 * driver.findElement(objPSF.getLocator("radiobtn_CGE_Political_Risk_From"));
			 * util.waitForVisibilityOfElement(driver, poluwElement); poluwElement.click();
			 * 
			 * poluwElement = driver.findElement(objPSF.getLocator("btn_CGE_save"));
			 * util.waitForElementToBeClickable(driver, poluwElement); poluwElement.click();
			 * 
			 * poluwElement = driver.findElement(objPSF.getLocator("btn_CGE_submit"));
			 * util.waitForElementToBeClickable(driver, poluwElement); poluwElement.click();
			 * driver.switchTo().alert().accept();
			 * 
			 */
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return actualMsg;
	}



	
}
