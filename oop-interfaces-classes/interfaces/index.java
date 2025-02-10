# **🔹 Classes and Interfaces in Java**  

Java is an **object-oriented programming (OOP)** language, and its core building blocks are **classes** and **interfaces**. Let's break them down.

---

## **1️⃣ Classes in Java**  
A **class** is a blueprint for creating objects. It contains **fields (variables) and methods (functions)** that define the behavior of an object.

### **Basic Syntax of a Class**  
```java
class Car {
    // Fields (Attributes)
    String brand;
    int speed;

    // Constructor (Special method to initialize objects)
    public Car(String brand, int speed) {
        this.brand = brand;
        this.speed = speed;
    }

    // Method
    public void accelerate() {
        speed += 10;
        System.out.println(brand + " is now going " + speed + " km/h");
    }
}

// Main Class
public class Main {
    public static void main(String[] args) {
        Car myCar = new Car("Toyota", 50); // Creating an object
        myCar.accelerate(); // Calling a method
    }
}
```
### **Output**
```
Toyota is now going 60 km/h
```

✅ **Key Concepts**:
- **Fields:** Variables inside a class (`brand`, `speed`).
- **Constructor:** Special method called when creating an object.
- **Methods:** Functions inside a class (`accelerate()`).

---

## **2️⃣ Types of Classes**
### **🔹 2.1 Concrete Class (Regular Class)**
A **regular class** can have methods with implementations.
```java
class Animal {
    void makeSound() {
        System.out.println("Animal makes a sound");
    }
}
```

### **🔹 2.2 Abstract Class (Cannot be Instantiated)**
An **abstract class** **cannot** be instantiated and can have abstract methods (methods without a body).
```java
abstract class Animal {
    abstract void makeSound(); // No implementation
}

class Dog extends Animal {
    void makeSound() {
        System.out.println("Dog barks");
    }
}
```

---

## **3️⃣ Interfaces in Java**
An **interface** is a contract that defines **methods** that a class must implement. **It only contains method signatures** (without implementations).

### **🔹 Key Differences Between a Class and an Interface**
| Feature | Class | Interface |
|---------|------|------------|
| **Method Implementation** | Can have method bodies | Only method declarations (until Java 8) |
| **Multiple Inheritance** | **Not allowed** (only single inheritance) | **Allowed** (a class can implement multiple interfaces) |
| **Objects** | Can create objects | Cannot create objects |
| **Access Modifiers** | Methods can have any access modifier | Methods are always `public abstract` by default |

---

## **4️⃣ Declaring and Using an Interface**
### **🔹 Example: Defining an Interface**
```java
interface Animal {
    void makeSound(); // Abstract method (no body)
}
```

### **🔹 Example: Implementing an Interface**
A **class must override all methods** of an interface.
```java
class Dog implements Animal {
    public void makeSound() { // Must be public
        System.out.println("Dog barks");
    }
}

// Main Class
public class Main {
    public static void main(String[] args) {
        Dog myDog = new Dog();
        myDog.makeSound(); // Output: Dog barks
    }
}
```

✅ **Key Points:**
- **Use `implements` keyword** to inherit from an interface.
- **All methods in an interface are `public abstract` by default.**
- **A class must provide implementations** for all interface methods.

---

## **5️⃣ Multiple Interfaces in Java**
A class can implement **multiple interfaces**, allowing multiple inheritances.

### **🔹 Example: Multiple Interfaces**
```java
interface Animal {
    void makeSound();
}

interface Pet {
    void play();
}

// Implementing both interfaces
class Dog implements Animal, Pet {
    public void makeSound() {
        System.out.println("Dog barks");
    }

    public void play() {
        System.out.println("Dog is playing");
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        Dog myDog = new Dog();
        myDog.makeSound();
        myDog.play();
    }
}
```
### **Output**
```
Dog barks
Dog is playing
```

✅ **Java allows multiple interface inheritance but NOT multiple class inheritance**.

---

## **6️⃣ Interface with Default & Static Methods (Java 8+)**
In Java 8+, interfaces **can have default and static methods** (with implementations).

### **🔹 Example: Interface with Default and Static Methods**
```java
interface Animal {
    void makeSound(); // Abstract method

    // Default method (Can have a body)
    default void sleep() {
        System.out.println("Animal is sleeping");
    }

    // Static method
    static void breathe() {
        System.out.println("Animal is breathing");
    }
}

// Implementing class
class Dog implements Animal {
    public void makeSound() {
        System.out.println("Dog barks");
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        Dog myDog = new Dog();
        myDog.makeSound();
        myDog.sleep(); // Calling default method

        Animal.breathe(); // Calling static method
    }
}
```
### **Output**
```
Dog barks
Animal is sleeping
Animal is breathing
```

✅ **Default methods allow backward compatibility** (e.g., adding new methods without breaking old implementations).

---

## **7️⃣ Abstract Class vs. Interface (Comparison Table)**
| Feature | Abstract Class | Interface |
|---------|---------------|------------|
| **Inheritance** | Can extend only **one** class | Can implement **multiple** interfaces |
| **Method Type** | Can have both abstract and concrete methods | Only abstract methods (until Java 8) |
| **Constructors** | Can have constructors | Cannot have constructors |
| **Fields (Variables)** | Can have instance variables | Only `public static final` (constants) |
| **Usage** | Used when classes share common behavior | Used when classes should follow a contract |

---

## **8️⃣ Summary**
| Feature | Class | Abstract Class | Interface |
|---------|-------|---------------|-----------|
| Can create objects? | ✅ Yes | ❌ No | ❌ No |
| Can have constructors? | ✅ Yes | ✅ Yes | ❌ No |
| Can have method implementations? | ✅ Yes | ✅ Yes | ❌ No (until Java 8) |
| Can contain abstract methods? | ❌ No | ✅ Yes | ✅ Yes |
| Can have static methods? | ✅ Yes | ✅ Yes | ✅ Yes (Java 8+) |
| Can extend multiple? | ❌ No | ❌ No | ✅ Yes |

---

## **9️⃣ When to Use Classes vs. Interfaces?**
🔹 **Use a Class** if:
- You need to create objects with behavior.
- You need instance variables and methods.

🔹 **Use an Abstract Class** if:
- You need a base class with some common logic.
- You need constructors.
- You want partial method implementations.

🔹 **Use an Interface** if:
- You want to enforce a contract across multiple unrelated classes.
- You need multiple inheritances.

---

## **🔟 Final Notes**
✅ **Use `class` for creating objects and encapsulating behavior.**  
✅ **Use `abstract class` if you need a common base with default behavior.**  
✅ **Use `interface` when multiple classes share common behavior but are unrelated.**  
✅ **From Java 8+, interfaces can have default and static methods.**  

Would you like a **deep dive into Object-Oriented Programming (OOP) principles in Java** next? 😊