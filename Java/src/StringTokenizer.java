import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ---Input---
 * Input string: s
 * ---Constraints---
 * s composed of any of the following: English alphabetic letters, blank spaces, exclamation points (!), commas (,),
 * question marks (?), periods (.), underscores (_), apostrophes ('), and at symbols (@).
 * 1 < length of s < 4E5
 * ---Output---
 * On the first line, print an integer, n, denoting the number of tokens in string  (they do not need to be unique)
 * Next, print each of the  tokens on a new line in the same order as they appear in input string .
 *
 * Important:
 * 1) We define a token to be one or more consecutive English alphabetic letters
 * 2) blank spaces, exclamation points (!), commas (,), question marks (?), periods (.), underscores (_), apostrophes ('), and at symbols (@).
 */

public class StringTokenizer{

    private List<String> tokens;
    private String inputString;

    StringTokenizer(String inputString) {
        String localVar = inputString.trim();
        if(localVar.length() > 0 && localVar.length() <= 4*Math.pow(10, 5)){
            this.inputString = inputString.trim();
        }else{
            System.out.println(localVar.length());
        }

    }

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        StringTokenizer tokenizer = new StringTokenizer(s);
        tokenizer.splitStringOnNoneTokenChars();
        //tokenizer.splitStringByToken();
        tokenizer.displayOutput();
        scan.close();
    }

    //decided to abandon this approach.
    private List<String> splitStringByToken(){
        tokens = new ArrayList<>();
        String tokenPatternRegex = "(\\w)+";
        Pattern tokenPattern = Pattern.compile(tokenPatternRegex);
        Matcher matcher = tokenPattern.matcher(this.inputString);
        while(matcher.find()){
            tokens.add(matcher.group());
        }
        return tokens;
    }

    private List<String> splitStringOnNoneTokenChars(){
        tokens = new ArrayList<>();
        String tokenPatternRegex = "[!_,.\"@'*?\\s]+";
        tokens =  Arrays.asList(inputString.split(tokenPatternRegex));
        if(tokens.size() == 0 || inputString.trim().length()==0 || inputString.trim().length() > 4*Math.pow(10, 5)){
            return null;
        }
        return tokens;
    }


    private void displayOutput(){
        if(tokens!=null) {
            System.out.println(tokens.size());
            tokens.forEach(System.out::println);
        }
    }

}
