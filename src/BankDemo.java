// Super class
class Account {
    protected static int accCounter = 1000;
    protected int accountNumber;
    protected String name;
    protected String accountType;
    protected double balance;
    protected int day, month, year;

    // Constructor
    public Account(String name, String accountType, double balance, int day, int month, int year) {
        this.accountNumber = ++accCounter;
        this.name = name;
        this.accountType = accountType;
        this.balance = balance;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public void checkBalance() {
        System.out.println("Account No: " + accountNumber);
        System.out.println("Current Balance: Rs " + balance);
    }

    public void deposit(double amount, int day, int month, int year) {
        balance += amount;
        this.day = day;
        this.month = month;
        this.year = year;
        System.out.println("Rs " + amount + " deposited successfully.");
    }

    // To be overridden
    public void withdraw(double amount) {
        System.out.println("Withdrawal method of Account class");
    }
}

// Standard Account
class StandardAccount extends Account {

    public StandardAccount(String name, double balance, int day, int month, int year) {
        super(name, "Standard", balance, day, month, year);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 100000) {
            if (balance >= amount) {
                balance -= amount;
                System.out.println("Rs " + amount + " withdrawn (No charges).");
            } else {
                System.out.println("Insufficient balance.");
            }
        } else if (amount <= 500000) {
            double penalty = amount * 0.0005;
            double total = amount + penalty;
            if (balance >= total) {
                balance -= total;
                System.out.println("Rs " + amount + " withdrawn with penalty Rs " + penalty);
            } else {
                System.out.println("Insufficient balance.");
            }
        } else {
            System.out.println("Withdrawal limit exceeded for Standard Account.");
        }
    }
}

// Premium Account
class PremiumAccount extends Account {

    public PremiumAccount(String name, double balance, int day, int month, int year) {
        super(name, "Premium", balance, day, month, year);
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 1000000) {
            if (balance >= amount) {
                balance -= amount;
                System.out.println("Rs " + amount + " withdrawn successfully (Premium Account).");
            } else {
                System.out.println("Insufficient balance.");
            }
        } else {
            System.out.println("Daily withdrawal limit exceeded for Premium Account.");
        }
    }
}

// Main class
public class BankDemo {
    public static void main(String[] args) {

        // Dynamic Method Dispatch
        Account a1 = new StandardAccount("Rahul", 600000, 1, 1, 2025);
        Account a2 = new PremiumAccount("Anita", 1500000, 2, 1, 2025);

        System.out.println("\n--- Standard Account Transactions ---");
        a1.checkBalance();
        a1.withdraw(200000);
        a1.checkBalance();

        System.out.println("\n--- Premium Account Transactions ---");
        a2.checkBalance();
        a2.withdraw(800000);
        a2.checkBalance();
    }
}
