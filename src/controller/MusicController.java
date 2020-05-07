package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import ultraVision_model.model;
import view.MusicTable;

public class MusicController implements ActionListener {

	MusicTable music;
	model model;

	public MusicController() {

		this.music = new MusicTable(this);
		model = new model();

	}

	@Override
	public void actionPerformed(ActionEvent action) {

		//variable to get the users input 
		String artist = this.music.getArtist();
		String title = this.music.getTitle();
		String year = this.music.getYear();
		String rent = this.music.getRented();

		Music addMusic = new Music(artist, title, year, rent);

		if (action.getActionCommand().equals("add")) {

			// calling the method to register the music title in the database
			
			boolean newMusic = model.regMusic(addMusic);

			if (newMusic == true) {
				//if success new artist added
				JOptionPane.showMessageDialog(null, "New Artist " + artist + " Sucessfully Created!");
			}
			
			//if something goes wrong user knows , should try again 
			else {
				JOptionPane.showMessageDialog(null, "Something went wrong. Please try again");
			}

		}

	}

}
