package main.java.com.cognixia.jump;

import main.java.com.cognixia.jump.controller.CustomerController;

public class DollarsBankCoreJavaProjectApp {

	public static void main(String[] args) {
            
            
            CustomerController custControl = new CustomerController();
            custControl.setup();
            custControl.login();

	}
	
}
