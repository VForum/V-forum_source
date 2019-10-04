package com.vforum.helper;

import com.vforum.dao.EmployeesDAO;
import com.vforum.dao.EmployeesDAOImpl;
import com.vforum.dao.LoginDAO;
import com.vforum.dao.LoginDAOImpl;
import com.vforum.dao.PostAnswerDAO;
import com.vforum.dao.PostAnswerDAOImpl;
import com.vforum.dao.PostQuestionDAO;
import com.vforum.dao.PostQuestionDAOImpl;
import com.vforum.service.EmployeesService;
import com.vforum.service.EmployeesServiceImpl;
import com.vforum.service.LoginService;
import com.vforum.service.LoginServiceImpl;
import com.vforum.service.PostAnswerService;
import com.vforum.service.PostAnswerServiceImpl;
import com.vforum.service.PostQuestionService;
import com.vforum.service.PostQuestionServiceImpl;

public class FactoryEmployeeDB {

	public static EmployeesDAO createEmployeesDAO(){
		EmployeesDAO employeesDAO=new EmployeesDAOImpl();
		return employeesDAO;
		
	}
	public static EmployeesService createEmployeesService(){
		EmployeesService employeesService=
				new EmployeesServiceImpl();
		return employeesService;
	}
	public static PostQuestionDAO createQuestionDAO(){
		PostQuestionDAO questionDAO=new PostQuestionDAOImpl();
		return questionDAO;
		
	}
	public static PostQuestionService createQuestionService(){
		PostQuestionService questionService=
				new PostQuestionServiceImpl();
		return questionService;
	}
	
	public static PostAnswerDAO createAnswerDAO(){
		PostAnswerDAO answerDAO=new PostAnswerDAOImpl();
		return answerDAO;
		
	}
	public static PostAnswerService createAnswerService(){
		PostAnswerService answerService=
				new PostAnswerServiceImpl();
		return answerService;
	}
	
	public static LoginDAO createLoginDAO(){
		LoginDAO loginDAO=new LoginDAOImpl();
		return loginDAO;
		
	}
	
	public static LoginService createLoginService(){
		LoginService loginService=
				new LoginServiceImpl();
		return loginService;
	}
	public static EmployeesDAO postQuestionDAO(){
		EmployeesDAO employeesDAO=new EmployeesDAOImpl();
		return employeesDAO;
		
	}
	public static EmployeesService postQuestionService(){
		EmployeesService employeesService=
				new EmployeesServiceImpl();
		return employeesService;
	}
	
}
