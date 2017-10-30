package model.exercisesFactory;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

/**
 * 	@Author Ben Vandevorst & Jef Beyens
	@Datum 09/10/2017
	@Project Calculator
	@Doel Methodes en Random object voorzien om een object van de Random klasse of een random getallen binnen een range, 
	of een random element uit array terug te geven.
 */
public final class Randomizer {
	/**
	 * Object van de Random klasse dat aangeroepen kan worden als dit nodig is binnen het project */
	public final static Random RANDOM = new Random();
	
	/**
	 * @param int minNumber: Integer gegeneerd door deze methode is groter of gelijk aan dit getal
	 * @param int maxNumber: Integer gegeneerd door deze methode is kleiner of gelijk aan dit getal
	 * @return int: Random int dat tussen de opgegeven grenzen ligt. */
	public static int getRandomNumber( int minNumber, int maxNumber){
		int temp = minNumber;
		minNumber = Math.min(minNumber, maxNumber);
		maxNumber = Math.max(temp, maxNumber);
		
		int randomNumber = RANDOM.nextInt(maxNumber + 1 - minNumber);
		return randomNumber + minNumber;
	}
	
	private static double roundNumber(double input, int nrDecimals, double minRange, double maxRange) {
		double result = new BigDecimal(input).setScale(nrDecimals, RoundingMode.DOWN).doubleValue();
		if (result < minRange || result > maxRange)
			result = new BigDecimal(input).setScale(nrDecimals, RoundingMode.UP).doubleValue();
		
		return result;
	}	
	
	/**
	 * @param double minNumber: double gegeneerd door deze methode is groter of gelijk aan dit getal
	 * @param double maxNumber: double gegeneerd door deze methode is kleiner of gelijk aan dit getal
	 * @param int nrDecimals:   double gegeneerd door deze methode mag hoogstens dit aantal decimals hebben.
	 * @return double: Random double dat tussen de opgegeven grenzen ligt, met hoogstens het opgegeven aantal decimalen. */
	public static double getRandomNumber(double minNumber, double maxNumber, int nrDecimals){
		if (nrDecimals < 0) throw new IllegalArgumentException();
		double temp = minNumber;
		minNumber = Math.min(minNumber, maxNumber);
		maxNumber = Math.max(temp, maxNumber);
		
		double value = RANDOM.nextDouble()* (maxNumber - minNumber) + minNumber;		
		return roundNumber(value, nrDecimals, minNumber, maxNumber);
	}
	
	/**
	 * @param String[] operatorArray: Een array van Strings
	 * @return char: eerste karakter van een willekeurige string uit de operatorArray */
	public static char getRandomChar(String[] operatorArray){
		int randomElement = RANDOM.nextInt(operatorArray.length);
		String randomOperator = operatorArray[randomElement];
		
		char operator = randomOperator.charAt(0);
		
		return operator;
	}
	
	/**
	 * @param String[] operatorArray: Een array van Strings
	 * @return String: Willekeurige string uit de operatorArray */
	public static String getRandomString(String[] commentArray){
		int randomElement = RANDOM.nextInt(commentArray.length);
		String randomComment = commentArray[randomElement];
		
		return randomComment;
	}
}
