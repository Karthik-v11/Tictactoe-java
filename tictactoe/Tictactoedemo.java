package tictactoe;
import java.util.Scanner;

public class Tictactoedemo {

	public static void main(String[] args) throws Myexception {
		
		Scanner scan=new Scanner(System.in);
		Tictactoe ox=new Tictactoe();
		System.out.println("Welcome to tic tac toe");
		ox.printboard();
		System.out.println("1) Versus CPU");
		System.out.println("2) 2 Players");
		
		while(true) {
		try {
			System.out.println("Press 1 or 2");
			int input=scan.nextInt();
			ox.gettype(input);
			break;
		}
		catch(Myexception e) {
			System.out.println(e);
		}
		
		}
		scan.close();
		
	}

}
