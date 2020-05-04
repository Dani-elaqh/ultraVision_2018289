package view;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import controller.Staff;
import controller.controller;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;

public class StaffMenu extends JFrame {

	private JPanel contentPane;
	private controller controllerInternalRef;

	public StaffMenu (controller controller) {
		this.controllerInternalRef = controller;
	}
	

	/**
	 * Create the frame.
	 * @wbp.parser.constructor
	 */
	public StaffMenu(Staff userLogged) {
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 823, 742);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 204, 255));
		contentPane.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(123, 104, 238)));
		setContentPane(contentPane);
		
		JButton btnCust = new JButton("Members");
		btnCust.setBounds(12, 52, 195, 73);
		btnCust.setForeground(new Color(0, 0, 0));
		btnCust.setSelectedIcon(null);
		btnCust.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 15));
		btnCust.setBackground(Color.WHITE);
		btnCust.setHorizontalAlignment(SwingConstants.LEADING);
		btnCust.setIcon(new ImageIcon("C:\\Users\\daniq\\eclipse-workspace\\Newworkspace OOC\\ultraVision_2018289\\icons\\poeple small.png"));
		btnCust.addActionListener( (ActionListener)controllerInternalRef);
		btnCust.setActionCommand("Members");
		
		contentPane.setLayout(null);
		contentPane.add(btnCust);
		
		JButton btnEntertaiment = new JButton("Entertaiment");
		btnEntertaiment.setBounds(268, 52, 205, 73);
		btnEntertaiment.addActionListener((ActionListener)controllerInternalRef);
		btnEntertaiment.setActionCommand("Entertaiment");
			
		btnEntertaiment.setIcon(new ImageIcon("C:\\Users\\daniq\\eclipse-workspace\\Newworkspace OOC\\ultraVision_2018289\\icons\\folder-video-icon (1).png"));
		btnEntertaiment.setHorizontalAlignment(SwingConstants.LEADING);
		btnEntertaiment.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 15));
		btnEntertaiment.setBackground(new Color(224, 255, 255));
		contentPane.add(btnEntertaiment);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(558, 52, 205, 73);
		btnSearch.setIcon(new ImageIcon("C:\\Users\\daniq\\eclipse-workspace\\Newworkspace OOC\\ultraVision_2018289\\icons\\Search-icon.png"));
		btnSearch.setHorizontalAlignment(SwingConstants.LEADING);
		btnSearch.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 15));
		btnSearch.setBackground(new Color(224, 255, 255));
		contentPane.add(btnSearch);
		btnSearch.addActionListener((ActionListener)controllerInternalRef);
		btnSearch.setActionCommand("Search");
		
		
		
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
}
