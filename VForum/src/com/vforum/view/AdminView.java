package com.vforum.view;

import java.util.List;
import java.util.Scanner;

import com.vforum.controller.AdminController;
import com.vforum.controller.EmployeeController;
import com.vforum.model.LoginModel;
import com.vforum.model.EmployeeModel;

public class AdminView {

public void mainAdminView(LoginModel loginModel) {
	AdminController adminController=new AdminController();
	EmployeeController employeeController=new EmployeeController();
	MainView mainView=new MainView();
	try(
			Scanner scanner=new Scanner(System.in);
	){
		System.out.println("=======Admin View======");
		System.out.println("1.view employees ");
		System.out.println("2.view posts ");
		System.out.println("3.search ");
		System.out.println("4.delete post ");
		System.out.println("5.logout");
		System.out.print("Enter choice:");
		int option=scanner.nextInt();
		switch(option) {
		case 1:adminController.viewEmployees(loginModel);
				break;
		case 2:employeeController.viewQuestions(loginModel);
				break;
		case 5:mainView.mainMenu();
		break;
	}
	}
	catch(Exception e) {
	e.printStackTrace();
	}
}

	public void showEmployees(List<EmployeeModel> model,LoginModel loginModel){
		System.out.println("=====================================================================================================================");
		System.out.format("%10s%15s%15s%15s%20s%20s%20s\n","UserName","FirstName","LastName","Email","PhoneNumber","Desgination","DOB");
		System.out.println("=====================================================================================================================");
		for(EmployeeModel models:model) {
		System.out.format("%5s,%12s,%15s,%15s,%15s,%15s%15s\n",models.getEmployeeUid(),models.getFirstName(),models.getLastName(),models.getEmail(),models.getPhoneNumber(),models.getDesignation(),models.getDob());
		System.out.println("\n");
	}
		mainAdminView(loginModel);
	
}
}
