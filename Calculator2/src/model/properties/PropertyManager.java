package model.properties;

import java.io.Console;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import utilities.PropertyFileReader;
import values.DefaultSettings;

public class PropertyManager {
	// Static Property Reference
	private static Properties programProperties = new Properties();
	// Static Class Reference to an object of itself
	private static PropertyManager propertyManager = null;
	// Static Class Reference to the file reader
	private static PropertyFileReader fileReader = null;


    /*Private Constructor will prevent the instantiation of this class directly.
     * This is to ensure this class is a singleton. */
	private PropertyManager() { }
	
	
	/* This method will ensure that no more than one object can be created */
	public static PropertyManager CreationMethod() {	
		if( propertyManager == null )
		{
			propertyManager = new PropertyManager();
			loadDefaultProperties();
			fileReader = PropertyFileReader.getPropertiesFile(programProperties.getProperty("stringPath"));
		}
		return propertyManager;
	} 
	
	/* Loads the default properties into the Property field of this object */
	private static void loadDefaultProperties(){
		for (DefaultSettings setting : DefaultSettings.values()) {
			programProperties.setProperty(setting.toString(), setting.getValue());
		}
	}
	
	/* To get a certain property from the Properties field */
	public String getProperty(String key) {
		return programProperties.getProperty(key);
	}

	/* This will save the settings locally and will try to save it to file. 
	 * Returns FALSE if save to file has failed. */
	public boolean setProperty(String key, String value) {
		programProperties.setProperty(key, value);
		if (PropertyFileReader.trySaveProperties(programProperties))
		{
			// TODO: Catch boolean higher up...
			System.out.println("Settings could not be stored to file. They are only kept during run of program.");
			return false;
		}
		return true;
	}
	
	
	
	public static Properties getDefaultProperties(){
		loadDefaultProperties();
		return programProperties;
	}
}