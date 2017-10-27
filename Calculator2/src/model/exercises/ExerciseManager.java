package model.exercises;

import java.util.Random;

import model.exercises.factory.Exercise;
import model.exercises.factory.ExerciseFactory;

/**
 * @Autor: Jef Beyens
 * @Date: 16/10/2016
 * @Project: Calculator
 * @Purpose: manage exercises
 *  --> The purpose of this class is to manage exercises. 
 *  It must keep a record of all exercises during the current test.
 *  It must also ask the generator for exercises and ask the calculator to evaluate them.
 */

public class ExerciseManager {
	// Fields
	static ExerciseManager exerciseManager;
	static Random random;
	
	
	private ExerciseManager() {
		random = new Random();
	}
	
	
	public static ExerciseManager creationMethod()	{
		if (exerciseManager == null)
			exerciseManager = new ExerciseManager();
		
		return exerciseManager;
	}
	
	
	public boolean isExerciseSettingsAcceptable(ExerciseSettings settings)
	{
		boolean check1 = settings.getNrDecimals() >= 0;
		boolean check2 = settings.getMaxRange() >= 2.0 * settings.getMinRange();
		
		return (check1 && check2);
	}

	
	/**
	 * Returns the result of the exercise given to it.	 *
	 * @param settings  exerciseSettings that must be respected in the exercise.
	 * @return exercise	returns an exercise in which the operands and operation have been set based on the exerciseSettings
	 */
	public Exercise generateExercise(ExerciseSettings settings) {
		return ExerciseFactory.getExercise(random, settings);
	}
	
	/**
	 * Returns the result of the exercise given to it.	 *
	 * @param exercise  the exercise to solve.
	 * @return double	returns the solution of the exercise
	 * @exception 		throws IllegalArgumentException if one of the operands causes a bad exercise 
	 * (ex. division by zero) or if the operation is not known. See exception message for details.
	 */
	public double getSolutionExercise(Exercise exercise) throws IllegalArgumentException {
		return Calculator.doCalculation(exercise);
	}
}
