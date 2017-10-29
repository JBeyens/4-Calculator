package model.exercises.factory.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.exercises.ExerciseSettings;
import model.exercises.factory.Exercise;
import model.exercises.factory.ExerciseSub;
import model.exercises.factory.Randomizer;

public class ExerciseSubTest {
	private ExerciseSettings settings;
	private int boundDecimals;
	private double boundRange;
	private String[] operators;
	
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
			
			Exercise exerciseSub = new ExerciseSub(settings, rndInt);

			assertTrue(exerciseSub.getExerciseNumber() == rndInt); 
			assertTrue(exerciseSub.getOperand1() >= minRange); 
			assertTrue(exerciseSub.getOperand2() >= minRange); 
			assertTrue(exerciseSub.getOperand1() <= maxRange); 
			assertTrue(exerciseSub.getOperand2() <= maxRange); 
			assertTrue(exerciseSub.getOperation() == '+'); 			
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
			
			Exercise exerciseSub = new ExerciseSub(settings, rndInt);

			double op1 = exerciseSub.getOperand1() * Math.pow(10, rndInt);
			double op2 = exerciseSub.getOperand2() * Math.pow(10, rndInt);
	
			assertTrue(Math.round(op1) - op1 < 0.00001); 
			assertTrue(Math.round(op2) - op2 < 0.00001); 
		}
	}

	@Test
	public void test_ToString_For_Random_NrDecimals_Expect_Good_Decimals() {
		for (int i = 0; i < 100000; i++) {
			int rndInt = Randomizer.getRandomNumber(0, boundDecimals);
			double minRange = Randomizer.getRandomNumber(-1*boundRange, boundRange, rndInt);
			double maxRange = Randomizer.getRandomNumber(-1*boundRange, boundRange, rndInt);
			
			settings = new ExerciseSettings(Math.min(minRange, maxRange), 
										    Math.max(minRange, maxRange), 
										    rndInt, rndInt, operators);
			
			Exercise exerciseSub = new ExerciseSub(settings, rndInt);

			String result = exerciseSub.toString();
			int maxResultLength = Double.toString(exerciseSub.getOperand1()).indexOf('.') 
							      + Double.toString(exerciseSub.getOperand2()).indexOf('.')
							      + 6 // 6 = 1x space between nr1 & operator + 1x for operator + 1x space + one the end ' = ' for 3x
							      + 2 // 2 for decimal point in each double
							      + 2 * settings.getNrDecimals(); 
			assertTrue(result.endsWith(" = "));  
			assertTrue(result.length() <= maxResultLength);  
		}
	}
}
