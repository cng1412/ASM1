import java.util.Stack;

class StudentStack {
    private Stack<Student> students;

    public StudentStack() {
        students = new Stack<>();
    }

    public void push(Student student) {
        students.push(student);
    }

    public Student pop() {
        return students.isEmpty() ? null : students.pop();
    }

    public Stack<Student> getStudents() {
        return students;
    }
}




