package controller;

//This class in in charge of make the actions happen when it comes to 
//add new titles to the table of TVBox sets

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import ultraVision_model.model;
import view.TvBox;

public class BoxController implements ActionListener {

	model model;
	TvBox box;

	public BoxController() {

		this.box = new TvBox(this);
		model = new model();
	}

	@Override
	public void actionPerformed(ActionEvent action) {

		String title = this.box.getTitle();
		String season = this.box.getSeason();
		String genre = this.box.getGenre();
		String rent = this.box.getRented();

		Box addTv = new Box(title, season, genre, rent);

		if (action.getActionCommand().equals("addBox")) {

			// calling the method to register the music title in the database

			boolean newBox = model.regBox(addTv);

			if (newBox == true) {
				// if success new artist added
				JOptionPane.showMessageDialog(null, "New movie " + title + " Sucessfully added!");
			}

			// if something goes wrong user knows , should try again
			else {
				JOptionPane.showMessageDialog(null, "Something went wrong. Please try again");
			}

		}

	}
}
