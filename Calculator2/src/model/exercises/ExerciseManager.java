package model.exercises;

import java.util.ArrayList;
import java.util.Random;

import model.dto.Exercise;
import model.dto.ExerciseSettings;

/**
 * @Autor: Jef Beyens
 * @Date: 16/10/2016
 * @Project: Calculator
 * @Purpose: BusinessComponent class
 *  --> The purpose of this class is to manage exercises. 
 *  It must keep a record of all exercises during the current test.
 *  It must also ask the generator for exercises and ask the calculator to evaluate them.
 */

public class ExerciseManager {
	private ExerciseGenerator generator;
	private ArrayList<Exercise> exercises = new ArrayList<>();
	private int NrOfCorrectQuestions = 0;

	public ExerciseManager(ExerciseSettings settings) {
		generator = new ExerciseGenerator(settings);
	}
	

	// Method to let the exercise generator generate exercises.
	public void loadExercises() throws Exception
	{
		exercises = generator.getExercises();
	}
	
	// Method to evaluate the answer
	public boolean evaluateReply(Exercise exercise, double userReply) throws Exception
	{
		return userReply == Calculator.doCalculation(exercise);
	}
	
	public void setMaxRange(double number) {
		generator.getSettings().setMaxRange(number);
	}
	
	public void isNegativeAllowed(boolean allowNegativeNumbers) {
		ExerciseSettings settings = generator.getSettings();
		
		settings.setMinRange(-1.0 * settings.getMaxRange());
	}
}
