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
	private ExerciseSettings settings;
	private Random random;
	private double operand1;
	private double operand2;
	private char operation;
	
	public Exercise(Random randomInput, ExerciseSettings settingsInput) {
		settings = settingsInput;
		random = randomInput;
	}
	
	abstract void generateExercise();

	/**
	 * @param settings: getter for 'settings' */
	public ExerciseSettings getSettings() {
		return settings; }

	/**
	 * @param random: getter for 'random' */
	public Random getRandom() {
		return random; }
	
	/**
	 * @param operand1: getter & setter for 'operand1' */
	public void setOperand1(double input) {
		operand1 = input; }	
	public double getOperand1() {
		return operand1; 	}	
	
	/**
	 * @param operand2: getter & setter for 'operand2' */
	public void setOperand2(double input) {
		operand2 = input; }	
	public double getOperand2() {
		return operand2; }
	
	/**
	 * @param operation: getter & setter for 'operation' */
	public void setOperation(char input) {
		operation = input; }	
	public char getOperation() {
		return operation; }
	
	/**
	 * @param input: a double which will be shown to the user
	 * @param nrDecimals: amount of decimals which should be visible to the user
	 * @return string: cleand up string with requested amount of decimals to show to the user */
	private String cleanUp(double input, int nrDecimals) {
		// Convert to double which should have no decimals
		double resultAsDouble = input *Math.pow(10.0, nrDecimals);
		// Round to nearest whole number and convert to int
		String resultAsString = Integer.valueOf((int) Math.round(resultAsDouble)).toString();
		
		// Throw away trailing zeros 
		// (e.g.:  resultAsString = "100"  and nrDecimals = 2    =>   resultAsString = "1" and nrDecimals = 0)
		int stringLength = resultAsString.length();
		while (stringLength > 1 && nrDecimals > 0 && resultAsString.endsWith("0")) {
			resultAsString = resultAsString.substring(0, stringLength -1);
			stringLength--;
			nrDecimals--;			
		}
		
		// TODO: Finish result..........
		return String.valueOf(input);
	}
	/**
	 * Generates the string to display the exercise */
	@Override
	public String toString() {
		return "" + getOperand1() + " " + getOperation() + " " + getOperand2() + " = ";
	}
}
