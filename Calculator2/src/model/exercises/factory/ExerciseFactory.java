package model.exercises.factory;

import java.util.Random;

import model.exercises.ExerciseSettings;

public final class ExerciseFactory {
	// TODO Improve factor to work with enum instead of switch
	// TODO Enum in factor can be used to populate view
	 
	/* Returns an exercise based on the operations it can find in the settings */
	public static Exercise getExercise(ExerciseSettings settings, int exerciseNumber) {
		char operation = Randomizer.getRandomChar(settings.getOperators());
				
		switch (operation)
		{
			case '+':
				return new ExerciseAdd(settings);
			case '-':
				return new ExerciseSub(settings);
			case '*':
				return new ExerciseMult(settings);
			case '/':
				return new ExerciseDiv(settings);
		}
		return null;		
	}

}