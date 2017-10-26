package model.exercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.dto.Exercise;
import model.dto.ExerciseSettings;
import utilities.Randomizer;

/**
 * @Autor: Jef Beyens
 * @Date: 16/10/2016
 * @Project: Calculator
 * @Purpose: BusinessComponent class
 *  --> The purpose of this class is to generate and return 'exercise' objects.
 */
public class ExerciseGenerator {
	private ExerciseSettings settings;

	public ExerciseSettings getSettings() {
		return settings;
	}
	public void setSettings(ExerciseSettings settings) {
		this.settings = settings;
	}

	/*
	 * @param Settings object
	 */
	public ExerciseGenerator(ExerciseSettings settings) {
		this.settings = settings;
	}

	/*
	 * Method which generates the amount of exercises as indicated in the settings
	 */
	public ArrayList<Exercise> getExercises() throws Exception
	{
		ArrayList<Exercise> exercises = new ArrayList<Exercise>();
		
		for (int i=0; i < settings.getNrOfExercises(); i++)
		{   
			exercises.add(getExercise(settings.getMinRange(),settings.getMaxRange(), settings.getNrDecimals(), settings.getOperators()));
		}
		return exercises;
	}

	/*
	 * Method which generates a single exercise based on the settings
	 */
	private Exercise getExercise(double minRange, double maxRange, int decimals, String[] operator) throws Exception 
	{		
		//Exercise exercise = null;
		double operand1 = Randomizer.getRandomNumber(minRange, maxRange, decimals);
		double operand2 = Randomizer.getRandomNumber(minRange, maxRange, decimals);
		char operation = Randomizer.getRandomChar(operator);
		
//		switch (operation)
//		{
//		case '+':
//			exercise = getAddExercise(minRange, maxRange, decimals);
//			break;
//		case '-':
//			exercise = getSubExercise(minRange, maxRange, decimals);
//			break;
//		case '*':
//			exercise = getMultExercise(minRange, maxRange, decimals);
//			break;
//		case '/':
//			exercise = getDivExercise(minRange, maxRange, decimals);
//			break;
//			default:
//				throw new Exception("Invalid operator given.");
//		}
		
		return new Exercise(operand1,operand2, operation);
	}

//	/* Generates a 'DIVISION' exercise. 
//	 * The operands of the exercise will respect minRange and maxRange.
//	 * The result is not obligated to respect minRange and maxRange, however, 
//	 * if the user has not allowed negative numbers, then the substraction result will never be negative.
//	 */
//	private Exercise getDivExercise(double minRange, double maxRange, int decimals) {
//		double first = Randomizer.getRandomNumber(minRange, maxRange, decimals);
//		double second = Randomizer.getRandomNumber(minRange, maxRange, decimals);	
//
//		return new Exercise(first, second, "/");
//	}
//
//	/* Generates a 'MULTIPLICATION' exercise. 
//	 * The operands of the exercise will respect minRange and maxRange.
//	 * The result is not obligated to respect minRange and maxRange, however, 
//	 * if the user has not allowed negative numbers, then the substraction result will never be negative.
//	 */
//	private Exercise getMultExercise(double minRange, double maxRange, int decimals) {
//		double first = Randomizer.getRandomNumber(minRange, maxRange, decimals);
//		double second = Randomizer.getRandomNumber(minRange, maxRange, decimals);	
//
//		return new Exercise(first, second, "*");
//	}
//
//	/* Generates a 'SUBSTRACTION' exercise. 
//	 * The operands of the exercise will respect minRange and maxRange.
//	 * The result is not obligated to respect minRange and maxRange, however, 
//	 * if the user has not allowed negative numbers, then the substraction result will never be negative.
//	 */
//	private Exercise getSubExercise(double minRange, double maxRange, int decimals) {
//		double first = Randomizer.getRandomNumber(minRange, maxRange, decimals);
//		double second = Randomizer.getRandomNumber(minRange, maxRange, decimals);	
//		
//		if (minRange >= 0) {
//			double temp = Math.min(first, second);
//			first = Math.max(first, second);
//			second = temp;
//		}
//		
//		return new Exercise(first, second, "-");
//	}
//
//	/* Generates an 'ADDITION' exercise. 
//	 * The method ensures that both operands & result will be within range 
//	 */
//	private Exercise getAddExercise(double minRange, double maxRange, int decimals)	{		
//		double first = Randomizer.getRandomNumber(minRange, maxRange, decimals);
//		double second = Randomizer.getRandomNumber(first, maxRange, decimals);	
//		
//		return new Exercise(first, second - first, "+");
//	}
}
