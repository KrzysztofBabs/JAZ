package org.example.annotations;

import org.example.rules.ICheckValidationRule;
import org.example.validation.ValidationResult;

import java.util.List;

public class Validator {
    List<ICheckValidationRule> rules;

    <T> ValidationResult validate(T obj){
        var result = new ValidationResult();
        rules.stream().forEach(rule->rule.validate(result));
        return result;
    }


    Validator addRule(ICheckValidationRule rule) {
        this.rules.add(rule);
        return this;



    }


}
