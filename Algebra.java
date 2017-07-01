//Algebra: 2x2 Linear Equations
//Program By: Chris Huynh

import java.util.Scanner;

public class Algebra {
	
	public static class LinearEquation {
		
		private double a, b, c, d, e, f;	//values of system of linear equations
		
		public LinearEquation(double a, double b, double c, double d, double e, double f) { 	//constructor assigns values of a, b, c, d, e, f
			
			this.a = a;
			this.b = b;
			this.c = c;
			this.d = d;
			this.e = e;
			this.f = f;
		}
		
		public double getA(){				//gets value of a
			return this.a;
		}
		
		public double getB(){				//gets value of b
			return this.b;
		}
		
		public double getC(){				//gets value of c
			return this.c;
		}
		
		public double getD(){				//gets value of d
			return this.d;
		}
		
		public double getE(){				//gets value of e
			return this.e;
		}
		
		public double getF(){				//gets value of f
			return this.f;
		}	
		
		public boolean isSolvable(){		//checks if equation is solvable with values given
			
			if (((a*d) - (b*c)) != 0) {		//if a*b-b*c is not 0 then equation is solvable
				return true;
			} else {
				return false;
			}
		}
		
		public double getX() {				//calculates y solution
			double solution = (e*d-b*f) / (a*d - b*c);
			return solution;
		}
		
		public double getY() {
			
			if (isSolvable()) {				//calculates y solution
				double solution = (a*f-e*c) / (a*d-b*c);
				return solution;
			} else {
				return -1;
			}
		}
	}
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter a, b, c, d, e, f: ");
		
		double a = input.nextDouble();		//gets a, b, c, d, e, and f from input
		double b = input.nextDouble();
		double c = input.nextDouble();
		double d = input.nextDouble();
		double e = input.nextDouble();
		double f = input.nextDouble();
		
		LinearEquation equation = new LinearEquation(a, b, c, d, e, f);					//creates new LinearEquation object
		
		if (equation.isSolvable()) {													//checks if equation is solvable with values given
			
			System.out.println("x = " + equation.getX() + "  y = " + equation.getY());	//if solvable, output solution
		} else {
			
			System.out.println("The equation has no solution");							//if not solvable, output no solution
		}
	}
}
