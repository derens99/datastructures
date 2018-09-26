package items;
/**
 * Deren Singh
 * This class holds a date and can calculate days after it. It has day, month, and year as instance variables.It can also
 * compare two dates and see which one came before the other. Also, it can see if a year is a leap year, find how many days
 * are in which month, and check a dates validity.
 */
public class Date implements Comparable{
	
	private int day;//The the day of the date
	private int month;//The month of the date
	private int year;//The year of the date
	
	/** Constructor to set all instance variables
	 * @param m - the month getting set
	 * @param d - the day getting set
	 * @param y - the year getting set
	 */
	public Date(int m, int d, int y){
		month = m;
		day = d;
		year = y;
	}
	
	//Getters and setters or Mutator and Accessor methods
	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	/** Method to calculate the next date of a given date
	 * @param date - the date getting calculated for the next day
	 * @return - the next day of the entered date
	 */
	public Date getNextDay(Date date){
		date.incrementDay();
		switch(date.getMonth()){
		case 1:
			if(date.getDay() > 31){
				date.incrementMonth();
			}
		case 2:
			if(isLeapYear(date.getYear())){
				if(date.getDay() > 29){
					date.incrementMonth();
					date.setDay(1);
				}
			}else{
				if(date.getDay() > 28){
					date.incrementMonth();
					date.setDay(1);
				}
			}
		case 3:
			if(date.getDay() > 31){
				date.incrementMonth();
			}
		case 4:
			if(date.getDay() > 30){
				date.incrementMonth();
			}
		case 5:
			if(date.getDay() > 31){
				date.incrementMonth();
			}
		case 6:
			if(date.getDay() > 30){
				date.incrementMonth();
			}
		case 7:
			if(date.getDay() > 31){
				date.incrementMonth();
			}
		case 8:
			if(date.getDay() > 31){
				date.incrementMonth();
			}
		case 9:
			if(date.getDay() > 30){
				date.incrementMonth();
			}
		case 10:
			if(date.getDay() > 31){
				date.incrementMonth();
			}
		case 11:
			if(date.getDay() > 30){
				date.incrementMonth();
			}
		case 12:
			if(date.getDay() > 31){
				date.incrementYear();
				date.setDay(1);
				date.setMonth(1);
			}
			
		}
		return new Date(date.getMonth(), date.getDay(), date.getYear());
	}
	
	/** Method to get an entered amount of days after
	 * @param d - the date getting calculated
	 * @param days - the amount of days after the entered date
	 * @return - a date of how many days after
	 */
	public Date getNextEnteredDay(Date d, int days){
		Date newDate = new Date(d.getMonth(), d.getDay(), d.getYear());
		for(int i = 0; i < days; i++){
			newDate.getNextDay(newDate);
		}
		return newDate;
	}
	//Method to add a day
	public void incrementDay(){
		day++;
	}
	//Add a month
	public void incrementMonth(){
		day = 0;
		month++;
	}
	//Add a year
	public void incrementYear(){
		year++;
	}
	
	/** toString method to print class information
	 * @return - a string of the classes information
	 */
	public String toString(){
		return month+"/"+day+"/"+year;
	}
	
	/** Check if a given year is a leap year
	 * @param y - the entered year
	 * @return - a boolean if the entered year is a leap year
	 */
	public static boolean isLeapYear(int y){
		return (y % 4 == 0 && y % 100 != 0) || y % 400 == 0;
	}

	/** Method to see which objects come before another
	 * @param o - the object getting compared
	 * @return - an integer. If positive, first object comes before, if negative, second object comes first, else, objects are equal
	 */
	public int compareTo(Object o) {
		if(o instanceof Date){
			if(year != ((Date)o).getYear()){
				return year - ((Date)o).getYear();
			}else if(month != ((Date)o).getMonth()){
				return month - ((Date)o).getMonth();
			}else if(day != ((Date)o).getDay()){
				return day - ((Date)o).getDay();
			}else{
				return 0;
			}
		}else{
			throw new IllegalStateException("Data types do not match!");
		}
			
	}
	
	/** Method to find the amount of days in a certain month
	 * @param m - the month entered
	 * @param y - the year entered
	 * @return - the amount of days in a month
	 */
	public static int daysInMonth(int m, int y){
		if(m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12){
			return 31;
		}else if(m == 4 || m == 6 || m == 9 || m == 11){
			return 30;
		}else if(m == 2 && isLeapYear(y)){
			return 29;
		}else{
			return 28;
		}
	}
	
	/** Method to validate a Date 
	 * @param m - the month entered
	 * @param d - the day entered
	 * @param y - the year entered
	 */
	public static void validDate(int m, int d, int y){
		if(y < 0 || m > 12 || m < 1 || d > daysInMonth(m,y) || d < 0 ){
			throw new IllegalArgumentException("");
		}
	}
	
	
}
