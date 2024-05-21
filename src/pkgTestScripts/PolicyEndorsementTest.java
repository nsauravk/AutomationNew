package pkgTestScripts;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pkgCommonFiles.BaseClass;
import pkgCommonFiles.PolUW_LandingPage;
import pkgWebPages.PolicyEndorsement;

public class PolicyEndorsementTest {

	WebDriver driverMain;
	static String expectedMsg, actualMsg;
	PolUW_LandingPage objDashboard = new PolUW_LandingPage();
	PolicyEndorsement objPolicyEndorsement = new PolicyEndorsement();
	boolean actualResult;
	BaseClass objBaseClass = new BaseClass();
	
	

	@BeforeClass
	public void getDriver() throws Exception{
		driverMain = objBaseClass.launchURL();
		// driverMain = BaseClass.getWebDriver();
	}

	@Test(enabled = true, priority = 1, testName = "This test is used for generating office note.")
	public void addBWPPolicy() throws Exception {
		objBaseClass.login("username");
		objDashboard.selectOptions(driverMain, "policyEndorsement");
		actualMsg = objPolicyEndorsement.addPolicyEndorsement(driverMain);
	}

	@AfterMethod
	public void screenCapture(ITestResult results) {
		if (ITestResult.FAILURE == results.getStatus())
			try {
				TakesScreenshot screenshot = (TakesScreenshot) driverMain;
				File src = screenshot.getScreenshotAs(OutputType.FILE);
				File screenshotFile = new File(
						System.getProperty("user.dir") + "/screenshots/" + results.getName() + ".jpg");
				FileHandler.copy(src, screenshotFile);
				System.out.println("Captured screenshot successfully");
			}

			catch (Exception e) {
				System.out.println("Exception while taking screenshot" + e.getMessage());
			}
	}

	@AfterSuite
	public void killProcess() throws Exception {
	//	objBaseClass.afterMethodExec();
	}

}
