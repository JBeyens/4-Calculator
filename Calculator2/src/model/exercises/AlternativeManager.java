package model.exercises;

import java.util.ArrayList;

import model.exercises.factory.Exercise;

public class AlternativeManager {
	private ArrayList<Exercise> listExercise;
	private int answersCorrect;
	private boolean isRunning;
	
	public AlternativeManager(){
		//listExercise = get list of exercises
		this.answersCorrect = 0;
	}
	
	public void setAnswerCorrect(Boolean isCorrect){
		if(isCorrect)
			answersCorrect++;
	}
	
	public String getEndResult(){
		return null; //Score, time etc
	}
	
	public int getNumberOfExercise(){
		return 0; // index of list+1 to show in view
	}
	
	public Exercise getNextOefening(){
		return null; //next element in list
	}
}
