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

public class BusSeatSelection extends Testbase{
	WebDriver driver;
	
	@FindBy(xpath = "//button[contains(@aria-label,'Select boarding & dropping points')]")
	WebElement selectBoardingndDrop;
	
	public static void SeatSelection(WebDriver driver, int budget) {
		List<WebElement> seats = driver.findElements(By.xpath("//span[contains(@aria-label,'lower deck')]"));
		for(int i=0;i<seats.size();i++) {
			String SeatText = seats.get(i).getText();
			if(!SeatText.equalsIgnoreCase("sold")) {
				int seatVal = Integer.parseInt(seats.get(i).getText().replace("₹", ""));
				if(seatVal<budget) {
					seats.get(i).click();
					break;
				}
			}
		}
	}
	
	public BusSeatSelection(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void SeatSelectionMethod(int budget,String TescaseID) throws InterruptedException, IOException {
		SeatSelection(driver,budget);
		TakesScreenshot("Bus Seat Selection", TescaseID);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", selectBoardingndDrop);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(selectBoardingndDrop));
		selectBoardingndDrop.click();
		Thread.sleep(2000);
	}
	
}
