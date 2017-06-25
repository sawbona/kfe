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
public class StringsEquals implements Validator<String[]> {

    @Override
    public boolean isValid(String... strings) {
        if(strings == null || strings.length == 0){
            return false;
        }
        String first = strings[0];
        if (first == null) {
            return false;
        }

        for (int i = 1; i < strings.length; ++i) {
            if (!first.equals(strings[i])) {
                return false;
            }
        }
        return true;
    }
}
