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
	 *
	 * @param words
	 * @return
	 */
	public String length(String words) {
		return String.valueOf(words.length());
	}

	/**
	 *
	 * @param words
	 * @return
	 */
	public String shout(String words) {
		return words.toUpperCase();
	}

	/**
	 *
	 * @param words
	 * @return
	 */
	public String whisper(String words) {
		return words.toLowerCase();
	}

	/**
	 * Takes in a given
     *
	 * @param words
	 * @return
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

	/**
	 *
	 *
	 * @param arguments
	 * @return
	 */
	private String joinWords(String[] arguments) {
		return String.join(" ", arguments);
	}

}
