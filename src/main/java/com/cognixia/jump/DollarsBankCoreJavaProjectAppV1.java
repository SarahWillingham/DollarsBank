package main.java.com.cognixia.jump;
import main.java.com.cognixia.jump.controller.CustomerController;
import main.java.com.cognixia.jump.model.Customer;
import java.util.ArrayList;
import java.util.Arrays;

public class DollarsBankCoreJavaProjectAppV1 {

	public static void main(String[] args) {
            
//            Customer sarah = new Customer("Sarah", "123");
//            Customer fred = new Customer("Fred", "123");
//            Customer james = new Customer("James", "123");
//            ArrayList<Customer> customers = new ArrayList<Customer>(Arrays.asList(sarah, fred, james));
            
            
            CustomerController custControl = new CustomerController();
            custControl.setup();
            custControl.login();
            
//            if(custControl.login() != null){
//                custControl.menu();
//            };
            
            
	}
	
}
