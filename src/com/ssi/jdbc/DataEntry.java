package com.ssi.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataEntry {

	public static void main(String[] args) {
		try {

			// load driver
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded");
			// establish connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wp", "root", "rr@99");
			System.out.println("Connection established sucessfully");
			
			//dfine sql query
			String sql = "Insert into emp values(101,'rahul',20000,'eng');";
			// send uery to databse
			
			Statement stmt = con.createStatement();
			int row=stmt.executeUpdate(sql);
			con.close();
			System.out.println("NO of rows afected "+row);

		} catch (ClassNotFoundException e) {
			System.out.println("Can't load driver");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Coonnection failed");
			e.printStackTrace();
		}

	}

}
