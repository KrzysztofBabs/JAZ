package org.example.facades;


import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class SimpleMethod implements IMethodFacade{
    Method method;

    public SimpleMethod(Method method) {
        this.method = method;
    }

    public boolean isPublic() {
//        if(Modifier.isPublic(method.getModifiers())) {
//            return true;
//        }
//        return false;
        return Modifier.isPublic(method.getModifiers());

    }

    public boolean paramsCountEquals(int n) {
        return method.getParameterTypes().length == n;

    }

    public boolean startsWith(String prefix) {
        return method.getName().startsWith(prefix);

    }

    public boolean isVoid(){
        return method.getReturnType().equals(void.class);
    }

    public boolean isSetter() {
        return method.getName().equals("set");

    }

    public boolean isGetter() {
        return method.getName().equals("get");

    }

    @Override
    public String getFieldName() {
        return "";
    }

    public Method getUnderlyingMethod(){
        return method;
    }


}
