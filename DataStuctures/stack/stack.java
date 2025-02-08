// Uses Stack class in Java (java.util.Stack).
// ✅ Push/pop operations are O(1)
// 🚫 Not efficient for large-scale data (use Deque instead)

import java.utils.Stack;
public class stack{
    public static void main(String[] args){
   

Stack<Integer> stack = new Stack<>();
stack.push(10);
stack.push(20);
stack.push(30);

System.out.println(stack.pop()); // Output: 30
System.out.println(stack.peek()); // Output: 20 (top element)


    }
}