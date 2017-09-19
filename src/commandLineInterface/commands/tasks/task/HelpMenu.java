package commandLineInterface.commands.tasks.task;

/*
 * *********************************************************************************************
 *
 * Name:			Ross Weinstein
 * Course Number:	SEIS 640-01
 *
 * Description: This class is responsible for putting together a help menu within the CLI project.
 *              It will take the master command dictionary from all over CLICommands and combines
 *              those commands into easily readable list to display the command names and their
 *              associated functions.
 *
 * *********************************************************************************************
 */

import java.util.Map;
import java.util.TreeMap;

public class HelpMenu {

    // the master list of all commands from each CLICommand
    private Map<String, String> commandDictionary;

    /**
     *
     *
     * @param commandDictionary
     */
    public HelpMenu(Map<String, String> commandDictionary) {
        this.commandDictionary = new TreeMap<>(commandDictionary);
    }

    /**
     * The completed CLI help menu with each command and its function
     *
     * @return the CLI help menu with each command and its function
     */
    public String printHelpMenu() {
        return this.helpBanner() + "\n" + this.header() + "\n" + this.helpCommandList()
                + "\n" + this.drawDivider('*', 72) + "\n";
    }

    /**
     * Creates a banner with a divider of '*' along with a description of the menu
     *
     * @return a sep
     */
    private String helpBanner() {
        return "\n" + this.drawDivider('*', 72) + "\n" +
                 "HELP MENU: CLI commands and their function descriptions\n";

    }

    /**
     * Create a header for the table with labels for the commands and descriptions
     *
     * @return a header for the helpCommandList table
     */
    private String header() {
        return "command\t\t|\tdescription" +
                "\n" + this.drawDivider('-', 72);
    }

    /**
     * For all the commands provided from the other CLICommand classes, create a table
     * which includes each command and their function
     *
     * @return a table which states each command and their function
     */
    private String helpCommandList() {

        // empty string to populate with table
        String output = "";

        for (String key: this.commandDictionary.keySet()) {

            // depending on the length of the command, add one or two
            // tabs to keep the table lined up correctly
            String spacer = key.length() > 5 ? "\t" : "\t\t";

            output += "  "+ key + spacer + "|\t" + this.commandDictionary.get(key) + "\n";
        }
        return output;
    }

    /**
     * Create a String of a single repeated character x amount of times used in this
     * program as a divider
     *
     * @param repeatingCharacter the character to be repeated
     * @param timesRepeated the number of times the character is to be repeated
     * @return a single line of the specified character repeated x amount of times
     */
    private String drawDivider(char repeatingCharacter, int timesRepeated) {
        String output = "";
        for (int i = 0; i < timesRepeated; i++) {
            output += repeatingCharacter;
        }
        return output;
    }
}
