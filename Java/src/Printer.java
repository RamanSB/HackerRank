/**
 * Problem solved for: https://www.hackerrank.com/challenges/java-generics/problem
 */

import java.io.IOException;
import java.lang.reflect.Method;

class Printer<T>
{
    /* Usually for instance methods if we declare the generic type parameter on the class level
    - we don't need to include it as a part of the method signature. However static methods require the
    generic type parameter to be declared in the method signature before the return type, i.e.
    static <T> (returnType) methodName(params) */
    <T> void printArray(T[] t){
        for(T value : t){
            System.out.println(value);
        }
    }

static class Solution {


    public static void main(String args[]) {
        Printer myPrinter = new Printer();
        Integer[] intArray = {1, 2, 3};
        String[] stringArray = {"Hello", "World"};
        myPrinter.printArray(intArray);
        myPrinter.printArray(stringArray);
        int count = 0;

        for (Method method : Printer.class.getDeclaredMethods()) {
            String name = method.getName();

            if (name.equals("printArray"))
                count++;
        }

        if (count > 1) System.out.println("Method overloading is not allowed!");

    }

    }
}