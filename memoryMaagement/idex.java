# **🔹 Memory Management in Java**  

Java uses **automatic memory management** with a built-in **Garbage Collector (GC)** to handle memory allocation and deallocation. This makes Java memory-efficient and prevents memory leaks.  

---

## **📌 1. Java Memory Areas**  
Java memory is divided into **Heap**, **Stack**, **Method Area**, **PC Registers**, and **Native Method Stack**.

### **🔹 Java Memory Structure**  
🟢 **Heap Memory** (For Objects)  
🔹 **Stack Memory** (For Methods & Variables)  
🔹 **Method Area** (For Class Metadata & Static Variables)  
🔹 **PC Register** (For Thread Execution Tracking)  
🔹 **Native Method Stack** (For Native OS Calls)  

---

### **📌 2. Heap Memory (Object Storage)**
- Stores **objects and instance variables**.  
- Shared across all threads.  
- Divided into:  
  ✅ **Young Generation (Eden + Survivor Spaces)** → Stores new objects.  
  ✅ **Old Generation (Tenured Heap)** → Stores long-lived objects.  
  ✅ **Metaspace (Method Area)** → Stores class metadata, static variables.  

#### **🔹 Example: Heap Memory Usage**
```java
class Plant {
    String name; // Stored in Heap
    Plant(String name) {
        this.name = name;
    }
}

public class MemoryExample {
    public static void main(String[] args) {
        Plant p1 = new Plant("Fern");  // Stored in Heap
        Plant p2 = new Plant("Cactus"); // Stored in Heap
    }
}
```

**🔹 Garbage Collection in Heap**  
Objects in the heap without references get **garbage collected automatically**.  

---

### **📌 3. Stack Memory (Method Execution)**
- Stores **method calls, local variables, and references**.  
- Follows **LIFO (Last In, First Out)** principle.  
- **Each thread has its own stack.**  

#### **🔹 Example: Stack Memory Usage**
```java
public class StackMemoryExample {
    public static void methodA() {
        int x = 10; // Stored in Stack
        methodB();
    }

    public static void methodB() {
        int y = 20; // Stored in Stack
    }

    public static void main(String[] args) {
        methodA(); // Stack memory allocation
    }
}
```
🟢 **When `methodA()` is called,** `x` is stored in the Stack.  
🔴 **When `methodA()` finishes,** `x` is removed from the Stack.  

---

### **📌 4. Garbage Collection (Automatic Memory Cleanup)**
Java **automatically reclaims memory** from unused objects.  

#### **🔹 When Does GC Run?**
- When memory is **low**.  
- When the **JVM decides** to optimize memory.  

#### **🔹 Manually Request Garbage Collection**
```java
System.gc(); // Requests GC (JVM may ignore)
```

#### **🔹 GC Algorithms**
| **GC Type** | **Description** |
|------------|----------------|
| **Serial GC** | Single-threaded, for small apps. |
| **Parallel GC** | Multi-threaded, for medium apps. |
| **G1 GC** | Splits Heap into regions, used in large apps. |
| **ZGC** | Low-latency GC, used in real-time apps. |

---

### **📌 5. Memory Leaks in Java (Avoiding Issues)**
Java **manages memory**, but bad code can still cause memory leaks.

#### **🔹 Common Causes of Memory Leaks**
✅ **Unclosed Resources** (Files, Streams, Sockets)  
✅ **Static Variables Holding Objects**  
✅ **Listeners/Observers Not Removed**  
✅ **Poorly Managed Collections (`List`, `Map`)**  

#### **🔹 Example of a Memory Leak**
```java
import java.util.ArrayList;
import java.util.List;

public class MemoryLeakExample {
    private static List<int[]> memoryLeak = new ArrayList<>();

    public static void main(String[] args) {
        while (true) {
            memoryLeak.add(new int[1000000]); // Keeps adding objects, causing OutOfMemoryError
        }
    }
}
```
🔴 **Solution:** Always remove unused objects & clear collections.  
```java
memoryLeak.clear(); // Frees up memory
```

---

### **📌 6. Weak References (Avoiding Memory Leaks)**
Use **WeakReference** when you want objects to be garbage collected when memory is needed.

#### **🔹 Example Using `WeakReference`**
```java
import java.lang.ref.WeakReference;

public class WeakReferenceExample {
    public static void main(String[] args) {
        Plant p = new Plant("Rose");
        WeakReference<Plant> weakPlant = new WeakReference<>(p);
        p = null; // Object is now eligible for GC

        System.gc(); // Run GC
        if (weakPlant.get() == null) {
            System.out.println("Object garbage collected");
        }
    }
}
```
✅ **Allows objects to be garbage collected when necessary.**  

---

## **📌 7. Summary**
| **Concept** | **Description** |
|------------|----------------|
| **Heap Memory** | Stores objects & instance variables. |
| **Stack Memory** | Stores method calls & local variables. |
| **Garbage Collection** | Automatically frees unused memory. |
| **Memory Leak** | Happens when objects stay referenced. |
| **WeakReference** | Allows GC to collect unused objects. |

Would you like a **deeper dive into GC tuning and performance optimization**? 🚀