import java.util.Objects;
import java.util.Scanner;

class student {
    int roll;
    String name;

    student(int roll, String name) {
        this.roll = roll;
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (!(obj instanceof student))
            return false;

        student s = (student) obj;

        return roll == s.roll &&
                Objects.equals(name, s.name);
    }
}

public class EqualsDemo {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter details for Student 1:");
        System.out.print("Roll number: ");
        int roll1 = sc.nextInt();
        sc.nextLine();
        System.out.print("Name: ");
        String name1 = sc.nextLine();

        System.out.println("\nEnter details for Student 2:");
        System.out.print("Roll number: ");
        int roll2 = sc.nextInt();
        sc.nextLine();
        System.out.print("Name: ");
        String name2 = sc.nextLine();

        student s1 = new student(roll1, name1);
        student s2 = new student(roll2, name2);

        if (s1.equals(s2))
            System.out.println("\nBoth students are equal");
        else
            System.out.println("\nStudents are not equal");

        sc.close();
    }
}
