package com.vforum.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.vforum.entities.Employees;
import com.vforum.integrate.ConnectionManager;

public class AdminDAOImpl implements AdminDAO{

	@Override
	public List<Employees> getEmployeeDetails() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection connection=ConnectionManager.openConnection();
		Statement statement=connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from employees_info");
		
		List<Employees> employeesList=new ArrayList<Employees>();
		while(resultSet.next()) {
			Employees employees=new Employees();
			employees.setEmployeeUid(resultSet.getString("employee_uname"));
			employees.setFirstName(resultSet.getString("first_name"));
			employees.setLastName(resultSet.getString("last_name"));
			employees.setEmail(resultSet.getString("email"));
			employees.setPhoneNumber(resultSet.getString("phone_number"));
			employees.setDesignation(resultSet.getString("designation"));
			employees.setDob(resultSet.getString("dob"));
			employeesList.add(employees);
		}
		ConnectionManager.closeConnection();
		return employeesList;

	}
}

	

