package commandLineInterface.prompt;

/*
 * *********************************************************************************************
 *
 * Name:			Ross Weinstein
 * Course Number:	SEIS 640-01
 *
 * Description: This class is responsible for the command prompt. It is reposinble for displaying
 *              the prompt, receiving user input, and separating that input into commands and
 *              arguments.
 *
 * *********************************************************************************************
 */

import java.util.Arrays;

public class Prompt {

	/*
	The prompt variable holds the icon that is printed
	on the screen showing that the cli program is running
	 */
	private String prompt;

	/*
	The command is responsible for the command the user
	wants to run, it may have zero of more arguments
	 */
	private String command;

	//
	/*
	The arguments are the optional parameters that may
	be needed for certain commands
	 */
	private String[] arguments;

	/*
	The InputHelper class sets up a Scanner and a simple way
	to get Strings as input from the user
	 */
	private InputHelper input;

	/**
	 * No arg constructor.
	 */
	public Prompt() {
		this.prompt = ">>>";
		this.command = "";
		this.arguments = null;
		this.input = new InputHelper();
	}

	/**
	 * Getter for command variable
	 *
	 * @return the CLI command the user wants to perform
	 */
	public String getCommand() {
		return this.command;
	}

	/**
	 * Getter for the arguments variable
	 *
	 * @return the arguments, if any, for the specified command
	 */
	public String[] getArguments() {
		return arguments;
	}

	/**
	 * Reads the String given at the CLI and separates the
	 * command and its arguments, populating the appropriate variables
	 */
	public void getCLICommand() {

		// prompt the user to enter a command and return their answer as a String
		String givenCLICommand = this.input.askForCommand(this.prompt + " ");

		// takes in a string and trims its whitespace
		String trimmedCommand = givenCLICommand.trim();

		if (trimmedCommand.length() > 0) {

			// takes the supplied string and separates the words into an array based on the
			// spaces
			String[] givenCommand = givenCLICommand.split(" ");

			// clean array of empty values, this will happen if there are multiple spaces
            // between entries
            givenCommand = Arrays.stream(givenCommand)
                    .filter(entry -> entry != null && entry.length() > 0)
                    .toArray(String[]::new);

			// gives that array to the method where the command and arguments can be
			// appropriately separated
			getCommandAndArguments(givenCommand);
		}
	}

	// if we have a command, set the instance variable to it and set our
	// arguments variable if we have arguments

	/**
	 * Separate the command and arguments, placing them in their
	 * specified variables
	 *
	 * @param givenCommand the array containing the input from the user
	 */
	private void getCommandAndArguments(String[] givenCommand) {

	    // set first supplied value as the command
		this.command = givenCommand[0];

		// set the remaining values as the array of arguments
		if (givenCommand.length > 1) {
			this.arguments = Arrays.copyOfRange(givenCommand, 1, givenCommand.length);
		}
	}
}
