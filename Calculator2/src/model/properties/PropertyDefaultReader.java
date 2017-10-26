package model.properties;

import java.util.Properties;

import values.DefaultSettings;

public class PropertyDefaultReader {
	private static Properties defaultProperties = new Properties();
	
	private PropertyDefaultReader(){
	}
	
	private static void loadDefaultProperties(){
		for (DefaultSettings setting : DefaultSettings.values()) {
			defaultProperties.setProperty(setting.toString(), setting.getValue());
		}
	}
	
	public static Properties getDefaultProperties(){
		loadDefaultProperties();
		return defaultProperties;
	}
}
