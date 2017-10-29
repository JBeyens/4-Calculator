package view;

import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.Color;


/**
 * 	@Author Ben Vandevorst & Jef Beyens
	@Datum 09/10/2017
	@Project Calculator
	@Doel View to change settings and check answers
 */

public class MainView extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel labelNrOfQuestions;
	private JLabel labelMinNumber;
	private JLabel labelMAxNumber;
	private JLabel labelNrOfDecimals;
	private JLabel labelOperators;
	private JLabel labelStringExercise;
	private JLabel labelExercise;
	
	private JFormattedTextField tfNrOfQuestions;
	private JFormattedTextField tfMinNumber;
	private JFormattedTextField tfMaxNumber;
	private JFormattedTextField tfNrOfDecimals;
	private JTextField tfUserInput;
	
	private JCheckBox rbAddition;
	private JCheckBox rbSubstraction;
	private JCheckBox rbMultiplication;
	private JCheckBox rbDivision;
	
	private JButton startExercises;
	private JButton checkAnswer;

	private SpringLayout layout;
	
	public MainView(){
		setUp();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void addExerciseActionListener(ActionListener listener){
		checkAnswer.addActionListener(listener);
	}
	
	public void addActionListener(ActionListener listener){
		startExercises.addActionListener(listener);
	}
	
	public void setCheckAnswerButton(Boolean isEnabled){
		this.checkAnswer.setEnabled(isEnabled);
	}
	
	public void setStartExerciseButton(Boolean isEnabled){
		this.startExercises.setEnabled(isEnabled);
	}
		
	public String getTfUserInput() {
		return tfUserInput.getText();
	}
	public void setTfUserInput(String tfUserInput) {
		this.tfUserInput.setText(tfUserInput);;
	}
	
	public String getLabelStringExercise() {
		return labelStringExercise.getText();
	}
	public void setLabelStringExercise(String labelExercise) {
		this.labelStringExercise.setText(labelExercise);
	}
	
	public String getTfNrOfQuestions() {
		return tfNrOfQuestions.getText();
	}

	public void setTfNrOfQuestions(String tfNrOfQuestions) {
		this.tfNrOfQuestions.setText(tfNrOfQuestions);;
	}

	public String getTfMinNumber() {
		return tfMinNumber.getText();
	}

	public void setTfMinNumber(String fMinNumber) {
		this.tfMinNumber.setText(fMinNumber);;
	}

	public String getTfMaxNumber() {
		return tfMaxNumber.getText();
	}

	public void setTfMaxNumber(String string) {
		this.tfMaxNumber.setText(string);
	}

	public String getTfNrOfDecimals() {
		return tfNrOfDecimals.getText();
	}

	public void setTfNrOfDecimals(String tfNrOfDecimals) {
		this.tfNrOfDecimals.setText(tfNrOfDecimals);;
	}

	public boolean getRbAddition() {
		return rbAddition.isSelected();
	}

	public void setRbAddition(boolean isSelected) {
		this.rbAddition.setSelected(isSelected);
	}

	public boolean getRbSubstraction() {
		return rbSubstraction.isSelected();
	}

	public void setRbSubstraction(boolean isSelected) {
		this.rbSubstraction.setSelected(isSelected);
	}

	public boolean getRbMultiplication() {
		return rbMultiplication.isSelected();
	}

	public void setRbMultiplication(boolean isSelected) {
		this.rbMultiplication.setSelected(isSelected);
	}

	public boolean getRbDivision() {
		return rbDivision.isSelected();
	}
	
	public void setRbDivision(boolean isSelected) {
		this.rbDivision.setSelected(isSelected);
	}
	
	public void showMessage(String s){
		JOptionPane.showMessageDialog(null, s);
	}
	
	public void setLabelExercise(String string) {
		this.labelExercise.setText(string);		
	}

	private void setUp(){
		labelNrOfQuestions = new JLabel("Aantal vragen: ");
		labelMinNumber = new JLabel("Minimum bereik: ");
		labelMAxNumber = new JLabel("Maximum bereik: ");
		labelNrOfDecimals = new JLabel("Aantal decimalen: ");
		labelOperators = new JLabel("Bewerkingen: ");
		labelStringExercise = new JLabel("Oefening");
		labelExercise = new JLabel("");
		labelExercise.setBackground(Color.PINK);
		
		tfNrOfDecimals = new JFormattedTextField(NumberFormat.getIntegerInstance());
		tfNrOfDecimals.setFocusLostBehavior(JFormattedTextField.COMMIT_OR_REVERT);
		tfNrOfQuestions = new JFormattedTextField(NumberFormat.getIntegerInstance());
		tfNrOfQuestions.setFocusLostBehavior(JFormattedTextField.COMMIT_OR_REVERT);
		tfMaxNumber = new JFormattedTextField(NumberFormat.getIntegerInstance());
		tfMaxNumber.setFocusLostBehavior(JFormattedTextField.COMMIT_OR_REVERT);
		tfMinNumber = new JFormattedTextField(NumberFormat.getIntegerInstance());
		tfMinNumber.setFocusLostBehavior(JFormattedTextField.COMMIT_OR_REVERT);
		tfUserInput = new JTextField(3);
		
		rbAddition = new JCheckBox("+");
		rbSubstraction = new JCheckBox("-");
		rbMultiplication = new JCheckBox("*");
		rbDivision = new JCheckBox("/");
		
		startExercises = new JButton("Start");
		checkAnswer = new JButton("Controleer");
		checkAnswer.setEnabled(false);

		layout = new SpringLayout();
		layout.putConstraint(SpringLayout.WEST, tfNrOfDecimals, 6, SpringLayout.EAST, labelNrOfDecimals);
		layout.putConstraint(SpringLayout.EAST, tfNrOfDecimals, 0, SpringLayout.EAST, tfMaxNumber);
		layout.putConstraint(SpringLayout.EAST, tfMaxNumber, 0, SpringLayout.EAST, tfNrOfQuestions);
		layout.putConstraint(SpringLayout.EAST, tfMinNumber, 0, SpringLayout.EAST, tfNrOfQuestions);
		layout.putConstraint(SpringLayout.WEST, tfMaxNumber, 11, SpringLayout.EAST, labelMAxNumber);
		layout.putConstraint(SpringLayout.EAST, tfNrOfQuestions, -35, SpringLayout.WEST, labelOperators);
		layout.putConstraint(SpringLayout.WEST, tfMinNumber, 15, SpringLayout.EAST, labelMinNumber);
		layout.putConstraint(SpringLayout.WEST, tfNrOfQuestions, 19, SpringLayout.EAST, labelNrOfQuestions);
		layout.putConstraint(SpringLayout.WEST, checkAnswer, 26, SpringLayout.EAST, tfUserInput);
		layout.putConstraint(SpringLayout.WEST, tfUserInput, -27, SpringLayout.WEST, labelOperators);
		layout.putConstraint(SpringLayout.NORTH, checkAnswer, 0, SpringLayout.NORTH, labelExercise);
		layout.putConstraint(SpringLayout.NORTH, tfUserInput, 1, SpringLayout.NORTH, labelExercise);
		layout.putConstraint(SpringLayout.SOUTH, tfUserInput, -2, SpringLayout.SOUTH, labelExercise);
		layout.putConstraint(SpringLayout.EAST, tfUserInput, 0, SpringLayout.EAST, labelOperators);
		layout.putConstraint(SpringLayout.NORTH, rbDivision, -4, SpringLayout.NORTH, labelMinNumber);
		layout.putConstraint(SpringLayout.WEST, rbDivision, 0, SpringLayout.WEST, rbMultiplication);
		layout.putConstraint(SpringLayout.EAST, rbAddition, -144, SpringLayout.EAST, getContentPane());
		layout.putConstraint(SpringLayout.NORTH, rbMultiplication, -4, SpringLayout.NORTH, labelNrOfQuestions);
		layout.putConstraint(SpringLayout.WEST, rbMultiplication, 6, SpringLayout.EAST, rbAddition);
		layout.putConstraint(SpringLayout.NORTH, rbSubstraction, -4, SpringLayout.NORTH, labelMinNumber);
		layout.putConstraint(SpringLayout.WEST, rbSubstraction, 0, SpringLayout.WEST, rbAddition);
		layout.putConstraint(SpringLayout.NORTH, tfMinNumber, -3, SpringLayout.NORTH, labelMinNumber);
		layout.putConstraint(SpringLayout.NORTH, tfNrOfQuestions, -3, SpringLayout.NORTH, labelNrOfQuestions);
		layout.putConstraint(SpringLayout.NORTH, tfMaxNumber, -3, SpringLayout.NORTH, labelMAxNumber);
		layout.putConstraint(SpringLayout.NORTH, tfNrOfDecimals, -3, SpringLayout.NORTH, labelNrOfDecimals);
		layout.putConstraint(SpringLayout.NORTH, labelNrOfQuestions, 0, SpringLayout.NORTH, labelOperators);
		layout.putConstraint(SpringLayout.WEST, labelNrOfQuestions, 0, SpringLayout.WEST, labelMAxNumber);
		layout.putConstraint(SpringLayout.NORTH, rbAddition, 6, SpringLayout.NORTH, getContentPane());
		layout.putConstraint(SpringLayout.NORTH, labelOperators, 4, SpringLayout.NORTH, rbAddition);
		layout.putConstraint(SpringLayout.EAST, labelOperators, -6, SpringLayout.WEST, rbAddition);
		layout.putConstraint(SpringLayout.EAST, startExercises, -195, SpringLayout.EAST, getContentPane());
		layout.putConstraint(SpringLayout.WEST, labelExercise, 10, SpringLayout.WEST, getContentPane());
		layout.putConstraint(SpringLayout.EAST, labelExercise, -305, SpringLayout.EAST, getContentPane());
		layout.putConstraint(SpringLayout.NORTH, startExercises, -4, SpringLayout.NORTH, labelNrOfDecimals);
		layout.putConstraint(SpringLayout.NORTH, labelMinNumber, 35, SpringLayout.NORTH, getContentPane());
		layout.putConstraint(SpringLayout.NORTH, labelExercise, 25, SpringLayout.SOUTH, labelStringExercise);
		layout.putConstraint(SpringLayout.SOUTH, labelExercise, 48, SpringLayout.SOUTH, labelStringExercise);
		layout.putConstraint(SpringLayout.NORTH, labelStringExercise, 36, SpringLayout.SOUTH, labelNrOfDecimals);
		layout.putConstraint(SpringLayout.WEST, labelStringExercise, 10, SpringLayout.WEST, getContentPane());
		layout.putConstraint(SpringLayout.WEST, labelMinNumber, 10, SpringLayout.WEST, getContentPane());
		layout.putConstraint(SpringLayout.NORTH, labelNrOfDecimals, 16, SpringLayout.SOUTH, labelMAxNumber);
		layout.putConstraint(SpringLayout.WEST, labelNrOfDecimals, 0, SpringLayout.WEST, labelMAxNumber);
		layout.putConstraint(SpringLayout.NORTH, labelMAxNumber, 16, SpringLayout.SOUTH, labelMinNumber);
		layout.putConstraint(SpringLayout.WEST, labelMAxNumber, 0, SpringLayout.WEST, labelMinNumber);
		
		getContentPane().setLayout(layout);
		getContentPane().add(labelMAxNumber);
		getContentPane().add(labelMinNumber);
		getContentPane().add(labelNrOfQuestions);
		getContentPane().add(labelNrOfDecimals);
		getContentPane().add(labelOperators);
		getContentPane().add(tfMaxNumber);
		getContentPane().add(tfNrOfQuestions);
		getContentPane().add(tfNrOfDecimals);
		getContentPane().add(tfMinNumber);
		getContentPane().add(startExercises);
		getContentPane().add(rbAddition);
		getContentPane().add(rbDivision);
		getContentPane().add(rbMultiplication);
		getContentPane().add(rbSubstraction);
		getContentPane().add(labelExercise);
		getContentPane().add(labelStringExercise);
		getContentPane().add(checkAnswer);
		getContentPane().add(tfUserInput);
	}

	
	
}
