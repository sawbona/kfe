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
public class StringsNotNull extends BaseStringsValidation {

    public StringsNotNull(String... strings){
        super(strings);
    }
    
    @Override
    protected boolean isValidImpl() {
        for (String string : strings) {
            if(string == null){
                return false;
            }
        }
        return true;
    }

}
