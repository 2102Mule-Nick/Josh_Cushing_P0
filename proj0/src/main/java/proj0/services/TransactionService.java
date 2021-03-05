package proj0.services;

import proj0.BankMenu;
import proj0.interfaces.Menu;
import proj0.pojo.UserAcct;

public class TransactionService {
	public void withdraw(UserAcct userAcct, double total) {

		if (total < 0.01) {
			System.out.println("You cannot withdraw less than: $0.01");
		} else if (total <= userAcct.getCheckingBal()) {
			System.out.println("Your checking balance was: $" + userAcct.getCheckingBal());
			System.out.println("You withdrew: " + total);
			double newBal = userAcct.getCheckingBal() - total;
			userAcct.setCheckingBal(newBal);
			System.out.println("Your checking balance is now: $" + userAcct.getCheckingBal());

			// Try to update the user's .dat file.
			UpdateService updateService = new UpdateService();
			updateService.updateUser(userAcct);
		} else {
			System.out.println("Your checking balance is: $" + userAcct.getCheckingBal());
			System.out.println("You cannot withdraw: $" + total);
		}
		System.out.print("Returning to Bank Menu");

		final Menu bankMenu = new BankMenu();
		bankMenu.displayMenuItems();
	}

	// ----------------------------------------------------
	public void deposit(UserAcct userAcct, double total) {

	
		

		/*
		 * 
		 * if(total > 0.01) { System.out.println("Your checking balance was: $" +
		 * userAcct.getCheckingBal()); System.out.println("You deposited: $" + total);
		 * double newBal = userAcct.getCheckingBal() + total;
		 * userAcct.setCheckingBal(newBal);
		 * System.out.println("Your checking balance is: $" +
		 * userAcct.getCheckingBal());
		 * 
		 * //Try to update the user's .dat file. UpdateService updateService = new
		 * UpdateService(); updateService.updateUser(userAcct); }else {
		 * System.out.println("You cannot deposit an amount less than $0.01"); }
		 * System.out.println("Returning to Bank Menu");
		 * 
		 * //Instantiate a menu that is an object of the BankMenu class. final Menu
		 * bankMenu = new BankMenu();
		 * 
		 * //Call the displayMenuItems function of bankMenu.
		 * bankMenu.displayWithAcct(userAcct);
		 */
	}

	public void inquire(UserAcct userAcct) {

		System.out.println("Your current checking balance is: $" + userAcct.getCheckingBal());
		System.out.println("Returning to Bank Menu");

		// Instantiate a menu that is an object of the BankMenu class.
		final Menu bankMenu = new BankMenu();

		// Call the displayMenuItems function of bankMenu.
		bankMenu.displayWithAcct(userAcct);
	}
}
