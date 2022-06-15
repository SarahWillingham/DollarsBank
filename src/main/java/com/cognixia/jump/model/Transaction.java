/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.cognixia.jump.model;

/**
 *
 * @author sarah
 */
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
