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

    // collects all the CLICommands that need to be included within the CLI program.
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

    // make sure we do not have any name collisions, will throw an error if there are two commands with
    // the same name. Program will not crash, but no new commands will be added once an exception is found
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
