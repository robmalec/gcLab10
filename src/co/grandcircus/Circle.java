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
		for (int y = 0; y < dimension; y++) {
			for (int x = 0; x < dimension; x++) {
				System.out.print(isInCircle(x,y) ? "*" : " ");
			}
			System.out.println("");
		}
		
	}
	private Boolean isInCircle(int x, int y) {
		return ((getSquared(x - (dimension/2)) + getSquared(y - dimension/2)) <= getSquared((int) Math.ceil(radius)));
	}
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
