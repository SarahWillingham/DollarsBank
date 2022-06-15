/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.cognixia.jump.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import main.java.com.cognixia.jump.utility.ConnectionManager;



public class Account1 {

    Customer1 customer;
    int accountNum;
    double balance;
    String type;
    ArrayList<Double> recentTransactions = new ArrayList<Double>();
    PreparedStatement statement = null;
    Connection conn = ConnectionManager.getConnection();

    public Account1(Customer1 customer, String type) {
        this.customer = customer;
        this.type = type;
        this.balance = 0;
        //this.recentTransactions.add(balance);
    }
    
//    public String getAccount(String accountNum)

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    public Customer1 getCustomer() {
        return customer;
    }

    public void setCustomer(Customer1 customer) {
        this.customer = customer;
    }
    
    public ResultSet getBalance(int accountNum) throws SQLException {
        statement = conn.prepareStatement("Select balance from account where account_number = '" + accountNum + "';");
        ResultSet rs = statement.executeQuery();
//        while(rs.next()){
//            balance = rs.getDouble(balance);
//        }
        return rs;
    }

    public void updateBalance(double transfer) throws SQLException {
        String sqlStatement = "update account set balance = balance + " + transfer + ";";
        statement = conn.prepareStatement(sqlStatement);
        statement.execute();
        //this.balance = balance;
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
