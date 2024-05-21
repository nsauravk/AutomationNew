package pkgCommonFiles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pkgSetupFiles.PropertiesSetupFile;
import pkgUtilities.HelperClass;

public class LogoutFunc {
	PropertiesSetupFile objPSF=new PropertiesSetupFile("LogoutFunc");
	HelperClass utility = new HelperClass();
	WebElement ppdElement;
	
	public void logoutFromModule(WebDriver driver) throws Exception
	{
		System.out.println("Logout page\n");
	 	
	 	ppdElement = driver.findElement(objPSF.getLocator("btn_Username"));
	 	utility.waitForElementToBeClickable(driver, ppdElement);
	 	ppdElement.click();
	 	
	 	ppdElement = driver.findElement(objPSF.getLocator("opt_Logout"));
	 	utility.waitForElementToBeClickable(driver, ppdElement);
	 	ppdElement.click();
	 		 	
	 	ppdElement = driver.findElement(objPSF.getLocator("btn_Logout"));
	 	utility.waitForElementToBeClickable(driver, ppdElement);
	 	ppdElement.click();
	 		 	
	 	
	}
	
}
