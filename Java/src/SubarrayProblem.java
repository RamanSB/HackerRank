import java.util.Arrays;
import java.util.Scanner;

/**
 * Problem: https://www.hackerrank.com/challenges/java-negative-subarray/problem
 *
 * Thoughts:
 *
 * for an array of size N how many subarrays exist?
 *
 * N=1 (x) [x] 1
 * N=2 (x, y) [x], [y], [x,y] 3 "1 subarray of size 2, 2 of size"
 * N=3 (x, y, z) [x], [y], [z], [x,y], [y,z], [x,y,z] 6 "1 subArray of size 3, 2 of size 2, 3 of size 1)
 * N=4 (w, x, y, z) [w], [x], [y], [z], [w,x], [x,y], [y,z], [w,x,y], [x,y,z], [w,x,y,z] 10
 * N=n (1 subarray of size N, 2 of size N-1, 3 of size N-2, ... N of size 1)
 *
 * #subArrays = n(n+1)/2
 */
public class SubarrayProblem {


    public static void main(String[] args){
        final Scanner scanner = new Scanner(System.in);
        int arrayLength = Integer.parseInt(scanner.nextLine()); //Don't even need this but let's just accept an input for the questions sake.
        int[] array = Arrays.stream(scanner.nextLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
       //System.out.println(Arrays.toString(array));
        System.out.println(findSubarrays(array));
    }

     static int findSubarrays(int[] array){
        int count = 0;
        for(int i=0; i<array.length; i++){
            int sum = 0;
            for(int k=i; k<array.length; k++){ //k=i ensures we are summing contiguous values
                sum += array[k];  //i=0,k=0 sum=array[0]+0 (subArray 1st elem), i=0, k=1 sum=array[0]+array[1] (subArray, 1st & 2nd elem);
                if(sum<0){
                    count++;
                }
            }
        }
        return count;
     }

}
