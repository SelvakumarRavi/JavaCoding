package com.dal.view;

import java.io.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.function.BiPredicate;
import java.io.Serializable;

import com.dal.controller.EmployeeController;
import com.dal.controller.EmployeeInterface;

import com.exp.UserNotFoundException;

public class MainClass implements Serializable {

	public static void main(String[] args) {
		System.out.println("Welcome to EMS :)");
		EmployeeController ec = new EmployeeController();
		Scanner sc = new Scanner(System.in);
		String ch = null;
		try {
			String un = null;
			String pwd = null;

			BiPredicate<String, String> validateUsernamePassword = (username, password) -> username.equals("Abi")
					&& password.equals("pass");

			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			System.out.println("Enter Username");
			un = br.readLine();
			System.out.println("Enter Password");
			pwd = br.readLine();

			if (validateUsernamePassword.test(un, pwd)) {
				System.out.println("Welcome " + un);
				// Rest of the code remains unchanged
			} else {
				throw new UserNotFoundException();
			}

			do {
				System.out.println("Enter your choice");
				System.out.println("1. Add Employee");
				System.out.println("2. View Employee");
				System.out.println("3. Serialize");
				System.out.println("4. Deserialize");
				System.out.println("5.Insert into DB");
				System.out.println("6.Update Employee");
				System.out.println("7.Delete Employee");
				int choice = sc.nextInt();
				switch (choice) {
				case 1: {
					try {
						System.out.println("Loading... Please wait.");
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					ec.addEmployee();
					break;
				}

				case 2: {
					System.out.println("Loading... Please wait.");
					Thread.sleep(2000);
					ec.viewEmployee();
					break;
				}

				case 3: {
					// Serialization
					try {
						FileOutputStream fileOut = new FileOutputStream("mainObject.ser");
						ObjectOutputStream out = new ObjectOutputStream(fileOut);
						out.writeObject(ec); // Serialize the EmployeeController object
						out.close();
						fileOut.close();
						System.out.println("Serialized data is saved in mainObject.ser");
					} catch (IOException e) {
						e.printStackTrace();
					}

					break;
				}

				case 4: {
					// Deserialization
					try {
						FileInputStream fileIn = new FileInputStream("mainObject.ser");
						ObjectInputStream in = new ObjectInputStream(fileIn);
						EmployeeController deserializedEc = (EmployeeController) in.readObject(); // Deserialize the
																									// EmployeeController
																									// object
						in.close();
						fileIn.close();
						// Use the deserialized object as needed
						System.out.println("Loading... Please wait.");
						Thread.sleep(2000);
						deserializedEc.viewEmployee();
					} catch (IOException e) {
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
					}
					break;
				}

				case 5: {

					ec.insertEmployee();
					ec.showEmployee();
					break;
				}

				case 6: {
					ec.updateEmployee();
					ec.showEmployee();

					break;
				}

				case 7: {
					ec.deleteEmployee();
					ec.showEmployee();
					break;
				}

				default: {
					System.out.println("Enter a valid number");
					break;
				}
				}

				System.out.println("Do u want to continue Y | y");
				ch = sc.next();

			} while (ch.equals("Y") || ch.equals("y"));
			System.out.println("Thanks for using our system.");
			System.exit(0);
		} catch (UserNotFoundException unf) {
			unf.printStackTrace();
		} catch (Exception ae) {
			System.out.println("IO");
		} finally {
			System.out.println("Finally .....");
		}
	}
}
