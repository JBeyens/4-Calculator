package model.exercises.factory.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.exercises.ExerciseSettings;
import model.exercises.factory.Exercise;
import model.exercises.factory.ExerciseAdd;
import model.exercises.factory.ExerciseDiv;
import model.exercises.factory.ExerciseFactory;
import model.exercises.factory.ExerciseMult;
import model.exercises.factory.ExerciseSub;
import model.exercises.factory.Randomizer;

public class ExerciseFactoryTest {
	private ExerciseSettings settings;
	private int boundDecimals;
	private double boundRange;
	private String[] operators;
	private Exercise exercise;
	
	@Before
	public void setUp(){
		boundDecimals = 10;
		boundRange = 1000;
		operators = new String[] {"+","-","/"};
	}

	@Test
	public void test_GetExercise_Should_Return_An_Exercise_With_Correct_Operator() {
		for (int i = 0; i < 100000; i++) {
			int rndInt = Randomizer.getRandomNumber(0, boundDecimals);
			double minRange = Randomizer.getRandomNumber(-1*boundRange, boundRange, rndInt);
			double maxRange = Randomizer.getRandomNumber(-1*boundRange, boundRange, rndInt);
			
			settings = new ExerciseSettings(Math.min(minRange, maxRange), 
										    Math.max(minRange, maxRange), 
										    rndInt, rndInt, operators);
			
			settings.setOperators(new String[] {"+"});
			exercise = ExerciseFactory.getExercise(settings, rndInt);
			assertTrue(exercise.getOperation() == '+'); 
			
			settings.setOperators(new String[] {"-"});
			exercise = ExerciseFactory.getExercise(settings, rndInt);
			assertTrue(exercise.getOperation() == '-'); 
			
			settings.setOperators(new String[] {"*"});
			exercise = ExerciseFactory.getExercise(settings, rndInt);
			assertTrue(exercise.getOperation() == '*'); 
			
			settings.setOperators(new String[] {"/"});
			exercise = ExerciseFactory.getExercise(settings, rndInt);
			assertTrue(exercise.getOperation() == '/'); 			
		}
	}

	@Test
	public void test_GetExercise_Should_Return_An_Exercise_With_Correct_Type() {
		for (int i = 0; i < 100000; i++) {
			int rndInt = Randomizer.getRandomNumber(0, boundDecimals);
			double minRange = Randomizer.getRandomNumber(-1*boundRange, boundRange, rndInt);
			double maxRange = Randomizer.getRandomNumber(-1*boundRange, boundRange, rndInt);
			
			settings = new ExerciseSettings(Math.min(minRange, maxRange), 
										    Math.max(minRange, maxRange), 
										    rndInt, rndInt, operators);
			
			settings.setOperators(new String[] {"+"});
			exercise = ExerciseFactory.getExercise(settings, rndInt);
			assertTrue(exercise instanceof ExerciseAdd); 
			
			settings.setOperators(new String[] {"-"});
			exercise = ExerciseFactory.getExercise(settings, rndInt);
			assertTrue(exercise instanceof ExerciseSub); 
			
			settings.setOperators(new String[] {"*"});
			exercise = ExerciseFactory.getExercise(settings, rndInt);
			assertTrue(exercise instanceof ExerciseMult); 
			
			settings.setOperators(new String[] {"/"});
			exercise = ExerciseFactory.getExercise(settings, rndInt);
			assertTrue(exercise instanceof ExerciseDiv); 			
		}
	}
}
