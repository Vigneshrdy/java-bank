// Abstract base class
abstract class Account {
    String accNumber;
    String accHolder;
    double balance;

    Account(String accNumber, String accHolder, double balance) {
        this.accNumber = accNumber;
        this.accHolder = accHolder;
        this.balance = balance;
    }

    // Abstract method - each account defines its own interest
    abstract void calculateInterest();

    // Common method
    void deposit(double amount) {
        balance += amount;
        System.out.println(amount + " deposited. New Balance: " + balance);
    }

    void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(amount + " withdrawn. New Balance: " + balance);
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    void display() {
        System.out.println("Account Number: " + accNumber);
        System.out.println("Account Holder: " + accHolder);
        System.out.println("Balance: " + balance);
    }
}

// Current Account
class CurrentAccount extends Account {
    double overdraftLimit = 50000;

    CurrentAccount(String accNumber, String accHolder, double balance) {
        super(accNumber, accHolder, balance);
    }

    @Override
    void calculateInterest() {
        System.out.println("No interest for Current Account.");
    }

    @Override
    void withdraw(double amount) {
        if (balance + overdraftLimit >= amount) {
            balance -= amount;
            System.out.println(amount + " withdrawn using overdraft. Balance: " + balance);
        } else {
            System.out.println("Overdraft limit exceeded!");
        }
    }
}

// Savings Account
class SavingsAccount extends Account {
    double minBalance = 1000;
    double interestRate = 8.25;  // FD interest
    double dailyLimit = 50000;

    SavingsAccount(String accNumber, String accHolder, double balance) {
        super(accNumber, accHolder, balance);
    }

    @Override
    void calculateInterest() {
        if (balance >= 1000) {
            double interest = (balance * interestRate) / 100;
            System.out.println("Interest Earned: " + interest);
        } else {
            System.out.println("Balance below minimum. No interest.");
        }
    }

    @Override
    void withdraw(double amount) {
        if (amount > dailyLimit) {
            System.out.println("Withdrawal exceeds daily limit!");
        } else if (balance - amount < minBalance) {
            System.out.println("Cannot withdraw. Minimum balance of 1000 required.");
        } else {
            balance -= amount;
            System.out.println(amount + " withdrawn. Balance: " + balance);
        }
    }
}

// Main class
public class BankDemo {
    public static void main(String[] args) {
        Account c1 = new CurrentAccount("C101", "Reddy", 20000);
        Account s1 = new SavingsAccount("S101", "Vignesh", 30000);

        System.out.println("\n--- Current Account ---");
        c1.display();
        c1.deposit(5000);
        c1.withdraw(60000);
        c1.calculateInterest();

        System.out.println("\n--- Savings Account ---");
        s1.display();
        s1.deposit(7000);
        s1.withdraw(10000);
        s1.calculateInterest();
    }
}
