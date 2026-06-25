import java.util.Scanner;
public class StudentReportCard {

    static final int MAX_MARKS = 100;

    // ---------- Input Handling 

    static int readNumberOfSubjects(Scanner sc) {
        int count = 0;
        while (count < 1) {
            System.out.print("How many subjects do you have? ");
            if (sc.hasNextInt()) {
                count = sc.nextInt();
                if (count < 1) {
                    System.out.println("!! Please enter at least 1 subject.");
                }
            } else {
                System.out.println("!! Invalid input. Enter a whole number.");
                sc.next();
            }
        }
        return count;
    }

    static int[] gatherMarks(Scanner sc, int subjectCount) {
        int[] marks = new int[subjectCount];
        System.out.println("\nEnter marks for each subject (0 - " + MAX_MARKS + "):\n");

        for (int i = 0; i < subjectCount; i++) {
            boolean valid = false;
            while (!valid) {
                System.out.print("  Subject " + (i + 1) + " marks: ");
                if (sc.hasNextInt()) {
                    int m = sc.nextInt();
                    if (m >= 0 && m <= MAX_MARKS) {
                        marks[i] = m;
                        valid = true;
                    } else {
                        System.out.println("  !! Marks must be between 0 and " + MAX_MARKS + ".");
                    }
                } else {
                    System.out.println("  !! Invalid input. Enter a number.");
                    sc.next();
                }
            }
        }
        return marks;
    }

    // ---------- Calculations

    static int grandTotal(int[] marks) {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return total;
    }

    static double computeAverage(int total, int subjectCount) {
        return (double) total / subjectCount;
    }

    // ---------- Grade Logic ----------

    static String assignGrade(double average) {
        if (average >= 90) return "A+  (Outstanding)";
        if (average >= 80) return "A   (Excellent)";
        if (average >= 70) return "B   (Very Good)";
        if (average >= 60) return "C   (Good)";
        if (average >= 50) return "D   (Average)";
        if (average >= 40) return "E   (Pass)";
        return                     "F   (Fail)";
    }

    static String gradeRemark(double average) {
        if (average >= 90) return "Truly exceptional performance!";
        if (average >= 80) return "Great effort, keep it up!";
        if (average >= 70) return "Good work, push for excellence!";
        if (average >= 60) return "Decent result, room to improve.";
        if (average >= 50) return "Average performance, study harder.";
        if (average >= 40) return "Barely passing, needs improvement.";
        return                     "Unfortunately failed. Don't give up!";
    }

    // ---------- Display

    static void printDivider(int length) {
        for (int i = 0; i < length; i++) System.out.print("-");
        System.out.println();
    }

    static void displayReport(int[] marks, int total, double average, String grade, String remark) {
        System.out.println("\n");
        printDivider(40);
        System.out.println("         STUDENT REPORT CARD");
        printDivider(40);

        System.out.println(" Subject-wise Marks:");
        for (int i = 0; i < marks.length; i++) {
            System.out.printf("   Subject %-2d  :  %d / %d%n", (i + 1), marks[i], MAX_MARKS);
        }

        printDivider(40);
        System.out.printf(" Total Marks    :  %d / %d%n", total, marks.length * MAX_MARKS);
        System.out.printf(" Average %%      :  %.2f%%%n", average);
        System.out.println(" Grade          :  " + grade);
        System.out.println(" Remark         :  " + remark);
        printDivider(40);
    }

    // ---------- Main 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("======================================");
        System.out.println("    STUDENT MARKS & GRADE CALCULATOR ");
        System.out.println("======================================\n");

        boolean continueProgram = true;

        while (continueProgram) {
            int subjectCount = readNumberOfSubjects(sc);
            int[] marks      = gatherMarks(sc, subjectCount);
            int total        = grandTotal(marks);
            double average   = computeAverage(total, subjectCount);
            String grade     = assignGrade(average);
            String remark    = gradeRemark(average);

            displayReport(marks, total, average, grade, remark);

            System.out.print("\nCalculate for another student? (yes/no): ");
            String ans = sc.next().trim().toLowerCase();
            continueProgram = ans.equals("yes") || ans.equals("y");
            System.out.println();
        }

        System.out.println("Thank you for using the Grade Calculator. Bye!");
        sc.close();
    }
}

