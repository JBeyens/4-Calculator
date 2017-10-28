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
	public ExerciseAdd(ExerciseSettings settings) {
		super(settings);
		generateExercise();
	}

	protected void generateExercise() {
		setOperation('+');
		setOperand1( Randomizer.getRandomNumber(				
				getSettings().getMinRange(), 
				getSettings().getMaxRange() - getSettings().getMinRange(), // this is the first step to ensure that the result will be within range
				getSettings().getNrDecimals()));
		setOperand2( Randomizer.getRandomNumber(				 
				getSettings().getMinRange(), 
				getSettings().getMaxRange() - getOperand1(), // this is the second step to ensure that the result will be within range
				getSettings().getNrDecimals()));
	}
}
