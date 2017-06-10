import java.util.Scanner;

public class DaysOfAMonth {
	
	public static void main (String[] args) {
		
		Scanner input = new Scanner(System.in);											
		System.out.print("Enter a year: ");												//input year
		int year = input.nextInt();
		
		System.out.print("Enter a month: ");											//input month
		String month = input.next();
		
		boolean leapYear = ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0));	//checks if current year is a leap year
		
		switch (month) { 																//months with 31 days
			case "Jan":																	//if month selected, print out 31 days
			case "Mar":													
			case "May":
			case "Jul":
			case "Aug":
			case "Oct":
			case "Dec":
				System.out.println(month + " " + year + " " + "has 31 days");
				break;
			case "Apr":																	//months with 30 days
			case "Jun":																	//if month selected, print out 30 days
			case "Sep":
			case "Nov":
				System.out.println(month + " " + year + " " + "has 30 days");
				break;
			case "Feb":																	//Feb has 28 days
				if (leapYear) {
					System.out.println(month + " " + year + " " + "has 29 days");		//however, if leap year, print 29 days
				}
				else {
					System.out.println(month + " " + year + " " + "has 28 days");		//if not leap year, print 28 days
				}
		}
	}
}
