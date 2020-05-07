package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.Menu;

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

		else {
			new EntertainmentController();
		}
	}
}

//boolean validCustomer = false;
//if(RegCustomer.isEmail(RegCustomer.getEmail()) ==true || RegCustomer.isCard(RegCustomer.getCard())==true  || RegCustomer.isDate(RegCustomer.getDate())==true ) {
//validCustomer = true;
//}
//else if(RegCustomer.isDate(RegCustomer.getDate())==false) {
//JOptionPane.showMessageDialog(null, "Please insert a valid date");
//validCustomer = false;
//}
//else if(RegCustomer.isCard(RegCustomer.getCard())==false) {
//JOptionPane.showMessageDialog(null, "Please insert a valid card");
//validCustomer = false;
//}
//else if(RegCustomer.isEmail(RegCustomer.getEmail()) ==false) {
//JOptionPane.showMessageDialog(null, "Please insert a valid email");
//validCustomer = false;
//		
//}
