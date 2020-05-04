package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ultraVision_model.model;
import view.StaffMenu;
import view.User;


public class controller implements ActionListener {
	
	model Model;
	User view;
	StaffMenu menu;
	
	
	public controller () {
		
		view = new User(this);
		menu = new StaffMenu (this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		//creating the connection to the data base for login
		Model = new model();
		
		//getting the inserts from the user
		String un = view.getStaffID();
		String pw = view.getCode();
		
		
		Staff userLogged = new Staff(un, pw);
		
		if(e.getActionCommand().equals("Login")){
            // and the user name and the password is valid 
            boolean login = model.login(userLogged);
            	
            System.out.println(login);
            // will go to the welcome screen for the administrator
            if(login){
            	menu = new StaffMenu(userLogged);
                view.dispose();
                
            }
        }
		
		
		}
	}

