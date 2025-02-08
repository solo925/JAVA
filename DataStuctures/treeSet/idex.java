import java.util.TreeSet;

TreeSet<Integer> treeSet = new TreeSet<>();
treeSet.add(40);
treeSet.add(10);
treeSet.add(30);

System.out.println(treeSet); // Output: [10, 30, 40] (Sorted)
System.out.println(treeSet.first()); // Output: 10
System.out.println(treeSet.last()); // Output: 40


// A self-balancing binary search tree (Red-Black Tree) for sorted elements.
// ✅ Sorted elements (O(log n) operations)
// 🚫 Slower than HashSet