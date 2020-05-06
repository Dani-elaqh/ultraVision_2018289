package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ultraVision_model.model;
import view.CustomerMenu;
import view.Entertaiment;
import view.MembersMenu;
import view.Menu;


public class controller implements ActionListener{
	
	model Model;
	Menu menu;
	MembersMenu members;
	CustomerMenu customers;
	Entertaiment entertaiment;


	
	public controller () {
		
		menu  = new Menu(this);

//		members = new MembersMenu(this);
		//customers = new CustomerMenu(this);
//		entertaiment = new Entertaiment(this);
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
		
		if(e.getActionCommand().equals("Members")) {
			 customers = new CustomerMenu(this);
			 Model = new model();
				
				String fn = customers.getFirstName();
				String ln = customers.getLastName();
				String phone = customers.getPhone();
				String type = customers.gettype();
				String cn = customers.getCard();
				String date = customers.getdate();
				
				Customer RegCustomer = new Customer (fn, ln, phone, type, cn, date);
			 customers.dispose();
		}
		
		
		else if (e.getActionCommand().equals("entertaiment")) {
			entertaiment = new Entertaiment();
			entertaiment.dispose();
		}
		}
	}

