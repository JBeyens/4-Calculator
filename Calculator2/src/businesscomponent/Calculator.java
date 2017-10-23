package businesscomponent;

/**
 * @Autor: Jef Beyens
 * @Date: 16/10/2016
 * @Project: Calculator
 * @Purpose: BusinessComponent class to calculate results
 */
public class Calculator {

	public static final String ADD = "+";
	public static final String SUB = "-";
	public static final String MULT = "*";
	public static final String DIV = "/";
	
	
	public Calculator() {
		// TODO Auto-generated constructor stub
	}
	
	public static double doCalculation(double input1, double input2, String operation) throws Exception
	{
		double result = 0;
		
		switch (operation) 
		{
			case ADD:
				result = input1 + input2;
				break;
			case SUB:
				result = input1 - input2;
				break;
			case MULT:
				result = input1 * input2;
				break;
			case DIV:
				if (input2 == 0)
				    throw new IllegalArgumentException("Division by zero not allowed");
				
				result = input1 / input2;
				break;

			default:
				throw new Exception("Invalid operation");
		}
		
		return result;
	}

}
