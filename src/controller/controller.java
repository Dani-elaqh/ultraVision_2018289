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
		
				
		

		if(e.getActionCommand().equals("Members")) {
			 members = new MembersMenu();
			members.dispose();
		}
		
		}
	}

