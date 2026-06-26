# 🎯 Guess The Number — CodSoft Java Internship | Task 1

> A fun console-based number guessing game built using Core Java where the computer picks a secret number and guides the player to guess it correctly.

---

## 📌 Project Description

This project is a **Number Guessing Game** built as a Java console application. The program randomly generates a secret number between 1 and 100, and the user has to guess it. After every guess, the program tells the user whether their guess was too high, too low, or correct. The game tracks the number of attempts and congratulates the player when they guess right. The player can choose to play multiple rounds in a single session.

---

## ✨ Features

- ✅ **Random Number Generation** — A new secret number is generated for every round
- ✅ **Higher / Lower Hints** — Tells the player if their guess is too high or too low
- ✅ **Attempt Counter** — Tracks and displays how many attempts it took to win
- ✅ **Input Validation** — Rejects non-integer and out-of-range inputs with a prompt to retry
- ✅ **Play Again Option** — Lets the player start a new round without restarting the program

---

## 🛠️ Technologies Used

| Technology | Purpose |
|---|---|
| **Java (JDK 8+)** | Core programming language |
| **java.util.Random** | Generating the random secret number |
| **java.util.Scanner** | Reading user input from the console |
| **Static Methods** | Organising game logic into reusable blocks |

---

## 🧠 Concepts Used

### 1. Random Number Generation
`Random.nextInt()` is used to generate a secret number within a defined range (1–100) at the start of every new round.

### 2. Static Methods
Game logic is split into focused methods — `generateSecretNumber()`, `evaluateGuess()`, `displayFeedback()`, and `readValidGuess()` — keeping `main()` clean and easy to follow.

### 3. Switch Statement
The `displayFeedback()` method uses a `switch` statement to print the right message based on the result string: `"TOO_HIGH"`, `"TOO_LOW"`, or `"CORRECT"`.

### 4. Nested Loops
An outer `while` loop handles the play-again feature for multiple rounds, and an inner `while` loop keeps the current round going until the player guesses correctly.

### 5. Input Validation
`sc.hasNextInt()` checks that the input is a valid integer, and a range check ensures the guess falls between 1 and 100, with helpful re-prompts on bad input.

---

## ⚙️ How It Works

```
Program Starts
     │
     ▼
generateSecretNumber() → picks random number between 1 and 100
     │
     ▼
User enters a guess (validated: must be integer, 1–100)
     │
     ▼
evaluateGuess() compares guess to secret number
     │
     ├── TOO HIGH  → "Try a smaller number!" → user guesses again
     ├── TOO LOW   → "Try a larger number!"  → user guesses again
     └── CORRECT   → "Congratulations! Guessed in X attempt(s)!"
                          │
                          ▼
               "Play again?" → Yes: new round | No: exit
```

---

## ▶️ How to Run

### Prerequisites
- Java JDK 8 or above installed

Check your version:
```bash
java -version
```

### Steps

**Step 1 — Save the file:**
```
GuessTheNumber/
  └── GuessTheNumber.java
```

**Step 2 — Compile:**
```bash
javac GuessTheNumber.java
```

**Step 3 — Run:**
```bash
java GuessTheNumber
```

---

## 💻 Sample Output

```
==============================
  WELCOME TO GUESS THE NUMBER
==============================

I have picked a number between 1 and 100. Can you guess it?

Enter your guess (1 - 100): 50
>> Your guess is too HIGH. Try a smaller number!

Enter your guess (1 - 100): 25
>> Your guess is too LOW. Try a larger number!

Enter your guess (1 - 100): 37

*** Congratulations! You have guessed it right in 3 attempt(s)! ***

Would you like to play again? (yes/no): no

Thanks for playing! Have a good day.
```

---

## 📚 What I Learned

- Generating **random numbers** in Java using the `Random` class
- Using **nested loops** to manage game rounds and guess attempts
- Applying **switch statements** for clean condition-based output
- Writing **modular code** with focused static methods
- Handling **invalid user input** gracefully with `hasNextInt()`

---

## 🏢 About the Internship

**Internship:** CodSoft Java Programming Internship  
**Task Number:** Task 1 — Guess The Number  
**Language:** Java  

---

*Built with ❤️ using Core Java*
