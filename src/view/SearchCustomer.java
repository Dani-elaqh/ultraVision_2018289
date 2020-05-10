package view;
//GUI class for the searching customer and also action listener to find the search

//This window doesn't have a controller, this is because the actions are performed in the same class

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import ultraVision_model.model;

import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.SystemColor;

public class SearchCustomer extends JFrame implements ActionListener {

	// declaring variables globally

	private JPanel contentPane;
	private JTextField emailTextField;
	public JTable table;
	model model;

	public SearchCustomer() {

		// Components and attributes for the window
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 715, 478);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblSearchForCustomers = new JLabel("Search for Customers");
		lblSearchForCustomers.setForeground(new Color(128, 0, 128));
		lblSearchForCustomers.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 18));
		lblSearchForCustomers.setBounds(253, 34, 235, 48);
		contentPane.add(lblSearchForCustomers);

		emailTextField = new JTextField();
		emailTextField.setBounds(129, 129, 134, 31);
		contentPane.add(emailTextField);
		emailTextField.setColumns(10);

		JLabel lblMemberId = new JLabel("Email");
		lblMemberId.setHorizontalAlignment(SwingConstants.CENTER);
		lblMemberId.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 16));
		lblMemberId.setBounds(36, 128, 94, 31);
		contentPane.add(lblMemberId);

		JButton btnSearch = new JButton("Search");
		btnSearch.setBorder(new LineBorder(new Color(100, 149, 237), 2, true));
		btnSearch.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 15));
		btnSearch.setBounds(294, 131, 116, 29);
		contentPane.add(btnSearch);
		btnSearch.addActionListener((ActionListener) this);
		btnSearch.setActionCommand("search");

		frame.validate();
		frame.repaint();
	}

	public String getEmail() {
		return emailTextField.getText();
	}

	// Actions performed when the search button is used
	@Override
	public void actionPerformed(ActionEvent action) {

		// calling the model to use the method serchMember
		model = new model();
		String email = getEmail();

		if (action.getActionCommand().equals("search")) {

			// Get a connection to the database
			String[] columnNames = new String[] { "Member ID", "First name", "Last name", "Email", "Member Type",
					"Card Number", "Card Exp Date" };
			// Setting the data into the array of data
			String[][] data = new String[5][columnNames.length];
			// Surround it with a JScroll pane
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(29, 187, 608, 343);
			contentPane.add(scrollPane);
			// populating the data trhought the model
			data = model.SearchMember(email);
			// creating the Jtable
			table = new JTable(data, columnNames);
			scrollPane.setViewportView(table);

		}
	}
}
