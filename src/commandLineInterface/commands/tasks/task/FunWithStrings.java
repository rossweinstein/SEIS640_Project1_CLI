package commandLineInterface.commands.tasks.task;

/*
 * *********************************************************************************************
 *
 * Name:			Ross Weinstein
 * Course Number:	SEIS 640-01
 *
 * Description: This class is responsible for very basic string manipulation.  It can print
 *              strings to the console, find how long a string is, capitalize and lower case
 *              entire strings and reverse a string.
 *
 * *********************************************************************************************
 */

public class FunWithStrings {

	/**
	 * No arg constructor.
	 */
	public FunWithStrings() {}

	/**
	 * Finds the length of the given string
	 *
	 * @param words the String to find the length of
	 * @return the length of the given string
	 */
	public String length(String words) {
		return String.valueOf(words.length());
	}

	/**
	 * Takes any character that is not uppercase and makes them uppercase
	 *
	 * @param words the String to manipulate
	 * @return a String with all uppercase letters
	 */
	public String shout(String words) {
		return words.toUpperCase();
	}

	/**
	 * Takes any character that is not lowercase and makes them lowercase
     *
	 * @param words the String to manipulate
	 * @return a String with all lowercase letters
	 */
	public String whisper(String words) {
		return words.toLowerCase();
	}

	/**
	 * Reverses the characters of a String.
     *
	 * @param words the String to manipulate
	 * @return a String with all the characters in reverse order
	 */
	public String reverse(String words) {

		// empty String to hold our reversed word
		String reversedWord = "";

		// loop through joinedWords backwards, adding each character
        // to reversedWord
		for (int i = words.length() - 1; i >= 0; i--) {
			reversedWord += String.valueOf(words.charAt(i));
		}
		return reversedWord;
	}
}
