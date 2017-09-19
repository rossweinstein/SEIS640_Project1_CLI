package commandLineInterface;

/*
 * *********************************************************************************************
 *
 * Name:			Ross Weinstein
 * Course Number:	SEIS 640-01
 *
 * Description: This class is responsible for bringing the whole CLI Project together. It has a
 *              prompt for getting user input and formatting that input. Once the input is
 *              correctly formatted, it passes that input to the CLICommands class which is able
 *              to give that input to the correct method for the desired result.
 *
 * *********************************************************************************************
 */

import commandLineInterface.commands.CLICommands;
import commandLineInterface.prompt.Prompt;

public class CommandLineInterface {

	/*
	The prompt is responsible for getting user input and
	separating that input into commands and arguments
	 */
	private Prompt prompt;

	/*
	The master list of all the commands. Where the commands
	and arguments collected from the prompt will be given
	in order to perform different functions.
	 */
	private CLICommands command;

    /**
     * No arg constructor.
     */
	public CommandLineInterface() {
		this.prompt = new Prompt();
		this.command = new CLICommands();
	}

    /**
     * Where the command line interface loop resides. It prints the banner, signaling that
     * the program is running and takes as many commands until the user enters 'quit' to
     * end the program.
     */
	public void runCLI() {

	    // print the startUpBanner
		System.out.println(this.startUpBanner());

		// sentinel for our CLI loop
		boolean runInterface = true;
		
		while (runInterface) {

		    // get user input and separate that input into a command and arguments
			this.prompt.getCLICommand();

			// end program loop if the command is quit
			if (this.prompt.getCommand().equals("quit")) {
				System.out.println("Exiting CLI Program...");
				runInterface = false;

			} else {
			    // get the result of our command and function, printing it to the screen
				String output = this.command.performCommand(this.prompt.getCommand(), this.prompt.getArguments());
                System.out.println(output);
            }
		}
	}

    /**
     * Creates a simple banner to show that the CLI program has started. States
     * the class, project name, my name, and informs the user of the help menu
     *
     * @return the banner to be shown when the CLI program starts
     */
	private String startUpBanner() {
		return 	"************************************************************************\n" +
				"** SEIS 640-01 | Project 1 - COMMAND LINE INTERFACE | Ross Weinstein  **\n" +
				"**                                                                    **\n" +
				"** type 'help' for list of available commands and their descriptions  **\n" +
				"************************************************************************\n";
	}
}
