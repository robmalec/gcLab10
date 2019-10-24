package co.grandcircus;

import java.util.ArrayList;
import java.util.Scanner;

public class CircleApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numCreated = 0, numDeleted = 0;
		Scanner scn = new Scanner(System.in);

		ArrayList<Circle> allCircles = new ArrayList<>();

		System.out.println("Welcome to the Circle Tester");

		char nextMove = 'c';

		// While loop
		while (nextMove != 'q') {
			switch (nextMove) {
			case 'c':
				// Counting number of total circles created
				numCreated++;

				// Getting radius from validator
				Double radius = Validator.getDouble(scn, "Enter radius:", 0.0, Double.MAX_VALUE);

				// Adding radius to list of all circles
				Circle c = new Circle(radius);
				allCircles.add(c);
				c.showInfo(false);

				// Showing user how to later access this circle
				System.out.println("This is circle number " + (allCircles.size()));

				break;
			case 'r':

				if (allCircles.size() > 0) {
					int circNum = 0;

					// If there already exists more than 1 circle, asking which one the viewer would
					// like to see
					if (allCircles.size() > 1) {
						circNum = Validator.getInt(scn,
								"Which circle would you like to review?  Enter a number between 1 and "
										+ allCircles.size() + ": ",
								1, allCircles.size());
						circNum--;
					}

					System.out.println("Here's circle #" + (circNum + 1) + ":");

					allCircles.get(circNum).showInfo(true);
					break;
				} else {
					System.out.println("There are no circles left to review.");
				}
			case 'd':
				// Counting number of circles deleted

				if (allCircles.size() > 0) {
					numDeleted++;
					int circNum = 0;

					// If there already exists more than 1 circle, asking which one the viewer would
					// like to delete
					if (allCircles.size() > 1) {
						circNum = Validator.getInt(scn,
								"Which circle would you like to delete?  Enter a number between 1 and "
										+ allCircles.size() + ": ",
								1, allCircles.size());
						circNum--;
					}

					allCircles.remove(circNum);
					System.out.println("Circle #" + (circNum + 1) + " was successfully deleted.");
					break;
				} else {
					System.out.println("There are no circles left to delete.");
				}

			default:
				System.out.println("That was not a valid option.  Please try again.");
				break;
			}
			System.out.println("");
			System.out.println("What would you like to do?  Type a letter below and hit Enter.\n"
					+ "c: Add a new circle\n" + "r: Review an existing circle\n" + "d: Delete a circle\n"
					+ "q: Exit the program");

			nextMove = scn.next().charAt(0);
		}

		// Indication that the program has ended
		System.out.print("You've created a total of " + numCreated + " " + getPluralOrNot(numCreated));

		if (numDeleted > 0) {
			System.out.print(",\n and deleted a total of " + numDeleted + " " + getPluralOrNot(numDeleted));
		}

		System.out.println(".");

		if (numDeleted > 0) {
			System.out.println("You have a total of " + allCircles.size() + " " + getPluralOrNot(allCircles.size())
					+ " stored in this program at the time of quitting.");
		}

		System.out.println("Goodbye.");
		scn.close();
	}

	static String getPluralOrNot(int number) {
		if (number == 1) {
			return "circle";
		} else {
			return "circles";
		}
	}

}
