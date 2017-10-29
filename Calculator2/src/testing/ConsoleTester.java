package testing;

public class ConsoleTester {

	public static void main(String[] args) {
		int minRange = 0;
		int maxRange = 30;
		
		for(int i=1;i<maxRange;i++){
	        for(int j=1;j<maxRange;j++){
	            if(i!=j){
	                System.out.println(i+","+j);
	            }
	        }
	    } 

	}

}
