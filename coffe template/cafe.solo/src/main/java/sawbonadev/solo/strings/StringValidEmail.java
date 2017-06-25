/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sawbonadev.solo.strings;

import org.apache.commons.validator.EmailValidator;
import sawbonadev.solo.Validator;

/**
 *
 * @author clobaco
 */
public class StringValidEmail implements Validator<String> {

    @Override
    public boolean isValid(String email) {
        return EmailValidator.getInstance().isValid(email);
    }

}
