import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

public class Queue1 {
    public static void main(String []s){
        System.out.println("Priority Queue");
        PriorityQueue<Integer> q= new PriorityQueue<>();
        q.add(1);
        q.add(2);
        System.out.println(q);
        System.out.println(q.peek());
        System.out.println(q.poll());
        System.out.println(q);

        System.out.println("Deque");
        Deque<Integer> dq=new ArrayDeque<>();
        dq.addFirst(1);
        dq.addLast(2);
        System.out.println(dq.peekFirst());
        System.out.println(dq.peekLast());

        dq.addLast(3);
        dq.pollFirst();
        System.out.println(dq);

    }
}
