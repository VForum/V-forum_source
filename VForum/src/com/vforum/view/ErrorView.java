package com.vforum.view;

public class ErrorView {
	
public void authenticationError() {
		
		System.out.println("=======Login Failed ! wrong details ======");
		MainView mainView=new MainView();
		mainView.mainMenu();
	}

}
