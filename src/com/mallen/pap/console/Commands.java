package com.mallen.pap.console;

import java.util.Scanner;

import com.mallen.pap.console.IO.commands;
import com.mallen.pap.physics.CalcAcel;
import com.mallen.pap.physics.CalcSpeed;
import com.mallen.pap.physics.Convert;

public class Commands {
	public static void waitforin(){
		Scanner in = new Scanner(System.in);
		IO.print("> ");
		
		String input = in.nextLine();
		String[] ia = input.split(" ");	
		
		IO.logln("<IN> " + input);
		Commands.parse(ia);
	}
	public static void parse(String[] inputarray){
		if(inputarray[0].equals("exit")){
			System.exit(0);
		}
		
		if(inputarray[0].equals("commands")){
			IO.println("> calc_speed @speed @force @airrestistance (per m/s) @mass @initialtime @finaltimee or @acel @initialtime @finaltime");
			IO.println("> calc_acel @force @mass");
			IO.println("> convert-ms/km - Converts between m/s and km/h");
			IO.println("> convert-km/ms - Converts between km/h and m/s");
			IO.println("> test (Runs a test calcspeed)");		
		}
		
		if(inputarray[0].equals("test")){
			CalcSpeed.set(0, 1000, 0 , 320, 0, 21600);
			CalcSpeed.printSpeed();
		}

		if(inputarray[0].equals("calc_speed")){
				
				if(inputarray.length == 4){
					CalcSpeed.set(0, Double.parseDouble(inputarray[1]), 0, 1, Double.parseDouble(inputarray[2]), Double.parseDouble(inputarray[3]));
				} else {
					CalcSpeed.set(Double.parseDouble(inputarray[1]), Double.parseDouble(inputarray[2]), Double.parseDouble(inputarray[3]), Double.parseDouble(inputarray[4]), Double.parseDouble(inputarray[5]), Double.parseDouble(inputarray[6]));
				}
					CalcSpeed.printSpeed();
		}
		if(inputarray[0].equals("calc_acel")){
				
				CalcAcel.set(Double.parseDouble(inputarray[1]), Double.parseDouble(inputarray[2]));
				CalcAcel.printAcel();
		}
		
		if(inputarray[0].equals("convert-ms/km")){
			IO.println("> " + Convert.mToKm(Double.valueOf(inputarray[1])));
		}
		if(inputarray[0].equals("convert-km/ms")){
			IO.println("> " + Convert.kmToM(Double.valueOf(inputarray[1])));
		}
		
		
		waitforin();
		
	}
}
