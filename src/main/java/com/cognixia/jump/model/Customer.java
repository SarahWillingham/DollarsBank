package main.java.com.cognixia.jump.model;

import java.util.ArrayList;

public class Customer {

    private String username;
    private String password;
    private String address;
    private String phone;
    private ArrayList<Account> customerAccounts = new ArrayList<Account>();

    public Customer(String username, String password, String address, String phone) {
        this.username = username;
        this.password = password;
        this.address = address;
        this.phone = phone;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
