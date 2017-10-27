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
	 * Generates the string to display the exercise */
	@Override
	public String toString() {
		return "" + getOperand1() + " " + getOperation() + " " + getOperand2() + "= ";
	}
}
