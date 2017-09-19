package commandLineInterface.commands.tasks.taskController;

/*
 * *********************************************************************************************
 *
 * Name:			Ross Weinstein
 * Course Number:	SEIS 640-01
 *
 * Description: This class takes the HelpMenu class and turns it into a functioning CLICommand
 *              for our CLI Project. It defines the command name as 'helpMenuBuilder' and
 *              assigns to it the printHelpMenu method within the HelpMenu class.
 *
 * *********************************************************************************************
 */

import commandLineInterface.commands.CLICommand;
import commandLineInterface.commands.tasks.task.HelpMenu;

import java.util.HashMap;
import java.util.Map;

public class HelpMenuController implements CLICommand {

    // to avoid typos, an array to hold the names of the commands
    // this CLICommand class is able to perform
    private String command;

    // HelpMenu is able to build a menu which displays the contents of the other CLICommand
    // command dictionaries
    private HelpMenu helpMenuBuilder;

    /**
     * No arg constructor. It is private in order to force the use of the constructor below.
     */
    private HelpMenuController() {}

    /**
     * Construct a new HelpMenuController from the supplied commandDictionary which holds
     * all the names and descriptions of the other CLICommands with the CLI project
     *
     * @param commandDictionary the master command dictionary composed from all other CLICommand classes
     */
    public HelpMenuController(Map<String, String> commandDictionary) {

        // name the commands this CLICommand is able to perform
        this.command = "help";

        // instantiate a new HelpMenu class with the Map with all the commands and descriptions needed
        // to build the helpMenuBuilder menu
        this.helpMenuBuilder = new HelpMenu(commandDictionary);
    }

    /**
     * Create a Map which will serve as this CLICommand's dictionary stating the name
     * of each command and the function it performs. This is needed for both the
     * helpMenuBuilder menu within our CLI project, but also to identify which commands belong
     * to which class
     *
     * @return the completed Map with all commands and descriptions
     */
    @Override
    public Map<String, String> commandDictionary() {

        // an empty map to hold our commands and descriptions
        Map<String, String> helpDictionary = new HashMap<>();

        // helpMenuBuilder
        helpDictionary.put(this.command, "Shows all available commands and their functionality");

        return helpDictionary;
    }

    /**
     * This CLICommand does not need any command name nor arguments. It just
     * conforms to the CLICommand interface in order to be called easily. This
     * method just calls printHelpMenu from HelpMenu in order to display all
     * the commands and their functions.
     *
     * @param name the name of the desired mathematical operation (unused)
     * @param args the arguments to be given to the desired FunWithStrings method (unused)
     * @return the constructed helpMenuBuilder menu from all the commands and descriptions within the CLI
     */
    @Override
    public String executeCommand(String name, String[] args) {
        return this.helpMenuBuilder.printHelpMenu();
    }
}
