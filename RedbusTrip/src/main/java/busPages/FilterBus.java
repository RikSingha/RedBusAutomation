package busPages;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.Testbase;

public class FilterBus extends Testbase{
	WebDriver driver;
	
	@FindBy(xpath="//div[@aria-label='Price']")
	WebElement price;
	@FindBy(xpath="//div[contains(text(),'SLEEPER')]")
	WebElement sleeper;
	@FindBy(id="bpIdentifier")
	WebElement sourceClick;
	@FindBy(xpath="//input[contains(@class,'searchInput')]")
	WebElement SrcOrDesInput;
	@FindBy(xpath="//div[text()='Boarding points']")
	WebElement sourceClose;
	@FindBy(id="dpIdentifier")
	WebElement destinationClick;
	
	static By viewSeats =By.xpath("//button[contains(@aria-label,'View seats')]");
	
	public static void viewSeatsMethod(WebDriver driver) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.textToBePresentInElementLocated(viewSeats, "View seats"));
		List<WebElement>seatBooking = driver.findElements(viewSeats);
		if(seatBooking.isEmpty()) {
			System.out.println("Seats are not available");
			Thread.sleep(2000);
		}
		else {
			seatBooking.get(0).click();
			Thread.sleep(2000);
		}
	}
	
	public static void ExpectedSource(WebDriver driver, String src) {
		driver.findElement(By.xpath("//div[text()=\'"+src+"\']")).click();
	}
	
	public static void ExpectedDestination(WebDriver driver, String des) {
		driver.findElement(By.xpath("//div[text()=\'"+des+"\']")).click();
	}
	
	public FilterBus(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void filterBusMethod(String Source, String  Destination, String TescaseID) throws InterruptedException, IOException {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		price.click();
		sleeper.click();
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,400);");
		Thread.sleep(1400);
		sourceClick.click();
		SrcOrDesInput.sendKeys(Source);
		Thread.sleep(1500);
		ExpectedSource(driver, Source);
		Thread.sleep(1000);
		sourceClose.click();
		Thread.sleep(1000);
		destinationClick.click();
		Thread.sleep(1000);
		SrcOrDesInput.sendKeys(Destination);
		Thread.sleep(1500);
		ExpectedDestination(driver, Destination);
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,-400);");
		TakesScreenshot("Filter the bus", TescaseID);
		viewSeatsMethod(driver);
	}
}
