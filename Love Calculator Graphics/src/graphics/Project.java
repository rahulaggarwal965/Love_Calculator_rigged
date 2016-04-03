package graphics;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.SwingUtilities;

public class Project {
	static Scanner scn;
	public static int compatibility;
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				Window window = new Window();
			}
			
		});
	}
	
	public static int getCompatibility() {
		try {
			scn = new Scanner(new File("input.txt")); //update input file path
			compatibility = scn.nextInt();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(compatibility);
		return compatibility;
	}
	
	public static void writeNames(String name1, String name2) {
		try {
			FileWriter fw = new FileWriter(new File("output.txt"));
			fw.write(name1 + "\n" + name2);
			fw.flush();
			fw.close();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void callPython() { //<---- RAHUL YOU NEED TO LOOK AT THIS 
		/*
		 * TODO 
		 * INPUT- JAVA CODE (EU)
		 * SOMEHOW CALL PYTHON CODE HERE
		 * PYTHON CODE FILE IO FROM OUTPUT.TXT AND GETS NAMES
		 * RUNS, RETURNS COMPATIBILITY, FILE IO TO INPUT.TXT
		 * RETURN- JAVA CODE (EU)
		 */
		try {
			Process p = Runtime.getRuntime().exec("python yourapp.py");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
