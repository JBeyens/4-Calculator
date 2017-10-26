package values;

public enum DefaultSettings {
	stringPath("resources/config.properties"),
	nrOfQuestions("19"),
	minimumNumber("0"),
	maximumNumber("39"),
	nrOfDecimals("0"),
	operators("+,-,*,/"),
	isNegative("true");
	
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
