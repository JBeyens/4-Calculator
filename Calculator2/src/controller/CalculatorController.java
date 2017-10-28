package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import model.exercises.Calculator;
import model.exercises.ExerciseSession;
import model.exercises.ExerciseSettings;
import model.exercises.factory.Exercise;
import model.properties.PropertyManager;
import values.NegativeComment;
import values.PositiveComment;
import view.MainView;

public class CalculatorController {
	private MainView view;
	private PropertyManager propertyManager;
	private ExerciseSession exerciseSession;
	private ExerciseSettings settings;
	private Exercise currentExercise;
	private Random random;
	
	public CalculatorController(){
		view = new MainView();
		propertyManager = PropertyManager.CreationMethod();
		random = new Random();
	}
	
	public void startController(){
		initializeProperties();
		view.setVisible(true);
		view.setSize(500, 350);
		view.addActionListener(new StartExerciseListener());
		view.addExerciseActionListener(new CheckExerciseListener());
		view.addNextExerciseActionListener(new NextExerciseListener());
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
			try {
				settings = new ExerciseSettings();
				settings.setMaxRange(Integer.parseInt(view.getTfMaxNumber()));
				settings.setMinRange(Integer.parseInt(view.getTfMinNumber()));
				settings.setNrDecimals(Integer.parseInt(view.getTfNrOfDecimals()));
				settings.setNrOfExercises(Integer.parseInt(view.getTfNrOfQuestions()));
				
				ArrayList<String> tempOperators = new ArrayList();
				
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
				
				settings.setOperators(operators);
				
				exerciseSession = new ExerciseSession(random, settings);
				
				showNewExercise();
				view.setStartExerciseButton(false);
				view.setNextExerciseButton(true);
				view.setCheckAnswerButton(true);
			} catch (NumberFormatException e1) {
				e1.printStackTrace();
			} catch (Exception e1) {
				view.showMessage(e1.getMessage());
			}
		}
	}
	
	private class CheckExerciseListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			try {
				Double userInput = Double.parseDouble(view.getTfUserInput());
				
				if(userInput == Calculator.doCalculation(currentExercise)){
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
	
	private class NextExerciseListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			showNewExercise();
		}
	}
	
	private void showNewExercise(){
		currentExercise = exerciseSession.getNextExercise();
		if(currentExercise != null){
			view.setLabelExercise(currentExercise.toString());
			view.setTfUserInput("");
		}
		else{
			view.setStartExerciseButton(true);
			view.setNextExerciseButton(false);
			view.setCheckAnswerButton(false);
			view.showMessage(exerciseSession.getEndResult());
		}
		
	}
}
