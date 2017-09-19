package commandLineInterface.commands;

/*
 * *********************************************************************************************
 * 
 * Name:			Ross Weinstein
 * Course Number:	SEIS 640-01
 * 
 * Description: This interface is responsible for the actions a command within my command line
 * 				interface project can perform.
 * 
 * *********************************************************************************************
 */

import java.util.Map;

public interface CLICommand {

	// within each class, what are the names of each command and what can they perform
	public Map<String, String> commandDictionary();

	// for any command to execute, you need the command name and the arguments, if any
	public String executeCommand(String name, String[] args);
}
