package commandLineInterface.commands;

/*
 * *********************************************************************************************
 * 
 * Name:			Ross Weinstein
 * Course Number:	SEIS 640-01
 * 
 * Description: Here is where new commands can be added to the CLI program. Just add a new
 * 				CLICommand to the list and it will be accessible within the program. Note that
 * 			    in order to avoid having two commands with the same name use the helper function
 *              to ensure that all names are unique.
 * 
 * *********************************************************************************************
 */

import java.util.*;

import commandLineInterface.commands.tasks.taskController.BasicMathController;
import commandLineInterface.commands.tasks.taskController.FunWithStringsController;

public class CommandCollection {

    /**
     * Collect all the CLICommands that need to be included within the CLI program. Each
     * command is checked to ensure that all command names are unique. If any names are
     * duplicates, throws an exception and stops adding commands to list.
     *
     * @return the collected list of all CLICommands
     */
    public static List<CLICommand> getAllCommands() {
        List<CLICommand> commandList = new ArrayList<>();
        try {

            /*
            !!!ADD NEW CLI COMMANDS HERE!!!

            be sure to user the helper method onlyIfAllCommandNamesUnique to avoid name collision
             */
            commandList.add(onlyIfAllCommandNamesUnique(commandList, new BasicMathController()));
            commandList.add(onlyIfAllCommandNamesUnique(commandList, new FunWithStringsController()));


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return commandList;
    }

    /**
     * Checks that there are no duplicates names within our commandList.
     *
     * @param commandList the list to check duplicate names against
     * @param command the new command names to be verified for uniqueness
     * @return the new Command, if verified; exception if any name collision
     * @throws Exception when we try to add a new command where the already exists
     *                  a command with that same name
     */
    private static CLICommand onlyIfAllCommandNamesUnique(List<CLICommand> commandList, CLICommand command) throws Exception {

        for (CLICommand eachCurrentCommand : commandList) {

            // gets all the names of that we currently have available in the CLI program
            Set<String> currentCommands = new HashSet<>(eachCurrentCommand.commandDictionary().keySet());

            // adds the two reserved names to that list
            currentCommands.add("help");
            currentCommands.add("quit");

            // get all the names that we want to add to the list
            Set<String> proposedCommands = new HashSet<>(command.commandDictionary().keySet());

            // if we have a two commands with the same name
            if (!Collections.disjoint(currentCommands, proposedCommands)) {

                // find that name and report it
                currentCommands.retainAll(proposedCommands);
                throw new Exception("\nWARNING!!!\n" +
                        "Error adding new CLI Command. Command " + currentCommands + " already exists. " +
                        "\nYou must change this command name before any new commands may be added to the CLI program.\n");
            }
        }
        return command;
    }
}
