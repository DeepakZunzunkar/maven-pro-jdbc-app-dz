package com.dz.app.model;


public class Employee 
{
	private int id;
	private String name;
	private String email;
	private int age;
	private double salary;
	
	public Employee() {
	}

	public Employee(int id, String name, String email, int age, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.age = age;
		this.salary = salary;
	}
	public Employee(String name, String email, int age, double salary) {
		
		this.name = name;
		this.email = email;
		this.age = age;
		this.salary = salary;
	}

	//getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", age=" + age + ", salary=" + salary
				+ "]";
	}
	
}

