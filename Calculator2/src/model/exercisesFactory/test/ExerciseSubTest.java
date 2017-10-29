package model.exercisesFactory.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.exercises.ExerciseSettings;
import model.exercisesFactory.Exercise;
import model.exercisesFactory.ExerciseAdd;
import model.exercisesFactory.ExerciseSub;
import model.exercisesFactory.Randomizer;

public class ExerciseSubTest {
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
			
			exercise = new ExerciseSub(settings, rndInt);

			assertTrue(exercise.getExerciseNumber() == rndInt); 
			assertTrue(exercise.getOperand1() >= minRange); 
			assertTrue(exercise.getOperand2() >= minRange); 
			assertTrue(exercise.getOperand1() <= maxRange); 
			assertTrue(exercise.getOperand2() <= maxRange); 
			assertTrue(exercise.getOperation() == '-'); 			
		}
	}

	@Test
	public void test_GenerateExercises_For_Random_NrDecimals_Expect_Good_Decimals() {
		for (int i = 0; i < 100000; i++) {
			int rndInt = Randomizer.getRandomNumber(0, boundDecimals);
			double minRange = Randomizer.getRandomNumber(-1*boundRange, boundRange, rndInt);
			double maxRange = Randomizer.getRandomNumber(-1*boundRange, boundRange, rndInt);
			
			settings = new ExerciseSettings(Math.min(minRange, maxRange), 
										    Math.max(minRange, maxRange), 
										    rndInt, rndInt, operators);
			
			exercise = new ExerciseSub(settings, rndInt);

			double op1 = exercise.getOperand1() * Math.pow(10, rndInt);
			double op2 = exercise.getOperand2() * Math.pow(10, rndInt);
	
			assertTrue(Math.round(op1) - op1 < 0.00001); 
			assertTrue(Math.round(op2) - op2 < 0.00001); 
		}
	}

	@Test
	public void test_ToString_For_Random_NrDecimals_Expect_String_Has_Certain_Length_And_Certain_Characters() {
		for (int i = 0; i < 100000; i++) {
			int rndInt = Randomizer.getRandomNumber(0, boundDecimals);
			double minRange = Randomizer.getRandomNumber(-1*boundRange, boundRange, rndInt);
			double maxRange = Randomizer.getRandomNumber(-1*boundRange, boundRange, rndInt);
			
			settings = new ExerciseSettings(Math.min(minRange, maxRange), 
										    Math.max(minRange, maxRange), 
										    rndInt, rndInt, operators);
			
			exercise = new ExerciseAdd(settings, rndInt);

			String result = exercise.toString();
			int maxResultLength = Double.toString(exercise.getOperand1()).indexOf('.') 
							      + Double.toString(exercise.getOperand2()).indexOf('.')
							      + 6 // 6 = 1x space between nr1 & operator + 1x for operator + 1x space + one the end ' = ' for 3x
							      + 2 // 2 for decimal point in each double
							      + 4 // 2*2 for '(' ')' around possible negative numbers
							      + 2 * settings.getNrDecimals(); 
			assertTrue(result.endsWith(" = "));  			// Check if it contains ' = ' at the end
			assertTrue(result.length() <= maxResultLength); // Check if the string length is not to long (would indicate bad formatting of doubles)
			assertTrue((exercise.getOperand1() < 0 ? result.indexOf('(') > -1 : true)); // Check if there are () brackets for negative numbers
			assertTrue((exercise.getOperand2() < 0 ? result.indexOf('(') > -1 : true)); // Check if there are () brackets for negative numbers
		}
	}
}
