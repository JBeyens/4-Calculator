package model.properties.test;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import model.exercisesFactory.Randomizer;
import model.properties.PropertyFileReader;
import model.properties.PropertyManager;
import values.DefaultSettings;

public class PropertyManagerTest {
	private File file;
	
	@Test
	public void test_Reading_Properties_From_Config_File_When_File_Found() {
		// Ensure file does not exist:
		String path = "Random path";
		file = new File(path);
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
		PropertyManager.resetToDefault();
		PropertyManager propMan = PropertyManager.CreationMethod(path);
		
		assertEquals("50", propMan.getProperty("minimumNumber"));
		assertEquals("100", propMan.getProperty("maximumNumber"));
		assertEquals("30", propMan.getProperty("nrOfQuestions"));
		assertEquals("2", propMan.getProperty("nrOfDecimals"));
		Assert.assertArrayEquals(new String[] {"+","-","*","/"}, propMan.getProperty("operators").split(","));
		
	}
	
	@Test
	public void test_Reading_Properties_From_Config_File_Not_Found_Expect_Default_Settings(){
		// Ensure file does not exist:
		String path = "Random path";
		file = new File(path);
		while (file.exists()) {
			path = Long.toString(Randomizer.RANDOM.nextLong()) + ".txt";
			file = new File(path);
		}			
	
		// Run tests while file does not exist:
		PropertyManager.resetToDefault();
		PropertyManager propMan = PropertyManager.CreationMethod(path);
		
		assertEquals(DefaultSettings.minimumNumber.getValue(), propMan.getProperty("minimumNumber"));
		assertEquals(DefaultSettings.maximumNumber.getValue(), propMan.getProperty("maximumNumber"));
		assertEquals(DefaultSettings.nrOfQuestions.getValue(), propMan.getProperty("nrOfQuestions"));
		assertEquals(DefaultSettings.nrOfDecimals.getValue(), propMan.getProperty("nrOfDecimals"));

	}
	
	
	@Test
	public void test_Reading_Properties_From_Config_File_With_Missing_Value_Expect_Default_Settings(){
		// Ensure file does not exist:
		String path = "Random path";
		file = new File(path);
		while (file.exists()) {
			path = Long.toString(Randomizer.RANDOM.nextLong()) + ".txt";
			file = new File(path);
		}			
		
		// Write some stuff to the file
		try {
			file.createNewFile();
			FileWriter writer = new FileWriter(file);
			writer.write("minimumNumber=111\r\n" + 
					     "maximumNumber=540");
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// Check how the PropertyManager handles everything:
		PropertyManager.resetToDefault();
		PropertyManager propMan = PropertyManager.CreationMethod(path);
		
		assertEquals("111", propMan.getProperty("minimumNumber"));
		assertEquals("540", propMan.getProperty("maximumNumber"));
		assertEquals(DefaultSettings.nrOfQuestions.getValue(), propMan.getProperty("nrOfQuestions"));
		assertEquals(DefaultSettings.nrOfDecimals.getValue(), propMan.getProperty("nrOfDecimals"));
		
	}
	
	
	@Test
	public void test_Reading_Properties_From_Config_File_With_Missing_Values_Added_To_File(){
		// Ensure file does not exist:
		String path = "Random path";
		file = new File(path);
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
		PropertyManager.resetToDefault();
		PropertyManager.CreationMethod(path);
		
		// Now let's check if missing properties have been added to the file
		Properties filePropertiesOnly = PropertyFileReader.loadProperties(path, new Properties());
		
		assertEquals("111", filePropertiesOnly.getProperty("maximumNumber"));
		assertEquals("540", filePropertiesOnly.getProperty("minimumNumber"));
		assertEquals(DefaultSettings.nrOfQuestions.getValue(), filePropertiesOnly.getProperty("nrOfQuestions"));
		assertEquals(DefaultSettings.nrOfDecimals.getValue(), filePropertiesOnly.getProperty("nrOfDecimals"));
		assertEquals(path, filePropertiesOnly.getProperty("stringPath"));
		
	}
	
	
	@Test
	public void test_SetProperty_Changes_Both_Result_GetProperty_And_File(){
		// Ensure file does not exist:
		String path = "Random path";
		file = new File(path);
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
		
		// Get a PropertyManager object
		PropertyManager.resetToDefault();
		PropertyManager propMan = PropertyManager.CreationMethod(path);
		propMan.setProperty("minimumNumber", "123");
		
		// Now let's check if we get results as desired
		String propManProp = propMan.getProperty("minimumNumber");
		assertEquals("123", propManProp);
		
		// Also check if the file contains the correct string
		Properties filePropertiesOnly = PropertyFileReader.loadProperties(path, new Properties());
		assertEquals("123", filePropertiesOnly.getProperty("minimumNumber"));
			
	}
	
	//Clean up file
	@After
	public void tearDown(){
		file.delete();
	}
	
}
