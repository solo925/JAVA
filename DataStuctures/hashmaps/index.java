import java.util.HashMap;

HashMap<String, Integer> map = new HashMap<>();
map.put("Alice", 25);
map.put("Bob", 30);

System.out.println(map.get("Alice")); // Output: 25
System.out.println(map.containsKey("Bob")); // Output: true



// A fast key-value data structure for mapping unique keys to values.
// ✅ O(1) lookup, insertion, and deletion
// 🚫 Unordered storage
