package com.mallen.pap.physics;

import java.text.DecimalFormat;
import java.util.Scanner;

import com.mallen.pap.console.IO;

public class CalcBrake {
	private  double speed, brakerate, distance;
	public  void printBrake(){
		DecimalFormat df = new DecimalFormat("#.000");
		
		IO.println("> Brake Calculation for " + speed + "m/s braking at " + brakerate + " m/s");
		
		IO.print("Cofirm Operation... (y/n) ");
		Scanner s = new Scanner(System.in);
		
		String confirm = s.nextLine();
		IO.logln("<IN> " + confirm);
		
		if(confirm.equals("y")){
			
			long dtime = System.currentTimeMillis();
			final int ispeed = (int) speed;
			
			for(int i = 0; i < ispeed/brakerate  ; i++){		
				speed -= brakerate;
				if(speed < 0){
					speed = 0;
				}
				distance += speed;
				
				IO.print("Time: " + (int)i + "s");	
				for(int i2 = 0; i2 < 20-Integer.toString(i).length(); i2++){
					IO.print(" ");
				}
			
				IO.print("| Speed: " + df.format(speed) + "m/s");
				for(int i2 = 0; i2 < 50-String.valueOf(df.format(speed)).length(); i2++){
					IO.print(" ");
				}
			
				IO.print("| Distance: " + df.format(distance) + "m");
				for(int i2 = 0; i2 < 50-String.valueOf(df.format(distance)).length(); i2++){
					IO.print(" ");
				}
				IO.println("");
			}	
			
				IO.println("> Operation Completed in " + (int)(System.currentTimeMillis() - dtime)/1000 + "s");
			} else {
				IO.println("> Operation Aborted"); // If reply is 'n'
		}
	}
	public  void set(double s, double br){
		speed = s;
		brakerate = br;
	}
}
