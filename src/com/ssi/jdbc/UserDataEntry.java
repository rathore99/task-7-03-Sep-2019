package com.ssi.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UserDataEntry {

	public Connection estbConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded sucessfully");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wp", "root", "rr@99");
			System.out.println("Connection estb succesfully");
			return con;
//			String sql = "Insert Into emp values(?,?,?,?)";
//			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
//			stmt.setInt(1, 102);
//			stmt.setString(2, "Vinod");
//			stmt.setInt(3,24000);
//			stmt.setString(4,"Manager");
//			int row = stmt.executeUpdate();
//			con.close();
//			System.out.println("Rows updated"+row);

		} catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}

	/*
	 * function to show menu
	 */
	public void showMenu() {

		System.out.println("Select from Given option");
		System.out.println("1. Insert");
		System.out.println("2. Update");
		System.out.println("3. Delete");
		System.out.println("4. Show Table");
		System.out.println("5. Exit");
		System.out.println("Enter your choise");

	}

	/*
	 * Method to implement switch case take int choice as parameter return nothing
	 */
	public void performOperation(int choice, Scanner sc) throws SQLException {
		// Scanner sc = new Scanner(System.in);
		int empno, sal;
		String ename, job;
		switch (choice) {
		case 1:
			System.out.println("Enter employee No");
			empno = sc.nextInt();
			System.out.println("Enter employee Name");
			ename = sc.next();
			System.out.println("Enter employee Salary");
			sal = sc.nextInt();
			System.out.println("Enter employee job");
			job = sc.next();
			// sc.close();
			this.insertData(empno, ename, sal, job);

			break;
		case 2:
			System.out.println("Enter employee No");
			empno = sc.nextInt();
			System.out.println("Enter employee Name");
			ename = sc.next();
			System.out.println("Enter employee Salary");
			sal = sc.nextInt();
			System.out.println("Enter employee job");
			job = sc.next();
			// sc.close();
			this.updatetData(empno, ename, sal, job);
			break;
		case 3:
			System.out.println("Enter employee No");
			empno = sc.nextInt();
			// sc.close();
			this.deleteData(empno);
			break;
		case 4:
			showData();
			// sc.close();
			break;
		case 5:
			// sc.close();
			System.out.println("----Thank you-----");
			System.exit(0);

			break;
		default:
			// sc.close();
			System.out.println("----Thank you-----");
			System.exit(0);
			break;
		}
	}

	/*
	 * method to insert data in db
	 */
	private void insertData(int empno, String ename, int sal, String job) throws SQLException {
		Connection con = estbConnection();
		String sql = "Insert Into emp values(?,?,?,?)";
		PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
		stmt.setInt(1, empno);
		stmt.setString(2, ename);
		stmt.setInt(3, sal);
		stmt.setString(4, job);
		int row = stmt.executeUpdate();
		con.close();
		System.out.println("Rows updated" + row);
	}

	/*
	 * Method to update data in db
	 */
	private void updatetData(int empno, String ename, int sal, String job) throws SQLException {
		Connection con = estbConnection();
		String sql = "Update emp set ename =?,sal =?,job =? where empno = "+empno;
		PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
		//stmt.setInt(4, empno);
		stmt.setString(1, ename);
		stmt.setInt(2, sal);
		stmt.setString(3, job);
		int row = stmt.executeUpdate();
		con.close();
		System.out.println("Rows updated" + row);
	}

	/*
	 * method to delete record from db
	 */
	private void deleteData(int empno) throws SQLException {
		Connection con = estbConnection();
		String sql = "delete from emp where empno = ?";
		PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
		stmt.setInt(1, empno);
		int row = stmt.executeUpdate();
		con.close();
		System.out.println("Rows updated" + row);

	}

	/*
	 * method to display data
	 */
	private void showData() throws SQLException {
		Connection con = estbConnection();
		String sql = "select * from emp";
		Statement stmt = con.createStatement();
		stmt.execute(sql);

	}
	
	public static void clearScreen() {  
	    System.out.print("\033[H\033[2J");  
	    System.out.flush();  
	}  

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		UserDataEntry obj = new UserDataEntry();
		
		while(true) {
		obj.showMenu();
		int choice = sc.nextInt();

		try {
			obj.performOperation(choice,sc);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
		}
		clearScreen();
		}
	}

}
