package com.dz.app.statement;

import java.util.Scanner;


public class Test {

	public static void main(String[] args) {
		
		System.out.println("\n*********************************\n");
		System.out.println("\n select your choice \n");
		Scanner sc =new Scanner(System.in);
		String status;
		
		do
		{

			System.out.println("1.create");
			System.out.println("2.insert");
			System.out.println("3.update [required ID * ]");
			System.out.println("4.delete [required ID * ]");
			System.out.println("5.view all record \n");
			
			int num =sc.nextInt();
		
		switch (num)
		{
			case 1:	
					boolean s=DaoImpl.create();
					if(!s)
					{
						System.out.println("table created successfully..");
					}
					break;
			case 2:
					DaoImpl.insert();
					break;
			case 3:
					DaoImpl.update();
					break;
		
			case 4:
					DaoImpl.delete();
					break;
					
			case 5:
					DaoImpl.getAllRecord();
					break;
			default:
					System.out.println("INVALID Choice");
					break;
		}
			
		System.out.println("Do u want to continue other operation (yes[y] / no[n] ) ? : ");
		status=sc.next();	
		
		
		}while(status.equalsIgnoreCase("yes") || status.equalsIgnoreCase("y"));
	}
}
