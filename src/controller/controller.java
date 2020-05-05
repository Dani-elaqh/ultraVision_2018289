package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ultraVision_model.model;
import view.MembersMenu;
import view.StaffMenu;


public class controller implements ActionListener{
	
	model Model;
	StaffMenu menu;
	MembersMenu members;

	
	public controller () {
		
		Model = new model();
		menu = new StaffMenu (this);
		members = new MembersMenu(this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String fn = members.getName();
		String ln = members.getLastName();
		String phone = members.getPhone();
		String st = members.getMember();
		String cn = members.getCard();
		String date = members.getdate();
		
		
		if(e.getActionCommand().equals("Members")) {
			 members = new MembersMenu();
			 members.dispose();
		}
		
		
		else if (e.getActionCommand().equals("Reg")) {
			
		}
		}
	}

