package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import ultraVision_model.model;
import view.CustomerMenu;

public class MemberController implements ActionListener {

	CustomerMenu customers;
	model model;

	public MemberController() {
		this.customers = new CustomerMenu(this);
	}

	@Override
	public void actionPerformed(ActionEvent action) {
		
			String fn = this.customers.getFirstName();
			String ln = this.customers.getLastName();
			String email = this.customers.getEmail();
			String type = this.customers.gettype();
			String cn = this.customers.getCard();
			String date = this.customers.getdate();
			Customer regCustomer = new Customer(fn, ln, email, type, cn, date);
		
		
		// Ask the model if the user is valid
		// we need to update this
		
		if(action.getActionCommand().equals("Members")) {
		
			
		
		boolean newCustomer = model.register(regCustomer);
		
		if (newCustomer == true) {
			
			JOptionPane.showMessageDialog(null, "New Customer " + fn + " Sucessfully Created!");
		}
		
		else {
			JOptionPane.showMessageDialog(null, "Something went wrong. Please try again");
		}
		
		
		
		}
	}

}
