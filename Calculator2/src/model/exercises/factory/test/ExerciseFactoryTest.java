package model.exercises.factory.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.exercises.ExerciseSettings;
import model.exercises.factory.Exercise;
import model.exercises.factory.ExerciseDiv;
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
	public void test_GenerateExercises_For_Random_MinRange_And_MaxRange_Expect_Within_Range() {
		for (int i = 0; i < 100000; i++) {
			int rndInt = Randomizer.getRandomNumber(0, boundDecimals);
			double minRange = Randomizer.getRandomNumber(-1*boundRange, boundRange, rndInt);
			double maxRange = Randomizer.getRandomNumber(-1*boundRange, boundRange, rndInt);
			
			settings = new ExerciseSettings(Math.min(minRange, maxRange), 
										    Math.max(minRange, maxRange), 
										    rndInt, rndInt, operators);
			
			exercise = new ExerciseDiv(settings, rndInt);

			assertTrue(exercise.getExerciseNumber() == rndInt); 
			assertTrue(exercise.getOperand1() >= minRange); 
			assertTrue(exercise.getOperand2() >= minRange); 
			assertTrue(exercise.getOperand1() <= maxRange); 
			assertTrue(exercise.getOperand2() <= maxRange); 
			assertTrue(exercise.getOperation() == '/'); 			
		}
	}
}
