package proj0;

import java.util.Scanner;

public class Driver {
	public static void main(String[] args) {

		// Instantiate a scanner to read console input.
		Scanner scanner = new Scanner(System.in);
		
		//Call MainMenu's (singleton) startMain Method. 
		//This will instantiate a final object called mainMenu.
		final MainMenu mainMenu = MainMenu.startMain();
		
		//Call mainMenu's displayMenuItems, passing:
		// 1) a scanner 
		// 2) the result of RegisterMenu's (singleton) startRegister method --> a final object called registerMenu;
		// 3) the result of LoginMenu's (singleton) startLogin method --> a final object called loginMenu.
		mainMenu.displayMenuItems(scanner, RegisterMenu.startRegister(), LoginMenu.startLogin());
	}
}
