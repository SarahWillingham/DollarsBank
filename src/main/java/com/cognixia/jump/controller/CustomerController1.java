package main.java.com.cognixia.jump.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import main.java.com.cognixia.jump.model.Account;
import main.java.com.cognixia.jump.utility.ConnectionManager;

import main.java.com.cognixia.jump.model.Customer;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Scanner;
import main.java.com.cognixia.jump.model.Account1;
import main.java.com.cognixia.jump.model.Customer1;


public class CustomerController1 {

    final static String ANSI_RESET = "\u001B[0m";

    // Declaring the color
    // Custom declaration
    final String ANSI_RED = "\u001B[31m";
    final String ANSI_BLACK = "\u001B[30m";
    final String ANSI_GREEN = "\u001B[32m";
    final String ANSI_YELLOW = "\u001B[33m";
    final String ANSI_BLUE = "\u001B[34m";
    final String ANSI_PURPLE = "\u001B[35m";
    final String ANSI_CYAN = "\u001B[36m";
    final String ANSI_WHITE = "\u001B[37m";
    
    Connection conn = ConnectionManager.getConnection();
    Customer1 current = null;
    Scanner sc = new Scanner(System.in);
    PreparedStatement statement = null;
    
    
    
    public void start() throws SQLException {
        System.out.println("Enter 'L' to login or 'R' to register a new user account.");
        String choice = sc.next();
        if(choice.equals("L") || choice.equals("l"))
            login();
        if(choice.equals("R") || choice.equals("r"))
            register();
        else{
            System.out.println("Invalid input, try again.");
            start();
        }
    }
    
    public void register() throws SQLException {
        
        System.out.println("Enter new username:");
        String username = sc.next();
        System.out.println("Enter new password:");
        String password = sc.next();
        System.out.println("Address:");
        String address = sc.next();
        System.out.println("Phone number:");
        String phone = sc.next();
        
        current = new Customer1(username);
        statement = conn.prepareStatement("insert into customer values('" + username + "', '" + password + "', '" + address + "', '" + phone + "');");
        statement.execute();

        if(current != null)
            System.out.println(ANSI_GREEN + "User successfully registered!" + ANSI_RESET);
        menu();
    }
    
    public void login() throws SQLException {
                
        //boolean loginSuccess = false;
        
        String usernameInput = null;
	String passwordInput = null;
        
        System.out.println(ANSI_PURPLE + "Please enter USERNAME." + ANSI_RESET);
        usernameInput = sc.next();

        System.out.println(ANSI_PURPLE + "Please enter password" + ANSI_RESET);
        passwordInput = sc.next();
            
        statement = conn.prepareStatement("Select * from customer where username = '" + usernameInput + "'and password = '" + passwordInput + "';");
        ResultSet rs = statement.executeQuery();

        if(rs.next()) {
            System.out.println(ANSI_GREEN + "Login successful!\n" + ANSI_RESET);
            rs = statement.executeQuery();
            current = new Customer1(usernameInput);
            summary();
        }else{
            System.out.println(ANSI_RED  + "Login failed!  Please try again" + ANSI_RESET);
            login();
        }
    }
    
    
    
    public void summary() throws SQLException{
        statement = conn.prepareStatement("Select account_number, balance, type from account where customer_username = '" + current.getUsername() + "';");
        ResultSet rs = current.getCustomerAccounts();
        ResultSetMetaData rsmd = rs.getMetaData();
        int columnsNumber = rsmd.getColumnCount();
        while (rs.next()) {
            for (int i = 1; i <= columnsNumber; i++) {
                if (i > 1) System.out.print(",  ");
                String columnValue = rs.getString(i);
                System.out.print(columnValue + " " + rsmd.getColumnName(i));
            }
            System.out.println("");
        }
        menu();
    }
    
    
    public void menu() throws SQLException{
        System.out.println("\n" + ANSI_PURPLE + "Select an option");
        System.out.println(ANSI_PURPLE + "1. Create new account");
        System.out.println(ANSI_PURPLE + "2. Recent account activity");
        System.out.println(ANSI_PURPLE + "3. Deposit or withdrawal");
        System.out.println(ANSI_PURPLE + "4. Transfer funds");
        System.out.println(ANSI_PURPLE + "5. View customer information");
        System.out.println(ANSI_PURPLE + "6. Logout" + ANSI_RESET);

        //Scanner sc = new Scanner(System.in);
        int choice = Integer.parseInt(sc.next());
        if(choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5 && choice != 6){
            System.out.println(ANSI_RED  + "Invalid choice, try again." + ANSI_RESET);
            menu();
        }
        
        if(choice == 1){
            addNewAccount(current);
        }else if(choice == 2){
            checkAccounts(current);
        }else if(choice == 3){
            makeTransaction(current);
        }else if(choice == 4){
            transfer();
        }else if(choice == 5){
            customerInfo(current);
        }else if(choice == 6){
            current = null;
            System.out.println(ANSI_GREEN + "You are now logged out" + ANSI_RESET);
            login();
        }else{
            System.out.println(ANSI_RED  + "Invalid choice" + ANSI_RESET);
        }
    }
    

