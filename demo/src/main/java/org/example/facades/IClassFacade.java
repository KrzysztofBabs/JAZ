package org.example.facades;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

public interface IClassFacade {
    List<IMethodFacade> getPublicDeclaredMethods();

    List<IMethodFacade> getDeclaredMethods();

    List<IMethodFacade> getPublicSetters();

    List<IMethodFacade> getPublicGetters();

    List<Field> getFieldsForPublicProperties();




}
