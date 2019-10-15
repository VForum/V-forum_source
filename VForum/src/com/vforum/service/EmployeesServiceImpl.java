package com.vforum.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.vforum.dao.EmployeesDAO;
import com.vforum.entities.Answers;
import com.vforum.entities.Employees;
import com.vforum.entities.Posts;
import com.vforum.helper.FactoryEmployeeDB;
import com.vforum.model.AnswerModel;
import com.vforum.model.EmployeeModel;
import com.vforum.model.LoginModel;
import com.vforum.model.PostModel;
import com.vforum.model.RegisterEmployeeModel;

public class EmployeesServiceImpl implements EmployeesService{
	private EmployeesDAO employeesDAO;
	Logger logger=Logger.getLogger(EmployeesServiceImpl.class.getName());
	public EmployeesServiceImpl() {
		this.employeesDAO=FactoryEmployeeDB.createEmployeesDAO();
		
	}
	@Override
	public String registerEmployee(RegisterEmployeeModel model) {
		// TODO Auto-generated method stub
		logger.info("---- In EmployeesServiceImpl registerEmployee method started ---- ");
		Employees employees=new Employees();
		employees.setEmployeeUid(model.getEmployeeUid());
		employees.setFirstName(model.getFirstName());
		employees.setLastName(model.getLastName());
		employees.setEmail(model.getEmail());
		employees.setPhoneNumber(model.getPhoneNumber());
		employees.setDesignation(model.getDesignation());
		employees.setPassword(model.getPassword());
		employees.setDob(model.getDob());
		
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
		logger.info("---- In EmployeesServiceImpl registerEmployee method completed ---- ");
		return result;
	}
	@Override
	public List<PostModel> retrievePosts() {
		// TODO Auto-generated method stub
		logger.info("---- In EmployeesServiceImpl retrievePosts method started ---- ");
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
			logger.info("---- The data of post model is added to the postModelList---- ");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("---- In EmployeesServiceImpl retrievePosts method completed ---- ");
		return postModelList;
	}
	@Override
	public List<EmployeeModel> getProfile(LoginModel loginModel) {
		// TODO Auto-generated method stub
		logger.info("---- In EmployeesServiceImpl getProfile method started ---- ");
		List<EmployeeModel> profileModelList=new ArrayList<>();
		try {
			List<Employees> profileList=employeesDAO.getProfile(loginModel);
			for(Employees employees:profileList) {
				
				EmployeeModel employeesModel=new EmployeeModel();
				employeesModel.setEmployeeUid(employees.getEmployeeUid());
				employeesModel.setFirstName(employees.getFirstName());
				employeesModel.setLastName(employees.getLastName());
				employeesModel.setEmail(employees.getEmail());
				employeesModel.setPhoneNumber(employees.getPhoneNumber());
				employeesModel.setDesignation(employees.getDesignation());
				employeesModel.setDob(employees.getDob());
				profileModelList.add(employeesModel);
				
			}
			logger.info("---- The data of employees model is added to the profileModelList---- ");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("---- In EmployeesServiceImpl getProfile method completed ---- ");
		return profileModelList;
	}
	@Override
	public List<AnswerModel> retrieveAnswers(LoginModel loginModel,int postId) {
		logger.info("---- In EmployeesServiceImpl retrieveAnswers method started ---- ");
		List<AnswerModel> answerModelList=new ArrayList<>();
		try {
			List<Answers> answersList=employeesDAO.getAllAnswers(loginModel,postId);
			for(Answers answers:answersList) {
				
				AnswerModel answerModel=new AnswerModel();
				answerModel.setAnswer(answers.getAnswer());
				answerModel.setUsername(answers.getEmpUserId());
				answerModelList.add(answerModel);
				
			}
			logger.info("---- The data of answer model is added to the answerModelList---- ");
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.info("---- In EmployeesServiceImpl retrieveAnswers method completed ---- ");
		return answerModelList;
	
	}
	}
