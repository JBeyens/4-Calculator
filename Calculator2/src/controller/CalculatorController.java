package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import model.exercises.Calculator;
import model.exercises.ExerciseSession;
import model.exercises.ExerciseSettings;
import model.exercisesFactory.Exercise;
import model.properties.PropertyManager;
import values.NegativeComment;
import values.PositiveComment;
import view.MainView;


/**
 * 	@Author Ben Vandevorst & Jef Beyens
	@Datum 09/10/2017
	@Project Calculator
	@Doel Handles properties and user setting changes
		  Handles response from user
 */

public class CalculatorController {
	//Fields
	private MainView view;
	private PropertyManager propertyManager;
	private ExerciseSession exerciseSession;
	private ExerciseSettings settings;
	private Exercise currentExercise;
	
	
	//Constructor
	public CalculatorController(){
		view = new MainView();
		
		//Calling properties
		propertyManager = PropertyManager.CreationMethod();
	}
	
	//Set up view
	public void startController(){
		initializeProperties();
		view.setVisible(true);
		view.setSize(500, 350);
		view.addActionListener(new StartExerciseListener());
		view.addExerciseActionListener(new CheckExerciseListener());
	}
	
	
	//Load properties into TextField/Checkbox
	private void initializeProperties(){
		view.setTfMinNumber(propertyManager.getProperty("minimumNumber").toString());
		view.setTfMaxNumber(propertyManager.getProperty("maximumNumber").toString());	
		view.setTfNrOfDecimals(propertyManager.getProperty("nrOfDecimals").toString());
		view.setTfNrOfQuestions(propertyManager.getProperty("nrOfQuestions").toString());
		
		String[] operators = propertyManager.getProperty("operators").split(",");
		
		view.setRbAddition(Arrays.stream(operators).anyMatch("+"::equals));
		view.setRbSubstraction(Arrays.stream(operators).anyMatch("-"::equals));
		view.setRbMultiplication(Arrays.stream(operators).anyMatch("*"::equals));
		view.setRbDivision(Arrays.stream(operators).anyMatch("/"::equals));
	}
	
	
	/*
	 * Listener for START button
	 * Checking for setting input
	 * Saving properties
	 * Create ExerciseSettings/ExerciseSession
	 * Start Session
	 */
	private class StartExerciseListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			try {
				int maxRange = Integer.parseInt(view.getTfMaxNumber());
				int minRange = Integer.parseInt(view.getTfMinNumber());
				int nrOfDecimals = view.getTfNrOfDecimals();
				int nrOfExercises = view.getTfNrOfQuestions();
				
				ArrayList<String> tempOperators = new ArrayList<String>();
				
				if(view.getRbAddition())
					tempOperators.add("+");
				
				if(view.getRbSubstraction())
					tempOperators.add("-");
				
				if(view.getRbMultiplication())
					tempOperators.add("*");
				
				if(view.getRbDivision()){
					tempOperators.add("/");
				}
				
				if(tempOperators.isEmpty())
					throw new Exception("Gelieve ten minstenste 1 operator te kiezen!");
				
				String[] operators = new String[tempOperators.size()];
				operators = tempOperators.toArray(operators);
				
				propertyManager.setProperty("maximumNumber", view.getTfMaxNumber());
				propertyManager.setProperty("minimumNumber", view.getTfMinNumber());
				propertyManager.setProperty("nrOfDecimals", view.getTfNrOfDecimals().toString());
				propertyManager.setProperty("nrOfQuestions", view.getTfNrOfQuestions().toString());
				propertyManager.setProperty("operators", String.join(",", operators));
				
				settings = new ExerciseSettings(minRange, maxRange, nrOfDecimals, nrOfExercises, operators);
				exerciseSession = new ExerciseSession(settings);
				
				showNewExercise();
				view.setStartExerciseButton(false);
				view.setCheckAnswerButton(true);
			} catch (NumberFormatException e1) {
				e1.printStackTrace();
			} catch (Exception e1) {
				view.showMessage(e1.getMessage());
			}
		}
	}
	
	/*
	 * Listener for CONTROLEER button
	 * Parsing userInput
	 * Extra logic for handling decimals => rounding accuracy
	 * Prompt Negative/Positive feedback to user
	 */
	private class CheckExerciseListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			try {
				Double userInput = Double.parseDouble(view.getTfUserInput());
				
				if( Math.abs(userInput - Calculator.doCalculation(currentExercise)) < 0.000001){
					view.showMessage(PositiveComment.getRandom().getValue());
					currentExercise.setCorrectReplied(true);
				}
				else{
					view.showMessage(NegativeComment.getRandom().getValue());
				}
				
				showNewExercise();
				
				
			} catch (NumberFormatException e2) {
				view.showMessage("Gelieve een geldig getal als antwoord in te geven!");
			}
		}
	}

	
	/*
	 * Logic for handling a new Exercise
	 * Logic for handling end of Session
	 */
	private void showNewExercise(){
		currentExercise = exerciseSession.getNextExercise();
		if(currentExercise != null){
			view.setLabelStringExercise("Oefening " + currentExercise.getExerciseNumber());
			view.setLabelExercise(currentExercise.toString());
			view.setTfUserInput("");
		}
		else{
			view.setStartExerciseButton(true);
			view.setCheckAnswerButton(false);
			view.showMessage(exerciseSession.getEndResult());
		}
		
	}
}
