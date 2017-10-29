package model.exercises;

import java.text.DecimalFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

import model.exercisesFactory.Exercise;
import model.exercisesFactory.ExerciseFactory;

/**
 * @Autor: Jef Beyens & Ben Vandevorst
 * @Date: 16/10/2016
 * @Project: Calculator
 * @Purpose: manage exercises
 *  --> The purpose of this class is to manage exercises. 
 */
public class ExerciseSession {
	// PRIVATE MEMBERS
	private ArrayList<Exercise> exerciseList;
	private int exerciseCounter;
	private boolean isRunning;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
    private DecimalFormat format2nrs = new DecimalFormat("00");
	
	
	// CONSTRUCTOR
	/** Initializes an exercise session
	 * @param random    An instance of the Random class.
	 * @param settings  exerciseSettings that must be respected in the session.
	 **/
	public ExerciseSession(ExerciseSettings settings) {
		exerciseList = new ArrayList<Exercise>();
		generateExercises(settings);
		isRunning = true;
		startTime = LocalDateTime.now();
		exerciseCounter = 0;
	}
	
	// PRIVATE METHODS
	private void generateExercises(ExerciseSettings settings) {
		for (int i = 0; i < settings.getNrOfExercises(); i++) {
			exerciseCounter++;
			exerciseList.add(ExerciseFactory.getExercise(settings, exerciseCounter));
		}		
	} 

	/**
	 * @param none		The exercises are already generated based on the ExerciseSettings
	 * @return String   Difference between start and end in HH:MM:SS format (H= Hour, M= Minute, S= Second)
	 **/
	private String getTimeDifference() {
		if (endTime == null)
			endTime = LocalDateTime.now();

		Duration time =  Duration.between(startTime, endTime);
		return time.toHours() + ":" + format2nrs.format(time.toMinutes() % 60)
							  + ":" + format2nrs.format(time.getSeconds() % 60);
	}
	
	// PUBLIC METHODS
	/**
	 * Returns the next exercise in the list and increases the exerciseCounter.
	 * @param none		 The exercises are already generated based on the ExerciseSettings
	 * @return Exercise  The next exercise in the list. Returns null if there are no exercises, or if there are no more exercises
	 **/
	public Exercise getNextExercise() {
		if (exerciseCounter >= exerciseList.size())
			return null;
		return exerciseList.get(exerciseCounter++);
	} 
	
	/**
	 * Composes a string with statistics from the exercise session (Score, time, etc)
	 * @return String    A description of the results
	 **/
	public String getEndResult() {
		// End exercise setting:
		if (isRunning) {
			isRunning = false;
			endTime = LocalDateTime.now();
		}
		
		// Calculate score:
		int correct = 0;
		for (Exercise exercise : exerciseList) {
			correct += exercise.isCorrectReplied() ? 1 : 0;
		}
	    int nrOfExercises = exerciseList.size();
	    
	    // Calculate time spent:
	    String timeSpentHHMMSS = getTimeDifference();
					

		return "Eindscore oefeningen: " + correct + "/" + nrOfExercises
				+ "\nTijd gespendeerd: " + timeSpentHHMMSS;
	} 
}