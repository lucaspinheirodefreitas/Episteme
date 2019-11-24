package br.com.episteme.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
	private String hostname, username, password, database, port, url;
	private Connection connection;
	
	public DataSource() {
		try {
			hostname   = "localhost";
			database   = "episteme";
			username   = "postgres";
			password   = "postgres";
			port       = "5432";
			url        = "jdbc:postgresql://" + hostname + ":" + port + "/" + database;
			connection = DriverManager.getConnection(url, username, password);
		} catch (SQLException ex) {
			System.out.println("Erro ao conectar com o database: " + ex);
		}
	}
	
	public Connection getConnection() {
		return this.connection;
	} 
}
