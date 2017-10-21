package values;


/**
 * 	@Author Ben Vandevorst
	@Datum 09/10/2017
	@Project Calculator
	@Doel 
 */

public enum DefaultOperators {
	addition("+"),
	substraction("-"),
	multiplication("*"),
	division("/");
	
	private final String name;
	
	DefaultOperators(String name){
		this.name = name;
	}
	
	@Override
	public String toString(){
		return this.name;
	}
}

