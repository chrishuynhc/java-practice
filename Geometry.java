//9.9 Geometry: n-sided Regular Polygon
//Program By: Chris Huynh

public class Geometry {
	
	public static class RegularPolygon {
		
		private int n = 3;					//private default values of polygon
		private double side = 1;
		private double x = 0;
		private double y = 0;
		
		public RegularPolygon() {}			//default constructor
		
		public RegularPolygon(int number, double length) {						//constructor creates polygon with number of sides and length
			
			this.n = number;
			this.side = length;
			this.x = 0;
			this.y = 0;
		}
		
		public RegularPolygon(int number, double length, double x, double y) {	//constructor creates polygon with number of sides, length of side, and x/y coordinates
			
			this.n = number;
			this.side = length;
			this.x = x;
			this.y = y;
		}
		
		public int returnNumber() {				//gets number of sides
			
			return this.n;
		}
		
		public void setNumber(int number) {		//sets number of sides
			
			this.n = number;
		}
		
		public double returnSide() {			//gets length of side
			
			return this.side;
		}
		
		public void setSide(double length) {	//sets length of side
			
			this.side = length;
		}
		
		public double returnX() {				//gets x coordinate
			return this.x;
		}
		
		public void setX(double x) {			//sets x coordinate
			
			this.x = x;
		}
		
		public double returnY() {				//gets y coordinate
			
			return this.y;
		}
		
		public void setY(double y) { 			//sets y coordinate
			
			this.y = y;
		}
		
		public double getPerimeter() {			//calculates perimeter of polygon
			double perimeter = this.n * this.side;
			return perimeter;
		}
		
		public double getArea(){				//calculates area of polygon
			double area = (this.n * Math.pow(this.side,2)) / (4 * Math.tan(Math.PI/this.n));
			return area;
		}
	}
	
	public static void main (String[] args) {
		
		RegularPolygon polygonOne = new RegularPolygon();					//default polygon object
		RegularPolygon polygonTwo = new RegularPolygon(6, 4);				//polygon object w/ 6 sides, length 4 each
		RegularPolygon polygonThree = new RegularPolygon(10, 4, 5.6, 7.8);	//polygon object w/ 10 sides, length 4 each, at coordinates (5.6, 7.8)
		
		System.out.println("Polygon One => Perimeter: " + polygonOne.getPerimeter() + " Area: " + polygonOne.getArea());		//outputs perimeter and area of each object
		System.out.println("Polygon Two => Perimeter: " + polygonTwo.getPerimeter() + " Area: " + polygonTwo.getArea());
		System.out.println("Polygon Three => Perimeter: " + polygonThree.getPerimeter() + " Area: " + polygonThree.getArea());
	}
}
