package main.java.com.cognixia.jump.model;

import java.util.ArrayList;

public class Customer {

    private String username;
    private String password;
    private ArrayList<Account> customerAccounts = new ArrayList<Account>();

    public Customer(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Account> getCustomerAccounts() {
        return customerAccounts;
    }

    public void setCustomerAccounts(ArrayList<Account> customerAccounts) {
        this.customerAccounts = customerAccounts;
    }

    @Override
    public String toString() {
        return "Customer{" + "username=" + username + ", password=" + password + ", customerAccounts=" + customerAccounts + '}';
    }

    

	
    
    
}
