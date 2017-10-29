package model.exercises.factory;

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
	public ExerciseDiv(ExerciseSettings settings, int number) {
		super(settings, number);
		generateExercise();
	}

	public void generateExercise() {
		setOperation( '/' );

		double min = getSettings().getMinRange();
		double max = getSettings().getMaxRange();
		int nrDecs = getSettings().getNrDecimals();
		double x = Randomizer.getRandomNumber( min, max, nrDecs);
		double y = Randomizer.getRandomNumber( min, max, nrDecs);
	
		boolean xAbsBiggerThanYAbs = Math.abs(x) > Math.abs(y); 
		setOperand1(xAbsBiggerThanYAbs ? x : y);
		setOperand2(xAbsBiggerThanYAbs ? y : x);
		
		modifyOperand1ToEnsureModulusIsZero(); // Modifies operand1 so that the modulus is zero
	}
	
	/* Modifies operand1 to ensure the result of the division does not have more decimals than allowed */
	private void modifyOperand1ToEnsureModulusIsZero()
	{
		double rest = getOperand1() % getOperand2();
		
		if (  getOperand1() + (getOperand2() - rest) > getSettings().getMaxRange()  )
			setOperand1( getOperand1() - rest );
		else
			setOperand1( getOperand1() + getOperand2() - rest);
	}
}
