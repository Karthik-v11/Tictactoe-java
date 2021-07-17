package tictactoe;

class Myexception extends Exception{
	private String detail;
	
	Myexception(String a){
		detail=a;
	}
	public String toString() {
		return "Myexception(" + detail + ")";
	}
}