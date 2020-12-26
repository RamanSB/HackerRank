/**
 * Problem: https://www.hackerrank.com/challenges/java-2d-array/problem
 *
 *  See Doc for findHourGlassSums method.
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Array2DProblem {


    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        scanner.close();
        findHourGlassSums(arr);
    }

    /**
     * Given a point in the array [x][y] an hourglass is defined as:
     * array[x][y],   array[x][y+1],    array[x][y+2]
     *                array[x+1][y+1]
     * array[x+2][y], array[x+2][y+1]   array[x+2][y+2]
     *
     * Constraints
     *      x>=0 & x<6
     *      y>=0 & y<6
     * @param array
     */
    static void findHourGlassSums(int[][] array){
        List<Integer> hourGlassSums = new ArrayList<>();
        for(int i=0; i<array.length; i++){
            for(int j=0; j<array.length; j++){
                if(i+2<6 && j+2<6){
                    int sum = array[i][j] + array[i][j+1] + array[i][j+2] + array[i+1][j+1] + array[i+2][j] +
                            array[i+2][j+1] + array[i+2][j+2];
                    hourGlassSums.add(sum);
                }else{
                    continue;
                }
            }
        }
       hourGlassSums.stream().max(Comparator.comparingInt(x->x)).ifPresent(System.out::print);
    }
}
