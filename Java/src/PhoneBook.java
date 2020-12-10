import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Problem: https://www.hackerrank.com/challenges/java-list/problem
 *
 * Map,<K, V> : K-Name, V-PhoneNumber
 *
 * ---INPUT---
 *
 */
public class PhoneBook {

    public static void main(String[] arg){
        Map<String, Integer> phoneBook = new HashMap<>();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        for(int i = 0;i<n;i++) {
            String name = in.nextLine();
            int phone = in.nextInt();
            phoneBook.put(name, phone);
            in.nextLine();
        }
        while(in.hasNext())
        {
            String s = in.nextLine();
            if(phoneBook.get(s)!=null) {
                System.out.println(s + "=" + phoneBook.get(s));
            }else {
                System.out.println("Not found");
            }
        }
    }

}
