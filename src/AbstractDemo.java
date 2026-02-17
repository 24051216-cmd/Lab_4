import java.util.Scanner;

abstract class Studenti {
    int rollNo;
    long regNo;

    void getInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Rollno - ");
        rollNo = sc.nextInt();
        System.out.print("Registration no - ");
        regNo = sc.nextLong();
    }

    abstract void course();
}
class Kiitian extends Studenti {

    @Override
    void course() {
        System.out.println("Course - B.Tech. (Computer Science & Engg)");
    }

    void display() {
        System.out.println("Rollno - " + rollNo);
        System.out.println("Registration no - " + regNo);
        course();
    }
}
public class AbstractDemo {
    public static void main(String[] args) {

        Kiitian obj = new Kiitian();
        obj.getInput();
        obj.display();
    }
}
