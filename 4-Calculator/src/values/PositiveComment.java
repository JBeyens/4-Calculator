package values;


/**
 * 	@Author Ben Vandevorst & Jef Beyens
	@Datum 24/10/2017
	@Project Calculator
	@Doel Comment to show user when answering correct
 */

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
	
	public static PositiveComment getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
	
	@Override
	public String toString(){
		return getValue();
	}
}
