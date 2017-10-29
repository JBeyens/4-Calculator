package model.exercises.factory;

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
	public ExerciseAdd(ExerciseSettings settings, int number) {
		super(settings, number);
		generateExercise();
	}

	public void generateExercise() {
		setOperation('+');
		setOperand1( Randomizer.getRandomNumber(				
				getSettings().getMinRange(), 
				getSettings().getMaxRange(),
				getSettings().getNrDecimals()));
		setOperand2( Randomizer.getRandomNumber(			 
				getSettings().getMinRange(), 
				getSettings().getMaxRange(),
				getSettings().getNrDecimals()));		
	}
}
