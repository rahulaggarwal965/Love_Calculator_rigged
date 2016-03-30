import java.util.HashMap;
import java.util.Scanner;

import t.Q;

import static t.Q.*;
public class LoveFinder {
	static HashMap<Integer, String> loveValues = new HashMap<Integer, String>();
	static String s1;
	static String s2;
	static int compatibility;
	static Scanner scn = new Scanner(System.in);
	
	public static void assignValues() {
		loveValues.put(0, "Potato Love");
		loveValues.put(100, "True Love");
	}
	
	public static void main(String[] args) {
		assignValues();
		System.out.println("Enter Name 1: ");
		s1 = scn.nextLine();
		System.out.println("Enter Name 2: ");
		s2 = scn.nextLine();
		
		int n = s1.length() % s2.length();
		if(n != 0 || n != 1) n = s2.length() % s1.length();
		if(n != 0 || n != 1) n = 0;
		else n = 100;
		
		System.out.println("Compatibility Level is: " + loveValues.get(n) + " or " + n + "%");
	}

}
