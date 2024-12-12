import java.util.Stack;
import java.util.Collections;
import java.util.Random;

class StudentManagement {
    private Stack<Student> students;

    public StudentManagement() {
        students = new Stack<>();
    }

    public void addStudent(int id, String name, double marks) {
        students.push(new Student(id, name, marks));
    }

    public void deleteStudent(int id) {
        students.removeIf(student -> student.getId() == id);
    }

    public void editStudent(int id, String newName, double newMarks) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                students.set(i, new Student(id, newName, newMarks));
            }
        }
    }

    public Student findStudent(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    public void bubbleSortStudentsByMarks() {
        int n = students.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (students.get(j).getMarks() > students.get(j + 1).getMarks()) {
                    Collections.swap(students, j, j + 1);
                }
            }
        }
    }

    public void quickSortStudentsByMarks() {
        quickSort(0, students.size() - 1);
    }

    private void quickSort(int low, int high) {
        if (low < high) {
            int pi = partition(low, high);
            quickSort(low, pi - 1);
            quickSort(pi + 1, high);
        }
    }

    private int partition(int low, int high) {
        double pivot = students.get(high).getMarks();
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (students.get(j).getMarks() < pivot) {
                i++;
                Collections.swap(students, i, j);
            }
        }
        Collections.swap(students, i + 1, high);
        return i + 1;
    }

    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    public Student getRandomStudent() {
        if (students.isEmpty()) {
            return null;
        }
        Random random = new Random();
        int index = random.nextInt(students.size());
        return students.get(index);
    }

    public void generateRandomStudents(int number) {
        for (int i = 1; i <= number; i++) {
            students.push(Student.generateRandomStudent(i));
        }
    }

    public void calculateSortingTime() {
        long startTime = System.nanoTime();
        bubbleSortStudentsByMarks();
        long endTime = System.nanoTime();
        System.out.println("Bubble Sort time: " + (endTime - startTime) + " nanoseconds");

        startTime = System.nanoTime();
        quickSortStudentsByMarks();
        endTime = System.nanoTime();
        System.out.println("Quick Sort time: " + (endTime - startTime) + " nanoseconds");
    }
}