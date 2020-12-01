/**
 * MD5 (Message-Digest algorithm 5) is a widely-used cryptographic hash function with a 128-bit hash value.
 *
 * Problem:
 * 1) https://www.hackerrank.com/challenges/java-md5/problem (Line 52 change string parameter to "MD5")
 * 2) https://www.hackerrank.com/challenges/sha-256/problem (Line 52 change string parameter to "SHA-256")
 * ("Given an alphanumeric string, s, denoting a password, compute and print its MD5 encryption value."
 *
 * ---INPUT---
 * Input: a single alphanumeric string denoted by s.
 *
 * ---OUTPUT---
 * Output: Print the MD5 encryption value of s on a new line.
 *
 * ---CONSTRAINTS---
 * Constraints:
 * -1) length of s must be between 6 and 20 (inclusive) | [6, 20]
 * -2) s must consist of alphabetic letters (i.e. [a-zA-Z] [0-9]
 *
 *
 * Comments: When seeing this challenge I was unsure how to imlpement the MD5 hash algorithm - however the discussion
 * indicates that we can use the MessageDigestSpi (Service Provider Interface - which is really an abstract class)...
 *
 * I don't think the difficulty should be Medium - the question should've also stated to use the MessageDigest class
 * within the java.security package.
 *
 * 1) Obtain the MessageDigest instance with the appropriate algorithm using MessageDigest.getInstance("algorithm-name");
 * 2) Use the MessageDigests' instance method update(byte[] byteArray) - this will send the message to the digest.
 * 3) Use the digest() method to create the hashed message (hash)
 *
 * Q: What is a MessageDigest?
 * Answer: A message digest is a cryptographic hash function containing a string of digits created by a one-way hashing
 *         formula. Message digests are designed to protect the integrity of a piece of data or media to detect changes
 *         and alterations to any part of a message.
 *
 *
 * More Info on how to use the MessageDigest reference on performing an MD5 (example uses SHA-256) encryption:
 * https://www.tutorialspoint.com/java_cryptography/java_cryptography_message_digest.htm
 */

import java.security.MessageDigest;
import java.util.Scanner;

public class MD5 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        scanner.close();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            messageDigest.update(inputString.getBytes());
            byte[] hash = messageDigest.digest();
            for (byte b : hash) {
                System.out.printf("%02x", b);
            }
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }

}