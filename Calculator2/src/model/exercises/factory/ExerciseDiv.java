package model.exercises.factory;

import java.util.Random;

import model.exercises.ExerciseSettings;

/**
 * @Autor: Jef Beyens & Ben Vandevorst
 * @Date: 26/10/2016
 * @Project: Calculator
 * @Purpose: Extention of base class Exercise to create a SUM
 */
public class ExerciseDiv extends Exercise {

	/**
	 * @param random object & settings are needed as input for the base class
	 */
	public ExerciseDiv(Random random, ExerciseSettings settings) {
		super(random, settings);
		generateExercise();
	}

	protected void generateExercise() {
		operation = '/';
		// TODO: For multiplication, the result is not guaranteed to be in range...
		operand1 = Randomizer.getRandomNumber(
				random, 
				settings.getMinRange(),
				settings.getMaxRange(), 
				settings.getNrDecimals());
		operand2 = Randomizer.getRandomNumber(
				random, 
				settings.getMinRange(), 
				settings.getMaxRange() / 2.0, 
				settings.getNrDecimals());
		
		modifeOperand1ToEnsureModulusIsZero(); // Modifies operand1 so that the modulus is zero
	}
	
	private void modifeOperand1ToEnsureModulusIsZero()
	{
		double rest = operand1 % operand2;
		
		if (operand1 + (operand2 - rest) > settings.getMaxRange())
			operand1 -= rest;
		else
			operand1 += operand2 - rest;
	}
}
