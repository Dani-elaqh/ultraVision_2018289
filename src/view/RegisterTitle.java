package view;
//Class for the GUI to display the registration for a rent title 
//This class is also a action Listener 

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.MemberReg;
import controller.RegRentController;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class RegisterTitle extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tfMember;
	private JTextField tfTitle;
	private JTextField tfDate;
	JComboBox<MemberReg> comboBox;
	private RegRentController controllerInternalRef;
	private JButton btnMlovers;
	private JButton btnTv;
	private JButton btnVideo;
	private JButton btnPremium;
	private JButton btnLive;
	private JTextField tfTitleID;

	public RegisterTitle(RegRentController controller) {
		//Reference controller local
		this.controllerInternalRef = controller;
		
		//Attributes and components for the window 
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 837, 485);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		frame.setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblRegisterTitles = new JLabel("Register titles");
		lblRegisterTitles.setBackground(new Color(204, 204, 255));
		lblRegisterTitles.setForeground(new Color(128, 0, 128));
		lblRegisterTitles.setFont(new Font("Lucida Sans Typewriter", Font.BOLD, 18));
		lblRegisterTitles.setBounds(320, 28, 196, 55);
		contentPane.add(lblRegisterTitles);

		JLabel lblType = new JLabel("Member Type");
		lblType.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 17));
		lblType.setBounds(136, 150, 127, 27);
		contentPane.add(lblType);
		
		comboBox = new JComboBox<MemberReg>();
		comboBox.setModel(new DefaultComboBoxModel(MemberReg.values()));
		comboBox.setBounds(305, 152, 127, 26);
		contentPane.add(comboBox);
		
		JButton selectButton = new JButton("Select");
		selectButton.setBorder(new LineBorder(new Color(100, 149, 237), 2, true));
		selectButton.setBounds(511, 153, 97, 25);
		contentPane.add(selectButton);
		selectButton.addActionListener((ActionListener) this);
		selectButton.setActionCommand("select");

		

		

		JLabel lblMember = new JLabel("Member ID");
		lblMember.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 17));
		lblMember.setBounds(79, 214, 105, 27);
		contentPane.add(lblMember);

		tfMember = new JTextField();
		tfMember.setColumns(10);
		tfMember.setBounds(62, 254, 127, 27);
		contentPane.add(tfMember);
		
		JLabel lblTitleID = new JLabel("Title ID");
		lblTitleID.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 17));
		lblTitleID.setBounds(237, 214, 105, 27);
		contentPane.add(lblTitleID);
		
		tfTitleID = new JTextField();
		tfTitleID.setColumns(10);
		tfTitleID.setBounds(224, 254, 127, 27);
		contentPane.add(tfTitleID);

		JLabel lblTitle = new JLabel("Title");
		lblTitle.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 17));
		lblTitle.setBounds(447, 214, 69, 27);
		contentPane.add(lblTitle);

		tfTitle = new JTextField();
		tfTitle.setColumns(10);
		tfTitle.setBounds(386, 254, 196, 27);
		contentPane.add(tfTitle);

		JLabel lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 17));
		lblDate.setBounds(665, 214, 69, 27);
		contentPane.add(lblDate);

		tfDate = new JTextField();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		tfDate.setText(dtf.format(now));
		tfDate.setColumns(10);
		tfDate.setBounds(613, 254, 141, 27);
		//System.out.println(); 
		contentPane.add(tfDate);
		
		btnMlovers = new JButton("MLovers");
		btnMlovers.setBorder(new LineBorder(new Color(100, 149, 237), 2, true));
		btnMlovers.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 17));
		btnMlovers.addActionListener((ActionListener) controller);
		btnMlovers.setActionCommand("addMlover");
		btnMlovers.setBounds(38, 357, 127, 39);
		contentPane.add(btnMlovers);

		btnTv = new JButton("TvLovers");
		btnTv.setBorder(new LineBorder(new Color(100, 149, 237), 2, true));
		btnTv.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 17));
		btnTv.addActionListener((ActionListener) controller);
		btnTv.setActionCommand("addTv");
		btnTv.setBounds(517, 357, 127, 39);
		contentPane.add(btnTv);

		btnVideo = new JButton("VLovers");
		btnVideo.setBorder(new LineBorder(new Color(100, 149, 237), 2, true));
		btnVideo.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 17));
		btnVideo.addActionListener((ActionListener) controller);
		btnVideo.setActionCommand("addVideo");
		btnVideo.setBounds(364, 357, 127, 39);
		contentPane.add(btnVideo);

		btnPremium = new JButton("Premium");
		btnPremium.setBorder(new LineBorder(new Color(100, 149, 237), 2, true));
		btnPremium.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 17));
		btnPremium.addActionListener((ActionListener) controller);
		btnPremium.setActionCommand("addPremium");
		btnPremium.setBounds(667, 357, 127, 39);
		contentPane.add(btnPremium);

				
		btnLive = new JButton("LiveConcerts");
		btnLive.setBorder(new LineBorder(new Color(100, 149, 237), 2, true));
		btnLive.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 17));
		btnLive.addActionListener((ActionListener) controller);
		btnLive.setActionCommand("addConcert");
		btnLive.setBounds(191, 357, 153, 39);
		contentPane.add(btnLive);
		
		
		
		

		frame.validate();
		frame.repaint();
	}

	public String getMember() {
		return ((MemberReg) comboBox.getSelectedItem()).gettype();
	}
	
	public String getTitleID() {
		return tfTitleID.getText();
	}

	public String getTitle() {
		return tfTitle.getText();
	}

	public String getDate() {
		return tfDate.getText();
	}
	public String getId() {
		return tfMember.getText();
	}


	//Actions when the user choose the type of member, depending on th type of member the buttons can be anabled or disabled 
	@Override
	public void actionPerformed(ActionEvent action) {
		// TODO Auto-generated method stub
		
		
		if(action.getActionCommand().equals("select")) {
			
			String selected = comboBox.getSelectedItem().toString();
			
			if (selected.equals("MusicLovers")){
				comboBox.setActionCommand("MusicLovers");	
				btnMlovers.setEnabled(true);
				btnLive.setEnabled(true);
				btnTv.setEnabled(false);
				btnVideo.setEnabled(false);
				btnPremium.setEnabled(false);
			}
			
			else if(selected.equals("VideoLovers")){
				comboBox.setActionCommand("VideoLovers");
				btnMlovers.setEnabled(false);
				btnLive.setEnabled(false);
				btnTv.setEnabled(false);
				btnVideo.setEnabled(true);
				btnPremium.setEnabled(false);
			}
			
			else if(selected.equals("TvLover")){
				comboBox.setActionCommand("TvLover");
				btnMlovers.setEnabled(false);
				btnLive.setEnabled(false);
				btnTv.setEnabled(true);
				btnVideo.setEnabled(false);
				btnPremium.setEnabled(false);
			}
			
			else {
			
			comboBox.setActionCommand("Premium");
			btnMlovers.setEnabled(false);
			btnLive.setEnabled(false);
			btnTv.setEnabled(false);
			btnVideo.setEnabled(false);
			btnPremium.setEnabled(true);
			
			}
											
			
		}		
		
	
}
}
