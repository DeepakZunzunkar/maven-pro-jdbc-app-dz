package com.dz.app.statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.dz.app.utility.Utility;

public class DaoImpl {

	public static boolean create()
	{
		boolean status=true;
		Connection con=null;
		try {
			
			// get connection object 
			con=Utility.getMySqlConnection();
			Statement st=con.createStatement();
			
			//step 3:-write the query
			String q1="create table Employee (eid int primary key auto_increment ,ename varchar(50),email varchar(50),age int,salary double)";
			System.err.println(q1);
			//step 4:-execute the query
			status=st.execute(q1);
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		finally{
			try {
				//step 5:close the resource
				con.close();
				System.out.println("connection closed !");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return status;
	}
	
	public static void insert()
	{
		Connection con=null;
		
		try {
			// get connection object 
			con=Utility.getMySqlConnection();
			Statement st=con.createStatement();
			Scanner sc=new Scanner(System.in);
			String choice="yes";
			while(choice.equalsIgnoreCase("yes"))
			{
				System.out.println("enter employee name :");
				String name=sc.next();
				System.out.println("enter employee email :");
				String email=sc.next();
				System.out.println("enter employee age :");
				int age=sc.nextInt();
				System.out.println("enter employee salary :");
				double sal=sc.nextDouble();
			
				//step 3:-write the query
				String q2="insert into Employee (ename,email,age,salary) values('"+name+"','"+email+"',"+age+","+sal+")";
				System.err.println(q2);
				//step 4:-execute the query
				int i=st.executeUpdate(q2);
				if(i>0)
				{
					System.out.println("values are inserted successfully !");
				}
				
				System.out.println("do u want to insert another row (yes/no) ? :");
				choice=sc.next();
				
			}

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}finally{
			try {
				//step 5:close the resource
				con.close();
				System.out.println("connection closed !");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void update()
	{
		Connection con=null;
		int status=0;
		//update by using id
		try {
			
			// get connection object 
			con=Utility.getMySqlConnection();
			Statement st=con.createStatement();
			Scanner sc=new Scanner(System.in);
			System.out.println("enter id : ");
			int id =sc.nextInt();
			
			if(getRecordByID(id)) {
				
				System.out.println("enter name:");
				String name=sc.next();
				
				System.out.println("enter email:");
				String email=sc.next();
				
				System.out.println("enter age:");
				int age =sc.nextInt();
				
				System.out.println("enter salary :");
				double sal=sc.nextDouble();
				
				//step 3:-write the query
				String q3="update Employee set ename='"+name+"',email='"+email+"',age="+age+",salary="+sal+" where eid="+id;
				System.err.println(q3);
				//step 4:-execute the query
				status=st.executeUpdate(q3);
				if(status>0)
				{
					System.out.println("record update succesfully..");
				}
			}
		
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}finally{
			try {
				//step 5:close the resource
				con.close();
				System.out.println("connection closed !");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
	public static void delete()
	{
		//delete by using id
		Connection con=null;
		try {
			
			// get connection object 
			con=Utility.getMySqlConnection();
			Statement st=con.createStatement();
			Scanner sc=new Scanner(System.in);
			System.out.println("enter id:");
			int id =sc.nextInt();
			
			if(getRecordByID(id)) {
				//step 3:-write the query
				String q4="delete from Employee where eid="+id;
				System.err.println(q4);
				//step 4:-execute the query 
				int status=st.executeUpdate(q4);
				
				if(status>0)
				{
					System.out.println("record succcesfully delete..");
				}
			}
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}finally{
			try {
				//step 5:close the resource
				con.close();
				System.out.println("connection closed !");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static boolean getRecordByID(int id)
	{
		Connection con=null;
		boolean status=false;
		try {
			
			// get connection object 
			con=Utility.getMySqlConnection();
			Statement st=con.createStatement();
			
			//step 3:-write the query
			String q5="select * from Employee where eid="+id;
			System.err.println(q5);
			//step 4:-execute the query
			ResultSet rs=st.executeQuery(q5);
//			System.out.println("size : "+rs.getFetchSize());
//			System.out.println(rs.wasNull());
			if(!rs.wasNull()) {
				status= true;
				System.out.println("--------------------------------------------------------------------");
				System.out.println("ID  | NAME   | EMAIL		|  AGE	| SALLARY ");
				System.out.println("---------------------------------------------------------------------");
				
				while(rs.next())
				{
					System.out.println(rs.getInt(1)+" | \t"+rs.getString(2)+" | \t"+rs.getString(3)+"| \t"+rs.getInt(4)+" | \t"+rs.getDouble(5)+"\t |");
				}
				System.out.println("-----------------------------------------------------------------------\n");
			}else {
				System.err.println(" no record found !");
			}
			
//			if(rs.getFetchSize() == 0){
//				System.out.println("No Records ..");
//			}
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}finally{
			try {
				//step 5:close the resource
				con.close();
				System.out.println("connection closed !");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return status;
	}
	
	public static void getAllRecord()
	{
		Connection con=null;
		try {
			
			// get connection object 
			con=Utility.getMySqlConnection();
			Statement st=con.createStatement();
			
			//step 3:-write the query
			String q5="select * from Employee";
			System.err.println(q5);
			//step 4:-execute the query
			ResultSet rs=st.executeQuery(q5);
			
//			System.out.println("size : "+rs.getFetchSize());
//			System.out.println(rs.wasNull());
			System.out.println("--------------------------------------------------------------------");
			System.out.println("ID  | NAME   | EMAIL		|  AGE	| SALLARY ");
			System.out.println("---------------------------------------------------------------------");
			
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" | \t"+rs.getString(2)+" | \t"+rs.getString(3)+"| \t"+rs.getInt(4)+" | \t"+rs.getDouble(5)+"\t |");
			}
			System.out.println("-----------------------------------------------------------------------\n");
//			if(rs.getFetchSize() == 0){
//				System.out.println("No Records ..");
//			}
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}finally{
			try {
				//step 5:close the resource
				con.close();
				System.out.println("connection closed !");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}
