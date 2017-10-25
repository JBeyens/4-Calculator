package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import model.properties.PropertyManager;
import utilities.PropertyFileReader;
import values.DefaultSettings;
import view.MainView;

public class CalculatorController {
	private MainView view;
	private PropertyManager propertyManager;
	
	public CalculatorController(){
		view = new MainView();
		propertyManager = PropertyManager.CreationMethod();
	}
	
	public void startController(){
		initializeProperties();
		view.setVisible(true);
		view.setSize(450, 350);
		view.addActionListener(new StartExerciseListener());
	}
	
	private void initializeProperties(){
		view.setTfMaxNumber(propertyManager.getProperty("maximumNumber").toString());
		view.setTfMinNumber(propertyManager.getProperty("minimumNumber").toString());
		view.setTfNrOfDecimals(propertyManager.getProperty("nrOfDecimals").toString());
		view.setTfNrOfQuestions(propertyManager.getProperty("nrOfQuestions").toString());
		
		String[] operators = propertyManager.getProperty("operators").split(",");
		
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
