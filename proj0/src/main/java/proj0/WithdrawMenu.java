package proj0;

import java.util.Scanner;

import proj0.interfaces.Menu;
import proj0.pojo.UserAcct;
import proj0.services.TransactionServices;

public class WithdrawMenu implements Menu {

	@Override
	public void displayMenuItems() {
		System.out.println("<-WITHDRAW MENU->");
		System.out.println("This menu can only be accessed by logging in.");

	}

	@Override
	public void displayWithAcct(UserAcct userAcct) {
		System.out.println("<-WITHDRAW MENU->");
		System.out.print("How much would you like to withdraw?");
		
		// Instantiate a scanner to read console input.
		Scanner scanner = new Scanner(System.in);
		
		//Instantiate a new transactionServices
		TransactionServices transactionServices = new TransactionServices();
		
		// Get user input.
		double total = scanner.nextDouble();
		
		String checkTotal = String.valueOf(total);
		
		Boolean isFloaty;
		
		try {  
		    Double.parseDouble(checkTotal);  
		    isFloaty = true;
		  } catch(NumberFormatException e){  
		    isFloaty = false;  
		  }  
		
		if(isFloaty == false) {
			System.out.println("That is not a valid number.");
			//Call the displayMenuItems function of bankMenu.
			displayWithAcct(userAcct);
		}
		
		transactionServices.withdraw(userAcct, total);
	}
}
