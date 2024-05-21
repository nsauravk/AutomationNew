package pkgTestScripts;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pkgCommonFiles.BaseClass;
import pkgCommonFiles.PolUW_LandingPage;
import pkgWebPages.MBEPolicy;

public class MBEPolicyTest {
	
	WebDriver driverMain;
	PolUW_LandingPage objDashboard = new PolUW_LandingPage();
	MBEPolicy objPolUW = new MBEPolicy();
	BaseClass objBaseClass = new BaseClass();
	String actualResult, expectedResult;
	
	@BeforeClass
	public void getDrive() throws Exception{
		driverMain = objBaseClass.launchURL();
		// driverMain = BaseClass.getWebDriver();
	}
	
	@Test(enabled = true, priority = 1, testName = "This testcase is used to test submitting new policy proposal for MBE Small")
	public void addNewSmallPolicyProposal() throws Exception {
		objBaseClass.login("username");
		objDashboard.selectOptions(driverMain, "policyIssue");
		actualResult = objPolUW.addNewMBESmallPolicyProposal(driverMain);
		// Assert.assertEquals(actualResult, expectedResult, actualResult);
	}
	
	@Test(enabled = false, priority = 2, testName = "This testcase is used to test submitting new policy proposal for MBE Large")
	public void addNewLargePolicyProposal() throws Exception {
		objDashboard.selectOptions(driverMain, "policyIssue");
		actualResult = objPolUW.addNewMBELargePolicyProposal(driverMain);
		Assert.assertEquals(actualResult, expectedResult, actualResult);
	}

	@Test(enabled = false, priority = 3, testName = "This testcase is used to test submitting new policy proposal for MBE Large")
	public void addNewGJDPolicyProposal() throws Exception {
		objDashboard.selectOptions(driverMain, "policyIssue");
		actualResult = objPolUW.addNewMBEGJDPolicyProposal(driverMain);
		Assert.assertEquals(actualResult, expectedResult, actualResult);
	}

}
