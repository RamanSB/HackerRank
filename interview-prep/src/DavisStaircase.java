import java.io.IOException;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Scanner;

public class DavisStaircase {

    // Complete the stepPerms function below.
    static int stepPerms(int n, int[] memo) {
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        if(n==3){
            return 4;
        }
        if(memo[n-1] != 0) {
            return memo[n - 1];
        }
        memo[n-1] = stepPerms(n-1, memo) + stepPerms(n-2, memo) + stepPerms(n-3, memo);
        return memo[n-1];
    }

    public static void main(String[] args){
        int n = 10;
        int[] memo = new int[n];
        LocalTime startTime = LocalTime.now();
        System.out.println(stepPerms(10, memo));
        LocalTime endTime = LocalTime.now();
        Duration duration = Duration.between(startTime, endTime);
        System.out.format("Time taken: %ds %fms", duration.getSeconds()*1000, duration.getNano()/1E6);
    }

}
