/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sawbonadev.solo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author clobaco
 */
public class ValidationResult {
    private final List<String> messages = new ArrayList<>();
    private final String property;

    public ValidationResult(String propiedad) {
        this.property = propiedad;
    }

    public List<String> getMessages() {
        return messages;
    }

    public String getProperty() {
        return property;
    }
    
    public void addMessage(String message){
        messages.add(message);
    }
}
