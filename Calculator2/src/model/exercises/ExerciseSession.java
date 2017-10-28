package model.exercises;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

import model.exercises.factory.Exercise;
import model.exercises.factory.ExerciseFactory;

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
			exerciseList.add(ExerciseFactory.getExercise(settings, i + 1));
		}		
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
		// Time spent:
		if (isRunning) {
			isRunning = false;
			endTime = LocalDateTime.now();
		}
					
		// TODO: compose string
		return "TODO: compose string";
	} 
}