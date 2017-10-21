package businesscomponent;

import java.util.Random;

import model.Exercise;
import model.ExerciseSettings;

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
	private Exercise[] exercises;

	public ExerciseManager() {
		// TODO Auto-generated constructor stub
	}

	
	// Method to load the exercise generator by passing it a settings object.
	public void loadExerciseGenerator(ExerciseSettings settings)
	{
		generator = new ExerciseGenerator(new Random(), settings);
	}

	
	// Method to let the exercise generator generate exercises.
	public void loadExercises() throws Exception
	{
		exercises = generator.getExercises();
	}
}
