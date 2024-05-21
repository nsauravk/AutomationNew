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
import pkgWebPages.SPPPolicy;

public class SPPPolicyTest {
	
	WebDriver driverMain;
	PolUW_LandingPage objDashboard = new PolUW_LandingPage();
	SPPPolicy objPolUW = new SPPPolicy();
	BaseClass objBaseClass = new BaseClass();
	String actualResult, expectedResult;
	
	@BeforeClass
	public void getDrive() throws Exception{
		driverMain = objBaseClass.launchURL();
//		driverMain = BaseClass.getWebDriver();
	}
	
	@Test(enabled = true, priority = 1, testName="This testcase is used to test submitting new policy proposal for SPP")
	public void addNewPolicyProposal() throws Exception {
		expectedResult = "All good";
		objBaseClass.login("username");
		objDashboard.selectOptions(driverMain, "policyIssue");
		actualResult = objPolUW.addNewSPPPolicyProposal(driverMain);
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
