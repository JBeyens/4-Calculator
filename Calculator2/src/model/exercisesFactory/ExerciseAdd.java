package model.exercisesFactory;

import model.exercises.ExerciseSettings;

/**
 * @Autor: Jef Beyens & Ben Vandevorst
 * @Date: 26/10/2016
 * @Project: Calculator
 * @Purpose: Extention of base class Exercise to create a SUM
 */
public class ExerciseAdd extends Exercise {
	/** Generated for Serializable implementation */
	private static final long serialVersionUID = -2069031712292967655L;

	/**
	 * @param random object & settings are needed as input for the base class
	 */
	public ExerciseAdd(ExerciseSettings settings, int number) {
		super(settings, number);
		generateExercise();
	}

	/**
	 * This method has to be defined (due to abstract method in base class) becasue the operands
	 *  have to be set up differently for each type of exercise 
	 */
	@Override
	public void generateExercise() {
		setOperation('+');
		
		double min = getSettings().getMinRange();
		double max = getSettings().getMaxRange();
		int nrDecs = getSettings().getNrDecimals();
		setOperand1( Randomizer.getRandomNumber( min, max, nrDecs));
		setOperand2( Randomizer.getRandomNumber( min, max, nrDecs));		
	}
}
