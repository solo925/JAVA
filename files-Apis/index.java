# **🔹 Working with Files and APIs in Java**  

In Java, handling **files** and **APIs** is common in real-world applications. This guide covers:  
1️⃣ **File Handling (Reading, Writing, Appending, Deleting)**  
2️⃣ **Working with APIs using HTTP Requests**  

---

# **1️⃣ File Handling in Java**
Java provides classes from the `java.io` and `java.nio` packages for **file operations**.

### **🔹 Creating a File**
Use `File` class to **create a new file**.
```java
import java.io.File;
import java.io.IOException;

public class FileExample {
    public static void main(String[] args) {
        try {
            File file = new File("example.txt");
            if (file.createNewFile()) {
                System.out.println("File created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
```
✅ **Checks if the file exists, creates one if not.**  
✅ **Catches `IOException` if something goes wrong.**

---

### **🔹 Writing to a File**
Use `FileWriter` to write text to a file.
```java
import java.io.FileWriter;
import java.io.IOException;

public class WriteToFile {
    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("example.txt");
            writer.write("Hello, this is a test file.\nWelcome to Java!");
            writer.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
```
✅ **Overwrites existing content**  
✅ **Use `writer.close()` to ensure data is saved properly.**  

---

### **🔹 Appending to a File**
Use `FileWriter` with `true` to append instead of overwrite.
```java
import java.io.FileWriter;
import java.io.IOException;

public class AppendToFile {
    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("example.txt", true);
            writer.write("\nThis is an appended line.");
            writer.close();
            System.out.println("Successfully appended to the file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```
✅ **The second parameter `true` enables appending.**  

---

### **🔹 Reading a File**
Use `Scanner` or `BufferedReader` to read a file.
```java
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {
    public static void main(String[] args) {
        try {
            File file = new File("example.txt");
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                System.out.println(data);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }
    }
}
```
✅ **Reads a file line by line using `Scanner`**  

---

### **🔹 Deleting a File**
```java
import java.io.File;

public class DeleteFile {
    public static void main(String[] args) {
        File file = new File("example.txt");
        if (file.delete()) {
            System.out.println("Deleted the file: " + file.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }
    }
}
```
✅ **Deletes the file if it exists.**  

---

## **2️⃣ Working with APIs (HTTP Requests in Java)**
To make HTTP requests, use **Java's built-in `HttpURLConnection`** or third-party libraries like **OkHttp** or **Apache HttpClient**.

---

### **🔹 Making a Simple GET Request (Built-in `HttpURLConnection`)**
```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpGetExample {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://jsonplaceholder.typicode.com/posts/1"); // Sample API
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            int responseCode = conn.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = reader.readLine()) != null) {
                response.append(inputLine);
            }
            reader.close();

            System.out.println("Response: " + response.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```
✅ **Sends a `GET` request to an API and prints the response.**  
✅ **Uses `HttpURLConnection`.**  

---

### **🔹 Making a POST Request with JSON**
To send data, set request headers and write JSON to the request body.
```java
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpPostExample {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://jsonplaceholder.typicode.com/posts");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            String jsonInput = "{\"title\": \"Java API\", \"body\": \"Testing POST request\", \"userId\": 1}";

            try (OutputStream os = conn.getOutputStream()) {
                byte[] input = jsonInput.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            int responseCode = conn.getResponseCode();
            System.out.println("Response Code: " + responseCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```
✅ **Sends JSON data via `POST`.**  
✅ **Uses `OutputStream` to write the request body.**  

---

### **🔹 Using OkHttp for Simpler API Requests**
If you are working with APIs frequently, use **OkHttp** (modern and efficient).

#### **📌 Install OkHttp (Maven)**
```xml
<dependency>
    <groupId>com.squareup.okhttp3</groupId>
    <artifactId>okhttp</artifactId>
    <version>4.9.3</version>
</dependency>
```

#### **🔹 OkHttp GET Request**
```java
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpGet {
    public static void main(String[] args) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://jsonplaceholder.typicode.com/posts/1")
                .build();

        try (Response response = client.newCall(request).execute()) {
            System.out.println(response.body().string());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```
✅ **More readable and efficient API requests.**  

---

## **3️⃣ Summary**
| **Feature** | **Method** | **Library** |
|------------|-----------|-------------|
| **File Creation** | `File.createNewFile()` | `java.io.File` |
| **File Writing** | `FileWriter` | `java.io.FileWriter` |
| **File Reading** | `Scanner`, `BufferedReader` | `java.util.Scanner` |
| **File Appending** | `FileWriter(true)` | `java.io.FileWriter` |
| **File Deletion** | `File.delete()` | `java.io.File` |
| **GET Request** | `HttpURLConnection` | Built-in |
| **POST Request** | `HttpURLConnection` | Built-in |
| **Modern API Requests** | `OkHttpClient` | OkHttp |

Would you like to dive deeper into **RESTful API development in Java** using **Spring Boot**? 😊