// Implemented 
// 
// using LinkedList or ArrayDeque.
import java.util.LinkedList;
import java.util.Queue;

Queue<String> queue = new LinkedList<>();
queue.add("Alice");
queue.add("Bob");
queue.add("Charlie");

System.out.println(queue.poll()); // Output: Alice (removes first element)
System.out.println(queue.peek()); // Output: Bob (next element)

// ✅ Fast enqueue/dequeue (O(1))
// 🚫 Slower random access