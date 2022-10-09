package com.dz.app.callableStatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import com.dz.app.model.Employee;
import com.dz.app.utility.Utility;

public class DaoImpl {

	public static int insert(Employee e)
	{
		Connection con=null;
		int status=0;
		try {
			
			// get connection object 
			con=Utility.getMySqlConnection();
			
			//call procedure name
			CallableStatement cs=con.prepareCall("call insertEmp(?,?,?,?)");
			cs.setString(1, e.getName());
			cs.setString(2, e.getEmail());
			cs.setInt(3, e.getAge());
			cs.setDouble(4, e.getSalary());
			
			status=cs.executeUpdate();
			
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
		return status;
	}
	
	public static int update(Employee e)
	{
		//updated by id
		Connection con=null;
		int status=0;
		
		try {
			
			// get connection object 
			con=Utility.getMySqlConnection();
			
			CallableStatement cs=con.prepareCall("call updateEmp(?,?,?,?,?)");
			
			cs.setInt(1, e.getId());
			cs.setString(2, e.getName());
			cs.setString(3, e.getEmail());
			cs.setInt(4, e.getAge());
			cs.setDouble(5, e.getSalary());
			
			status=cs.executeUpdate();
			
			
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
		
		return status;
	}
	public static int delete(int id)
	{
		Connection con=null;
		int status=0;
		try {
			
			// get connection object 
			con=Utility.getMySqlConnection();
			
			CallableStatement cs=con.prepareCall("call deleteEmp(?)");
			
			cs.setInt(1, id);
			
			status=cs.executeUpdate();
			
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
		
		return status;
	}
	
	public static List<Employee> getAllRecord()
	{
		Connection con=null;
		ArrayList<Employee> list=new ArrayList<Employee>();
		//Employee e=null; wrong
		try {
			
			// get connection object 
			con=Utility.getMySqlConnection();
			
			CallableStatement cs=con.prepareCall("call selectEmployee()");
			ResultSet rs=cs.executeQuery();
			
			while(rs.next())
			{
				Employee e=new Employee();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setEmail(rs.getString(3));
				e.setAge(rs.getInt(4));
				e.setSalary(rs.getDouble(5));
				
				list.add(e);
				
			}
			
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
		return list;
	}
	
	public static Employee search(int eid) //throws NullPointerException
	{
		Connection con=null;
		Employee e=null;
		try {
			
			// get connection object 
			con=Utility.getMySqlConnection();

			/*
			 * way 1
			 * 
			 CallableStatement cs=con.prepareCall("call selectEmpById(?,?,?,?,?)");
			cs.setInt(1, eid);
			cs.registerOutParameter(2,Types.VARCHAR);
			cs.registerOutParameter(3, Types.VARCHAR);
			cs.registerOutParameter(4, Types.INTEGER);
			cs.registerOutParameter(5, Types.DOUBLE);
			
			cs.execute();
//			System.out.println(cs.getString(2)+" "+cs.getString(3)+" "+cs.getInt(4)+" "+cs.getDouble(5));
			e=new Employee();
			e.setName(cs.getString(2));
			e.setEmail(cs.getString(3));
			e.setAge(cs.getInt(4));
			e.setSalary(cs.getDouble(5));*/
			
			/*
			 * 
			 * way 2
			 */
			CallableStatement cs=con.prepareCall("call selectById(?)");
			cs.setInt(1, eid);
			ResultSet rs=cs.executeQuery();
			
			while(rs.next())
			{
				e=new Employee();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setEmail(rs.getString(3));
				e.setAge(rs.getInt(4));
				e.setSalary(rs.getDouble(5));
			}
		
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
			e=null;
		}finally{
			try {
				//close the resource
				con.close();
				System.out.println("connection closed !\n");
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		
		return e;
	}
}
