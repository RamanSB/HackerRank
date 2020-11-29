import java.util.Scanner;

/**
 * ---INPUT---
 * Input: String s
 * ---OUTPUT---
 * Output: Valid or Invalid.
 * ---CONSTRAINTS---
 * 1) Length of s [8, 30] (Inclusive)
 * 2) Valid characters: a-zA-Z0-9
 * 3) s.charAt(0) must be alphabetic (a-zA-Z)
 */
public class ValidateUsername {

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        int n = Integer.parseInt(scan.nextLine());
        while (n-- != 0) {
            String userName = scan.nextLine();

            if (userName.matches(UsernameValidator.regularExpression)) {
                System.out.println("Valid");
            } else {
                System.out.println("Invalid");
            }
        }
    }
}

class UsernameValidator {
    /*
     * Write regular expression here.
     */
    public static final String regularExpression = "[a-zA-Z][\\w\\d_]{7,29}";
}
