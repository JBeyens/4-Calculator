package businesscomponent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.ExerciseSettings;
import modeldata.Exercise;

/**
 * @Autor: Jef Beyens
 * @Date: 16/10/2016
 * @Project: Calculator
 * @Purpose: BusinessComponent class
 *  --> The purpose of this class is to generate and return 'exercise' objects.
 */
public class ExerciseGenerator {
	private Random random;
	private ExerciseSettings settings;

	/*
	 * Constructor which takes in a Random object and a settings object
	 */
	public ExerciseGenerator(Random random, ExerciseSettings settings) {
		this.random = random;
		this.settings = settings;
	}

	/*
	 * Method which generates the amount of exercises as indicated in the settings
	 */
	public Exercise[] getExercises() throws Exception
	{
		List<Exercise> exercises = new ArrayList<Exercise>();
		
		for (int i=0; i < settings.getNrOfExercises(); i++)
		{
			exercises.add(getExercise(0,10,"+"));
		}
		return (Exercise[]) exercises.toArray();
	}

	/*
	 * Method which generates a single exercise based on the settings
	 */
	private Exercise getExercise(double minRange, double maxRange, String operator) throws Exception 
	{
		Exercise exercise = null;
		
		switch (operator)
		{
		case "+":
			exercise = getAddExercise(minRange, maxRange);
			break;
		case "-":
			exercise = getSubExercise(minRange, maxRange);
			break;
		case "*":
			exercise = getMultExercise(minRange, maxRange);
			break;
		case "/":
			exercise = getDivExercise(minRange, maxRange);
			break;
			default:
				throw new Exception("Invalid operator given.");
		}
		
		return exercise;
	}
	
	private Exercise getDivExercise(double minRange, double maxRange) {
		// TODO Auto-generated method stub
		return null;
	}

	private Exercise getMultExercise(double minRange, double maxRange) {
		// TODO Auto-generated method stub
		return null;
	}

	private Exercise getSubExercise(double minRange, double maxRange) {
		// TODO Auto-generated method stub
		return null;
	}

	private Exercise getAddExercise(double minRange, double maxRange)
	{
		double coefficient = Math.pow(10, settings.getNrDecimals());
		
		double value1 = random.nextDouble();
		
		return null;
	}
}
