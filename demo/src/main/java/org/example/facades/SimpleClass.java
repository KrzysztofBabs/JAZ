package org.example.facades;

import org.example.Subject;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class SimpleClass implements IClassFacade{

    Class<?> clazz;

    public SimpleClass(Class<?> clazz) {
        this.clazz = clazz;
    }

    @Override
    public  List<IMethodFacade> getPublicDeclaredMethods() {
        List<IMethodFacade> result = new ArrayList<>();
        Method[] metody = clazz.getDeclaredMethods();
        for(Method m : metody){
            if(Modifier.isPublic(m.getModifiers())){
                IMethodFacade iMethodFacade = new SimpleMethod(m);
                result.add(iMethodFacade);
            }
        }
        return result;

    }
    @Override
    public List<IMethodFacade> getPublicGetters() {
        List<IMethodFacade> result = new ArrayList<>();
        Method[] metody = clazz.getDeclaredMethods();
        for(Method m : metody){
            boolean isGetter = Modifier.isPublic(m.getModifiers()) && (m.getName().startsWith("get") || m.getName().startsWith("is")) && m.getParameterCount()==0 && m.getReturnType()!=void.class;
            if(isGetter){
                IMethodFacade iMethodFacade = new SimpleMethod(m);
                result.add(iMethodFacade);

            }
        }
        return result;
    }


    @Override
    public List<IMethodFacade> getPublicSetters() {
        List<IMethodFacade> result = new ArrayList<>();
        Method[] methods = clazz.getDeclaredMethods();
        for(Method m : methods){
            boolean isSetter = Modifier.isPublic(m.getModifiers()) && m.getName().startsWith("set") && m.getReturnType()==void.class && m.getParameterCount()==1;

            if(isSetter){
                IMethodFacade iMethodFacade = new SimpleMethod(m);
                result.add(iMethodFacade);

            }
        }
        return result;

    }

    @Override
    public List<Field> getFieldsForPublicProperties() {
        List<Field> result = new ArrayList<>();

        for(IMethodFacade getter : getPublicGetters()) {
            for(IMethodFacade setter : getPublicSetters()) {
                if(getter.getFieldName().equals(setter.getFieldName())) {
                    try {
                        Field field = setter.GetUnderlyingMethod().getDeclaringClass().getDeclaredField(getter.getFieldName());
                        result.add(field);
                    }catch (NoSuchFieldException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return result;
    }


    @Override
    public List<IMethodFacade> getDeclaredMethods() {
        return null;
    }






}
