/*
 * Created by Pavel Mikuska
 */

package com.pavelmikuska.mortgagecalculatorfx;

public class InputValidator {

    public boolean isValid(String input, double min, double max) {
        if (!isNumber(input)) {
            return false;
        }
        if (Double.parseDouble(input) < min || Double.parseDouble(input) > max) {
            return false;
        }
        return true;
    }

    public boolean isNumber(String input) {
        if (input == null) {
            return false;
        }
        try {
            double number = Double.parseDouble(input);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }


}
