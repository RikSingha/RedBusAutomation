package Utilities;

import java.time.LocalDate;

public class Helpers {

	public static String getExpectedDate() {
		String inputMonth;
		LocalDate currentDate = LocalDate.now();
		int currentMonth = currentDate.getMonthValue();
		int inputmonth = currentMonth+2;
		String inputDate;
		if(inputmonth<10) {
			inputMonth="0"+String.valueOf(inputmonth);
		}
		else {
			inputMonth=String.valueOf(inputmonth);
		}
		if(currentDate.getDayOfMonth()<10) {
			inputDate="0"+String.valueOf(currentDate.getDayOfMonth());
		}
		else {
			inputDate=String.valueOf(currentDate.getDayOfMonth());
		}
		String newInputDate = String.valueOf(currentDate.getYear())+"-"+inputMonth+"-"+inputDate;
		System.out.println(newInputDate);
		return newInputDate;
	}

}
