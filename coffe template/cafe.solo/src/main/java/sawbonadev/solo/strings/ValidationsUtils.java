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
public final class ValidationsUtils {
    
    public static final Validator STRINGS_REQUIRED = new StringRequired();
    public static final Validator VALID_EMAIL = new StringValidEmail();
    
}
