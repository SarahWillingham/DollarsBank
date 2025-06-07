package main.java.com.cognixia.jump.model;
import java.util.ArrayList;

public class Account {

    Customer customer;
    double balance;
    String type;
    ArrayList<Double> recentTransactions = new ArrayList<Double>();

    public Account(Customer customer, Double balance, String type) {
        this.customer = customer;
        this.type = type;
        this.balance = balance;
        this.recentTransactions.add(balance);   // first transaction
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public ArrayList<Double> getRecentTransactions() {
        return recentTransactions;
    }

    public void setRecentTransactions(ArrayList<Double> recentTransactions) {
        this.recentTransactions = recentTransactions;
    }

    @Override
    public String toString() {
        return "Account{" + "type=" + type + ", balance=" + balance + '}';
    }

}
