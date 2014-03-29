package com.mallen.pap.console;

import java.util.Scanner;

import com.mallen.pap.console.IO.commands;
import com.mallen.pap.physics.CalcAcel;
import com.mallen.pap.physics.CalcSpeed;
import com.mallen.pap.physics.Convert;

public class Commands {
	public static void waitandparse(){
		Scanner in = new Scanner(System.in);
		IO.print("> ");
		
		String input = in.nextLine();
		String[] inputarray = input.split(" ");	
		commands parsecommand = commands.empty;
		
		IO.logln("<IN> " + input);
		
		if(inputarray[0].equals("exit")){
			System.exit(0);
		}
		
		if(inputarray[0].equals("test")){
			CalcSpeed.set(0, 1000, 320, 0, 60);
			CalcSpeed.printSpeed();
		}

		if(inputarray[0].equals("calc_speed")){
				
				if(inputarray.length == 4){
					CalcSpeed.set(0, Double.parseDouble(inputarray[1]), 1, Double.parseDouble(inputarray[2]), Double.parseDouble(inputarray[3]));
				} else {
					CalcSpeed.set(Double.parseDouble(inputarray[1]), Double.parseDouble(inputarray[2]), Double.parseDouble(inputarray[3]), Double.parseDouble(inputarray[4]), Double.parseDouble(inputarray[5]));
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
		
		
		waitandparse();
		
	}
}
