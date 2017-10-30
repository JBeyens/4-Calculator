package values;


/**
 * 	@Author Ben Vandevorst & Jef Beyens
	@Datum 09/10/2017
	@Project Calculator
	@Doel Holding default values
 */

public enum DefaultSettings {
	stringPath("resources/config.properties"),
	nrOfQuestions("10"),
	minimumNumber("0"),
	maximumNumber("20"),
	nrOfDecimals("0"),
	operators("+,-,*,/");
	
	private final String name;
	
	DefaultSettings(String name){
		this.name = name;
	}
	
	public String getValue(){
		return name;
	}
	
	@Override
	public String toString(){
		return this.name();
	}
	
}
