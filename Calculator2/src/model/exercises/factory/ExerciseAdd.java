/**
 * 
 */
package model.exercises.factory;

import java.util.Random;

import model.exercises.ExerciseSettings;

/**
 * @Autor: Jef Beyens & Ben Vandevorst
 * @Date: 26/10/2016
 * @Project: Calculator
 * @Purpose: Extention of base class Exercise to create a SUM
 */
public class ExerciseAdd extends Exercise {

	/**
	 * @param random object & settings are needed as input for the base class
	 */
	public ExerciseAdd(Random random, ExerciseSettings settings) {
		super(random, settings);
		generateExercise();
	}

	protected void generateExercise() {
		operation = '+';
		operand1 = Randomizer.getRandomNumber(
				random, 
				settings.getMinRange(), 
				settings.getMaxRange() - settings.getMinRange(), // this is the first step to ensure that the result will be within range
				settings.getNrDecimals());
		operand2 = Randomizer.getRandomNumber(
				random, 
				settings.getMinRange(), 
				settings.getMaxRange() - operand1, // this is the second step to ensure that the result will be within range
				settings.getNrDecimals());
	}
}
