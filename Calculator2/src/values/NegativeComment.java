package values;


/**
 * 	@Author Ben Vandevorst & Jef Beyens
	@Datum 09/10/2017
	@Project Calculator
	@Doel Comment to show user when making mistake
 */

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
	
	public static NegativeComment getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
	
	@Override
	public String toString(){
		return getValue();
	}
}
