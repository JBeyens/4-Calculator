package values;

public enum DefaultSettings {
	stringPath("resources/config.properties"),
	nrOfQuestions("20"),
	minimumNumber("0"),
	maximumNumber("40"),
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
