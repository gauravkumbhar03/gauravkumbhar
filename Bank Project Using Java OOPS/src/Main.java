
import java.util.*;

public class Main {
    static ArrayList<Bank> newUser = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    static void createAc() {
        System.out.println("Enter Your Name : ");
        String name = sc.nextLine();
        Random r = new Random();
        int minRange = 1000;
        int maxRange = 2000;
        int banknumber = r.nextInt(maxRange - minRange + 1) + minRange;
        System.out.println("Enter Your Contact : ");
        long contact = sc.nextLong();
        sc.nextLine();
        System.out.println("Enter Your Password : ");
        String password = sc.nextLine();
        int initial_deposite = 100;
        Bank newUsers = new Bank(name, banknumber, contact, password, initial_deposite);
        newUser.add(newUsers);
        System.out.println("Your Bank Number  :" + banknumber);
    }

    static void updateAc() {
        System.out.println("Enter Ac Number");
        int banknumber = sc.nextInt();
        sc.nextLine();
        Bank u;
        for (Bank a : newUser) {
            if (a.getBanknumber() == banknumber) {
                u = a;
                System.out.println("Enter Password ");
                String pass = sc.nextLine();
                if (u.getPassword().equals(pass)) {
                    System.out.println("Welcome Sir Now You Can Update Your AC");
                    System.out.println(" ");
                    System.out.println("Enter Your New Name : ");
                    String name = sc.nextLine();
                    System.out.println("Enter Your New Contact : ");
                    long contact = sc.nextLong();
                    sc.nextLine();
                    System.out.println("Enter Your New Password : ");
                    String password = sc.nextLine();
                    int initial_deposite = 100;
                    Bank newUsers = new Bank(name, banknumber, contact, password, initial_deposite);
                    newUser.remove(u);
                    newUser.add(newUsers);
                }
            }
        }
    }

    static void deleteAc() {
        System.out.println("Enter Ac Number");
        int banknumber = sc.nextInt();
        sc.nextLine();
        Bank u;
        for (Bank a : newUser) {
            if (a.getBanknumber() == banknumber) {
                u = a;
                System.out.println("Enter Password ");
                String pass = sc.nextLine();
                if (u.getPassword().equals(pass)) {
                    System.out.println("Do You Really Want To delete your account(Y/N)");
                    char ans = sc.next().charAt(0);
                    if (ans == 'y') {
                        newUser.remove(u);
                    } else if (ans == 'n') {
                        System.out.println("thank You Sir");
                    } else {
                        System.out.println("Thank You Sir");
                    }
                }
            }
        }
    }

    public static void transeferMoney() {
        System.out.println("Enter Your Account Number Again:");
        int banknumber = sc.nextInt();
        sc.nextLine();
        Bank u = null;
        for (Bank a : newUser) {
            if (a.getBanknumber() == banknumber) {
                u = a;
                break;
            }
        }
        if (u == null) {
            System.out.println("Account Not Found");
            return;
        }
        System.out.println("Enter Your Password Again:");
        String pass = sc.nextLine();
        if (!u.getPassword().equals(pass)) {
            System.out.println("Incorrect Password");
            return;
        }
        System.out.println("Enter Receiver's Account Number:");
        int num = sc.nextInt();
        sc.nextLine();

        Bank receiver = null;
        for (Bank b : newUser) {
            if (b.getBanknumber() == num) {
                receiver = b;
                break;
            }
        }
        if (receiver == null) {
            System.out.println("Receiver's Account Not Found");
            return;
        }
        System.out.println("Enter Amount To Transfer:");
        int am = sc.nextInt();
        sc.nextLine();
        if (am > u.getBalance()) {
            System.out.println("Insufficient Balance");
        } else {
            u.transfer(am);
            receiver.receive(am);
            System.out.println(am + " Rs has been transferred to account number " + num);
        }
    }

    static void logIn() {
        System.out.println("Enter Ac Number");
        double banknumber = sc.nextDouble();
        sc.nextLine();
        Bank u;
        for (Bank a : newUser) {
            if (a.getBanknumber() == banknumber) {
                u = a;
                System.out.println("Enter Password ");
                String pass = sc.nextLine();
                if (u.getPassword().equals(pass)) {
                    System.out.println("Welcome Sir, You Have SuccessFullyLogin");
                    boolean ab = true;
                    while (ab) {
                        System.out.println();
                        System.out.println("Please Select Following Option");
                        System.out.println();
                        System.out.println("1 : Deposit");
                        System.out.println("2 : Windrow");
                        System.out.println("3 : Transfer Money");
                        System.out.println("4 : View Your Balance");
                        System.out.println("5 : View  Details");
                        System.out.println("6 : Exit");
                        int c = sc.nextInt();
                        sc.nextLine();
                        switch (c) {
                            case 1: {
                                u.deposite();
                            }
                            break;
                            case 2: {
                                u.windraw();
                            }
                            break;
                            case 3: {
                                transeferMoney();
                            }
                            break;
                            case 4: {
                                System.out.println(u.getBalance());
                            }
                            break;
                            case 5: {
                                u.displayAcDetails();
                            }
                            break;
                            case 6: {
                                ab = false;
                                System.out.println("Returning Back To main Window");
                            }
                        }
                    }
                }
            } else {
                System.out.println("This Account does Not Exist");
            }
        }
    }

    public static void main(String[] args) {
        boolean on = true;
        while (on) {
            System.out.println();
            System.out.println("1 : Create Ac");
            System.out.println("2 : Update Ac");
            System.out.println("3 : Delete Ac");
            System.out.println("4 : LogInn");
            System.out.println("5 : Exit");
            System.out.println(" ");
            System.out.println("Enter Your Choice");
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1: {
                    createAc();
                }
                break;
                case 2: {
                    updateAc();
                }
                break;
                case 3: {
                    deleteAc();
                }
                break;
                case 4: {
                    logIn();
                }
                break;
                case 5: {
                    on = false;
                    System.out.println("Exiting");
                }
            }
        }
    }
}
