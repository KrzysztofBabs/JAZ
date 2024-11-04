package org.example.rules;

import org.example.annotations.NotNull;
import org.example.validation.ValidationResult;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NotNullValidationRule implements ICheckValidationRule {
    @Override
    public <T> void validate(ValidationResult<T> result) {
        Class clazz = result.getValidatedObject().getClass();
        var obj = result.getValidatedObject();
        Stream.of(clazz.getDeclaredFields()).filter(f -> f.isAnnotationPresent(NotNull.class))
                .collect(Collectors.toMap(f -> f, f -> f.getAnnotation(NotNull.class)))
                .forEach((field, annotation) -> {
                            try {
                                field.setAccessible(true);
                                if(field.get(obj) == null) {
                                    result.setValid(false);
                                    result.getNotValidFields().putIfAbsent(field.getName(), new ArrayList<>());
                                    result.getNotValidFields().get(field.getName()).add(annotation.message());
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                            }


                        }
                );
    }
}

