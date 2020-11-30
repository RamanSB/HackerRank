/**
 * Problem: https://www.hackerrank.com/challenges/tag-content-extractor/problem
 *
 *
 * ---INPUT---
 * Input: 1st line - Integer n (declaring number of tag-based text)
 * Input: n lines of tag based text
 *
 * ---Constraints---
 * 1) Name of start & end tags must be the same i.e. <h1></h1>
 * 2) Tags can be nested, content between nested tags is invalid, i.e.
 * <h1>
 *     <a>contents</a>
 *     invalid
 * </h1>
 * contents is valid but invalid is not valid.
 * 3) Tags consist of printable characters
 *
 * 1<=N<=100 [1,100]
 * each test case max character count of 1E4
 * total character count of all test cases must be less than E6
 *
 * ---OUTPUT---
 * Output: print valid content on a new line, if no valid content exists print None.
 *
 */

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TagContentExtractor{


    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        while(testCases>0){
            String line = in.nextLine();
            //Write your code here
            //<h1><h1>Sanjay has no watch</h1></h1><par>So wait for a while</par>
            //<Amee>safat codes like a ninja</amee>
            extractAndDisplayContent(line);
            testCases--;
        }


    }

    public static void extractAndDisplayContent(String inputString){

        String regExpTag = "<(.|[^<>]+)>";
        String regExpContent = "<(.|[^<>]+)>([^<>]+)</\\1>"; //Ensuring opening & ending tags are equal

        boolean isMatched = false;
        Pattern contentPattern = Pattern.compile(regExpContent);
        Matcher contentMatcher = contentPattern.matcher(inputString);
        while(contentMatcher.find()){
            isMatched = true;
            System.out.println(contentMatcher.group(2));
        }
        if(!isMatched){
            System.out.println("None");
        }
    }
}




