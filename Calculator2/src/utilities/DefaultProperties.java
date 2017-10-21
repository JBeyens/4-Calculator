package utilities;

import java.util.Properties;

import values.DefaultSettings;

public class DefaultProperties {
	private static Properties defaultProperties = new Properties();
	
	private DefaultProperties(){
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
