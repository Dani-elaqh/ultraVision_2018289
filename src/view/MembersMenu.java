package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.MemberReg;
import controller.controller;

import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;

public class MembersMenu extends JFrame {

	private JPanel contentPane;
	
	private controller controllerInternalRef;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	public MembersMenu (controller controller) {
		this.controllerInternalRef = controller;
	}

	

	/**
	 * Create the frame.
	 */
	public MembersMenu() {
		setTitle("Ultra Vision ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 821, 487);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		lblName.setBounds(71, 62, 69, 30);
		contentPane.add(lblName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		lblLastName.setBounds(71, 105, 91, 19);
		contentPane.add(lblLastName);
		
		JLabel lblPhoneNumber = new JLabel("Phone number");
		lblPhoneNumber.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		lblPhoneNumber.setBounds(71, 147, 116, 19);
		contentPane.add(lblPhoneNumber);
		
		JLabel lblMemberType = new JLabel("Member Type");
		lblMemberType.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		lblMemberType.setBounds(71, 198, 116, 19);
		contentPane.add(lblMemberType);
		
		JLabel lblCardNumber = new JLabel("Card Number");
		lblCardNumber.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		lblCardNumber.setBounds(71, 244, 99, 19);
		contentPane.add(lblCardNumber);
		
		JLabel lblCardExpDate = new JLabel("Card Exp. Date");
		lblCardExpDate.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		lblCardExpDate.setBounds(71, 290, 131, 19);
		contentPane.add(lblCardExpDate);
		
		textField = new JTextField();
		textField.setBounds(246, 67, 189, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(246, 104, 189, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(244, 146, 191, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		MemberReg [] list = MemberReg.values();		
		JComboBox <MemberReg>comboBox = new JComboBox<MemberReg>();
		comboBox.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 13));
		comboBox.setBounds(246, 196, 31, 22);
		contentPane.add(comboBox);
		
		textField_3 = new JTextField();
		textField_3.setBounds(246, 243, 189, 22);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(246, 289, 189, 22);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnRegisterNewCustomer = new JButton("Register new customer");
		btnRegisterNewCustomer.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 17));
		btnRegisterNewCustomer.setBounds(158, 374, 271, 53);
		contentPane.add(btnRegisterNewCustomer);
		
		JButton btnUpdateCustomer = new JButton("Update Customer");
		btnUpdateCustomer.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 17));
		btnUpdateCustomer.setBounds(567, 103, 213, 38);
		contentPane.add(btnUpdateCustomer);
		
		
		
//		String [] list = {"Music", "TV", "premuin"};
//		JComboBox <String> JC = new JComboBox <String> (list);
//		contentPane_1.add(JC);
		
		
//		JList<MemberReg> list = new JList();
//		for (MemberReg a : MemberReg.values())
//		list.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 13));
//		list.setBounds(149, 176, 152, 23);
//		contentPane_1.add(list);
		
		
		this.validate();
		this.repaint();
	}
	
	public String getName() {
		return tf.getText();
	}
	
	public String getLastName() {

		return tf1.getText();
		
	}
	
	public String getPhone() {
		
		return tf2.getText();
	}
	
	public String getMember() {
		 return tf3.getText();
	}
	
	public String getCard() {
		return tf4.getText();
	}
	
	public String getdate() {
		
		return tf5.getText();
		
	}
}
