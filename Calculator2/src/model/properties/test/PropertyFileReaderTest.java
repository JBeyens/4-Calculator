package model.properties.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.Properties;

import org.junit.Before;
import org.junit.Test;

import model.exercisesFactory.Randomizer;
import model.properties.PropertyFileReader;

public class PropertyFileReaderTest {
	
	@Before
	public void setUp(){ }
	
	@Test
	public void test_Save_Properties_Expect_Same_As_Load_Properties() {
		// Ensure file does not exist:
		String path = "Random path";
		File file = new File(path);
		while (file.exists()) {
			path = Long.toString(Randomizer.RANDOM.nextLong()) + ".txt";
			file = new File(path);
		}			
		
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
}
