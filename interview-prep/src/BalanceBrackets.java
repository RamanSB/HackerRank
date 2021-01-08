import java.util.*;

/**
 * Problem: https://www.hackerrank.com/challenges/balanced-brackets/problem
 *
 * The following chars are considered as 'brackets': (, ), {, }, [, or ].
 * A bracket is matched if the following occurs: [], {}, and ().
 *
 * A string is balanced if:
 * - It contains no unmatched brackets.
 * - The subset of brackets enclosed within the confines of a matched pair of brackets is also a matched pair of brackets.
 */
public class BalanceBrackets {

    // Complete the isBalanced function below.
    static String isBalanced(String s) {

        List<Character> openBracketList = Arrays.asList('{', '(', '[');
        List<Character> closedBracketList = Arrays.asList('}',')',']');
        List<String> matchedBracketList = Arrays.asList("{}","[]","()");

        Deque<Character> stack = new ArrayDeque<>();
        boolean isBalanced = false;
        for(int i=0; i<s.length(); i++){
            try {
                char character = s.charAt(i);
                if(i==0 && !openBracketList.contains(character) //if first char is not an open bracket then cannot be balanced.
                        || i==s.length()-1 && !closedBracketList.contains(character)//if last char is not a closed bracket then cannot be balanced.
                ){
                    isBalanced = false;
                    break;
                }
                if (openBracketList.contains(character)) {
                    stack.push(character);
                } else {
                    isBalanced = matchedBracketList.contains(stack.pop().toString() + s.charAt(i));
                    if (!isBalanced) {
                        break; // if the brackets are unbalanced for any iteration, return false;
                    }
                }
            } catch(Exception ex){
                isBalanced = false;
                break;
            }
        }
        return isBalanced ? "YES" : "NO";
    }

    public static void main(String[] args){
        String input = "{{}(";


        System.out.println(isBalanced(input));
    }

}
