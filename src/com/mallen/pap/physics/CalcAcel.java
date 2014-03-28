package com.mallen.pap.physics;

public class CalcAcel {
	static double mass, force;
	public static void printAcel(){
		System.out.println("Acel: " + (force/mass) + "m/s/s");
	}
	public static void set(double f, double m){
		mass = m;
		force = f;
	}
}
