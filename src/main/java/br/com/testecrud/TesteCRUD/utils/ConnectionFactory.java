package br.com.testecrud.TesteCRUD.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {

	public static Connection getConnection() {

		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			System.err.println("Missing PostgreSQL JDBC Driver. Please include in your library path!");
			return null;
		}

		Connection connection = null;
		try {
			String url = "jdbc:postgresql://localhost:5432/DBTesteCRUD";
			Properties props = new Properties();
			props.setProperty("user", "postgres");
			props.setProperty("password", "root");
			connection = DriverManager.getConnection(url, props);
		} catch (SQLException e) {
			System.err.println("Connection Failed: " + e.getMessage());
			return null;
		}

		if (connection != null) {
			System.out.println("Connected to DataBase DBTesteCRUD!");
			return connection;
		} else {
			System.err.println("Failed to make connection!");
			return null;
		}

	}

}