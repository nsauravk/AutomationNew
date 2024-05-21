
package pkgCommonFiles;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import pkgSetupFiles.WebDriverSetupFile;

public class BaseClass {
	
	public static WebDriver driverMain;
	public static Properties envProp, testDataProps;
	private String osName, browserName, driverPath, url, userName, password, environment = null;
	private boolean headless;
	private FileInputStream inputStream;
	
	LoginPage objLogin = new LoginPage();
	LogoutFunc objLogout = new LogoutFunc();
	PolUW_LandingPage objLandingPage = new PolUW_LandingPage();
	
	public static WebDriver getWebDriver() {
		return driverMain;
	}
	
	public void TestBase(){
		try {
			environment = System.getProperty("env");
			if(environment!=null) {
				envProp = new Properties();
				inputStream = new FileInputStream(System.getProperty("user.dir")+ "/EnvironmentProperties/"+environment+".properties");
				envProp.load(inputStream);
				
				testDataProps = new Properties();
				inputStream = new FileInputStream(System.getProperty("user.dir")+ "/testData/TestData.properties");
				testDataProps.load(inputStream);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public WebDriver launchURL() throws Exception
	{
		TestBase();
		osName = envProp.getProperty("os");
		browserName = envProp.getProperty("browser");
		headless = Boolean.parseBoolean(envProp.getProperty("headless"));
		driverPath = envProp.getProperty("driverpath");
		url = testDataProps.getProperty("url");
//		userName = testDataProps.getProperty("username");
//		password = testDataProps.getProperty("password");
		
		driverMain=WebDriverSetupFile.setupDriver(osName, browserName, driverPath, headless, url);
//		objLogin.loginToModule(driverMain, userName, password);
//		objLandingPage.selectInsuranceDoc(driverMain, "insCvrDoc");
		
		return getWebDriver();
		
	}
	
	public void login(String username) throws Exception {

		userName = testDataProps.getProperty(username);
		password = testDataProps.getProperty("password");

		objLogin.loginToModule(driverMain, userName, password);

	}

	public void afterMethodExec() throws Exception
	{
		objLogout.logoutFromModule(driverMain);
		//driverMain.quit();
	}
}


/*
package pkgCommonFiles;

import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import pkgSetupFiles.WebDriverSetupFile;

public class BaseClass {
	
	private static WebDriver driverMain;
	private Properties envProp = null;
	private Properties testDataProps = null;
	private String osName = null;
	private String browserName = null;
	private String driverPath = null;
	private String url = null;
	private String userName = null;
	private String password = null;
	private boolean headless = false;
//	private FileInputStream inputStream;
	
	LoginPage objLogin = new LoginPage();
	LogoutFunc objLogout = new LogoutFunc();
	PPD_LandingPage objLandingPage = new PPD_LandingPage();
	
	public static WebDriver getWebDriver() {
		return driverMain;
	}
	
	public void testBase(){
		
		String environment = System.getProperty("env");
		
		if(environment != null) {
			
			String pathEnvProp = System.getProperty("user.dir")+ "/EnvironmentProperties/"+environment+".properties";
			String pathTestDataProp = System.getProperty("user.dir")+ "/testData/TestData.properties";
			
			try (
					FileInputStream readEnvProp = new FileInputStream(pathEnvProp);
					FileInputStream readTestDataProp = new FileInputStream(pathTestDataProp)) {
				
				envProp = new Properties();
				envProp.load(readEnvProp);
				
				testDataProps = new Properties();
				testDataProps.load(readTestDataProp);
				
				osName = envProp.getProperty("os");
				browserName = envProp.getProperty("browser");
				headless = Boolean.parseBoolean(envProp.getProperty("headless"));
				driverPath = envProp.getProperty("driverpath");
				url = testDataProps.getProperty("url");
				
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Environment is null");
		}
		
	}
	
	public WebDriver launchURL() throws Exception
	{
		testBase();
		
//		userName = testDataProps.getProperty(username);
//		password = testDataProps.getProperty("password");
		
		driverMain = WebDriverSetupFile.setupDriver(osName, browserName, driverPath, headless, url);
//		objLogin.loginToModule(driverMain, userName, password);
		
		return getWebDriver();
		
	}
	
	public void login(String username) throws Exception {
		
		userName = testDataProps.getProperty(username);
		password = testDataProps.getProperty("password");
		
		objLogin.loginToModule(driverMain, userName, password);
		
	}
	
	public void logout() throws Exception {
		
		objLogout.logoutFromModule(driverMain);
	}
	
	public void afterMethodExec() throws Exception
	{
		driverMain.quit();
	}
}
*/
