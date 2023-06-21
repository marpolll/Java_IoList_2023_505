package com.marpol.iolist.exec;

import com.marpol.iolist.config.HelpMessage;
import com.marpol.iolist.controller.MainController;

public class ExecF {
	
	public static void main(String[] args) {
		MainController mainController = new MainController();
		mainController.startApp();

		HelpMessage.OK("집가고싶다");
	}

}
