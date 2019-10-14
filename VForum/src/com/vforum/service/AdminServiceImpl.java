package com.vforum.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vforum.dao.AdminDAO;
import com.vforum.entities.Employees;
import com.vforum.entities.Posts;
import com.vforum.helper.FactoryAdminDB;
import com.vforum.model.EmployeeModel;
import com.vforum.model.PostModel;


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
	@Override
	public List<PostModel> retrievePosts() {
		// TODO Auto-generated method stub
		
		List<PostModel> postModelList=new ArrayList<>();
		try {
			List<Posts> postsList=adminDAO.getAllQuestions();
			for(Posts posts:postsList) {
				
				PostModel postModel=new PostModel();
				postModel.setPostId(posts.getPostId());
				postModel.setUserId(posts.getUserId());
				postModel.setPost(posts.getPost());
				postModel.setCategory(posts.getCategory());
				postModelList.add(postModel);
				
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return postModelList;
	}
}
