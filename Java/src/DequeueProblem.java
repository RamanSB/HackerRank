import java.util.*;

/**
 * Problem: https://www.hackerrank.com/challenges/java-dequeue/problem
 *
 * (Double-ended queue - a.k.a Deque ('Deck')
 *
 * push (inserts element to the front of queue)
 * offer (adds element to the back of queue).
 * poll (removes and returns element at front of queue - otherwise returns null)
 * peek (reveals element at the front of the queue - otherwise null)
 */
public class DequeueProblem {

    Deque<Integer> deque = new LinkedList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Deque<Integer> deque = new ArrayDeque<>();
        int n = in.nextInt();
        int m = in.nextInt();

        for (int i = 0; i < n; i++) {
            int num = in.nextInt();
            deque.offer(num);
        }

        Set<Integer>[] contiguousSetsArray = new HashSet[n-m+1];
        int[] dequeArray = deque.stream().mapToInt(x->x).toArray();

        int startIdx = 0;
        while(startIdx <= n-m) {
            contiguousSetsArray[startIdx] = new HashSet<>();
            for (int i = startIdx; i < startIdx + m; i++) {
                contiguousSetsArray[startIdx].add(dequeArray[i]);
            }
            startIdx++;
        }

        Optional<Integer> maxOptional = Arrays.stream(contiguousSetsArray).map(x->x.size()).max(Comparator.comparingInt(x -> x));
        int result = maxOptional.orElseGet(()->-1);
        System.out.println(result);
    }

}



