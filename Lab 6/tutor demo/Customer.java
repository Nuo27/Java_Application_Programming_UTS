import java.util.*;
/**
 * A customer has a savings account and a loan account.
 *
 * You can deposit into and withdraw from the savings account,
 * and you can transfer money from the savings to the loan account.
 * You can also view the balance of all accounts.
 */
public class Customer {
    public static void main(String[] args) {
        new Customer().use();
    }
    private LinkedList<Account> accounts = new LinkedList<Account>();


    public Customer() {
        accounts.add(new Account("Savings"));
        accounts.add(new Account("Loan"));
    }

    private Account account(String type){
        for(Account account: accounts)
            if(account.hasType(type))
                return account;
            
        return null;
    }

    

    public void use() {
        char choice;
        while ((choice = readChoice()) != 'x') {
            switch (choice) {
            case 'd': deposit(); break;
            case 'w': withdraw(); break;
            case 't': transfer(); break;
            case 'v': show(); break;
            default: help(); break;
            }
        }
        System.out.println("Done");
    }

    private char readChoice() {
        System.out.print("Customer menu (d/w/t/s/x): ");
        return In.nextChar();
    }

    private void deposit() {
        Account account = account(readType());
        if (account != null)
            account.deposit(readAmount("deposit"));
        else
            System.out.println("No such account");
            

    }

    private void withdraw() {
        Account savingsAccount = account("Savings");

        double amount = readAmount("withdraw");
        if (savingsAccount.has(amount))
            savingsAccount.withdraw(amount);
        else
            System.out.println("Not enough money.");
    }

    private void transfer() {
        Account savingsAccount = account("Savings");
        double amount = readAmount("transfer");
        if (savingsAccount.has(amount))
            savingsAccount.transferTo(amount, account("Loan"));
        else
            System.out.println("Not enough money.");
    }

    private double readAmount(String action) {
        System.out.print("Amount to " + action + ": $");
        return In.nextDouble();
    }

    private String readType(){
        System.out.print("Account type: ");
        return In.nextLine();
    }

    private void show() {
         // View all accounts:
        //
        // for (Account account : accounts)
        //     System.out.println(account);
        //
        // View selected account:
        Account account = account(readType());
        System.out.println(account);
    }

    private void help() {
        System.out.println("Menu options");
        System.out.println("d = deposit");
        System.out.println("w = withdraw");
        System.out.println("t = transfer");
        System.out.println("s = show");
        System.out.println("x = exit");
    }
}
