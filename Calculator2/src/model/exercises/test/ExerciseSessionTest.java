package model.exercises.test;

import static org.junit.Assert.assertTrue;

import java.text.DecimalFormat;
import java.util.Formatter;

import org.junit.Before;
import org.junit.Test;

import model.exercises.ExerciseSession;
import model.exercises.ExerciseSettings;
import model.exercisesFactory.Exercise;
import model.exercisesFactory.Randomizer;

/**
 * @Autor: Jef Beyens & Ben Vandevorst
 * @Date: 29/10/2016
 * @Project: Calculator
 * @Purpose: manage exercises
 *  --> The purpose of this class is to manage exercises. 
 */
public class ExerciseSessionTest {
	private ExerciseSettings settings;
	private int boundInteger;
	private double boundRange;
	private String[] operators;
	private DecimalFormat Formatter = new DecimalFormat("#.00");
	
	@Before
	public void setUp(){
		boundInteger = 10;
		boundRange = 1000;
		operators = new String[] {"+","-","/"};
		settings = new ExerciseSettings(-1 * boundRange, boundRange, boundInteger, boundInteger, operators);
	}

	
	@Test
	public void test_GetNextExcercise_Should_Give_Null_After_n_Calls() {
		for (int i = 0; i < 1000; i++) {
			int rndInt = Randomizer.getRandomNumber(0, boundInteger);
			double minRange = Randomizer.getRandomNumber(-1*boundRange, boundRange, rndInt);
			double maxRange = Randomizer.getRandomNumber(-1*boundRange, boundRange, rndInt);
			
			settings = new ExerciseSettings(minRange, maxRange, rndInt, rndInt, operators);
			
			ExerciseSession session = new ExerciseSession(settings);
			
			for (int j = 0; j < rndInt +1; j++) {
				if (j < settings.getNrOfExercises())
					assertTrue(session.getNextExercise() instanceof Exercise);
				else
					assertTrue(session.getNextExercise() == null);
			}
		}
	}
	
	@Test
	public void test_GetEndResult_Should_Contain_IntegerCorrect_IntegerTotal_And_TimeSpent() {
		for (int i = 0; i < 1000; i++) {
			int rndInt = Randomizer.getRandomNumber(1, boundInteger);
			double minRange = Randomizer.getRandomNumber(-1*boundRange, boundRange, rndInt);
			double maxRange = Randomizer.getRandomNumber(-1*boundRange, boundRange, rndInt);
			
			settings = new ExerciseSettings(minRange, maxRange, rndInt, rndInt, operators);
			
			ExerciseSession session = new ExerciseSession(settings);
			
			int amountCorrect = 0;
			for (int j = 0; j < rndInt; j++) {
				if (Randomizer.RANDOM.nextBoolean()) {
					session.getNextExercise().setCorrectReplied(true);
					amountCorrect++;
				}
				else {
					session.getNextExercise();
				}
			}
		
			String endResult = session.getEndResult();
			
			assertTrue(endResult != null); // Should not be null
			assertTrue(endResult.contains(Formatter.format((amountCorrect/settings.getNrOfExercises()) * 100))); // Should contain number of exercises set to 'Correct'
			assertTrue(endResult.contains(Integer.toString(settings.getNrOfExercises()))); // Should contain number of exercises	
		}
	}
}