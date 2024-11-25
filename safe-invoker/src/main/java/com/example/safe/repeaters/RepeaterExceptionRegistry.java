package com.example.safe.repeaters;

import java.util.HashMap;
import java.util.Map;

public class RepeaterExceptionRegistry  implements IRepeaterExceptionRegistry{
    private final static RepeaterExceptionRegistry instance;
    static{
        instance = new RepeaterExceptionRegistry();
    }

    public static RepeaterExceptionRegistry getInstance(){ return instance; }

    private final Map<String, RegistryEntry> registry = new HashMap<>();

    private RepeaterExceptionRegistry(){}

    @Override
    public void add(Class<? extends Throwable> exceptionClass, int retries, long delay) {
        /*
            Tutaj Twoim zadaniem jest napisanie odpowiedniego algorytmu
         */
       registry.put(exceptionClass.getName(), new RegistryEntry(exceptionClass.getName(), delay, retries));




    }

    @Override
    public  RegistryEntry EntryFor(Throwable exception) {
        /*
            Tutaj Twoim zadaniem jest napisanie odpowiedniego algorytmu
         */
        RegistryEntry entry = registry.get(exception.getClass().getName());


        return entry;
    }
}
