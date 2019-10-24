package co.grandcircus;

public class Circle {
	private Double radius = 0.0;
	private static String formatNumber(double num) {
		return String.format("%.2f",num);
	}
	
	public Circle() {};
	public Circle(Double radius) {
		this.radius = radius;
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
	public String getFormattedCircumference() {
		return formatNumber(getCircumference());
	}
	public String getFormattedArea() {
		return formatNumber(getArea());
	}
	
}
