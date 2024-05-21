package pkgCommonFiles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//import com.sun.tools.sjavac.Log;

import pkgSetupFiles.PropertiesSetupFile;
import pkgUtilities.HelperClass;

public class PolUW_LandingPage {

	PropertiesSetupFile objPSF = new PropertiesSetupFile("PolUW_LandingPage");
	HelperClass util = new HelperClass();
	WebElement poluwElement;
	

	public void selectOptions(WebDriver driver, String option) throws Exception

	{
		try {
			option = "link_"+option;
			System.out.println("Landed:Dashboard page");
			 	
			poluwElement = driver.findElement(objPSF.getLocator("menu_policyIssue"));
			util.waitForElementToBeClickable(driver, poluwElement);
			poluwElement.click();
			
			poluwElement = driver.findElement(objPSF.getLocator("menu_policyEndorsement"));
			util.waitForElementToBeClickable(driver, poluwElement);
			poluwElement.click();

//			poluwElement = driver.findElement(objPSF.getLocator(option));
//			util.waitForElementToBeClickable(driver, poluwElement);
//			poluwElement.click();
			
		}catch(Exception e) {
			e.printStackTrace();
		}	 	
	}
}
