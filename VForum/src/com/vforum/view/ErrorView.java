package com.vforum.view;
/*
 * This class is used as an error view for all the operations failed
 */
import java.io.IOException;

public class ErrorView {
	
public void authenticationError() throws IOException {
		
		System.out.println("=======Login Failed ! wrong details ======");
		MainView mainView=new MainView();
		mainView.mainMenu();
	}

}
