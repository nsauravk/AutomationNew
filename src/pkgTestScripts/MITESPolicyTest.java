package pkgTestScripts;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pkgCommonFiles.BaseClass;
import pkgCommonFiles.PolUW_LandingPage;
import pkgWebPages.MITESPolicy;

public class MITESPolicyTest {
	
	WebDriver driverMain;
	PolUW_LandingPage objDashboard = new PolUW_LandingPage();
	MITESPolicy objPolUW = new MITESPolicy();
	BaseClass objBaseClass = new BaseClass();
	String actualResult, expectedResult;
	
	@BeforeClass
	public void getDrive() throws Exception{
		driverMain = objBaseClass.launchURL();
		// driverMain = BaseClass.getWebDriver();
	}
	
	@Test(enabled = true, priority = 1, testName="This testcase is used to test submitting new policy proposal for MITES")
	public void addNewPolicyProposal() throws Exception {
		objBaseClass.login("username");
		objDashboard.selectOptions(driverMain, "policyIssue");
		actualResult = objPolUW.addNewMITESPolicyProposal(driverMain);
		Assert.assertEquals(actualResult, expectedResult, actualResult);
	}
	
}
