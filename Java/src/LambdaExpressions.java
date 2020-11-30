import java.io.*;

/**
 * This is a functional interface - it contains a single abstract method (public abstract boolean check(int a))
 * parameter type int, return type boolean: Predicate<Integer> or Function<Integer, Boolean>
 */
interface PerformOperation {
    boolean check(int a);
}

class MyMath {

    public static boolean checker(PerformOperation p, int num) {
        return p.check(num);
    }


    PerformOperation isOdd = x -> x%2 != 0;
    PerformOperation isPrime = (x) -> {
        if(x%2==0){
            return false;
        }else{
            for(int i=0; i<i/2; i++){
                if(x%i == 0){
                    return false;
                }
            }
        }
        return true;
    };
    PerformOperation isPalindrome = (x) -> {
        String numberString = ""+x;
        String reverseString = new StringBuilder(numberString).reverse().toString();
        return numberString.equals(reverseString);
    };

}



public class LambdaExpressions {

    public static void main(String[] args) throws IOException {
        MyMath ob = new MyMath();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        PerformOperation op;
        boolean ret = false;
        String ans = null;
        while (T-- > 0) {
            String s = br.readLine().trim();
            StringTokenizer st = new StringTokenizer(s);
            int ch = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if (ch == 1) {
                op = ob.isOdd();
                ret = MyMath.checker(op, num);
                ans = (ret) ? "ODD" : "EVEN";
            } else if (ch == 2) {
                op = ob.isPrime();
                ret = MyMath.checker(op, num);
                ans = (ret) ? "PRIME" : "COMPOSITE";
            } else if (ch == 3) {
                op = ob.isPalindrome();
                ret = MyMath.checker(op, num);
                ans = (ret) ? "PALINDROME" : "NOT PALINDROME";

            }
            System.out.println(ans);
        }
    }
}
