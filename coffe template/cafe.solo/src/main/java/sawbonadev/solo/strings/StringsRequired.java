/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sawbonadev.solo.strings;

/**
 * Validates that all strings are not null and its trimed value is not empty.
 * Invalid examples: " " ""
 *
 * Valid examples: " asd " "asd"
 *
 * @author clobaco
 */
public class StringsRequired extends BaseStringsValidation {

    /**
     * Validates that all strings are not null and its trimed value is not
     * empty. Invalid examples: " " ""
     *
     * Valid examples: " asd " "asd"
     *
     * @param stringToEvaluate
     */
    public StringsRequired(String... stringToEvaluate) {
        super(stringToEvaluate);
    }

    @Override
    public boolean isValidImpl() {
        for (String string : strings) {
            if (string == null || string.trim().isEmpty()) {
                return false;
            }
        }
        return true;
    }

}
