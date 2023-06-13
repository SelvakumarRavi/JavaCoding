package com.dal.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.dal.model.Employee;

public class EmployeeController implements EmployeeInterface,Serializable {
	
	Scanner sc = new Scanner(System.in);
	List<Employee> emplist = new ArrayList(); 
	public void addEmployee() {
		Employee emp = new Employee();
		System.out.println("Enter ENo:");
		int eno = sc.nextInt();
		emp.setEmpno(eno);
		System.out.println("Enter EName:");
		String ename = sc.next();
		emp.setEname(ename);
		emplist.add(emp);
		System.out.println("Employee created");
	}
	
	public List<Employee> getEmplist() {
		return emplist;
	}


	public void viewEmployee() {
//		System.out.println(emp.getEmpno());
//		System.out.println(emp.getEname());
		System.out.println(emplist);
		
	}
	public void serializee(List<Employee> emp) throws IOException
	{
		try{
		
		FileOutputStream fos = new FileOutputStream("dedalus.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
//		Employee emp = emplist.get(0); 
		oos.writeObject(emp);
		System.out.println("Serilized to file dedalus.txt");
		oos.close();
		fos.close();
		}
		catch(FileNotFoundException fnf)
		{
			System.out.println("No file");
		}
	}

	public void deserializee(String filename) throws IOException
	{
		try{
		
	
		FileInputStream fis = new FileInputStream(filename);
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		List<Employee> emp = (List<Employee>)ois.readObject();
		System.out.println("DeSerilized from file "+filename);
		System.out.println(emp);
//		System.out.println(emp.getEmpno());
//		System.out.println(emp.getEname());
		ois.close();
		fis.close();
		}
		catch(FileNotFoundException fnf)
		{
			System.out.println("No file");
		}
		catch(ClassNotFoundException cnf)
		{
			System.out.println("No Emp class");
		}

	}
	
}
