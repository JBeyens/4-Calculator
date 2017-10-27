package model.exercises;

import model.exercises.factory.Exercise;

/**
 * @Autor: Jef Beyens
 * @Date: 16/10/2016
 * @Project: Calculator
 * @Purpose: BusinessComponent class to calculate results
 */
public final class Calculator {

	public static final char ADD = '+';
	public static final char SUB = '-';
	public static final char MULT = '*';
	public static final char DIV = '/';
	
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
