/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.cognixia.jump.model;

import java.util.ArrayList;



public class Account {

    double balance;
    ArrayList<Double> recentTransactions = new ArrayList<Double>();

    public Account(double balance) {
        this.balance = balance;
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
        return "Account{" + "balance=" + balance + ", recentTransactions=" + recentTransactions + '}';
    }
    

    


    
}
