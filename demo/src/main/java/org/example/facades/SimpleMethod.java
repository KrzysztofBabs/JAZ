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
        if(!Modifier.isPublic(method.getModifiers())){
            return false;
        }
        if(method.getName().startsWith("set")){
            if(method.getReturnType()==void.class && method.getParameterCount()==1)
                return true;

        }
        return false;

    }

    public boolean isGetter() {
//        return method.getName().equals("get") && method.getReturnType() != void.class && method.getParameterCount()==0 && Modifier.isPublic(method.getModifiers());
//        if(!Modifier.isPublic(method.getModifiers())) return false;
//        if(method.getName().equals("get")) return true;
//        if(method.getReturnType()!=void.class) return true;
//        if(method.getParameterCount()==0) return true;
//        return false;
        if(!Modifier.isPublic(method.getModifiers())){
            return false;
        }
//        String methodName = method.getName();

        if(method.getName().startsWith("get")){
            return method.getReturnType() != void.class && method.getParameterCount() == 0;
        }
        if(method.getName().startsWith("is")){
            return method.getReturnType() == boolean.class && method.getParameterCount() == 0;
        }

        return false;
    }

    @Override
    public String getFieldName() {
        if(method.getName().startsWith("set")){
            return method.getName().substring(3, 4).toLowerCase() + method.getName().substring(4);
        }
        if(method.getName().startsWith("set") && method.getParameterCount() == 1) {
            return method.getName().substring(3, 4).toLowerCase() + method.getName().substring(4);
        }
        if(method.getName().startsWith("is") && method.getReturnType() == boolean.class) {
            return method.getName().substring(2, 3).toLowerCase() + method.getName().substring(3);
        }
        return null;

    }

    public Method GetUnderlyingMethod(){
        return method;
    }


}
