/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sawbonadev.solo.strings;

import sawbonadev.solo.Validator;

/**
 * Validates that all strings are not null and its trimed value is not empty.
 * Invalid examples: " " ""
 *
 * Valid examples: " asd " "asd"
 *
 * @author clobaco
 */
public class StringRequired implements Validator<String> {

    @Override
    public boolean isValid(String string) {
        return !(string == null || string.trim().isEmpty());
    }

}
