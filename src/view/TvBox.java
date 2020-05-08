package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import controller.BoxController;
import controller.Rent;
import ultraVision_model.model;

public class TvBox extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private BoxController controllerInternalRef;
	JComboBox <Rent>comboBox;

	
	public TvBox(BoxController controller) {
		this.controllerInternalRef = controller;
		
		JFrame frame = new JFrame();
		frame.setVisible(true);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 933, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 91, 575, 346);
		contentPane.add(scrollPane);
		
		String[] columnNames = { "LiveID", "Title", "Artist", "Year of release", "Genre", "Rented" , "Format" };
		String[][] data = new String[100][columnNames.length];

		// database connection in model class
		model jdbc = new model();

		// gathering the data
		data = jdbc.box();
		
		table = new JTable(data, columnNames);
		scrollPane.setViewportView(table);
		
		JLabel lblTvBoxSets = new JLabel("Tv Box Sets");
		lblTvBoxSets.setBackground(SystemColor.textHighlight);
		lblTvBoxSets.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 15));
		lblTvBoxSets.setBounds(418, 23, 123, 31);
		contentPane.add(lblTvBoxSets);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		lblTitle.setBounds(620, 106, 86, 31);
		contentPane.add(lblTitle);
		
		JLabel lblSeason = new JLabel("Season");
		lblSeason.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		lblSeason.setBounds(620, 164, 86, 31);
		contentPane.add(lblSeason);
		
		JLabel lblGenre = new JLabel("Genre");
		lblGenre.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		lblGenre.setBounds(620, 225, 86, 31);
		contentPane.add(lblGenre);
		
		JLabel lblRent = new JLabel("Rented");
		lblRent.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		lblRent.setBounds(620, 296, 86, 31);
		contentPane.add(lblRent);
		
		JButton btnAddBox = new JButton("Add new TvBox");
		btnAddBox.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 15));
		btnAddBox.addActionListener((ActionListener)controller);
		btnAddBox.setActionCommand("add");
		btnAddBox.setBounds(713, 370, 149, 41);
		contentPane.add(btnAddBox);
		
		textField = new JTextField();
		textField.setBounds(718, 107, 167, 31);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(718, 169, 167, 31);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(718, 230, 167, 31);
		contentPane.add(textField_2);
		
		comboBox = new JComboBox<Rent>();
		comboBox.setModel(new DefaultComboBoxModel(Rent.values()));
		comboBox.setBounds(718, 296, 167, 27);
		contentPane.add(comboBox);
		
		frame.validate();
		frame.repaint();
	}
}
