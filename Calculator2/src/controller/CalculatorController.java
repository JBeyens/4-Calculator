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
		view.setTfMaxNumber(propertyReader.getProperty("maximumNumber").toString());
		view.setTfMinNumber(propertyReader.getProperty("minimumNumber").toString());
		view.setTfNrOfDecimals(propertyReader.getProperty("nrOfDecimals").toString());
		view.setTfNrOfQuestions(propertyReader.getProperty("nrOfQuestions").toString());
		view.setVisible(true);
		view.setSize(400, 350);
		view.addActionListener(new StartExerciseListener());
	}
	
	private class StartExerciseListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
		}
	}
}
