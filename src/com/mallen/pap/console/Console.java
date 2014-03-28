package com.mallen.pap.console;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.mallen.pap.physics.threads.CalcPhys;

public class Console {
	
	public static PrintStream log;
	public static FileOutputStream fos;
	
	
	public enum commands {
		empty,
		calcspeed,
	}

	
	public static void initHeader(){
		
		try {
	
			DateFormat df = new SimpleDateFormat("dd-MM-yy_HH-mm-ss");
			Date currdate = new Date();

			fos = new FileOutputStream("PAP_Log-" + df.format(currdate) + ".txt", true);
			log = new PrintStream(fos);		
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		Console.println(" _____ _____ _____    ___     ___");
		Console.println("|  _  |   __|  _  |  |_  |   |   |");
		Console.println("|   __|   __|   __|   _| |_ _| | |");
		Console.println("|__|  |__|  |__|     |_____|_|___|");
		
		for(int i = 0; i < 100; i++){
			Console.print("*");
		}
		
		Console.println("");
		
		Console.println("calcspeed @speed @force @mass @initialtime @finaltimee");
		Console.println("test (Runs a test calcspeed)");
		
		
		for(int i = 0; i < 100; i++){
			Console.print("*");
		}
		Console.println("");
	}
	public static void print(String s){
			log.print(s);
			System.out.print(s);
	}
	
	public static void println(String s){
			
			log.println(s);
			System.out.println(s);
	}
	
	public static void log(String s){
			log.println(s);
	}
	
	public static void waitandparse(){
		Scanner in = new Scanner(System.in);
		Console.print("> ");
		
		String input = in.nextLine();
		String[] inputarray = input.split(" ");	
		commands parsecommand = commands.empty;
		
		Console.log("<IN> " + input);
		
		if(inputarray[0].equals("exit")){
			log.flush();
			log.close();
			System.exit(0);
		}
		
		if(inputarray[0].equals("test")){
			CalcPhys.setSpeed(0);
			CalcPhys.setMass(640);
			CalcPhys.setForce(5000);
			CalcPhys.setTime(0, 10);
			CalcPhys.printAcceleration();
		}

		if(inputarray[0].equals("calcspeed")){

				CalcPhys.setSpeed(Double.parseDouble(inputarray[1]));
				Console.println("> Speed set to " + inputarray[1]);


				CalcPhys.setForce(Double.parseDouble(inputarray[2]));
				Console.println("> Force set to " + inputarray[2]);


				CalcPhys.setMass(Double.parseDouble(inputarray[3]));
				Console.println("> Mass set to " + inputarray[3]);
				
				CalcPhys.setTime(Double.parseDouble(inputarray[4]), Double.parseDouble(inputarray[5]));
				Console.println("> Time set to " + inputarray[4]);
				
				Console.println("> Executed...");
				CalcPhys.printAcceleration();

		}
		
		Console.waitandparse();
		
	}
}
