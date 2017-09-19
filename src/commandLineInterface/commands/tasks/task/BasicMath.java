package commandLineInterface.commands.tasks.task;

/*
 * *********************************************************************************************
 *
 * Name:			Ross Weinstein
 * Course Number:	SEIS 640-01
 *
 * Description: This class is responsible for the most basic of math functions.  It can add,
 *              subtract, multiply, and divide ints and doubles.
 *
 * *********************************************************************************************
 */

import java.util.Arrays;

public class BasicMath {

    /**
     * No arg constructor.
     */
	public BasicMath() {}

    /**
     * For the given values, add all of them together.
     *
     * @param values the int values to be added together
     * @return the sum of the given values
     */
	public int add(int[] values) {
        return Arrays.stream(values).sum();
    }

    /**
     * For the given values, add all of them together.
     *
     * @param values the double values to be added together
     * @return the sum of the given values
     */
    public double add(double[] values) {
        return Arrays.stream(values).sum();
    }

    /**
     * For the given values, subtract all values from the first value
     *
     * @param values the int values to be subtracted from one another
     * @return the result from subtracting al values from the first value
     */
	public int subt(int[] values) {
	    return Arrays.stream(values).reduce((a,b) -> a - b).getAsInt();
    }

    /**
     * For the given values, subtract all values from the first value
     *
     * @param values the double values to be subtracted from one another
     * @return the result from subtracting al values from the first value
     */
    public double subt(double[] values) {
        return Arrays.stream(values).reduce((a,b) -> a - b).getAsDouble();
    }

    /**
     * For the given values, multiply all of them together.
     *
     * @param values the int values to be multiplied together
     * @return the product of multiplying all values together
     */
	public int mult(int[] values) {
        return Arrays.stream(values).reduce(1, (a,b) -> a * b);
	}

    /**
     * For the given values, multiply all of them together.
     *
     * @param values the double values to be multiplied together
     * @return the product of multiplying all values together
     */
    public double mult(double[] values) {
        return Arrays.stream(values).reduce(1, (a,b) -> a * b);
    }

    /**
     * For the given values, divide all values from the first value
     *
     * @param values the int values to be divided from the first value
     * @return the quotient after dividing all values
     */
	public double divide(int[] values) {
        double[] convertedIntArray = Arrays.stream(values).asDoubleStream().toArray();
        return this.divide(convertedIntArray);
	}

    /**
     * For the given values, divide all values from the first value
     *
     * @param values the double values to be divided from the first value
     * @return the quotient after dividing all values
     */
    public double divide(double[] values) {
        return Arrays.stream(values).reduce((a,b) -> a / b).getAsDouble();
    }
}
