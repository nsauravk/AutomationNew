package pkgUtilities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;



public class HelperClass {
	
	Random random = new Random();
	Faker faker = new Faker();	
	Actions actions;
	WebDriverWait wait;
	
//	wait for element to be clickable	
	public void waitForElementToBeClickable(WebDriver driver, WebElement webElement) {
		wait = new WebDriverWait(driver, 20000);
		wait.until(ExpectedConditions.elementToBeClickable(webElement));
	}
	
	
//	wait for the visibility of element	
	public void waitForVisibilityOfElement(WebDriver driver, WebElement webElement) {
		wait = new WebDriverWait(driver, 20000);
		wait.until(ExpectedConditions.visibilityOf(webElement));
	}
	
//	wait for visibility of All Elements	
	public void waitForVisibilityOfAllElements(WebDriver driver, List<WebElement> webElements) {
		wait = new WebDriverWait(driver, 50000);
		wait.until(ExpectedConditions.visibilityOfAllElements(webElements));
	}
	
//  Function to handle ElementInterceptException using Action class
	
	public void handleElementInterceptExceptionUsingAction(WebDriver driver, WebElement webElement) {
		actions = new Actions(driver);
		actions.moveToElement(webElement).click().build().perform();
	}

	
//	wait for dropdown options to load	
	public void waitForDropdownOptions(WebDriver driver, Select select) {
		wait = new WebDriverWait(driver, 50000);
		List<WebElement> list = select.getOptions();
		wait.until(ExpectedConditions.visibilityOfAllElements(list));
	}
	
//	Function used to generate random unique ID
	public void enterRandomID(WebElement webElement) {
		webElement.clear();
		webElement.sendKeys((Integer.toString(random.nextInt(100000))));
	}
	
//	Function used to generate random names	
	public void enterRandomString(WebElement webElement) {
		webElement.clear();
		webElement.sendKeys(faker.gameOfThrones().character());
	}
	
	public String getRandomString() {
		return faker.gameOfThrones().character();
	}
	
	public void enterOrganization(WebElement webElement) {
		webElement.clear();
		webElement.sendKeys(faker.company().name());
	}
	
	public void enterContactNumber(WebElement webElemnet) {
		/*
		 * String temp; Pattern pattern = Pattern.compile("^[6-9]\\d{9}$"); Matcher
		 * match; System.out.println("Hello"); do { temp = faker.number().digits(10);
		 * match = pattern.matcher(temp); if(match.find()&&match.group(temp)) {
		 * 
		 * } } while(match.find()&&match.group(temp)); return
		 * faker.number().digits(digits);
		 */
		webElemnet.clear();
		webElemnet.sendKeys("9876543210");
	}
	
	
// Function used to pick random value from a web table row	
	public String selectRandomValueFromTable(List<WebElement> listElement) {
		int size = listElement.size();
		String searchKeyword = listElement.get(random.nextInt(size)).getAttribute("value");
		return searchKeyword;
	}
	
	public String getRandomValueFromTable(List<WebElement> listElement) {
		int size = listElement.size();
		String searchKeyword = listElement.get(random.nextInt(size)).getText();
		return searchKeyword;
	}
	
//	Function used to pick random value from dropdown
	public void selectRandomValueFromDropdown(WebDriver driver, Select dropdown) {
		List<WebElement> options = dropdown.getOptions();
		int drpdwnSize = options.size();
		dropdown.selectByIndex(random.nextInt(drpdwnSize));
	}
	
	public String getRandomValueFromDropdown(WebDriver driver, Select dropdown) {
		List<WebElement> options = dropdown.getOptions();
		int drpdwnSize = options.size();
		int index;
		do {
			index = random.nextInt(drpdwnSize);
		} while(index == 0);
		dropdown.selectByIndex(index);
		String selectedValue = dropdown.getOptions().get(index).getText();
		return selectedValue;
	}
	
//	Function used to enter random mail id
	public void enterRandomMailID(WebElement webElement) {
		webElement.clear();
		webElement.sendKeys(faker.internet().emailAddress());
	}
	
	public void enterRandomPincode(WebElement webElement) {
		webElement.clear();
//		webElement.sendKeys(Integer.toString(random.nextInt(1000000)));
		webElement.sendKeys("123456");
	}
	
	public String getCurrentDate() {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
	    String strDate= formatter.format(date);
//	    strDate = (String) strDate.subSequence(0, 10);
	    return strDate;
	}
	
	public void setCurrentDate(WebElement webElement) {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	    String strDate= formatter.format(date);
//	    strDate = (String) strDate.subSequence(0, 10);
	    webElement.sendKeys(strDate);
	}
	
	public void selectRandomPastDate(WebElement webElement) {
		Date date = faker.date().past(10, TimeUnit.DAYS);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	    String strDate= formatter.format(date);
		webElement.sendKeys(strDate);
	}
	
	public void selectRandomFutureDate(WebElement webElement) {
		Date date = faker.date().future(2000, TimeUnit.DAYS); 
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	    String strDate= formatter.format(date);
//		System.out.println("Future Date:"+strDate);
		webElement.sendKeys(strDate);
	}
	
	public void enterRandomName(WebElement webElement) {
		webElement.clear();
		webElement.sendKeys(faker.address().cityName());
//		faker.address().cityName();
	}
	
	public boolean isElementPresent(WebElement webElement) {
        if(webElement != null) {
            return true;
        }
        return false;
    }
	
	public void enterFullAddress(WebElement webElemnt) {
		webElemnt.clear();
		webElemnt.sendKeys(faker.address().cityName());
	}
	
	public void enterAddressLine1(WebElement webElement) {
		webElement.clear();
		String addressLine1 = faker.address().buildingNumber();
		webElement.sendKeys(addressLine1);
	}
	
	public void enterAddressLine2(WebElement webElement) {
		webElement.clear();
		String addressLine2 = faker.address().streetAddress();
		webElement.sendKeys(addressLine2);
	}
	
	public void enterRandomNumberByDigit(WebElement webElement, int digit) {
		String number = Integer.toString(random.nextInt(digit));
	}
	
	public String modifyXpathWithSearchkey(String xpath, String searchKey) {
		String modifiedXpath = xpath.replaceAll("replaceTextWithSearchKey", searchKey).substring(9);
		return modifiedXpath;
	}
}
