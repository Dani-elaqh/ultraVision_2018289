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
	private JPanel contentPane_1;
	
	private controller controllerInternalRef;
	private JTextField tf;
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tf3;
	private JTextField tf4;

		
	
	public MembersMenu (controller controller) {
		this.controllerInternalRef = controller;
	
	
	}
	
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
		frame.setBounds(100, 100, 769, 601);
		contentPane_1 = new JPanel();
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane_1);

		
		
		this.validate();
		this.repaint();
		contentPane_1.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		lblName.setBounds(28, 92, 36, 19);
		contentPane_1.add(lblName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		lblLastName.setBounds(28, 139, 81, 19);
		contentPane_1.add(lblLastName);
		
		JLabel lblPhoneNumber = new JLabel("Phone number");
		lblPhoneNumber.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		lblPhoneNumber.setBounds(28, 193, 108, 19);
		contentPane_1.add(lblPhoneNumber);
		
		JLabel lblMemberType = new JLabel("Member Type");
		lblMemberType.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		lblMemberType.setBounds(28, 232, 99, 19);
		contentPane_1.add(lblMemberType);
		
		JLabel lblCardNumber = new JLabel("Card Number");
		lblCardNumber.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		lblCardNumber.setBounds(28, 284, 99, 19);
		contentPane_1.add(lblCardNumber);
		
		JLabel lblCardExpDate = new JLabel("Card Exp. Date");
		lblCardExpDate.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 15));
		lblCardExpDate.setBounds(28, 331, 126, 19);
		contentPane_1.add(lblCardExpDate);
		
		tf= new JTextField();
		tf.setBounds(178, 91, 116, 22);
		contentPane_1.add(tf);
		tf.setColumns(10);
		
		tf1 = new JTextField();
		tf1.setBounds(178, 138, 116, 22);
		contentPane_1.add(tf1);
		tf1.setColumns(10);
		
		tf2 = new JTextField();
		tf2.setBounds(178, 192, 116, 22);
		contentPane_1.add(tf2);
		tf2.setColumns(10);
		
		//JCombobox for the enum list tyoes of members
		MemberReg [] list = MemberReg.values();	
		JComboBox <MemberReg>comboBox = new JComboBox<MemberReg>();
		comboBox.setSelectedItem(null);
		comboBox.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 13));
		comboBox.setBounds(178, 231, 116, 22);
		contentPane_1.add(comboBox);
		comboBox.addActionListener( (ActionListener)controllerInternalRef);
		String type = comboBox.getSelectedItem().toString();
		setType(type);
		
		
		//Text fields for the staff input to create a new member
		tf3 = new JTextField();
		tf3.setBounds(178, 283, 116, 22);
		contentPane_1.add(tf3);
		tf3.setColumns(10);
		
		tf4 = new JTextField();
		tf4.setBounds(178, 330, 116, 22);
		contentPane_1.add(tf4);
		tf4.setColumns(10);
		
		JButton btrc = new JButton("Register new customer");
		btrc.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 17));
		btrc.setBounds(51, 424, 243, 58);
		contentPane_1.add(btrc);
		btrc.addActionListener( (ActionListener)controllerInternalRef);
		btrc.setActionCommand("new");
		
		JButton btnUpdateCustomer = new JButton("Update Customer");
		btnUpdateCustomer.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 17));
		btnUpdateCustomer.setBounds(519, 113, 183, 29);
		contentPane_1.add(btnUpdateCustomer);
		
		JLabel lblNewCustomer = new JLabel("New customer");
		lblNewCustomer.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 16));
		lblNewCustomer.setBounds(79, 13, 183, 39);
		contentPane_1.add(lblNewCustomer);
		
		
		
//		String [] list = {"Music", "TV", "premuin"};
//		JComboBox <String> JC = new JComboBox <String> (list);
//		contentPane_1.add(JC);
		
		
		
	
	}
	

	
	public String getst() {
		return  value.getText();
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
	
	public String getCard() {
		 return tf3.getText();
	}
	
	public String getdate() {
		return tf4.getText();
	}
	
	
}
