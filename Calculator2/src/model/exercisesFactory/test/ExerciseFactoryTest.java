package model.exercisesFactory.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.exercises.ExerciseSettings;
import model.exercisesFactory.Exercise;
import model.exercisesFactory.ExerciseAdd;
import model.exercisesFactory.ExerciseDiv;
import model.exercisesFactory.ExerciseFactory;
import model.exercisesFactory.ExerciseMult;
import model.exercisesFactory.ExerciseSub;
import model.exercisesFactory.Randomizer;

public class ExerciseFactoryTest {
	private ExerciseSettings settings;
	private int boundInteger;
	private double boundRange;
	private String[] operators;
	private Exercise exercise;
	
	@Before
	public void setUp(){
		boundInteger = 10;
		boundRange = 1000;
		operators = new String[] {"+","-","/"};
		settings = new ExerciseSettings(-1* boundRange, boundRange,	boundInteger, boundInteger, operators);
	}

	@Test
	public void test_GetExercise_Should_Return_An_Exercise_With_Correct_Operator_And_Type() {
		settings.setOperators(new String[] {"+"});
		exercise = ExerciseFactory.getExercise(settings, boundInteger);
		assertTrue(exercise.getOperation() == '+');
		assertTrue(exercise instanceof ExerciseAdd);  
			
		settings.setOperators(new String[] {"-"});
		exercise = ExerciseFactory.getExercise(settings, boundInteger);
		assertTrue(exercise.getOperation() == '-'); 
		assertTrue(exercise instanceof ExerciseSub); 
			
		settings.setOperators(new String[] {"*"});
		exercise = ExerciseFactory.getExercise(settings, boundInteger);
		assertTrue(exercise.getOperation() == '*'); 
		assertTrue(exercise instanceof ExerciseMult);
			
		settings.setOperators(new String[] {"/"});
		exercise = ExerciseFactory.getExercise(settings, boundInteger);
		assertTrue(exercise.getOperation() == '/');
		assertTrue(exercise instanceof ExerciseDiv);
	}

	@Test
	public void test_GetExercise_Should_Return_An_Exercise_With_Inputted_Integer() {
		for (int i = 0; i < 100000; i++) {
			int rndInt = Randomizer.getRandomNumber(0, boundInteger);
			
			exercise = ExerciseFactory.getExercise(settings, rndInt);
			assertTrue(exercise.getExerciseNumber() == rndInt); 
		}
	}
}
