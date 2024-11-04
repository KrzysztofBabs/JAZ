package org.example.annotations;

import java.util.List;
import java.util.Map;

public class ValidationResult<T> {
    T validatedObject;
    Map<String, List<String>> notValidFields;
    boolean isValid;

    public T getValidatedObject() {
        return validatedObject;
    }

    public void setValidatedObject(T obj) {

    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean isValid) {

    }

    public Map<String, List<String>> getNotValidFields() {
        return notValidFields;
    }


}
