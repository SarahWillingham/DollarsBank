package main.java.com.cognixia.jump.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import main.java.com.cognixia.jump.model.Customer;

public class CustomerController {

        final static String ANSI_RESET = "\u001B[0m";
	    
	// Declaring the color
	// Custom declaration
	final static String ANSI_RED = "\u001B[31m";
        final static String ANSI_BLACK = "\u001B[30m";
        final static String ANSI_GREEN = "\u001B[32m";
        final static String ANSI_YELLOW = "\u001B[33m";
        final static String ANSI_BLUE = "\u001B[34m";
        final static String ANSI_PURPLE = "\u001B[35m";
        final static String ANSI_CYAN = "\u001B[36m";
        final static String ANSI_WHITE = "\u001B[37m";
		
//        private static String usernameInput = null;
//        private static String passwordInput = null;
	
    public static void login() {
        
        Customer sarah = new Customer("Sarah", "123");
        Customer fred = new Customer("Fred", "123");
        Customer james = new Customer("James", "123");
        
        ArrayList<Customer> customers = new ArrayList<Customer>(Arrays.asList(sarah, fred, james));
        
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
                }
            }
        }
        
        if(loginSuccess == true){
            System.out.println(ANSI_BLUE + "Login successful!" + ANSI_RESET);
        }else{
            System.out.println(ANSI_RED  + "Login failed!  Please try again" + ANSI_RESET);
            login();
        }

    }
}
