package tictactoe;

public class Tictactoe {
	char[][] board={{' ','|',' ','|',' '},
			{'-','+','-','+','-'},
			{' ','|',' ','|',' '},
			{'-','+','-','+','-'},
			{' ','|',' ','|',' '}};;
	
	Tictactoe(){}
	
	
	void printboard(){
		for(char[] i:board) {
			for(char c:i) {
				System.out.print(c);
			}
			System.out.println();
		}
	}
	
	
	void gettype(int input) throws Myexception{
		if(input==1) {
			TTTCPU ttt=new TTTCPU();
			if(ttt.win) {
				System.out.println("You Win congrats!!");
			}
			else if(ttt.lose) {
				System.out.println("You Lose");
			}
			else {
				System.out.println("Draw");
			}
		}
		else if(input==2){
			TTT2P ttt=new TTT2P();
			if(ttt.win) {
				System.out.println("Player1 Win congrats!!");
			}
			else if(ttt.lose) {
				System.out.println("Player2 Win Congrats!!");
			}
			else if(ttt.draw){
				System.out.println("Draw123");
			}	
		}
		else {
			throw new Myexception("wrong input");
		}
	}
	
	
	void play(int pos,String user) {
		char symbol=' ';
		if(user=="Player1") {
			symbol='X';
		}
		else if(user=="Player2" || user=="CPU") {
			symbol='O';
		}
		
		switch(pos) {
		case 1:
			board[0][0]=symbol;
			return;
		case 2:
			board[0][2]=symbol;
			return;
		case 3:
			board[0][4]=symbol;
			return;
		case 4:
			board[2][0]=symbol;
			return;
		case 5:
			board[2][2]=symbol;
			return;
		case 6:
			board[2][4]=symbol;
			return;
		case 7:
			board[4][0]=symbol;
			return;
		case 8:
			board[4][2]=symbol;
			return;
		case 9:
			board[4][4]=symbol;
			return;
		}
	}
	
				
				

}
