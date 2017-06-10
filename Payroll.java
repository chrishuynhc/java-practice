import java.util.Scanner;

public class Payroll {
	public static void main (String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter employee's name: ");
		String name = input.nextLine();
		System.out.print("Enter number of hours worked in a week: ");
		float hours = input.nextFloat();
		System.out.print("Enter hourly pay rate: ");
		float hourlyPay = input.nextFloat();
		System.out.print("Enter federal tax withholding rate: ");
		float fedTax = input.nextFloat();
		System.out.print("Enter state tax withholding rate: ");
		float stateTax = input.nextFloat();
		System.out.println("");
		
		float fedRate = fedTax * 100;
		float stateRate = stateTax * 100;
		float grossPay = hours * hourlyPay;
		float fedWithholding = fedTax * grossPay;
		float stateWithholding = stateTax * grossPay;
		float totalDeductions = fedWithholding + stateWithholding;
		float netPay = grossPay - totalDeductions;
		
		System.out.println("Employee Name: " + name);
		System.out.println("Hours worked: " + hours);
		
		System.out.print("Pay Rate: $");
		System.out.printf("%.2f", hourlyPay);
		System.out.println("");
		
		System.out.print("Gross Pay: $");
		System.out.printf("%.2f", grossPay);
		System.out.println("");
		
		System.out.println("Deductions: ");
		System.out.print("   Federal Witholding (" + fedRate + "%): $");
		System.out.printf("%.2f", fedWithholding);
		System.out.println("");
		
		System.out.print("   State Witholding (" + stateRate + "%): $");
		System.out.printf("%.2f", stateWithholding);
		System.out.println("");
		
		System.out.print("   Total Deductions: $");
		System.out.printf("%.2f", totalDeductions);
		System.out.println("");
		
		System.out.print("Net Pay: $");
		System.out.printf("%.2f", netPay);
		System.out.println("");	
	}
}
