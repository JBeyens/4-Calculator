package model.exercisesFactory;

import java.io.Serializable;

import model.exercises.ExerciseSettings;

/**
 * @Autor: Jef Beyens & Ben Vandevorst
 * @Date: 26/10/2016
 * @Project: Calculator
 * @Purpose: Base class for Exercises
 */

public abstract class Exercise implements Serializable{
	// PRIVATE MEMBERS
	/** Generated for Serializable implementation */
	private static final long serialVersionUID = -335959616570107702L;
	private ExerciseSettings settings;
	private double operand1;
	private double operand2;
	private char operation;
	private int exerciseNumber;
	private boolean correctReplied;


	// CONSTRUCTOR
	public Exercise(ExerciseSettings settingsInput, int number) {
		settings = settingsInput;
		exerciseNumber = number;
	}
	
	
	// PRIVATE METHODS
	/**
	 * @param none:    input will be retrieved from the ExerciseSettings
	 * @return String: a String where the trailing zeros and '.' has been cut off */
	private String operandFormatter(double input) {
		String operand = Double.toString(input);
		boolean checkShouldContinue = true;
		
		while (checkShouldContinue) {
			if ( operand.endsWith("0") && operand.contains(".") )
				operand =  operand.substring(0, operand.length() - 2);
			else if (  operand.endsWith(".") )
				operand =  operand.substring(0, operand.length() - 2);
			else
				checkShouldContinue = false;
		}
		return operand;
	}
	
	
	// PUBLIC METHODS
	/**
	 * Method to be described in each extended class */
	public abstract void generateExercise();
	
	
	/**
	 * Generates the string to display the exercise */
	@Override
	public String toString() {	
		String op1 = operandFormatter(getOperand1());
		String op2 = operandFormatter(getOperand2());
		op1 = getOperand1() < 0 ? "("+op1+")" : op1;
		op2 = getOperand2() < 0 ? "("+op2+")" : op2;
		return op1 + " " + getOperation() + " " + op2 + " = ";
	}
	

	/**
	 * @param settings: getter for 'settings' */
	public ExerciseSettings getSettings() {
		return settings; }

	/**
	 * @param settings: getter for 'exerciseNumber' */
	public int getExerciseNumber() {
		return exerciseNumber; }
	
	/**
	 * @param operand1: setter & getter for 'operand1' */
	public void setOperand1(double input) {
		operand1 = input; }	
	public double getOperand1() {
		return operand1; 	}	
	
	/**
	 * @param operand2: setter & getter for 'operand2' */
	public void setOperand2(double input) {
		operand2 = input; }	
	public double getOperand2() {
		return operand2; }
	
	/**
	 * @param operation: setter & getter for 'operation' */
	public void setOperation(char input) {
		operation = input; }	
	public char getOperation() {
		return operation; }
	
	/**
	 * @param correctReplied: setter & getter for 'correctReplied' */
	public boolean isCorrectReplied() {
		return correctReplied;	}
	public void setCorrectReplied(boolean correctReplied) {
		this.correctReplied = correctReplied;	}
}
