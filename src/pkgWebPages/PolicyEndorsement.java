package pkgWebPages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import pkgSetupFiles.PropertiesSetupFile;
import pkgUtilities.HelperClass;


public class PolicyEndorsement {
	String actualMsg, getWholeMsg;
	boolean status = false;
	WebElement poluwElement;
	PropertiesSetupFile objPSF = new PropertiesSetupFile("PolicyEndorsement");
	// PropertiesSetupFile objPSE = new PropertiesSetupFile("PolicyProposalForm");
	HelperClass util = new HelperClass();
	PolicyProposalForm objPPF = new PolicyProposalForm();
	Select drpdwnList;
	List<WebElement> poluwElements;
	Select statusList;
	

	public String addPolicyEndorsement(WebDriver driver) throws Exception {
		try {

			poluwElement = driver.findElement(objPSF.getLocator("submenu_endorsement_request"));
			util.waitForElementToBeClickable(driver, poluwElement);
			poluwElement.click();

			poluwElement = driver.findElement(objPSF.getLocator("btn_add_new_endorsement_request"));
			util.waitForElementToBeClickable(driver, poluwElement);
			poluwElement.click();

			objPPF.searchInwardDetails(driver);
			objPPF.searchPolicyDetailsEndorsement(driver);

			drpdwnList = new Select(driver.findElement(objPSF.getLocator("drpdwn_policy_type")));
			util.waitForDropdownOptions(driver, drpdwnList);
			drpdwnList.selectByVisibleText("ETP: Export Turnover Policy");

			poluwElement = driver.findElement(objPSF.getLocator("btn_search_policy_number_lookup"));
			util.waitForElementToBeClickable(driver, poluwElement);
			poluwElement.click();

			JavascriptExecutor d = (JavascriptExecutor) driver;
			d.executeScript("window.scrollBy(0,-1000)");

			Thread.sleep(2000);

			poluwElement = driver.findElement(objPSF.getLocator("radio_policy_number_lookup"));
			util.waitForElementToBeClickable(driver, poluwElement);
			poluwElement.click();

			Thread.sleep(2000);

			poluwElement = driver.findElement(objPSF.getLocator("check_select_endorsement"));
			util.waitForElementToBeClickable(driver, poluwElement);
			poluwElement.click();

			poluwElement = driver.findElement(objPSF.getLocator("check_select_endorsement1"));
			util.waitForElementToBeClickable(driver, poluwElement);
			poluwElement.click();

			poluwElement = driver.findElement(objPSF.getLocator("txt_endorsement_request_date"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			util.setCurrentDate(poluwElement);

			poluwElement = driver.findElement(objPSF.getLocator("txt_endorsement_request_remark"));
			util.waitForVisibilityOfElement(driver, poluwElement);
			poluwElement.sendKeys("Test");

			poluwElement = driver.findElement(objPSF.getLocator("btn_Add_Entry_Next"));
			util.waitForElementToBeClickable(driver, poluwElement);
			poluwElement.click();
			driver.switchTo().alert().accept();


		} catch (Exception e) {
			e.printStackTrace();
		}
		return actualMsg;
		}
	

}

