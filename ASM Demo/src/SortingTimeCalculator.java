import java.util.Random;
import java.util.Scanner;

public class SortingTimeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int size = scanner.nextInt(); // Nhập số lượng sinh viên
        StudentStack studentStack = new StudentStack();
        generateRandomStudents(studentStack, size);

        // Tính thời gian cho Bubble Sort
        Student[] quickArray = studentStack.getStudents().toArray(new Student[0]);
        Student[] bubbleArray = studentStack.getStudents().toArray(new Student[0]);
        long bubbleStartTime = System.nanoTime();
        bubbleSort(bubbleArray);
        long bubbleEndTime = System.nanoTime();
        System.out.println("Bubble Sort Time: " + (bubbleEndTime - bubbleStartTime) + " ns");

        // Tính thời gian cho Quick Sort
        long quickStartTime = System.nanoTime();
        quickSort(quickArray, 0, quickArray.length - 1);
        long quickEndTime = System.nanoTime();
        System.out.println("Quick Sort Time: " + (quickEndTime - quickStartTime) + " ns");

        // Đóng Scanner
        scanner.close();
    }

    // Tạo ngẫu nhiên sinh viên và thêm vào StudentStack
    private static void generateRandomStudents(StudentStack stack, int size) {
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            int id = i + 1; // ID sinh viên
            String name = "Student" + id; // Tên sinh viên
            double marks = random.nextDouble() * 10; // Điểm từ 0 đến 10
            stack.push(new Student(id, name, marks));
        }
    }

    // Phương thức sắp xếp bằng Bubble Sort
    private static void bubbleSort(Student[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].getMarks() > arr[j + 1].getMarks()) {
                    // Hoán đổi arr[j] và arr[j + 1]
                    Student temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Phương thức sắp xếp bằng Quick Sort
    private static void quickSort(Student[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(Student[] arr, int low, int high) {
        double pivot = arr[high].getMarks();
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j].getMarks() < pivot) {
                i++;
                // Hoán đổi arr[i] và arr[j]
                Student temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // Hoán đổi arr[i + 1] và arr[high]
        Student temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}
