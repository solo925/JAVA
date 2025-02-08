import java.util.HashSet;

HashSet<Integer> set = new HashSet<>();
set.add(10);
set.add(20);
set.add(10); // Duplicate, will not be added

System.out.println(set); // Output: [10, 20]
System.out.println(set.contains(20)); // Output: true


// A collection of unique elements (unordered).
// ✅ O(1) insertion, deletion, and lookup
// 🚫 No duplicate values