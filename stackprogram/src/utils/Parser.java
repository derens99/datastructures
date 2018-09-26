package utils;

public class Parser {
	
	public static void main(String[] args) {
		System.out.println(parseInt("-23"));
	}
	
	public static int parseInt(String n){
		boolean negative = false;
		int answer = 0;
		if(n.charAt(0) == '-'){
			negative = true;
			n = n.substring(1);
		}
		
		for(int i = 0; i < n.length(); i++){
			answer += Character.getNumericValue(n.charAt(i)) * Math.pow(10,  n.length() - i -1);
		}
		return negative ? (answer*-1) : answer;
	}

	public static double parseDouble(String n){
		boolean negative=false;
		if(n.charAt(0) == '-'){
			negative = true;
			n = n.substring(1);
		}
		
		int decIndex = n.indexOf(".");
		int whole = parseInt(n.substring(0, decIndex));
		String decimal = n.substring(decIndex+1);
		
		double d = parseInt(decimal);
		d = d / Math.pow(10, decimal.length());
		
		return negative ? ((whole+d)*-1) : (whole+d);
	}
	
}
