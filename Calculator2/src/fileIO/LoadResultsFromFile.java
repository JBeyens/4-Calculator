package fileIO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import model.exercises.ExerciseSession;


/**
 * 	@Author Ben Vandevorst & Jef Beyens
	@Datum 09/10/2017
	@Project Calculator
	@Doel Load previous results from file
 */

public class LoadResultsFromFile {
	
	/**
	 * @param file
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static ArrayList<String> streamFileToString(File file) throws FileNotFoundException, IOException, ClassNotFoundException{
		try(FileInputStream inputStream = new FileInputStream(file); ObjectInputStream objStream = new ObjectInputStream(inputStream)){						
			@SuppressWarnings("unchecked")
			ArrayList<String> list = (ArrayList<String>) objStream.readObject();
			return list;
		}
	}
	
	/**
	 * @param file
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static ArrayList<String> streamFileToString(String path) throws FileNotFoundException, IOException, ClassNotFoundException{
		try(FileInputStream inputStream = new FileInputStream(path); ObjectInputStream objStream = new ObjectInputStream(inputStream)){						
			@SuppressWarnings("unchecked")
			ArrayList<String> list = (ArrayList<String>) objStream.readObject();
			return list;
		}
	}
}
