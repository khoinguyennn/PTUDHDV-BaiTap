# Socket Programming in Java - Lab 2/6

This project implements socket programming exercises including basic client-server communication, sum calculator, and quadratic equation solver.

## Project Structure

```
src/bai1/
├── Client.java              # Basic client (Practice 2)
├── Server.java              # Basic server (Practice 3)
├── SumClient.java           # Client for sum calculation (Practice 4.1)
├── SumServer.java           # Server for sum calculation (Practice 4.2)
├── QuadraticEquation.java   # Quadratic equation solver class (Practice 4.3)
├── QuadraticClient.java     # Client for quadratic equation
└── QuadraticServer.java     # Server for quadratic equation
```

## Prerequisites

- Java 8 or higher
- Java IDE (Eclipse recommended)

## How to Run

### Exercise 1: Basic Client-Server Communication

**Purpose:** Server listens for connection, client connects and sends messages until "Over" is sent.

**Steps:**
1. **Run Server first:**
   ```powershell
   cd d:\HKI_2025-2026\PTUDHDV\PTUDHDV-BaiTap\MyWorkSpace\IP_Programming_2_6
   javac -d bin src/bai1/Server.java
   java -cp bin bai1.Server
   ```
   Output: `Server started` and `Waiting for a client ...`

2. **Run Client in a new terminal:**
   ```powershell
   cd d:\HKI_2025-2026\PTUDHDV\PTUDHDV-BaiTap\MyWorkSpace\IP_Programming_2_6
   javac -d bin src/bai1/Client.java
   java -cp bin bai1.Client
   ```
   Output: `Connected to server`

3. **Send messages:**
   - Type any message and press Enter
   - Messages will appear on the Server console
   - Type "Over" to close the connection

---

### Exercise 2: Sum Calculator (Practice 4.1 & 4.2)

**Purpose:** Client sends two numbers to server, server calculates sum and returns result.

**Steps:**
1. **Run SumServer first:**
   ```powershell
   cd d:\HKI_2025-2026\PTUDHDV\PTUDHDV-BaiTap\MyWorkSpace\IP_Programming_2_6
   javac -d bin src/bai1/SumServer.java
   java -cp bin bai1.SumServer
   ```
   Output: `Sum Server started on port 5001` and `Waiting for a client ...`

2. **Run SumClient in a new terminal:**
   ```powershell
   cd d:\HKI_2025-2026\PTUDHDV\PTUDHDV-BaiTap\MyWorkSpace\IP_Programming_2_6
   javac -d bin src/bai1/SumClient.java
   java -cp bin bai1.SumClient
   ```

3. **Enter numbers:**
   - Enter first number (e.g., 6)
   - Enter second number (e.g., 9)
   - Server calculates and returns: `Sum of 6 + 9 = 15`

**Example:**
```
Enter first number: 6
Enter second number: 9
Sent: 6 and 9
Result from server: Sum of 6 + 9 = 15
```

---

### Exercise 3: Quadratic Equation Solver (Practice 4.3)

**Purpose:** Client sends coefficients a, b, c to server. Server solves quadratic equation ax² + bx + c = 0 and returns result.

**Steps:**
1. **Run QuadraticServer first:**
   ```powershell
   cd d:\HKI_2025-2026\PTUDHDV\PTUDHDV-BaiTap\MyWorkSpace\IP_Programming_2_6
   javac -d bin src/bai1/QuadraticEquation.java src/bai1/QuadraticServer.java
   java -cp bin bai1.QuadraticServer
   ```
   Output: `Quadratic Equation Server started on port 5002` and `Waiting for a client ...`

2. **Run QuadraticClient in a new terminal:**
   ```powershell
   cd d:\HKI_2025-2026\PTUDHDV\PTUDHDV-BaiTap\MyWorkSpace\IP_Programming_2_6
   javac -d bin src/bai1/QuadraticClient.java
   java -cp bin bai1.QuadraticClient
   ```

3. **Enter coefficients:**
   - Enter a (coefficient of x²)
   - Enter b (coefficient of x)
   - Enter c (constant term)
   - Server solves and returns result

**Examples:**
```
Example 1: x² - 3x + 2 = 0
Enter a: 1
Enter b: -3
Enter c: 2
Result: Phuong trinh co 2 nghiem phan biet: x1 = 2.0, x2 = 1.0

Example 2: x² - 2x + 1 = 0
Enter a: 1
Enter b: -2
Enter c: 1
Result: Phuong trinh co nghiem kep: x1 = x2 = 1.0

Example 3: x² + 1 = 0
Enter a: 1
Enter b: 0
Enter c: 1
Result: Phuong trinh vo nghiem (No real solution, delta < 0)
```

---

## Technical Details

### Ports Used
- **Basic Client-Server:** Port 5000
- **Sum Calculator:** Port 5001
- **Quadratic Equation Solver:** Port 5002

### Classes and Methods

**QuadraticEquation.java**
- `giaiPT2(int a, int b, int c)`: Solves quadratic equation
  - Returns solution as String
  - Handles all cases: no solution, one solution, two solutions
  - Handles linear equations (when a = 0)

### Notes

1. **Always run Server before Client** - Server must be listening before client attempts to connect
2. **Port conflicts** - Make sure ports (5000, 5001, 5002) are not used by other applications
3. **One connection per run** - Current implementation handles one client connection per server run
4. **Testing in Eclipse:**
   - Open two Console views
   - Run Server in first console
   - Run Client in second console

## Common Issues

1. **"Connection refused"** - Server is not running or wrong port
2. **"Address already in use"** - Port is occupied, wait a few seconds or use different port
3. **No output** - Make sure you run Server first before Client

## Learning Objectives Achieved

✓ Understanding Socket programming basics
✓ Creating client-server applications
✓ Using DataInputStream and DataOutputStream
✓ Implementing request-response pattern
✓ Separating business logic (QuadraticEquation) from network code

## References

- [GeeksforGeeks - Socket Programming in Java](https://www.geeksforgeeks.org/socket-programming-in-java/)
- Java Documentation: java.net.Socket
- Java Documentation: java.net.ServerSocket
