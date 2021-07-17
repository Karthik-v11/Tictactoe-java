package tictactoe;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class TTTCPU extends Tictactoe {
	Scanner sc=new Scanner(System.in);
	int pos;
	boolean win=false;
	boolean draw=false;
	boolean lose=false;
	String second;
	ArrayList<Integer> array=new ArrayList<Integer>(9);
	ArrayList<Integer> parray=new ArrayList<Integer>(9);
	ArrayList<Integer> carray=new ArrayList<Integer>(9);
	int turn=0;
	
	TTTCPU() {
		System.out.println("Welcome to tic-tac-toe against cpu");
		System.out.println("You are X");
		System.out.println("Would you like to go first");
		System.out.println("Press y or n");
		String first=sc.next();
		
		while(!win && !draw && !lose) {
			try {
				play(first);
				if(checkstate()) {
					break;
				}
				play(second);
				if(checkstate()) {
					break;
				}
			} catch (Myexception e) {
				System.out.println(e);
			}
		}
		sc.close();			
	}
	
	
	void play(String first) throws Myexception {
		if(first.equals("y")|| first.equals("Y")) {
			second="n";
			while(true) {	
			System.out.println("Enter your placement(0 to 9)");
			pos=sc.nextInt();
			if(array.contains(pos)) {
				System.out.println("Invalid placement");
				System.out.println("re-enter your placement");
			}
			else {
				array.add(pos);
				parray.add(pos);
				turn++;
				break;
			}
			}
			super.play(pos, "Player1");
			super.printboard();	
		}
		else if(first.equals("n")|| first.equals("N")) {
			second="y";
			System.out.println("CPU makings its move");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println("interrupted");
			}
			Random rand=new Random();
			while(true) {
			pos=rand.nextInt(9)+1;
			if(array.contains(pos)) {}
			else {
				array.add(pos);
				carray.add(pos);
				turn++;
				break;
			}
			}
			super.play(pos, "CPU");
			super.printboard();
		}
		else {
			throw new Myexception("Invalid choice");
		}
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
				win=parray.contains(7)&& parray.contains(8)&&parray.contains(9);
				break;
			case 3: 
				win=parray.contains(1)&& parray.contains(4)&&parray.contains(7);
				break;
			case 4: 
				win=parray.contains(2)&& parray.contains(5)&&parray.contains(8);
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
				lose=carray.contains(2)&& carray.contains(5)&&carray.contains(8);
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
