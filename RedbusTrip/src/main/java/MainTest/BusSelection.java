package MainTest;

import java.io.IOException;

import org.testng.annotations.Test;
import Pages.BusSeatSelection;
import Pages.EnterCustomerDetails;
import Pages.FilterBus;
import Pages.HomePage;
import Pages.LocationSelection;
import Utilities.Excel;
import Utilities.Testbase;

public class BusSelection extends Testbase{
	
	@Test(dataProvider = "ActualData", dataProviderClass = Excel.class)
	public void mainTest(String TescaseID,String SourceSuggestion, String DestinationSuggestion,
						 String budget, String Name, String Age, 
						 String StateOfResidence, String Source, 
						 String Destination, String PhoneNumber, 
						 String EmailID, String BusSource, String BusDestination) throws InterruptedException, IOException {
		
		int parsedFare = Integer.parseInt(budget);
		CreateFolder(TescaseID);
		//Page 1
		HomePage ho = new HomePage(driver);
		ho.BusSelection(Source, Destination,SourceSuggestion,DestinationSuggestion, TescaseID);
		//Page 2
		FilterBus fb = new FilterBus(driver);
		fb.filterBusMethod(Source, Destination, TescaseID);
		//Page 3
		BusSeatSelection bss = new BusSeatSelection(driver);
		bss.SeatSelectionMethod(parsedFare, TescaseID);
		//Page 4
		LocationSelection ls = new LocationSelection(driver);
		ls.selectLocationMethod(BusSource, BusDestination, TescaseID);
		//Page 5
		EnterCustomerDetails ecd = new EnterCustomerDetails(driver);
		ecd.enterCustomerDetailsMethod(PhoneNumber, EmailID, StateOfResidence, Name, Age, TescaseID);
	}
	//setTimeout(() => { debugger; }, 10000)
}
