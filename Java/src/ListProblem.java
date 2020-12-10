import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Problem: https://www.hackerrank.com/challenges/java-list/problem
 *
 * ---INPUT---
 * Input:
 * 1) The first line contains an integer, N (the initial number of elements in L).
 *
 */

public class ListProblem {

    public static void main(String[] args){
        acceptInput();
    }

    public static void acceptInput(){
        Scanner scanner = new Scanner(System.in);
        int listSize = Integer.parseInt(scanner.nextLine());
        String elements = scanner.nextLine();
        String[] search_list =  elements.split(" ");
        List<Integer> searchList = Arrays.stream(search_list).map(x -> Integer.parseInt(x)).collect(Collectors.toList());
        List<Integer> netList = new ArrayList<Integer>(listSize*listSize);
        netList.addAll(searchList);
        int numOfQueries = Integer.parseInt(scanner.nextLine());
        for(int i=0; i<numOfQueries; i++){
            Action ACTION = scanner.nextLine().equals("Insert") ? Action.INSERT : Action.DELETE;
            switch(ACTION){
                case INSERT:
                    int[] insertionVals = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(x->Integer.parseInt(x)).toArray();
                    if(insertionVals[0] >= netList.size()) {
                        netList.add(insertionVals[1]);
                    }else {
                        netList.add(insertionVals[0], insertionVals[1]);
                    }
                    break;
                case DELETE:
                    netList.remove(Integer.parseInt(scanner.nextLine()));
                    break;
                default:
                    throw new IllegalArgumentException("Invalid enum action used: " + ACTION);
            }
        }
        netList.forEach((x) -> System.out.print(x+"".concat(" ")));
    }


    enum Action {

        DELETE("Delete"), INSERT("Insert");
        private String inputString;

        private Action(String s){
            this.inputString = s;
        }

    }
}
