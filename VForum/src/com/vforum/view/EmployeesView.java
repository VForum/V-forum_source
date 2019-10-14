package com.vforum.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

import com.vforum.controller.PostAnswerController;
import com.vforum.model.EmployeeModel;
import com.vforum.model.LoginModel;
import com.vforum.model.PostAnswerModel;
import com.vforum.model.PostModel;
import com.vforum.model.PostQuestionModel;
import com.vforum.model.RegisterEmployeeModel;

public class EmployeesView {
	

	private MainView mainView=new MainView();

	public void showQuestions(List<PostModel> model,LoginModel loginModel){
		System.out.println("=====================================================================================================================");
		System.out.format("%10s%15s%25s%40s\n","UserName","PostId","Question","Category");
		System.out.println("=====================================================================================================================");
		for(PostModel models:model) {
			System.out.format("%9s%12d%30s%40s\n",models.getUserId(),models.getPostId(),models.getPost(),models.getCategory());;
			System.out.println("\n");
		}
		replyMenu(loginModel);
	}
	public void showProfile(List<EmployeeModel> model,LoginModel loginModel){
		System.out.println("=====================================================================================================================");
		System.out.format("%10s%15s%15s%15s%20s%20s%20s\n","UserName","FirstName","LastName","Email","PhoneNumber","Desgination","DOB");
		System.out.println("=====================================================================================================================");
		for(EmployeeModel models:model) {
		System.out.format("%5s,%12s,%15s,%15s,%15s,%15s%15s\n",models.getEmployeeUid(),models.getFirstName(),models.getLastName(),models.getEmail(),models.getPhoneNumber(),models.getDesignation(),models.getDob());
		System.out.println("\n");
	}
		mainView.employeeMenu(loginModel);
		}
		
	
	public void replyMenu(LoginModel loginModel) {
		System.out.println("***************************");
		System.out.println("*=>1. Reply to Question   *");
		System.out.println("*=>2. Report Question     *");
		System.out.println("*=>3. Back to Menu        *");
		System.out.println("***************************");
		try(Scanner scanner=new Scanner(System.in);){
			
			System.out.print("\nEnter Choice:");
			int option=scanner.nextInt();
			
			switch(option) {
			
			case 1:postAnswerMenu(loginModel);
			       break;
			case 2:
				   break;
			case 3:mainView.employeeMenu(loginModel);
				   break;
			
			default:System.out.println("!ERROR[SELECT APPROPRIATE OPTION] replyMenu ");
			        replyMenu(loginModel);
			}
			
		}catch(Exception e) {
			
			System.out.println("!ERROR[SELECT APPROPRIATE OPTION] replyMenu catch");
		}
	}
	public void postAnswerMenu(LoginModel loginModel) {
		
		try(InputStreamReader reader=
				new InputStreamReader(System.in);
				BufferedReader buffer=new BufferedReader(reader);)
		{
				System.out.print("Enter Post ID:");
				int postId=Integer.parseInt(buffer.readLine());
				System.out.print("Enter your Answer");
				String answer=buffer.readLine();
				System.out.println(answer);
				PostAnswerModel answerModel=new PostAnswerModel();
				answerModel.setPostId(postId);
				answerModel.setAnswer(answer);
				PostAnswerController answerController=new PostAnswerController();
				answerController.postAnswer(answerModel,loginModel);
		}catch(Exception e) {
				e.printStackTrace();
			}
	}
	
	public void showRegistrationSuccess(RegisterEmployeeModel model) {
		System.out.println("\n Registration successful ");
		mainView.mainMenu();
	}
	
	public void showRegistrationFailure(RegisterEmployeeModel model) {
		System.out.println("\n Registration unsuccessful");
		mainView.mainMenu();
	}
	public void showPostSuccess(PostQuestionModel model,LoginModel loginModel) {
		System.out.println("\n Question posted successfully");
		mainView.employeeMenu(loginModel);
	}
	
	public void showPostFailure(PostQuestionModel model,LoginModel loginModel) {
		System.out.println("\n Question post unsuccessful");
		mainView.employeeMenu(loginModel);
	}
	public void showPostAnswerSuccess(PostAnswerModel model,LoginModel loginModel) {
		System.out.println("\n Answer posted successfully");
		mainView.employeeMenu(loginModel);
	}
	
	public void showPostAnswerFailure(PostAnswerModel model,LoginModel loginModel) {
		System.out.println("\n Posting of answer unsuccessful");
		mainView.employeeMenu(loginModel);
	}
	public void validationFailedError() {
		  System.out.println("Data validation failed!!");
	  }
	public void loginFailedError() {
		  System.out.println("login failed!!");
	  }
	public void showLoginFailure()
	{
		System.out.println("========!! Login failed -invalid credentials !!");
	}
}
