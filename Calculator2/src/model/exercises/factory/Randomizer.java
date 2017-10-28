package model.exercises.factory;

import java.util.Random;

public final class Randomizer {
	public final static Random RANDOM = new Random();
	
	public static int getRandomNumber( int minNumber, int maxNumber){
		int randomNumber = RANDOM.nextInt(maxNumber + 1 - minNumber);
		
		return randomNumber + minNumber;
	}
	
	public static double getRandomNumber(double minNumber, double maxNumber, int nrDecimals){
		int minInteger = (int) Math.ceil(minNumber*Math.pow(10, nrDecimals));
		int maxInteger = (int) Math.floor(maxNumber*Math.pow(10, nrDecimals));
		
		return ((double) getRandomNumber(minInteger, maxInteger))/Math.pow(10, nrDecimals);
	}
	
	public static char getRandomChar(String[] operatorArray){
		int randomElement = RANDOM.nextInt(operatorArray.length);
		String randomOperator = operatorArray[randomElement];
		
		char operator = randomOperator.charAt(0);
		
		return operator;
	}
	
	public static String getRandomString(String[] commentArray){
		int randomElement = RANDOM.nextInt(commentArray.length);
		String randomComment = commentArray[randomElement];
		
		return randomComment;
	}
}
