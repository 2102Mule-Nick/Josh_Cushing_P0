package proj0;

import java.util.Scanner;
import proj0.interfaces.Menu;
import proj0.pojo.UserAcct;
import proj0.services.RegistrationService;

public class RegisterMenu {

	private static RegisterMenu registerMenu = null;

	public static synchronized RegisterMenu startRegister() {
		if (registerMenu == null) {
			registerMenu = new RegisterMenu();
		}
		return registerMenu;
	}

//-------------------------------------------------------

	public void displayMenuItems(Scanner scanner) {
		// Print out menu title and prompt.
		System.out.println("<-REGISTRATION MENU->");

		// Prompt user for userID
		System.out.println("Please enter a 3 digit user ID.");
		System.out.print("-->");

		// Create a string for the passWord that will be entered by the user.
		String userId = scanner.next();

//----------------------------------------------------------------------------------------------
//DATA RESTRAINT #1: userID entry must be exactly 3 characters long, and they all must be digits.

		while (userId.length() != 3 || Character.isDigit(userId.charAt(0)) == false
				|| Character.isDigit(userId.charAt(1)) == false || Character.isDigit(userId.charAt(2)) == false) {
			System.out.println("Please make sure the ID is exactly 3 DIGITS long.");
			System.out.print("-->");
			userId = scanner.next();
		}

		// If the proper type of userId is entered, we make it to here.

		System.out.println("Please enter a username.");
		System.out.print("-->");

		// Create a string for the userName that will be entered by the user.
		String userName = scanner.next();
//------------------------------------------------------------------------------------------------
//DATA RESTRAINT #2: UserName must be between 3 and 15 characters, and must only contains letters.
		
		Boolean hasOnlyLetters = true;
		for (int i=0; i<userName.length(); i++) {
			if(Character.isLetter(userName.charAt(i)) == false){
				hasOnlyLetters = false;
			}
		}
		
		while (userName.length() > 15 || userName.length() < 3 || hasOnlyLetters == false) {
			System.out.println("Please ensure that your username is\nbetween 3 and 15 characters and contains only letters.");
			System.out.print("-->");
			userName = scanner.next();
			
			hasOnlyLetters = true;
			for (int i=0; i<userName.length(); i++) {
				if(Character.isLetter(userName.charAt(i)) == false){
					hasOnlyLetters = false;
				}
			}
		}
		
		// If the proper type of user name is entered, we make it to here.
		System.out.println("Please enter your password-->");
		System.out.print("-->");

		// Create a string for the passWord that will be entered by the user.
		String passWord = scanner.next();
//---------------------------------------------------------------------------------------------------------
//DATA RESTRAINT #3: UserName must be between 5 and 15 characters.
				
		while (passWord.length() > 15 || passWord.length() < 5) {
			System.out.println("Please ensure that your password is between 3 and 15 characters.");
			System.out.print("-->");
			passWord = scanner.next();
		}

		// Finally, if all the data constraints have been passed, we make it here.
		RegistrationService registrationService = new RegistrationService();
		registrationService.registerNewUser(userId, userName, passWord);
		
	}
}