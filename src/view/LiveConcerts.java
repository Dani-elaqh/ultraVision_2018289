package view;
//Class Gui for the live concerts table , display and adding new titles to the table 

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ConcertController;
import controller.Rent;
import ultraVision_model.model;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;

public class LiveConcerts extends JFrame {
	
	//Global so all method that need them can accesess them 

	private JPanel contentPane;
	private JTable table;
	private JTextField tfTitle;
	private JTextField tfArtist;
	private JTextField tfYear;
	private JTextField tfGenre;
	private JTextField tfFormat;
	JComboBox <Rent>comboBox;
	//The window need to know who and and which is the controller for this window
	private ConcertController controllerInternalRef;


	
	public LiveConcerts(ConcertController controller) {
		//Setting the reference of the controller
		this.controllerInternalRef= controller;
		
		//Setting the attributes for this window and components
		JFrame frame = new JFrame();
		frame.setBackground(SystemColor.inactiveCaptionBorder);
		frame.setVisible(true);
		frame.setBounds(100, 100, 1101, 698);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLiveConcerts = new JLabel("Live Concerts");
		lblLiveConcerts.setForeground(new Color(128, 0, 128));
		lblLiveConcerts.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 20));
		lblLiveConcerts.setBounds(449, 34, 164, 50);
		contentPane.add(lblLiveConcerts);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 128, 664, 475);
		contentPane.add(scrollPane);
		

		String[] columnNames = { "LiveID", "Title", "Artist", "Year of release", "Genre", "Rented" , "Format" };
		String[][] data = new String[100][columnNames.length];

		// database connection in model class
		model jdbc = new model();

		// gathering the data
		data = jdbc.concert();
		
		table = new JTable(data, columnNames);
		scrollPane.setViewportView(table);
		
		JLabel lbltitle = new JLabel("Title");
		lbltitle.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		lbltitle.setBounds(729, 157, 56, 16);
		contentPane.add(lbltitle);
		
		JLabel lblartist = new JLabel("Artist");
		lblartist.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		lblartist.setBounds(729, 209, 56, 16);
		contentPane.add(lblartist);
		
		JLabel lblyear = new JLabel("Year of release");
		lblyear.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		lblyear.setBounds(729, 269, 142, 16);
		contentPane.add(lblyear);
		
		JLabel lblgenre = new JLabel("Genre");
		lblgenre.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		lblgenre.setBounds(729, 325, 142, 16);
		contentPane.add(lblgenre);
		
		JLabel lblrented = new JLabel("For Rent");
		lblrented.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		lblrented.setBounds(729, 390, 142, 16);
		contentPane.add(lblrented);
		
		JLabel lblformat = new JLabel("Format");
		lblformat.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		lblformat.setBounds(729, 457, 142, 16);
		contentPane.add(lblformat);
		
		JButton btnadd = new JButton("Add New title");
		btnadd.setBorder(new LineBorder(new Color(100, 149, 237), 3, true));
		btnadd.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 17));
		btnadd.addActionListener((ActionListener)controller);
		btnadd.setActionCommand("add");
		btnadd.setBounds(823, 543, 164, 44);
		contentPane.add(btnadd);
		
		tfTitle = new JTextField();
		tfTitle.setBounds(891, 146, 180, 31);
		contentPane.add(tfTitle);
		tfTitle.setColumns(10);
		
		tfArtist = new JTextField();
		tfArtist.setColumns(10);
		tfArtist.setBounds(891, 207, 180, 31);
		contentPane.add(tfArtist);
		
		tfYear = new JTextField();
		tfYear.setColumns(10);
		tfYear.setBounds(891, 267, 180, 31);
		contentPane.add(tfYear);
		
		tfGenre = new JTextField();
		tfGenre.setColumns(10);
		tfGenre.setBounds(891, 323, 180, 31);
		contentPane.add(tfGenre);
		
		comboBox = new JComboBox<Rent>();
		comboBox.setModel(new DefaultComboBoxModel(Rent.values()));
		comboBox.setBounds(916, 390, 155, 30);
		contentPane.add(comboBox);
		
		tfFormat = new JTextField();
		tfFormat.setColumns(10);
		tfFormat.setBounds(891, 455, 180, 31);
		contentPane.add(tfFormat);
		
		frame.validate();
		frame.repaint();
	}
	
	
	
	public String getTitle() {
		return tfTitle.getText();
	}
	public String getArtist() {
		return tfArtist.getText();
	}
	public String getYear() {
		return tfYear.getText();
	}
	
	public String getGenre() {
		return tfGenre.getText();
	}
	
	public String getRented() {
		return ((Rent)comboBox.getSelectedItem()).getFree();
	}
	
	public String getFormat() {
		return tfFormat.getText();
	}
}
