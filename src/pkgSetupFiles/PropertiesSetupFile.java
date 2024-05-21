/**  
 	 AUTHOR  : AKHILESH
 	 DESCRIPTION: This file is used to return the selenium locator alongwith the locator value from the .properties file.
 	 Its an interface between .java and .properties file. This method is also used to load the File by using the Load method of
 	 Properties class (Selenium)
**/

package pkgSetupFiles;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;

public class PropertiesSetupFile
{
	Properties props;
	FileInputStream locator,objFile;
	String loc,locType,locValue;
	Exception e=new Exception("Locator type '"+locType+"' not defined!!");
	
	//Code with Selenium Locator
	public PropertiesSetupFile(String className)
	{
		try
		{
			locator=new FileInputStream(System.getProperty("user.dir")+"/SeleniumProperties/"+className+".properties");
			props=new Properties();
			props.load(locator);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public By getLocator(String elementName) throws Exception
	{
		//Read the value of the locator using the key name
		loc=props.getProperty(elementName);
		
		//Split the value on ":" which contains the locator type and locator value
		locType=loc.split(":")[0];
		locValue=loc.split(":")[1];    
		
		//Return an object of the By class based on the type of locator
		switch(locType.toLowerCase())
		{
			case "id":
				return By.id(locValue);
				
			case "name":
				return By.name(locValue);
				
			case "classname":
				return By.className(locValue);
				
			case "class":
				return By.className(locValue);
				
			case "tagname":
				return By.className(locValue);
				
			case "tag":
				return By.className(locValue);
				
			case "linktext":
				return By.linkText(locValue);
			
			case "link":
				return By.linkText(locValue);
			
			case "partiallinktext":
				return By.partialLinkText(locValue);
			
			case "cssselector":
				return By.cssSelector(locValue);
			
			case "css":
				return By.cssSelector(locValue);
			
			case "xpath":
				return By.xpath(locValue);
			
			default:
				throw e;
		}
	}
	
	//Code without Selenium Locator
	public PropertiesSetupFile()
	{
		
	}
/*	
	public FileInputStream loadObjFile(String className) throws IOException
	{
		objFile=new FileInputStream(System.getProperty("user.dir")+"/propertiesFiles/"+className+".properties");
		return objFile;
	}
*/	 
}