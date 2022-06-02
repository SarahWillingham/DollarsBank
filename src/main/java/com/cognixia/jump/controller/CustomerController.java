package main.java.com.cognixia.jump.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import main.java.com.cognixia.jump.model.Account;
import main.java.com.cognixia.jump.model.Customer;

public class CustomerController {

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
		

        Customer sarah = new Customer("Sarah", "123");
        Customer fred = new Customer("Fred", "123");
        Customer james = new Customer("James", "123");
        
        Customer current = null;
        
        ArrayList<Customer> customers = new ArrayList<Customer>(Arrays.asList(sarah, fred, james));    
	
    public Customer login() {
        
        System.out.println(customers);
        
        boolean loginSuccess = false;
        
        String usernameInput = null;
	String passwordInput = null;
        
        Scanner sc = new Scanner(System.in);
        System.out.println(ANSI_GREEN + "Please enter username." + ANSI_RESET);
        usernameInput = sc.next();
        System.out.println(ANSI_GREEN + "Please enter password" + ANSI_RESET);
        passwordInput = sc.next();
            
        for(Customer customer : customers){
            if(usernameInput.equals(customer.getUsername())){
                if(passwordInput.equals(customer.getPassword())){
                    loginSuccess = true;
                    current = customer;
                }
            }
        }
        
        if(loginSuccess == true){
            System.out.println(ANSI_BLUE + "Login successful!" + ANSI_RESET);
            menu();
        }else{
            System.out.println(ANSI_RED  + "Login failed!  Please try again" + ANSI_RESET);
            login();
        }

        return current;
    }
    
    
    public void menu(){
        String choice;
        String initialBalance;
        
        System.out.println("Select an option \n1. Create new account");
        System.out.println("2. Check account status");
        System.out.println("3. Make transaction");

        Scanner sc = new Scanner(System.in);
        choice = sc.next();
        
        //Double.parseDouble(choice);
        if(Double.parseDouble(choice) == 1){
            System.out.println("How much do you want to deposit?");
            initialBalance = sc.next();
            addNewAccount(current, Double.parseDouble(initialBalance));
            System.out.println("New account added with balance: " + initialBalance);
            System.out.println(current.getCustomerAccounts());
        }else if(Double.parseDouble(choice) == 2){
            System.out.println("Choose an account index");
            System.out.println(current.getCustomerAccounts());
        }else{
            System.out.println("Invalid choice");
        }
    }
    
    
    public void addNewAccount(Customer current, Double initialBalance){
        
        Account newAccount = new Account(initialBalance);
        current.getCustomerAccounts().add(newAccount);
    }
    
}
