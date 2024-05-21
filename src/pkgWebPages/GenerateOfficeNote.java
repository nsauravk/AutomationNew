package pkgWebPages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import pkgSetupFiles.PropertiesSetupFile;
import pkgUtilities.HelperClass;


public class GenerateOfficeNote {
	String actualMsg, getWholeMsg;
	boolean status = false;
	WebElement poluwElement;
	PropertiesSetupFile objPSF = new PropertiesSetupFile("GenerateOfficeNote");
	HelperClass util = new HelperClass();
	PolicyProposalForm objPPF = new PolicyProposalForm();
	Select drpdwnList;
	List<WebElement> poluwElements;
	Select statusList;
	

	public String addGenerateOfficeNote(WebDriver driver) throws Exception {
		try {

			poluwElement = driver.findElement(objPSF.getLocator("submenu_generate_office_note"));
//			util.waitForElementToBeClickable(driver, poluwElement);
			Thread.sleep(2000);
			poluwElement.click();

			Thread.sleep(1000);

			drpdwnList = new Select(driver.findElement(objPSF.getLocator("drpdwn_policy_type")));
			util.waitForDropdownOptions(driver, drpdwnList);
			drpdwnList.selectByVisibleText("SCR: Shipment Comprehensive Risk");

			poluwElement = driver.findElement(objPSF.getLocator("btn_search_proposal_details"));
			util.waitForElementToBeClickable(driver, poluwElement);
			poluwElement.click();


			Thread.sleep(2000);
			List<WebElement> listOfElementsElementes = driver
					.findElements(objPSF.getLocator("radio_btn_view_proposal_list"));
			for (int i = 0; i <= listOfElementsElementes.size(); i++)
					{
						listOfElementsElementes.get(i).click();
						driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
						System.out.println(i);

					
					
//			poluwElement = driver.findElement(objPSF.getLocator("radio_btn_view_proposal_list"));
//			util.waitForElementToBeClickable(driver, poluwElement);
//			poluwElement.click();

			poluwElement = driver.findElement(objPSF.getLocator("txt_application_number"));
			System.out.println("The Application Number :" + poluwElement.getText());

			JavascriptExecutor a1 = (JavascriptExecutor) driver;
			a1.executeScript("window.scrollBy(0,500)");
			

	
			Thread.sleep(2000);
			poluwElement = driver.findElement(objPSF.getLocator("btn_generate_office_note"));
			util.waitForElementToBeClickable(driver, poluwElement);
			poluwElement.click();

		}


		} catch (Exception e) {
			e.printStackTrace();
		}
		return getWholeMsg;
	}
}
