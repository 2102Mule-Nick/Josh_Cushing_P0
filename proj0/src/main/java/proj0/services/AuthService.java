package proj0.services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;

import proj0.BankMenu;
import proj0.LoginMenu;
import proj0.interfaces.Menu;
import proj0.pojo.UserAcct;

public class AuthService {
	public void authenticateUser(String userId, String userName, String passWord) {
	
	}
}


/*KRYO IMPLEMENTATION
// Create a new Kryo object and two final strings to keep constants.
Kryo kryo = new Kryo();
final static String FOLDER_NAME = "accts\\";
final static String FILE_EXTENSION = ".dat";

public void authenticateUser(String userId, String userName, String passWord) {

	// Initialize input to null.
	FileInputStream fip = null;
	Input input = null;
	// Instantiate a userAcct that is an object of the UserAcct class.
	UserAcct userAcct = new UserAcct(userId, userName, passWord);

	// Set file equal to this long string for brevity.
	File file = new File(
			FOLDER_NAME + userAcct.getUserId() + userAcct.getUserName() + userAcct.getPassWord() + FILE_EXTENSION);

	// First check to see if the file already exists
	if (!file.exists()) {
		System.out.print("ERROR: User not found. Make sure your information was correct");
		final Menu loginMenu = new LoginMenu();
		loginMenu.displayMenuItems();
	} else {
		try {
			// Try to read a file in accts/
			fip = new FileInputStream(file);
			input = new Input(fip);
			userAcct = kryo.readObject(input, UserAcct.class);
			System.out.println("User authenticated. Welcome " + userAcct.getUserName() + "!");
			// Instantiate BankMenu
			final Menu bankMenu = new BankMenu();
			// Calls BankMenu's displayWithAcct function, passing the new user.
			bankMenu.displayWithAcct(userAcct);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.print("User not found. Make sure your information was correct");
		} finally {
			// Another try catch.
			try {
				// Close the input, then the stream. This will cause errors otherwise.
				input.close();
				fip.close();
			} catch (IOException e) {
				// The error to catch
				e.printStackTrace();
			}
		}
	}
}

//Sets the constructor to register the UserAcct class with Kryo upon instantiation.	 
public AuthService() {
	super();
	kryo.register(UserAcct.class);
}
}
*/