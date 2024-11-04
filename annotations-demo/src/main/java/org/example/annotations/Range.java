package org.example.annotations;

public @interface Range {
    public String message() default "";
    public int min();
    public int max();
}
