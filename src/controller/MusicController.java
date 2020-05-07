package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.MusicTable;

public class MusicController implements ActionListener{

	MusicTable music;
	
	public MusicController () {
		
		music = new MusicTable(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
