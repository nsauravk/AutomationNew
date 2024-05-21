package pkgWebPages;

import java.io.File;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import pkgCommonFiles.BaseClass;
import pkgSetupFiles.PropertiesSetupFile;

public class Exporter {
	WebElement expElement;
	PropertiesSetupFile objPSF = new PropertiesSetupFile("Exporter");
	BaseClass objBaseClass = new BaseClass();
	
	@Test
	public void RegExporter(WebDriver driver){
		try {
			expElement=driver.findElement((objPSF.getLocator("exporterclick")));
			expElement.click();
			expElement=driver.findElement((objPSF.getLocator("RegisterExp")));
			expElement.click();
			expElement=driver.findElement((objPSF.getLocator("RegCompName")));
			expElement.sendKeys("ecgc1");
			expElement=driver.findElement((objPSF.getLocator("Name")));
			expElement.sendKeys("dutta");
			expElement=driver.findElement((objPSF.getLocator("PanNo")));
			expElement.sendKeys("DBDPK2354R");
			
			JavascriptExecutor js= (JavascriptExecutor) driver;        
			        js.executeScript("window.scrollBy(0,500)");
			Thread.sleep(3000);
			expElement=driver.findElement((objPSF.getLocator("PanNo2")));
			

			expElement = driver.findElement(objPSF.getLocator("link_upload_pan_card"));
			expElement.sendKeys(new File("C:\\Users\\cdac\\Desktop\\pannum1\\a.pdf").getAbsolutePath());

			Thread.sleep(3000);

			//expElement.sendKeys("C:/Users/cdac/Desktop/autoit/test.exe");
		expElement.sendKeys(new File("./testData/pdf.pdf").getAbsolutePath());	
		Thread.sleep(3000);
		
		expElement=driver.findElement((objPSF.getLocator("IECode")));
		expElement.sendKeys("31");
			
		expElement=driver.findElement((objPSF.getLocator("link_upload_ie_code")));
		expElement.sendKeys(new File("C:\\Users\\cdac\\Desktop\\iecode1\\aa.pdf").getAbsolutePath());
		Thread.sleep(3000);

		
		expElement=driver.findElement((objPSF.getLocator("IECodAllotDate")));
		expElement.sendKeys("04-02-2024");
			expElement=driver.findElement((objPSF.getLocator("PreffEcgcbrch")));
		expElement.sendKeys("Mumbai");
			expElement=driver.findElement((objPSF.getLocator("Designation")));
			expElement.sendKeys("Trainer");
			expElement=driver.findElement((objPSF.getLocator("Mob")));
			expElement.sendKeys("9999999999");
		expElement=driver.findElement((objPSF.getLocator("Email")));
			expElement.sendKeys("ayandutta@ecgc.in");
			expElement=driver.findElement((objPSF.getLocator("Register")));
		expElement.click();
		
			
			
			 
			
		}
	catch(Exception e){
		e.printStackTrace();
	}
	}
		public void VerExpoReg(WebDriver driver){
			try {
				expElement=driver.findElement((objPSF.getLocator("P_UW")));
				expElement.click();
				expElement=driver.findElement((objPSF.getLocator("Ex_Master_Service")));
				expElement.click();
				
				expElement=driver.findElement((objPSF.getLocator("exporter")));
				expElement.click();
				expElement=driver.findElement((objPSF.getLocator("verExpRegclick")));
				expElement.click();
				expElement=driver.findElement((objPSF.getLocator("R_Button1")));
				expElement.click();
				expElement=driver.findElement((objPSF.getLocator("verify_Request")));
				expElement.click();
				expElement=driver.findElement((objPSF.getLocator("Approve1")));
				expElement.click();
				expElement=driver.findElement((objPSF.getLocator("Remarks")));
				expElement.sendKeys("asdf");
				
				expElement=driver.findElement((objPSF.getLocator("save1")));
				expElement.click();
				Alert alert = driver.switchTo().alert();
				alert.accept();
				
				
	
			}
		
			
			catch(Exception e){
				e.printStackTrace();
			}	
		
		}
		public void managexpoprofile(WebDriver driver){
			try {
//				JavascriptExecutor js= (JavascriptExecutor) driver;        
//	        js.executeScript("window.scrollBy(0,500)");
//
//				expElement=driver.findElement((objPSF.getLocator("P_UW1")));
//				expElement.click();
//				expElement=driver.findElement((objPSF.getLocator("Ex_Master_Service1")));
//				expElement.click();
				expElement=driver.findElement((objPSF.getLocator("exporter1")));
				expElement.click();
				
				
				
				
				expElement=driver.findElement((objPSF.getLocator("managexpoprofileclick")));
				expElement.click();
				expElement=driver.findElement((objPSF.getLocator("Exporter_Code")));
				expElement.sendKeys("368");
				expElement=driver.findElement((objPSF.getLocator("ofc_id")));
				expElement.click();
				Select dropdown=new Select(expElement);
				
				dropdown.selectByVisibleText("All Branches");
				expElement=driver.findElement((objPSF.getLocator("Search_Exporter")));
				expElement.click();
				
				expElement=driver.findElement((objPSF.getLocator("R_Button2")));
				expElement.click();
				
				expElement=driver.findElement((objPSF.getLocator("View&Edit1")));
				expElement.click();
				Thread.sleep(3000);
				
//				expElement=driver.findElement((objPSF.getLocator("Basic_Details")));
//				expElement.click();
				JavascriptExecutor js= (JavascriptExecutor) driver;        
		        js.executeScript("window.scrollBy(0,500)");
				Thread.sleep(12000);
				expElement=driver.findElement((objPSF.getLocator("Modify1")));
				expElement.click();
				expElement=driver.findElement((objPSF.getLocator("Company_Incorporation_Date")));
				expElement.sendKeys("19-03-2024");
//				expElement=driver.findElement((objPSF.getLocator("Legal_Constitution")));
//                 Select dropdown1=new Select(expElement);
//				
//				dropdown1.selectByVisibleText("LIMITED LIABILITY PARTNERSHIP (LLP)");
				expElement=driver.findElement((objPSF.getLocator("Remarks")));
				expElement.sendKeys("added");
				expElement=driver.findElement((objPSF.getLocator("save2")));
				expElement.click();
				
				
				
				expElement=driver.findElement((objPSF.getLocator("Exporter_Addresses")));
				expElement.click();
				expElement=driver.findElement((objPSF.getLocator("Modify2")));
				expElement.click();
				expElement=driver.findElement((objPSF.getLocator("Address_line1")));
				expElement.sendKeys("new mainpur,delhi");
				expElement=driver.findElement((objPSF.getLocator("Address_line2")));
				expElement.sendKeys("mainpur123,thair");
				expElement=driver.findElement((objPSF.getLocator("City")));
				expElement.sendKeys("goarakhip");
				expElement=driver.findElement((objPSF.getLocator("pincode")));
				expElement.sendKeys("453423");
				expElement=driver.findElement((objPSF.getLocator("state")));
				expElement.sendKeys("delhi");
				expElement=driver.findElement((objPSF.getLocator("address_Proof")));
				expElement.sendKeys(new File("./testData/pdf.pdf").getAbsolutePath());
				expElement=driver.findElement((objPSF.getLocator("Remarks1")));
				expElement.sendKeys("added1");
				expElement=driver.findElement((objPSF.getLocator("save3")));
				expElement.click();
				expElement=driver.findElement((objPSF.getLocator("Remarks1")));
				expElement.sendKeys("added1");
				expElement=driver.findElement((objPSF.getLocator("Remarks1")));
				expElement.sendKeys("added1");
				expElement=driver.findElement((objPSF.getLocator("Remarks1")));
				expElement.sendKeys("added1");
				expElement=driver.findElement((objPSF.getLocator("Remarks1")));
				expElement.sendKeys("added1");
				expElement=driver.findElement((objPSF.getLocator("Remarks1")));
				expElement.sendKeys("added1");
				
				
			
			}
			catch(Exception e){
				e.printStackTrace();
			}	
		
		}


}
