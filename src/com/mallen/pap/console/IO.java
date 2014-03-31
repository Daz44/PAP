package com.mallen.pap.console;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.mallen.pap.physics.CalcSpeed;
import com.mallen.pap.physics.Convert;

public class IO {
	
	private static PrintStream log;
	private static FileOutputStream fos;
	private static Scanner in = new Scanner(System.in);

	/**
	 * Configures the PrintStreams for the application, and draws the welcome message for the applications
	 * TO BE REFACTORED
	 */
	public static void init(){
		try {
			DateFormat df = new SimpleDateFormat("dd-MM-yy_HH-mm-ss");
			Date currdate = new Date();

			fos = new FileOutputStream("log.paplog", true);
			log = new PrintStream(fos);		
			IO.logln("\n\n\n" + df.format(currdate)); // Sets space before begin logging, helps split diffrent execution of project in log.paplog
			
		} catch (FileNotFoundException e) {
			IO.logln("[ERROR] " + e.getClass() + e.getCause() + e.getMessage() + e.getStackTrace()); // Wont happen, file WILL be created
		}
			IO.println(" _____ _____ _____ ");
			IO.println("|  _  |   __|  _  |");
			IO.println("|   __|   __|   __|");
			IO.println("|__|  |__|  |__|   ");
			IO.println("(C) Matthew Allen 2014 - MIT LICENSE");
			
			IO.breakln();
			IO.println("DEBUILD 0.1A");
			IO.breakln();
	}
	
	/**
	 * Draws a line break out of hyphens, 100 Chars long 
	 * NO ARGS
	 */
	public static void breakln(){
		for(int i = 0; i < 100; i++){
			IO.print("-");
		}
		    IO.print("\n");
	}
	/**
	 * Redirects String s to the default System.out and logs to a FileOutputStream (FOS)
	 * @param s String to print
	 */
	public static void print(String s){
			log.print(s);
			System.out.print(s);
	}
	/**
	 * Redirects String s to the default System.out and logs to a FileOutputStream (FOS)
	 * @param s String to print
	 */
	public static void println(String s){
			
			log.println(s);
			System.out.println(s);
	}
	/**
	 * Redirects String s to a FileOutputStream (FOS)
	 * @param s String to print
	 */
	public static void logln(String s){
			log.println(s);
	}
	/**
	 * Waits for an input on the default System.in IO stream
	 * @return
	 */
	public static String nextIn(){
			return in.nextLine();
	}
}
