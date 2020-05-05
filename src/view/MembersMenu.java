package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.controller;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MembersMenu extends JFrame {

	private JPanel contentPane;
	
	private controller controllerInternalRef;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

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
		
		JFrame frame = new JFrame();
		frame.setVisible(true);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 450, 300);
		frame.setSize(600, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		frame.validate();
	    frame.repaint();
		
		JButton btnButton = new JButton("Update Customer data");
		btnButton.setForeground(SystemColor.textHighlight);
		btnButton.setBackground(SystemColor.textHighlight);
		btnButton.addActionListener( (ActionListener)controllerInternalRef);
		btnButton.setActionCommand("Update Customer data");
		btnButton.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 16));
		btnButton.setBounds(505, 146, 269, 53);
		contentPane.add(btnButton);
		
		JButton btnNewButton_1 = new JButton("Register new customer");
		btnNewButton_1.setForeground(SystemColor.textHighlight);
		btnNewButton_1.setBackground(SystemColor.textHighlight);
		btnNewButton_1.addActionListener((ActionListener)controllerInternalRef);
		btnNewButton_1.setActionCommand("Register new customer");
		btnNewButton_1.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 18));
		btnNewButton_1.setBounds(54, 353, 290, 53);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(54, 50, 56, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblLastName = new JLabel("Last name");
		lblLastName.setBounds(54, 94, 68, 16);
		contentPane.add(lblLastName);
		
		JLabel lblPhoneNumber = new JLabel("Phone number");
		lblPhoneNumber.setBounds(54, 138, 95, 16);
		contentPane.add(lblPhoneNumber);
		
		JLabel lblMemberType = new JLabel("Member type");
		lblMemberType.setBounds(54, 183, 84, 16);
		contentPane.add(lblMemberType);
		
		JLabel lblCardNumber = new JLabel("Card number");
		lblCardNumber.setBounds(54, 224, 95, 16);
		contentPane.add(lblCardNumber);
		
		JLabel lblExpirationDate = new JLabel("Expiration date");
		lblExpirationDate.setBounds(54, 267, 95, 16);
		contentPane.add(lblExpirationDate);
		
		textField = new JTextField();
		textField.setBounds(149, 43, 152, 31);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(149, 87, 152, 31);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(149, 131, 152, 31);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(149, 176, 152, 31);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(149, 218, 152, 29);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(149, 260, 152, 31);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		
		this.invalidate();
		this.repaint();
	}
}
