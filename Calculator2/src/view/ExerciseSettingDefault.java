package view;

import model.ExerciseSettings;

/**
 * @Autor: Jef Beyens
 * @Date: 16/10/2016
 * @Project: Calculator
 * @Purpose: BusinessComponent class
 *  --> This class is a backup in case no settings can be loaded from
 *  either user input or from file.
 */
public final class ExerciseSettingDefault {	
	public static final int AANTAL_DECIMALEN  = 0;
	public static final int AANTAL_OEFENINGEN = 2;
	public static final double MIN_RANGE      = 0;
	public static final double MAX_RANGE      = 20;
	public static final String[] OPERATOREN   = {"+", "-"};
	
	/*
	 * Method which returns an ExerciseSettings object without needing any depencies
	 */
	public static ExerciseSettings getDefaultSettings() 
	{
		ExerciseSettings settings = new ExerciseSettings();
		settings.setNrDecimals(AANTAL_DECIMALEN);
		settings.setNrOfExercises(AANTAL_OEFENINGEN);
		settings.setMinRange(MIN_RANGE);
		settings.setMaxRange(MAX_RANGE);
		settings.setOperators(OPERATOREN);
		
		return settings;
	}
}