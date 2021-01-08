import java.util.*;

/**
 * Problem: https://www.hackerrank.com/challenges/largest-rectangle/problem
 */
public class LargestRectangleStack {

    public static void main(String[] args){
        int n = 5;
        int[] adjBuildings = {6873,7005,1372,5438,1323,9238,9184,2396,4605,162,7170,9421,4012,5302,6277,2438,4409,3391,4956,4488,622,9365,5088,6926,2691,6909,1050,2824,3538,5801,8468,411,9158,9841,2201,481,5431,1385,2877,36,1547,48,5809,1911,1702,8439,4349,6111,1830,5657,6951,8804,5022,8391,2083,7713,5300,3133,6890,5190,5286,1710,1953,4445,7903,4154,4926,3335,5539,4156,9723,3438,556,1885,5349,2258,324,6050,4722,8506,1707,1673,7310,3081,65,9393,7147,1717,8878,389,6908,4165,2099,5213,8610,3,9368,3536,9690,1259};
        int result = largestRectangle(adjBuildings);
        System.out.format("For %d adjacent buildings as described by;\n %s\n, the largest area is: %d",
                n, Arrays.toString(adjBuildings), result);
        
    }

    public static int largestRectangle(int[] adjBuildings) {
        Deque<Integer> adjBuildingStack = new ArrayDeque();
        for (int building : adjBuildings) {
            adjBuildingStack.push(building);
        }
        int[] area = new int[adjBuildings.length];
        int i=0;
        while (adjBuildingStack.size() != 1) {
            int minimum = adjBuildingStack.stream().min(Comparator.comparingInt(x->x)).get();
            System.out.println("Minimum to remove: " + minimum);
            area[i]= adjBuildingStack.size() * minimum;
            System.out.println("Current Area:" + area[i]);
            while(adjBuildingStack.contains(minimum)){
                if(adjBuildingStack.peekLast() > adjBuildingStack.peekFirst()){ //1st value > last value
                    System.out.println("Removing: " + adjBuildingStack.pollFirst());

                }else if(adjBuildingStack.peekLast() == adjBuildingStack.peekFirst()){
                    //Nothing
                }else{
                    System.out.println("Removing: " + adjBuildingStack.pollLast());
                }
            }
            i++;
        }
        System.out.println();
        return Arrays.stream(area).max().getAsInt();

    }
}