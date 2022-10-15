package com.dz.app.addBatch;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.dz.app.model.Employee;


public class Test {

	public static void main(String[] args) 
	{
		System.out.println("*********************************\n");
		Scanner sc =new Scanner(System.in);
		
		System.out.println("How many Record Do Want Add ?");
		System.out.println("Enter Number of Record :\n");
		int n = sc.nextInt();
		
		List<Employee> elist=new ArrayList<Employee>();
		
		int k=1;
		for (int i = 0; i < n; i++) 
		{
			// System.out.println("Enter Employee ID :");
			// int id=sc.nextInt();
			System.err.println(k+". Record \n");
			Employee e=new Employee();
			
			System.out.println("Enter Employee Name :");
			e.setName(sc.next());
			
			System.out.println("Enter Email :");
			e.setEmail(sc.next());
			
			System.out.println("Enter Age :");
			e.setAge(sc.nextInt());
			
			System.out.println("Enter Salary:");
			e.setSalary(sc.nextDouble());
			
			elist.add(e);
			k++;
		}

		int[] i=DaoImpl.insert(elist);
		if (i[0] > 0) {
			System.out.println("succesfully added..");
		} else {
			System.out.println("fail to add.");
		}
		

	}
}
