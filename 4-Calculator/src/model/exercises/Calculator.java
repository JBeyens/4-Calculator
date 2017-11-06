package model.exercises;

import model.exercisesFactory.Exercise;

/**
 * @Autor: Jef Beyens & Ben VandeVorst
 * @Date: 16/10/2016
 * @Project: Calculator
 * @Purpose: BusinessComponent class to calculate results
 */
public final class Calculator {

	public static final char ADD = '+';
	public static final char SUB = '-';
	public static final char MULT = '*';
	public static final char DIV = '/';
	
	/** 
	 * Performs calculation and will return the result.
	 * @param input1, input2, operation: input1 = number left of the operation, input2 = number right of operation
	 * @return input1 ADDED TO / SUBSTRACTRED FROM / MULTIPLIED WITH / DIVIDED BY input2
	 * @exception IllegalArgumentException: if input2 is zero in case of division
	 * */
	public static double doCalculation(double input1, double input2, char operation) throws IllegalArgumentException
	{
		double result = 0;
		
		switch (operation) 
		{
			case ADD:
				result = input1 + input2;
				break;
			case SUB:
				result = input1 - input2;
				break;
			case MULT:
				result = input1 * input2;
				break;
			case DIV:
				if (input2 == 0)
				    throw new IllegalArgumentException("Division by zero not allowed");
				
				result = input1 / input2;
				break;

			default:
				throw new IllegalArgumentException("Invalid operation");
		}
		
		return result;
	}
	
	public static double doCalculation(Exercise exercise) throws IllegalArgumentException {
		return doCalculation(exercise.getOperand1(), exercise.getOperand2(), exercise.getOperation());
	}
}
