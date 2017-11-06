package model.exercisesFactory;

import java.math.BigDecimal;
import java.math.RoundingMode;

import model.exercises.ExerciseSettings;

/**
 * @Autor: Jef Beyens & Ben Vandevorst
 * @Date: 26/10/2016
 * @Project: Calculator
 * @Purpose: Extention of base class Exercise to create a SUM
 */
public class ExerciseDiv extends Exercise {
	/** Generated for Serializable implementation */
	private static final long serialVersionUID = 7690512140225374201L;

	/**
	 * @param random object & settings are needed as input for the base class
	 */
	public ExerciseDiv(ExerciseSettings settings, int number) {
		super(settings, number);
		generateExercise();
	}

	/**
	 * This method has to be defined (due to abstract method in base class) becasue the operands
	 *  have to be set up differently for each type of exercise 
	 */
	@Override
	public void generateExercise() {
		setOperation( '/' );

		double min = getSettings().getMinRange();
		double max = getSettings().getMaxRange();
		int nrDecs = getSettings().getNrDecimals();
		double x = 0;
		double y = 0;
		while (x == 0 || y == 0 )
		{
			x = Randomizer.getRandomNumber( min, max, nrDecs);
			y = Randomizer.getRandomNumber( min, max, nrDecs);
		}
			
		boolean xAbsBiggerThanYAbs = Math.abs(x) > Math.abs(y); 
		setOperand1(xAbsBiggerThanYAbs ? x : y);
		setOperand2(xAbsBiggerThanYAbs ? y : x);
		
		double op1Test = getOperand1() - (getOperand1() % getOperand2());
		if (op1Test < min)
			op1Test = Math.signum(getOperand1()) * ( Math.abs(getOperand1()) - Math.abs(getOperand2()) + Math.abs( getOperand1() % getOperand2())  );
		else if (op1Test > max)
			op1Test = Math.signum(getOperand1()) * ( Math.abs(getOperand1()) - Math.abs( getOperand1() % getOperand2())  );

		setOperand1( new BigDecimal(Double.toString(op1Test))
				.setScale(getSettings().getNrDecimals(), RoundingMode.HALF_UP)
				.doubleValue());
	}
}
