package values;

public enum DefaultSettings {
	stringPath("resources/config.properties"),
	numberOfQuestions("20"),
	minimumNumber("0"),
	maximumNumber("40"),
	isRoundNumber("True"),
	operators("+, -, *, /");
	
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
