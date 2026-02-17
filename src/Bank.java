import java.util.*;

class Accounti {
    static int autoAccNo = 1000;

    int accNo;
    String name;
    String accType;
    double balance;
    int day, month, year;

    Accounti(String name, String accType, double balance,
            int day, int month, int year) {

        this.accNo = ++autoAccNo;
        this.name = name;
        this.accType = accType;
        this.balance = balance;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    void checkBalance() {
        System.out.println("Current Balance: Rs " + balance);
    }

    void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited Rs " + amount);
    }

    void withdraw(double amount) {
        System.out.println("Withdrawal method of Account class");
    }
}
class StandardAccount extends Accounti {

    StandardAccount(String name, double balance,
                    int d, int m, int y) {
        super(name, "Standard", balance, d, m, y);
    }

    @Override
    void withdraw(double amount) {

        if (amount > 500000) {
            System.out.println("Standard Account: Max limit Rs 5 lakh per day.");
            return;
        }

        if (amount <= 100000) {
            balance -= amount;
            System.out.println("Withdrawn Rs " + amount + " (No penalty)");
        }
        else {
            double penalty = amount * 0.0005;   // 0.05%
            balance -= (amount + penalty);
            System.out.println("Withdrawn Rs " + amount +
                    " with penalty Rs " + penalty);
        }
    }
}
class PremiumAccount extends Accounti {

    PremiumAccount(String name, double balance,
                   int d, int m, int y) {
        super(name, "Premium", balance, d, m, y);
    }

    @Override
    void withdraw(double amount) {

        if (amount > 1000000) {
            System.out.println("Premium Account: Max limit Rs 10 lakh per day.");
            return;
        }

        balance -= amount;
        System.out.println("Withdrawn Rs " + amount + " (Premium Account)");
    }
}
public class Bank {

    public static void main(String[] args) {

        Accounti a1 = new StandardAccount("Rahul", 800000, 12, 1, 2026);
        Accounti a2 = new PremiumAccount("Sneha", 1500000, 10, 1, 2026);

        System.out.println("\n--- Standard Account ---");
        a1.checkBalance();
        a1.withdraw(300000);
        a1.checkBalance();

        System.out.println("\n--- Premium Account ---");
        a2.checkBalance();
        a2.withdraw(900000);
        a2.checkBalance();
    }
}
