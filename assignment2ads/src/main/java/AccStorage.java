import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;

public class AccStorage {
    LinkedList<BankAccount> accounts = new LinkedList<>();

    Stack<String> transactionHistory = new Stack<>();

    Queue<String> billQueue = new LinkedList<>();
    Queue<String> accRequest = new LinkedList<>();

    public void add_acc(String username, int acc_id, int balance){
        BankAccount new_acc = new BankAccount(username, acc_id, balance);
        accounts.add(new_acc);
    }

    public void display_acc(){
        for (BankAccount acc: accounts){
            System.out.println(acc.username + " - Balance: " + acc.balance);
        }
    }

    public void search_acc(String search){
        for (BankAccount acc : accounts) {
            if (search.equals(acc.username)) {
                System.out.println("Found: " + acc.username);
                System.out.println("Balance: " + acc.balance);
                return;
            }
        }
        System.out.println("Not found");
    }

    public void deposit(String username, int amount){
        for (BankAccount acc: accounts){
            if (acc.username.equals(username)) {
                acc.balance += amount;
                transactionHistory.push("Deposit " + amount + " to " + username);

                System.out.println("Deposit: " + amount);
                System.out.println(acc.username + "'s new balance: " + acc.balance);

                return;
            }
        }
    }

    public void withdraw(String username, int amount){
        for (BankAccount acc: accounts){

            if (acc.username.equals(username)) {
                if (amount > acc.balance){
                    System.out.println("Operation failed. " + acc.username + " has not enough money");
                    return;
                }
                acc.balance -= amount;
                transactionHistory.push("Withdraw " + amount + " to " + username);

                System.out.println("Withdraw: " + amount);
                System.out.println(acc.username + "'s new balance: " + acc.balance);
                return;
            }
        }
    }

    public void undolasttransaction(){
        if (!transactionHistory.isEmpty()) {
            String removed = transactionHistory.pop();
            System.out.println("Undo: " + removed + " removed.");
        }
        else {
            System.out.println("History is empty. Nothing to undo. ");
        }
    }

    public void displaylasttransaction(){
        if (!transactionHistory.isEmpty()){
            System.out.println("Last transaction: " + transactionHistory.peek());
        }
        else {
            System.out.println("No transaction yet. ");
        }
    }

    public void addbill(String billName){
        billQueue.add(billName);
        System.out.println("Added: " + billName);
    }

    public void processbill(){
        if (!billQueue.isEmpty()){
            String processed = billQueue.poll();
            System.out.println("Processing: " + processed);
        }
        else{
            System.out.println("No bills to process. ");
        }
    }

    public void displaybills(){
        System.out.println("Current bill queue: " + billQueue);
    }

    public void requestAccOpening(String name){
        accRequest.add(name);
        System.out.println("Request added for: " + name);
    }

    public void processAccountRequest(int newId, int initialBalance) {
        if (!accRequest.isEmpty()) {
            String name = accRequest.poll();

            add_acc(name, newId, initialBalance);

            System.out.println("Account opened for: " + name);
        } else {
            System.out.println("No pending requests.");
        }
    }

    public void displayAccRequests(){
        System.out.println("Pending account request: " + accRequest);
    }

    public void showPhysicalStorage() {
        BankAccount[] physicalAccounts = new BankAccount[3];

        physicalAccounts[0] = new BankAccount("Adilbek", 101, 500);
        physicalAccounts[1] = new BankAccount("Dimash", 102, 1500);
        physicalAccounts[2] = new BankAccount("Aldiyar", 103, 2500);

        System.out.println("--- Physical Array Storage (Fixed Size: 3) ---");

        for (int i = 0; i < physicalAccounts.length; i++) {
            System.out.println("Slot " + i + ": " + physicalAccounts[i].username +
                    " | Balance: " + physicalAccounts[i].balance);
        }
    }
}
