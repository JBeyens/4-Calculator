package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.MainView;

public class CalculatorController {
	private MainView view;
	
	public CalculatorController(){
		view = new MainView();
	}
	
	public void startController(){
		view.setVisible(true);
		view.addActionListener(new StartExerciseListener());
	}
	
	private class StartExerciseListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
		}
	}
}
