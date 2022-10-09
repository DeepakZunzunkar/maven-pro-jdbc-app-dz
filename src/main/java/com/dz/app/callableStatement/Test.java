package com.dz.app.callableStatement;

import java.util.ArrayList;
import java.util.Scanner;

import com.dz.app.model.Employee;
import com.dz.app.callableStatement.DaoImpl;

public class Test {

	public static void main(String[] args) 
	{
		System.out.println("\n*********************************\n");
		System.out.println("\n select your choice \n");
		Scanner sc =new Scanner(System.in);
		String status;
		String choice="";
		
		do
		{
			System.out.println("1.insert");
			System.out.println("2.update [required ID * ]");
			System.out.println("3.delete [required ID * ]");
			System.out.println("4.view all record ");
			System.out.println("5.Search \n");
			
		int num=sc.nextInt();
		
		
		switch (num)
		{
			case 1:	
					//Scanner sc=new Scanner(System.in);
					choice="yes";
					while(choice.equalsIgnoreCase("yes") || choice.equalsIgnoreCase("y"))
					{
						System.out.println("enter employee name :");
						String name=sc.next();
						System.out.println("enter employee email :");
						String email=sc.next();
						System.out.println("enter employee age :");
						int age=sc.nextInt();
						System.out.println("enter employee salary :");
						double sal=sc.nextDouble();
						
						Employee e=new Employee(name, email, age, sal);
						int i=DaoImpl.insert(e);
						if(i>0)
						{
							System.out.println("record inserted successfully..");
						}else{
							System.out.println("fail to insert...");
						}
						
						System.out.println("do u want to insert another row (yes/no) ? : ");
						choice=sc.next();
					}
					
					break;
			case 2:
					System.out.println("to update any record you should know EmployeeID first ");
					choice="yes";
					while(choice.equalsIgnoreCase("yes") || choice.equalsIgnoreCase("y"))
					{
						System.out.println("enter id of updated record :\n");
						int id =sc.nextInt();
						
						if(DaoImpl.search(id) != null){
							
							System.out.println("enter name:");
							String name=sc.next();
							
							System.out.println("enter email:");
							String email=sc.next();
							
							System.out.println("enter age:");
							int age =sc.nextInt();
							
							System.out.println("enter salary :");
							double sal=sc.nextDouble();
							
							Employee e=new Employee(id,name,email,age,sal);
							
							int i=DaoImpl.update(e);
							if(i>0)
							{
								System.out.println("record updated succesfully..");
							}else{
								System.out.println("fail to update..");
							}
						}else {
							System.err.println(" no record found !");
						}
						System.out.println("do u want to update one more row (yes/no) ? : ");
						choice=sc.next();
					}
					break;
			case 3:
					System.out.println("to delete the record you should know employeeID first ");
					System.out.println("enter ID  :");
					int id =sc.nextInt();
					
					if(DaoImpl.search(id) != null){

						int i=DaoImpl.delete(id);
						if(i>0)
						{
							System.out.println("record deleted successfully..");
						}else{
							System.out.println("fail to delete");
						}
						
					}else {
						System.err.println(" no record found !");
					}
					break;
		
			case 4:
						ArrayList<Employee> list=new ArrayList<Employee>();
						
						list=(ArrayList<Employee>) DaoImpl.getAllRecord();
						System.out.println("--------------------------------------------------------------------");
						System.out.println("ID  | NAME   | EMAIL		|  AGE	| SALLARY ");
						System.out.println("---------------------------------------------------------------------");
						for(Employee  e: list)
						{ 
							System.out.println(e.getId()+" \t |"+e.getName()+" \t |"+e.getEmail()+"  \t |"+e.getAge()+"  \t |"+e.getSalary()+" |");
						}
						System.out.println("-----------------------------------------------------------------------\n");
				
					break;
					
			case 5 :
					System.out.println("Enter ID : ");
					int search=sc.nextInt();
				
					
					Employee e=DaoImpl.search(search);
					if(e!=null)
					{
						System.out.println("--------------------------------------------------------------------");
						System.out.println("ID  | NAME   | EMAIL		|  AGE	| SALLARY ");
						System.out.println("---------------------------------------------------------------------");
						System.out.println(e.getId()+" \t |"+e.getName()+" \t |"+e.getEmail()+"  \t |"+e.getAge()+"  \t |"+e.getSalary()+" |");
						System.out.println("-----------------------------------------------------------------------\n");
					}else{
						System.out.println("No Record Found");
					}
					
					break;
			default:
				
					System.out.println("INVALID CHOICE");
					break;
		}
			
			
		System.out.println("Do u want to continue other operation (yes/no) ? : ");
		status=sc.next();	
		
		
		}while(status.equalsIgnoreCase("yes") || status.equalsIgnoreCase("y"));
	
	}
}
