package commandLineInterface.commands.tasks.taskController;

/*
 * *********************************************************************************************
 *
 * Name:			Ross Weinstein
 * Course Number:	SEIS 640-01
 *
 * Description: This class takes the BasicMath class and turns it into a functioning CLICommand
 *              for our CLI Project. It defines the command names and assigns to it certain
 *              functions within the BasicMath class.
 *
 * *********************************************************************************************
 */

import commandLineInterface.commands.CLICommand;
import commandLineInterface.commands.tasks.helpers.Numbers;
import commandLineInterface.commands.tasks.task.BasicMath;

import java.util.HashMap;
import java.util.Map;

public class BasicMathController implements CLICommand {

    // to avoid typos, an array to hold the names of the commands
    // this CLICommand class is able to perform
    private String[] commands;

    // BasicMath allows us to perform simple calculations
    private BasicMath math;

    // error message if invalid input is given
    private String errorMessage;

    /**
     * No arg constructor. Sets up this class for use.
     */
    public BasicMathController() {

        // name the commands this CLICommand is able to perform
        this.commands = new String[]{"add", "subt", "mult", "divide"};

        // instantiate a new BasicMath class in order to perform our calculations
        this.math = new BasicMath();

        // declare the error message if any invalid input is given
        this.errorMessage = "Invalid Input: Not All Arguments Are Valid Numeric Values";
    }

    /**
     * Create a Map which will serve as this CLICommand's dictionary stating the name
     * of each command and the function it performs. This is needed for both the
     * help menu within our CLI project, but also to identify which commands belong
     * to which class
     *
     * @return the completed Map with all commands and descriptions
     */
    @Override
    public Map<String, String> commandDictionary() {

        // an empty map to hold our commands and descriptions
        Map<String, String> basicMathDictionary = new HashMap<>();

        // add
        basicMathDictionary.put(this.commands[0], "Performs addition on the supplied arguments");

        // subtract
        basicMathDictionary.put(this.commands[1], "Performs subtraction on the supplied arguments");

        // multiply
        basicMathDictionary.put(this.commands[2], "Performs multiplication on the supplied arguments");

        // divide
        basicMathDictionary.put(this.commands[3], "Performs division on the supplied arguments");

        return basicMathDictionary;
    }

    /**
     * Check if our supplied arguments are valid numbers before performing any
     * mathematical operation. Return a invalid arguments message if supplied
     * arguments are not all valid numeric values
     *
     * @param name the name of the desired mathematical operation (add, subt, mult, divide)
     * @param args the arguments to be checked for validity before being passed for evaluation
     * @return the result of the evaluated expression if supplied arguments are valid numeric values;
     *          an error message if all arguments are not valid numeric values
     */
    @Override
    public String executeCommand(String name, String[] args) {

        // the Number class is able to determine if the arguments are valid numbers and
        // whether we have ints or doubles for the BasicMath methods
        Numbers arguments = new Numbers(args);

        return arguments.areNumeric() ? evaluateOperation(name, arguments) : this.errorMessage;
    }

    /**
     * Based upon the command given, perform the desired mathematical operations with the
     * given arguments.
     *
     * @param operation the name of the desired mathematical operation (add, subt, mult, divide)
     * @param args the arguments to be given to the desired BasicMath method
     * @return the result of the evaluated expression
     */
    private String evaluateOperation(String operation, Numbers args) {

        // String to hold the expression result
        String output = "";

        // add
        if (operation.equals(this.commands[0])) {
            output = this.performAddition(args);

            // subt
        } else if (operation.equals(this.commands[1])) {
            output = this.performSubtraction(args);

            // mult
        } else if (operation.equals(this.commands[2])) {
            output = this.performMultiplication(args);

            // divide
        } else if (operation.equals(this.commands[3])) {
            output = this.performDivision(args);
        }

        return output;
    }

    /**
     * For the arguments given, perform the add method from the BasicMath class
     *
     * @param arguments the arguments to be evaluated
     * @return the result of the evaluated expression
     */
    private String performAddition(Numbers arguments) {
        return arguments.canBeInteger() ? String.valueOf(this.math.add(arguments.getIntValues())) :
                String.valueOf(this.math.add(arguments.getDoubleValues()));
    }

    /**
     * For the arguments given, perform the subt method from the BasicMath class
     *
     * @param arguments the arguments to be evaluated
     * @return the result of the evaluated expression
     */
    private String performSubtraction(Numbers arguments) {
        return arguments.canBeInteger() ? String.valueOf(this.math.subt(arguments.getIntValues())) :
                String.valueOf(this.math.subt(arguments.getDoubleValues()));
    }

    /**
     * For the arguments given, perform the mult method from the BasicMath class
     *
     * @param arguments the arguments to be evaluated
     * @return the result of the evaluated expression
     */
    private String performMultiplication(Numbers arguments) {
        return arguments.canBeInteger() ? String.valueOf(this.math.mult(arguments.getIntValues())) :
                String.valueOf(this.math.mult(arguments.getDoubleValues()));
    }

    /**
     * For the arguments given, perform the divide method from the BasicMath class
     *
     * @param arguments the arguments to be evaluated
     * @return the result of the evaluated expression
     */
    private String performDivision(Numbers arguments) {
        return arguments.canBeInteger() ? String.valueOf(this.math.divide(arguments.getIntValues())) :
                String.valueOf(this.math.divide(arguments.getDoubleValues()));
    }
}
