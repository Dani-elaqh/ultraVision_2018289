package controller;

//Class that controls the display of the live concert table and the insertion of new titles 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import ultraVision_model.model;
import view.LiveConcerts;

public class ConcertController implements ActionListener {

	model model;
	LiveConcerts concerts;

	public ConcertController() {
		this.concerts = new LiveConcerts(this);
		model = new model();

	}

	@Override
	public void actionPerformed(ActionEvent action) {

		String artist = this.concerts.getArtist();
		String title = this.concerts.getTitle();
		String year = this.concerts.getYear();
		String genre = this.concerts.getGenre();
		String rent = this.concerts.getRented();
		String format = this.concerts.getFormat();

		Concert addLive = new Concert(title, artist, year, genre, rent, format);

		if (action.getActionCommand().equals("add")) {

			// calling the method to register the new title in the database

			boolean newLive = model.regConcert(addLive);

			if (newLive == true) {
				// if success new artist added
				JOptionPane.showMessageDialog(null, " New concert " + title + " Sucessfully added! ");
			}

			// if something goes wrong user knows , should try again
			else {
				JOptionPane.showMessageDialog(null, "Something went wrong. Please try again");
			}
		}
	}
}
