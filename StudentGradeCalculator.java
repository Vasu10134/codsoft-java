import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        // Use try-with-resources to automatically close the scanner
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Welcome to the Student Grade Calculator!");

            // Step 1: Input number of subjects
            int numSubjects = getNumberOfSubjects(scanner);

            // Step 2: Input marks for each subject
            int[] marks = new int[numSubjects];
            int totalMarks = 0;

            for (int i = 0; i < numSubjects; i++) {
                marks[i] = getMarksForSubject(scanner, i);
                totalMarks += marks[i];
            }

            // Step 3: Calculate total marks and average percentage
            double averagePercentage = (double) totalMarks / numSubjects;

            // Step 4: Determine grade based on average percentage
            String grade = determineGrade(averagePercentage);

            // Step 5: Display results
            displayResults(totalMarks, averagePercentage, grade);
        }
    }

    private static int getNumberOfSubjects(Scanner scanner) {
        System.out.print("Enter the number of subjects: ");
        while (!scanner.hasNextInt()) {
            System.out.println("That's not a valid number. Please enter a positive integer.");
            scanner.next(); // Clear the invalid input
        }
        return scanner.nextInt();
    }

    private static int getMarksForSubject(Scanner scanner, int subjectIndex) {
        int marks;
        while (true) {
            System.out.print("Enter marks obtained in subject " + (subjectIndex + 1) + " (out of 100): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number between 0 and 100.");
                scanner.next(); // Clear the invalid input
            }
            marks = scanner.nextInt();

            // Validate marks are between 0 and 100
            if (marks < 0 || marks > 100) {
                System.out.println("Invalid marks! Please enter a value between 0 and 100.");
            } else {
                break; // Valid input, exit the loop
            }
        }
        return marks;
    }

    private static String determineGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return "A+";
        } else if (averagePercentage >= 80) {
            return "A";
        } else if (averagePercentage >= 70) {
            return "B";
        } else if (averagePercentage >= 60) {
            return "C";
        } else if (averagePercentage >= 50) {
            return "D";
        } else {
            return "F";
        }
    }

    private static void displayResults(int totalMarks, double averagePercentage, String grade) {
        System.out.println("\nResults:");
        System.out.println("Total Marks: " + totalMarks);
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade: " + grade);
    }
}
