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

    public PerformOperation isOdd() {
        return (x) -> x % 2 != 0;
    }

    public PerformOperation isPrime() {
        return (x) -> {
            if (x == 2) {
                return true;
            }
            if (x % 2 == 0 & x != 2) {
                return false;
            } else {
                for (int i = 1; i < x / 2; i++) {
                    if (i % x == 0) {
                        return false;
                    }
                }
            }
            return true;
        };
    }

    public PerformOperation isPalindrome() {
        return (x) -> {
            String numberString = "" + x;
            String reverseString = new StringBuilder(numberString).reverse().toString();
            return numberString.equals(reverseString);
        };
    }

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
