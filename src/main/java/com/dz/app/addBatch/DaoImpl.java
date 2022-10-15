package com.dz.app.addBatch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.dz.app.model.Employee;
import com.dz.app.utility.Utility;


public class DaoImpl {

	public static int[] insert(List<Employee> elist) {

		Connection con = null;
		int[] i=null; 
		PreparedStatement ps = null;
		
		try {

			// get connection object 
			con =Utility.getMySqlConnection();
			
			ps = con.prepareStatement("insert into employee (ename ,email,age,salary) values(?,?,?,?)");
			
			for(Employee e: elist)
			{
				ps.setString(1, e.getName());
				ps.setString(2, e.getEmail());
				ps.setInt(3, e.getAge());
				ps.setDouble(4, e.getSalary());

				ps.addBatch();
			}
			i = ps.executeBatch();
			// System.out.println(i.length);
			
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}finally{
			try {
				//close the resource
				con.close();
				System.out.println("connection closed !\n");
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}

		return i;
	}
	
	public static void update()
	{
		
	}
	
	public static void delete()
	{
		
	}
	
	public static void getRecord()
	{
		
	}
}
