package view;

//class in charge for the TvBox window to display 
//the titles available and insert new ones

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import controller.BoxController;
import controller.Rent;
import ultraVision_model.model;

import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class TvBox extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField tfTitle;
	private JTextField tfSeason;
	private JTextField tfGenre;
	//Declaring the controller for this window 
	private BoxController controllerInternalRef;
	JComboBox<Rent> comboBox;

	public TvBox(BoxController controller) {
		//Local reference for the controller 
		this.controllerInternalRef = controller;

		// Component and attributes for this window
		JFrame frame = new JFrame();
		frame.setBackground(SystemColor.inactiveCaptionBorder);
		frame.setVisible(true);
		frame.setBounds(100, 100, 905, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTvboxSets = new JLabel("TvBox Sets");
		lblTvboxSets.setForeground(new Color(128, 0, 128));
		lblTvboxSets.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 20));
		lblTvboxSets.setBounds(388, 13, 138, 51);
		contentPane.add(lblTvboxSets);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 96, 495, 344);
		contentPane.add(scrollPane);

		String[] columnNames = { "BoxID", "Title", "Season", "Genre", "Rented" };
		String[][] data = new String[100][columnNames.length];

		// database connection in model class
		model jdbc = new model();

		// gathering the data
		data = jdbc.box();

		table = new JTable(data, columnNames);
		scrollPane.setViewportView(table);

		JLabel lblTitle = new JLabel("Title");
		lblTitle.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		lblTitle.setBounds(556, 126, 56, 16);
		contentPane.add(lblTitle);

		JLabel lblSeason = new JLabel("Season");
		lblSeason.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		lblSeason.setBounds(556, 183, 56, 16);
		contentPane.add(lblSeason);

		JLabel lblGenre = new JLabel("Genre");
		lblGenre.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		lblGenre.setBounds(556, 238, 56, 16);
		contentPane.add(lblGenre);

		JLabel lblRent = new JLabel("For Rent");
		lblRent.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		lblRent.setBounds(556, 288, 87, 16);
		contentPane.add(lblRent);

		tfTitle = new JTextField();
		tfTitle.setBounds(655, 118, 197, 35);
		contentPane.add(tfTitle);
		tfTitle.setColumns(10);

		tfSeason = new JTextField();
		tfSeason.setColumns(10);
		tfSeason.setBounds(655, 175, 197, 35);
		contentPane.add(tfSeason);

		tfGenre = new JTextField();
		tfGenre.setColumns(10);
		tfGenre.setBounds(655, 230, 197, 35);
		contentPane.add(tfGenre);

		comboBox = new JComboBox<Rent>();
		comboBox.setModel(new DefaultComboBoxModel(Rent.values()));
		comboBox.setBounds(655, 284, 197, 27);
		contentPane.add(comboBox);

		JButton btnAddNewTv = new JButton("Add new TvBox Set");
		btnAddNewTv.setForeground(SystemColor.desktop);
		btnAddNewTv.setBorder(new LineBorder(new Color(100, 149, 237), 2, true));
		btnAddNewTv.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 14));
		btnAddNewTv.setBounds(655, 345, 197, 43);
		contentPane.add(btnAddNewTv);
		btnAddNewTv.addActionListener((ActionListener) controller);
		btnAddNewTv.setActionCommand("addBox");

		frame.validate();
		frame.repaint();
	}

	// Getters for the user inputs when adding a new title to the table
	public String getTitle() {
		return tfTitle.getText();
	}

	public String getSeason() {
		return tfSeason.getText();
	}

	public String getGenre() {
		return tfGenre.getText();
	}

	public String getRented() {
		return ((Rent) comboBox.getSelectedItem()).getFree();
	}

}
