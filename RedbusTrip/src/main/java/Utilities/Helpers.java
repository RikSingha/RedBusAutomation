package Utilities;

import java.time.LocalDate;

public class Helpers {

	public static String getExpectedDate() {
		String inputMonth;
		LocalDate currentDate = LocalDate.now();
		int currentMonth = currentDate.getMonthValue();
		int inputmonth = currentMonth+2;
		if(inputmonth<10) {
			inputMonth="0"+String.valueOf(inputmonth);
		}
		else {
			inputMonth=String.valueOf(inputmonth);
		}
		String newInputDate = String.valueOf(currentDate.getYear())+"-"+inputMonth+"-"+String.valueOf(currentDate.getDayOfMonth());
		return newInputDate;
	}

}
