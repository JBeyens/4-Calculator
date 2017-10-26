package model.exercises.factory;

import java.util.Random;

import model.exercises.ExerciseSettings;

public final class ExerciseFactory {
	// TODO Improve factor to work with enum instead of switch
	// TODO Enum in factor can be used to populate view
	 
	/* Returns an exercise based on the operations it can find in the settings */
	public static Exercise getExercise(Random random, ExerciseSettings settings) {
		char operation = Randomizer.getRandomChar(random, settings.getOperators());
				
		switch (operation)
		{
			case '+':
				return new ExerciseAdd(random, settings);
			case '-':
				return new ExerciseSub(random, settings);
			case '*':
				return new ExerciseMult(random, settings);
			case '/':
				return new ExerciseDiv(random, settings);
		}
		return null;		
	}

}