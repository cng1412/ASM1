class Student {
    private int id;
    private String name;
    private double marks;

    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }

    public static Student generateRandomStudent(int id) {
        String randomName = "Student" + id;
        double randomMarks = Math.random() * 100;
        return new Student(id, randomName, randomMarks);
    }

    @Override
    public String toString() {
        return "Student [ID=" + id + ", Name=" + name + ", Marks=" + marks + "]";
    }
}