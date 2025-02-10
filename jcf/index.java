# **📌 Java Collection Framework (JCF)**
The **Java Collection Framework (JCF)** is a set of classes and interfaces that provide **efficient ways to store, manipulate, and retrieve objects**. It includes **Lists, Sets, Queues, Maps, and utility classes**.

---

## **📌 1. Overview of Collection Framework**
Java collections are categorized into **four main types**:

| **Collection Type** | **Interface** | **Implementation Classes** |
|-------------------|-------------|---------------------------|
| **List** (Ordered, Duplicates Allowed) | `List<E>` | `ArrayList`, `LinkedList`, `Vector`, `Stack` |
| **Set** (Unique Elements, No Duplicates) | `Set<E>` | `HashSet`, `LinkedHashSet`, `TreeSet` |
| **Queue** (FIFO Order, for Queues) | `Queue<E>`, `Deque<E>` | `PriorityQueue`, `ArrayDeque` |
| **Map** (Key-Value Pairs) | `Map<K, V>` | `HashMap`, `LinkedHashMap`, `TreeMap`, `Hashtable`, `ConcurrentHashMap` |

---

## **📌 2. List Interface (Ordered, Duplicates Allowed)**
`List<E>` allows duplicate elements and maintains insertion order.

### ✅ **1. ArrayList (Fast Random Access, Slow Insert/Delete)**
- **Implemented using a dynamic array.**
- **Fast for searching, slow for adding/removing elements in the middle.**
- **Best for read-heavy applications.**

```java
import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {
    public static void main(String[] args) {
        List<String> plants = new ArrayList<>();
        plants.add("Fern");
        plants.add("Cactus");
        plants.add("Bamboo");

        System.out.println(plants.get(1)); // Cactus
    }
}
```
⏳ **Time Complexity:**  
- **Add at end:** O(1)  
- **Add at middle:** O(n)  
- **Search:** O(1) (for index-based access)  

---

### ✅ **2. LinkedList (Fast Insert/Delete, Slow Access)**
- **Doubly linked list implementation.**
- **Best for insert/delete operations in the middle of a list.**

```java
import java.util.LinkedList;

public class LinkedListExample {
    public static void main(String[] args) {
        LinkedList<String> queue = new LinkedList<>();
        queue.add("Rose");
        queue.add("Tulip");
        queue.addFirst("Lily");

        System.out.println(queue); // Lily, Rose, Tulip
    }
}
```
⏳ **Time Complexity:**  
- **Insert/Delete at beginning or middle:** O(1)  
- **Search:** O(n)  

---

## **📌 3. Set Interface (Unique Elements, No Duplicates)**
`Set<E>` does not allow duplicate elements.

### ✅ **1. HashSet (Unordered, Unique)**
- **Uses HashMap internally.**
- **Fast operations but unordered.**

```java
import java.util.HashSet;
import java.util.Set;

public class HashSetExample {
    public static void main(String[] args) {
        Set<Integer> numbers = new HashSet<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(10); // Duplicate, won't be added

        System.out.println(numbers); // Output order not guaranteed
    }
}
```
⏳ **Time Complexity:** O(1) for add, remove, contains.

---

### ✅ **2. TreeSet (Sorted Set)**
- **Sorted order based on natural ordering (Comparable) or custom comparator.**
- **Implemented using Red-Black Tree.**

```java
import java.util.TreeSet;

public class TreeSetExample {
    public static void main(String[] args) {
        TreeSet<Integer> sortedSet = new TreeSet<>();
        sortedSet.add(30);
        sortedSet.add(10);
        sortedSet.add(20);

        System.out.println(sortedSet); // [10, 20, 30]
    }
}
```
⏳ **Time Complexity:** O(log n) for add, remove, contains.

---

## **📌 4. Queue Interface (FIFO)**
`Queue<E>` follows **First In, First Out (FIFO)** ordering.

### ✅ **1. PriorityQueue (Min/Max Heap)**
- **Elements are sorted based on natural ordering or a comparator.**
- **Used for priority-based tasks (like job scheduling).**

```java
import java.util.PriorityQueue;

public class PriorityQueueExample {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(50);
        pq.add(10);
        pq.add(30);

        System.out.println(pq.poll()); // 10 (smallest element)
    }
}
```
⏳ **Time Complexity:** O(log n) for add, remove.

---

## **📌 5. Map Interface (Key-Value Pairs)**
`Map<K, V>` stores unique keys mapped to values.

### ✅ **1. HashMap (Unordered Key-Value Store)**
- **Allows `null` keys & values.**
- **Unordered storage.**

```java
import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
    public static void main(String[] args) {
        Map<String, Integer> plantAge = new HashMap<>();
        plantAge.put("Fern", 2);
        plantAge.put("Cactus", 5);

        System.out.println(plantAge.get("Fern")); // 2
    }
}
```
⏳ **Time Complexity:** O(1) for get, put.

---

### ✅ **2. TreeMap (Sorted Key-Value Store)**
- **Keys are sorted in ascending order.**
- **Implemented using Red-Black Tree.**

```java
import java.util.TreeMap;

public class TreeMapExample {
    public static void main(String[] args) {
        TreeMap<String, Integer> sortedMap = new TreeMap<>();
        sortedMap.put("Bamboo", 3);
        sortedMap.put("Aloe", 1);
        sortedMap.put("Cactus", 5);

        System.out.println(sortedMap); // {Aloe=1, Bamboo=3, Cactus=5}
    }
}
```
⏳ **Time Complexity:** O(log n) for get, put.

---

## **📌 6. Iterating Through Collections**
### ✅ **1. Using `forEach` Loop**
```java
for (String plant : plants) {
    System.out.println(plant);
}
```

### ✅ **2. Using Iterator**
```java
import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class IteratorExample {
    public static void main(String[] args) {
        List<String> plants = new ArrayList<>();
        plants.add("Fern");
        plants.add("Cactus");

        Iterator<String> iterator = plants.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
```

---

## **📌 7. Summary**
| **Collection** | **Ordered?** | **Duplicates?** | **Sorting?** |
|--------------|------------|------------|------------|
| **ArrayList** | ✅ Yes | ✅ Yes | ❌ No |
| **LinkedList** | ✅ Yes | ✅ Yes | ❌ No |
| **HashSet** | ❌ No | ❌ No | ❌ No |
| **TreeSet** | ✅ Yes | ❌ No | ✅ Yes |
| **PriorityQueue** | ❌ No | ✅ Yes | ✅ Yes |
| **HashMap** | ❌ No | ✅ Yes (Keys unique) | ❌ No |
| **TreeMap** | ✅ Yes | ✅ Yes (Keys unique) | ✅ Yes |

Would you like a **deep dive into custom sorting using Comparators?** 🚀