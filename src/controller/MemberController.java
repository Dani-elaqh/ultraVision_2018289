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
		model = new model();

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
		
		String id = this.customers.getId();
		String name = this.customers.getName();
		String lname = this.customers.getLname();
		String mail = this.customers.getMail();
		String member = this.customers.getMember();
		String card = this.customers.getCardN();
		String expDate = this.customers.getExpDate();
		UpdateCustomer custUpdated = new UpdateCustomer(id, name, lname, mail, member, card, expDate);
		

		//if the new registration of the new customer is true happy to add new one

		if (action.getActionCommand().equals("Members")) {

			boolean newCustomer = model.register(regCustomer);

			if (newCustomer == true) {

				JOptionPane.showMessageDialog(null, "New Customer " + fn + " Sucessfully Created!");
			}

			else {
				JOptionPane.showMessageDialog(null, "Something went wrong. Please try again");
			}

		}
		
		if (action.getActionCommand().equals("update")) {

			boolean update = model.updateN(custUpdated);

			if (update == true) {

				JOptionPane.showMessageDialog(null, " Customer " + id + " Updated!");
			}

			else {
				JOptionPane.showMessageDialog(null, "Something went wrong. Please try again");
			}

		}
	}

}
