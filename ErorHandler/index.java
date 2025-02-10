## **Exception Handling in Java**

**Exception handling** in Java is used to manage runtime errors and ensure smooth program execution. Java provides a structured way to handle errors using **try, catch, finally, throw, and throws**.

---

## **1. Basic Exception Handling**
The `try-catch` block is used to handle exceptions and prevent program crashes.

### **Example: Handling Division by Zero**
```java
public class ExceptionExample {
    public static void main(String[] args) {
        try {
            int a = 10, b = 0;
            int result = a / b; // This will throw an ArithmeticException
            System.out.println(result);
        } catch (ArithmeticException e) {
            System.out.println("Cannot divide by zero!"); // Custom error message
        }
    }
}
```
### **Output:**
```
Cannot divide by zero!
```
✅ The program **does not crash**, and we handle the error gracefully.

---

## **2. Multiple Catch Blocks**
A `try` block can have multiple `catch` blocks to handle different exceptions.

### **Example: Handling Different Exceptions**
```java
public class MultipleCatchExample {
    public static void main(String[] args) {
        try {
            int[] arr = {1, 2, 3};
            System.out.println(arr[5]); // ArrayIndexOutOfBoundsException
        } catch (ArithmeticException e) {
            System.out.println("Arithmetic Exception occurred.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array Index Out of Bounds Exception occurred.");
        } catch (Exception e) {
            System.out.println("Some other exception occurred.");
        }
    }
}
```
### **Output:**
```
Array Index Out of Bounds Exception occurred.
```
✅ The correct `catch` block handles the specific exception.

---

## **3. Finally Block**
The `finally` block **always executes**, whether an exception occurs or not.

### **Example: Using Finally**
```java
public class FinallyExample {
    public static void main(String[] args) {
        try {
            int num = 5 / 0; // ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("Exception caught.");
        } finally {
            System.out.println("This block always runs.");
        }
    }
}
```
### **Output:**
```
Exception caught.
This block always runs.
```
✅ The `finally` block ensures **clean-up operations** (e.g., closing a file or database connection).

---

## **4. Throwing Custom Exceptions (`throw`)**
The `throw` keyword is used to manually throw an exception.

### **Example: Throwing an Exception**
```java
public class ThrowExample {
    public static void checkAge(int age) {
        if (age < 18) {
            throw new IllegalArgumentException("You must be 18 or older.");
        }
        System.out.println("You are eligible.");
    }

    public static void main(String[] args) {
        checkAge(16); // Throws an exception
    }
}
```
### **Output:**
```
Exception in thread "main" java.lang.IllegalArgumentException: You must be 18 or older.
```
✅ The program **throws an exception** when an invalid age is provided.

---

## **5. Declaring Exceptions (`throws`)**
The `throws` keyword is used to **declare an exception** in a method.

### **Example: Using `throws`**
```java
public class ThrowsExample {
    public static void divide(int a, int b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero.");
        }
        System.out.println(a / b);
    }

    public static void main(String[] args) {
        try {
            divide(10, 0);
        } catch (ArithmeticException e) {
            System.out.println("Exception caught: " + e.getMessage());
        }
    }
}
```
### **Output:**
```
Exception caught: Cannot divide by zero.
```
✅ `throws` tells the compiler that the method **may throw an exception**, and handling is required.

---

## **6. Custom Exception Class**
You can create **custom exceptions** by extending `Exception` or `RuntimeException`.

### **Example: Creating a Custom Exception**
```java
// Custom Exception Class
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

// Using the Custom Exception
public class CustomExceptionExample {
    public static void checkAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or older.");
        }
        System.out.println("Access granted.");
    }

    public static void main(String[] args) {
        try {
            checkAge(15); // Throws our custom exception
        } catch (InvalidAgeException e) {
            System.out.println("Caught: " + e.getMessage());
        }
    }
}
```
### **Output:**
```
Caught: Age must be 18 or older.
```
✅ Custom exceptions improve **code clarity** and **error handling**.

---

## **7. Exception Hierarchy**
Java exceptions are categorized into:
- **Checked Exceptions** (must be handled) → `IOException`, `SQLException`
- **Unchecked Exceptions** (runtime errors) → `NullPointerException`, `ArithmeticException`
- **Errors** (system-level issues) → `OutOfMemoryError`, `StackOverflowError`

---

## **8. Summary**
| Keyword | Usage |
|---------|-------|
| **try** | Defines a block of code to test for errors. |
| **catch** | Handles the exception thrown in the try block. |
| **finally** | A block that always executes (cleanup code). |
| **throw** | Used to manually throw an exception. |
| **throws** | Declares an exception that a method may throw. |

---

## **🚀 Key Takeaways**
✅ **Use `try-catch` to prevent crashes**  
✅ **Always clean up resources using `finally`**  
✅ **Use `throw` to raise custom errors**  
✅ **Use `throws` to declare exceptions in methods**  
✅ **Custom exceptions make error handling clearer**  

Would you like more real-world examples? 😊