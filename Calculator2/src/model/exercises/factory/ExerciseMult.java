package model.exercises.factory;

import java.util.Random;

import model.exercises.ExerciseSettings;

/**
 * @Autor: Jef Beyens & Ben Vandevorst
 * @Date: 26/10/2016
 * @Project: Calculator
 * @Purpose: Extention of base class Exercise to create a SUM
 */
public class ExerciseMult extends Exercise {

	/**
	 * @param random object & settings are needed as input for the base class
	 */
	public ExerciseMult(Random random, ExerciseSettings settings) {
		super(random, settings);
		generateExercise();
	}

	protected void generateExercise() {
		operation = '*';
		// TODO: For multiplication, the result is not guaranteed to be in range...
		operand1 = Randomizer.getRandomNumber(
				random, 
				settings.getMinRange(),
				settings.getMaxRange(), 
				settings.getNrDecimals());
		operand2 = Randomizer.getRandomNumber(
				random, 
				settings.getMinRange(), 
				settings.getMaxRange(), 
				settings.getNrDecimals());
	}
}
