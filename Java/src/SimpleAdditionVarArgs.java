/**
 * https://www.hackerrank.com/challenges/simple-addition-varargs/problem
 */
public class SimpleAdditionVarArgs {

    class Add {
        public void add(int... nums) {
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += nums[i];
                if (i == nums.length - 1) {
                    System.out.print(nums[i] + "=");
                } else {
                    System.out.print(nums[i] + "+");
                }
            }
            System.out.println(sum);
        }
    }
}
