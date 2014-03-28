package com.mallen.pap.console;

import java.util.Scanner;

import com.mallen.pap.console.IO.commands;
import com.mallen.pap.physics.CalcSpeed;
import com.mallen.pap.physics.Convert;

public class Commands {
	public static void waitandparse(){
		Scanner in = new Scanner(System.in);
		IO.print("> ");
		
		String input = in.nextLine();
		String[] inputarray = input.split(" ");	
		commands parsecommand = commands.empty;
		
		IO.println("<IN> " + input);
		
		if(inputarray[0].equals("exit")){
			System.exit(0);
		}
		
		if(inputarray[0].equals("test")){
			CalcSpeed.setSpeed(0);
			CalcSpeed.setMass(640);
			CalcSpeed.setForce(5000);
			CalcSpeed.setTime(0, 10);
			CalcSpeed.printAcceleration();
		}

		if(inputarray[0].equals("calcspeed")){

				CalcSpeed.setSpeed(Double.parseDouble(inputarray[1]));
				CalcSpeed.setForce(Double.parseDouble(inputarray[2]));
				CalcSpeed.setMass(Double.parseDouble(inputarray[3]));
				CalcSpeed.setTime(Double.parseDouble(inputarray[4]), Double.parseDouble(inputarray[5]));
				CalcSpeed.printAcceleration();

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
