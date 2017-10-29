package model.exercises.factory.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import model.exercises.ExerciseSettings;
import model.exercises.factory.ExerciseAdd;
import model.exercises.factory.Randomizer;


/**
 * 	@Author Jef Beyens & Ben Vandevorst
	@Datum 28/10/2017
	@Project Calculator
	@Doel Testen van de ExerciseAdd functies
 */
public class ExerciseAddTest {
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
			
			ExerciseAdd exerciseAdd = new ExerciseAdd(settings, rndInt);

			assertTrue(exerciseAdd.getExerciseNumber() == rndInt); 
			assertTrue(exerciseAdd.getOperand1() >= minRange); 
			assertTrue(exerciseAdd.getOperand2() >= minRange); 
			assertTrue(exerciseAdd.getOperand1() <= maxRange); 
			assertTrue(exerciseAdd.getOperand2() <= maxRange); 
			assertTrue(exerciseAdd.getOperation() == '+'); 			
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
			
			ExerciseAdd exerciseAdd = new ExerciseAdd(settings, rndInt);

			double op1 = exerciseAdd.getOperand1() * Math.pow(10, rndInt);
			double op2 = exerciseAdd.getOperand2() * Math.pow(10, rndInt);
	
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
			
			ExerciseAdd exerciseAdd = new ExerciseAdd(settings, rndInt);

			String result = exerciseAdd.toString();
			int maxResultLength = Double.toString(exerciseAdd.getOperand1()).indexOf('.') 
							      + Double.toString(exerciseAdd.getOperand2()).indexOf('.')
							      + 6 // 6 = 1x space between nr1 & operator + 1x for operator + 1x space + one the end ' = ' for 3x
							      + 2 // 2 for decimal point in each double
							      + 2 * settings.getNrDecimals(); 
			assertTrue(result.endsWith(" = "));  
			assertTrue(result.length() <= maxResultLength);  
		}
	}
}
