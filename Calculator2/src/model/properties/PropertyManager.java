package model.properties;

import java.util.Properties;


/**
 * @Author Ben Vandevorst & Jef Beyens
 * @Datum 09/10/2017
 * @Project Calculator
 * @Doel Manages the properties and sends commands to PropertyDefaultReader & PropertyFileReader
 */

public class PropertyManager {
	// DATA MEMBERS
	/* Static Property Reference */
	private static Properties programProperties = new Properties(PropertyDefaultReader.getDefaultProperties());
	/* Static Class Reference to an object of itself */
	private static PropertyManager propertyManager;


	
	// CONSTRUCTOR
    /*Private Constructor will prevent the instantiation of this class directly.
     * This is to ensure this class is a singleton. */
	private PropertyManager() { 
		programProperties = PropertyDefaultReader.getDefaultProperties();
	}
	
	
	
	// PUBLIC MEMBERS
	/* This method will ensure that no more than one object can be created */	
	public static PropertyManager CreationMethod() {
		return CreationMethod(PropertyDefaultReader.getDefaultPath());
	}
	
	/* Overloaded method on CreationMethod(), which also changes the defaultpath in the programProperties */
	public static PropertyManager CreationMethod(String path) {
		if( propertyManager == null ) {
			propertyManager = new PropertyManager();
		}
		
		programProperties.setProperty("stringPath", path);
		readProperties(path);	// Update programProperties with what you can read from file
		saveProperties(path);	// ProgramProperties can now contain more than was indicated in the file, so save all to file
		return propertyManager;
	}
	
	/* Getter property with key parameter */
	public String getProperty(String key) {
		return programProperties.getProperty(key);
	}

	/* This will save the settings locally and will try to save it to file. 
	 * Returns FALSE if save to file has failed. */
	public boolean setProperty(String key, String value) {
		programProperties.setProperty(key, value);
		return saveProperties(programProperties.getProperty("stringPath"));
	}
	
	/* To get all properties from file updated in 'programProperties' */
	public static Properties readProperties(String path) {
		return PropertyFileReader.loadProperties(path, programProperties);
	}
	
	/* To save all properties in 'programProperties' to file */
	public static boolean saveProperties(String path) {
		return PropertyFileReader.saveProperties(path, programProperties);
	}
	
	/* For testing purposes - resets the singleton class */
	public static void reset() {
		propertyManager = null;
		programProperties = null;
	}
}