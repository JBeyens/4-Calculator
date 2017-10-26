package model.properties;

import java.util.Properties;

import values.DefaultSettings;

public final class PropertyDefaultReader {

	/* Method to load in the default settings into a Property object*/	
	public static Properties getDefaultProperties(){
		Properties properties = new Properties();
		
		for (DefaultSettings setting : DefaultSettings.values()) {
			properties.setProperty(setting.toString(), setting.getValue());
		}

		return properties;
	}
	
	/* Method to retrieve the default file path */
	public static String getDefaultPath() {
		return DefaultSettings.stringPath.getValue();
	} 
}
