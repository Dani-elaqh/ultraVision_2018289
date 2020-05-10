package view;

//This class is in charge of the entertainment Menu, so far the user has 4 options to see the records for each table 
//or the user can add new titles to the tables

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.EntertainmentController;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.border.LineBorder;

public class Entertaiment extends JFrame {

	private JPanel contentPane;
	//Setting who is is the controller for his window
	private EntertainmentController controllerInternalRef;

	public Entertaiment(EntertainmentController controller) {

		//Setting the reference of the controller
		this.controllerInternalRef = controller;

		//Setting attributes and components
		JFrame frame = new JFrame();
		frame.setBackground(new Color(204, 255, 255));
		frame.setVisible(true);
		frame.setTitle("UltraVision");
		frame.setBounds(100, 100, 671, 561);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);

		// Button to see the movies
		JButton btnMovies = new JButton("Movies");
		btnMovies.setBorder(new LineBorder(new Color(100, 149, 237), 3, true));
		btnMovies.setForeground(SystemColor.desktop);
		btnMovies.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 13));
		btnMovies.setIcon(new ImageIcon(
				"C:\\Users\\daniq\\eclipse-workspace\\Newworkspace OOC\\ultraVision_2018289\\icons\\folder-video-icon (1).png"));
		btnMovies.setBounds(71, 105, 185, 72);
		contentPane.add(btnMovies);
		btnMovies.addActionListener((ActionListener) controllerInternalRef);
		btnMovies.setActionCommand("movie");

		// Button to go to Live concert table and menu
		JButton btnConcert = new JButton("Live Concert");
		btnConcert.setBorder(new LineBorder(new Color(100, 149, 237), 3, true));
		btnConcert.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 13));
		btnConcert.setIcon(new ImageIcon(
				"C:\\Users\\daniq\\eclipse-workspace\\Newworkspace OOC\\ultraVision_2018289\\icons\\City-Park-Concert-Shell-icon.png"));
		btnConcert.setBounds(374, 105, 185, 72);
		contentPane.add(btnConcert);
		btnConcert.addActionListener((ActionListener) controllerInternalRef);
		btnConcert.setActionCommand("concert");

		// Button for the Tv bos set menu
		JButton btnBox = new JButton("TV Box Set");
		btnBox.setBorder(new LineBorder(new Color(100, 149, 237), 3, true));
		btnBox.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 13));
		btnBox.setIcon(new ImageIcon(
				"C:\\Users\\daniq\\eclipse-workspace\\Newworkspace OOC\\ultraVision_2018289\\icons\\television-icon.png"));
		btnBox.setBounds(71, 279, 185, 72);
		contentPane.add(btnBox);
		btnBox.addActionListener((ActionListener) controllerInternalRef);
		btnBox.setActionCommand("box");

		// Button for the Music table and menu
		JButton btnMusic = new JButton("Music");
		btnMusic.setBorder(new LineBorder(new Color(100, 149, 237), 3, true));
		btnMusic.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 13));
		btnMusic.setIcon(new ImageIcon(
				"C:\\Users\\daniq\\eclipse-workspace\\Newworkspace OOC\\ultraVision_2018289\\icons\\Music-Library-icon.png"));
		btnMusic.setBounds(374, 279, 185, 72);
		contentPane.add(btnMusic);
		btnMusic.addActionListener((ActionListener) controllerInternalRef);
		btnMusic.setActionCommand("music");

		frame.validate();
		frame.repaint();

	}

}
