package values;

public enum NegativeComment {
	firstComment("Volgende keer meer succes!"),
	secondComment("Beetje harder uw best doen!"),
	thirdComment("De volgende zal wel lukken!");
	
	private String name;
	
	NegativeComment(String name){
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
