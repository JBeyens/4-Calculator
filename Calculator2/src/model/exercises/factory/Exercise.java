package model.exercises.factory;

import java.util.Random;

import model.exercises.ExerciseSettings;

/**
 * @Autor: Jef Beyens & Ben Vandevorst
 * @Date: 26/10/2016
 * @Project: Calculator
 * @Purpose: Base class for Exercises
 */

public abstract class Exercise {	
	protected ExerciseSettings settings;
	protected Random random;
	protected double operand1;
	protected double operand2;
	protected char operation;
	
	public Exercise(Random randomInput, ExerciseSettings settingsInput) {
		settings = settingsInput;
		random = randomInput;
	}
	
	abstract void generateExercise();
	
	public double getOperand1() {
		return operand1; 
	}	

	
	public double getOperand2() {
		return operand2; 
	}

	
	public char getOperation() {
		return operation; 
	}


	@Override
	public String toString() {
		return "" + getOperand1() + " " + getOperation() + " " + getOperand2() + "= ";
	}
}
