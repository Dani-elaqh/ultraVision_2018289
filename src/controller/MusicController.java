package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ultraVision_model.model;
import view.MusicTable;
import view.MusicTable;

public class MusicController implements ActionListener{

	MusicTable music;
	model Model;
	
	public MusicController () {
		
		music = new MusicTable();
		Model = new model();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
