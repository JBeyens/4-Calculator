package view;

import java.awt.event.ActionListener;
import java.text.NumberFormat;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SpringLayout;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


/**
 * 	@Author Ben Vandevorst & Jef Beyens
	@Datum 09/10/2017
	@Project Calculator
	@Doel View to change settings and check answers
 */

public class MainView extends JFrame {
	/***/
	//JComponents
	private static final long serialVersionUID = 1L;
	private JLabel labelNrOfQuestions;
	private JLabel labelMinNumber;
	private JLabel labelMAxNumber;
	private JLabel labelNrOfDecimals;
	private JLabel labelOperators;
	private JLabel labelStringExercise;
	private JLabel labelExercise;
	
	private JSpinner tfNrOfQuestions;
	private JSpinner tfNrOfDecimals;
	private JFormattedTextField tfMinNumber;
	private JFormattedTextField tfMaxNumber;
	private JTextField tfUserInput;
	
	private JCheckBox cbAddition;
	private JCheckBox cbSubstraction;
	private JCheckBox cbMultiplication;
	private JCheckBox cbDivision;
	
	private JButton startExercises;
	private JButton checkAnswer;
	private JButton showResults;

	private SpringLayout layout;
	
	
	//Constructor
	public MainView(){
		setUp();
		this.setTitle("Calculator Exercises");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	//ActionListeners for buttons;
	public void addExerciseActionListener(ActionListener listener){
		this.checkAnswer.addActionListener(listener);
	}
	
	public void addActionListener(ActionListener listener){
		this.startExercises.addActionListener(listener);
	}
	
	public void addShowResultsActionListener(ActionListener listener){
		this.showResults.addActionListener(listener);;
	}
	
	//Function for enabling/disabling buttons
	public void setCheckAnswerButton(Boolean isEnabled){
		this.checkAnswer.setEnabled(isEnabled);
	}
	
	public void setStartExerciseButton(Boolean isEnabled){
		this.startExercises.setEnabled(isEnabled);
	}
		
	
	//Getters & Setters
	public String getTfUserInput() {
		return tfUserInput.getText();
	}
	public void setTfUserInput(String tfUserInput) {
		this.tfUserInput.setText(tfUserInput);
	}
	
	public String getLabelStringExercise() {
		return labelStringExercise.getText();
	}
	public void setLabelStringExercise(String labelExercise) {
		this.labelStringExercise.setText(labelExercise);
	}
	
	public Integer getTfNrOfQuestions() {
		return (Integer) tfNrOfQuestions.getValue();
	}

	public void setTfNrOfQuestions(String tfNrOfQuestions) {
		this.tfNrOfQuestions.setValue(Integer.parseInt(tfNrOfQuestions));
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

	public Integer getTfNrOfDecimals() {
		return (Integer) tfNrOfDecimals.getValue();
	}

	public void setTfNrOfDecimals(String tfNrOfDecimals) {
		this.tfNrOfDecimals.setValue(Integer.parseInt(tfNrOfDecimals));
	}

	public boolean getRbAddition() {
		return cbAddition.isSelected();
	}

	public void setRbAddition(boolean isSelected) {
		this.cbAddition.setSelected(isSelected);
	}

	public boolean getRbSubstraction() {
		return cbSubstraction.isSelected();
	}

	public void setRbSubstraction(boolean isSelected) {
		this.cbSubstraction.setSelected(isSelected);
	}

	public boolean getRbMultiplication() {
		return cbMultiplication.isSelected();
	}

	public void setRbMultiplication(boolean isSelected) {
		this.cbMultiplication.setSelected(isSelected);
	}

	public boolean getRbDivision() {
		return cbDivision.isSelected();
	}
	
	public void setRbDivision(boolean isSelected) {
		this.cbDivision.setSelected(isSelected);
	}
	
	public void showMessage(String s){
		JOptionPane.showMessageDialog(null, s);
	}
	
	public void setLabelExercise(String string) {
		this.labelExercise.setText(string);		
	}

	
	/*Initialization JComponents
	 *ChangeListeners to SpinnerComponent
	 *LayOut settings
	 *Adding JComponents to contentPane 
	 */
	private void setUp(){
		labelNrOfQuestions = new JLabel("Aantal vragen: ");
		labelMinNumber = new JLabel("Minimum bereik: ");
		labelMAxNumber = new JLabel("Maximum bereik: ");
		labelNrOfDecimals = new JLabel("Aantal decimalen: ");
		labelOperators = new JLabel("Bewerkingen: ");
		labelStringExercise = new JLabel("Oefening");
		labelExercise = new JLabel("");
		
		SpinnerNumberModel valueD = new SpinnerNumberModel(0,0,5,1);
		tfNrOfDecimals = new JSpinner(valueD);
		tfNrOfDecimals.addChangeListener(new ChangeListener(){
			@Override
			public void stateChanged(ChangeEvent e) {
				int max = (int) valueD.getMaximum();
				int min = (int) valueD.getMinimum();
				int user = (int) tfNrOfDecimals.getValue();
				
				if(user > max)
					setTfNrOfDecimals(Integer.toString(max));
				
				if(user < min)
					setTfNrOfDecimals(Integer.toString(min));
			}
			
		});
		SpinnerNumberModel valueQ = new SpinnerNumberModel(5, 1, 30, 1);
		tfNrOfQuestions = new JSpinner(valueQ);
		tfNrOfQuestions.addChangeListener(new ChangeListener(){
			@Override
			public void stateChanged(ChangeEvent e) {
				int max = (int) valueQ.getMaximum();
				int min = (int) valueQ.getMinimum();
				int user = (int) tfNrOfQuestions.getValue();
				
				if(user > max)
					setTfNrOfQuestions(Integer.toString(max));
				
				if(user < min)
					setTfNrOfQuestions(Integer.toString(min));
			}
			
		});
		tfMaxNumber = new JFormattedTextField(NumberFormat.getIntegerInstance());
		tfMaxNumber.setFocusLostBehavior(JFormattedTextField.COMMIT_OR_REVERT);
		tfMinNumber = new JFormattedTextField(NumberFormat.getIntegerInstance());
		tfMinNumber.setFocusLostBehavior(JFormattedTextField.COMMIT_OR_REVERT);
		
		tfUserInput = new JTextField(3);
		
		cbAddition = new JCheckBox("+");
		cbSubstraction = new JCheckBox("-");
		cbMultiplication = new JCheckBox("*");
		cbDivision = new JCheckBox("/");
		
		showResults = new JButton("Resultaten");
		startExercises = new JButton("Start");
		checkAnswer = new JButton("Controleer");
		checkAnswer.setEnabled(false);

		layout = new SpringLayout();
		layout.putConstraint(SpringLayout.SOUTH, showResults, -10, SpringLayout.SOUTH, getContentPane());
		layout.putConstraint(SpringLayout.EAST, showResults, 0, SpringLayout.EAST, labelMAxNumber);
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
		layout.putConstraint(SpringLayout.NORTH, cbDivision, -4, SpringLayout.NORTH, labelMinNumber);
		layout.putConstraint(SpringLayout.WEST, cbDivision, 0, SpringLayout.WEST, cbMultiplication);
		layout.putConstraint(SpringLayout.EAST, cbAddition, -144, SpringLayout.EAST, getContentPane());
		layout.putConstraint(SpringLayout.NORTH, cbMultiplication, -4, SpringLayout.NORTH, labelNrOfQuestions);
		layout.putConstraint(SpringLayout.WEST, cbMultiplication, 6, SpringLayout.EAST, cbAddition);
		layout.putConstraint(SpringLayout.NORTH, cbSubstraction, -4, SpringLayout.NORTH, labelMinNumber);
		layout.putConstraint(SpringLayout.WEST, cbSubstraction, 0, SpringLayout.WEST, cbAddition);
		layout.putConstraint(SpringLayout.NORTH, tfMinNumber, -3, SpringLayout.NORTH, labelMinNumber);
		layout.putConstraint(SpringLayout.NORTH, tfNrOfQuestions, -3, SpringLayout.NORTH, labelNrOfQuestions);
		layout.putConstraint(SpringLayout.NORTH, tfMaxNumber, -3, SpringLayout.NORTH, labelMAxNumber);
		layout.putConstraint(SpringLayout.NORTH, tfNrOfDecimals, -3, SpringLayout.NORTH, labelNrOfDecimals);
		layout.putConstraint(SpringLayout.NORTH, labelNrOfQuestions, 0, SpringLayout.NORTH, labelOperators);
		layout.putConstraint(SpringLayout.WEST, labelNrOfQuestions, 0, SpringLayout.WEST, labelMAxNumber);
		layout.putConstraint(SpringLayout.NORTH, cbAddition, 6, SpringLayout.NORTH, getContentPane());
		layout.putConstraint(SpringLayout.NORTH, labelOperators, 4, SpringLayout.NORTH, cbAddition);
		layout.putConstraint(SpringLayout.EAST, labelOperators, -6, SpringLayout.WEST, cbAddition);
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
		getContentPane().add(cbAddition);
		getContentPane().add(cbDivision);
		getContentPane().add(cbMultiplication);
		getContentPane().add(cbSubstraction);
		getContentPane().add(labelExercise);
		getContentPane().add(labelStringExercise);
		getContentPane().add(checkAnswer);
		getContentPane().add(tfUserInput);
		getContentPane().add(showResults);
	}
	
}
