package pkgWebPages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import pkgSetupFiles.PropertiesSetupFile;
import pkgUtilities.HelperClass;


public class Scrutiny {
	String actualMsg, getWholeMsg;
	boolean status = false;
	WebElement poluwElement;
	PropertiesSetupFile objPSF = new PropertiesSetupFile("Scrutiny");
	HelperClass util = new HelperClass();
	PolicyProposalForm objPPF = new PolicyProposalForm();
	Select drpdwnList;
	List<WebElement> poluwElements;
	Select statusList;
	

	public String addScrutiny(WebDriver driver) throws Exception {
		try {

			poluwElement = driver.findElement(objPSF.getLocator("submenu_scrutiny"));
//			util.waitForElementToBeClickable(driver, poluwElement);
			Thread.sleep(2000);
			poluwElement.click();

			poluwElement = driver.findElement(objPSF.getLocator("Search_Scrutiny_Proposal_List"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.sendKeys("MBE");

			Thread.sleep(2000);

			poluwElement = driver.findElement(objPSF.getLocator("radiobtn_scrutiny_proposal_list"));
			util.waitForElementToBeClickable(driver, poluwElement);
			poluwElement.click();

			poluwElement = driver.findElement(objPSF.getLocator("btn_scrutiny"));
			util.waitForElementToBeClickable(driver, poluwElement);
			poluwElement.click();

			Thread.sleep(30000);

			poluwElement = driver.findElement(objPSF.getLocator("btn_proposal_scrutiny"));
			util.waitForElementToBeClickable(driver, poluwElement);
			poluwElement.click();
			
			JavascriptExecutor a = (JavascriptExecutor) driver;
			a.executeScript("window.scrollBy(0,-1500)");

//			poluwElement = driver.findElement(objPSF.getLocator("btn_modify_discount"));
//			util.waitForElementToBeClickable(driver, poluwElement);
//			poluwElement.click();
//
//			poluwElement = driver.findElement(objPSF.getLocator("txt_malus_loading"));
//			util.waitForElementToBeClickable(driver, poluwElement);
//			poluwElement.clear();
//			poluwElement.sendKeys("10");
//
//			poluwElement = driver.findElement(objPSF.getLocator("txt_no_claim_bonus"));
//			util.waitForElementToBeClickable(driver, poluwElement);
//			poluwElement.clear();
//			poluwElement.sendKeys("20");
//
//			poluwElement = driver.findElement(objPSF.getLocator("txt_turnover_discount"));
//			util.waitForElementToBeClickable(driver, poluwElement);
//			poluwElement.clear();
//			poluwElement.sendKeys("20");
//
//			poluwElement = driver.findElement(objPSF.getLocator("txt_volume_discount"));
//			util.waitForElementToBeClickable(driver, poluwElement);
//			poluwElement.clear();
//			poluwElement.sendKeys("10");
//
//			poluwElement = driver.findElement(objPSF.getLocator("btn_save_modify_discount"));
//			util.waitForElementToBeClickable(driver, poluwElement);
//			poluwElement.click();

			Thread.sleep(2000);
			
			poluwElement = driver.findElement(objPSF.getLocator("txt_total_premium_Earned"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.clear();
			poluwElement.sendKeys("0");

			poluwElement = driver.findElement(objPSF.getLocator("txt_total_claim_paid"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.clear();
			poluwElement.sendKeys("0");

			drpdwnList = new Select(driver.findElement(objPSF.getLocator("drpdwn_mode_of_payment")));
			util.getRandomValueFromDropdown(driver, drpdwnList);

			poluwElement = driver.findElement(objPSF.getLocator("btn_save_proposal_scrutiny"));
			util.waitForElementToBeClickable(driver, poluwElement);
			poluwElement.click();

			Thread.sleep(2000);

			poluwElement = driver.findElement(objPSF.getLocator("btn_alert_save_proposal_scrutiny"));
			util.waitForElementToBeClickable(driver, poluwElement);
			poluwElement.click();

			Thread.sleep(30000);

			JavascriptExecutor a1 = (JavascriptExecutor) driver;
			a1.executeScript("window.scrollBy(0,-500)");

			Thread.sleep(2000);

			poluwElement = driver.findElement(objPSF.getLocator("txt_scrutiny_recommendation_remark"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.clear();
			poluwElement.sendKeys("Recommended by 909");

			poluwElement = driver.findElement(objPSF.getLocator("btn_recommend"));
			util.waitForElementToBeClickable(driver, poluwElement);
			poluwElement.click();

//			poluwElement = driver.findElement(objPSF.getLocator("success_message_recommendation"));
//			actualMsg = poluwElement.getText();
//			System.out.println(actualMsg);


		} catch (Exception e) {
			e.printStackTrace();
		}
		return actualMsg;
	}
}
