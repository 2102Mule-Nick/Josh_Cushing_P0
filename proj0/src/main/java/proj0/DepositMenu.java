package proj0;

import java.util.Scanner;
import proj0.interfaces.Menu;
import proj0.pojo.UserAcct;
import proj0.services.TransactionService;
import proj0.services.TransactionServices;

public class DepositMenu implements Menu {

	@Override
	public void displayMenuItems() {
		System.out.println("<-DEPOSIT MENU->");
		System.out.println("This menu can only be accessed by logging in.");
	}

	@Override
	public void displayWithAcct(UserAcct userAcct) {
		System.out.println("<-DEPOSIT MENU->");
		System.out.print("How much would you like to Deposit?");
		
		// Instantiate a scanner to read console input.
		Scanner scanner = new Scanner(System.in);
		
		//Instantiate a new transactionServices
		TransactionService transactionService = new TransactionService();
		
		// Get user input.
		double total = scanner.nextDouble();

		String checkTotal = String.valueOf(total);
		Boolean isValidMoney = true;

		try {
			Float.parseFloat(checkTotal);
		} catch (NumberFormatException e) {
			System.out.println(checkTotal + " is not a valid amount for currency.");
			System.out.println("Please enter digits in this format: 33.12");
			isValidMoney = false;
		}
		
		while (isValidMoney == false){
			
			total = scanner.nextDouble();
			checkTotal = String.valueOf(total);
			isValidMoney = true;
			
			try {
				Float.parseFloat(checkTotal);
			} catch (NumberFormatException e) {
				System.out.println(checkTotal + " is not a valid amount for currency.");
				System.out.println("Please enter digits in this format: 33.12");
				isValidMoney = false;
			}		
		}
		transactionService.deposit(userAcct, total);
	}	
}
