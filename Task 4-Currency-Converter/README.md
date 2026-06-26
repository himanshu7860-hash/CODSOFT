# 💱 Currency Converter — CodSoft Java Internship | Task 2

> A console-based Currency Converter built using Core Java that fetches **live exchange rates** from a free API — no API key required!

---

## 📌 Project Description

This project is a **real-time Currency Converter** built as a Java console application. The user selects a base currency and a target currency from a list of 10 popular world currencies, enters an amount, and the program fetches the latest exchange rate from a live API and instantly displays the converted result along with the exchange rate used.

The entire project is contained in a **single Java file**, making it clean and beginner-friendly, with every section clearly commented.

---

## ✨ Features

- ✅ **Live Exchange Rates** — Fetches real-time rates from `open.er-api.com` (free, no API key needed)
- ✅ **10 Popular Currencies** — USD, INR, EUR, GBP, JPY, AUD, CAD, AED, SGD, CHF
- ✅ **Currency Selection Menu** — Numbered menu for easy base and target currency selection
- ✅ **Amount Validation** — Rejects zero, negative, and non-numeric inputs
- ✅ **Detailed Result Display** — Shows converted amount, currency symbol, and exchange rate used
- ✅ **Convert Again Option** — Lets the user do multiple conversions in one session

---

## 🛠️ Technologies Used

| Technology | Purpose |
|---|---|
| **Java (JDK 11+)** | Core programming language |
| **java.net.http.HttpClient** | Sending HTTP GET requests to the API |
| **ExchangeRate-API (free tier)** | Source of live currency exchange rates |
| **LinkedHashMap** | Storing and displaying currencies in order |
| **Scanner (java.util)** | Reading user input from the console |

---

## 🧠 Concepts Used

### 1. HTTP Networking
Uses Java's built-in `HttpClient` (introduced in Java 11) to send a `GET` request to the exchange rate API and receive a JSON response — no external libraries needed.

### 2. Manual JSON Parsing
The API response is a raw JSON string. Instead of using a library like Gson, the program manually searches for the target currency key using `String.indexOf()` and extracts the rate value — a great exercise in string manipulation.

### 3. Collections — LinkedHashMap
All 10 supported currencies are stored in a `LinkedHashMap<Integer, String[]>`, which maps a menu number to an array holding the currency code, name, and symbol. `LinkedHashMap` preserves insertion order, so the menu always appears in the same sequence.

### 4. Input Validation & Exception Handling
Every user input is wrapped in a `try-catch` block to catch `NumberFormatException`, and value ranges are checked (e.g., amount must be > 0, menu choice must be 1–10), keeping the program crash-proof.

### 5. Static Helper Methods
The logic is broken into focused static methods — `fetchExchangeRate()`, `getValidMenuChoice()`, and `getValidAmount()` — keeping the `main()` method clean and readable.

---

## ⚙️ How It Works

```
Program Starts
     │
     ▼
Display currency menu (10 currencies with codes & symbols)
     │
     ▼
User selects BASE currency  →  User selects TARGET currency
     │
     ▼
User enters amount to convert
     │
     ▼
HTTP GET → https://open.er-api.com/v6/latest/{BASE}
     │
     ▼
Parse JSON response → extract rate for TARGET currency
     │
     ▼
converted amount = input amount × exchange rate
     │
     ▼
Display result: amount, converted value, rate used
     │
     ▼
Ask "Convert again?" → Yes: repeat | No: exit
```

---

## ▶️ How to Run

### Prerequisites
- **Java JDK 11 or above** (uses `java.net.http.HttpClient`)
- Active internet connection (needed to fetch live rates)

Check your Java version:
```bash
java -version
```

### Steps

**Step 1 — Save the file:**
```
CurrencyConverter/
  └── CurrencyConverter.java
```

**Step 2 — Compile:**
```bash
javac CurrencyConverter.java
```

**Step 3 — Run:**
```bash
java CurrencyConverter
```

---

## 💻 Sample Output

```
==========================================
      JAVA CURRENCY CONVERTER
     (Live Rates via ExchangeRate-API)
==========================================

  No.  Code   Name                      Symbol
  1    USD    US Dollar                 $
  2    INR    Indian Rupee              Rs.
  3    EUR    Euro                      EUR
  ...

Enter number for BASE currency: 1
Enter number for TARGET currency: 2
Enter amount in US Dollar ($): 500

  Fetching live exchange rate... please wait.

==========================================
           CONVERSION RESULT
==========================================
  $ 500.00  (USD)
        converts to
  Rs. 41750.00  (INR)
------------------------------------------
  Exchange Rate: 1 USD = 83.5000 INR
  (Rates provided by open.er-api.com)
==========================================

Do you want to convert again? (yes/no): no

  Thank you for using Java Currency Converter! Goodbye!
```

---

## 📚 What I Learned

- Making **real-time API calls** in Java using `HttpClient`
- **Parsing JSON responses** manually without external libraries
- Using **Collections** (`LinkedHashMap`) to structure menu data
- Writing **reusable static methods** for clean, modular code
- Handling **network errors and invalid inputs** gracefully

---

## 🏢 About the Internship

**Internship:** CodSoft Java Programming Internship  
**Task Number:** Task 2 — Currency Converter  
**Language:** Java  
**API Used:** [ExchangeRate-API Free Tier](https://open.er-api.com) *(no key required)*

---

*Built with ❤️ using Core Java*
