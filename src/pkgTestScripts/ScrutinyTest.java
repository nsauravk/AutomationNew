package pkgTestScripts;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pkgCommonFiles.BaseClass;
import pkgCommonFiles.PolUW_LandingPage;
import pkgWebPages.Scrutiny;

public class ScrutinyTest {

	WebDriver driverMain;
	static String expectedMsg, actualMsg;
	PolUW_LandingPage objDashboard = new PolUW_LandingPage();
	Scrutiny objScrutiny = new Scrutiny();
	boolean actualResult;
	BaseClass objBaseClass = new BaseClass();
	

	@BeforeClass
	public void getDriver() throws Exception{
		driverMain = objBaseClass.launchURL();
		// driverMain = BaseClass.getWebDriver();
	}

	@Test(enabled = true, priority = 1, testName = "This test is used for generating scrutiny of policy proposal.")
	public void addBWPPolicy() throws Exception {
		expectedMsg = "Recommendation Details Saved Successfully";
		objBaseClass.login("AM");
		objDashboard.selectOptions(driverMain, "policyIssue");
		actualMsg = objScrutiny.addScrutiny(driverMain);
		Assert.assertEquals(actualMsg, expectedMsg);
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
