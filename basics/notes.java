Here’s a basic overview of Java syntax with key elements:

### 1. **Basic Java Program Structure**
Every Java program must have a class and a `main` method.
```java
// Class definition
public class HelloWorld {
    // Main method (entry point)
    public static void main(String[] args) {
        System.out.println("Hello, World!"); // Output statement
    }
}
```
### 2. **Variables & Data Types**
Java is a statically typed language, meaning you must declare variable types.
```java
int age = 25;           // Integer
double price = 19.99;   // Floating-point number
char grade = 'A';       // Character
boolean isJavaFun = true; // Boolean
String message = "Hello Java"; // String (Note: String is a class)
```
### 3. **Operators**
Java has arithmetic, relational, logical, and assignment operators:
```java
int x = 10, y = 5;
int sum = x + y; // Addition
boolean isGreater = x > y; // Comparison
boolean result = (x > 5) && (y < 10); // Logical AND
```
### 4. **Control Flow Statements**
#### (a) Conditional Statements (`if-else`, `switch`)
```java
if (x > 0) {
    System.out.println("Positive number");
} else {
    System.out.println("Not positive");
}

// Switch case example
int day = 2;
switch (day) {
    case 1:
        System.out.println("Monday");
        break;
    case 2:
        System.out.println("Tuesday");
        break;
    default:
        System.out.println("Other day");
}
```
#### (b) Loops (`for`, `while`, `do-while`)
```java
// For loop
for (int i = 0; i < 5; i++) {
    System.out.println("Iteration: " + i);
}

// While loop
int count = 0;
while (count < 3) {
    System.out.println("Count: " + count);
    count++;
}

// Do-while loop
int num = 0;
do {
    System.out.println("Number: " + num);
    num++;
} while (num < 3);
```
### 5. **Functions (Methods)**
```java
// Method definition
public static int addNumbers(int a, int b) {
    return a + b;
}

// Calling the method
int result = addNumbers(5, 3);
System.out.println("Sum: " + result);
```
### 6. **Classes & Objects**
```java
// Defining a class
class Car {
    String brand;
    
    // Constructor
    Car(String brand) {
        this.brand = brand;
    }
    
    // Method
    void showBrand() {
        System.out.println("Car brand: " + brand);
    }
}

// Creating an object
public class Main {
    public static void main(String[] args) {
        Car myCar = new Car("Toyota"); // Creating an instance
        myCar.showBrand(); // Calling a method
    }
}
```
### 7. **Arrays**
```java
int[] numbers = {1, 2, 3, 4, 5}; // Array declaration

// Looping through an array
for (int num : numbers) {
    System.out.println(num);
}
```
### 8. **Exception Handling**
```java
try {
    int result = 10 / 0; // This will cause an error
} catch (ArithmeticException e) {
    System.out.println("Cannot divide by zero!");
} finally {
    System.out.println("Execution completed.");
}
```
---
This is a quick overview, but Java has many more features like object-oriented programming (OOP), interfaces, collections, multithreading, and more! 🚀