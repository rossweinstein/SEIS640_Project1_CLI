package commandLineInterface.commands;

/*
 * *********************************************************************************************
 * 
 * Name:				Ross Weinstein
 * Course Number:	SEIS 640-01
 * 
 * Description: This class is responsible for executing the different commands the 
 * 				CLI is able to perform.
 * 
 * *********************************************************************************************
 */

import commandLineInterface.commands.tasks.taskController.HelpMenuController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CLICommands {

	// this is the master list of all the commands the CLI is able to perform
	private List<CLICommand> commands;

	// a map to hold the commands and a description of their functionality
	private Map<String, String> commandDictionary;

	// no arg constructor, it populates the commands variable with all the CLI
	// Commands found within CommandCollection
	public CLICommands() {

		this.commands = CommandCollection.getAllCommands();
		this.commandDictionary = this.buildCommandDictionary();

		/*
		Once all the commands are placed in the dictionary,
        the help menu is created so each command can be displayed with
        its description
         */
        CLICommand help = new HelpMenuController(this.commandDictionary);
        this.commands.add(help);
	}

	// build the master command dictionary by combining all the command
	// dictionaries from each individual CLICommand class
	private Map<String, String> buildCommandDictionary() {

		// an empty map to hold all the different command names and descriptions
		Map<String, String> dictionary = new HashMap<>();

		for (CLICommand commands : this.commands) {
			dictionary.putAll(commands.commandDictionary());
		}

		/*
		 quit is added here because it is not apart of a CLICommand class
		 its only function is to end the loop, so it is added here to be included
		 in the help menu when displayed in the program
		  */
		dictionary.put("quit", "Leave CLI program");

		return dictionary;
	}

	// this method finds what class the supplied command is found within and
	// executes that command with the supplied arguments, if needed
	public String performCommand(String command, String[] args) {

		// search the available commands for one that matches the supplied command,
		// return null if no match is found
		CLICommand selectedCommand = findSelectedCommand(command);

		return selectedCommand != null ? selectedCommand.executeCommand(command, args) : "BAD COMMAND";
	}

	// searches the possible CLI commands for a match, returns null if no command is found
	private CLICommand findSelectedCommand(String command) {

		for (CLICommand eachCommand: this.commands) {
			if (eachCommand.commandDictionary().containsKey(command)) {
				return eachCommand;
			}
		}
		return null;
	}
}
