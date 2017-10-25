package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import utilities.PropertyFileReader;
import values.DefaultSettings;
import view.MainView;

public class CalculatorController {
	private MainView view;
	private PropertyFileReader propertyReader;
	
	public CalculatorController(){
		view = new MainView();
		propertyReader = PropertyFileReader.getPropertiesFile(DefaultSettings.stringPath.getValue());
	}
	
	public void startController(){
		initializeProperties();
		view.setVisible(true);
		view.setSize(450, 350);
		view.addActionListener(new StartExerciseListener());
	}
	
	private void initializeProperties(){
		view.setTfMaxNumber(propertyReader.getProperty("maximumNumber").toString());
		view.setTfMinNumber(propertyReader.getProperty("minimumNumber").toString());
		view.setTfNrOfDecimals(propertyReader.getProperty("nrOfDecimals").toString());
		view.setTfNrOfQuestions(propertyReader.getProperty("nrOfQuestions").toString());
		
		String[] operators = propertyReader.getProperty("operators").split(",");
		
		view.setRbAddition(Arrays.stream(operators).anyMatch("+"::equals));
		view.setRbSubstraction(Arrays.stream(operators).anyMatch("-"::equals));
		view.setRbMultiplication(Arrays.stream(operators).anyMatch("*"::equals));
		view.setRbDivision(Arrays.stream(operators).anyMatch("/"::equals));
	}
	
	private class StartExerciseListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
		}
	}
}
