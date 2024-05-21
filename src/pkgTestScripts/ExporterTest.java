package pkgTestScripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pkgCommonFiles.BaseClass;
import pkgCommonFiles.PolUW_LandingPage;
import pkgWebPages.BWPPolicy;
import pkgWebPages.Exporter;



public class ExporterTest {
	WebDriver driverMain;
	static String expectedMsg, actualMsg;
	PolUW_LandingPage objDashboard = new PolUW_LandingPage();
	Exporter objBWPPolicy = new Exporter();
	boolean actualResult;
	BaseClass objBaseClass = new BaseClass();

	@BeforeTest
	public void getDriver() throws Exception{
		driverMain = objBaseClass.launchURL();
//		driverMain = BaseClass.getWebDriver();
	}
	
	@Test(enabled = false, priority = 1, testName = "This test is used to register")
	public void registerExporter() throws Exception{
		objBaseClass.login("username");
//		objDashboard.selectOptions(driverMain, "policyIssue");
		objBWPPolicy.RegExporter(driverMain);
		
	}
	@Test(enabled = false, priority = 2, testName = "This test is used to Verify Exporter registrations")
	public void verifyexporegister() throws Exception{
		objBaseClass.login("verifyusername");
		objBWPPolicy.VerExpoReg(driverMain);
	}
	@Test(enabled = true, priority = 3, testName = "This test is used to Manage Exporter Profile")
	public void managexpoprofile() throws Exception{
		objBaseClass.login("managexpoprofile");
		objBWPPolicy.managexpoprofile(driverMain);
	}
	
	
	
	@AfterMethod
	public void killProcess() throws Exception {
	//	objBaseClass.afterMethodExec();
	}

}
