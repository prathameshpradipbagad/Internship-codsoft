package stringmethods;
import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: Number of subjects
        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();

        // Input: Array to store marks obtained in each subject
        double[] marksArray = new double[numSubjects];

        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter marks obtained in subject " + (i + 1) + " (out of 100): ");
            marksArray[i] = scanner.nextDouble();
        }

        // Calculate total marks
        double totalMarks = 0;
        for (double marks : marksArray) {
            totalMarks += marks;
        }

        // Calculate average percentage
        double averagePercentage = (totalMarks / (numSubjects * 100)) * 100;

        // Assign grade
        String grade = assignGrade(averagePercentage);

        // Display results
        System.out.println("Total Marks: " + totalMarks);
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade: " + grade);

        scanner.close();
    }

    // Function to assign grades based on the average percentage
    private static String assignGrade(double averagePercentage) {
        if (averagePercentage >= 90 && averagePercentage <= 100) {
            return "A+";
        } else if (averagePercentage >= 80 && averagePercentage < 90) {
            return "A";
        } else if (averagePercentage >= 70 && averagePercentage < 80) {
            return "B";
        } else if (averagePercentage >= 60 && averagePercentage < 70) {
            return "C";
        } else if (averagePercentage >= 50 && averagePercentage < 60) {
            return "D";
        } else {
            return "F";
        }
    }
}


