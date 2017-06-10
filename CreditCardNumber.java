import java.util.Scanner;

public class CreditCardNumber {
	public static void main (String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a credit card number as a long integer: ");
		long creditCard = input.nextLong();
		System.out.println("");
		System.out.println("Input - " + creditCard);
		
		System.out.println("Step 1 - Doubling every second digit from right to left");
		for (int i = (getSize(creditCard)); i >= 2; i -= 2) {
			System.out.print(getDigit(2 * getCertainDigit(creditCard, i)) + " ");
		}
		System.out.println("");
		
		System.out.println("Step 2 - Adding all digits from step 1");
		System.out.println(sumOfDoubleEvenPlace(creditCard));
		
		System.out.println("Step 3 - Adding all odd digits");
		System.out.println(sumOfOddPlace(creditCard));
		
		int oddEvenSum = sumOfDoubleEvenPlace(creditCard) + sumOfOddPlace(creditCard);
		
		System.out.println("Step 4 - Adding odd and even total");
		System.out.println(sumOfDoubleEvenPlace(creditCard) +  " + " + sumOfOddPlace(creditCard) + " = "  + oddEvenSum);
		
		System.out.println("Step 5 - Checking validity of card");
		if (isValid(creditCard)) {
			System.out.println(oddEvenSum + " divisible by 10. " + creditCard + " is valid.");
		} else {
			System.out.println(oddEvenSum + " not divisible by 10. " + creditCard + " is invalid.");
		}
	}
	
	public static boolean isValid (long number) {
		
		int prefix = (int) getPrefix(number, 1);
		
		if ((sumOfDoubleEvenPlace(number) + sumOfOddPlace(number)) % 10 != 0) {
			return false;
		}
		else if (prefix !=4 && prefix != 5 && prefix != 6) {
			return false;
		}
		else if (prefix == 3) {
			int secondDigit = (int) getPrefix(number, 2);
			if (secondDigit != 37) {
				return false;
			}
		} 
		return true;
	}
	
	public static int sumOfDoubleEvenPlace (long number) {
		
		int total = 0;
		
		for (int i = 2; i <= (getSize(number)); i += 2) {
			total += getDigit(2 * getCertainDigit(number, i));
		}
		return total;	
	}
	
	public static int sumOfOddPlace (long number) {
		int total = 0;
		
		for (int i = 1; i <= (getSize(number)); i += 2) {
			total += getCertainDigit(number, i);
		}
		return total;
	}
	
	public static boolean prefixMatched (long number, int d) {
		
		if (getPrefix(number, getSize(d)) == d) {
			return true;
		} else {
			return false;
		}
	}
	
	public static int getSize (long d) {
		int length = String.valueOf(d).length();
		return length;
	}
	
	public static long getPrefix (long number, int k) {
		return number / (long) (Math.pow(10.0, (double) (getSize(number) - k)));
	}
	
	public static int getCertainDigit(long number, int index) {
		return (int) (((number / Math.pow(10, index - 1))) % 10);
	}
	
	public static int getDigit (int number) {
		
		if ((number / 10) == 0) {					//If the first digit = 0, return the number
			return number;
		} else {									//Else, return first digit + second digit
			return (number / 10) + (number % 10);
		}
	}
}
