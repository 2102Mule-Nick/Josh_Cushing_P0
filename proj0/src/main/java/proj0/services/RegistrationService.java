package proj0.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Output;

import proj0.BankMenu;
import proj0.RegisterMenu;
import proj0.interfaces.Menu;
import proj0.pojo.UserAcct;

public class RegistrationService {
	public void registerNewUser(String userId, String userName, String passWord) {

		
	}
}
//CONNECCTION EXAMPLE
/*package com.revature.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.revature.pojo.User;

public final class ConnectionFactoryPostgres {

	Logger log = Logger.getRootLogger();

	public static String URL;

	public static String USERNAME;

	public static String PASSWORD;
	
	private static ConnectionFactoryPostgres connectionFactory = null;

	private ConnectionFactoryPostgres() {
		URL = "jdbc:postgresql://" + System.getenv("POS_DB_URL") + ":5432/" + "postgres" + "?";

		USERNAME = System.getenv("POS_DB_USERNAME");

		PASSWORD = System.getenv("POS_DB_PASSWORD");
	}
	
	
	public Connection createConnection() {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Failed to load Driver");
		}

		log.info("URL : " + URL);

		try {
			return DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			log.error("Failed to connect to DB", e);
		}
		return null;
	}
	

	public static synchronized Connection getConnection() {
		
		if (connectionFactory == null) {
			connectionFactory = new ConnectionFactoryPostgres();
		}

		return connectionFactory.createConnection();

	}

}

 * 
 * */

/*KRYO IMPLEMENTATION
	// Create a new Kryo object and two final strings to keep constants.
	Kryo kryo = new Kryo();
	final String FOLDER_NAME = "accts\\";
	final String FILE_EXTENSION = ".dat";

	public void registerNewUser(String userId, String userName, String passWord) {

		// Create a new userAct object by calling its args constructor.
		UserAcct userAcct = new UserAcct(userId, userName, passWord);

		// Initialize output to null.
		FileOutputStream fop = null;
		Output output = null;

		// Set file equal to this long string for brevity.
		File file = new File(FOLDER_NAME + userAcct.getUserId() + userAcct.getUserName() + userAcct.getPassWord() + FILE_EXTENSION);

		// First check to see if the file already exists
		if (file.exists()) {
			System.out.println("ERROR: This user file exists already.");
			final Menu registerMenu = new RegisterMenu();
			registerMenu.displayMenuItems();
		} else {
			try {
				// Try to write a file for the new user.
				fop = new FileOutputStream(file);
				output = new Output(fop);
				kryo.writeObject(output, userAcct);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} finally {
				try {
					// Close the output, then the stream so we can open the file again later.
					output.close();
					fop.close();
					System.out.println("You have created a new account! Welcome " + userAcct.getUserName() + "!");
					// Instantiate BankMenu
					final Menu bankMenu = new BankMenu();
					// Calls BankMenu's displayWithAcct function, passing the new user.
					bankMenu.displayWithAcct(userAcct);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

//Sets the constructor to register the UserAcct class with Kryo upon instantiation.	 
	public RegistrationService() {
		super();
		kryo.register(UserAcct.class);
	}
}
*/