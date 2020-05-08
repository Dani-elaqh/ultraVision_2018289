package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import ultraVision_model.model;
import view.Movie;

public class MovieController implements ActionListener{

	Movie movie;
	model model;
	
	public MovieController() {
		
		this.movie = new Movie(this);
		model = new model();
	}
	@Override
	public void actionPerformed(ActionEvent action) {
			
		String director = this.movie.getDir();
		String title = this.movie.getTitle();
		String year = this.movie.getYear();
		String genre = this.movie.getGenre();
		String rent = this.movie.getRent();
		
		Movies addMovie =  new Movies(director, title, year, genre, rent);
		
		
				if (action.getActionCommand().equals("new")) {

				// calling the method to register the music title in the database
				
				boolean newMovie = model.regMovie(addMovie);

				if (newMovie == true) {
					//if success new artist added
					JOptionPane.showMessageDialog(null, "New movie " + title + " Sucessfully added!");
				}
				
				//if something goes wrong user knows , should try again 
				else {
					JOptionPane.showMessageDialog(null, "Something went wrong. Please try again");
				}

			
		}
		
	}
	
}
