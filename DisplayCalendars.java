import java.util.Scanner;

public class DisplayCalendars {
	public static void main (String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a year: ");
		int year = input.nextInt();
		System.out.print("Enter the day of the week: ");
		int firstDay = input.nextInt();
		System.out.println("");
		
		for (int i = 1; i < 13; i++) {
			
			String currentMonth = "";
			int length = 31;
			
			if (i == 1) {
				currentMonth = "January";
				length = 31;
			} 
			else if (i == 2) {
				currentMonth = "February";
				if (((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))) {
					length = 29;
				} else {
					length = 28;
				}
			}
			else if (i == 3) {
				currentMonth = "March";
				length = 31;
			}
			else if (i == 4) {
				currentMonth = "April";
				length = 30;
			}
			else if (i == 5) {
				currentMonth = "May";
				length = 31;
			}
			else if (i == 6) {
				currentMonth = "June";
				length = 30;
			}
			else if (i == 7) {
				currentMonth = "July";
				length = 31;
			}
			else if (i == 8) {
				currentMonth = "August";
				length = 31;
			}
			else if (i == 9) {
				currentMonth = "September";
				length = 30;
			}
			else if (i == 10) {
				currentMonth = "October";
				length = 31;
			}
			else if (i == 11) {
				currentMonth = "November";
				length = 30;
			}
			else if (i == 12) {
				currentMonth = "December";
				length = 31;
			}
			
			System.out.println("             " + currentMonth);
			System.out.println("---------------------------------");
			System.out.println("Sun  Mon  Tue  Wed  Thu  Fri  Sat");
			
			firstDay = firstDay % 7;
			
			if (firstDay != 0) {
			    System.out.print(String.format("%" + 5 * firstDay + "s", ""));
			   }
			 
			   for (int j = 1; j <= length; j++) {
			    System.out.printf("%-5d", j);
			 
			    if (firstDay % 7 == 6) {
			     System.out.println("");
			    }
			    firstDay += 1;
			   }
			   
			   System.out.println("");
			   System.out.println("");
			
		}
	}
}
