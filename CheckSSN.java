import java.util.Scanner;

public class CheckSSN {
	
	public static void main (String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a SSN: ");			//input SSN
		String ssn = input.next();					
		
		if (Character.isDigit(ssn.charAt(0)) &&		//checks if first character is a digit
			Character.isDigit(ssn.charAt(1)) &&		//checks if second character is a digit
			Character.isDigit(ssn.charAt(2)) &&		//checks if third character is a digit
			(ssn.charAt(3) == '-') &&				//checks if fourth character is a dash
			Character.isDigit(ssn.charAt(4)) &&		//checks if fifth character is a digit
			Character.isDigit(ssn.charAt(5)) &&		//checks if sixth character is a digit
			(ssn.charAt(6) == '-') &&				//checks if seventh character is a dash
			Character.isDigit(ssn.charAt(7)) &&		//checks if eighth character is a digit
			Character.isDigit(ssn.charAt(8)) &&		//checks if ninth character is a digit
			Character.isDigit(ssn.charAt(9)) &&		//checks if tenth character is a digit
			Character.isDigit(ssn.charAt(10))) {	//checks if eleventh character is a digit
			 
			System.out.println(ssn + " is a valid social security number");	 	//if all conditions satisfied, valid SSN
		} else {
			System.out.println(ssn + " is an invalid social security number");	//if not all conditions satisfied, invalid SSN
		}	
	}
}

