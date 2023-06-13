package com.dal.view;

import java.util.Scanner;
import java.util.function.BiPredicate;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.dal.controller.EmployeeController;
//import com.dal.model.Employee;
import com.dal.controller.EmployeeInterface;
import com.dal.exception.UserNotFoundException;

public class MainClass {

	public static void main(String[] args) {
		System.out.println("Welcome to EMS :)");
		EmployeeInterface ec = new EmployeeController();
		System.out.println("Please Login:");
		Scanner sc = new Scanner(System.in);
		String ch=null;
	
		try {
			String un = null;
			String pwd = null;

			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			System.out.println("Enter Username");
			un = br.readLine();
			System.out.println("Enter Password");
			pwd = br.readLine();
			System.out.println("Please wait...");
			Thread.sleep(2000);
			BiPredicate<String, String> res = (u, p) -> u.equals(p);
			if (res.test(pwd, un)) {
				System.out.println("Welcome " + un);
				do {
					
					System.out.println("Enter your choice");
					System.out.println("1. Add Employee");
					System.out.println("2. View Employee");
					System.out.println("3. Serialize Employee");
					System.out.println("4. Deserialize Employee");
					System.out.println("5. Update Employee");
					System.out.println("6. Delete Employee");
					System.out.println("7. Sort Employees");
					int choice = sc.nextInt();
					switch (choice) {
					case 1: {
						ec.addEmployee();
						break;
					}

					case 2: {
						ec.viewEmployee();
						break;
					}
					case 3: {
						ec.serializee(ec.getEmplist());
						break;
					}
					case 4: {
						ec.deserializee("dedalus.txt");
						break;
					}
					
					case 5: {
						System.out.println("Enter the employee number to update: ");
						int eno = sc.nextInt();
						ec.updateEmployee(eno);
						break;
					}
					case 6: {
						System.out.println("Enter the employee number to Delete: ");
						int eno = sc.nextInt();
						ec.deleteEmployee(eno);
						break;
					}
					case 7:{
						System.out.println("Sort by name(1) or sort by Empno(2)?");
						int op = sc.nextInt();
						ec.sortEmployee(op);
						ec.viewEmployee();
						break;
					}
					default: {
						System.out.println("Enter a valid number");
						break;
					}
					}
					
					System.out.println("Do u want to continue Y | y");
					ch=sc.next();
					
					}while(ch.equals("Y") || ch.equals("y"));
				
			} else {
				throw new UserNotFoundException();
			}

		}

		catch (UserNotFoundException unf) {
			//System.out.println("From catch unf");
			//System.out.println(unf);
			System.out.println("Enter valid credentials");
			unf.printStackTrace();
		}
		catch(InterruptedException ipr) {
			ipr.printStackTrace();
		}
		catch (Exception ae) {
			System.out.println("IO");
		} finally {
			System.out.println("Finally .....");
		}
		
		
//		System.out.println("Thanks for using our system.");
		System.exit(0);
	}
		
}
