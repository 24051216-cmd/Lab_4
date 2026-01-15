abstract class Student {
    protected int rollno;
    protected long regno;

    // Method to take input
    public void getinput(int rollno, long regno) {
        this.rollno = rollno;
        this.regno = regno;
    }

    // Abstract method
    abstract void course();
}
class Kiitian extends Student {

    @Override
    void course() {
        System.out.println("Course - B.Tech. (Computer Science & Engg)");
    }

    // Method to display details
    public void display() {
        System.out.println("Rollno - " + rollno);
        System.out.println("Registration no - " + regno);
        course();
    }
}
public class AbstractDemo {
    public static void main(String[] args) {

        Kiitian k = new Kiitian();
        k.getinput(2205180, 1234567890L);
        k.display();
    }
}
