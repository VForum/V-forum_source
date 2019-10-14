package com.vforum.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Scanner;

import com.vforum.controller.EmployeeController;
import com.vforum.controller.FrontController;
import com.vforum.controller.PostQuestionController;
import com.vforum.exception.ValidationException;
import com.vforum.model.LoginModel;
import com.vforum.model.PostQuestionModel;
import com.vforum.model.RegisterEmployeeModel;
import com.vforum.validation.EmployeesModelValidator;

public class MainView {
	
	public void mainMenu() {
		System.out.println("\n");
		System.out.println("\t\t\t\t***********=========*========MAIN MENU========*=======**********\n\n");
		System.out.println("*****************************");
		System.out.println("*=>1. Admin                 *");
		System.out.println("*=>2. Employee              *");
		System.out.println("*****************************");
		try(Scanner scanner=new Scanner(System.in);){
			
			System.out.print("\nEnter Choice:");
			int option=scanner.nextInt();
			
			switch(option) {
			
			case 1:viewLoginMenu();
			       break;
			case 2:viewEmployeeMainMenu();
				   break;
			
			default:System.out.println("!ERROR[SELECT APPROPRIATE OPTION] mainMenu");
			        mainMenu();
				  
			}
			
		}catch(Exception e) {
			
			System.out.println("!ERROR[SELECT APPROPRIATE OPTION] mainMenu catch");
		}
		
	}
	public void viewLoginMenu() throws ClassNotFoundException, SQLException{

		try(
				InputStreamReader reader=
				new InputStreamReader(System.in);
					BufferedReader buffer=new BufferedReader(reader);
					
		     ){
				System.out.println("***************************");	
				System.out.print("Enter User ID:");
				String userId=buffer.readLine().trim();
				
				System.out.print("Enter Password:");
				String password=buffer.readLine().trim();
				System.out.println("***************************");
				
				FrontController controller=new FrontController();
				controller.userAuthentication(userId,password);
				
				
			}catch(IOException e) {
				e.printStackTrace();
			}
		
	}
public void viewEmployeeMainMenu() {
		
		try(
				Scanner scanner=new Scanner(System.in);
		){
			System.out.println("****************************");
			System.out.println("*=>1. Login                *");
			System.out.println("*=>2. Registration         *");
			System.out.println("*=>3. Main Menu            *");
			System.out.println("****************************");
			System.out.print("Enter choice:");
			int option=scanner.nextInt();
			
			switch(option) {
			
			case 1:viewLoginMenu();
			       break;
			case 2:registerEmployeeForm();
				   break;
			
			case 3:mainMenu();
			default:System.out.println("!ERROR[SELECT APPROPRIATE OPTION] viewEmployeeMenu");
	        viewEmployeeMainMenu();
				  
			}

			}catch(Exception e) {
			e.printStackTrace();
		}

	}
public void employeeMenu(LoginModel loginModel) {
	try(
			Scanner scanner=new Scanner(System.in);
	){
	System.out.println("========== EMPLOYEE VIEW ========\n");
	System.out.println("****************************");
	System.out.println("*1.view profile            *");
	System.out.println("*2.post question           *");
	System.out.println("*3.view questions          *");
	System.out.println("*4:logout                  *");
	System.out.println("****************************");
	System.out.print("Enter choice:");
	int option=scanner.nextInt();
	EmployeeController employeeController=new EmployeeController();
	switch(option){
	case 1:
			break;
	case 2:postQuestionForm(loginModel);
			break;
	case 3:employeeController.viewQuestions(loginModel);
			break;
	case 4:viewEmployeeMainMenu();
			break;
	default:System.out.println("!ERROR[SELECT APPROPRIATE OPTION] employeeMenu");
		employeeMenu(loginModel);
	}
	}
	catch(Exception e) {
		e.printStackTrace();
	}
}
public void postQuestionForm(LoginModel loginModel) {
	try(Scanner scanner=new Scanner(System.in);)
	{
		System.out.println("***************************");
		System.out.println("Enter question");
		String question=scanner.nextLine();
		System.out.println("Enter title");
		String title=scanner.next();
		System.out.println("***************************");
		PostQuestionModel postModel=new PostQuestionModel();
		postModel.setUserId(loginModel.getUserId());
		postModel.setPost(question);
		postModel.setTitle(title);
		PostQuestionController controller=new PostQuestionController();
		controller.postQuestion(postModel,loginModel);
	}catch(Exception e) {
		
	}
	
}
public void registerEmployeeForm() {
	
	try(Scanner scanner=new Scanner(System.in);){			
	System.out.println("***************************");
	System.out.println("##### REGISTRATION FORM ##### ");
	System.out.println("***************************");
	System.out.print("Username:");
	String employeeUid=scanner.next();
	EmployeesModelValidator validator=new EmployeesModelValidator();
		System.out.print("First Name:");
		String firstName=scanner.next();
		
		boolean validfirstName=validator.validString(firstName);
		if(!validfirstName)
			try {
			throw new ValidationException("[!ERROR:Invalid First Name]");
			}catch(ValidationException e) {
				System.out.println(e.getMessage());
				registerEmployeeForm();
			}
		
		
		System.out.print("Last Name:");
		String lastName=scanner.next();
		
		boolean validLastName=validator.validString(lastName);
		if(!validLastName)
			try {
			throw new ValidationException("[!ERROR:Invalid Last Name]");
			}catch(ValidationException e) {
				System.out.println(e.getMessage());
				registerEmployeeForm();
			}
		
		
		System.out.print("Email:");
		String email=scanner.next();
		
		boolean validemail=validator.validEmail(email);
		if(!validemail)
			try {
			throw new ValidationException("!ERROR:Invalid Email");
			}catch(ValidationException e) {
				System.out.println(e.getMessage());
				registerEmployeeForm();
			}
		System.out.print("PhoneNumber:");
		String phoneNumber=scanner.next();
		boolean validNumber=validator.validNumber(phoneNumber);
		if(!validNumber)
			try {
			throw new ValidationException("!ERROR:Invalid PhoneNumber");
			}catch(ValidationException e) {
				System.out.println(e.getMessage());
				registerEmployeeForm();
			}
		
		System.out.print("Designation :");
		String designation=scanner.next();
		System.out.print("Date of Birth(dd/mm/yyyy):");
		String dob=scanner.next();
		boolean validDOB=validator.validDOB(dob);
		if(!validDOB)
			try {
			throw new ValidationException("!ERROR:Invalid DOB");
			}catch(ValidationException e) {
				System.out.println(e.getMessage());
				registerEmployeeForm();
			}
		System.out.print("Password :");
		String password=scanner.next();
		boolean validPassword=validator.validPassword(password);
		if(!validPassword)
			try {
			throw new ValidationException("!ERROR:Password must bt atleast 8 characters long");
			}catch(ValidationException e) {
				System.out.println(e.getMessage());
				registerEmployeeForm();
			}
		RegisterEmployeeModel model=new RegisterEmployeeModel();
		model.setEmployeeUid(employeeUid);
		model.setFirstName(firstName);
		model.setLastName(lastName);
		model.setEmail(email);
		model.setPhoneNumber(phoneNumber);
		model.setDesignation(designation);
		model.setDob(dob);
		model.setPassword(password);
		
		EmployeeController controller=new EmployeeController();
		controller.handleRegisterEmployee(model);
		
	   viewEmployeeMainMenu();
	}catch(Exception e) {
		
	}	
}
	
}
