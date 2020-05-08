package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.MenuController;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import java.awt.Color;

public class Menu extends JFrame {

	private JPanel contentPane;
	private MenuController controllerInternalRef;
	
	public Menu(MenuController controllerInternalRef) {
		
		
		
		JFrame  frame = new JFrame();
		frame.setVisible(true);
		frame.setTitle("UltraVision");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 732, 530);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(224, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton membt = new JButton("Members");
		membt.setBackground(new Color(135, 206, 250));
		membt.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 18));
		membt.setActionCommand("Members");
		membt.setBounds(37, 187, 195, 57);
		contentPane.add(membt);
		membt.addActionListener((ActionListener)controllerInternalRef);
		membt.setActionCommand("Members");
		
		JButton enterbt = new JButton("Entertainment");
		enterbt.setBackground(new Color(135, 206, 250));
		enterbt.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 18));
		enterbt.setActionCommand("entertaiment");
		enterbt.setBounds(451, 187, 189, 57);
		contentPane.add(enterbt);
		enterbt.addActionListener((ActionListener)controllerInternalRef);
		enterbt.setActionCommand("entertaiment");
		
		JLabel lblUltraVision = new JLabel("Ultra Vision");
		lblUltraVision.setForeground(new Color(199, 21, 133));
		lblUltraVision.setBackground(new Color(153, 50, 204));
		lblUltraVision.setFont(new Font("Lucida Sans Typewriter", Font.BOLD | Font.ITALIC, 22));
		lblUltraVision.setBounds(261, 53, 171, 65);
		contentPane.add(lblUltraVision);
		
		frame.validate();
		frame.repaint();
	}


}
