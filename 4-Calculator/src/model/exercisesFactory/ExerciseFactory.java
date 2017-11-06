package model.exercisesFactory;

import model.exercises.ExerciseSettings;

/**
 * @Autor: Jef Beyens & Ben Vandevorst
 * @Date: 26/10/2016
 * @Project: Calculator
 * @Purpose: Extention of base class Exercise to create a SUM
 */
public final class ExerciseFactory {
	// Possible improvements: Improve factory to work with enum instead of switch
	// Possible improvements: Enum in factory can be used to populate view
	 
	/** Returns an exercise based on the operations it can find in the settings 
	 * @param settings: ExerciseSettings to generate exercises with. These settings already have to be configured 
	 * @param exerciseNumber: The generated exercise will be assigned this number internally 
	 * @return Exercise: An object which is derived from the abstract Exercise class will be returned */
	public static Exercise getExercise(ExerciseSettings settings, int exerciseNumber) {
		char operation = Randomizer.getRandomChar(settings.getOperators());
				
		switch (operation)
		{
			case '+':
				return new ExerciseAdd(settings, exerciseNumber);
			case '-':
				return new ExerciseSub(settings, exerciseNumber);
			case '*':
				return new ExerciseMult(settings, exerciseNumber);
			case '/':
				return new ExerciseDiv(settings, exerciseNumber);
		}
		return null;		
	}
}