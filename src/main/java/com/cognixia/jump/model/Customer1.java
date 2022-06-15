package main.java.com.cognixia.jump.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import main.java.com.cognixia.jump.utility.ConnectionManager;

public class Customer1 {

    private String username;
    private String password;
    private String address;
    private String phone;
    private ArrayList<Account1> customerAccounts = new ArrayList<Account1>();
    Connection conn = ConnectionManager.getConnection();
    PreparedStatement statement = null;

    
    
    public Customer1(String username) {
        this.username = username;
    }


    public ResultSet getUsername() throws SQLException {
        statement = conn.prepareStatement("Select username from customer where customer_username = '" + username + "';");
        ResultSet rs = statement.executeQuery();
        return rs;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ResultSet getPassword() throws SQLException {
        statement = conn.prepareStatement("Select password from customer where customer_username = '" + username + "';");
        ResultSet rs = statement.executeQuery();
        return rs;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ResultSet getAddress() throws SQLException {
        statement = conn.prepareStatement("Select address from customer where customer_username = '" + username + "';");
        ResultSet rs = statement.executeQuery();
        return rs;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ResultSet getPhone() throws SQLException {
        statement = conn.prepareStatement("Select phone from account where customer_username = '" + username + "';");
        ResultSet rs = statement.executeQuery();
        return rs;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
//    public ArrayList<Account1> getCustomerAccounts() {
//        return customerAccounts;
//    }
    
    public ResultSet getCustomerAccounts() throws SQLException {
        statement = conn.prepareStatement("Select account_number, balance, type from account where customer_username = '" + username + "';");
        ResultSet rs = statement.executeQuery();
        return rs;
    }

    public void setCustomerAccounts(ArrayList<Account1> customerAccounts) {
        this.customerAccounts = customerAccounts;
    }

    @Override
    public String toString() {
        return "Customer{" + "username=" + username + ", password=" + password + ", customerAccounts=" + customerAccounts + '}';
    }

    

	
    
    
}
