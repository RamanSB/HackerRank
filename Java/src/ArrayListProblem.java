import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Problem: https://www.hackerrank.com/challenges/java-arraylist/problem
 */

public class ArrayListProblem {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<String> inputData = new ArrayList<>();
        for(int i=0; i<n; i++){
            String input = scanner.nextLine();
            inputData.add(i, input);
        }

        int noOfQueries = Integer.parseInt(scanner.nextLine());
        for(int i=0; i<noOfQueries; i++){
            String input = scanner.nextLine();
            String[] queryIndex = input.split("\\s");
            int listIndexToQuery = Integer.parseInt(queryIndex[0]);
            int arrayElementIndex = Integer.parseInt(queryIndex[1]);
            performQuery(inputData, listIndexToQuery, arrayElementIndex);
        }
    }

    private static void performQuery(List<String> data, int listIndexToQuery, int arrayElementIndex){
        try {
            String[] arrayElements = data.get(listIndexToQuery-1).split("\\s");
            System.out.println(arrayElements[arrayElementIndex]);
        } catch(IndexOutOfBoundsException ex){
            System.out.println("ERROR!");
        }
    }

}
