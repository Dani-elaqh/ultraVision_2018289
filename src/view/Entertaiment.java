package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.controller;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;

public class Entertaiment extends JFrame {

	private JPanel contentPane;
	private controller controllerInternalRef;

	/**
	 * Launch the application.
	 */
	
	public Entertaiment (controller controller) {
		this.controllerInternalRef = controller;
	
	
	}

	/**
	 * Create the frame.
	 */
	public Entertaiment() {
		setTitle("Ultra Vision");
		getContentPane().setLayout(null);
		
		JButton btnMusic = new JButton("Music");
		btnMusic.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 16));
		btnMusic.setBounds(47, 76, 194, 61);
		getContentPane().add(btnMusic);
		
		JButton btnTvBox = new JButton("Tv Box");
		btnTvBox.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 17));
		btnTvBox.setBounds(422, 76, 202, 61);
		getContentPane().add(btnTvBox);
		
		JButton btnMovies = new JButton("Movies");
		btnMovies.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 18));
		btnMovies.setBounds(47, 323, 194, 61);
		getContentPane().add(btnMovies);
		
		JButton btnLiveConcerts = new JButton("Live Concerts");
		btnLiveConcerts.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 18));
		btnLiveConcerts.setBounds(422, 323, 202, 61);
		getContentPane().add(btnLiveConcerts);
		JFrame frame= new JFrame ();
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this .setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		this.setContentPane(contentPane);
		
		this.validate();
		this.repaint();
		
		
		
	}

}
