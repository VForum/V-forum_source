package com.vforum.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vforum.dao.AdminDAO;
import com.vforum.entities.Employees;
import com.vforum.helper.FactoryAdminDB;
import com.vforum.model.EmployeeModel;
import com.vforum.model.RegisterEmployeeModel;

public class AdminServiceImpl implements AdminService {
private AdminDAO adminDAO;
	
	public AdminServiceImpl() {
		this.adminDAO=FactoryAdminDB.createAdminDAO();
		
	}

	@Override
	public List<EmployeeModel> retrieveEmployees() {
		// TODO Auto-generated method stub
		List<EmployeeModel> employeesModelList=new ArrayList<>();
		
			List<Employees> employeesList;
			try {
				employeesList = adminDAO.getEmployeeDetails();
			
			for(Employees employees:employeesList)
			{
				EmployeeModel employeesModel=new EmployeeModel();
				employeesModel.setEmployeeUid(employees.getEmployeeUid());
				employeesModel.setFirstName(employees.getFirstName());
				employeesModel.setLastName(employees.getLastName());
				employeesModel.setEmail(employees.getEmail());
				employeesModel.setPhoneNumber(employees.getPhoneNumber());
				employeesModel.setDesignation(employees.getDesignation());
				employeesModel.setDob(employees.getDob());
				employeesModelList.add(employeesModel);
			}
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		return employeesModelList;
	}
}
