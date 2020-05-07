package view;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.EntertainmentController;
import controller.MenuController;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Entertaiment extends JFrame {

	private JPanel contentPane;
	private EntertainmentController controllerInternalRef;

	public Entertaiment(EntertainmentController controller) {
		
		this.controllerInternalRef = controller;
		
		
		
		JFrame  frame = new JFrame();
		frame.setVisible(true);
		frame.setTitle("UltraVision");
		frame.setBounds(100, 100, 671, 561);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnMovies = new JButton("Movies");
		btnMovies.setIcon(new ImageIcon("C:\\Users\\daniq\\eclipse-workspace\\Newworkspace OOC\\ultraVision_2018289\\icons\\folder-video-icon (1).png"));
		btnMovies.setBounds(71, 105, 185, 72);
		contentPane.add(btnMovies);
		btnMovies.addActionListener((ActionListener)controllerInternalRef);
		btnMovies.setActionCommand("movie");
		
		JButton btnConcert = new JButton("Live Concert");
		btnConcert.setIcon(new ImageIcon("C:\\Users\\daniq\\eclipse-workspace\\Newworkspace OOC\\ultraVision_2018289\\icons\\City-Park-Concert-Shell-icon.png"));
		btnConcert.setBounds(374, 105, 185, 72);
		contentPane.add(btnConcert);
		btnConcert.addActionListener((ActionListener)controllerInternalRef);
		btnConcert.setActionCommand("concert");
		
		JButton btnBox = new JButton("TV Box Set");
		btnBox.setIcon(new ImageIcon("C:\\Users\\daniq\\eclipse-workspace\\Newworkspace OOC\\ultraVision_2018289\\icons\\television-icon.png"));
		btnBox.setBounds(71, 279, 185, 72);
		contentPane.add(btnBox);
		btnBox.addActionListener((ActionListener)controllerInternalRef);
		btnBox.setActionCommand("box");
		
		JButton btnMusic = new JButton("Music");
		btnMusic.setIcon(new ImageIcon("C:\\Users\\daniq\\eclipse-workspace\\Newworkspace OOC\\ultraVision_2018289\\icons\\Music-Library-icon.png"));
		btnMusic.setBounds(374, 279, 185, 72);
		contentPane.add(btnMusic);
		btnMusic.addActionListener((ActionListener)controllerInternalRef);
		btnMusic.setActionCommand("music");
	
		frame.validate();
		frame.repaint();
	
	
	
	}

}
