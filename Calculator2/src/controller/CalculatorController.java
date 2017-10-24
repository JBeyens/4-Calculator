package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import utilities.PropertyFileReader;
import values.DefaultSettings;
import view.MainView;

public class CalculatorController {
	private MainView view;
	private PropertyFileReader propertyReader;
	
	public CalculatorController(){
		view = new MainView();
	}
	
	public void startController(){
		propertyReader = PropertyFileReader.getPropertiesFile(DefaultSettings.stringPath.getValue());
		view.setTfMaxNumber(propertyReader.getProperty("maximumNumber"));
		
		view.setVisible(true);
		view.addActionListener(new StartExerciseListener());
	}
	
	private class StartExerciseListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
		}
	}
}
