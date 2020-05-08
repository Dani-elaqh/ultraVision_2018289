package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import controller.BoxController;
import controller.Rent;
import javax.swing.JButton;

public class TvBox2 extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField tfTitle;
	private JTextField tfSeason;
	private JTextField tfGenre;
	private BoxController controllerInternalRef;
	JComboBox <Rent>comboBox;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					TvBox2 frame = new TvBox2();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the frame.
//	 */
	public TvBox2(BoxController controller) {
		this.controllerInternalRef = controller;
		
		JFrame frame= new JFrame();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 905, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTvboxSets = new JLabel("TvBox Sets");
		lblTvboxSets.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 16));
		lblTvboxSets.setBounds(389, 32, 115, 51);
		contentPane.add(lblTvboxSets);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 96, 495, 344);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblTitle = new JLabel("Title");
		lblTitle.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		lblTitle.setBounds(576, 126, 56, 16);
		contentPane.add(lblTitle);
		
		JLabel lblSeason = new JLabel("Season");
		lblSeason.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		lblSeason.setBounds(576, 177, 56, 16);
		contentPane.add(lblSeason);
		
		JLabel lblGenre = new JLabel("Genre\r\n");
		lblGenre.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		lblGenre.setBounds(576, 232, 56, 16);
		contentPane.add(lblGenre);
		
		JLabel lblRent = new JLabel("Rented");
		lblRent.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		lblRent.setBounds(576, 284, 56, 16);
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
		
		JButton btnAddNewTv = new JButton("Add new Tv Box Set");
		btnAddNewTv.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 14));
		btnAddNewTv.setBounds(667, 347, 185, 35);
		contentPane.add(btnAddNewTv);
		
		frame.validate();
		frame.repaint();
	}
}
