package proj0;

import java.util.Scanner;
import proj0.interfaces.Menu;
import proj0.pojo.UserAcct;
import proj0.services.AuthService;

public final class LoginMenu {

	private static LoginMenu loginMenu = null;

	public static synchronized LoginMenu startLogin() {
		if (loginMenu == null) {
			loginMenu = new LoginMenu();
		}
		return loginMenu;
	}

//-------------------------------------------------------
	public void displayMenuItems(Scanner scanner) {
		// Prompt user for userName
		System.out.println("<-LOGIN MENU->");
		System.out.print("Please enter your user ID-->");

		// Create a string for the userName that will be entered by the user.
		String userId = scanner.next();

		System.out.print("Please enter your username-->");

		// Create a string for the userName that will be entered by the user.
		String userName = scanner.next();

		// Prompt user for passWord
		System.out.print("Please enter your password-->");

		// Create a string for the passWord that will be entered by the user.
		String passWord = scanner.next();

		// Send userName and passWord to authService.
		
		// Instantiate a authService.
		AuthService authService = new AuthService();
		
		
		authService.authenticateUser(userId, userName, passWord);
	}
}