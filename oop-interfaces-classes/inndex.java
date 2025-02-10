# **🔹 Functions (Methods) in Java**  

In Java, functions are called **methods**. They are blocks of code that perform a specific task and can be reused multiple times.

---

## **1️⃣ Syntax of a Java Method**
A method has:
- A **return type** (or `void` if it returns nothing)
- A **method name**
- Optional **parameters**
- A **body** (the code to execute)
- Can be **static** or **non-static**  

### **Example: A Simple Java Method**
```java
public class Example {
    // Method without parameters
    public static void sayHello() {
        System.out.println("Hello, World!");
    }

    public static void main(String[] args) {
        sayHello(); // Calling the method
    }
}
```
### **Output**
```
Hello, World!
```

---

## **2️⃣ Method with Parameters and Return Value**
Methods can take **input parameters** and **return a value**.

### **Example: Method with Parameters**
```java
public class MathOperations {
    // Method that adds two numbers and returns the sum
    public static int add(int a, int b) {
        return a + b;
    }

    public static void main(String[] args) {
        int result = add(5, 10); // Call method
        System.out.println("Sum: " + result);
    }
}
```
### **Output**
```
Sum: 15
```

---

## **3️⃣ Method Overloading (Multiple Methods with Same Name)**
Java allows multiple methods with the **same name but different parameters**.

### **Example: Method Overloading**
```java
public class OverloadExample {
    // Method 1: Adding two numbers
    public static int add(int a, int b) {
        return a + b;
    }

    // Method 2: Adding three numbers (same name but different parameters)
    public static int add(int a, int b, int c) {
        return a + b + c;
    }

    public static void main(String[] args) {
        System.out.println(add(5, 10));       // Calls method with 2 parameters
        System.out.println(add(5, 10, 15));   // Calls method with 3 parameters
    }
}
```
### **Output**
```
15
30
```

---

## **4️⃣ Static vs. Non-Static Methods**
- **Static methods** can be called **without** creating an object.
- **Non-static methods** require an **object** to be called.

### **Example: Static vs. Non-Static**
```java
public class MethodTypes {
    // Static method
    public static void staticMethod() {
        System.out.println("I am a static method.");
    }

    // Non-static method
    public void nonStaticMethod() {
        System.out.println("I am a non-static method.");
    }

    public static void main(String[] args) {
        staticMethod(); // Call static method directly

        MethodTypes obj = new MethodTypes(); // Create object
        obj.nonStaticMethod(); // Call non-static method
    }
}
```
### **Output**
```
I am a static method.
I am a non-static method.
```

---

## **5️⃣ Recursion in Java (Method Calling Itself)**
A recursive method **calls itself** until a condition is met.

### **Example: Factorial Using Recursion**
```java
public class RecursionExample {
    public static int factorial(int n) {
        if (n == 1) return 1; // Base condition
        return n * factorial(n - 1);
    }

    public static void main(String[] args) {
        System.out.println("Factorial of 5: " + factorial(5));
    }
}
```
### **Output**
```
Factorial of 5: 120
```

---

## **6️⃣ Pass-by-Value in Java**
Java **always** passes arguments by **value** (copy of the variable).

### **Example: Pass-by-Value (Primitive)**
```java
public class PassByValue {
    public static void modify(int x) {
        x = 50; // Change value inside method
    }

    public static void main(String[] args) {
        int num = 10;
        modify(num);
        System.out.println("Value of num: " + num); // Remains unchanged
    }
}
```
### **Output**
```
Value of num: 10
```
✅ The original variable `num` is **not affected** because Java passes a **copy**.

---

## **7️⃣ Methods with Objects (Reference Type)**
For **objects**, Java still passes by **value**, but the **reference** is copied.

### **Example: Modifying Object Inside Method**
```java
class Person {
    String name;
}

public class PassByReference {
    public static void changeName(Person p) {
        p.name = "Alice"; // Modifying object property
    }

    public static void main(String[] args) {
        Person person = new Person();
        person.name = "Bob";

        changeName(person);
        System.out.println("Person's Name: " + person.name); // Alice
    }
}
```
### **Output**
```
Person's Name: Alice
```
✅ **Objects are modified because Java passes a copy of the reference**.

---

## **8️⃣ Method with Variable Arguments (`varargs`)**
You can pass a **variable number of arguments** using `...`.

### **Example: `varargs` Method**
```java
public class VarargsExample {
    public static void printNumbers(int... numbers) {
        for (int num : numbers) {
            System.out.print(num + " ");
        }
    }

    public static void main(String[] args) {
        printNumbers(1, 2, 3, 4, 5); // Pass multiple values
    }
}
```
### **Output**
```
1 2 3 4 5
```

---

## **9️⃣ Returning Multiple Values**
Java doesn't support multiple return values, but you can return an **array** or an **object**.

### **Example: Returning Multiple Values Using an Array**
```java
public class ReturnMultipleValues {
    public static int[] getNumbers() {
        return new int[]{1, 2, 3};
    }

    public static void main(String[] args) {
        int[] numbers = getNumbers();
        System.out.println(numbers[0] + ", " + numbers[1] + ", " + numbers[2]);
    }
}
```
### **Output**
```
1, 2, 3
```

---

## **🔟 Summary**
| Feature | Description | Example |
|---------|-------------|---------|
| **Basic Method** | Simple method with no parameters | `public static void sayHello()` |
| **Method with Parameters** | Takes input values | `public static int add(int a, int b)` |
| **Method Overloading** | Multiple methods with the same name but different parameters | `add(int a, int b, int c)` |
| **Static Method** | Can be called without an object | `Math.sqrt(9)` |
| **Non-Static Method** | Requires an object to be called | `obj.nonStaticMethod()` |
| **Recursion** | A method calling itself | `factorial(n)` |
| **Pass-by-Value** | Java passes arguments by value (copy) | `modify(int x)` |
| **Pass-by-Reference** | Objects' properties can be modified | `changeName(Person p)` |
| **Variable Arguments (`varargs`)** | Accepts multiple arguments | `printNumbers(int... numbers)` |
| **Returning Multiple Values** | Return an array or object | `return new int[]{1,2,3}` |

✅ **Use `static` for utility methods (e.g., `Math.max()`).**  
✅ **Use method overloading for flexibility.**  
✅ **Use `varargs` when unsure about the number of arguments.**  

Would you like a deep dive into **Lambda Expressions or Functional Interfaces** next? 😊