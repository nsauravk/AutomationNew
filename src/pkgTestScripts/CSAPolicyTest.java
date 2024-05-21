package pkgTestScripts;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pkgCommonFiles.BaseClass;
import pkgCommonFiles.PolUW_LandingPage;
import pkgWebPages.CSAPolicy;

public class CSAPolicyTest {
	
	WebDriver driverMain;
	PolUW_LandingPage objDashboard = new PolUW_LandingPage();
	CSAPolicy objPolUW = new CSAPolicy();
	BaseClass objBaseClass = new BaseClass();

	
	String actualResult, expectedResult;

//	@BeforeClass
//    public void getDriver() throws Exception {
//    	driverMain = BaseClass.getWebDriver();
//    	objDashboard.selectOptions(driverMain);
//    }
	
	@BeforeClass
	public void getDrive() throws Exception{
		driverMain = objBaseClass.launchURL();
		// driverMain = BaseClass.getWebDriver();
	}
	
	@Test(enabled = true, priority = 0, testName="This testcase is used to test submitting new policy proposal for SCR")
	public void addNewPolicyProposal() throws Exception {
		expectedResult = "All good";
		objBaseClass.login("username");
		objDashboard.selectOptions(driverMain, "policyIssue");
		actualResult = objPolUW.addNewCSAPolicyProposal(driverMain);
		Assert.assertEquals(actualResult, expectedResult, actualResult);
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

}
