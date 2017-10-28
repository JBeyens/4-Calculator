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
		// TODO: For multiplication, the result is not guaranteed to be in range...
		setOperand1( Randomizer.getRandomNumber(				
				getSettings().getMinRange(),
				getSettings().getMaxRange(), 
				getSettings().getNrDecimals()));
		setOperand2( Randomizer.getRandomNumber(				 
				getSettings().getMinRange(), 
				getSettings().getMaxRange() / 2.0, 
				getSettings().getNrDecimals()));
		
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
