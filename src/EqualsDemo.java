class Student {
    int rollNo;
    String name;

    // Constructor
    Student(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }

    // Overriding equals() method
    @Override
    public boolean equals(Object obj) {

        // Check if both references point to same object
        if (this == obj)
            return true;

        // Check if obj is instance of Student
        if (!(obj instanceof Student))
            return false;

        Student s = (Student) obj;

        // Compare data members
        return this.rollNo == s.rollNo &&
                this.name.equals(s.name);
    }
}
public class EqualsDemo {
    public static void main(String[] args) {

        Student s1 = new Student(101, "Rahul");
        Student s2 = new Student(101, "Rahul");
        Student s3 = new Student(102, "Anita");

        System.out.println("s1 equals s2: " + s1.equals(s2));
        System.out.println("s1 equals s3: " + s1.equals(s3));
    }
}
