package com.dal.model;

import java.io.Serializable;
import java.util.Comparator;



public class Employee implements Comparable<Employee>,Serializable{
	private int empno;
	private String ename;
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String toString() {
		return "Employee [empno=" + empno + ", ename=" + ename + "]";
	}
	
	//Anonyomous class
	public static Comparator<Employee> nameComparator = new Comparator<Employee>() {

		@Override
		public int compare(Employee s1, Employee s2) {
			
			return (s1.getEname().compareTo(s2.getEname()));
		}
		
		
	};

	@Override
	public int compareTo(Employee o) {
		// TODO Auto-generated method stub
		return this.empno - o.empno;
	}
	
	
}
