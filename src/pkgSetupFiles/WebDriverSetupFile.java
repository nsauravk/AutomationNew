/**  
 	 AUTHOR     : AKHILESH
 	 DESCRIPTION: This file will return the WebDriver object which will hold the browser instance to use in the project and load
 	 the base URL of the AUT.
**/

package pkgSetupFiles;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

import org.openqa.selenium.edge.EdgeDriver;

public class WebDriverSetupFile
{
//	static String driverPath;
    static WebDriver driver;

	public static WebDriver setupDriver(String osName,String browser, String driverPath, boolean headless, String url)
	{
		if(osName.contains("Windows"))	{
				
			switch(browser)
			{
				case "Firefox":
					System.setProperty("webdriver.gecko.driver",driverPath);
//					FirefoxOptions objFO=new FirefoxOptions();
//					objFO.setHeadless(headless);
//					driver=new FirefoxDriver(objFO);
					driver = new FirefoxDriver();
					break;
											
				case "Chrome":
//					driverPath="E:/Drivers/chromedriver.exe";
					System.setProperty("webdriver.chrome.driver",driverPath);
					ChromeOptions objCO = new ChromeOptions();
					objCO.setHeadless(headless);
					driver=new ChromeDriver(objCO);
					break;
					
				case "PhantomJS":
//					driverPath="E:/Drivers/phantomjs.exe";
					System.setProperty("phantomjs.binary.path",driverPath);					
					driver=new PhantomJSDriver();
					break;
					
				case "Edge":
//					driverPath="E:/Drivers/msedgedriver.exe";
					System.setProperty("webdriver.edge.driver",driverPath);
					driver=new EdgeDriver();
					break;
					
				default:
					return null;
			}
		}
		
		else 
		{
			switch(browser)
			{
				case "Firefox":
//					driverPath="/home/browserDrivers/geckodriver";
					System.setProperty("webdriver.gecko.driver",driverPath);
					FirefoxOptions objFO=new FirefoxOptions();
					objFO.setHeadless(headless);
					driver=new FirefoxDriver(objFO);
					break;
				
				case "Chrome":
//					driverPath="/home/browserDrivers/chromedriver";
					System.setProperty("webdriver.chrome.driver",driverPath);
					ChromeOptions objCO = new ChromeOptions();
					objCO.setHeadless(headless);
					driver=new ChromeDriver(objCO);
					break;
					
				case "PhantomJS":
//					driverPath="/home/browserDrivers/phantomjs";
					System.setProperty("phantomjs.binary.path",driverPath);					
					driver=new PhantomJSDriver();
					break;
					
				default:
					return null;
			}
			
		}
		
		driver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS);
		driver.get(url);
     	driver.manage().window().maximize();
	 	return driver;
    }
	
}