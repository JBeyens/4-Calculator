package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import model.exercises.ExerciseManager;
import model.exercises.ExerciseSettings;
import model.properties.PropertyManager;
import values.DefaultSettings;
import view.MainView;

public class CalculatorController {
	private MainView view;
	private PropertyManager propertyManager;
	private ExerciseManager exerciseManager;
	
	public CalculatorController(){
		view = new MainView();
		propertyManager = PropertyManager.CreationMethod();
	}
	
	public void startController(){
		initializeProperties();
		view.setVisible(true);
		view.setSize(450, 350);
		view.addActionListener(new StartExerciseListener());
		view.addExerciseActionListener(new ExerciseListener());
	}
	
	private void initializeProperties(){
		view.setTfMaxNumber(propertyManager.getProperty("maximumNumber").toString());
		view.setTfMinNumber(propertyManager.getProperty("minimumNumber").toString());
		view.setTfNrOfDecimals(propertyManager.getProperty("nrOfDecimals").toString());
		view.setTfNrOfQuestions(propertyManager.getProperty("nrOfQuestions").toString());
		view.setcbNegative(Boolean.parseBoolean(propertyManager.getProperty("isNegative")));
		
		String[] operators = propertyManager.getProperty("operators").split(",");
		
		view.setRbAddition(Arrays.stream(operators).anyMatch("+"::equals));
		view.setRbSubstraction(Arrays.stream(operators).anyMatch("-"::equals));
		view.setRbMultiplication(Arrays.stream(operators).anyMatch("*"::equals));
		view.setRbDivision(Arrays.stream(operators).anyMatch("/"::equals));
	}
	
	private class StartExerciseListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			//Code for userinput not yet implemented
			ExerciseSettings settings = new ExerciseSettings();
			settings.setMaxRange(Integer.parseInt(view.getTfMaxNumber()));
			settings.setMinRange(Integer.parseInt(view.getTfMinNumber()));
			settings.setNrDecimals(Integer.parseInt(view.getTfNrOfDecimals()));
			settings.setNrOfExercises(Integer.parseInt(view.getTfNrOfQuestions()));
			
			//Needed to add/remove items to list => ExcerciseSettings needs String[] no ArrayList
			ArrayList<String> tempOperators = new ArrayList();
			
			//Operators are hard coded
			//Possible solution => seperate enum for operators and call these in methods
			if(view.getRbAddition())
				tempOperators.add("+");
			
			if(view.getRbSubstraction())
				tempOperators.add("-");
			
			if(view.getRbMultiplication())
				tempOperators.add("*");
			
			if(view.getRbDivision()){
				tempOperators.add("/");
			}
			
			String[] operators = new String[tempOperators.size()];
			operators = tempOperators.toArray(operators);
			settings.setOperators(operators);
			
			exerciseManager = ExerciseManager.creationMethod();
		}
	}
	
	private class ExerciseListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			
		}
	}
}
