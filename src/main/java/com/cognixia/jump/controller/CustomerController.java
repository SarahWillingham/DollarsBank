package main.java.com.cognixia.jump.controller;

import java.util.ArrayList;
import java.util.Scanner;
import main.java.com.cognixia.jump.model.Account;
import main.java.com.cognixia.jump.model.Customer;

public class CustomerController {

    // Declaring the color
    // Custom declaration
    final static String ANSI_RESET = "\u001B[0m";
    final String ANSI_RED = "\u001B[31m";
    final String ANSI_BLACK = "\u001B[30m";
    final String ANSI_GREEN = "\u001B[32m";
    final String ANSI_YELLOW = "\u001B[33m";
    final String ANSI_BLUE = "\u001B[34m";
    final String ANSI_PURPLE = "\u001B[35m";
    final String ANSI_CYAN = "\u001B[36m";
    final String ANSI_WHITE = "\u001B[37m";

	// create initial test customers
    Customer sarah = new Customer("sarah", "123", "TX", "123456789");
    Customer fred = new Customer("fred", "123", "PA", "987654321");
    Customer james = new Customer("james", "123", "CA", "234567890");
    Customer current = null;
    ArrayList<Customer> customers = new ArrayList<Customer>(Arrays.asList(sarah, fred, james));    
    
    Scanner sc = new Scanner(System.in);

	// create intial test accounts and add to customer
    public void setup() {
        Account account1 = new Account(sarah, 500.0, "checking");
        Account account2 = new Account(sarah, 400.0, "checking");
        Account account3 = new Account(sarah, 300.0, "savings");
        sarah.getCustomerAccounts().add(account1);
        sarah.getCustomerAccounts().add(account2);
        sarah.getCustomerAccounts().add(account3);
    }

	// allow user to create new customer object with username/password and personal details
    public void register(){
        System.out.println("Enter new username:");
        String username = sc.next();
        System.out.println("Enter new password:");
        String password = sc.next();
        System.out.println("Address:");
        String address = sc.next();
        System.out.println("Phone number:");
        String phone = sc.next();
        
        Customer customer = new Customer(username, password, address, phone);
        current = customer;
        if(current != null)
            System.out.println(ANSI_GREEN + "User successfully registered!" + ANSI_RESET);
        menu();
    }

	
    public void login() {
        boolean loginSuccess = false;
        String usernameInput = null;
	String passwordInput = null;
        
        System.out.println(ANSI_PURPLE + "Please enter USERNAME or 'r' to register a new user account." + ANSI_RESET);
        usernameInput = sc.next();
        if(usernameInput.equals("r"))
            register();
        System.out.println(ANSI_PURPLE + "Please enter password" + ANSI_RESET);
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
            System.out.println(ANSI_GREEN + "Login successful!\n" + ANSI_RESET);
            summary();
        }else{
            System.out.println(ANSI_RED  + "Login failed!  Please try again" + ANSI_RESET);
            login();
        }
    }

	
    public void summary(){
        for(int i = 0; i < current.getCustomerAccounts().size(); i++)
            System.out.println(ANSI_BLUE + (i+1) + ": " + current.getCustomerAccounts().get(i).toString());
        menu();
    }

	
    public void menu(){
        System.out.println("\n" + ANSI_PURPLE + "Select an option");
        System.out.println(ANSI_PURPLE + "1. Create new account");
        System.out.println(ANSI_PURPLE + "2. Recent account activity");
        System.out.println(ANSI_PURPLE + "3. Deposit or withdrawal");
        System.out.println(ANSI_PURPLE + "4. Transfer funds");
        System.out.println(ANSI_PURPLE + "5. View customer information");
        System.out.println(ANSI_PURPLE + "6. Logout" + ANSI_RESET);

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
    

    public void transfer(){
        Account transferAccount;
        Account depositAccount;
        double transfer;
        
        for(int i = 0; i < current.getCustomerAccounts().size(); i++)
            System.out.println(ANSI_BLUE + (i+1) + ": " + current.getCustomerAccounts().get(i).toString());
        System.out.println(ANSI_PURPLE + "Select transfer account" + ANSI_RESET);
        transferAccount = current.getCustomerAccounts().get(Integer.parseInt(sc.next()) -1);
        System.out.println(ANSI_PURPLE + "Select deposit account" + ANSI_RESET);
        depositAccount = current.getCustomerAccounts().get(Integer.parseInt(sc.next()) -1);
        System.out.println("How much do you want to transfer?");
        transfer = Double.parseDouble(sc.next());
        
        if(transfer <= transferAccount.getBalance()){
            transferAccount.setBalance(transferAccount.getBalance()-transfer);
            depositAccount.setBalance(depositAccount.getBalance()+transfer);
            transferAccount.getRecentTransactions().add(-transfer);
            depositAccount.getRecentTransactions().add(transfer);
            System.out.println("Transfer complete!");
        }else{
            System.out.println(ANSI_RED + "Insufficient funds!" + ANSI_RESET);
        }
        menu();
    }

	
    public void customerInfo(Customer current){
        System.out.println(ANSI_PURPLE + "Username:");
        System.out.println(ANSI_BLUE + current.getUsername());
        System.out.println(ANSI_PURPLE + "Password:");
        System.out.println(ANSI_BLUE + current.getPassword());
        System.out.println(ANSI_PURPLE + "Address:");
        System.out.println(ANSI_BLUE + current.getAddress());
        System.out.println(ANSI_PURPLE + "Phone:");
        System.out.println(ANSI_BLUE + current.getPhone());
        System.out.println("Enter any input to go back");
        String enter = sc.next();
        if(enter != null)
            summary();
    }

	
    public void checkAccounts(Customer current){
        if(current.getCustomerAccounts().size() == 0){
            System.out.println(ANSI_BLUE + "You currently have no accounts.  Enter x to go back." + ANSI_RESET);
            String choice = sc.next();
            if(choice != null)
                menu();
        }
        System.out.println(ANSI_PURPLE + "\nChoose an account number" + ANSI_RESET);
        for(int i = 0; i < current.getCustomerAccounts().size(); i++)
            System.out.println(ANSI_BLUE + (i+1) + ": " + current.getCustomerAccounts().get(i).toString() + ANSI_RESET);
        System.out.println(ANSI_BLUE + (current.getCustomerAccounts().size() + 1) + ": Go back" + ANSI_RESET);
        int choice = Integer.parseInt(sc.next());
        if(choice > current.getCustomerAccounts().size() || choice < 1)
            menu();
        System.out.println(ANSI_BLUE + "Recent transactions:");
        System.out.println(current.getCustomerAccounts().get(choice-1).getRecentTransactions() + ANSI_RESET);
        menu();
    }
    
    
    public void makeTransaction(Customer current){
        double transaction = 0;
        System.out.println("\n" + ANSI_PURPLE + "Choose an accout" + ANSI_RESET);
        
        for(int i = 0; i < current.getCustomerAccounts().size(); i++){
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

	
    public void addNewAccount(Customer current){
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
        Double initialBalance = Double.parseDouble(sc.next());
        
        Account account = new Account(current, initialBalance, type);
        System.out.println(ANSI_BLUE + "New " + type + " account added with balance: " + initialBalance + ANSI_RESET);
        
        
        current.getCustomerAccounts().add(account);
        System.out.println(current.getCustomerAccounts());
        menu();
    }
    
}
