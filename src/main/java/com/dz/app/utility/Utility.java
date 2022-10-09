package com.dz.app.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Utility {

public static Connection con=null;
	
	public static void main(String[] args) {
		
		// add mySql or oracle connection jar in class path
		getMySqlConnection();
//		getOracleConnection();
		
		try {
			con.close();
			System.out.println("connection closed !");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getMySqlConnection()
	{
		try {
			
			//register the driver means load the driver class 
			Class.forName("com.mysql.jdbc.Driver");
//			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("\nstep 1:- Driver Loaded..");
			
			//Create the connection object
			// means provide the connection between java application and database
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dz","root","root");
			System.out.println("step 2:- connection created.\n");
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return con;
	}
	
	private static Connection getOracleConnection()
	{
		try {
			
			//register the driver means load the driver class 
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("\nDriver Loaded..");
			
			//Create the connection object
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system", "amit");
			System.out.println("connection created.\n");
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return con;
	}
}
