// A doubly linked list in Java's LinkedList class.
// ✅ Fast insertion/deletion (O(1))
// 🚫 Slow random access (O(n))

import java.util.LinkedList;

public class linkedlist{
    public static void main (String[] args){


LinkedList<Integer> linkedList = new LinkedList<>();
linkedList.add(10);
linkedList.add(20);
linkedList.addFirst(5); // Add at the beginning

System.out.println(linkedList); // Output: [5, 10, 20]
    }};