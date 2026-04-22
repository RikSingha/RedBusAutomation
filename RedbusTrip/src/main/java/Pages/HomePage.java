package Pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.Helpers;
import Utilities.Testbase;

public class HomePage extends Testbase{
	WebDriver driver;
	String date = Helpers.getExpectedDate();
	@FindBy(id="txtSource")
	WebElement fromCity;
	@FindBy(id="txtDestination")
	WebElement toCity;
	@FindBy(xpath ="//div[contains(text(),'Koramangala, Bangalore')]")
	WebElement toCitySelection;
	@FindBy(id="txtOnwardCalendar")
	WebElement calendarClick;
	@FindBy(className="calwid__btn-next-month")
	WebElement nextMonthClick;
	@FindBy(xpath="//button[contains(@class,'D120_search_btn_v2 searchBuses')]")
	WebElement searchBus;
	By element = By.xpath("//div[contains(@class,'srcDest')and@aria-label='Select From']");
	
	public static void ExpectedDate(WebDriver driver) {
		driver.findElement(By.xpath("//span[contains(@data-date,\'"+Helpers.getExpectedDate()+"\')]")).click();
	}
	
	public static void ExpectedSource(WebDriver driver, String srcSuggestion) {
		driver.findElement(By.xpath("//div[contains(text(),\'"+srcSuggestion+"\')]")).click();
	}
	
	public static void ExpectedDestination(WebDriver driver, String desSuggestion) {
		driver.findElement(By.xpath("//div[contains(text(),\'"+desSuggestion+"\')]")).click();
	}
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}


	public void BusSelection(String src, String des, String srcSuggestion, String desSuggestion, String TescaseID) throws InterruptedException, IOException {
		fromCity.sendKeys(src);
		Thread.sleep(1000);
		ExpectedSource(driver,srcSuggestion);
		
		toCity.sendKeys(des);;
		Thread.sleep(1000);
		ExpectedDestination(driver,desSuggestion);
		
		calendarClick.click();
		Thread.sleep(800);
		for(int i=1;i<=12;i++) {	
			try {
				HomePage.ExpectedDate(driver);
				Thread.sleep(1000);
				break;
			}catch(Exception e) {
				nextMonthClick.click();
			}
		}
		Thread.sleep(2000);
		TakesScreenshot("Home Page", TescaseID);
		Thread.sleep(1000);
		searchBus.click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.textToBePresentInElementLocated(element, srcSuggestion));
	}
}
