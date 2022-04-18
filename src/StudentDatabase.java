//Task: Write a program that will recognize invalid inputs when the user requests
//information about students in a class.
//
//What will the application do?
// * Provide information about students in a class of at least 10 people
// * Prompt the user to ask about a particular student
// * Give proper responses according to user-submitted information
// * Ask if the user would like to learn about another student
// * Validate user choices and ask again if they provide an invalid number or
//information type.
//Build Specifications
//1. Account for invalid user input with exceptions
//2. Try to incorporate IndexOutOfBoundsException
//
//Extended Challenges:
// * Create other exceptions and catch those too!

import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentDatabase {

	private static String[] hometown = { "Mould-on-the-Wold", "Islington", "Godric's Hollow", " Great Britain",
			"Godric's Hollow", "The Burrow", "Unknown", "Detroit", "", "Leeds", "Sheffield", "Birmingham", "ThatPlace",
			"Nottingham", "Worcester", "Google It", "Unknown", "Preston", "Godric's Hollow", "West Bloomfield" };
	private static String[] studentName = { "Dumbledore, Albus", "Black, Sirius", "Potter, James",
			"Longbottom, Neville", "Potter, Harry", "Weasley, Ronald", "Creevey, Colin", "Newt Scamander",
			"Nymphadora Tonks", "Bones, Susan", "Chang, Cho", "Corner, Michael", "Lovegood, Luna", "Malfoy, Lucius",
			"Malfoy, Draco", "Crabbe, Vincent", "Goyle, Gregory", "Parkinson, Pansy", "Albus Severus Potter",
			"Malik, Dimitri" };
	private static String[] favoriteFood = { "Steak", "Steak", "Steak", "Steak", "Steak", "Steak", "Steak", "Twinkies",
			"Twinkies", "Twinkies", "Tea and Biscuits", "Tea and Biscuits", "Tea and Biscuits", "Hard Boiled Eggs",
			"Hard Boiled Eggs", "Hard Boiled Eggs", "Hard Boiled Eggs", "Hard Boiled Eggs", "Hard Boiled Eggs",
			"Ice Cream" };

	private static int userSelection = -1;
	private static String nameInquiry = "";
	private static String hometownInquiry = "";
	private static String foodInquiry = "";
	private static String studentFirstName = "";
	private static boolean keepGoing = true;

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		while (keepGoing) {
			printWelcomeMsg();
			setUserInquiryVariables(scnr);
			printNameInquiryMsg();
			nextInquiryMsg(scnr);
			keepGoing(scnr);
		}
		System.out.println("Thanks. Goodbye!");
	}

	private static void printWelcomeMsg() {
		System.out.print(
				"Welcome to Hogwarts. Which student would you like to learn more about? (enter a number from 1-20) ");
	}

	private static void setUserInquiryVariables(Scanner scnr) {
		try {
			userSelection = scnr.nextInt();
			nameInquiry = studentName[userSelection - 1];
			hometownInquiry = hometown[userSelection - 1];
			foodInquiry = favoriteFood[userSelection - 1];
			studentFirstName = nameInquiry.substring((nameInquiry.indexOf(" ") + 1));
		} catch (IndexOutOfBoundsException | InputMismatchException e) {
			System.out.println("Forbidden: Please enter a number from 1-20");
			scnr.nextLine();
			setUserInquiryVariables(scnr);
		}
	}

	private static void keepGoing(Scanner scnr) {
		boolean goOn = false;
		do {
			System.out.println("Would you like to continue searching? (enter \"yes\" or \"no\")");
			String str = scnr.nextLine();
			if (str.equalsIgnoreCase("yes")) {
				keepGoing = true;
				goOn = false;
			} else if (str.equalsIgnoreCase("no")) {
				keepGoing = false;
				goOn = false;
			} else {
				goOn = true;
				System.out.println("Please enter valid input");
			}
		} while (goOn);
	}

	private static void printNameInquiryMsg() {
		System.out.println("Student " + userSelection + " is " + nameInquiry + ".");
	}

	private static void printFoodInquiryMsg() {
		System.out.println(studentFirstName + "'s favorite food is " + foodInquiry + ".");
	}

	private static void printHometownMsg() {
		System.out.println(studentFirstName + " is from " + hometownInquiry + ".");
	}

	private static void nextInquiryMsg(Scanner scnr) {
		boolean loop = false;
		do {
			System.out.println("What would you like to know about " + studentFirstName
					+ "? (enter \"hometown\" or \"favorite food\") ");
			scnr.nextLine();
			String nextInquiry = scnr.nextLine();
			if (nextInquiry.equalsIgnoreCase("hometown")) {
				printHometownMsg();
				loop = false;
			} else if (nextInquiry.equalsIgnoreCase("favorite food")) {
				printFoodInquiryMsg();
				loop = false;
			} else {
				System.out.println("Please enter valid input. ");
				loop = true;
			}
		} while (loop);
	}
}