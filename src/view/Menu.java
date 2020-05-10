package view;

//Class in charge of the GUi for the first window for the program, shows 4 options 
//Members, entertainment, search for a customer and registering a rent title
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.MenuController;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;

public class Menu extends JFrame {

	private JPanel contentPane;
	private MenuController controllerInternalRef;
	
	public Menu(MenuController controllerInternalRef) {
		//internal reference of the controller 
		this.controllerInternalRef = controllerInternalRef;
		
		//Attributes and components for this window
		JFrame  frame = new JFrame();
		frame.setBackground(new Color(204, 204, 255));
		frame.setVisible(true);
		frame.setTitle("UltraVision");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 732, 530);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton membt = new JButton("Members");
		membt.setBorder(new LineBorder(new Color(135, 206, 235), 3, true));
		membt.setForeground(new Color(0, 0, 139));
		membt.setBackground(SystemColor.activeCaption);
		membt.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 18));
		membt.setBounds(37, 187, 195, 57);
		contentPane.add(membt);
		membt.addActionListener((ActionListener)controllerInternalRef);
		membt.setActionCommand("Members");
		
		JButton enterbt = new JButton("Entertainment");
		enterbt.setBorder(new LineBorder(new Color(135, 206, 235), 3, true));
		enterbt.setForeground(new Color(0, 0, 128));
		enterbt.setBackground(SystemColor.activeCaption);
		enterbt.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 18));
		enterbt.setBounds(451, 187, 189, 57);
		contentPane.add(enterbt);
		enterbt.addActionListener((ActionListener)controllerInternalRef);
		enterbt.setActionCommand("entertainment");
		
		JLabel lblUltraVision = new JLabel("Ultra Vision");
		lblUltraVision.setForeground(new Color(199, 21, 133));
		lblUltraVision.setBackground(new Color(153, 50, 204));
		lblUltraVision.setFont(new Font("Lucida Sans Typewriter", Font.BOLD | Font.ITALIC, 22));
		lblUltraVision.setBounds(261, 53, 171, 65);
		contentPane.add(lblUltraVision);
		
		JButton btnReg = new JButton("Register Rent");
		btnReg.setBorder(new LineBorder(new Color(135, 206, 235), 3, true));
		btnReg.setForeground(new Color(0, 0, 128));
		btnReg.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 18));
		btnReg.setBackground(SystemColor.activeCaption);
		btnReg.addActionListener((ActionListener)controllerInternalRef);
		btnReg.setActionCommand("register");
		btnReg.setBounds(445, 312, 195, 57);
		contentPane.add(btnReg);
		
		JButton btnSearch = new JButton("Search Customers");
		btnSearch.setForeground(new Color(0, 0, 139));
		btnSearch.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 18));
		btnSearch.setBorder(new LineBorder(new Color(135, 206, 235), 3, true));
		btnSearch.setBackground(SystemColor.activeCaption);
		btnSearch.addActionListener((ActionListener)controllerInternalRef);
		btnSearch.setActionCommand("search");
		btnSearch.setBounds(37, 312, 195, 57);
		contentPane.add(btnSearch);
		
		frame.validate();
		frame.repaint();
	}
}
