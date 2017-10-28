package model.exercises;

import java.util.ArrayList;
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
	private ArrayList<Exercise> listExercices;
	private ExerciseSettings settings;
	private ExerciseManager exerciseManager;
	private Random random;
	private int correctAnswers;
	private int currentNumberOfExercise;
	
	
	public ExerciseManager(ExerciseSettings settings) {
		this.random = new Random();
		this.settings = settings;
		this.listExercices = new ArrayList<>();
		generateExercise();
		correctAnswers = 0;
		currentNumberOfExercise = 1;
	}

	private void generateExercise() {
		for (int i = 0; i < settings.getNrOfExercises(); i++) {
			listExercices.add(ExerciseFactory.getExercise(random, settings));
		}
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
	
	public boolean isExerciseSettingsAcceptable(ExerciseSettings settings)
	{
		boolean check1 = settings.getNrDecimals() >= 0;
		boolean check2 = settings.getMaxRange() >= 2.0 * settings.getMinRange();
		
		return (check1 && check2);
	}
	
	public Exercise getExercise(){
		Exercise ex = listExercices.get(currentNumberOfExercise - 1);
		currentNumberOfExercise++;
		return ex;
	}
	
	public String showResults(){
		return null;
	}
}
