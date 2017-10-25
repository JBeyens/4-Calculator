package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;


/**
 * @Author Ben Vandevorst
 * @Datum 09/10/2017
 * @Project Calculator
 * @Doel
 */

public class PropertyFileReader {
	private static Properties defaultProperties = DefaultProperties.getDefaultProperties();
	private static Properties userProperties = new Properties(defaultProperties);
	private static File file;

	private PropertyFileReader() {
	}

	/**/
	public static boolean trySaveProperties(Properties properties) {
		try (OutputStream out = new FileOutputStream(file)) {
			properties.store(out, null);
		}
		catch (IOException ex) { // The exception FileNotFoundException is already caught by the alternative IOException
			return false;
		}
		return true;
	}

	private static void loadUserProperties() throws FileNotFoundException, IOException {	
		try(InputStream is = new FileInputStream(file)){
			userProperties.load(is);
		}	
	}

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
				trySaveProperties(userProperties);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return instance;
	}
}
