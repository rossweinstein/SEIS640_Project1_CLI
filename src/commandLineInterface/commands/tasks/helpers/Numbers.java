package commandLineInterface.commands.tasks.helpers;

/*
 * *********************************************************************************************
 *
 * Name:				Ross Weinstein
 * Course Number:	    SEIS 640-01
 *
 * Description: This class is responsible for determining if a string is a number or not.  If it
 *              is, it will determine if that number is an int or double and then make the proper
 *              conversion.
 *
 * *********************************************************************************************
 */

public class Numbers {

    private int[] intValues;
    private double[] doubleValues;
    private String[] unconvertedNumber;

    public Numbers(String[] unconvertedNumbers) {
        this.intValues = null;
        this.doubleValues = null;
        this.unconvertedNumber = unconvertedNumbers;
    }

    public Numbers(String unconvertedNumber) {
        this(new String[] {unconvertedNumber});
    }

    public int[] getIntValues() {
        this.makeInteger();
        return intValues;
    }

    public double[] getDoubleValues() {
        this.makeDouble();
        return doubleValues;
    }

    public boolean areNumeric() {
        for (String eachValue: this.unconvertedNumber) {
            if(!this.isValidInteger(eachValue) && !this.isValidDouble(eachValue)) {
                return false;
            }
        }
        return true;
    }

    public boolean canBeInteger() {
        for (String eachValue: this.unconvertedNumber) {
            if(!this.isValidInteger(eachValue)) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidInteger(String possibleInteger) {
        return hasNoLeadingZeros(possibleInteger) && possibleInteger.matches("[-+]?[0-9]+");
    }

    private boolean isValidDouble(String possibleDouble) {
        return hasNoLeadingZeros(possibleDouble) && possibleDouble.matches("[-+]?[0-9]*\\.?[0-9]+");
    }

    private boolean hasNoLeadingZeros(String possibleNumber) {
        return couldHaveLeadingZeros(possibleNumber) ? checkForLeadingZeros(possibleNumber) : true;
    }

    private boolean couldHaveLeadingZeros(String numInQuestion) {
        return numInQuestion.length() > 1 && numInQuestion.charAt(0) == '0' || numInQuestion.charAt(0) == '-';
    }

    private boolean checkForLeadingZeros(String number) {
        return isNegativeNumber(number) ? this.negativeValidation(number) : this.positiveValidation(number);
    }

    private boolean negativeValidation(String possibleNumber) {
        return this.isValid(possibleNumber, 1);
    }

    private boolean positiveValidation(String possibleNumber) {
        return this.isValid(possibleNumber, 0);
    }

    private boolean isNegativeNumber(String possibleNumber) {
        return possibleNumber.charAt(0) == '-';
    }

    private boolean isValid(String possibleNumber, int startOffset) {
        return possibleNumber.charAt(0 + startOffset) == '0' ? possibleNumber.charAt(1 + startOffset) == '.' : true;
    }

    public void makeInteger() {
        if (this.areNumeric() && this.canBeInteger()) {

            this.intValues = new int[this.unconvertedNumber.length];

            for (int i = 0; i < this.unconvertedNumber.length; i++) {
                this.intValues[i] = Integer.parseInt(this.unconvertedNumber[i]);
            }
        }
    }

    public void makeDouble() {
        if (this.areNumeric()) {
            this.doubleValues = new double[this.unconvertedNumber.length];

            for (int i = 0; i < this.unconvertedNumber.length; i++) {
                this.doubleValues[i] = Double.parseDouble(this.unconvertedNumber[i]);
            }
        }

    }
}
