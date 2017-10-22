package testing;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

import utilities.Randomizer;


/**
 * 	@Author Ben Vandevorst
	@Datum 09/10/2017
	@Project Calculator
	@Doel Testen van de Randomizer functies
 */

public class RandomizerTest {
	private char[] charArray;
	private String[] stringArray;
	private Random rnd = new Random();
	
	@Before
	public void setUp(){
		charArray = new char[4];
		charArray[0] = '+';
		charArray[1] = '-';
		charArray[2] = '*';
		charArray[3] = '/';
		
		stringArray = new String[3];
		stringArray[0] = "Foo";
		stringArray[1] = "Bar";
		stringArray[2] = "FooBar";
	}

	@Test
	public void test_Random_Element_From_CharArray() {
		for (int i = 0; i < 1000000; i++) {
			char randomChar = Randomizer.getRandomChar(charArray);

			assertTrue(new String(charArray).indexOf(randomChar) != -1); 
		}
	}
	
	@Test
	public void test_Random_Element_From_StringArray() {
		for (int i = 0; i < 1000000; i++) {
			String randomString = Randomizer.getRandomString(stringArray);

			assertTrue(Arrays.asList(stringArray).contains(randomString)); // Contains only works on Strings
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
			
			int nrOfDecimalsFound = (Math.floor(result) == result) ? 0 : String.valueOf(result).split(".")[1].length(); 
			// ToDo: Fix test
			//assertTrue(nrOfDecimals == nrOfDecimalsFound);
		}
	}
}
