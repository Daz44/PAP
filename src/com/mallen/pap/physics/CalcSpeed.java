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
	public static  void printAcceleration(){
		
		DecimalFormat df = new DecimalFormat("#.000");
		double a = force/mass;
		
		IO.println("==== CALCULATING ACCELERATION FOR " + force + "n at " + mass + "kg, " + a + "====");
		long dtime = System.currentTimeMillis();
		
		IO.print("Cofirm Operation... (y/n) ");
		Scanner s = new Scanner(System.in);
		
		String confirm = s.nextLine();
		IO.println("<IN> " + confirm);
		
		if(confirm.equals("y")){
			for(int i = itime; i <= ftime; i++){		
					
				speed = a*i+ispeed; //Initial speed not working with 'distance'
				distance += a*i;
				
				IO.print("Time: " + (int)i + "s");	
				for(int i2 = 0; i2 < 20-Integer.toString(i).length(); i2++){
					IO.print(" ");
				}
			
				IO.print("| Speed: " + df.format(ispeed+speed) + "m/s");
				for(int i2 = 0; i2 < 50-String.valueOf(df.format(ispeed+speed)).length(); i2++){
					IO.print(" ");
				}
			
			
			//DISTANCE BROKEN ATM
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
	public static void setForce(double n){
		force = n;
	}
	public static void setHeading(double n){
		heading = n;
	}
	public static void setSpeed(double n){
		ispeed = n;
	}
	public static void setMass(double n){
		mass = n;
	}
	/**
	 * 
	 * Sets the time of the calcspeed equation,
	 * eg. setTime(60, 120) would calculate between the one and two minute marks but not before or after.
	 * 
	 * 
	 * @param i Value of the initial time 
	 * @param f Value of the final time 
	 */
	public static void setTime(double i, double f){
		itime = (int) i;
		ftime = (int) f;
	}
	
	public CalcSpeed(double speed, double force, double mass, double t1, double t2){
		setSpeed(speed);
		setForce(force);
		setMass(mass);
		setTime(t1, t2);
		printAcceleration();
	}
}
