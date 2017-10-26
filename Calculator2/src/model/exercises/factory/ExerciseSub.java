package model.exercises.factory;

import java.util.Random;

import model.exercises.ExerciseSettings;

/**
 * @Autor: Jef Beyens & Ben Vandevorst
 * @Date: 26/10/2016
 * @Project: Calculator
 * @Purpose: Extention of base class Exercise to create a SUM
 */
public class ExerciseSub extends Exercise {

	/**
	 * @param random object & settings are needed as input for the base class
	 */
	public ExerciseSub(Random random, ExerciseSettings settings) {
		super(random, settings);
		generateExercise();
	}

	protected void generateExercise() {
		operation = '-';
		operand1 = Randomizer.getRandomNumber(
				random, 
				2.0 * settings.getMinRange(), // this is the first step to ensure that the result will be within range
				settings.getMaxRange(), 
				settings.getNrDecimals());
		operand2 = Randomizer.getRandomNumber(
				random, 
				settings.getMinRange(), 
				operand1 - settings.getMaxRange(), // this is the second step to ensure that the sum will be within range
				settings.getNrDecimals());
	}
}
