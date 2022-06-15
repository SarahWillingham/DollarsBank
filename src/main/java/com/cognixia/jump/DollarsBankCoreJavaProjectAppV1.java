package main.java.com.cognixia.jump;
import main.java.com.cognixia.jump.controller.CustomerController;
import main.java.com.cognixia.jump.model.Customer;
import java.util.ArrayList;
import java.util.Arrays;

public class DollarsBankCoreJavaProjectAppV1 {

	public static void main(String[] args) {
            
            
            CustomerController custControl = new CustomerController();
            custControl.setup();
            custControl.login();

	}
	
}