package com.vforum.helper;

import org.apache.log4j.Logger;

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
	
	static Logger logger=Logger.getLogger(FactoryEmployeeDB.class.getName());
	
	public static EmployeesDAO createEmployeesDAO(){
		logger.info("---- In FactoryEmployeeDB createEmployeesDAO method called---- ");
		EmployeesDAO employeesDAO=new EmployeesDAOImpl();
		logger.info("---- In FactoryEmployeeDB createEmployeesDAO method completed---- ");
		return employeesDAO;
		
	}
	public static EmployeesService createEmployeesService(){
		logger.info("---- In FactoryEmployeeDB createEmployeesService method called---- ");
		EmployeesService employeesService=new EmployeesServiceImpl();
		logger.info("---- In FactoryEmployeeDB createEmployeesService method completed---- ");
		return employeesService;
	}
	public static PostQuestionDAO createQuestionDAO(){
		logger.info("---- In FactoryEmployeeDB createQuestionDAO method called---- ");
		PostQuestionDAO questionDAO=new PostQuestionDAOImpl();
		logger.info("---- In FactoryEmployeeDB createQuestionDAO method completed---- ");
		return questionDAO;
		
	}
	public static PostQuestionService createQuestionService(){
		logger.info("---- In FactoryEmployeeDB createQuestionService method called---- ");
		PostQuestionService questionService=new PostQuestionServiceImpl();
		logger.info("---- In FactoryEmployeeDB createQuestionService method completed---- ");
		return questionService;
	}
	
	public static PostAnswerDAO createAnswerDAO(){
		logger.info("---- In FactoryEmployeeDB createAnswerDAO method called---- ");
		PostAnswerDAO answerDAO=new PostAnswerDAOImpl();
		logger.info("---- In FactoryEmployeeDB createAnswerDAO method completed---- ");
		return answerDAO;
		
	}
	public static PostAnswerService createAnswerService(){
		logger.info("---- In FactoryEmployeeDB createAnswerService method called---- ");
		PostAnswerService answerService= new PostAnswerServiceImpl();
		logger.info("---- In FactoryEmployeeDB createAnswerService method completed---- ");
		return answerService;
	}
	
	public static LoginDAO createLoginDAO(){
		logger.info("---- In FactoryEmployeeDB createLoginDAO method called---- ");
		LoginDAO loginDAO=new LoginDAOImpl();
		logger.info("---- In FactoryEmployeeDB createLoginDAO method completed---- ");
		return loginDAO;
		
	}
	
	public static LoginService createLoginService(){
		logger.info("---- In FactoryEmployeeDB createLoginService method called---- ");
		LoginService loginService=new LoginServiceImpl();
		logger.info("---- In FactoryEmployeeDB createLoginService method completed---- ");
		return loginService;
	}
	public static EmployeesDAO postQuestionDAO(){
		logger.info("---- In FactoryEmployeeDB postQuestionDAO method called---- ");
		EmployeesDAO employeesDAO=new EmployeesDAOImpl();
		logger.info("---- In FactoryEmployeeDB postQuestionDAO method completed---- ");
		return employeesDAO;
		
	}
	public static EmployeesService postQuestionService(){
		logger.info("---- In FactoryEmployeeDB postQuestionService method called---- ");
		EmployeesService employeesService=new EmployeesServiceImpl();
		logger.info("---- In FactoryEmployeeDB postQuestionService method completed---- ");
		return employeesService;
	}
	
}
