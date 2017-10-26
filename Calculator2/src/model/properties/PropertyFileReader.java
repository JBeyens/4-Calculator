package model.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;


/**
 * @Author Ben Vandevorst & Jef Beyens
 * @Datum 09/10/2017
 * @Project Calculator
 * @Doel Read & Write properties to file
 */

public final class PropertyFileReader {
	//private static Properties defaultProperties = DefaultProperties.getDefaultProperties();
	//private static Properties userProperties = new Properties(defaultProperties);
	//private static File file;

	/* Private constructor since this class is a singleton class */
	private PropertyFileReader() {
	}

	/* Method to store specified properties to a specified path. */
	public static boolean saveProperties(String path, Properties properties) {
		File file = getFile(path);
		try (OutputStream out = new FileOutputStream(file)) {
			properties.store(out, null);
		}
		catch (IOException ex) { // The exception FileNotFoundException is already caught by the alternative IOException
			return false;
		}
		return true;
	}

	/* Method to get properties from a specified path. */
	public static Properties loadProperties(String path, Properties properties) {	
		File file = getFile(path);						
		try(InputStream is = new FileInputStream(file)){
			properties.load(is);
		}	
		catch (IOException ex) { // The exception FileNotFoundException is already caught by the alternative IOException
			return null;
		}
		return properties;
	}
	
	private static File getFile(String path)
	{		
		File  file = null;
		try {
			file = new File(path);
			
			if (!file.exists()) {
				// Create new file based on absolute path
				file.getParentFile().mkdirs(); // Will create missing folders if necessary
				file.createNewFile();
			}

		} catch (IOException|SecurityException e) {
			e.printStackTrace();
		} 
		return file;		
	}
/*
	public static PropertyFileReader getPropertiesFile(String path) {
		PropertyFileReader instance = null;
		
		try {
			file = new File(path);
			if (file.exists()) {
				instance = new PropertyFileReader();
				loadUserProperties();
			} else {
				// Create new file based on absolute path
				file = new File(defaultProperties.getProperty("stringPath"));
				file.getParentFile().mkdirs(); // Will create missing folders if necessary
				instance = new PropertyFileReader();
				userProperties = defaultProperties;
				saveProperties(path, userProperties);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return instance;
	}*/
}
