package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ultraVision_model.model;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class MusicTable extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	public MusicTable() {

		JFrame frame = new JFrame();

		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 1072, 462);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(24, 40, 563, 324);
		contentPane.add(scrollPane);

		String[] columnNames = { "MusicID", "Artist", "Title", "Year of release", "rented" };
		String[][] data = new String[100][columnNames.length];

		// database connection in model class
		model jdbc = new model();

		// gathering the data
		data = jdbc.music();
		
		table = new JTable(data, columnNames);
		scrollPane.setViewportView(table);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(840, 286, 97, 25);
		contentPane.add(btnUpdate);
		
		JLabel lblArtist = new JLabel("Artist");
		lblArtist.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		lblArtist.setBounds(635, 64, 97, 25);
		contentPane.add(lblArtist);
		
		JLabel lbltitle = new JLabel("Title\r\n");
		lbltitle.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		lbltitle.setBounds(635, 102, 97, 25);
		contentPane.add(lbltitle);
		
		JLabel lblyear = new JLabel("Year of release");
		lblyear.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		lblyear.setBounds(635, 149, 165, 25);
		contentPane.add(lblyear);
		
		JLabel lblrented = new JLabel("rented");
		lblrented.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		lblrented.setBounds(635, 198, 97, 25);
		contentPane.add(lblrented);
		
		textField = new JTextField();
		textField.setBounds(783, 66, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(783, 114, 116, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(783, 163, 116, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(783, 210, 116, 22);
		contentPane.add(textField_3);
		textField_3.setColumns(10);

		frame.validate();
		frame.repaint();

	}
}
