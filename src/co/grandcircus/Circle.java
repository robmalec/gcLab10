package co.grandcircus;

public class Circle {
	private Double radius = 0.0;
	private final int dimension;
	private static String formatNumber(double num) {
		return String.format("%.2f",num);
	}
	
	public Circle() {dimension = 0;};
	public Circle(Double radius) {
		this.radius = radius;
		dimension = (int) (2 * Math.ceil(radius));
	}
	public Double getCircumference() {
		return (Math.PI * radius * 2);
	}
	public Double getArea() {
		return (Math.PI * Math.pow(radius, 2.0));
	}
	
	/*
	 * Shows all calculated circle information, including the radius if the boolean is set to 'true' (useful when showing details of existing circle)
	 */
	public void showInfo(Boolean showRadius) {
		System.out.println("");
		if (showRadius) {
			System.out.println("Radius: " + formatNumber(radius));
		}
		System.out.println("Circumference: " + getFormattedCircumference());
		System.out.println("Area: " + getFormattedArea());
	}
	public void showCircle() {
		System.out.println("Showing circle with radius rounded up to the nearest unit");
		
		if (radius == 1) {
			System.out.println("*");
		}
		else {
			for (int y = (dimension/4); y < (Math.ceil(0.75*dimension)); y++) {
				for (int x = 0; x < dimension; x++) {
					System.out.print(isInCircle(x,y) ? "*" : " ");
				}
				System.out.println("");
			}
		}
	}
	/*Determines if a given 'pixel' falls within the range of a circle defined by equation x^2 + y^2 = r^2
	Had to fiddle around with this to reproduce the shape of an actual circle in ASCII characters and compensate for the fact that
	I'm not working with perfecty square 'pixels', but I feel this is close enough.*/
	private Boolean isInCircle(int x, int y) {
		
		return ((getSquared(x - (dimension/2)) + Math.round(getSquared((y - dimension/2))*5.2)) <= getSquared((int) Math.ceil(radius)));
	}
	
	//Returns the given input integer squared
	private int getSquared(int input) {
		return (int) Math.pow((double)input,2.0);
	}
	
	
	public String getFormattedCircumference() {
		return formatNumber(getCircumference());
	}
	public String getFormattedArea() {
		return formatNumber(getArea());
	}
	
}
