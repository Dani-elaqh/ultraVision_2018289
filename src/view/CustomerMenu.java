package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import controller.MemberController;
import controller.MemberReg;
import controller.MenuController;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;

public class CustomerMenu extends JFrame {

	private JPanel contentPane;
	
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tf3;
	private JTextField tf4;
	JComboBox <MemberReg>comboBox;
	private MemberController controllerInternalRef;
	private JTextField textField;
	private JTextField tfId;
	private JTextField tfFn;
	private JTextField tfLn;
	private JTextField tfMail;
	private JTextField tfCard;
	private JTextField tfDate;
	JComboBox <MemberReg>comboBox_1;

	public CustomerMenu (MemberController controller) {
		this.controllerInternalRef = controller;
		
//Window to display the the options to add or update a customer
		
		JFrame frmMembersUltraVision = new JFrame();
		frmMembersUltraVision.setTitle("Members Ultra Vision");
		frmMembersUltraVision.setVisible(true);
		
		frmMembersUltraVision.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMembersUltraVision.setBounds(100, 100, 874, 634);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frmMembersUltraVision.setContentPane(contentPane);
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
		
		JLabel lblPhone = new JLabel("Email");
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
		lblRegsiterNewCustomer.setForeground(Color.ORANGE);
		lblRegsiterNewCustomer.setBackground(SystemColor.activeCaptionBorder);
		lblRegsiterNewCustomer.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 16));
		lblRegsiterNewCustomer.setBounds(63, 24, 245, 33);
		contentPane.add(lblRegsiterNewCustomer);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setForeground(SystemColor.textHighlight);
		btnRegister.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 16));
		btnRegister.setBounds(97, 397, 156, 49);
		contentPane.add(btnRegister);
		btnRegister.addActionListener((ActionListener)controller);
		btnRegister.setActionCommand("Members");
		
		JButton btnUpdateCustomer = new JButton("Update Customer");
		btnUpdateCustomer.setForeground(SystemColor.textHighlight);
		btnUpdateCustomer.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 13));
		btnUpdateCustomer.setBounds(577, 473, 183, 49);
		contentPane.add(btnUpdateCustomer);
		btnUpdateCustomer.addActionListener((ActionListener)controller);
		btnUpdateCustomer.setActionCommand("update");
		
		textField = new JTextField();
		textField.setBounds(171, 75, 137, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblupdate = new JLabel("Update Customer details ");
		lblupdate.setForeground(Color.RED);
		lblupdate.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 16));
		lblupdate.setBounds(539, 28, 257, 24);
		contentPane.add(lblupdate);
		
		JLabel lblFn = new JLabel("Name");
		lblFn.setBounds(463, 112, 91, 33);
		contentPane.add(lblFn);
		
		JLabel lblId = new JLabel("Member ID");
		lblId.setBounds(463, 70, 91, 33);
		contentPane.add(lblId);
		
		JLabel lblLn = new JLabel("Last Name");
		lblLn.setBounds(463, 158, 91, 25);
		contentPane.add(lblLn);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(463, 200, 91, 25);
		contentPane.add(lblEmail);
		
		JLabel lblType = new JLabel("Type of Member");
		lblType.setBounds(463, 250, 113, 33);
		contentPane.add(lblType);
		
		JLabel lblCard = new JLabel("Card Number");
		lblCard.setBounds(463, 301, 91, 33);
		contentPane.add(lblCard);
		
		JLabel lblDate = new JLabel("Card exp. Date");
		lblDate.setBounds(463, 357, 91, 25);
		contentPane.add(lblDate);
		
		tfId = new JTextField();
		tfId.setColumns(10);
		tfId.setBounds(602, 75, 137, 22);
		contentPane.add(tfId);
		
		tfFn = new JTextField();
		tfFn.setColumns(10);
		tfFn.setBounds(601, 117, 138, 22);
		contentPane.add(tfFn);
		
		tfLn = new JTextField();
		tfLn.setColumns(10);
		tfLn.setBounds(601, 157, 138, 22);
		contentPane.add(tfLn);
		
		tfMail = new JTextField();
		tfMail.setColumns(10);
		tfMail.setBounds(602, 197, 138, 22);
		contentPane.add(tfMail);
		
		tfCard = new JTextField();
		tfCard.setColumns(10);
		tfCard.setBounds(602, 306, 138, 22);
		contentPane.add(tfCard);
		
		tfDate = new JTextField();
		tfDate.setColumns(10);
		tfDate.setBounds(601, 358, 138, 22);
		contentPane.add(tfDate);
		
		comboBox_1 = new JComboBox<MemberReg>();
		comboBox_1.setModel(new DefaultComboBoxModel(MemberReg.values()));
		comboBox_1.setBounds(602, 255, 137, 22);
		contentPane.add(comboBox_1);
		
		frmMembersUltraVision.validate();
		frmMembersUltraVision.repaint();
	
	}
	
//This are the getters for the registration of a new customer into the system
	public String getFirstName() {
		return textField.getText();
	}
	
	public String getLastName() {

		return tf1.getText();
		
	}
	public String gettype() {
		return  ((MemberReg)comboBox.getSelectedItem()).gettype();
	}
	public String getEmail() {	
		return tf2.getText();
	}
	
	public String getCard() {
		 return tf3.getText();
	}
	
	public String getdate() {
		return tf4.getText();
	}
	
	
	//This are the getters for the Update customer 
	public String getId() {
		return tfId.getText();
	}
	
	public String getName() {
		return tfFn.getText();
	}
	
	public String getLname() {
		return tfLn.getText();
	}
	
	public String getMail() {
		return tfMail.getText();
	}
	
	public String getMember() {
		return ((MemberReg)comboBox.getSelectedItem()).gettype();
	}
	
	public String getCardN() {
		return tfCard.getText();
	}
	
	public String getExpDate() {
		return tfDate.getText();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}


