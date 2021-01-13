/**
 * Problem: https://www.hackerrank.com/challenges/java-reflection-attributes/problem
 */

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;

public class ReflectionsProblem {

    public static void main(String[] args){
        Class classObj = Worker.class;
        Method[] methods = classObj.getDeclaredMethods();
        ArrayList<String> methodList = new ArrayList<>();

        for(Method method : methods){
            methodList.add(method.getName());
        }

        Collections.sort(methodList);
        for(String name: methodList){
            System.out.println(name);
        }
    }
}

class Worker {

    protected void work(){}
    private void beg(){}
    public void travel(){}
    public void lie(){}
    public void compete(){}

}
