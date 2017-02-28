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
public class StringsEquals extends BaseStringsValidation {

    public StringsEquals(String... strings) {
        super(strings);
    }

    @Override
    public boolean isValidImpl() {

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
