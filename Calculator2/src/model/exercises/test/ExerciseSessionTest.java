package model.exercises.test;

import org.junit.Before;
import org.junit.Test;

import model.exercises.Calculator;
import model.exercises.ExerciseSettings;
import model.exercisesFactory.Exercise;

/**
 * @Autor: Jef Beyens & Ben Vandevorst
 * @Date: 29/10/2016
 * @Project: Calculator
 * @Purpose: manage exercises
 *  --> The purpose of this class is to manage exercises. 
 */
public class ExerciseSessionTest {
	private ExerciseSettings settings;
	private int boundInteger;
	private double boundRange;
	private String[] operators;
	
	@Before
	public void setUp(){
		boundInteger = 10;
		boundRange = 1000;
		operators = new String[] {"+","-","/"};
		settings = new ExerciseSettings(-1 * boundRange, boundRange, boundInteger, boundInteger, operators);
	}

	/*
	@Test(expected=IllegalArgumentException.class)
	public void test_division_deler0_wordt_niet_aanvaard() throws Exception {
		Calculator.doCalculation(testGetal, 0, Calculator.DIV);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void test_division_deler0_wordt_niet_aanvaard() throws Exception {
		Calculator.doCalculation(testGetal, 0, Calculator.DIV);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void test_division_deler0_wordt_niet_aanvaard() throws Exception {
		Calculator.doCalculation(testGetal, 0, Calculator.DIV);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void test_division_deler0_wordt_niet_aanvaard() throws Exception {
		Calculator.doCalculation(testGetal, 0, Calculator.DIV);
	}
}
public class ExerciseSession {
	// PRIVATE MEMBERS
	private ArrayList<Exercise> exerciseList;
	private int exerciseCounter;
	private boolean isRunning;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
    private DecimalFormat format2nrs = new DecimalFormat("00");
	
	public ExerciseSession(ExerciseSettings settings) {
		exerciseList = new ArrayList<Exercise>();
		generateExercises(settings);
		isRunning = true;
		startTime = LocalDateTime.now();
		exerciseCounter = 0;
	}

	public Exercise getNextExercise() {
		if (exerciseCounter >= exerciseList.size())
			return null;
		return exerciseList.get(exerciseCounter++);
	} 
	
	public String getEndResult() {
		// End exercise setting:
		if (isRunning) {
			isRunning = false;
			endTime = LocalDateTime.now();
		}
		
		// Calculate score:
		int correct = 0;
		for (Exercise exercise : exerciseList) {
			correct += exercise.isCorrectReplied() ? 1 : 0;
		}
	    int nrOfExercises = exerciseList.size();
	    
	    // Calculate time spent:
	    String timeSpentHHMMSS = getTimeDifference();
					

		return "Eindscore oefeningen: " + correct + "/" + nrOfExercises
				+ "\nTijd gespendeerd: " + timeSpentHHMMSS;
	} */
}