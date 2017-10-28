package model.exercises.factory;

import java.text.DecimalFormat;

import model.exercises.ExerciseSettings;

/**
 * @Autor: Jef Beyens & Ben Vandevorst
 * @Date: 26/10/2016
 * @Project: Calculator
 * @Purpose: Base class for Exercises
 */

public abstract class Exercise {
	// PRIVATE MEMBERS
	private ExerciseSettings settings;
	private DecimalFormat formatter;
	private double operand1;
	private double operand2;
	private char operation;
	private int exerciseNumber;
	private boolean correctReplied;


	// CONSTRUCTOR
	public Exercise(ExerciseSettings settingsInput, int number) {
		settings = settingsInput;
		formatter = configureFormatter();
		exerciseNumber = number;
	}
	
	
	// PRIVATE METHODS
	/**
	 * @param none:   		  input will be retrieved from the ExerciseSettings
	 * @return DecimalFormat: a DecimalFormat object which can format double to the desired output */
	private DecimalFormat configureFormatter() {
		String pattern = getSettings().getNrDecimals() > 0 ? "#." + new String(new char[getSettings().getNrDecimals()]).replace("\0", "#") : "#";
		return new DecimalFormat(pattern); 
	}
	
	
	// PUBLIC METHODS
	/**
	 * Method to be described in each extended class */
	abstract void generateExercise();
	
	
	/**
	 * Generates the string to display the exercise */
	@Override
	public String toString() {
		return "" + formatter.format(getOperand1()) + " " + getOperation() + " " + formatter.format(getOperand2()) + " = ";
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
