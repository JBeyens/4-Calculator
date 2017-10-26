package model.exercises.factory;

import java.util.Random;

public final class Randomizer {
	public static int getRandomNumber(Random random, int minNumber, int maxNumber){
		int randomNumber = random.nextInt(maxNumber + 1 - minNumber);
		
		return randomNumber + minNumber;
	}
	
	public static double getRandomNumber(Random random, double minNumber, double maxNumber, int nrDecimals){
		int minInteger = (int) Math.ceil(minNumber*Math.pow(10, nrDecimals));
		int maxInteger = (int) Math.floor(maxNumber*Math.pow(10, nrDecimals));
		
		return ((double) getRandomNumber(random, minInteger, maxInteger))/Math.pow(10, nrDecimals);
	}
	
	public static char getRandomChar(Random random, String[] operatorArray){
		int randomElement = random.nextInt(operatorArray.length);
		String randomOperator = operatorArray[randomElement];
		
		char operator = randomOperator.charAt(0);
		
		return operator;
	}
	
	public static String getRandomString(Random random, String[] commentArray){
		int randomElement = random.nextInt(commentArray.length);
		String randomComment = commentArray[randomElement];
		
		return randomComment;
	}
}
