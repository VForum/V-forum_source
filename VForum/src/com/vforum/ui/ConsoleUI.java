package com.vforum.ui;
/*
 * The main class where the application is executed
 */
import java.io.IOException;

import org.apache.log4j.Logger;
import com.vforum.view.MainView;

public class ConsoleUI {

	public static void main(String[] args) throws IOException {
		
		Logger logger=Logger.getLogger(ConsoleUI.class.getName());
		
		MainView mainView=new MainView();
		mainView.mainMenu();
		logger.info("-----In consoleUI the mainMenu of MainView class is called---");
	}

}
