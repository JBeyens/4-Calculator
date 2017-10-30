package model.properties.test;

import static org.junit.Assert.*;

import java.util.Properties;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import model.properties.PropertyDefaultReader;



/**
 * 	@Author Ben Vandevorst & Jef Beyens
	@Datum 09/10/2017
	@Project Calculator
	@Doel Test of values from DefaultSettings(ENUM)
	 		are transferred correctly to properties
 */

public class PropertyDefaultReaderTest {
	private Properties properties;
	private String[] operatorArray;
	private String[] stringArray;
	private String	path;
	
	@Before
	public void setUp(){
		stringArray = new String[4];
		stringArray[0] = new String("+");
		stringArray[1] = new String("-");
		stringArray[2] = new String("*");
		stringArray[3] = new String("/");
		
		path = "resources/config.properties";
	}
	
	@Test
	public void testt_Get_Default_Values_From_Enum_To_Properties_Expect_Defaults() {
		properties = PropertyDefaultReader.getDefaultProperties();
		
		operatorArray = properties.getProperty("operators").split(",");
		
		assertEquals(10, Integer.parseInt(properties.getProperty("nrOfQuestions")));
		assertEquals(0, Integer.parseInt(properties.getProperty("minimumNumber")));
		assertEquals(20,Integer.parseInt(properties.getProperty("maximumNumber")));
		assertEquals(0, Integer.parseInt(properties.getProperty("nrOfDecimals")));
		assertEquals(path, properties.getProperty("stringPath"));
		Assert.assertArrayEquals(stringArray, operatorArray);
	}

}
