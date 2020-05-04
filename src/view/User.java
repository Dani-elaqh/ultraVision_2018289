package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.MatteBorder;

import controller.controller;
import ultraVision_model.model;

import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

public class User extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	
	private controller controllerInternalRef;
	private JPasswordField passwordField;
	
	

	
	public User(controller controller) {
		
		
		
		this.controllerInternalRef = controller;
		
		setForeground(SystemColor.textHighlight);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\daniq\\eclipse-workspace\\Newworkspace OOC\\ultraVision_2018289\\icons\\Cjdowner-Cryptocurrency-Genesis-Vision.ico"));
		setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 17));
		setBackground(SystemColor.controlDkShadow);
		setTitle("Ultra Vision");
		getContentPane().setLayout(null);
		
		JLabel lblUserId = new JLabel("Staff ID");
		lblUserId.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 18));
		lblUserId.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(153, 153, 255)));
		lblUserId.setBounds(83, 73, 106, 31);
		getContentPane().add(lblUserId);
		
		JLabel lblWelcomeStaff = new JLabel("Welcome Staff");
		lblWelcomeStaff.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 17));
		lblWelcomeStaff.setBounds(143, 13, 139, 31);
		getContentPane().add(lblWelcomeStaff);
		
		JLabel lblCode = new JLabel("Code");
		lblCode.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 18));
		lblCode.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(153, 153, 255)));
		lblCode.setBounds(83, 122, 106, 31);
		getContentPane().add(lblCode);
		
		textField = new JTextField();
		textField.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 13));
		textField.setColumns(10);
		textField.setBounds(250, 73, 116, 34);
		getContentPane().add(textField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBackground(new Color(100, 149, 237));
		btnLogin.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 16));
		btnLogin.setBounds(171, 184, 97, 25);
		getContentPane().add(btnLogin);
		btnLogin.addActionListener((ActionListener)controllerInternalRef);
		btnLogin.setActionCommand("Login");
		
		
		passwordField = new JPasswordField();
		passwordField.setBounds(250, 122, 116, 31);
		getContentPane().add(passwordField);
		JFrame frame = new JFrame();
		this.setVisible(true);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		this.validate();
		this.repaint();
	}
	
	
	public String getStaffID() {
		return textField.getText();
	}
	
	public String getCode() {
		return passwordField.getText().toString();
	}
}
