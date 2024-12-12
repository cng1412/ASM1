import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentManagement manager = new StudentManagement();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            displayMenu();
            int choice = getValidChoice(scanner);

            switch (choice) {
                case 0:
                    System.out.println("Exiting... Goodbye!");
                    scanner.close();
                    return;
                case 1:
                    int id = getValidIntegerInput(scanner, "Enter Student ID: ");
                    String name = getValidStringInput(scanner, "Enter Student Name: ");
                    double marks = getValidDoubleInput(scanner, "Enter Student Marks: ");
                    manager.addStudent(id, name, marks);
                    break;
                case 2:
                    int deleteId = getValidIntegerInput(scanner, "Enter Student ID to delete: ");
                    manager.deleteStudent(deleteId);
                    break;
                case 3:
                    int editId = getValidIntegerInput(scanner, "Enter Student ID to edit: ");
                    String newName = getValidStringInput(scanner, "Enter new Student Name: ");
                    double newMarks = getValidDoubleInput(scanner, "Enter new Student Marks: ");
                    manager.editStudent(editId, newName, newMarks);
                    break;
                case 4:
                    int searchId = getValidIntegerInput(scanner, "Enter Student ID to search: ");
                    Student foundStudent = manager.findStudent(searchId);
                    if (foundStudent != null) {
                        System.out.println("Student found: " + foundStudent);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 5:
                    manager.bubbleSortStudentsByMarks();
                    System.out.println("Students sorted by marks (Bubble Sort).");
                    manager.displayStudents();
                    break;
                case 6:
                    manager.quickSortStudentsByMarks();
                    System.out.println("Students sorted by marks (Quick Sort).");
                    manager.displayStudents();
                    break;
                case 7:
                    manager.displayStudents();
                    break;
                case 8:
                    Student randomStudent = manager.getRandomStudent();
                    if (randomStudent != null) {
                        System.out.println("Random Student: " + randomStudent);
                    } else {
                        System.out.println("No students available.");
                    }
                    break;
                case 9:
                    int numStudents = getValidIntegerInput(scanner, "Enter the number of students to generate: ");
                    manager.generateRandomStudents(numStudents);
                    System.out.println(numStudents + " random students generated successfully.");
                    break;
                case 10:
                    manager.calculateSortingTime();
                    break;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("\n=== Student Management System ===");
        System.out.println("1. Add Student");
        System.out.println("2. Delete Student");
        System.out.println("3. Edit Student");
        System.out.println("4. Search Student");
        System.out.println("5. Sort Students (Bubble Sort)");
        System.out.println("6. Sort Students (Quick Sort)");
        System.out.println("7. Display Students");
        System.out.println("8. Random Student");
        System.out.println("9. Generate Random Students");
        System.out.println("10. Calculate Sorting Time");
        System.out.println("0. Exit");
    }

    private static int getValidChoice(Scanner scanner) {
        while (true) {
            System.out.print("Enter your choice: ");
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine();
                return choice;
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine();
            }
        }
    }

    private static int getValidIntegerInput(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextInt()) {
                int input = scanner.nextInt();
                scanner.nextLine();
                return input;
            } else {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine();
            }
        }
    }

    private static String getValidStringInput(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine();
            if (!input.isEmpty()) {
                return input;
            } else {
                System.out.println("Input cannot be empty. Please try again.");
            }
        }
    }

    private static double getValidDoubleInput(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (scanner.hasNextDouble()) {
                double input = scanner.nextDouble();
                scanner.nextLine();
                return input;
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine();
            }
        }
    }
}