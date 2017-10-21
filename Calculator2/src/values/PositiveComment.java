package values;

public enum PositiveComment {
	firstComment("Proficiat!"),
	secondComment("Goed zo!"),
	thirdComment("Bravo!");
	
	private String name;
	
	PositiveComment(String name){
		this.name = name;
	}
	
	public String getValue(){
		return name;
	}
	
	@Override
	public String toString(){
		return getValue();
	}
}
