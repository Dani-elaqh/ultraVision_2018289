package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controller.UpdateController;
import ultraVision_model.model;

public class UpdateCustomer extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private UpdateController controllerInternalRef;
	JScrollPane myPane;
	JTable myTable;
	
	public UpdateCustomer(UpdateController controller) {
		this.controllerInternalRef = controller;
		
		this.setVisible(true);
		this.setSize(800, 600);
		
		String [][] data = new String[100][100];
		
		//array for the column name in the database
		String[] columnNames = {"MemberID", "First Name", "Last Name", "Email", "Member Type", "Card number", "Expiration date"};
		
		//database connection in model class
		model jdbc = new model();
		
		//gathering the data 
		data = jdbc.music();
		
		//Creating the table
		myTable = new JTable(data, columnNames);
		
		//Scroll pane for the table
		myPane = new JScrollPane(myTable);
		this.add(myPane);
		
		this.validate();
		this.repaint();
		
	}
	
}
