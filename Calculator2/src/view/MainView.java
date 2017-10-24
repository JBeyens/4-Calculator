package view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

public class MainView extends JFrame {
	private JLabel labelNrOfQuestions;
	private JLabel labelMinNumber;
	private JLabel labelMAxNumber;
	private JLabel labelNrOfDecimals;
	private JLabel labelOperators;
	
	private JTextField tfNrOfQuestions;
	private JTextField tfMinNumber;
	private JTextField tfMaxNumber;
	private JTextField tfNrOfDecimals;
	private JList listOfOperators;
	
	private JButton startExercises;

	private SpringLayout layout;
	
	public MainView(){
		setUp();
	}
	
	private void setUp(){
		labelNrOfQuestions = new JLabel("Aantal vragen: ");
		labelMinNumber = new JLabel("Minimum bereik: ");
		labelMAxNumber = new JLabel("Maximum bereik: ");
		labelNrOfDecimals = new JLabel("Aantal decimalen: ");
		labelOperators = new JLabel("Bewerkingen: ");
		
		tfNrOfDecimals = new JTextField(3);
		tfNrOfQuestions = new JTextField(3);
		tfMaxNumber = new JTextField(3);
		tfMinNumber = new JTextField(3);
		listOfOperators = new JList<>();
		
		startExercises = new JButton("Start");
		
		layout = new SpringLayout();
		
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
		getContentPane().add(listOfOperators);
		getContentPane().add(startExercises);
	}
}
