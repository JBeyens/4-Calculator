package testing;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import model.exercises.factory.Randomizer;


/**
 * 	@Author Ben Vandevorst
	@Datum 09/10/2017
	@Project Calculator
	@Doel Testen van de Randomizer functies
 */

public class RandomizerTest {
	private String[] stringArray1;
	private String[] stringArray2;
	private Random rnd = new Random();
	
	@Before
	public void setUp(){
		
		stringArray1 = new String[4];
		stringArray1[0] = new String("+");
		stringArray1[1] = new String("-");
		stringArray1[2] = new String("*");
		stringArray1[3] = new String("/");
		
		stringArray2 = new String[3];
		stringArray2[0] = "Foo";
		stringArray2[1] = "Bar";
		stringArray2[2] = "FooBar";
	}

	@Test
	public void test_Random_Element_From_CharArray() {
		for (int i = 0; i < 1000000; i++) {
			char randomChar = Randomizer.getRandomChar(stringArray1);

			assertTrue(String.join("",stringArray1).indexOf(randomChar) != -1); 
		}
	}
	
	@Test
	public void test_Random_Element_From_StringArray() {
		for (int i = 0; i < 1000000; i++) {
			String randomString = Randomizer.getRandomString(stringArray2);

			assertTrue(Arrays.asList(stringArray2).contains(randomString)); // Contains only works on Strings
		}
	}
	
	@Test
	public void test_Get_Random_Element_NoEqual_Boundaries_Expect_Random_Numbers(){
		for (int i = 0; i < 1000000; i++) {
			int randomInt1 = Randomizer.getRandomNumber(0, 10);
			int randomInt2 = Randomizer.getRandomNumber(10, 20);
			int randomIntResult = Randomizer.getRandomNumber(randomInt1, randomInt2);
			
			assertTrue(randomInt1 <= randomIntResult && randomIntResult <= randomInt2);
		}	
	}
	
	@Test
	public void test_Get_Random_Element_Equal_Boundaries_Expect_Same_Number(){
		for (int i = 0; i < 1000000; i++) {
			int randomInt = Randomizer.getRandomNumber(10, 10);
			
			if (randomInt == 10) {
				assertTrue(true);
			}
		}
	}

	@Test
	public void test_Get_Random_Element_NoEqual_Boundaries_Negative_Number_Expect_Random_Numbers(){
		for (int i = 0; i < 1000000; i++) {
			int randomInt1 = Randomizer.getRandomNumber(-20, -1);
			int randomInt2 = Randomizer.getRandomNumber(1, 20);
			int randomIntResult = Randomizer.getRandomNumber(randomInt1, randomInt2);

			assertTrue(randomInt1 <= randomIntResult && randomIntResult <= randomInt2);
		}	
	}
	
	@Test
	public void test_Get_Random_Element_Equal_Boundaries_Negative_Number_Expect_Same_Number(){
		for (int i = 0; i < 1000000; i++) {
			int randomInt = Randomizer.getRandomNumber(-10, -10);
			
			if (randomInt == 10) {
				assertTrue(true);
			}
		}
	}
	
	@Test
	public void test_Get_Random_Double_Positive_And_Negative_Boundaries_Expect_Within_Boundaries(){
		for (int i = 0; i < 1000000; i++) {
			double minNumber = rnd.nextDouble()*(-10000d);
			double maxNumber = rnd.nextDouble()*(10000d);
			int nrOfDecimals = rnd.nextInt(6);
			double result = Randomizer.getRandomNumber(minNumber, maxNumber, nrOfDecimals);
			
			assertTrue(minNumber <= result);
			assertTrue(result <= maxNumber);
			
			double resultNoDecimals = result * Math.pow(10, nrOfDecimals);
			assertTrue(Math.abs(resultNoDecimals - Math.round(resultNoDecimals)) < 0.000001);
		}
	}
}
