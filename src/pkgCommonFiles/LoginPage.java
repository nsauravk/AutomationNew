package pkgCommonFiles;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import pkgSetupFiles.PropertiesSetupFile;

public class LoginPage {
	
	PropertiesSetupFile objPSF = new PropertiesSetupFile("LoginPage");
	WebElement ppdElement;
	
	public void loginToModule(WebDriver driver, String userId, String password) throws Exception
	{
		
		try {
			System.out.println("Landed:Login page");
		
			ppdElement = driver.findElement(objPSF.getLocator("txt_Username"));
			ppdElement.sendKeys(userId);
		
			ppdElement = driver.findElement(objPSF.getLocator("txt_Password"));
			ppdElement.sendKeys(password);
		
			ppdElement = driver.findElement(objPSF.getLocator("btn_Login"));
			ppdElement.click();
			
			System.out.println("Loading:User " + userId + " Logging in");
		} catch(Exception e) {
			e.printStackTrace();
		}
		 	
	}
	
}
