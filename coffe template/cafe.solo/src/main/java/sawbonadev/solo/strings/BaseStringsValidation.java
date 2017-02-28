/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sawbonadev.solo.strings;

import sawbonadev.solo.Validator;

/**
 *
 * @author sawbona
 */
public abstract class BaseStringsValidation implements Validator {

    private final boolean isNullValid;
    protected final String[] strings;

    protected BaseStringsValidation(String... strings) {
        this.isNullValid = false;
        this.strings = strings;
    }

    @Override
    public boolean isValid() {
        if (strings == null) {
            return isNullValid;
        }
        if (strings.length == 0) {
            return true;
        }
        return isValidImpl();
    }

    protected abstract boolean isValidImpl();

}
