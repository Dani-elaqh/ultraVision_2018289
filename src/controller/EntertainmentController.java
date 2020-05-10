package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.Entertaiment;

//This class is in charge of calling the next controllers , 
//depending on what the users needs to see or add new title to 

public class EntertainmentController implements ActionListener {

	Entertaiment entertainment;

	public EntertainmentController() {

		entertainment = new Entertaiment(this);

	}

	// implementing the method for the actions
	@Override
	public void actionPerformed(ActionEvent e) {
//Calling the relevant controllers for each button
		if (e.getActionCommand().equals("music")) {

			new MusicController();
		}

		else if (e.getActionCommand().equals("movie")) {

			new MovieController();

		}

		else if (e.getActionCommand().equals("concert")) {

			new ConcertController();

		}

		else if (e.getActionCommand().equals("box")) {

			new BoxController();

		}
	}

}
