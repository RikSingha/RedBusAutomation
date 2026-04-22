package Utilities;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.TakesScreenshot;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Testbase {
	public static WebDriver driver;
	@BeforeMethod
	public void openBrowser() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.redbus.in/bus-tickets");
		Thread.sleep(2000);
	}
	
	@AfterMethod
	public void TearDown() {
		driver.close();
	}
	
	public static void TakesAScreenshot(String PageName, String TescaseID) throws IOException {
		Screenshot s = new AShot()
			    .shootingStrategy(ShootingStrategies.viewportPasting(1000))
			    .takeScreenshot(driver);
			ImageIO.write(s.getImage(), "PNG", new File("D:\\Selenium Workspace\\RedbusTrip\\Screenshots\\"+TescaseID+"\\"+PageName+".png"));

	}
	
	public static void TakesScreenshot(String PageName, String TescaseID) throws IOException {
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcFile, new File("D:\\Selenium Workspace\\RedbusTrip\\Screenshots\\"+TescaseID+"\\"+PageName+".png"));

	}
	
	public static void CreateFolder(String TescaseID) {
		String path = "D:\\Selenium Workspace\\RedbusTrip\\Screenshots\\"+TescaseID;
        File folder = new File(path);

        if (!folder.exists()) {
            if (folder.mkdirs()) {
                System.out.println("Folder created: " + folder.getPath());
            } else {
                System.out.println("Failed to create folder.");
            }
        } else {
            System.out.println("Folder already exists.");
        }
	}
	
}
