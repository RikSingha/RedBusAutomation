package busPages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.Testbase;

public class LocationSelection extends Testbase {
	WebDriver driver;
	
	public static void ExpectedSource(WebDriver driver, String src, JavascriptExecutor js) {
		WebElement source = driver.findElement(By.xpath("//div[text()=\'"+src+"\']"));
		js.executeScript("arguments[0].scrollIntoView(true);", source);
		source.click();
	}
	
	public static void ExpectedDestination(WebDriver driver, String des, JavascriptExecutor js) {
		WebElement destination = driver.findElement(By.xpath("//div[text()=\'"+des+"\']"));
		js.executeScript("arguments[0].scrollIntoView(true);", destination);
		destination.click();
	}
	
	public LocationSelection(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void selectLocationMethod(String src, String des, String TescaseID) throws InterruptedException, IOException {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		ExpectedSource(driver, src, js);
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(0,400);");
		ExpectedDestination(driver,des, js);
		Thread.sleep(1000);
	}
	
}
