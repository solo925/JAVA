### **Networking and Sockets in Java**
Networking in Java is handled using the **java.net** package, which provides classes for communication over a network. The **Socket** and **ServerSocket** classes allow TCP-based communication between a client and a server.

---

## **1. Basic Client-Server Communication (TCP Sockets)**
This example demonstrates a **simple server** that listens for connections and a **client** that sends a message.

### **Server Code (Socket Server)**
```java
import java.io.*;
import java.net.*;

public class SimpleServer {
    public static void main(String[] args) {
        int port = 5000; // Port number

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is running and waiting for a client...");

            // Accept client connection
            Socket socket = serverSocket.accept();
            System.out.println("Client connected!");

            // Get input from client
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String clientMessage = input.readLine();
            System.out.println("Client says: " + clientMessage);

            // Send response to client
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            output.println("Hello from Server!");

            // Close resources
            input.close();
            output.close();
            socket.close();
            System.out.println("Connection closed.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

---

### **Client Code (Socket Client)**
```java
import java.io.*;
import java.net.*;

public class SimpleClient {
    public static void main(String[] args) {
        String serverAddress = "localhost"; // Server address
        int port = 5000; // Server port

        try (Socket socket = new Socket(serverAddress, port)) {
            System.out.println("Connected to server.");

            // Send message to server
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
            output.println("Hello Server!");

            // Receive response from server
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String serverMessage = input.readLine();
            System.out.println("Server says: " + serverMessage);

            // Close resources
            input.close();
            output.close();
            System.out.println("Connection closed.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

---

### **How It Works**
1. The **server** listens for incoming client connections on port **5000**.
2. The **client** connects to the server and sends a message **"Hello Server!"**.
3. The **server** reads the message and replies with **"Hello from Server!"**.
4. Both close their connections after communication.

---

### **2. Multi-Client Server (Handling Multiple Clients)**
The previous example only supports **one client at a time**. To handle multiple clients, we can use **threads**.

### **Multi-Client Server Code**
```java
import java.io.*;
import java.net.*;

public class MultiClientServer {
    public static void main(String[] args) {
        int port = 5000;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Multi-client server started...");

            while (true) {
                // Accept new client connection
                Socket clientSocket = serverSocket.accept();
                System.out.println("New client connected!");

                // Handle each client in a new thread
                new ClientHandler(clientSocket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// Thread class for handling individual clients
class ClientHandler extends Thread {
    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            // Input and Output Streams
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            output.println("Welcome! Type 'exit' to disconnect.");
            
            String message;
            while ((message = input.readLine()) != null) {
                System.out.println("Client says: " + message);
                output.println("Server received: " + message);

                if (message.equalsIgnoreCase("exit")) {
                    break;
                }
            }

            // Close resources
            input.close();
            output.close();
            socket.close();
            System.out.println("Client disconnected.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

---

### **Client Code (Same as Before)**
Use the **SimpleClient** code from the first example to connect multiple clients to the server.

---

### **3. UDP Communication (Faster but Unreliable)**
UDP (User Datagram Protocol) is **faster** than TCP but does not guarantee delivery.

#### **UDP Server**
```java
import java.net.*;

public class UDPServer {
    public static void main(String[] args) {
        int port = 5000;

        try (DatagramSocket socket = new DatagramSocket(port)) {
            System.out.println("UDP Server is running...");

            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            // Receive data from client
            socket.receive(packet);
            String received = new String(packet.getData(), 0, packet.getLength());
            System.out.println("Received from client: " + received);

            // Send response
            String response = "Hello from UDP Server!";
            byte[] responseData = response.getBytes();
            DatagramPacket responsePacket = new DatagramPacket(
                responseData, responseData.length, packet.getAddress(), packet.getPort()
            );
            socket.send(responsePacket);
            System.out.println("Response sent.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

---

#### **UDP Client**
```java
import java.net.*;

public class UDPClient {
    public static void main(String[] args) {
        String serverAddress = "localhost";
        int port = 5000;

        try (DatagramSocket socket = new DatagramSocket()) {
            String message = "Hello UDP Server!";
            byte[] buffer = message.getBytes();

            // Send packet
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, InetAddress.getByName(serverAddress), port);
            socket.send(packet);
            System.out.println("Message sent to server.");

            // Receive response
            byte[] responseBuffer = new byte[1024];
            DatagramPacket responsePacket = new DatagramPacket(responseBuffer, responseBuffer.length);
            socket.receive(responsePacket);

            String response = new String(responsePacket.getData(), 0, responsePacket.getLength());
            System.out.println("Server response: " + response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

---

### **Conclusion**
| Feature | TCP (Sockets) | UDP (Datagram) |
|---------|--------------|---------------|
| **Reliability** | Reliable | Unreliable |
| **Speed** | Slower | Faster |
| **Connection Type** | Connection-Oriented | Connectionless |
| **Use Case** | Web apps, Chat apps | Video streaming, Gaming |

---

### **Which one should you use?**
- **TCP** (Sockets) → Use for chat applications, file transfers, and web communication.
- **UDP** (Datagrams) → Use for real-time applications like gaming, VoIP, and video streaming.

Would you like an **example with GUI (JavaFX)** or **file transfer over a network**? 🚀