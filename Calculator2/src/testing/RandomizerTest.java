package testing;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import randomizer.Randomizer;


/**
 * 	@Author Ben Vandevorst
	@Datum 09/10/2017
	@Project Calculator
	@Doel Testen van de Randomizer functies
 */

public class RandomizerTest {
	private char[] charArray;
	private String[] stringArray;
	
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
			
			if (randomChar == '+' || randomChar == '-' || randomChar == '*' || randomChar == '/') {
				assertTrue(true);
			}
		}

	}
	
	@Test
	public void test_Random_Element_From_StringArray() {
		for (int i = 0; i < 1000000; i++) {
			String randomString = Randomizer.getRandomString(stringArray);
			
			if (randomString == "Foo" || randomString == "Bar" || randomString == "FooBar") {
				assertTrue(true);
			}
		}
	}
	
	@Test
	public void test_Get_Random_Element_NoEqual_Boundaries_Expect_Random_Numbers(){
		for (int i = 0; i < 1000000; i++) {
			int randomInt = Randomizer.getRandomNumber(0, 20);
			
			if(randomInt > 0 && randomInt <= 20){
				assertTrue(true);
			}
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
			int randomInt = Randomizer.getRandomNumber(-20, 20);
			
			if(randomInt > -20 && randomInt <= 20){
				assertTrue(true);
			}
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
}
