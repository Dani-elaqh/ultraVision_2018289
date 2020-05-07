package view;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import controller.MenuController;
import controller.MusicController;
import ultraVision_model.model;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionListener;

public class MusicTable extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private MusicController controllerInternalRef;
	JScrollPane myPane;
	JTable myTable;
	
	public MusicTable(MusicController controller) {
		this.controllerInternalRef = controller;
		
		JFrame  frame = new JFrame();
		frame.setVisible(true);
		frame.setTitle("UltraVision");
		frame.setBounds(100, 100, 671, 561);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//array for the data
		String [][] data = new String[10][];
		
		//array for the column name in the database
		String[] columnNames = {"MusicID", "Artist", "Title", "Year of release"};
		
		//database connection in model class
		model jdbc = new model();
		
		//gathering the data 
		data = jdbc.music();
		getContentPane().setLayout(null);
		
		//Scroll pane for the table
		myPane = new JScrollPane();
		myPane.setBounds(0, 0, 452, 453);
		getContentPane().add(myPane);
		
		//Creating the table
		myTable = new JTable(data, columnNames);
		myPane.setViewportView(myTable);
		myTable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"MusicID", "Artist", "Title", "Year of release"
			}
		));
		myTable.setColumnSelectionAllowed(true);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 15));
		btnUpdate.setBounds(545, 114, 93, 52);
		getContentPane().add(btnUpdate);
		btnUpdate.addActionListener((ActionListener)controllerInternalRef);
		btnUpdate.setActionCommand("update");
		
	
		
		
		
		frame.validate();
		frame.repaint();
	}
}
