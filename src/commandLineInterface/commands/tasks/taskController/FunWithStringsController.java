package commandLineInterface.commands.tasks.taskController;

/*
 * *********************************************************************************************
 *
 * Name:			Ross Weinstein
 * Course Number:	SEIS 640-01
 *
 * Description: This class takes the FunWithStrings class and turns it into a functioning
 *              CLICommand for our CLI Project. It defines the command names and assigns to it
 *              certain functions within the FunWithStrings class.
 *
 * *********************************************************************************************
 */

import commandLineInterface.commands.CLICommand;
import commandLineInterface.commands.tasks.task.FunWithStrings;

import java.util.HashMap;
import java.util.Map;

public class FunWithStringsController implements CLICommand {

    // to avoid typos, an array to hold the names of the commands
    // this CLICommand class is able to perform
    private String[] commands;

    // FunWithStrings allows us to perform string manipulations
    private FunWithStrings stringManipulator;

    /**
     * No arg constructor. Sets up this class for use.
     */
    public FunWithStringsController() {

        // name the commands this CLICommand is able to perform
        this.commands = new String[] {"say", "length", "shout", "whisper", "reverse"};

        // instantiate a new FunWithStrings class in order to perform our string manipulations
        this.stringManipulator = new FunWithStrings();
    }

    /**
     * Create a Map which will serve as this CLICommand's dictionary stating the name
     * of each command and the function it performs. This is needed for both the
     * help menu within our CLI project, but also to identify which commands belong
     * to which class.
     *
     * @return the completed Map with all commands and descriptions
     */
    @Override
    public Map<String, String> commandDictionary() {

        // an empty map to hold our commands and descriptions
        Map<String, String> funWithStringsDictionary = new HashMap<>();

        // say
        funWithStringsDictionary.put(commands[0], "Prints the given string to the console");

        // length
        funWithStringsDictionary.put(commands[1], "Prints the length of the given string");

        // shout
        funWithStringsDictionary.put(commands[2], "Prints the given string in all capital letters");

        // whisper
        funWithStringsDictionary.put(commands[3], "Prints the given string in all lower case letters");

        // reverse
        funWithStringsDictionary.put(commands[4], "Prints the reverse of the given string");

        return funWithStringsDictionary;
    }

    /**
     * Based upon the command given, perform the desired string manipulation with the
     * given arguments.
     *
     * @param name the name of the desired string operation (say, length, shout, whisper, reverse)
     * @param args the arguments to be given to the desired FunWithStrings method
     * @return the manipulated string
     */
    @Override
    public String executeCommand(String name, String[] args) {

        // String to hold the expression result
        String output = "";

        // take the arguments and turn them into a single string
        // with spaces between each value
        String argument = String.join(" ", args);

        // say
        if (name.equals(commands[0])) {
            output = argument;

            // length
        } else if (name.equals(commands[1])) {
            output = this.stringManipulator.length(argument);

            // shout
        } else if (name.equals(commands[2])) {
            output = this.stringManipulator.shout(argument);

            // whisper
        } else if (name.equals(commands[3])) {
            output = this.stringManipulator.whisper(argument);

            // reverse
        } else if (name.equals(commands[4])) {
            output = this.stringManipulator.reverse(argument);
        }

        return output;
    }
}
