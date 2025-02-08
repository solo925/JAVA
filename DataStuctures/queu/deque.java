import java.util.ArrayDeque;
import java.util.Deque;

Deque<Integer> deque = new ArrayDeque<>();
deque.addFirst(1);
deque.addLast(2);
deque.addLast(3);

System.out.println(deque.pollFirst()); // Output: 1
System.out.println(deque.pollLast()); // Output: 3
