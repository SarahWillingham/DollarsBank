package main.java.com.cognixia.jump;

import java.util.Scanner;

import main.java.com.cognixia.jump.controller.CustomerController;
import main.java.com.cognixia.jump.model.Customer;

public class DollarsBankCoreJavaProjectAppV1 {

	public static void main(String[] args) {
		
	    final String ANSI_RESET = "\u001B[0m";
	    
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
		
            String usernameInput = null;
            String passwordInput = null;
		
            Scanner sc = new Scanner(System.in);
            System.out.println("Please enter username.");
            usernameInput = sc.next();
            System.out.println("Please enter password");
            passwordInput = sc.next();
		
		
            System.out.println(ANSI_GREEN + "Your username is " + usernameInput + " and your password is " + passwordInput + "\u001B[0m");
	}
	
}
