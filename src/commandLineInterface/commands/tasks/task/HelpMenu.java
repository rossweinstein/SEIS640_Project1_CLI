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

    private Map<String, String> commandDictionary;

    public HelpMenu(Map<String, String> commandDictionary) {
        this.commandDictionary = new TreeMap<>(commandDictionary);
    }

    public String printHelpMenu() {
        return this.helpBanner() + "\n" + this.header() + "\n" + this.helpCommandList()
                + "\n" + this.drawDivider('*', 72) + "\n";
    }

    private String helpBanner() {
        return "\n" + this.drawDivider('*', 72) + "\n" +
                 "HELP MENU: CLI commands and their function descriptions\n";

    }

    private String header() {
        return "command\t\t|\tdescription" +
                "\n" + this.drawDivider('-', 72);
    }

    private String helpCommandList() {
        String output = "";

        for (String key: this.commandDictionary.keySet()) {

            String spacer = key.length() > 5 ? "\t" : "\t\t";

            output += "  "+ key + spacer + "|\t" + this.commandDictionary.get(key) + "\n";
        }
        return output;
    }

    private String drawDivider(char repeatingCharacter, int timesRepeated) {
        String output = "";
        for (int i = 0; i < timesRepeated; i++) {
            output += repeatingCharacter;
        }
        return output;
    }
}
