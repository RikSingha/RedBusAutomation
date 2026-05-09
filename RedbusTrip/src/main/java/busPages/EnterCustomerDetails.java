package busPages;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.Testbase;

public class EnterCustomerDetails extends Testbase {
	WebDriver driver;
	
	@FindBy(name = "Phone *")
	WebElement phoneNumber;
	
	@FindBy(xpath = "//input[@aria-label='Email ID']")
	WebElement email;
	
	@FindBy(xpath = "//input[@id='0_201']")
	WebElement stateOfResidence;
	
	@FindBy(xpath = "//input[contains(@placeholder,'Search for state')]")
	WebElement stateOfResidenceData;
	
	@FindBy(xpath = "//div[@data-radio-index='0']")
	WebElement stateOfResidenceDataSelection;
	
	@FindBy(xpath = "//input[@placeholder='Enter your Name']")
	WebElement Name;
	
	@FindBy(xpath = "//input[@placeholder='Enter Age']")
	WebElement Age;

	@FindBy(xpath = "//span[text()='Male']")
	WebElement radioMale;
	
	@FindBy(xpath="//h3[text()='redBus Assurance']")
	WebElement redBusAssured;
	
	@FindBy(id = "insuranceRejectText")
	WebElement InsuranceRejection;
	
	@FindBy(xpath= "//button[starts-with(text(),'Continue booking')]")
	WebElement continueBooking;
	
	public EnterCustomerDetails(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterCustomerDetailsMethod(String PhoneNumber, String EmailID, String StateOfResidence, String name, String age, String TescaseID) throws InterruptedException, IOException{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		phoneNumber.sendKeys(PhoneNumber);
		email.sendKeys(EmailID);
		stateOfResidence.click();
		Thread.sleep(1000);
		stateOfResidenceData.sendKeys(StateOfResidence);
		Thread.sleep(2000);
		stateOfResidenceDataSelection.click();
		TakesScreenshot("Enter Customer Details - 1", TescaseID);
		Thread.sleep(1000);
		js.executeScript("arguments[0].scrollIntoView(true);", Name);
		Thread.sleep(1000);
		Name.sendKeys(name);
		Thread.sleep(500);
		Age.sendKeys(age);
		Thread.sleep(500);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", radioMale);
		TakesScreenshot("Enter Customer Details - 2", TescaseID);
		Thread.sleep(500);
		js.executeScript("arguments[0].scrollIntoView(true);", redBusAssured);
		Thread.sleep(500);
		InsuranceRejection.click();
		TakesScreenshot("Enter Customer Details - 3", TescaseID);
		Thread.sleep(500);
		js.executeScript("arguments[0].scrollIntoView(true);", continueBooking);
		Thread.sleep(500);
		TakesScreenshot("Enter Customer Details - 4", TescaseID);
		Thread.sleep(500);
		continueBooking.click();
		Thread.sleep(5000);
		TakesAScreenshot("Checkout Page", TescaseID);
	}
}
