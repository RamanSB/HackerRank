import java.util.*;

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
 *
 * Anytime we come across an element that is an end/closing brace or NOT a start/opening Brace we will pop our stack and
 * check if the combination of the concatenated value between the popped value and closing brace form a a balanced bracket,
 * i.e. balanced List on line 28... () [] {}
 */
public class StackProblem {

    public static void main(String []argh) {
        Scanner sc = new Scanner(System.in);
        boolean isBalanced = false;
        List<String> balanced = Arrays.asList("()", "[]", "{}");
        List<Character> startBraces = Arrays.asList('{','[','(');
        while (sc.hasNext()) {
            Deque<Character> characterStack = new ArrayDeque<>();
            String input = sc.next();
            //Complete the code
            if (input.length() % 2 != 0) {
                System.out.println("false");
                continue;
            }
            char[] characters = input.toCharArray();
            for(int i=0; i<characters.length; i++){
                if(startBraces.contains(characters[i])){
                    characterStack.push(characters[i]);
                }else{
                    if(characterStack.peek()!=null) {
                        String poppedVal = characterStack.pop().toString();
                        isBalanced = balanced.contains(poppedVal.concat(characters[i] + ""));
                    }else{
                        isBalanced = false;
                        break;
                    }
                }
            }
        System.out.println(isBalanced);
        }
    }
}

//
//        true
//        false
//        true
//        false
//        false
//        false
//        false
//        false
//        true
//        false
//        false
//        true
//        false
//        false
//        true
//        true
//        true
//        true
//                true
//                false
//                true
//                false
//                false
//                false
//                false
//                false
//                true
//                false
//                false
//                false
//                false
//                false
//                true
//                true
//                true
//                true