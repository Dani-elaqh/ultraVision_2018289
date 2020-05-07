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

public class Menu extends JFrame {

	private JPanel contentPane;
	private MenuController controllerInternalRef;
	
	public Menu(MenuController controllerInternalRef) {
		
		
		
		JFrame  frame = new JFrame();
		frame.setVisible(true);
		frame.setTitle("UltraVision");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 719, 435);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton membt = new JButton("Members");
		membt.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 18));
		membt.setActionCommand("Members");
		membt.setBounds(37, 187, 195, 57);
		contentPane.add(membt);
		membt.addActionListener((ActionListener)controllerInternalRef);
		membt.setActionCommand("Members");
		
		JButton enterbt = new JButton("Entertaiment");
		enterbt.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 18));
		enterbt.setActionCommand("entertaiment");
		enterbt.setBounds(451, 187, 189, 57);
		contentPane.add(enterbt);
		enterbt.addActionListener((ActionListener)controllerInternalRef);
		enterbt.setActionCommand("entertaiment");
		
		frame.validate();
		frame.repaint();
	}


}
