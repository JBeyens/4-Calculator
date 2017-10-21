package businesscomponent;

/**
 * @Autor: Jef Beyens
 * @Date: 16/10/2016
 * @Project: Calculator
 * @Purpose: BusinessComponent class
 *  --> The purpose of this class is to calculate exercises. This will be done by return 'exercise' objects.
 */
public class Calculator {

	public Calculator() {
		// TODO Auto-generated constructor stub
	}
	
	public double doCalculation(double input1, double input2, String operation) throws Exception
	{
		double result = 0;
		
		switch (operation) 
		{
			case "+":
				result = input1 + input2;
				break;
			case "-":
				result = input1 - input2;
				break;
			case "*":
				result = input1 * input2;
				break;
			case "/":
				result = input1 / input2;
				break;

			default:
				throw new Exception("Invalid operation");
		}
		
		return result;
	}

}
