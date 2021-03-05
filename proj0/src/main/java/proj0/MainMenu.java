package proj0;

import java.util.Scanner;

//This object is set up as a singleton because the mainMenu does not have anything dynamic.
public final class MainMenu {
	
	private static MainMenu mainMenu = null;

	public static synchronized MainMenu startMain() {
		if (mainMenu == null) { 
			mainMenu = new MainMenu(); 
		}
		return mainMenu;
	}
//-------------------------------------------------------
	public void displayMenuItems(Scanner scanner, RegisterMenu registerMenu, LoginMenu loginMenu) {
		
		// Print out menu title, options, and prompt.
		System.out.println("<-MAIN MENU->");
		System.out.println("-->1) Login");
		System.out.println("-->2) Register");
		System.out.println("-->3) Quit\n");
		System.out.print("Please type in the number for\none of the following options-->");

		// Instantiate userInput and set equal to console input.
		String userInput = scanner.next();

		// Switch to handle user decision.
		switch (userInput) {
		case "1":
			// If 1, go to login menu
			loginMenu.displayMenuItems(scanner);
			break;
		case "2":
			// If 2, go to register menu
			registerMenu.displayMenuItems(scanner);
			break;
		case "3":
			// If 3 exit the program, no break needed.
			System.out.println("Goodbye");
			System.exit(0);
		default:
			// Print instructions in case the user mistypes.
			System.out.println("Please type in 1, 2, or 3 for the corresponding option.");
			
			// Send user back to top of menu.
			displayMenuItems(scanner, registerMenu, loginMenu);
		}
	}
}