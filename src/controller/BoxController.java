package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import ultraVision_model.model;
import view.TvBox;

public class BoxController implements ActionListener {
	
	model model;
	TvBox box;

	@Override
	public void actionPerformed(ActionEvent action) {
		
		this.box = new TvBox(this);
		model = new model();
		
	}

	
}
