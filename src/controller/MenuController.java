package controller;

//Controller for the first window of the program 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.Menu;
import view.SearchCustomer;

public class MenuController implements ActionListener {

	Menu menu;

	public MenuController() {

		menu = new Menu(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("Members")) {

			new MemberController();

		}

		else if (e.getActionCommand().equals("entertainment")) {
			new EntertainmentController();
		}

		else if (e.getActionCommand().equals("register")) {
			new RegRentController();
		}

		else if (e.getActionCommand().equals("search")) {
			new SearchCustomer();
		}

	}
}
