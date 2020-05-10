package controller;
//Class for the registration of a rented title 

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import ultraVision_model.model;
import view.RegisterTitle;

public class RegRentController implements ActionListener {

	RegisterTitle register;
	model model;
	private JButton btnMlovers;
	private JButton btnTv;

	public RegRentController() {

		this.register = new RegisterTitle(this);
		model = new model();
	}

	@Override
	public void actionPerformed(ActionEvent action) {

		String Id = this.register.getId();
		String titleID = this.register.getTitleID();
		String title = this.register.getTitle();
		String date = this.register.getDate();

		RegisterRent addRented = new RegisterRent(Id, titleID, title, date);

		if (action.getActionCommand().equals("addMlover")) {

			// calling the method to register the music title in the database
			// btnMlovers.setEnabled(true);
			boolean newMLover = model.RentedMusic(addRented);

			if (newMLover == true) {
				// if success new artist added
				JOptionPane.showMessageDialog(null, " New title added to rented MusicLover  ");

			}

			// if something goes wrong user knows , should try again
			else {
				JOptionPane.showMessageDialog(null, "Something went wrong. Please try again");
			}
		}

		if (action.getActionCommand().equals("addConcert")) {

			// calling the method to register the music title in the database
			// btnMlovers.setEnabled(true);
			boolean newConcert = model.RentedConcert(addRented);

			if (newConcert == true) {
				// if success new artist added
				JOptionPane.showMessageDialog(null, " New title added to rented LiveConcerts  ");

			}

			// if something goes wrong user knows , should try again
			else {
				JOptionPane.showMessageDialog(null, "Something went wrong. Please try again");
			}
		}

		if (action.getActionCommand().equals("addTv")) {

			// calling the method to register the music title in the database
			// btnMlovers.setEnabled(true);
			boolean newTv = model.RentedTvBox(addRented);

			if (newTv == true) {
				// if success new artist added
				JOptionPane.showMessageDialog(null, " New title added to rented Tv Box Sets  ");

			}

			// if something goes wrong user knows , should try again
			else {
				JOptionPane.showMessageDialog(null, "Something went wrong. Please try again");
			}
		}

		if (action.getActionCommand().equals("addVideo")) {

			// calling the method to register the music title in the database
			// btnMlovers.setEnabled(true);
			boolean newMovies = model.RentedMovies(addRented);

			if (newMovies == true) {
				// if success new artist added
				JOptionPane.showMessageDialog(null, " New title added to rented Movies  ");

			}

			// if something goes wrong user knows , should try again
			else {
				JOptionPane.showMessageDialog(null, "Something went wrong. Please try again");
			}
		}

		if (action.getActionCommand().equals("addPremium")) {

			// calling the method to register the music title in the database
			// btnMlovers.setEnabled(true);
			boolean newPremium = model.RentedPremium(addRented);

			if (newPremium == true) {
				// if success new artist added
				JOptionPane.showMessageDialog(null, " New title added to rented Premium  ");

			}

			// if something goes wrong user knows , should try again
			else {
				JOptionPane.showMessageDialog(null, "Something went wrong. Please try again");
			}
		}
	}

}
