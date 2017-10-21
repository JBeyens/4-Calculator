package model;

/**
 * @Autor: Jef Beyens
 * @Date: 16/10/2016
 * @Project: Calculator
 * @Purpose: Model data klasse
 * 
 * Additional explanation:
 * - operand1, operand2 and operation:
 *   These properties will only get a getter and not a settor. They have to be inputted through the constructor.
 *   REASON: They are not allowed to be changed after the instantiation of the class.
 *   Preventing changes to these parameters ensure more data consistency.
 */
public class Exercise {
	
	private double operand1;
	private double operand2;
	private String operation;
	private double result;
	private int timeWaited;
	private String reply;
	private boolean correct;
	

	public Exercise(double operand1, double operand2, String operation) {
		this.operand1 = operand1;
		this.operand2 = operand2;
		this.operation = operation;
	}

	
	public double getOperand1() {
		return operand1; 
	}	

	
	public double getOperand2() {
		return operand2; 
	}

	
	public String getOperation() {
		return operation; 
	}

	
	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}
	
	
	public int getTimeWaited() {
		return timeWaited;	
	}
	public void setTimeWaited(int timeWaited) {
		this.timeWaited = timeWaited;
	}


	public String getReply() {
		return reply;	
	}
	public void setReply(String reply) {
		this.reply = reply;	
	}


	public boolean isCorrect() {
		return correct;	
	}
	public void setCorrect(boolean correct) {
		this.correct = correct;	
	}
}
