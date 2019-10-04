package com.vforum.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.vforum.dao.EmployeesDAO;
import com.vforum.entities.Employees;
import com.vforum.entities.Posts;
import com.vforum.helper.FactoryEmployeeDB;
import com.vforum.model.LoginModel;
import com.vforum.model.PostModel;
import com.vforum.model.PostQuestionModel;
import com.vforum.model.RegisterEmployeeModel;

public class EmployeesServiceImpl implements EmployeesService{
	private EmployeesDAO employeesDAO;
	
	public EmployeesServiceImpl() {
		this.employeesDAO=FactoryEmployeeDB.createEmployeesDAO();
		
	}
	@Override
	public String registerEmployee(RegisterEmployeeModel model) {
		// TODO Auto-generated method stub
		
		Employees employees=new Employees();
		employees.setEmployeeUid(model.getEmployeeUid());
		employees.setFirstName(model.getFirstName());
		employees.setLastName(model.getLastName());
		employees.setEmail(model.getEmail());
		employees.setPhoneNumber(model.getPhoneNumber());
		employees.setDesignation(model.getDesignation());
		employees.setPassword(model.getPassword());
		employees.setEmployeeId(model.getEmployeeId());
		
		String result="fail";
		try {
			boolean stored=employeesDAO.storeEmployeeDetails(employees);
			if(stored)
				result="success";
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("!ERROR[Registration failed because of internal issues...]");
		}
		return result;
	}
	@Override
	public List<PostModel> retrievePosts() {
		// TODO Auto-generated method stub
		
		List<PostModel> postModelList=new ArrayList<>();
		try {
			List<Posts> postsList=employeesDAO.getAllQuestions();
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