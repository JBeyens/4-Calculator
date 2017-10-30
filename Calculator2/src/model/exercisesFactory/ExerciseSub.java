package model.exercisesFactory;

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
	public ExerciseSub(ExerciseSettings settings, int number) {
		super(settings, number);
		generateExercise();
	}

	/**
	 * This method has to be defined (due to abstract method in base class) becasue the operands
	 *  have to be set up differently for each type of exercise 
	 */
	@Override
	public void generateExercise() {
		setOperation( '-' );
		
		double min = getSettings().getMinRange();
		double max = getSettings().getMaxRange();
		int nrDecs = getSettings().getNrDecimals();
		double x = Randomizer.getRandomNumber( min, max, nrDecs);
		double y = Randomizer.getRandomNumber( min, max, nrDecs);
		
		boolean allowNegativeResult = getSettings().getMinRange() < 0;
		setOperand1(allowNegativeResult ? x : Math.max(x, y));
		setOperand2(allowNegativeResult ? y : Math.min(x, y));
	}
}
