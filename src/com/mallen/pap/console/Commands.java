package com.mallen.pap.console;

import java.util.Scanner;
import com.mallen.pap.physics.CalcAcel;
import com.mallen.pap.physics.CalcBrake;
import com.mallen.pap.physics.CalcMass;
import com.mallen.pap.physics.CalcSpeed;
import com.mallen.pap.physics.Convert;

public class Commands {
	/**
	 * Waiting for input from IO.nextIn();
	 */
	public  void waitforin(){
			IO.print("> ");
		
			String input = IO.nextIn();
			String[] ia = input.split(" ");	
		
			IO.logln("<IN> " + input);
			this.parse(ia);
	}
	/**
	 * Parses user input for waitforin(), 
	 * to determine the command to execute
	 * @param inputarray - Array derived for waitforin();
	 */
	public  void parse(String[] inputarray){	
		switch(inputarray[0].toLowerCase()){
		case "exit":
			IO.logln("[EXIT] User called exit");
			System.exit(0);
		break;
		case "commands":
			IO.println("> calc_speed @speed @force @airrestistance (per m/s) @mass @initialtime @finaltimee or @acel @initialtime @finaltime");
			IO.println("> calc_acel @force @mass");
			IO.println("> calc_brake @speed @brakerate");
			IO.println("> calc_mass @acel @force");
			IO.println("> convert-mk - Converts between m/s and km/h");
			IO.println("> convert-km - Converts between km/h and m/s");
		break;
		case "calc_speed":
			CalcSpeed.set(Double.parseDouble(inputarray[1]), Double.parseDouble(inputarray[2]), Double.parseDouble(inputarray[3]), Double.parseDouble(inputarray[4]), Double.parseDouble(inputarray[5]), Double.parseDouble(inputarray[6]));
			CalcSpeed.printSpeed();	
		break;
		case "calc_acel":
			CalcAcel ca = new CalcAcel();
			ca.set(Double.parseDouble(inputarray[1]), Double.parseDouble(inputarray[2]));
			ca.printAcel();
		break;
		case "calc_mass":
			CalcMass cm = new CalcMass();
			cm.set(Double.parseDouble(inputarray[1]), Double.parseDouble(inputarray[2]));
			cm.printMass();
		break;
		case "calc_brake":
			CalcBrake cb = new CalcBrake();
			cb.set(Double.parseDouble(inputarray[1]), Double.parseDouble(inputarray[2]));
			cb.printBrake();
		break;
		case "covert-mk":
			IO.println("> " + Convert.mToKm(Double.valueOf(inputarray[1])));
		break;
		case "convert-km":
			IO.println("> " + Convert.kmToM(Double.valueOf(inputarray[1])));
		break;
		default:
			IO.println("> Invalid input");
			
			String[] cmd = new String[1];
			cmd[0] = "commands";
			parse(cmd);
			waitforin();
		break;
		}
		waitforin();
	}
}
