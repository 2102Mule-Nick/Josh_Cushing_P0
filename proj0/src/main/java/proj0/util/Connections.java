package proj0.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class Connections {
	// Make some strings to hold the environment variables.
	public static String URL;
	public static String USERNAME;
	public static String PASSWORD;

	// This is also going to be singleton so it will be set up like our menu
	// classes.
	private static Connections connectionsSingle = null;

	// The constructor pulls our environemnts variables os no one ever truly knows
	// them.
	private Connections() {
		URL = "jdbc:postgresql://" + System.getenv("BANK_DB_URL") + ":5432/" + "postgres" + "?";
		USERNAME = System.getenv("BANK_DB_USERNAME");
		PASSWORD = System.getenv("BANK_DB_PASSWORD");
	}

	// Here we will make a connection.
	public Connection createConnection() {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Failed to load Driver");
		}

		// Also need Nick's help getting log4j running
		// log.info("URL : " + URL);

		try {
			return DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			System.out.println("Failed to connect to DB");
			// log.error("Failed to connect to DB", e);
		}
		return null;
	}

	//And here's the singleton constructor.
	public static synchronized Connection getConnection() {

		if (connectionsSingle == null) {
			connectionsSingle = new Connections();
		}

		return connectionsSingle.createConnection();
	}
}
