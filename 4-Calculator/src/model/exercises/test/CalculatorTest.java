package model.exercises.test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import model.exercises.Calculator;


/**
 * 	@Author Ben Vandevorst & Jef Beyens
	@Datum 09/10/2017
	@Project Calculator
	@Doel TestingUnit for CalculationClass
 */


public class CalculatorTest {
	private double testGetal;
	private double accuracyResult;
	
	@Before
	public void setUp(){
		testGetal = 100;
		accuracyResult = 0.0;
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void test_division_deler0_wordt_niet_aanvaard() throws Exception {
		Calculator.doCalculation(testGetal, 0, Calculator.DIV);
	}
	
	@Test
	public void test_division_geldig_parameter_wordt_aanvaard() throws Exception{
		double testWaarde = Calculator.doCalculation(testGetal, 5, Calculator.DIV);
		
		assertEquals(20, testWaarde, accuracyResult);
	}
	
	@Test
	public void test_multiplication_geldig_parameter_wordt_aanvaard() throws Exception{
		double testWaarde = Calculator.doCalculation(testGetal, 5, Calculator.MULT);
		
		assertEquals(500, testWaarde, accuracyResult);
	}
	
	@Test
	public void test_substraction_geldig_parameter_wordt_aanvaard() throws Exception{
		double testWaarde = Calculator.doCalculation(testGetal, 5, Calculator.SUB);
		
		assertEquals(95, testWaarde, accuracyResult);
	}
	
	@Test
	public void test_addition_geldig_parameter_wordt_aanvaard() throws Exception{
		double testWaarde = Calculator.doCalculation(testGetal, 5, Calculator.ADD);
		
		assertEquals(105, testWaarde, accuracyResult);
	}	

}
