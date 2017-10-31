package model.properties.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import model.exercisesFactory.Randomizer;
import model.properties.PropertyFileReader;
import model.properties.PropertyManager;
import values.DefaultSettings;

public class PropertyManagerTest {
	private int minimumNumber;
	private int maximumNumber;
	private int numberOfQuestions;
	private int numberOfDecimals;
	private String[] operatorArray;
	private String[] stringArray;
	
	@Before
	public void setUp(){
		stringArray = new String[4];
		stringArray[0] = new String("+");
		stringArray[1] = new String("-");
		stringArray[2] = new String("*");
		stringArray[3] = new String("/");
	}
	
	@Test
	public void test_Reading_Properties_From_Config_File_When_File_Found() {
		// Ensure file does not exist:
		String path = "Random path";
		File file = new File(path);
		while (file.exists()) {
			path = Long.toString(Randomizer.RANDOM.nextLong()) + ".txt";
			file = new File(path);
		}			
		
		// Write some stuff to the file
		try {
			file.createNewFile();
			FileWriter writer = new FileWriter(file);
			writer.write("#Tue Oct 31 00:37:02 CET 2017\r\n" +
						"operators=+,-,*,/\r\n" +
						"stringPath=resources/config.properties\r\n" +
						"nrOfDecimals=2\r\n" +
						"filePath=resource/results.txt\r\n" +
						"maximumNumber=100\r\n" +
						"minimumNumber=50\r\n" +
						"nrOfQuestions=30");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		PropertyManager.reset();
		PropertyManager propMan = PropertyManager.CreationMethod(path);
		
		operatorArray = propMan.getProperty("operators").split(",");
		
		minimumNumber = Integer.parseInt(propMan.getProperty("minimumNumber"));
		maximumNumber = Integer.parseInt(propMan.getProperty("maximumNumber"));
		numberOfQuestions = Integer.parseInt(propMan.getProperty("nrOfQuestions"));
		numberOfDecimals = Integer.parseInt(propMan.getProperty("nrOfDecimals"));
		
		assertEquals(50, minimumNumber);
		assertEquals(100, maximumNumber);
		assertEquals(30, numberOfQuestions);
		assertEquals(2, numberOfDecimals);
		Assert.assertArrayEquals(stringArray, operatorArray);
		
		// Clean up file
		file.delete();
	}
	
	@Test
	public void test_Reading_Properties_From_Config_File_Not_Found_Expect_Default_Settings(){
		// Ensure file does not exist:
		String path = "Random path";
		File file = new File(path);
		while (file.exists()) {
			path = Long.toString(Randomizer.RANDOM.nextLong()) + ".txt";
			file = new File(path);
		}			
	
		// Run tests while file does not exist:
		PropertyManager.reset();
		PropertyManager propMan = PropertyManager.CreationMethod(path);
		
		minimumNumber = Integer.parseInt(propMan.getProperty("minimumNumber"));
		maximumNumber = Integer.parseInt(propMan.getProperty("maximumNumber"));
		numberOfQuestions = Integer.parseInt(propMan.getProperty("nrOfQuestions"));
		numberOfDecimals = Integer.parseInt(propMan.getProperty("nrOfDecimals"));
		
		assertEquals(Integer.parseInt(DefaultSettings.minimumNumber.getValue()), minimumNumber);
		assertEquals(Integer.parseInt(DefaultSettings.maximumNumber.getValue()), maximumNumber);
		assertEquals(Integer.parseInt(DefaultSettings.nrOfQuestions.getValue()), numberOfQuestions);
		assertEquals(Integer.parseInt(DefaultSettings.nrOfDecimals.getValue()), numberOfDecimals);
		
		// Clean up file
		file.delete();
	}
	
	
	@Test
	public void test_Reading_Properties_From_Config_File_With_Missing_Value_Expect_Default_Settings(){
		// Ensure file does not exist:
		String path = "Random path";
		File file = new File(path);
		while (file.exists()) {
			path = Long.toString(Randomizer.RANDOM.nextLong()) + ".txt";
			file = new File(path);
		}			
		
		// Write some stuff to the file
		try {
			file.createNewFile();
			FileWriter writer = new FileWriter(file);
			writer.write("maximumNumber=111\r\n" + 
					     "minimumNumber=540");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Check how the PropertyManager handles everything:
		PropertyManager.reset();
		PropertyManager propMan = PropertyManager.CreationMethod(path);
			
		minimumNumber = Integer.parseInt(propMan.getProperty("minimumNumber"));
		maximumNumber = Integer.parseInt(propMan.getProperty("maximumNumber"));
		numberOfQuestions = Integer.parseInt(propMan.getProperty("nrOfQuestions"));
		numberOfDecimals = Integer.parseInt(propMan.getProperty("nrOfDecimals"));
		
		assertEquals(111, maximumNumber);
		assertEquals(540, minimumNumber);
		assertEquals(DefaultSettings.nrOfQuestions.getValue(), Integer.toString(numberOfQuestions));
		assertEquals(DefaultSettings.nrOfDecimals.getValue(), Integer.toString(numberOfDecimals));
		
		// Clean up file
		file.delete();
	}
	
	
	@Test
	public void test_Reading_Properties_From_Config_File_With_Missing_Values_Added_To_File(){
		// Ensure file does not exist:
		String path = "Random path";
		File file = new File(path);
		while (file.exists()) {
			path = Long.toString(Randomizer.RANDOM.nextLong()) + ".txt";
			file = new File(path);
		}			
		
		// Write some stuff to the file
		try {
			file.createNewFile();
			FileWriter writer = new FileWriter(file);
			writer.write("maximumNumber=111\r\n" + 
					     "minimumNumber=540");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Start a PropertyManager, it should add missing properties to the file
		PropertyManager.reset();
		PropertyManager.CreationMethod(path);
		
		// Now let's check if missing properties have been added to the file
		Properties filePropertiesOnly = PropertyFileReader.loadProperties(path, new Properties());
			
		minimumNumber = Integer.parseInt(filePropertiesOnly.getProperty("minimumNumber"));
		maximumNumber = Integer.parseInt(filePropertiesOnly.getProperty("maximumNumber"));
		numberOfQuestions = Integer.parseInt(filePropertiesOnly.getProperty("nrOfQuestions"));
		numberOfDecimals = Integer.parseInt(filePropertiesOnly.getProperty("nrOfDecimals"));
		
		assertEquals(111, maximumNumber);
		assertEquals(540, minimumNumber);
		assertEquals(DefaultSettings.nrOfQuestions.getValue(), Integer.toString(numberOfQuestions));
		assertEquals(DefaultSettings.nrOfDecimals.getValue(), Integer.toString(numberOfDecimals));
		assertEquals(path, filePropertiesOnly.getProperty("stringPath"));
		
		// Clean up file
		file.delete();
	}
}
