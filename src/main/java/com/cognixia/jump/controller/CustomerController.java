package main.java.com.cognixia.jump.controller;

import java.util.Scanner;

public class CustomerController {

	
	String usernameInput = null;
	String passwordInput = null;
	
	public void login() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please enter username.");
		usernameInput = sc.next();
		System.out.println("Please enter password");
		passwordInput = sc.next();
	}
}
