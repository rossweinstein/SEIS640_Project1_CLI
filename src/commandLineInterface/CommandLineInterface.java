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
	
	private Prompt prompt;
	private CLICommands command;
	
	public CommandLineInterface() {
		this.prompt = new Prompt();
		this.command = new CLICommands();
	}
	
	public void runCLI() {
		
		System.out.println(this.startUpBanner());
		
		boolean runInterface = true;
		
		while (runInterface) {
			this.prompt.getCLICommand();
			
			if (this.prompt.getCommand().equals("quit")) {
				System.out.println("Exiting CLI Program...");
				runInterface = false;
			} else {
				String output = this.command.performCommand(this.prompt.getCommand(), this.prompt.getArguments());
                System.out.println(output);
            }
		}
	}


	private String startUpBanner() {
		return 	"************************************************************************\n" +
				"** SEIS 640-01 | Project 1 - COMMAND LINE INTERFACE | Ross Weinstein  **\n" +
				"**                                                                    **\n" +
				"** type 'help' for list of available commands and their descriptions  **\n" +
				"************************************************************************\n";
	}
}
