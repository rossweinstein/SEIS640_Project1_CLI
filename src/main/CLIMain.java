package main;

/*
 * *********************************************************************************************
 *
 * Name:			Ross Weinstein
 * Course Number:	SEIS 640-01
 *
 * Description: This class is responsible for starting the CLI Project.
 *
 * *********************************************************************************************
 */

import commandLineInterface.CommandLineInterface;

public class CLIMain {
	
	public static void main (String[] args) {
		CommandLineInterface cli = new CommandLineInterface();
		cli.runCLI();
	}
}
