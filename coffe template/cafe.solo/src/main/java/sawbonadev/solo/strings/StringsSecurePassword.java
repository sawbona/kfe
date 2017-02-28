/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sawbonadev.solo.strings;

/**
 *
 * @author sawbona
 */
public class StringsSecurePassword extends BaseStringsValidation {

    public StringsSecurePassword(String... strings) {
        super(strings);
    }

    @Override
    protected boolean isValidImpl() {
        for (String string : strings) {
            if (string != null) {
                string = string.trim();
                
                // length
                if (string.length() < 8
                        
                        // upper and lower case required
                        || string.equals(string.toLowerCase())
                        || string.equals(string.toUpperCase())
                        
                        // if only alphanumeric.
                        || string.matches("[A-Za-z0-9 ]*")) {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

}
