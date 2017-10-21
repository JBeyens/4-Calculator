/**
 * 
 */
package view;

import businesscomponent.ExerciseManager;
import model.ExerciseSettings;

/**
 * @Autor: Jef Beyens
 * @Date: 16/10/2016
 * @Project: Calculator
 * @Purpose: Test class
 */
public class TestCalculator {

	private static ExerciseManager exerciseManager;
	
	public TestCalculator() {
		exerciseManager = new ExerciseManager();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Step 1: Set up exercises
		exerciseManager.loadExerciseGenerator(ExerciseSettingDefault.getDefaultSettings());
		try {
			exerciseManager.loadExercises();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
