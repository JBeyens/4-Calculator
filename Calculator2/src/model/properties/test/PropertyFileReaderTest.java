package model.properties.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.exercisesFactory.Randomizer;
import model.properties.PropertyFileReader;

public class PropertyFileReaderTest {
	private File file;
	private String path = "Random path";
	
	//Set up file
	@Before
	public void setUp(){
		// Ensure file does not exist:
		file = new File(path);
		while (file.exists()) {
			path = Long.toString(Randomizer.RANDOM.nextLong()) + ".txt";
			file = new File(path);
		}	
	}	
	
	@Test
	public void test_Save_Properties_Expect_Same_As_Load_Properties() {
		// Prepare properties
		Properties propertiesBefore = new Properties();
		propertiesBefore.setProperty("Happy times", "I hear you!");
		propertiesBefore.setProperty("1 Johny + 1 Johny", "2 Johnies");
		
		// Execute methods to test
		PropertyFileReader.saveProperties(path, propertiesBefore);
		Properties propertiesAfter = PropertyFileReader.loadProperties(path, new Properties());
		
		// Test stuff
		assertTrue(propertiesAfter.containsKey("Happy times"));
		assertEquals(propertiesAfter.get("Happy times"), "I hear you!");
		assertTrue(propertiesAfter.containsKey("1 Johny + 1 Johny"));
		assertEquals(propertiesAfter.get("1 Johny + 1 Johny"), "2 Johnies");
	}
	
	//Clean up file
	@After
	public void tearDown(){
		file.delete();
	}
}
