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
	
	public enum commands {
		empty,
		calcspeed,
	}

	
	public static void initHeader(){
		
		try {
	
			DateFormat df = new SimpleDateFormat("dd-MM-yy_HH-mm-ss");
			Date currdate = new Date();

			fos = new FileOutputStream(df.format(currdate) + ".paplog", true);
			log = new PrintStream(fos);		
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		IO.println(" _____ _____ _____    ___     ___");
		IO.println("|  _  |   __|  _  |  |_  |   |   |");
		IO.println("|   __|   __|   __|   _| |_ _| | |");
		IO.println("|__|  |__|  |__|     |_____|_|___|");
		
		
		for(int i = 0; i < 100; i++){
			IO.print("*");
		}
		
		IO.println("\n WARNING: In this build distance calculations are broken");
		
		for(int i = 0; i < 100; i++){
			IO.print("*");
		}
		
		IO.println("");
		
		IO.println("calcspeed @speed @force @mass @initialtime @finaltimee");
		IO.println("convert-ms/km - Converts between m/s and km/h");
		IO.println("convert-km/ms - Converts between km/h and m/s");
		IO.println("test (Runs a test calcspeed)");
		
		
		for(int i = 0; i < 100; i++){
			IO.print("*");
		}
		IO.println("");
	}
	public static void print(String s){
			log.print(s);
			System.out.print(s);
	}
	
	public static void println(String s){
			
			log.println(s);
			System.out.println(s);
	}
	public String nextIn(){
		return in.nextLine();
	}
}
