package br.com.sistemamedico.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {
	
	private static final String URL = "jdbc:mysql://localhost:3306/avaliacao";
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String USUARIO = "root";
	private static final String SENHA = "a";
	
	public static Connection openConnection() throws SQLException {
		try {
			Class.forName(DRIVER);
			return DriverManager.getConnection(URL, USUARIO, SENHA);
			
		} catch (ClassNotFoundException e) {
			throw new SQLException(e.getMessage());
		}
	}

}
