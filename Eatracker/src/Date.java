
/*
 * Author: Farryl
 * 
 * This class stores information on the current date.
 * 
 */

public class Date {

	// Stores the day, month, and year as integers
	private int day, month, year;

	// Date constructor
	public Date(int day, int month, int year) {

		super();
		setMonth(month);
		setYear(year);
		setDay(day);

	}

	// Setters and getters
	public int getDay() {
		return day;
	}

	public void setDay(int day) {

		// Must be between 1 and the number of days in the current month, otherwise
		// default to 1
		if (day > 0 && day <= numDays(getMonth(), getYear()))
			this.day = day;
		else
			this.day = 1;

	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {

		// Must be between 1 and 12, otherwise default to 1
		if (month >= 1 && month <= 12)
			this.month = month;
		else
			this.month = 1;

	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {

		// Must be a positive integer, otherwise default to 2019
		if (year > 0)
			this.year = year;
		else
			this.year = 2019;

	}

	// Determines the number of days based on the month and year
	private static int numDays(int month, int year) {

		switch (month) {
		case 1:
			return 31;
		case 2:
			// If it is a leap year, there are 29 days; otherwise, there are 28 days
			if (year % 4 == 0)
				return 29;
			else
				return 28;
		case 3:
			return 31;
		case 4:
			return 30;
		case 5:
			return 31;
		case 6:
			return 30;
		case 7:
			return 31;
		case 8:
			return 31;
		case 9:
			return 30;
		case 10:
			return 31;
		case 11:
			return 30;
		case 12:
			return 31;
		}

		return 30;

	}
	
	// Checks whether a date is valid
	public static boolean checkValid(int day, int month, int year) {
		
		// Only dates between 01/01/2019 to 12/31/2019 are valid as of currently
		if(day > 0 && day <= numDays(month, year) && month > 0 && month <= 12 && year == 2019)
			return true;
		else
			return false;
		
	}
	
	// Returns the day number of a date
	public static int dayNum(Date date) {
		
		int dayNum = 0;
		
		// Add the corresponding number of days for each month
		for(int index = 1; index < date.getMonth(); index++)
			dayNum += numDays(index, date.getYear());
		
		// Add the remaining days
		dayNum += date.getDay();
		
		return dayNum;
		
	}
	
	// Returns the corresponding date given a num value
	public static Date numToDate(int num) {
		
		int tempNum = num;
		int day;
		int month = 1;
		int year = 2019;
		
		// Find the month
		for(int index = 1; index < 12; index++) {
			
			if(tempNum > numDays(index, 2019)) {

				month ++;
				tempNum -= numDays(index, 2019);
				
			}else
				break;
			
		}
		
		// Find the day
		day = tempNum;
		
		return new Date(day, month, year);
		
	}
	
	// Formats the date
	public String format() {
		
		return String.format("%d/%d/%d", month, day, year);
		
	}

	// toString
	@Override
	public String toString() {
		return "Date [day=" + day + ", month=" + month + ", year=" + year + "]";
	}

}