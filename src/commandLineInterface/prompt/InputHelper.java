package commandLineInterface.prompt;

/*
 * *********************************************************************************************
 *
 * Name:			Ross Weinstein
 * Course Number:	SEIS 640-01
 *
 * Description: This class is responsible for the user input.  It is essentially a small wrapper
 *              around the Scanner class.
 *
 * *********************************************************************************************
 */

import java.util.Scanner;

public class InputHelper {

	// a Scanner allows us to get user input from the keyboard
	private Scanner input;

	// no arg constructor, sets up our Scanner
	public InputHelper() {
		this.input = new Scanner(System.in);
	}

	// takes any question and a String and returns the answer as a String
	public String askForCommand(String question) {
		System.out.print(question);
		String answer = this.input.nextLine();
		return answer;
	}
}
