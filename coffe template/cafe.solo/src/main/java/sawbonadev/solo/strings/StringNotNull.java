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
public class StringNotNull implements Validator<String> {

    @Override
    public boolean isValid(String string) {
        return string != null;
    }

}