    public void transfer() throws SQLException{
        double transAccBal;
        double depAccBal;
        double transAmount;
        
//fix this so account balances are not null
        summary();
        System.out.println(ANSI_PURPLE + "Select transfer account number:" + ANSI_RESET);
        int transAccId = Integer.parseInt(sc.next());
        //transferAccount = current.getCustomerAccounts().get(Integer.parseInt(sc.next()) -1);
        
        System.out.println(ANSI_PURPLE + "Select deposit account number:" + ANSI_RESET);
        int depAccId = Integer.parseInt(sc.next());
        //depositAccount = current.getCustomerAccounts().get(Integer.parseInt(sc.next()) -1);
        
        System.out.println("How much do you want to transfer?");
        transAmount = Double.parseDouble(sc.next());
        
//        if(transAmount <= transferAccount.getBalance()){
//            transferAccount.setBalance(transferAccount.getBalance()-transAmount);
//            depositAccount.setBalance(depositAccount.getBalance()+transAmount);
//            transferAccount.getRecentTransactions().add(-transAmount);
//            depositAccount.getRecentTransactions().add(transAmount);
//            System.out.println("Transfer complete!");
//        }else{
//            System.out.println(ANSI_RED + "Insufficient funds!" + ANSI_RESET);
//        }
        menu();
    }

    public void customerInfo(Customer1 current) throws SQLException{
    
        System.out.println(ANSI_PURPLE + "Username:");
        System.out.println(ANSI_BLUE + current.getUsername());
        System.out.println(ANSI_PURPLE + "Password:");
        System.out.println(ANSI_BLUE + current.getPassword());
        System.out.println(ANSI_PURPLE + "Address:");
        System.out.println(ANSI_BLUE + current.getAddress());
        System.out.println(ANSI_PURPLE + "Phone:");
        System.out.println(ANSI_BLUE + current.getPhone());
        //summary();
        System.out.println("Enter any input to go back");
        String enter = sc.next();
        if(enter != null)
            summary();
    }

//    public void checkAccounts(Customer1 current) throws SQLException{
//        if(current.getCustomerAccounts().size() == 0){
//            System.out.println(ANSI_BLUE + "You currently have no accounts.  Enter x to go back." + ANSI_RESET);
//            String choice = sc.next();
//            if(choice != null)
//                menu();
//        }
//        System.out.println(ANSI_PURPLE + "\nChoose an account number" + ANSI_RESET);
//        for(int i = 0; i < current.getCustomerAccounts().size(); i++)
//            System.out.println(ANSI_BLUE + (i+1) + ": " + current.getCustomerAccounts().get(i).toString() + ANSI_RESET);
//            //System.out.println(current.getCustomerAccounts());
//        System.out.println(ANSI_BLUE + (current.getCustomerAccounts().size() + 1) + ": Go back" + ANSI_RESET);
//        int choice = Integer.parseInt(sc.next());
//        if(choice > current.getCustomerAccounts().size() || choice < 1)
//            menu();
//        System.out.println(ANSI_BLUE + "Recent transactions:");
//        System.out.println(current.getCustomerAccounts().get(choice-1).getRecentTransactions() + ANSI_RESET);
//        menu();
//        //recentTransactions(choice);
//        
//    }
    
    
//    public void recentTransactions(int accountNumber){
//        System.out.println(current.getCustomerAccounts().get(accountNumber-1).getRecentTransactions());
//        
//    }
    
    
    public void makeTransaction(Customer1 current) throws SQLException{
        double transaction = 0;
        System.out.println("\n" + ANSI_PURPLE + "Choose an accout" + ANSI_RESET);
        
        for(int i = 0; i < current.getCustomerAccounts().size(); i++){
            //System.out.println(i ": " + currentAccounts.get(i).getType() + " accout, balance: " + currentAccounts.get(i).getBalance());
            System.out.println(ANSI_BLUE + (i + 1) + ": " + current.getCustomerAccounts().get(i).toString() + ANSI_RESET);
        }
        
        int accountNum = Integer.parseInt(sc.next())-1;
        System.out.println(ANSI_PURPLE + "1: Withdrawal or 2: deposit?" + ANSI_RESET);
        int choice = Integer.parseInt(sc.next());
        Account currentAccount = current.getCustomerAccounts().get(accountNum);
        
        if(choice == 1){
            System.out.println(ANSI_PURPLE + "How much would you like to withdraw?" + ANSI_RESET);
            transaction = -Double.parseDouble(sc.next());
        }else if(choice == 2){
            System.out.println(ANSI_PURPLE + "How much would you like to deposit?" + ANSI_RESET);
            transaction = Double.parseDouble(sc.next());
        }else{
            System.out.println(ANSI_RED + "Invalid choice" + ANSI_RESET);
            makeTransaction(current);
        }
        
        currentAccount.setBalance(currentAccount.getBalance() + transaction);
        currentAccount.getRecentTransactions().add(transaction);
        if(currentAccount.getRecentTransactions().size() > 5)
            currentAccount.getRecentTransactions().remove(0);
        System.out.println(ANSI_BLUE + "Transaction successful!  New balance = " + currentAccount.getBalance());
        menu();
    }
    
    public void addNewAccount(Customer1 current) throws SQLException{
        //Scanner sc = new Scanner(System.in);
        String type = null;
        
        System.out.println("\n");
        System.out.println(ANSI_PURPLE + "What kind of account do you want to create?");
        System.out.println(ANSI_PURPLE + "1: Checking\n2: Savings" + ANSI_RESET);
        String choice = sc.next();
        if(choice.equals("1"))
            type = "checking";
        else if(choice.equals("2"))
            type = "savings";
        else{
            System.out.println(ANSI_RED + "Invadid choice, please try again" + ANSI_RESET);
            addNewAccount(current);
        }
        System.out.println(ANSI_PURPLE + "How much do you want to deposit?" + ANSI_RESET);        
        Account1 account = new Account1(current, type);
        
        statement = conn.prepareStatement("insert into account values(account_number, '" + current.getUsername() + "', 0.0, '" + type + "');");
        statement.execute();
        System.out.println(ANSI_BLUE + "New " + type + " account added with balance: $0" + ANSI_RESET);
                    
        summary();
    }
    
}