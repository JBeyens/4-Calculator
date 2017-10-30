package fileIO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import model.exercises.ExerciseSession;



/**
 * 	@Author Ben Vandevorst & Jef Beyens
	@Datum 09/10/2017
	@Project Calculator
	@Doel Save result of a session to file
 */
public class SaveResultsToFile {

	
	/**
	 * @param serializedList
	 * @param file
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void streamListToFile(ArrayList<String> result, File file) throws FileNotFoundException, IOException{
		File tempFile = file;
		tempFile.createNewFile();
		try(FileOutputStream outputStream = new FileOutputStream(file); ObjectOutputStream objStream = new ObjectOutputStream(outputStream);){
			objStream.writeObject(result);
		}
	}
	
	/**
	 * @param serializedList
	 * @param path
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static void streamListToFile(ArrayList<String> result, String path) throws FileNotFoundException, IOException{
		File file = new File(path);
		file.createNewFile();
		
		try(FileOutputStream outputStream = new FileOutputStream(path); ObjectOutputStream objStream = new ObjectOutputStream(outputStream);){
			objStream.writeObject(result);
		}
	}
	
	public static void addStringToStreamListToFile(String result, String path) throws FileNotFoundException, ClassNotFoundException, IOException{
		ArrayList<String> existedList = LoadResultsFromFile.streamFileToString(path);
		existedList.add(result);
		streamListToFile(existedList, path);
	}
}
