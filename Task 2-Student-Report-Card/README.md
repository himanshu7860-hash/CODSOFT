# 📋 Student Report Card — CodSoft Java Internship | Task 4

> A console-based Student Report Card generator built using Core Java that calculates total marks, average percentage, and assigns a grade with a remark.

---

## 📌 Project Description

This project is a **Student Marks & Grade Calculator** built as a Java console application. The user enters the number of subjects and the marks obtained in each subject. The program then calculates the total marks, average percentage, and automatically assigns a grade and a remark based on the student's performance. It can calculate report cards for multiple students in a single session.

The entire project is in a **single Java file** with clearly separated static methods for input, calculation, grading, and display.

---

## ✨ Features

- ✅ **Dynamic Subject Count** — Works for any number of subjects the user enters
- ✅ **Marks Validation** — Only accepts marks between 0 and 100
- ✅ **Total & Average Calculation** — Computes grand total and average percentage automatically
- ✅ **Grade Assignment** — Assigns grades from A+ to F based on average (7 grade levels)
- ✅ **Performance Remark** — Displays a motivational or advisory remark with each grade
- ✅ **Formatted Report Card** — Prints a clean, structured report with subject-wise breakdown
- ✅ **Multiple Students** — Asks if the user wants to calculate for another student after each report

---

## 🛠️ Technologies Used

| Technology | Purpose |
|---|---|
| **Java (JDK 8+)** | Core programming language |
| **Scanner (java.util)** | Reading user input from the console |
| **Arrays** | Storing marks for all subjects |
| **Static Methods** | Organising code into reusable blocks |

---

## 🧠 Concepts Used

### 1. Static Methods
The program is split into focused static methods — `readNumberOfSubjects()`, `gatherMarks()`, `grandTotal()`, `computeAverage()`, `assignGrade()`, `gradeRemark()`, and `displayReport()` — keeping `main()` short and clean.

### 2. Arrays
An integer array `int[] marks` stores the marks for all subjects dynamically based on how many subjects the user enters.

### 3. Loops
- A `for` loop collects marks for each subject one by one
- A `while` loop in the main method allows processing multiple students in the same session
- Inner `while` loops re-prompt the user on invalid input until a valid value is entered

### 4. Input Validation
All inputs use `sc.hasNextInt()` to check if the input is a valid integer before reading it, and value-range checks ensure marks stay between 0 and 100.

### 5. Grade Logic with If-Else Chain
The `assignGrade()` method uses a descending `if-else` chain to match the average percentage to a grade band (A+, A, B, C, D, E, F), and `gradeRemark()` returns a matching motivational message.

### 6. Formatted Output with printf
`System.out.printf()` is used to print aligned, formatted output in the report card for a clean and readable layout.

---

## ⚙️ How It Works

```
Program Starts
     │
     ▼
User enters number of subjects
     │
     ▼
User enters marks for each subject (validated: 0–100)
     │
     ▼
grandTotal()   → adds up all subject marks
computeAverage() → total ÷ number of subjects
     │
     ▼
assignGrade()  → matches average % to a grade
gradeRemark()  → picks a remark for that grade
     │
     ▼
displayReport() → prints formatted report card:
   • Subject-wise marks
   • Total marks
   • Average percentage
   • Grade & Remark
     │
     ▼
"Calculate for another student?" → Yes: repeat | No: exit
```

---

## ▶️ How to Run

### Prerequisites
- Java JDK 8 or above installed

Check your Java version:
```bash
java -version
```

### Steps

**Step 1 — Save the file:**
```
StudentReportCard/
  └── StudentReportCard.java
```

**Step 2 — Compile:**
```bash
javac StudentReportCard.java
```

**Step 3 — Run:**
```bash
java StudentReportCard
```

---

## 💻 Sample Output

```
======================================
    STUDENT MARKS & GRADE CALCULATOR
======================================

How many subjects do you have? 4

Enter marks for each subject (0 - 100):

  Subject 1 marks: 88
  Subject 2 marks: 76
  Subject 3 marks: 92
  Subject 4 marks: 65

----------------------------------------
         STUDENT REPORT CARD
----------------------------------------
 Subject-wise Marks:
   Subject 1   :  88 / 100
   Subject 2   :  76 / 100
   Subject 3   :  92 / 100
   Subject 4   :  65 / 100
----------------------------------------
 Total Marks    :  321 / 400
 Average %      :  80.25%
 Grade          :  A   (Excellent)
 Remark         :  Great effort, keep it up!
----------------------------------------

Calculate for another student? (yes/no): no

Thank you for using the Grade Calculator. Bye!
```

---

## 📚 What I Learned

- Structuring a Java program using **multiple static methods**
- Using **arrays** to handle dynamic, user-defined data
- Applying **input validation** with `hasNextInt()` and range checks
- Implementing **grade logic** using if-else chains
- Producing **formatted console output** using `printf()`

---

## 🏢 About the Internship

**Internship:** CodSoft Java Programming Internship  
**Task Number:** Task 4 — Student Report Card  
**Language:** Java  

---

*Built with ❤️ using Core Java*
