package model.exercisesFactory.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.exercises.ExerciseSettings;
import model.exercisesFactory.Exercise;
import model.exercisesFactory.ExerciseMult;
import model.exercisesFactory.Randomizer;

/**
 * 	@Author Jef Beyens & Ben Vandevorst
	@Datum 28/10/2017
	@Project Calculator
	@Doel Testen van de ExerciseMult functies
 */
public class ExerciseMultTest {
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
	}

	@Test
	public void test_GenerateExercises_For_Random_MinRange_And_MaxRange_Expect_Within_Range() {
		for (int i = 0; i < 100000; i++) {
			int rndInt = Randomizer.getRandomNumber(0, boundInteger);
			double x = Randomizer.getRandomNumber(-1*boundRange, boundRange, rndInt);
			double y = Randomizer.getRandomNumber(-1*boundRange, boundRange, rndInt);
			double minRange = Math.min(x, y);
			double maxRange = Math.max(x, y);
			
			settings = new ExerciseSettings(minRange, maxRange, rndInt, rndInt, operators);			
			exercise = new ExerciseMult(settings, rndInt);

			//System.out.println("MinRange:\t" + minRange + "\t-- " + exercise.getOperand1() + "\t-- " + exercise.getOperand2() + " --\t" + maxRange + "MaxRange");
			assertTrue(exercise.getExerciseNumber() == rndInt); 
			assertTrue(exercise.getOperand1() >= minRange); 
			assertTrue(exercise.getOperand2() >= minRange); 
			assertTrue(exercise.getOperand1() <= maxRange); 
			assertTrue(exercise.getOperand2() <= maxRange); 
			assertTrue(exercise.getOperation() == '*'); 			
		}
	}

	@Test
	public void test_GenerateExercises_For_Random_NrDecimals_Expect_Good_Decimals() {
		for (int i = 0; i < 100000; i++) {
			int rndInt = Randomizer.getRandomNumber(0, boundInteger);
			double x = Randomizer.getRandomNumber(-1*boundRange, boundRange, rndInt);
			double y = Randomizer.getRandomNumber(-1*boundRange, boundRange, rndInt);
			double minRange = Math.min(x, y);
			double maxRange = Math.max(x, y);
			
			settings = new ExerciseSettings(minRange, maxRange, rndInt, rndInt, operators);			
			exercise = new ExerciseMult(settings, rndInt);

			String op1 = Double.toString(exercise.getOperand1());
			String op2 = Double.toString(exercise.getOperand2());
			
			// clean up trailing zero's:
			//System.out.println("NrDecimals: " + rndInt + " " + op1 + "     " + op2);
			boolean checkShouldContinue = true;
			while (checkShouldContinue) {
				if (  (op1.endsWith("0") && op1.contains("."))  || op1.endsWith("."))
					op1 =  op1.substring(0, op1.length() - 2);
				else if (  (op2.endsWith("0") && op2.contains("."))  || op2.endsWith("."))
					op2 =  op2.substring(0, op2.length() - 2);
				else
					checkShouldContinue = false;
			}
			//System.out.println("NrDecimals: " + rndInt + " " + op1 + "     " + op2);

			assertTrue(op1.indexOf('.') == -1 || op1.indexOf('.') >= (op1.length() - rndInt -1)); 
			assertTrue(op2.indexOf('.') == -1 || op2.indexOf('.') >= (op2.length() - rndInt -1)); 
		}
	}

	@Test
	public void test_ToString_For_Random_NrDecimals_Expect_String_Has_Certain_Length_And_Certain_Characters() {
		for (int i = 0; i < 100000; i++) {
			int rndInt = Randomizer.getRandomNumber(0, boundInteger);
			double minRange = Randomizer.getRandomNumber(-1*boundRange, boundRange, rndInt);
			double maxRange = Randomizer.getRandomNumber(-1*boundRange, boundRange, rndInt);
			
			settings = new ExerciseSettings(Math.min(minRange, maxRange), 
										    Math.max(minRange, maxRange), 
										    rndInt, rndInt, operators);
			
			exercise = new ExerciseMult(settings, rndInt);

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
