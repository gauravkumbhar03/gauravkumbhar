import java.util.Scanner;

public class Bank {
    static Scanner sc = new Scanner(System.in);
    private String name;
    final int banknumber;
    private long contact;
    private int initial_deposite = 100;
    private String password;
    private int balance;

    public Bank(String name, int banknumber, long contact, String password, int initial_deposite) {
        this.name = name;
        this.banknumber = banknumber;
        this.contact = contact;
        this.password = password;
        initial_deposite = 100;
        this.balance = initial_deposite;
    }

    public String getPassword() {
        return password;
    }

    public double getBanknumber() {
        return banknumber;
    }

    public int getBalance() {
        return balance;
    }

    public int getInitial_deposite() {
        return initial_deposite;
    }

    public long getContact() {
        return contact;
    }

    public String getName() {
        return name;
    }

    public void deposite() {
        System.out.println("Enter Amount");
        int am = sc.nextInt();
        if (am < 0) {
            System.out.println("Amount Cannot Be Negative");
        } else {
            balance += am;
        }
    }

    public void windraw() {
        System.out.println("Enter Amount To Windraw");
        int am = sc.nextInt();
        if (am > balance) {
            System.out.println("Insufficient Balance");
        } else {
            balance -= am;
        }
    }
    public void transfer(int am) {
            balance -= am;
    }
    public void receive(int am){
        balance+=am;
    }

    public void displayAcDetails() {
        System.out.println("Name           : " + getName());
        System.out.println("Ac Number      : " + getBanknumber());
        System.out.println("Contact Number : " + getContact());
        System.out.println("Balance        : " + getBalance());
    }



    @Override
    public String toString() {
        return "Name : " + name + " AC_No : " + banknumber + " Contact : " + contact + " Balance : " + balance;
    }
}
