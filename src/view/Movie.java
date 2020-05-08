package view;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.MovieController;
import controller.Rent;
import ultraVision_model.model;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

public class Movie extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private MovieController controllerInternalRef;
	private JScrollPane scrollPane_1;
	private JLabel lblMovies;
	private JLabel lbltitle;
	private JLabel lbyear;
	private JLabel lblgenre;
	private JLabel lbdirector;
	private JTextField tfdir;
	private JTextField tftitle;
	private JTextField tfyear;
	private JTextField tfgenre;
	private JLabel lbrent;
	JComboBox <Rent>comboBox;

	public Movie(MovieController controller) {
		this.controllerInternalRef = controller;

		JFrame frame = new JFrame();

		frame.setVisible(true);
		frame.setBounds(100, 100, 1136, 571);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);

		lblMovies = new JLabel("Movies");
		lblMovies.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 16));
		lblMovies.setBounds(297, 13, 66, 20);
		contentPane.add(lblMovies);
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(12, 51, 632, 356);
		contentPane.add(scrollPane_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane_1.setViewportView(scrollPane);

		String[] columnNames = { "MovieID", "Director", "Title", "Year of release", "Genre", "Rented" };
		String[][] data = new String[100][columnNames.length];

		// database connection in model class
		model jdbc = new model();

		// gathering the data
		data = jdbc.movie();
		
		table = new JTable(data, columnNames);
		scrollPane.setViewportView(table);

		lbltitle = new JLabel("Title");
		lbltitle.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 17));
		lbltitle.setBounds(702, 149, 114, 20);
		contentPane.add(lbltitle);

		lbyear = new JLabel("Year of release");
		lbyear.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 16));
		lbyear.setBounds(702, 197, 156, 20);
		contentPane.add(lbyear);

		lblgenre = new JLabel("Genre");
		lblgenre.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 16));
		lblgenre.setBounds(702, 252, 114, 20);
		contentPane.add(lblgenre);

		lbdirector = new JLabel("Director");
		lbdirector.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 16));
		lbdirector.setBounds(702, 102, 114, 20);
		contentPane.add(lbdirector);

		tfdir = new JTextField();
		tfdir.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		tfdir.setBounds(869, 102, 219, 22);
		contentPane.add(tfdir);
		tfdir.setColumns(10);

		tftitle = new JTextField();
		tftitle.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		tftitle.setColumns(10);
		tftitle.setBounds(869, 150, 219, 22);
		contentPane.add(tftitle);

		tfyear = new JTextField();
		tfyear.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		tfyear.setColumns(10);
		tfyear.setBounds(870, 197, 218, 22);
		contentPane.add(tfyear);

		tfgenre = new JTextField();
		tfgenre.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		tfgenre.setColumns(10);
		tfgenre.setBounds(869, 252, 219, 22);
		contentPane.add(tfgenre);

		JButton btnadd = new JButton("Add new Movie");
		btnadd.setBackground(SystemColor.activeCaption);
		btnadd.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 16));
		btnadd.setBounds(784, 343, 184, 35);
		contentPane.add(btnadd);
		btnadd .addActionListener((ActionListener)controller);
		btnadd .setActionCommand("new");
		
		lbrent = new JLabel("Rented");
		lbrent.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 16));
		lbrent.setBounds(702, 297, 114, 20);
		contentPane.add(lbrent);
		
		comboBox = new JComboBox<Rent>();
		comboBox.setModel(new DefaultComboBoxModel(Rent.values()));
		comboBox.setBounds(999, 297, 89, 22);
		contentPane.add(comboBox);
		
		frame.validate();
		frame.repaint();
	}
	
	public String getDir() {
		return tfdir.getText();
	}
	
	public String getTitle() {
		return tftitle.getText();
	}
	
	public String getYear() {
		return tfyear.getText();
	}
	
	public String getGenre() {
		return tfgenre.getText();
	}
	
	public String getRent() {
		return ((Rent)comboBox.getSelectedItem()).getFree();
	}
}
