/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sawbonadev.solo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author clobaco
 * @param <T>
 */
public class GenericResponse<T> {

    private T payload;
    private final Map<String, List<String>> validations = new HashMap<>();

    public GenericResponse(T payload) {
        this.payload = payload;
    }

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }

    public Map<String, List<String>> getValidations() {
        return validations;
    }

    public <K> void add(String propertyName, String message, Validator<K> validator, K value) {
        if (!validator.isValid(value)) {
            addValidationMessageForProperty(propertyName, message);
        }
    }

    public void addValidationMessageForProperty(String propertyName, String message) {
        List<String> messages = getValidationsMessageForProperty(propertyName);
        messages.add(message);
    }

    private List<String> getValidationsMessageForProperty(String propertyName) {
        if (!validations.containsKey(propertyName)) {
            validations.put(propertyName, new ArrayList<>());
        }
        List<String> messages = validations.get(propertyName);
        return messages;
    }

    private boolean valid;

    public boolean isValid() {
        valid = validations.isEmpty();
        return valid;
    }

    public void setValid(boolean isValid) {
        this.valid = isValid;
    }
}
