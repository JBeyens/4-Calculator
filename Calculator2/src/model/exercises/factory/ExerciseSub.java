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
		setOperation( '-' );
		setOperand1( Randomizer.getRandomNumber(
				getRandom(), 
				2.0 * getSettings().getMinRange(), // this is the first step to ensure that the result will be within range
				getSettings().getMaxRange(), 
				getSettings().getNrDecimals()));
		setOperand2( Randomizer.getRandomNumber(
				getRandom(), 
				getSettings().getMinRange(), 
				getOperand1() - getSettings().getMinRange(), // this is the second step to ensure that the sum will be within range
				getSettings().getNrDecimals()));
	}
}
