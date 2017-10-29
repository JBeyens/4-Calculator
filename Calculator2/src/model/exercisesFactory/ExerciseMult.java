package model.exercisesFactory;

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
	public ExerciseMult(ExerciseSettings settings, int number) {
		super(settings, number);
		generateExercise();
	}

	public void generateExercise() {
		setOperation( '*' );
		
		double min = getSettings().getMinRange();
		double max = getSettings().getMaxRange();
		int nrDecs = getSettings().getNrDecimals();
		setOperand1( Randomizer.getRandomNumber( min, max, nrDecs));
		setOperand2( Randomizer.getRandomNumber( min, max, nrDecs));
	}
}
