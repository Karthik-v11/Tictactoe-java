package tictactoe;

import java.util.ArrayList;
import java.util.Scanner;

public class TTT2P extends Tictactoe {
	Scanner sc=new Scanner(System.in);
	int pos;
	boolean win=false;
	boolean draw=false;
	boolean lose=false;
	String second;
	int turn=0;
	ArrayList<Integer> array=new ArrayList<Integer>(9);
	ArrayList<Integer> parray=new ArrayList<Integer>(9);
	ArrayList<Integer> carray=new ArrayList<Integer>(9);

	public TTT2P() {
		System.out.println("Welcome to 2 Player tic-tac-toe");
		System.out.println("1P is X and 2P is O");
		while(!win && !draw && !lose) {
			start();
		}
		
	}
	void start() {
		System.out.println("1P will make their move");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		place("Player1");
		if(!checkstate()) {
			System.out.println("2P will make their move");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			place("Player2");
		}

		}
	void place(String player) {
		while(true) {	
			System.out.println("Enter your placement(0 to 9)");
			pos=sc.nextInt();
			if(array.contains(pos)) {
				System.out.println("Invalid placement");
				System.out.println("re-enter your placement");
			}
			else {
				array.add(pos);
				if(player=="Player1") {
					parray.add(pos);
				}
				else {
					carray.add(pos);
				}
				turn++;
				break;
			}
			}
			super.play(pos, player);
			super.printboard();
			checkstate();
	}
	boolean checkstate() {
		boolean none=false;
		for(int a=0;a<16;a++) {
			switch(a) {
			case 0: 
				win=parray.contains(1)&& parray.contains(2)&&parray.contains(3);
				break;
			case 1: 
				win=parray.contains(4)&& parray.contains(5)&&parray.contains(6);
				break;
			case 2: 
				win=parray.contains(7)&& parray.contains(8)&& parray.contains(9);
				break;
			case 3: 
				win=parray.contains(1)&& parray.contains(4)&& parray.contains(7);
				break;
			case 4: 
				win=parray.contains(2)&& parray.contains(5)&& parray.contains(8);
				break;
			case 5: 
				win=parray.contains(3)&& parray.contains(6)&&parray.contains(9);
				break;
			case 6: 
				win=parray.contains(1)&& parray.contains(5)&&parray.contains(9);
				break;
			case 7: 
				win=parray.contains(3)&& parray.contains(5)&&parray.contains(7);
				break;
			case 8: 
				lose=carray.contains(1)&& carray.contains(2)&&carray.contains(3);
				break;
			case 9: 
				lose=carray.contains(4)&& carray.contains(5)&&carray.contains(6);
				break;
			case 10: 
				lose=carray.contains(7)&& carray.contains(8)&&carray.contains(9);
				break;
			case 11: 
				lose=carray.contains(1)&& carray.contains(4)&&carray.contains(7);
				break;
			case 12: 
				lose=carray.contains(2)&& carray.contains(5)&& carray.contains(8);
				break;
			case 13: 
				lose=carray.contains(3)&& carray.contains(6)&&carray.contains(9);
				break;
			case 14: 
				lose=carray.contains(1)&& carray.contains(5)&&carray.contains(9);
				break;
			case 15: 
				lose=carray.contains(3)&& carray.contains(5)&&carray.contains(7);
				break;	
		}
		if(win) {
				return win;
		}else if(lose) {
				return lose;
		}
		}
		
		if(turn==9) {
			if(!win) {
				draw=true;
				return draw;
			}
		}
		return none;	
	}
}

