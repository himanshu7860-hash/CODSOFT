# 📊 Student Marks & Grade Calculator — Task 2

![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Internship](https://img.shields.io/badge/Internship-CodSoft-blue?style=for-the-badge)
![Task](https://img.shields.io/badge/Task-2%20of%205-green?style=for-the-badge)
![Status](https://img.shields.io/badge/Status-Completed-brightgreen?style=for-the-badge)

---

## 🏢 About the Internship

This project is **Task 2** of my **Java Programming Internship at CodSoft**.  
The goal of this task was to build a console-based application in Java that accepts student marks, calculates totals and averages, assigns grades, and displays a formatted report card.

---

## 📌 About This Program

The **Student Marks & Grade Calculator** is a console-based Java application that:

- Takes the number of subjects as input from the user
- Accepts marks (out of 100) for each subject individually
- Calculates the **total marks** obtained across all subjects
- Computes the **average percentage**
- Assigns a **letter grade** with remarks based on the average
- Displays a clean, formatted **Report Card** with all results
- Supports **multiple student calculations** in a single run without restarting

### 🎯 Grade Scale Used

| Average %       | Grade | Description  |
|-----------------|-------|--------------|
| 90% and above   | A+    | Outstanding  |
| 80% – 89%       | A     | Excellent    |
| 70% – 79%       | B     | Very Good    |
| 60% – 69%       | C     | Good         |
| 50% – 59%       | D     | Average      |
| 40% – 49%       | E     | Pass         |
| Below 40%       | F     | Fail         |

---

## 🛠️ Technologies & Tools Used

| Technology | Purpose |
|------------|---------|
| **Java (JDK 8+)** | Core programming language |
| **Scanner Class** | Reading user input from the console |
| **Arrays** | Storing subject-wise marks |
| **Control Flow** | `if-else`, `for`, `while` loops for logic |
| **String Formatting** | `printf` and `format` for clean output |
| **Git & GitHub** | Version control and project hosting |

---

## 💡 Concepts & Skills Learned

Through building this project, I strengthened my understanding of:

- ✅ **Modular Programming** — Breaking code into separate methods for input, calculation, grading, and display instead of writing everything in `main()`
- ✅ **Input Validation** — Handling invalid inputs like characters, negative marks, or marks above 100 using `hasNextInt()` and range checks
- ✅ **Array Handling** — Dynamically collecting and iterating over marks using `int[]` arrays
- ✅ **Type Casting** — Using `(double)` casting for precise average percentage calculation
- ✅ **`printf` Formatting** — Formatting decimal values with `%.2f` for clean percentage display
- ✅ **Conditional Logic** — Implementing multi-level `if-else` chains for grade assignment
- ✅ **Loops** — Using nested `while` loops for multi-student support and input retry on invalid entries
- ✅ **Clean Code Practices** — Using constants (`MAX_MARKS`), descriptive method names, and utility methods like `printDivider()`
- ✅ **User Experience** — Designing readable console output with dividers, spacing, and motivational remarks

---
---

## ▶️ How to Run

### Prerequisites
- Java JDK 8 or above installed
- Any terminal / command prompt

### Steps

```bash
# Step 1: Clone the repository
git clone https://github.com/your-username/your-repo-name.git

# Step 2: Navigate to the project folder
cd himanshu7860-hash/CODSOFT

# Step 3: Compile the Java file
javac StudentReportCard.java

# Step 4: Run the program
java StudentReportCard
```

---

## 👨‍💻 Author

**Your Name**  
Java Programming Intern @ CodSoft  
📧 hmsharma7860@gmail.com
🔗 [LinkedIn](www.linkedin.com/in/himanshu-5221b8419) | [GitHub](https://github.com/himanshu7860-hash)

---

## 📃 License

This project is intended for educational purposes as part of the CodSoft Internship Program.

---

> ⭐ If you found this helpful, consider giving this repo a star!
