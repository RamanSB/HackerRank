import java.util.Stack;

/**
 * Problem: https://www.hackerrank.com/challenges/ctci-queue-using-two-stacks
 *
 * We are tasked with creating a Queue (FIFO) using 2 Stacks (LIFO).
 *
 * One stack will be responsible for enqueueing (adding values to the queue): pushStack
 * The other stack will be repsonsible for dequeueing & peeking from the stack: popStack
 *
 * We only ever need to have an element present in 1 of the stacks, never both. Once an element is enqueued,
 * it can remain in the pushStack until it is time for dequeuing or peeking, we will then move the values from
 * the pushStack to the popStack if the popStack is empty, otherwise we will peek or dequeue directly from the
 * pop-stack.
 *
 *
 * ---Example---
 * enqueue(5)
 * enqueue(10)
 * enqueue(14)
     * pushStack [5,10,14]
     * popStack []
 * dequeue() - Now because the popStack is empty, we will move the elements in the pushStack to the popStack ready for dequeue or peeking.
     * pushStack []
     * popStack [14, 10, 5] we then pop()
     * popStack[14, 10]
 * enqueue(19)
     * pushStack [19]
     * popStack [14, 10]
 * peek()
     * pushStack [19]
     * popStack [14, 10] we then peek() returns 10
 * dequeue() - because the popStack contains element we do not yet move the elements on the pushStack to the popStack.
     * pushStack[19]
     * popStack [14]
 */
public class MyQueue<T> {

    Stack<T> pushStack = new Stack<>(); //represents items at the front of the queue.
    Stack<T> popStack = new Stack<>(); //represents items at the back of the queue

    public void enqueue(T t){
        pushStack.push(t);
    }

    public T dequeue(){
        if (popStack.isEmpty()) {
            while(!pushStack.isEmpty()){
                popStack.push(pushStack.pop());
            }
        }
        return popStack.pop();
    }

    public T peek(){
        if(popStack.isEmpty()){
            while(!pushStack.isEmpty()){
                popStack.push(pushStack.pop());
            }
        }
        return popStack.peek();
    }


    public String toString(){
        return String.format("%s, %s", pushStack, popStack);
    }

    public static void main(String[] args){
        MyQueue<Integer> queue = new MyQueue<>();
        queue.enqueue(5);
        queue.enqueue(12);
        queue.enqueue(1);
        //push stack [5,12,1]
        //pop stack []
        System.out.println("Dequeued: " + queue.dequeue());
        //pop stack [1]  (Whilst executing dequeue)
        //push stack [5,12] (Whilst executing dequeue)
        //pop stack [] (at the end of dequeue)
        //push stack [5,12] (at the end of dequeue)
        System.out.println("Peek: " + queue.peek());
        // push stack [5]
        // pop stack [12]




        System.out.println(queue);
    }

}