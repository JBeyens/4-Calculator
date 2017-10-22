package utilities;

import java.util.Random;

public class Randomizer {
	private static Random random= new Random();
	
	public static int getRandomNumber(int minNumber, int maxNumber){
		int randomNumber = random.nextInt(maxNumber + 1 - minNumber);
		
		return randomNumber;
	}
	
	public static char getRandomChar(char[] operatorArray){
		int randomElement = random.nextInt(operatorArray.length);
		char randomOperator = operatorArray[randomElement];
		
		return randomOperator;
	}
	
	public static String getRandomString(String[] commentArray){
		int randomElement = random.nextInt(commentArray.length);
		String randomComment = commentArray[randomElement];
		
		return randomComment;
	}
}
