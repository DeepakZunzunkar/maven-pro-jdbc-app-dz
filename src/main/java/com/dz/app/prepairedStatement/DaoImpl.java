package com.dz.app.prepairedStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
			
			//String q1="insert into employee (ename,email,age,salary) values('"+e.getName()+"','"+e.getEmail()+"',"+e.getAge()+","+e.getSalary()+")";
			PreparedStatement ps=con.prepareStatement("insert into employee (ename,email,age,salary) values(?,?,?,?)");
			
			//setting the values
			ps.setString(1, e.getName());
			ps.setString(2, e.getEmail());
			ps.setInt(3, e.getAge());
			ps.setDouble(4, e.getSalary());
			
			status=ps.executeUpdate();
			
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
			
			PreparedStatement ps=con.prepareStatement("update employee set ename=? ,email=?,age=?,salary=? where eid=?");
			ps.setString(1, e.getName());
			ps.setString(2, e.getEmail());
			ps.setInt(3, e.getAge());
			ps.setDouble(4, e.getSalary());
			ps.setInt(5, e.getId());
			
			status=ps.executeUpdate();
			
			
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
			
			PreparedStatement ps=con.prepareStatement("delete from employee where eid=?");
			ps.setInt(1, id);
			
			status=ps.executeUpdate();
			
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
			
			PreparedStatement ps=con.prepareStatement("select * from employee");
			ResultSet rs=ps.executeQuery();
			
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
			PreparedStatement ps=con.prepareStatement("select ename,email,age,salary from employee where eid=?");
			ps.setInt(1, eid);
			ResultSet rs=ps.executeQuery();
					
			while(rs.next())
			{
				e=new Employee();
				e.setName(rs.getString(1));
				e.setEmail(rs.getString(2));
				e.setAge(rs.getInt(3));
				e.setSalary(rs.getDouble(4));
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
		
		return e;
	}
}
