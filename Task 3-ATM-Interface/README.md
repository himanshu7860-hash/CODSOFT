# 🏧 ATM Interface — CodSoft Java Internship | Task 3

> A console-based ATM Interface System built using Core Java as part of the **CodSoft Java Programming Internship**.

---

## 📌 Project Description

This project simulates a real-world **ATM (Automated Teller Machine)** system through a Java console application. The user is greeted with a menu-driven interface where they can perform common banking operations such as checking their account balance, depositing money, and withdrawing cash — all while the program validates every input and displays appropriate success or error messages.

The project is divided into clean, well-structured classes following Object-Oriented Programming principles, making it easy to understand, extend, and maintain.

---

## ✨ Features

- ✅ **Check Balance** — View the current account balance at any time
- ✅ **Deposit Money** — Add funds to the account with minimum amount validation
- ✅ **Withdraw Money** — Withdraw cash with balance and withdrawal limit checks
- ✅ **Input Validation** — Handles invalid inputs (letters, negative numbers, zero amounts) gracefully
- ✅ **Withdrawal Limit** — Enforces a per-transaction maximum withdrawal cap (₹10,000)
- ✅ **User-Friendly Messages** — Clear success and error messages for every operation
- ✅ **Loop-Based Menu** — Keeps the session running until the user chooses to exit

---

## 🛠️ Technologies Used

| Technology | Purpose |
|---|---|
| **Java (JDK 8+)** | Core programming language |
| **Scanner (java.util)** | Reading user input from the console |
| **Object-Oriented Design** | Structuring code into classes and objects |
| **Exception Handling** | Catching invalid inputs using `try-catch` |

---

## 🧠 Concepts Used

### 1. Object-Oriented Programming (OOP)
The project is built around two core classes:
- **`BankAccount`** — Represents the user's bank account (data + basic operations)
- **`ATM`** — Represents the ATM machine (business logic + validation)
- **`Main`** — The entry point that handles the user interface

### 2. Encapsulation
The `balance` field in `BankAccount` is declared `private`, meaning it cannot be accessed directly from outside the class. It is only modified through controlled methods (`deposit()` and `withdraw()`), keeping data safe.

### 3. Method Design
Each ATM operation is implemented as its own method:
- `checkBalance()` — reads and displays the balance
- `deposit(double amount)` — validates and adds funds
- `withdraw(double amount)` — validates and deducts funds

### 4. Input Validation
All user inputs are wrapped in `try-catch` blocks to handle `NumberFormatException` when non-numeric values are entered, preventing the program from crashing.

### 5. Control Flow
- A `while` loop keeps the ATM session running continuously
- A `switch` statement routes the user to the correct operation based on their menu choice
- `if-else` chains handle multiple validation scenarios in sequence

### 6. Static Constants
Maximum withdrawal limit and minimum deposit amount are stored as `static final` constants, making them easy to find and change in one place.

---

## 🗂️ Project Structure

```
ATM_Project/
│
├── BankAccount.java    → Stores account holder name and balance
│                         Methods: deposit(), withdraw(), getBalance()
│
├── ATM.java            → ATM logic with validation
│                         Methods: checkBalance(), deposit(), withdraw()
│
└── Main.java           → Entry point and user interface
                          Handles menu loop and input reading
```

---

## ⚙️ How It Works

```
Program Starts
     │
     ▼
User enters their name → BankAccount is created with ₹5,000 starting balance
     │
     ▼
ATM object is created and linked to the BankAccount
     │
     ▼
┌─────────────────────────────┐
│         MAIN MENU           │
│  1. Check Balance           │
│  2. Deposit Money           │
│  3. Withdraw Money          │
│  4. Exit                    │
└─────────────────────────────┘
     │
     ├── Option 1 → ATM.checkBalance() → prints name + balance
     │
     ├── Option 2 → User enters amount
     │              ATM.deposit() validates:
     │              • Amount > 0?
     │              • Amount >= minimum deposit?
     │              → If valid: balance increases, success message shown
     │              → If invalid: error message shown, balance unchanged
     │
     ├── Option 3 → User enters amount
     │              ATM.withdraw() validates:
     │              • Amount > 0?
     │              • Amount <= withdrawal limit (₹10,000)?
     │              • Amount <= current balance?
     │              → If valid: balance decreases, success message shown
     │              → If invalid: error message shown, balance unchanged
     │
     └── Option 4 → Session ends, goodbye message displayed
```

---

## ▶️ How to Run

### Prerequisites
- Java JDK 8 or above installed
- A terminal / command prompt

### Steps

**Step 1 — Save all three files in the same folder:**
```
ATM_Project/
  ├── BankAccount.java
  ├── ATM.java
  └── Main.java
```

**Step 2 — Open terminal in that folder and compile:**
```bash
javac BankAccount.java ATM.java Main.java
```

**Step 3 — Run the program:**
```bash
java Main
```

---

## 💻 Sample Output

```
==========================================
       WELCOME TO JAVA ATM SYSTEM
==========================================
Enter your name: Rahul
Hello, Rahul! Your account has been loaded.
Starting Balance: Rs. 5000.00

==========================================
             ATM MAIN MENU
==========================================
  1. Check Balance
  2. Deposit Money
  3. Withdraw Money
  4. Exit
==========================================
Enter your choice (1-4): 2

--- DEPOSIT MONEY ---
Enter amount to deposit (Rs.): 2000
----------------------------------
  SUCCESS: Rs. 2000.00 deposited successfully!
  New Balance: Rs. 7000.00
----------------------------------

Enter your choice (1-4): 3

--- WITHDRAW MONEY ---
Enter amount to withdraw (Rs.): 15000
----------------------------------
  ERROR: Cannot withdraw more than Rs. 10000.00 at once.
----------------------------------

Enter your choice (1-4): 4

  Thank you for using Java ATM System!
  Goodbye, Rahul!
==========================================
```

---

## 📚 What I Learned

- Designing a real-world problem using **Object-Oriented Programming**
- Writing **multiple classes** that communicate with each other
- Using **encapsulation** to protect sensitive data (account balance)
- Implementing **input validation** and **exception handling**
- Building a **menu-driven console application** in Java

---

## 🏢 About the Internship

**Internship:** CodSoft Java Programming Internship  
**Task Number:** Task 3 — ATM Interface  
**Language:** Java  

---

*Built with ❤️ using Core Java*
