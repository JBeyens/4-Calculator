package model.properties;

import java.util.Properties;

import values.DefaultSettings;

public class PropertyManager {
	// DATA MEMBERS
	/* Static Property Reference */
	private static Properties programProperties = PropertyDefaultReader.getDefaultProperties();
	/* Static Class Reference to an object of itself */
	private static PropertyManager propertyManager = null;


	
	// CONSTRUCTOR
    /*Private Constructor will prevent the instantiation of this class directly.
     * This is to ensure this class is a singleton. */
	private PropertyManager() { }
	
	
	
	// PUBLIC MEMBERS
	/* This method will ensure that no more than one object can be created */
	public static PropertyManager CreationMethod() {	
		if( propertyManager == null ) {
			propertyManager = new PropertyManager();
		}
		return propertyManager;
	} 
	
	/* To get a certain property from the Properties field */
	public String getProperty(String key) {
		return programProperties.getProperty(key);
	}
	
	public Properties getProperties(String path) {
		return PropertyFileReader.loadProperties(path, programProperties);
	}

	/* This will save the settings locally and will try to save it to file. 
	 * Returns FALSE if save to file has failed. */
	public boolean setProperty(String key, String value) {
		programProperties.setProperty(key, value);
		if (PropertyFileReader.saveProperties(programProperties.getProperty("stringPath"), programProperties)) {
			// TODO: Catch boolean higher up...
			System.out.println("Settings could not be stored to file. They are only kept during run of program.");
			return false;
		}
		return true;
	}
}