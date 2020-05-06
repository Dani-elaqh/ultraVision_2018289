package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import controller.MemberReg;
import controller.controller;

import java.awt.Font;
import javax.swing.JButton;

public class CustomerMenu extends JFrame {

	private JPanel contentPane;
	
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tf3;
	private JTextField tf4;
	JComboBox <MemberReg>comboBox;
	private controller controllerInternalRef;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public CustomerMenu (controller controller) {
		this.controllerInternalRef = controller;
		
	
//	}
//
//	/**
//	 * Create the frame.
//	 */
//	public CustomerMenu() {
		
		JFrame frame = new JFrame();
		frame.setVisible(true);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 874, 634);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		this.setVisible(true);
		this.validate();
		this.repaint();
		
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(50, 70, 91, 33);
		contentPane.add(lblName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(50, 116, 91, 25);
		contentPane.add(lblLastName);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(50, 154, 91, 25);
		contentPane.add(lblPhone);
		
		JLabel lblTypeOfMember = new JLabel("Type of Member");
		lblTypeOfMember.setBounds(50, 192, 113, 33);
		contentPane.add(lblTypeOfMember);
		
		JLabel lblCardNumber = new JLabel("Card Number");
		lblCardNumber.setBounds(50, 238, 91, 33);
		contentPane.add(lblCardNumber);
		
		JLabel lblCardExpDate = new JLabel("Card exp. Date");
		lblCardExpDate.setBounds(50, 305, 91, 25);
		contentPane.add(lblCardExpDate);
		
		tf1 = new JTextField();
		tf1.setBounds(170, 117, 138, 22);
		contentPane.add(tf1);
		tf1.setColumns(10);
		
		tf2 = new JTextField();
		tf2.setText("");
		tf2.setBounds(168, 155, 140, 22);
		contentPane.add(tf2);
		tf2.setColumns(10);
		
		comboBox = new JComboBox<MemberReg>();
		comboBox.setModel(new DefaultComboBoxModel(MemberReg.values()));
		comboBox.setBounds(170, 197, 138, 22);
		contentPane.add(comboBox);
		
		tf3 = new JTextField();
		tf3.setBounds(171, 255, 137, 22);
		contentPane.add(tf3);
		tf3.setColumns(10);
		
		tf4 = new JTextField();
		tf4.setBounds(171, 306, 137, 22);
		contentPane.add(tf4);
		tf4.setColumns(10);
		
		JLabel lblRegsiterNewCustomer = new JLabel("Register new Customer");
		lblRegsiterNewCustomer.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 16));
		lblRegsiterNewCustomer.setBounds(63, 24, 245, 33);
		contentPane.add(lblRegsiterNewCustomer);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 16));
		btnRegister.setBounds(97, 397, 156, 49);
		contentPane.add(btnRegister);
		
		JButton btnUpdateCustomer = new JButton("Update Customer");
		btnUpdateCustomer.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 13));
		btnUpdateCustomer.setBounds(516, 134, 283, 65);
		contentPane.add(btnUpdateCustomer);
		
		textField = new JTextField();
		textField.setBounds(171, 75, 137, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		frame.validate();
		frame.repaint();
	
	}
	

	public String getFirstName() {
		return textField.getText();
	}
	
	public String getLastName() {

		return tf1.getText();
		
	}
	public String gettype() {
		return  ((MemberReg)comboBox.getSelectedItem()).gettype();
	}
	public String getPhone() {
		
		return tf2.getText();
	}
	
	public String getCard() {
		 return tf3.getText();
	}
	
	public String getdate() {
		return tf4.getText();
	}
	
	
}


