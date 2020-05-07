package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.Entertaiment;
import view.Menu;
import view.MusicTable;

public class EntertainmentController implements ActionListener {
	
	Entertaiment entertainment;
	
	
	public EntertainmentController() {

		entertainment = new Entertaiment(this);

	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand().equals("music")) {
			
			new MusicController();
		}
		
		else if(e.getActionCommand().equals("concert")) {
			
			
		}
		
		
	}

}
