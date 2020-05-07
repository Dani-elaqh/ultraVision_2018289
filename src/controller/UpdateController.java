package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.UpdateCustomer;

public class UpdateController implements ActionListener {
	
	UpdateCustomer update;
	public UpdateController () {
		
		update = new UpdateCustomer(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
