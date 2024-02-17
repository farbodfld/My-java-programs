import java.util.Scanner;

public class InsufficientFundsException extends Exception {
    private double amount;

    public InsufficientFundsException(double a) {
        this.amount = a;
    }

    public double getAmount() {
        return amount;
    }
}

class Account {
    private double balance;
    private int number;

    public Account(int number) {
        this.number = number;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount <= balance) {
            balance -= amount;
        } else {
            double needs = amount - balance;
            throw new InsufficientFundsException(needs);
        }
    }

    public double getBalance() {
        return balance;
    }

    public int getNumber() {
        return number;
    }
}

class test3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Account a = new Account(20);
        System.out.println("deposit 100$");
        a.deposit(100);
        try {
            System.out.println("withdraw 20 $");
            a.withdraw(20);
            System.out.println("withdraw 200$");
            a.withdraw(200);
        } catch (InsufficientFundsException e) {
            System.out.println("sorry you are short: " + e.getAmount());
            e.printStackTrace();
        }
        System.out.println("rest of code...");
    }
}