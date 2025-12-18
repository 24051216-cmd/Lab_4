import java.util.Scanner;

// 2D Sheet class (Parent)
class Plastic2D {
    double length;
    double width;
    final double COST_PER_SQFT = 40;

    public void input2D(Scanner sc) {
        System.out.print("Enter length: ");
        length = sc.nextDouble();

        System.out.print("Enter width: ");
        width = sc.nextDouble();
    }

    public double calculateCost() {
        double area = length * width;
        return area * COST_PER_SQFT;
    }
}

// 3D Box class (Child inherits from 2D)
class Plastic3D extends Plastic2D {
    double height;
    final double COST_PER_CUBICFT = 60;

    public void input3D(Scanner sc) {
        input2D(sc);   // reuse 2D input
        System.out.print("Enter height: ");
        height = sc.nextDouble();
    }

    @Override
    public double calculateCost() {
        double volume = length * width * height;
        return volume * COST_PER_CUBICFT;
    }
}

public class q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("1. Plastic Sheet (2D)");
        System.out.println("2. Plastic Box (3D)");
        System.out.print("Enter choice: ");
        int choice = sc.nextInt();

        if (choice == 1) {
            Plastic2D sheet = new Plastic2D();
            sheet.input2D(sc);
            System.out.println("Cost of plastic sheet = Rs " + sheet.calculateCost());
        }
        else if (choice == 2) {
            Plastic3D box = new Plastic3D();
            box.input3D(sc);
            System.out.println("Cost of plastic box = Rs " + box.calculateCost());
        }
        else {
            System.out.println("Invalid choice");
        }

        sc.close();
    }
}
