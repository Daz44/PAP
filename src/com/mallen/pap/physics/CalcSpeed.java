package com.mallen.pap.physics;

import java.text.DecimalFormat;
import java.util.Scanner;

import com.mallen.pap.console.IO;

public class CalcSpeed {
	
	private static double force, heading, ispeed, mass;
	private static double speed, distance, a;
	
	private static int itime, ftime;
	
	public double calculateForce(double fnforce, double rnforce){
		return fnforce-rnforce;
	}
	public static  void printSpeed(){
		
		DecimalFormat df = new DecimalFormat("#.000");
		double a = force/mass;
		distance = 0;
		
		IO.println("==== CALCULATING ACCELERATION FOR " + force + "n at " + mass + "kg, " + a + "====");
		long dtime = System.currentTimeMillis();
		
		IO.print("Cofirm Operation... (y/n) ");
		Scanner s = new Scanner(System.in);
		
		String confirm = s.nextLine();
		IO.logln("<IN> " + confirm);
		
		if(confirm.equals("y")){
		for(int i = itime; i <= ftime; i++){		
					
				speed = a*i+ispeed;
				distance += speed;
				
				
				IO.print("Time: " + (int)i + "s");	
				for(int i2 = 0; i2 < 20-Integer.toString(i).length(); i2++){
					IO.print(" ");
				}
			
				IO.print("| Speed: " + df.format(ispeed+speed) + "m/s");
				for(int i2 = 0; i2 < 50-String.valueOf(df.format(ispeed+speed)).length(); i2++){
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
			IO.println("> Operation Aborted");
		}
	}
	
	public static void set(double s, double f, double m, double t1, double t2){
		distance = 0;
		ispeed = s;
		force = f;
		mass = m;
		itime = (int) t1;
		ftime = (int) t2;
	}
}
