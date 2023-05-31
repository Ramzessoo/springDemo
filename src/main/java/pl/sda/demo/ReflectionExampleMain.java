package pl.sda.demo;

import java.lang.reflect.Field;

public class ReflectionExampleMain {
    public static void main(String[] args) throws IllegalAccessException {

        ReflectionExample example = new ReflectionExample();

        System.out.println(ReflectionExample.class.getDeclaredFields().length);

       for  (Field field : ReflectionExample.class.getFields()) {
           field.setAccessible(true);
           System.out.println(field.getName());
           System.out.println(field.get(example));
           field.set(example, "changed Value");
       }
        System.out.println( example.getPrivateField());
    }
}
