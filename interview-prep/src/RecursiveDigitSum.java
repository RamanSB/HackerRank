import java.time.Duration;
import java.time.LocalTime;

/**
 * Problem: https://www.hackerrank.com/challenges/recursive-digit-sum/problem
 */
public class RecursiveDigitSum {

    public static void main(String[] args){
        LocalTime startTime = LocalTime.now();
        System.out.println(superDigit("861568688536788", 100000));
        LocalTime endTime = LocalTime.now();
        Duration duration = Duration.between(startTime, endTime);

        System.out.format("Time taken: %d.%fs", duration.getSeconds(), duration.getNano()/1E0);
    }


    public static int superDigit(String n, int k){
        String result = "";
        for(int i=k; i>0; i--){
            result += n;
        }
        return superDigit(result);
    }

    public static int superDigit(String n){
        if(n.length()==1){
            return Integer.parseInt(n);
        }
        int super_digit = 0;
        for(char val : n.toCharArray()){
            super_digit += Integer.parseInt(val+"");
        }
        return superDigit(super_digit+"");
    }


}
