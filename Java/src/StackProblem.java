import java.util.Scanner;
import java.util.Stack;

/**
 * Problem: https://www.hackerrank.com/challenges/java-stack/problem
 *
 * A string containing only parentheses is balanced if the following is true:
 * 1. if it is an empty string
 * 2. if A and B are correct, AB is correct,
 * 3. if A is correct, (A) and {A} and [A] are also correct.
 *
 * Comments:
 * Only strings with even number of characters are eligible to be balanced
 *
 * Example: ({()}) (6 characters)
 * Consider the first 3 characters, we push them on to our Stack...
 * [ (,{,( ]
 * Now consider the last 3 elements: ), ], )
 */
public class StackProblem {

    public static void main(String []argh) {
        Scanner sc = new Scanner(System.in);
        String[] balanced = {"()", "[]", "{}"};
        while (sc.hasNext()) {
            String input = sc.next();
            //Complete the code
            if(input.length() % 2 != 0){
                System.out.println("false");
            }
            else{
                boolean isBalanced = false;
                Stack<Character> characterStack = new Stack<>();
                char[] charArray = input.toCharArray();
                for(int i=0; i<charArray.length; i++){
                    if(i<charArray.length/2){
                        //System.out.println("Pushing " + charArray[i] + " on to stack.");
                        characterStack.push(charArray[i]);
                    }else{
                        char poppedValue = characterStack.pop();
                        //System.out.println("Popping " + poppedValue + " from to stack.");
                        String value = (poppedValue+"").concat(charArray[i]+"");
                        //System.out.println(value);
                        if(value.matches("\\(\\)|\\[\\]|\\{\\}]")){
                            isBalanced = true;
                        }else{
                            isBalanced = false;
                        }
                    }
                }
                System.out.println(isBalanced);
            }
        }

    }
}

