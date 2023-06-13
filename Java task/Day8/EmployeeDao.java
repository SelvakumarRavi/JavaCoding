package com.dal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.dal.model.Employee;
import com.dal.util.MyDbConnection;

public class EmployeeDao {
	
	Connection con;
	Statement stmt;
	PreparedStatement ps;
	ResultSet rs;
	
	public void insertEmployee(Employee emp) {
		
		con =MyDbConnection.getMyConnection();
		try {
			ps =con.prepareStatement("insert into DEDEMP values(?,?)");
			ps.setInt(1, emp.getEmpno());
			ps.setString(2, emp.getEname());
			int noofrows =ps.executeUpdate();
			System.out.println(noofrows + " got inserted into DB successfully!");
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
	}
	
	public void showEmployee() {
		con =MyDbConnection.getMyConnection();
		try {
			stmt =con.createStatement();
			rs =stmt.executeQuery("select * from dedemp");
			while(rs.next()) {
				System.out.println(rs.getInt(1) + " -- " + rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void UpdateEmployee(int eno,String ename) {
		con =MyDbConnection.getMyConnection();
		try {
			stmt =con.createStatement();
			stmt.executeUpdate("UPDATE dedemp SET ename = '"+ename+"' WHERE empno = "+eno);
			System.out.println(eno + "employee got updated in DB successfully!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void DeleteEmployee(int eno) {
		con =MyDbConnection.getMyConnection();
		try {
			stmt =con.createStatement();
			stmt.executeUpdate("delete from dedemp where empno="+eno);
			System.out.println(eno + "employee Deleted from DB successfully!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
}
