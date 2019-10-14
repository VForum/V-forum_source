package com.vforum.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

import com.vforum.controller.AdminController;
import com.vforum.controller.EmployeeController;
import com.vforum.model.LoginModel;
import com.vforum.model.PostModel;
import com.vforum.model.RegisterEmployeeModel;
import com.vforum.model.EmployeeModel;

public class AdminView {

public void mainAdminView(LoginModel loginModel) {
	AdminController adminController=new AdminController();
	MainView mainView=new MainView();
	try(
			Scanner scanner=new Scanner(System.in);
	){
		System.out.println("=======Admin View======");
		System.out.println("1.view employees ");
		System.out.println("2.view questions ");
		System.out.println("3.logout");
		System.out.print("Enter choice:");
		int option=scanner.nextInt();
		switch(option) {
		case 1:adminController.viewEmployees(loginModel);
				break;
		case 2:adminController.viewQuestions(loginModel);
				break;
		case 3:mainView.mainMenu();
		break;
	}
	}
	catch(Exception e) {
	e.printStackTrace();
	}
}
		public void showQuestionDeleteSuccess(LoginModel loginModel,int postId) {
			System.out.println("\n deleted successfully ");
			mainAdminView(loginModel);
			}
	public void showEmployees(List<EmployeeModel> model,LoginModel loginModel){
		System.out.println("=====================================================================================================================");
		System.out.format("%10s%15s%15s%15s%20s%20s%20s\n","UserName","FirstName","LastName","Email","PhoneNumber","Desgination","DOB");
		System.out.println("=====================================================================================================================");
		for(EmployeeModel models:model) {
		System.out.format("%5s%12s%15s%15s%15s%15s%15s\n",models.getEmployeeUid(),models.getFirstName(),models.getLastName(),models.getEmail(),models.getPhoneNumber(),models.getDesignation(),models.getDob());
		System.out.println("\n");
	}
		mainAdminView(loginModel);
	
}
	public void showQuestions(List<PostModel> model,LoginModel loginModel){
		System.out.println("=====================================================================================================================");
		System.out.format("%10s%15s%25s%40s\n","UserName","PostId","Question","Category");
		System.out.println("=====================================================================================================================");
		for(PostModel models:model) {
			System.out.format("%9s%12d%30s%40s\n",models.getUserId(),models.getPostId(),models.getPost(),models.getCategory());;
			System.out.println("\n");
		}
		deleteQuestionMenu(loginModel);
	}
	public void deleteQuestionMenu(LoginModel loginModel) {
		
		try(
				Scanner scanner=new Scanner(System.in);
		){
			
			System.out.println("1.delete post ");
			System.out.println("2.back to menu ");
			System.out.print("Enter choice:");
			int option=scanner.nextInt();
			switch(option) {
			case 1:deleteQuestion(loginModel);
					break;
			case 2:mainAdminView(loginModel);
					break;
			default:System.out.println("!ERROR[SELECT APPROPRIATE OPTION] deleteQuestionMenu");
					deleteQuestionMenu(loginModel);
					break;
		}
		}
		catch(Exception e) {
		e.printStackTrace();
		}
	}
	public void deleteQuestion(LoginModel loginModel) {
		try(InputStreamReader reader=
				new InputStreamReader(System.in);
				BufferedReader buffer=new BufferedReader(reader);)
			{
				System.out.print("Enter Post ID:");
				int postId=Integer.parseInt(buffer.readLine()); 
				AdminController adminController=new AdminController();
				adminController.deleteQuestion(loginModel,postId);
			}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
