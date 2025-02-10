### **Generics and Streams in Java**

---

## **1. Generics in Java**
Generics allow you to create **classes, interfaces, and methods** with **type parameters**, making your code more flexible and type-safe.

---

### **Example 1: Generic Class**
```java
// Generic class with a type parameter <T>
class Box<T> {
    private T value;

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }
}

public class GenericExample {
    public static void main(String[] args) {
        Box<String> stringBox = new Box<>();
        stringBox.set("Hello, Generics!");
        System.out.println(stringBox.get());

        Box<Integer> intBox = new Box<>();
        intBox.set(100);
        System.out.println(intBox.get());
    }
}
```
### **Explanation**
- The `Box<T>` class can hold any type (String, Integer, etc.).
- This eliminates the need for type casting and ensures **type safety**.

---

### **Example 2: Generic Method**
```java
class Util {
    // Generic method
    public static <T> void printArray(T[] array) {
        for (T element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}

public class GenericMethodExample {
    public static void main(String[] args) {
        String[] words = {"Java", "Generics", "Streams"};
        Integer[] numbers = {1, 2, 3, 4, 5};

        Util.printArray(words);
        Util.printArray(numbers);
    }
}
```
### **Explanation**
- `<T>` before `void` defines a generic type.
- The method works with any array type (String, Integer, etc.).

---

### **Example 3: Generic Interface**
```java
// Generic interface
interface Pair<K, V> {
    K getKey();
    V getValue();
}

// Implementing generic interface
class KeyValuePair<K, V> implements Pair<K, V> {
    private K key;
    private V value;

    public KeyValuePair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() { return key; }
    public V getValue() { return value; }
}

public class GenericInterfaceExample {
    public static void main(String[] args) {
        Pair<String, Integer> agePair = new KeyValuePair<>("Alice", 25);
        System.out.println("Name: " + agePair.getKey() + ", Age: " + agePair.getValue());
    }
}
```
### **Explanation**
- `Pair<K, V>` is a **generic interface**.
- `KeyValuePair` implements `Pair` with **any type** for `K` and `V`.

---

## **2. Streams in Java**
Streams provide a functional way to process collections **efficiently**.

---

### **Example 1: Filtering a List**
```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Anna", "Charlie");

        // Filter names starting with 'A'
        List<String> filteredNames = names.stream()
                                          .filter(name -> name.startsWith("A"))
                                          .collect(Collectors.toList());

        System.out.println(filteredNames); // Output: [Alice, Anna]
    }
}
```
### **Explanation**
- `.stream()` converts `List` into a **Stream**.
- `.filter()` selects elements based on **conditions**.
- `.collect(Collectors.toList())` converts back to a **List**.

---

### **Example 2: Mapping (Transforming) a List**
```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMappingExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("alice", "bob", "charlie");

        // Convert names to uppercase
        List<String> upperCaseNames = names.stream()
                                           .map(String::toUpperCase)
                                           .collect(Collectors.toList());

        System.out.println(upperCaseNames); // Output: [ALICE, BOB, CHARLIE]
    }
}
```
### **Explanation**
- `.map(String::toUpperCase)` transforms each string.
- Streams work in a **functional programming** style.

---

### **Example 3: Sorting a List**
```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamSortingExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(5, 1, 8, 2, 3);

        // Sort in ascending order
        List<Integer> sortedNumbers = numbers.stream()
                                             .sorted()
                                             .collect(Collectors.toList());

        System.out.println(sortedNumbers); // Output: [1, 2, 3, 5, 8]
    }
}
```
### **Explanation**
- `.sorted()` sorts elements in natural order (ascending).
- You can also sort in **descending order**:
  ```java
  .sorted((a, b) -> b - a) // Comparator for descending order
  ```

---

### **Example 4: Reduce (Sum of Elements)**
```java
import java.util.Arrays;
import java.util.List;

public class StreamReduceExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10, 20, 30, 40);

        // Sum using reduce
        int sum = numbers.stream()
                         .reduce(0, Integer::sum);

        System.out.println("Sum: " + sum); // Output: Sum: 100
    }
}
```
### **Explanation**
- `.reduce(0, Integer::sum)` adds all numbers.

---

### **Example 5: Count Elements Matching a Condition**
```java
import java.util.Arrays;
import java.util.List;

public class StreamCountExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Anna", "Charlie");

        // Count names starting with 'A'
        long count = names.stream()
                          .filter(name -> name.startsWith("A"))
                          .count();

        System.out.println("Count: " + count); // Output: Count: 2
    }
}
```
### **Explanation**
- `.count()` counts filtered elements.

---

## **3. Combining Generics and Streams**
```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class DataProcessor<T> {
    public List<T> filterList(List<T> list, java.util.function.Predicate<T> condition) {
        return list.stream().filter(condition).collect(Collectors.toList());
    }
}

public class GenericStreamExample {
    public static void main(String[] args) {
        DataProcessor<String> processor = new DataProcessor<>();
        List<String> names = Arrays.asList("Alice", "Bob", "Anna", "Charlie");

        // Use generic method with streams
        List<String> filteredNames = processor.filterList(names, name -> name.startsWith("A"));

        System.out.println(filteredNames); // Output: [Alice, Anna]
    }
}
```
### **Explanation**
- `DataProcessor<T>` is a generic class.
- `filterList()` uses **Streams and Predicates** for filtering.

---

## **Summary**
| **Feature** | **Generics** | **Streams** |
|------------|-------------|-------------|
| **Purpose** | Code reusability & type safety | Process collections efficiently |
| **Where Used?** | Classes, Interfaces, Methods | Lists, Sets, Maps |
| **Main Methods** | `<T>`, `extends`, `super` | `filter()`, `map()`, `sorted()`, `reduce()` |
| **Benefits** | Avoids type casting, flexible | Less code, readable, efficient |

---

Would you like an **example with custom objects** or a **real-world use case**? 🚀