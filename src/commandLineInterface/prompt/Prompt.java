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

	// the prompt variable holds the icon that is printed on the screen showing
	// that the cli program is running
	private String prompt;

	// the command is responsible for the command the user wants to run, it may
	// have zero of more arguments
	private String command;

	// the arguments are the optional parameters that may be needed for certain
	// commands
	private String[] arguments;

	// the InputHelper class sets up a Scanner and a simple way to get Strings
	// as input from the user
	private InputHelper input;

	// no arg constructor, sets the prompt to '>>>', sets command to an empty
	// string, and sets the arguments to null
	public Prompt() {
		this.prompt = ">>>";
		this.command = "";
		this.arguments = null;
		this.input = new InputHelper();
	}

	// getter for the command variable, gets the current command as a String
	public String getCommand() {
		return this.command;
	}

	// getter for the arguments variable, gets arguments, if they exits, as an
	// array
	public String[] getArguments() {
		return arguments;
	}

	// this method reads the string given at the command line and separates the
	// command and the arguments, populating the appropriate variables
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
	private void getCommandAndArguments(String[] givenCommand) {

	    // set first supplied value as the command
		this.command = givenCommand[0];

		// set the remaining values as the array of arguments
		if (givenCommand.length > 1) {
			this.arguments = Arrays.copyOfRange(givenCommand, 1, givenCommand.length);
		}
	}
}
