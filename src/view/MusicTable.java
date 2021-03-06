package view;
//This class is in charge of managing the window for music table 

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.MusicController;
import ultraVision_model.model;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class MusicTable extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField tfartist;
	private JTextField tftitle;
	private JTextField tfyear;
	private JTextField tfrent;
	private MusicController controllerInternalRef;

	public MusicTable(MusicController controller) {
		//Reference to the controller locally
		this.controllerInternalRef = controller;

		JFrame frame = new JFrame();
		//Attributes and components for this window, music table 
		frame.setVisible(true);
		frame.setBounds(100, 100, 1072, 462);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMusicData = new JLabel("Music data");
		lblMusicData.setForeground(new Color(128, 0, 128));
		lblMusicData.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 20));
		lblMusicData.setBounds(500, 13, 152, 16);
		contentPane.add(lblMusicData);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 61, 563, 324);
		contentPane.add(scrollPane);

		String[] columnNames = { "MusicID", "Artist", "Title", "Year of release", "rented" };
		String[][] data = new String[100][columnNames.length];

		// database connection in model class
		model jdbc = new model();

		// gathering the data
		data = jdbc.music();
		
		table = new JTable(data, columnNames);
		scrollPane.setViewportView(table);
		
		JButton btnUpdate = new JButton("Add new title");
		btnUpdate.setBorder(new LineBorder(new Color(100, 149, 237), 3, true));
		btnUpdate.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 16));
		btnUpdate.setBounds(783, 287, 165, 41);
		contentPane.add(btnUpdate);
		btnUpdate.addActionListener((ActionListener)controller);
		btnUpdate.setActionCommand("add");
		
		JLabel lblArtist = new JLabel("Artist");
		lblArtist.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		lblArtist.setBounds(635, 64, 97, 25);
		contentPane.add(lblArtist);
		
		JLabel lbltitle = new JLabel("Title\r\n");
		lbltitle.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		lbltitle.setBounds(635, 111, 97, 25);
		contentPane.add(lbltitle);
		
		JLabel lblyear = new JLabel("Year of release");
		lblyear.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		lblyear.setBounds(635, 161, 165, 25);
		contentPane.add(lblyear);
		
		JLabel lblrented = new JLabel("Rented");
		lblrented.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		lblrented.setBounds(635, 208, 97, 25);
		contentPane.add(lblrented);
		
		tfartist = new JTextField();
		tfartist.setBounds(783, 66, 259, 22);
		contentPane.add(tfartist);
		tfartist.setColumns(10);
		
		tftitle = new JTextField();
		tftitle.setBounds(783, 114, 259, 22);
		contentPane.add(tftitle);
		tftitle.setColumns(10);
		
		tfyear = new JTextField();
		tfyear.setBounds(783, 163, 259, 22);
		contentPane.add(tfyear);
		tfyear.setColumns(10);
		
		tfrent = new JTextField();
		tfrent.setBounds(783, 210, 259, 22);
		contentPane.add(tfrent);
		tfrent.setColumns(10);
		
		

		frame.validate();
		frame.repaint();

	}
	
	//Getter for the text fields
	public String getArtist() {
		return tfartist.getText();
	}
	
	public String getTitle() {
		return tftitle.getText();
	}
	
	public String getYear() {
		return tfyear.getText();
	}
	
	public String getRented() {
		return tfrent.getText();
	}
}
