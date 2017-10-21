package testing;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import model.Calculator;


/**
 * 	@Author Ben Vandevorst
	@Datum 09/10/2017
	@Project Calculator
	@Doel TestingUnit for CalculationClass
 */


public class CalculationsTest {
	private Calculator calculator;
	private double testGetal;
	private double accuracyResult;
	
	@Before
	public void setUp(){
		this.calculator = new Calculator();
		testGetal = 100;
		accuracyResult = 0.0;
	}
	
	@Test
	public void test_division_deler0_wordt_niet_aanvaard() {
		double testWaarde = calculator.result(testGetal, 0, Calculator.DIV);
		
		assertEquals(0, testWaarde, accuracyResult);
	}
	
	@Test
	public void test_division_geldig_parameter_wordt_aanvaard(){
		double testWaarde = calculator.result(testGetal, 5, Calculator.DIV);
		
		assertEquals(20, testWaarde, accuracyResult);
	}
	
	@Test
	public void test_multiplication_geldig_parameter_wordt_aanvaard(){
		double testWaarde = calculator.result(testGetal, 5, Calculator.MULT);
		
		assertEquals(500, testWaarde, accuracyResult);
	}
	
	@Test
	public void test_substraction_geldig_parameter_wordt_aanvaard(){
		double testWaarde = calculator.result(testGetal, 5, Calculator.SUB);
		
		assertEquals(95, testWaarde, accuracyResult);
	}
	
	@Test
	public void test_addition_geldig_parameter_wordt_aanvaard(){
		double testWaarde = calculator.result(testGetal, 5, Calculator.ADD);
		
		assertEquals(105, testWaarde, accuracyResult);
	}	

}
