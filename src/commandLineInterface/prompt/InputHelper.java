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

	/**
	 * No arg constructor.
	 */
	public InputHelper() {
		this.input = new Scanner(System.in);
	}

	/**
	 * Prompts user with a specified question and returns their answer
	 * as a String.
	 *
	 * @param question what to display on the console for the user to respond to
	 * @return the user's answer
	 */
	public String askForCommand(String question) {

		System.out.print(question);

		// the user's answer
		String answer = this.input.nextLine();
		return answer;
	}
}
