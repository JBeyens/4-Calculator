package testing;

import static org.junit.Assert.*;

import java.io.Console;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import utilities.PropertyFileReader;

public class PropertiesTest {
	private String configPath;
	private int minimumNumber;
	private int maximumNumber;
	private int numberOfQuestions;
	private boolean isRoundNumber;
	private String[] operatorArray;
	private String[] stringArray;
	
	@Before
	public void setUp(){
		configPath = "resources/config.properties";
		stringArray = new String[4];
		stringArray[0] = new String("+");
		stringArray[1] = new String("-");
		stringArray[2] = new String("*");
		stringArray[3] = new String("/");
	}
	
	@Test
	public void test_Reading_Properties_From_Config_File_When_File_Found() {
		PropertyFileReader pfr = PropertyFileReader.getPropertiesFile(configPath);
		
		operatorArray = pfr.getProperty("operators").split(",");
		
		minimumNumber = Integer.parseInt(pfr.getProperty("minimumNumber"));
		maximumNumber = Integer.parseInt(pfr.getProperty("maximumNumber"));
		numberOfQuestions = Integer.parseInt(pfr.getProperty("numberOfQuestions"));
		isRoundNumber = Boolean.parseBoolean(pfr.getProperty("isRoundNumber"));
		
		assertEquals(0, minimumNumber);
		assertEquals(40, maximumNumber);
		assertEquals(20, numberOfQuestions);
		assertTrue(isRoundNumber);
		// InvocationTargetException. Inner details: suppressedExceptions	Collections$UnmodifiableRandomAccessList<E>	
		Assert.assertArrayEquals(stringArray, operatorArray);
	}
	
	//@Test
	public void test_Reading_Properties_Only_Operators_From_Config_File_When_File_Found() {
		PropertyFileReader pfr = PropertyFileReader.getPropertiesFile(configPath);
		
		operatorArray = pfr.getProperty("operators").split(",");
		
		minimumNumber = Integer.parseInt(pfr.getProperty("minimumNumber"));
		maximumNumber = Integer.parseInt(pfr.getProperty("maximumNumber"));
		numberOfQuestions = Integer.parseInt(pfr.getProperty("numberOfQuestions"));
		isRoundNumber = Boolean.parseBoolean(pfr.getProperty("isRoundNumber"));

		assertEquals(0, minimumNumber);
		assertEquals(40, maximumNumber);
		assertEquals(20, numberOfQuestions);
		assertTrue(isRoundNumber);
		// InvocationTargetException. Inner details: suppressedExceptions	Collections$UnmodifiableRandomAccessList<E>	
		assertArrayEquals(stringArray, operatorArray);
	}
	
	//@Test
	public void test_Reading_Properties_From_Config_File_Not_Found_Expect_Default_Settings(){
		configPath = "invalid path";
		PropertyFileReader pfr = PropertyFileReader.getPropertiesFile(configPath);
		
		minimumNumber = Integer.parseInt(pfr.getProperty("minimumNumber"));
		maximumNumber = Integer.parseInt(pfr.getProperty("maximumNumber"));
		numberOfQuestions = Integer.parseInt(pfr.getProperty("numberOfQuestions"));
		isRoundNumber = Boolean.parseBoolean(pfr.getProperty("isRoundNumber"));
		
		assertEquals(0, minimumNumber);
		assertEquals(40, maximumNumber);
		assertEquals(20, numberOfQuestions);
		assertTrue(isRoundNumber);	
	}
	
	
	//@Test
	public void test_Reading_Properties_From_Config_File_With_Missing_Value_Expect_Default_Settings(){
		PropertyFileReader pfr = PropertyFileReader.getPropertiesFile(configPath);
			
		minimumNumber = Integer.parseInt(pfr.getProperty("minimumNumber"));
		maximumNumber = Integer.parseInt(pfr.getProperty("maximumNumber"));
		numberOfQuestions = Integer.parseInt(pfr.getProperty("numberOfQuestions"));
		isRoundNumber = Boolean.parseBoolean(pfr.getProperty("isRoundNumber"));
		
		assertEquals(0, minimumNumber);
		assertEquals(40, maximumNumber);
		assertEquals(20, numberOfQuestions);
		assertTrue(isRoundNumber);	
	}

}
