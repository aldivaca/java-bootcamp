package com.mysql.dbAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class DbAccess {
	protected static final StringBuilder dbType = new StringBuilder("com.mysql.jdbc.Driver");
	protected StringBuilder dbPath = new StringBuilder("jdbc:mysql://localhost/high-school");
	protected StringBuilder query = new StringBuilder("");
	protected ResultSet rows;
	private Connection con;
	private Statement stmt;

	protected void setQuery(String sql) {
		query.setLength(0);
		query.append(sql);
	}

	public void openConnection() {
		System.out.println("Open connection");

		try {
			if (con == null || con.isClosed()) {

				Class.forName(dbType.toString());
				// System.out.println(dbPath.toString());

				String servidor = dbPath.toString();
				String usuarioDB = "root";
				String passwordDB = "";

				con = DriverManager.getConnection(servidor, usuarioDB, passwordDB);
			} else {
				System.out.println("Connection already opened");
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Error - " + e.toString());
			System.exit(0);
		}

	}

	public void closeConnection() {
		System.out.println("Close connection");
		try {
			this.con.close();
			this.con = null;
		} catch (SQLException ex) {
			System.out.println("Error on DB closure -" + ex.toString());
			System.exit(0);
		}
	}

	protected void executeSingleQuery() {

		System.out.println(query.toString());
		try {
			this.openConnection();
			this.stmt = this.con.createStatement();
			this.stmt.executeUpdate(query.toString());
		} catch (SQLException ex) {
			System.exit(0);
		}

	}

	protected ResultSet getResultsFromQuery() {

		System.out.println("QUERY: " + query.toString());
		ResultSet rows = null;
		try {
			stmt = this.con.createStatement();
			rows = stmt.executeQuery(query.toString());
		} catch (SQLException ex) {

			System.out.println("Error on execute query - " + ex.toString());
			Logger.getLogger(DbAccess.class.getName()).log(Level.SEVERE, null, ex);
			System.exit(0);
		}
		return rows;
	}

	protected void closeResultSet() throws SQLException {
		this.stmt.close();
	}

}
