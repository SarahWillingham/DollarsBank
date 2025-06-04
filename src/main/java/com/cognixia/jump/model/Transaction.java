package main.java.com.cognixia.jump.model;

public class Transaction {
    
    private int amount;
    private int accountNumber;

    public Transaction(int amount, int accountNumber) {
        this.amount = amount;
        this.accountNumber = accountNumber;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
    
    
    
}
